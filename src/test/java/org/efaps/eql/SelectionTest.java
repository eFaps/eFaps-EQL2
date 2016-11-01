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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * The Class SelectionTest.
 *
 * @author The eFaps Team
 */
public class SelectionTest
    extends AbstractTest
{

    /**
     * Object print.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     */
    @Test(dataProvider = "PrintStmts", description = "select attribute[Name]")
    public void attribute(final String _eqlBase,
                          final IPrintStatement<?> _printStmt)
    {
        _printStmt.getSelection()
                .addSelect(IEqlFactory.eINSTANCE.createSelect()
                        .addElement(IEqlFactory.eINSTANCE.createAttributeSelectElement().setNameC("Name")));
        verifyStatement(_eqlBase + "select attribute[Name]", _printStmt);
    }

    /**
     * Attribute with alias.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "PrintStmts", description = " select attribute[Name] as alias")
    public void attributeWithAlias(final String _eqlBase,
                                   final IPrintStatement<?> _printStmt)
        throws Exception
    {
        _printStmt.getSelection()
            .addSelect(IEqlFactory.eINSTANCE.createSelect()
                .setAliasC("alias")
                .addElement(IEqlFactory.eINSTANCE.createAttributeSelectElement().setNameC("Name")));
        verifyStatement(_eqlBase + "select attribute[Name] as alias", _printStmt);
    }

    /**
     * Ci commands.
     *
     * @param _context context
     * @return iterator with ciform
     */
    @DataProvider(name = "PrintStmts")
    public static Iterator<Object[]> printStmts(final ITestContext _context)
    {
        final List<Object[]> ret = new ArrayList<>();
        ret.add(new Object[] { "print obj 123.345 ",
                        IEqlFactory.eINSTANCE.createObjectPrintStatement().setOidC("123.345")
                            .setSelectionC(IEqlFactory.eINSTANCE.createSelection()) });
        ret.add(new Object[] { "print list (123.345) ",
                        IEqlFactory.eINSTANCE.createListPrintStatement().addOid("123.345")
                            .setSelectionC(IEqlFactory.eINSTANCE.createSelection())});
        return ret.iterator();
    }
}
