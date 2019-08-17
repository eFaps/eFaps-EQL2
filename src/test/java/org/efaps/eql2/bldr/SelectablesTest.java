/*
 * Copyright 2003 - 2019 The eFaps Team
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

package org.efaps.eql2.bldr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.efaps.eql2.AbstractTest;
import org.efaps.eql2.EQL2;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * The Class SelectablesTest.
 */
public class SelectablesTest
    extends AbstractTest
{

    @Test(description = "Test Selectables", dataProvider = "DataProvider")
    public void selectables(final String _stmt,
                            final ISelectable[] _selectables)
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL2.builder()
                        .print("13.46")
                        .select(_selectables);
        verifyStatement(_stmt, bldr.getStmt());
    }

    @DataProvider(name = "DataProvider")
    public static Iterator<Object[]> dataProvider(final ITestContext _context)
    {
        final List<Object[]> ret = new ArrayList<>();
        ret.add(new Object[] { "print obj 13.46 select instance",
                        new ISelectable[] { AbstractSelectables.instance() } });
        ret.add(new Object[] { "print obj 13.46 select attribute[ATTRNAME]",
                        new ISelectable[] { AbstractSelectables.attribute("ATTRNAME") } });
        ret.add(new Object[] { "print obj 13.46 select linkto[LINKTOATTR].attribute[ATTRNAME]",
                        new ISelectable[] { AbstractSelectables.linkto("LINKTOATTR").attribute("ATTRNAME") } });


        ret.add(new Object[] { "print obj 13.46 select instance, "
                            + "attribute[ATTRNAME1], "
                            + "linkto[LINKTOATTR2].attribute[ATTRNAME2]",
                        new ISelectable[] { AbstractSelectables.instance(),
                                        AbstractSelectables.attribute("ATTRNAME1"),
                                        AbstractSelectables.linkto("LINKTOATTR2").attribute("ATTRNAME2") } });
        return ret.iterator();
    }

}
