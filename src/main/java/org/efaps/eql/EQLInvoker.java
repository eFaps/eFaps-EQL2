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

import org.eclipse.xtext.parser.IParseResult;
import org.efaps.eql.eQL.OneSelect;
import org.efaps.eql.eQL.PrintPart;
import org.efaps.eql.eQL.SelectPart;
import org.efaps.eql.eQL.Statement;
import org.efaps.eql.parser.antlr.EQLParser;
import org.efaps.eql.validation.EQLJavaValidator;

import com.google.inject.Inject;

/**
 * TODO comment!
 *
 * @author The eFaps Team
 * @version $Id: $
 */
public class EQLInvoker
{

    @Inject
    private EQLParser parser;

    @Inject
    private EQLJavaValidator validator;

    /**
     *
     */
    public EQLInvoker()
    {
        EQLStandaloneSetup.doSetup(this);
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

    public ISelectStmt invoke(final String _stmt)
        throws Exception
    {
        ISelectStmt ret = null;
        final IParseResult result = getParser().doParse(_stmt);
        final Statement stmt = (Statement) result.getRootASTElement();
        if (stmt != null) {
            if (stmt.getPrintPart() != null) {
                final PrintPart printPart = stmt.getPrintPart();
                final IPrintStmt print = getIPrint();
                print.setInstance(printPart.getOid());
                ret = print;
            }
            if (stmt.getSelectPart() != null && ret != null) {
                final SelectPart selectPart = stmt.getSelectPart();
                for (final OneSelect sel : selectPart.getSelects()) {
                    ret.addSelect(sel.getSelect(), sel.getAlias());
                }
            }
        }
        return ret;
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

    protected IPrintStmt getIPrint()
    {
        return new NonOpPrint();
    }
}
