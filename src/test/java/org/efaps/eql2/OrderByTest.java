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

package org.efaps.eql2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * TODO comment!
 *
 * @author The eFaps Team
 */
public class OrderByTest
    extends AbstractTest
{

    /**
     * One numeric key.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     */
    @Test(dataProvider = "Stmts", description = "NUM")
    public void oneNumericKey(final String _eqlBase,
                              final IOrdered<?> _stmt)
    {
        _stmt.orderBy("2", false);
        verifyStatement(_eqlBase + "order by 2", _stmt);
    }

    /**
     * Two numeric key.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     */
    @Test(dataProvider = "Stmts", description = "NUM, NUM")
    public void twoNumericKey(final String _eqlBase,
                              final IOrdered<?> _stmt)
    {
        _stmt.order(IEql2Factory.eINSTANCE.createOrder().addElement("2", false).addElement("5", false));
        verifyStatement(_eqlBase + "order by 2, 5", _stmt);
    }

    /**
     * Many numeric key.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     */
    @Test(dataProvider = "Stmts", description = "NUM, NUM, NUM")
    public void manyNumericKey(final String _eqlBase,
                               final IOrdered<?> _stmt)
    {
        _stmt.order(IEql2Factory.eINSTANCE.createOrder().addElement("2", false).addElement("4", false)
                        .addElement("7", false));
        verifyStatement(_eqlBase + "order by 2, 4, 7", _stmt);
    }

    /**
     * One numeric key asc.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     */
    @Test(dataProvider = "Stmts", description = "NUM asc")
    public void oneNumericKeyAsc(final String _eqlBase,
                                 final IOrdered<?> _stmt)
    {
        _stmt.order(IEql2Factory.eINSTANCE.createOrder().addElement("2", false));
        verifyStatement(_eqlBase + "order by 2 asc", _stmt);
    }

    /**
     * One numeric key desc.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     */
    @Test(dataProvider = "Stmts", description = "NUM desc")
    public void oneNumericKeyDesc(final String _eqlBase,
                                  final IOrdered<?> _stmt)
    {
        _stmt.order(IEql2Factory.eINSTANCE.createOrder().addElement("2", true));
        verifyStatement(_eqlBase + "order by 2 desc", _stmt);
    }

    /**
     * One alphanumeric key.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     */
    @Test(dataProvider = "Stmts", description = "STR")
    public void oneAlphanumericKey(final String _eqlBase,
                                   final IOrdered<?> _stmt)
    {
        _stmt.order(IEql2Factory.eINSTANCE.createOrder().addElement("demo", false));
        verifyStatement(_eqlBase + "order by demo", _stmt);
    }

    /**
     * Two alphanumeric key.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     */
    @Test(dataProvider = "Stmts", description = "STR, STR")
    public void twoAlphanumericKey(final String _eqlBase,
                                   final IOrdered<?> _stmt)
    {
        _stmt.order(IEql2Factory.eINSTANCE.createOrder().addElement("demo", false).addElement("second", false));
        verifyStatement(_eqlBase + "order by demo, second", _stmt);
    }

    /**
     * Mixed alphanumeric key.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     */
    @Test(dataProvider = "Stmts", description = "STR desc, STR")
    public void mixedAlphanumericKey(final String _eqlBase,
                                     final IOrdered<?> _stmt)
    {
        _stmt.order(IEql2Factory.eINSTANCE.createOrder().addElement("demo", true).addElement("second", false));
        verifyStatement(_eqlBase + "order by demo desc, second", _stmt);
    }

    /**
     * Ci commands.
     *
     * @param _context context
     * @return iterator with ciform
     */
    @DataProvider(name = "Stmts")
    public static Iterator<Object[]> stmts(final ITestContext _context)
    {
        final List<Object[]> ret = new ArrayList<>();
        ret.add(new Object[] { "print query type EFaps_Type select attribute[Name] ",
                        IEql2Factory.eINSTANCE.createPrintQueryStatement()
                            .query(IEql2Factory.eINSTANCE.createQuery().addType("EFaps_Type"))
                                .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                                    .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                        .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement()
                                    .setNameC("Name")))) });

        ret.add(new Object[] { "exec org.efaps.demo.Test select 1 as Key, 5 as Demo, 8 as etwas ",
                        IEql2Factory.eINSTANCE.createExecStatement().className("org.efaps.demo.Test")
                            .addSelection(IEql2Factory.eINSTANCE.createExecSelectionElement()
                                        .index("1").alias("Key"))
                            .addSelection(IEql2Factory.eINSTANCE.createExecSelectionElement()
                                        .index("5").alias("Demo"))
                            .addSelection(IEql2Factory.eINSTANCE.createExecSelectionElement()
                                            .index("8").alias("etwas"))  });
        return ret.iterator();
    }
}
