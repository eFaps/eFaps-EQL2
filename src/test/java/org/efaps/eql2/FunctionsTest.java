/*
 * Copyright 2003 - 2020 The eFaps Team
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

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class FunctionsTest
    extends AbstractTest
{

    @Test
    public void now()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintObjectStatement().setOidC("123.12")
                        .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                                        .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                                        .addElement(IEql2Factory.eINSTANCE.createFunctionSelectElement()
                                                                        .withFunction(IEql2Factory.eINSTANCE
                                                                                        .createNowFunction()))));
        verifyStatement("print object 123.12 select now()", stmt);
    }

    @Test
    public void nowAdd()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintObjectStatement().setOidC("123.12")
                        .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                                        .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                                        .addElement(IEql2Factory.eINSTANCE.createFunctionSelectElement()
                                                                        .withFunction(IEql2Factory.eINSTANCE
                                                                                        .createNowAddFunction()
                                                                                        .withInterval(Interval.DAY)
                                                                                        .withQuantity(4)))));
        verifyStatement("print object 123.12 select nowAdd(4,day)", stmt);
    }

    @Test
    public void nowAddPositiv()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintObjectStatement().setOidC("123.12")
                        .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                                        .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                                        .addElement(IEql2Factory.eINSTANCE.createFunctionSelectElement()
                                                                        .withFunction(IEql2Factory.eINSTANCE
                                                                                        .createNowAddFunction()
                                                                                        .withInterval(Interval.DAY)
                                                                                        .withQuantity(14)))));
        verifyStatement("print object 123.12 select nowAdd(+14,day)", stmt);
    }

    @Test
    public void nowAddNegative()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintObjectStatement().setOidC("123.12")
                        .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                                        .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                                        .addElement(IEql2Factory.eINSTANCE.createFunctionSelectElement()
                                                                        .withFunction(IEql2Factory.eINSTANCE
                                                                                        .createNowAddFunction()
                                                                                        .withInterval(Interval.DAY)
                                                                                        .withQuantity(-4)))));
        verifyStatement("print object 123.12 select nowAdd(-4,day)", stmt);
    }

    @Test
    public void date()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintObjectStatement().setOidC("123.12")
                        .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                                        .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                                        .addElement(IEql2Factory.eINSTANCE.createFunctionSelectElement()
                                                                        .withFunction(IEql2Factory.eINSTANCE
                                                                                        .createDateFunction()))));
        verifyStatement("print object 123.12 select date()", stmt);
    }

    @Test
    public void dateAdd()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintObjectStatement().setOidC("123.12")
                        .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                                        .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                                        .addElement(IEql2Factory.eINSTANCE.createFunctionSelectElement()
                                                                        .withFunction(IEql2Factory.eINSTANCE
                                                                                        .createDateAddFunction()
                                                                                        .withInterval(Interval.DAY)
                                                                                        .withQuantity(4)))));
        verifyStatement("print object 123.12 select dateAdd(4,day)", stmt);
    }

    @Test
    public void dateAddPositiv()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintObjectStatement().setOidC("123.12")
                        .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                                        .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                                        .addElement(IEql2Factory.eINSTANCE.createFunctionSelectElement()
                                                                        .withFunction(IEql2Factory.eINSTANCE
                                                                                        .createDateAddFunction()
                                                                                        .withInterval(Interval.DAY)
                                                                                        .withQuantity(4)))));
        verifyStatement("print object 123.12 select dateAdd(+4,day)", stmt);
    }

    @Test
    public void dateAddNegative()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintObjectStatement().setOidC("123.12")
                        .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                                        .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                                        .addElement(IEql2Factory.eINSTANCE.createFunctionSelectElement()
                                                                        .withFunction(IEql2Factory.eINSTANCE
                                                                                        .createDateAddFunction()
                                                                                        .withInterval(Interval.MONTH)
                                                                                        .withQuantity(-4)))));
        verifyStatement("print object 123.12 select dateAdd(-4,month)", stmt);
    }

    @Test
    public void queryNow()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintQueryStatement()
                        .query(IEql2Factory.eINSTANCE.createQuery().addType("Sales_Invoice")
                            .where(IEql2Factory.eINSTANCE.createWhere()
                                        .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                                        .element(IEql2Factory.eINSTANCE
                                                    .createWhereElement()
                                                    .attribute("Date")
                                                    .comparison(Comparison.LESS)
                                                    .function(IEql2Factory.eINSTANCE
                                                                    .createNowFunction())))))
                        .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                                        .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                                        .addElement(IEql2Factory.eINSTANCE
                                                                        .createAttributeSelectElement()
                                                                        .setNameC("Date"))));
        final var eql = verifyStatement("print query Sales_Invoice where Date < now() select attribute[Date]", stmt);
        assertEquals(eql, "print  query type Sales_Invoice where   attribute[Date] < now()  select  attribute[Date]");
    }

    @Test
    public void queryNowAdd()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintQueryStatement()
                        .query(IEql2Factory.eINSTANCE.createQuery().addType("Sales_Invoice")
                            .where(IEql2Factory.eINSTANCE.createWhere()
                                        .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                                        .element(IEql2Factory.eINSTANCE
                                                    .createWhereElement()
                                                    .attribute("Date")
                                                    .comparison(Comparison.LESS)
                                                    .function(IEql2Factory.eINSTANCE
                                                                    .createNowAddFunction()
                                                                    .withInterval(Interval.MONTH)
                                                                    .withQuantity(5))))))
                        .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                                        .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                                        .addElement(IEql2Factory.eINSTANCE
                                                                        .createAttributeSelectElement()
                                                                        .setNameC("Date"))));
        final var eql = verifyStatement("print query Sales_Invoice where Date < nowAdd(5,month) select attribute[Date]", stmt);
        assertEquals(eql, "print  query type Sales_Invoice where   attribute[Date] < nowAdd(5, month)  select  attribute[Date]");
    }

}
