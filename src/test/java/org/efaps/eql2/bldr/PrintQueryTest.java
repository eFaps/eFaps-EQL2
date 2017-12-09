/*
 * Copyright 2003 - 2017 The eFaps Team
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

import static org.efaps.eql2.EQL.print;
import static org.efaps.eql2.EQL.query;
import static org.efaps.eql2.EQL.where;

import org.efaps.eql2.AbstractTest;
import org.testng.annotations.Test;
/**
 * The Class PrintQueryTest.
 */
public class PrintQueryTest
    extends AbstractTest
{
    @Test(description = "print query ")
    public void printQuery()
    {
        final AbstractPrintEQLBuilder<?> bldr = print(query("Sales_Document"))
                        .attribute("Attri");
        final String smt = "print query type Sales_Document select attribute[Attri]";
        verifyStatement(smt, bldr.getStmt());
    }

    @Test(description = "print query types")
    public void printQueryTypes()
    {
        final AbstractPrintEQLBuilder<?> bldr = print(query("Sales_Document", "Sales_Invoice"))
                        .attribute("Attri");
        final String smt = "print query type Sales_Document, Sales_Invoice select attribute[Attri]";
        verifyStatement(smt, bldr.getStmt());
    }

    @Test(description = "print query TYPE where ATTRIBUTE eq NUMBER")
    public void printQueryWhere()
    {
        final AbstractPrintEQLBuilder<?> bldr = print(query("Sales_Document")
                            .where(where().attribute("Attri").eq(12)))
                        .attribute("Attri");
        final String smt = "print query type Sales_Document where attribute[Attri] == 12 select attribute[Attri]";
        verifyStatement(smt, bldr.getStmt());
    }
}
