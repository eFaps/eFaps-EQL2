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
 * Revision:        $Rev$
 * Last Changed:    $Date$
 * Last Changed By: $Author$
 */


package org.efaps.eql;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.validation.AbstractInjectableValidator;
import org.efaps.eql.eQL.Statement;
import org.efaps.eql.parser.antlr.EQLParser;
import org.efaps.eql.validation.EQLJavaValidator;
import org.testng.annotations.BeforeClass;

import com.google.inject.Inject;
import com.google.inject.Injector;


/**
 * TODO comment!
 *
 * @author The eFaps Team
 * @version $Id: $
 */
public abstract class AbstractTest
{
    @Inject
    private EQLParser parser;

    @Inject
    private EQLJavaValidator validator;

    private BasicDiagnostic diagnostic;

    @BeforeClass
    public void setupParser() {
        final Injector injector = new EQLStandaloneSetup()
                .createInjectorAndDoEMFRegistration();
        injector.injectMembers(this);
    }

    protected final Statement getStatement(final CharSequence _stmt)
    {
        final IParseResult result = getParser().doParse(_stmt);
        final Statement ret = (Statement) result.getRootASTElement();

        setDiagnostic(new BasicDiagnostic());
        final Map<Object, Object> context = new HashMap<>();
        context.put(AbstractInjectableValidator.CURRENT_LANGUAGE_NAME, "org.efaps.eql.EQL");
        this.validator.validate(ret, getDiagnostic(), context);
        final TreeIterator<EObject> iterator = ret.eAllContents();
        while (iterator.hasNext()) {
            this.validator.validate(iterator.next(), getDiagnostic(), context);
        }
        return ret;
    }

    /**
     * Getter method for the instance variable {@link #parser}.
     *
     * @return value of instance variable {@link #parser}
     */
    public EQLParser getParser()
    {
        return this.parser;
    }


    /**
     * Getter method for the instance variable {@link #validator}.
     *
     * @return value of instance variable {@link #validator}
     */
    public EQLJavaValidator getValidator()
    {
        return this.validator;
    }


    /**
     * Getter method for the instance variable {@link #diagnostic}.
     *
     * @return value of instance variable {@link #diagnostic}
     */
    public BasicDiagnostic getDiagnostic()
    {
        return this.diagnostic;
    }


    /**
     * Setter method for instance variable {@link #diagnostic}.
     *
     * @param _diagnostic value for instance variable {@link #diagnostic}
     */
    public void setDiagnostic(final BasicDiagnostic _diagnostic)
    {
        this.diagnostic = _diagnostic;
    }
}
