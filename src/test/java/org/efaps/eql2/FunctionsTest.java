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
                                                                                        .withQuantity(4)))));
        verifyStatement("print object 123.12 select nowAdd(+4,day)", stmt);
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

}
