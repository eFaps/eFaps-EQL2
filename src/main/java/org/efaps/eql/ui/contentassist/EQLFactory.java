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

import java.util.Collection;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Token;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory.StatefulFactory;
import org.eclipse.xtext.util.Strings;

/**
 * A factory for creating EQL objects.
 */
@SuppressWarnings("checkstyle:abstractclassname")
public class EQLFactory
    extends StatefulFactory
{

    @Override
    protected void initializeAndAdjustCompletionOffset(final int _offset)
    {
        this.selection = new EQLTextSelection(this.parseResult.getRootNode().getText(), _offset);
        this.completionOffset = _offset;
        if (this.selection.getOffset() + this.selection.getLength() == _offset) {
            this.completionOffset = this.selection.getOffset();
        }
    }

    @Override
    public String getNodeTextUpToCompletionOffset(final INode _currentNode)
    {
        final int startOffset = _currentNode.getOffset();
        final int length = this.completionOffset - startOffset;
        final String nodeText = ((ILeafNode) _currentNode).getText();
        final String trimmedNodeText = length > nodeText.length() ? nodeText : nodeText.substring(0, length);
        return trimmedNodeText;
    }

    @Override
    @SuppressWarnings("checkstyle:returncount")
    protected void createContextsForLastCompleteNode(final EObject _previousModel,
                                                     final boolean _strict)
        throws BadLocationException
    {
        final String currentNodePrefix = getPrefix(this.currentNode);
        if (!Strings.isEmpty(currentNodePrefix) && !this.currentNode.getText().equals(currentNodePrefix)) {
            this.lexer.setCharStream(new ANTLRStringStream(currentNodePrefix));
            Token token = this.lexer.nextToken();
            if (token == Token.EOF_TOKEN) { // error case - nothing
                                            // could be parsed
                return;
            }
            while (token != Token.EOF_TOKEN) {
                if (isErrorToken(token)) {
                    return;
                }
                token = this.lexer.nextToken();
            }
        }
        final String prefix = "";
        final String completeInput = this.selection.getText().substring(0, this.completionOffset);
        final Collection<FollowElement> followElements = this.parser.getFollowElements(completeInput, _strict);
        doCreateContexts(this.lastCompleteNode, this.currentNode, prefix, _previousModel, followElements);
    }

    @Override
    protected void handleLastCompleteNodeIsAtEndOfDatatypeNode()
        throws BadLocationException
    {
        final String prefix = getPrefix(this.lastCompleteNode);
        final String completeInput = this.selection.getText().substring(0, this.lastCompleteNode.getOffset());
        final INode previousNode = getLastCompleteNodeByOffset(this.rootNode, this.lastCompleteNode.getOffset());
        final EObject previousModel = previousNode.getSemanticElement();
        final INode currentDatatypeNode = getContainingDatatypeRuleNode(this.currentNode);
        final Collection<FollowElement> followElements = this.parser.getFollowElements(completeInput, false);
        final int prevSize = this.contextBuilders.size();
        doCreateContexts(previousNode, currentDatatypeNode, prefix, previousModel, followElements);

        if (this.lastCompleteNode instanceof ILeafNode && this.lastCompleteNode.getGrammarElement() == null
                        && this.contextBuilders.size() != prevSize) {
            handleLastCompleteNodeHasNoGrammarElement(this.contextBuilders.subList(prevSize, this.contextBuilders
                            .size()), previousModel);
        }
    }
}
