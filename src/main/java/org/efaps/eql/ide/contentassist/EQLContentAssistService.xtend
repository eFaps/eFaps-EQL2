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
package org.efaps.eql.ide.contentassist

import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory
import com.google.inject.Provider
import com.google.inject.Inject
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.ITextRegion
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import java.util.concurrent.Executors
import java.util.List
import java.util.HashSet
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor
import java.util.Arrays
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry

/**
 * The Class EQLContentAssistService.
 *
 * @author The eFaps Team
 */
class EQLContentAssistService
{
    @Inject
    Provider<ContentAssistContextFactory> contextFactoryProvider

    @Inject
    IdeContentProposalProvider proposalProvider

    def createProposals(XtextResource resource, String text, ITextRegion selection, int caretOffset, int limit)
    {
        val contexts = getContexts(resource, text, selection, caretOffset)
        return createProposals(Arrays.asList(contexts), limit)
    }

    def private ContentAssistContext[] getContexts(XtextResource resource, String text, ITextRegion selection,
        int caretOffset)
    {
        if (caretOffset > text.length)
            return #[]
        val contextFactory = contextFactoryProvider.get() => [pool = Executors.newCachedThreadPool]
        contextFactory.create(text, selection, caretOffset, resource)
    }

    def private createProposals(List<ContentAssistContext> contexts, int proposalsLimit)
    {
        val result = newArrayList
        if (!contexts.empty)
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
                    proposals.size < proposalsLimit
                }
            }

            proposalProvider.createProposals(contexts, acceptor)

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
