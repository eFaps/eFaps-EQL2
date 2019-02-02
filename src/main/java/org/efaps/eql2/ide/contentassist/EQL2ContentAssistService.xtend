/*
 * Copyright 2003 - 2016 The eFaps Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.efaps.eql2.ide.contentassist

import com.google.inject.Inject
import com.google.inject.Provider
import java.util.Arrays
import java.util.HashSet
import java.util.List
import java.util.concurrent.Executors
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.ITextRegion

/**
 * The Class EQLContentAssistService.
 *
 * @author The eFaps Team
 */
class EQL2ContentAssistService
{
    @Inject
    Provider<ContentAssistContextFactory> contextFactoryProvider

    @Inject
    EQL2ProposalProvider proposalProvider

    def createProposals(XtextResource _resource, String _text, ITextRegion _selection, int _caretOffset, int _limit)
    {
        val contexts = getContexts(_resource, _text, _selection, _caretOffset)
        return createProposals(Arrays.asList(contexts), _limit)
    }

    def private ContentAssistContext[] getContexts(XtextResource _resource, String _text, ITextRegion _selection,
        int _caretOffset)
    {
        if (_caretOffset > _text.length)
            return #[]
        val contextFactory = contextFactoryProvider.get() => [pool = Executors.newCachedThreadPool]
        contextFactory.create(_text, _selection, _caretOffset, _resource)
    }

    def private createProposals(List<ContentAssistContext> _contexts, int _proposalsLimit)
    {
        val result = newArrayList
        if (!_contexts.empty)
        {
            val proposals = new HashSet<Pair<Integer, ContentAssistEntry>>
            val acceptor = new IIdeContentProposalAcceptor
            {
                override accept(ContentAssistEntry entry, int priority)
                {
                    if (entry.proposal === null)
                        throw new IllegalArgumentException('proposal must not be null.')
                    proposals.add(priority -> entry)
                }

                override canAcceptMoreProposals()
                {
                    proposals.size < _proposalsLimit
                }
            }

            proposalProvider.createProposals(_contexts, acceptor)

            result.addAll(proposals.sortWith [ p1, p2 |
                val prioResult = p2.key.compareTo(p1.key)
                if (prioResult != 0)
                    return prioResult
                val s1 = p1.value.label ?: p1.value.proposal
                val s2 = p2.value.label ?: p2.value.proposal
                return s1.compareTo(s2)
            ].map[value])
        }
        return result
    }
}
