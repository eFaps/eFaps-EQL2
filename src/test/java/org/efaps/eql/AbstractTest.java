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

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.eclipse.emf.ecore.EObject;
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
                                final Object _object)
    {
        final EObject eObject = getParser().doParse(_eqlStmt).getRootASTElement();
        Assert.assertTrue(EqualsBuilder.reflectionEquals(_object, eObject,
                        "eContainer", "eFlags", "eStorage"));
    }
}
