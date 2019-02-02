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

import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider

/**
 * The Class EQLProposalProvider.
 *
 * @author The eFaps Team
 */
class EQL2ProposalProvider
    extends IdeContentProposalProvider
{
    override dispatch createProposals(RuleCall _ruleCall,
        ContentAssistContext _context,
        IIdeContentProposalAcceptor _acceptor)
    {
        println(_ruleCall.rule.name)
        switch (_ruleCall.rule.name)
        {
            case "OID":
            {
                val entry = proposalCreator.createProposal("132.456", _context);
                val priority = proposalPriorities.getKeywordPriority("132.456", entry);
                _acceptor.accept(entry, priority)
            }
            case "Type":
            {
                val prefix = _context.getPrefix();
                if (prefix.isEmpty())
                {
                    var entry = proposalCreator.createProposal("CITYPE", _context);
                    val priority = proposalPriorities.getKeywordPriority("CITYPE", entry);
                    _acceptor.accept(entry, priority)
                }
                else
                {
                    for (provider : EQL2Proposals.getCINameProviders())
                    {
                        for (type : provider.getTypeNames())
                        {
                            if (type.startsWith(prefix))
                            {
                                var entry = proposalCreator.createProposal(type, _context);
                                val priority = proposalPriorities.getKeywordPriority(type, entry);
                                _acceptor.accept(entry, priority)
                            }
                        }
                    }
                }
            }
            default:
            {
            }
        }
    }
}
