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

import org.testng.annotations.Test;

public class CountTest
    extends AbstractTest
{

    @Test(description = "count query type EFaps_Type")
    public void query1()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createCountQueryStatement()
                        .setQueryC(IEql2Factory.eINSTANCE.createQuery().addType("EFaps_Type"));
        verifyStatement("count query type EFaps_Type", stmt);
    }

    @Test(description = "count query type Type1, Type2")
    public void query2()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createCountQueryStatement()
                        .setQueryC(IEql2Factory.eINSTANCE.createQuery().addType("Type1").addType("Type2"));
        verifyStatement("count query type Type1, Type2", stmt);
    }

    @Test(description = "count query type Type1, Type2 where ID > 100")
    public void query3()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createCountQueryStatement()
                        .setQueryC(IEql2Factory.eINSTANCE.createQuery().addType("Type1").addType("Type2")
                                        .setWhereC(IEql2Factory.eINSTANCE.createWhere()
                                                        .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                                                                        .element(IEql2Factory.eINSTANCE
                                                                                        .createWhereElement()
                                                                                        .attribute("ID")
                                                                                        .comparison(Comparison.GREATER)
                                                                                        .addValue("100")))));
        verifyStatement("count  query type Type1, Type2 where   attribute[ID] > 100", stmt);
    }
}
