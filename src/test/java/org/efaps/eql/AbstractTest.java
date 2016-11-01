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
package org.efaps.eql;

import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.Token;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.efaps.eql.parser.antlr.EQLParser;
import org.testng.Assert;

import com.google.inject.Inject;

/**
 * The Class AbstractTest.
 *
 * @author The eFaps Team
 */
public abstract class AbstractTest
{

    /** The parser. */
    @Inject
    private EQLParser parser;

    /** The lexer. */
    @Inject
    private Lexer lexer;

    /** The token def provider. */
    @Inject
    private ITokenDefProvider tokenDefProvider;

    /**
     * Instantiates a new abstract test.
     */
    public AbstractTest()
    {
        EQLStandaloneSetup.doSetup(this);
    }

    /**
     * Gets the parser.
     *
     * @return the parser
     */
    public EQLParser getParser()
    {
        return this.parser;
    }

    /**
     * Verify statement.
     *
     * @param _eqlStmt the eql stmt
     * @param _object the object
     */
    public void verifyStatement(final String _eqlStmt,
                                final IEQLElement _object)
    {
        final IParseResult result = getParser().doParse(_eqlStmt);
        if (result.hasSyntaxErrors()) {
            for (final INode error : result.getSyntaxErrors()) {
                System.out.println(error.getSyntaxErrorMessage());
            }
        }
        final IEQLElement eObject = (IEQLElement) result.getRootASTElement();
        if (eObject == null) {
            debugTokens(getTokens(_eqlStmt));
        }
        Assert.assertEquals(eObject.eqlStmt(), _object.eqlStmt());
    }

    /**
     * Gets the tokens.
     *
     * @param _input the input
     * @return the tokens
     */
    public List<Token> getTokens(final CharSequence _input)
    {
        final CharStream stream = new ANTLRStringStream(_input.toString());
        this.lexer.setCharStream(stream);
        final XtextTokenStream tokenStream = new XtextTokenStream(this.lexer, this.tokenDefProvider);
        @SuppressWarnings("unchecked")
        final List<Token> tokens = tokenStream.getTokens();
        return tokens;
    }

    /**
     * Debug tokens.
     *
     * @param _tokens the tokens
     */
    public void debugTokens(final List<Token> _tokens)
    {
        for (int i = 0; i < _tokens.size(); i++) {
            final Token token = _tokens.get(i);
            System.out.println("Token type=" + getTokenType(token) + " text=" + token.getText());
        }
    }

    /**
     * Gets the token type.
     *
     * @param _token the token
     * @return the token type
     */
    public String getTokenType(final Token _token)
    {
        return this.tokenDefProvider.getTokenDefMap().get(_token.getType());
    }

}
