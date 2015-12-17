/*
 * Copyright 2003 - 2015 The eFaps Team
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
package org.efaps.eql.ui.contentassist;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.contentassist.CompletionProposalComputer;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ITemplateAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.ITemplateProposalProvider;
import org.eclipse.xtext.ui.editor.contentassist.XtextContentAssistProcessor;
import org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory;
import org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory.StatefulFactory;
import org.eclipse.xtext.util.StringInputStream;
import org.efaps.eql.EQLStandaloneSetup;

import com.google.inject.Provider;

/**
 * The Class EQLProposals.
 *
 * @author The eFaps Team
 */
public final class EQLProposals
{

    /**
     * Instantiates a new EQL proposals.
     */
    private EQLProposals()
    {

    }
    /**
     * Gets the proposal list.
     *
     * @param _text the text
     * @return the proposal list
     */
    public static List<String> getProposalList(final String _text)
    {
        final List<String> ret = new ArrayList<>();
        try {

            final EQLProposalProvider provider = new EQLProposalProvider();
            EQLStandaloneSetup.doSetup(provider);

            final XtextContentAssistProcessor prov = new XtextContentAssistProcessor();
            EQLStandaloneSetup.doSetup(prov);

            final ParserBasedContentAssistContextFactory conte = new ParserBasedContentAssistContextFactory();
            final EQLFactory ac = new EQLFactory();
            EQLStandaloneSetup.doSetup(ac);
            conte.setStatefulFactoryProvider(new Provider<StatefulFactory>()
            {

                @Override
                public StatefulFactory get()
                {
                    return ac;
                }
            });
            prov.setContextFactory(conte);

            final XtextResource resource = new XtextResource();
            EQLStandaloneSetup.doSetup(resource);

            resource.load(new StringInputStream(_text), null);

            prov.setTemplateProposalProvider(new ITemplateProposalProvider()
            {
                @Override
                public void createTemplates(final ContentAssistContext _context,
                                            final ITemplateAcceptor _acceptor)
                {
                }
            });

            final CompletionProposalComputer comp = new CompletionProposalComputer(prov, null, _text.length());
            final ICompletionProposal[] prep = comp.exec(resource);
            for (int i = 0; i < prep.length; i++) {
                ret.add(prep[i].getDisplayString());
            }

        } catch (final Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ret;
    }

}
