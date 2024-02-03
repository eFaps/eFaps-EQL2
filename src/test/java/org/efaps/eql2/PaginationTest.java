/*
 * Copyright © 2003 - 2024 The eFaps Team (-)
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
 */
package org.efaps.eql2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PaginationTest
    extends AbstractTest
{

    @Test(dataProvider = "Stmts", description = "limit only")
    public void onlyLimit(final String _eqlBase,
                          final IPageable<?> _stmt)
    {
        _stmt.limit( IEql2Factory.eINSTANCE.createLimit().value("2"));
        verifyStatement(String.format(_eqlBase, "limit 2"), _stmt);
    }


    @Test(dataProvider = "Stmts", description = "offset only")
    public void onlyOffset(final String _eqlBase,
                           final IPageable<?> _stmt)
    {
        _stmt.offset( IEql2Factory.eINSTANCE.createOffset().value("100"));
        verifyStatement(String.format(_eqlBase, "offset 100"), _stmt);
    }

    @Test(dataProvider = "Stmts", description = "limit and offset")
    public void limitAndffset(final String _eqlBase,
                           final IPageable<?> _stmt)
    {
        _stmt.limit( IEql2Factory.eINSTANCE.createLimit().value("10"));
        _stmt.offset( IEql2Factory.eINSTANCE.createOffset().value("50"));
        verifyStatement(String.format(_eqlBase, "limit 10 offset 50"), _stmt);
    }

    @Test(dataProvider = "Stmts", description = "limit and offset")
    public void offsetAndLimit(final String _eqlBase,
                           final IPageable<?> _stmt)
    {
        _stmt.limit( IEql2Factory.eINSTANCE.createLimit().value("10"));
        _stmt.offset( IEql2Factory.eINSTANCE.createOffset().value("50"));
        verifyStatement(String.format(_eqlBase, "offset 50 limit 10"), _stmt);
    }

    @DataProvider(name = "Stmts")
    public static Iterator<Object[]> stmts(final ITestContext _context)
    {
        final List<Object[]> ret = new ArrayList<>();
        ret.add(new Object[] { "print query type EFaps_Type %s select attribute[Name] ",
                        IEql2Factory.eINSTANCE.createPrintQueryStatement()
                            .query(IEql2Factory.eINSTANCE.createQuery().addType("EFaps_Type"))
                                .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                                    .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                        .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement()
                                    .setNameC("Name")))) });
        ret.add(new Object[] { "print query type EFaps_Type %s select attribute[Name] order by 1",
                        IEql2Factory.eINSTANCE.createPrintQueryStatement()
                            .query(IEql2Factory.eINSTANCE.createQuery().addType("EFaps_Type"))
                                .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                                    .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                        .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement()
                                    .setNameC("Name"))))
                                .orderBy("1", false)});
        return ret.iterator();
    }
}
