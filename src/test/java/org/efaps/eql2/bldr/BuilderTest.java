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
package org.efaps.eql2.bldr;

import org.efaps.eql2.AbstractTest;
import org.efaps.eql2.EQL;
import org.testng.annotations.Test;

/**
 * The Class bldrTest.
 *
 * @author The eFaps Team
 */
public class BuilderTest
    extends AbstractTest
{
    //future id
    // (print query type Sales_Document select type.label as type ==> ( if (type == invoice ) {  update obj 123.456 set attr=\"\blau" } else {")
    /**
     * Prints the query limit.
     */
   // @Test(description = "print query limit")
    public void printQueryLimit()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print()
                        //    .limit(10)
                        .attribute("Attri");
        final String smt = "print query type Sales_Document limit 10 select attribute[Attri]";
        verifyStatement(smt, bldr.getStmt());
    }
//
//    /**
//     * Prints the.
//     */
//    @Test(description = "print query ")
//    public void printWhereEq()
//    {
//        final AbstractPrintEQLBuilder<?> bldr = EQL
//                        .print()
//                            .query("Sales_Document")
//                            .where()
//                                .attr("Name").eq("demo")
//
//                                .attribute("Attri");
//        final String smt = "print query type Sales_Document where Name eq \"demo\" select attribute[Attri]";
//        verifyStatement(smt, bldr.getStmt());
//    }
//
//    /**
//     * Prints the.
//     */
//    @Test(description = "print query ")
//    public void printWhereEqValues()
//    {
//        final AbstractPrintEQLBuilder<?> bldr = EQL
//                        .print()
//                            .query("Sales_Document")
//                            .where()
//                                .attr("Name").in("demo", "test")
//
//                                .attribute("Attri");
//        final String smt = "print query type Sales_Document where Name in (\"demo\", \"test\") select attribute[Attri]";
//        verifyStatement(smt, bldr.getStmt());
//    }
//
//    /**
//     * Prints the where eq and eq.
//     */
//    @Test(description = "print query eq and eq")
//    public void printWhereEqAndEq()
//    {
//        final AbstractPrintEQLBuilder<?> bldr = EQL
//                        .print()
//                            .query("Sales_Document")
//                            .where()
//                                .attr("Name").eq("demo")
//                                .and()
//                                .attr("Attr2").eq("5")
//
//                                .attribute("Attri");
//        final String smt = "print query type Sales_Document where Name eq \"demo\" and Attr2 == 5 "
//                        + "select attribute[Attri]";
//        verifyStatement(smt, bldr.getStmt());
//    }
//
//    /**
//     * Prints the where eq and eq.
//     */
//    @Test(description = "print query eq and eq or eq")
//    public void printWhereEqAndEqOrEq()
//    {
//        final AbstractPrintEQLBuilder<?> bldr = EQL
//                        .print()
//                            .query("Sales_Document")
//                            .where()
//                                .attr("Name").eq("demo")
//                                .and()
//                                .attr("Attr2").eq("5")
//                                .or()
//                                .attr("Attr3").eq("7")
//
//                                .attribute("Attri");
//        final String smt = "print query type Sales_Document where Name eq \"demo\" and Attr2 == 5 "
//                        + "or Attr3 == 7 select attribute[Attri]";
//        verifyStatement(smt, bldr.getStmt());
//    }
//
//
//    /**
//     * Prints the.
//     */
//    @Test(description = "print query where less")
//    public void printWhereLess()
//    {
//        final AbstractPrintEQLBuilder<?> bldr = EQL
//                        .print()
//                            .query("Sales_Document")
//                            .where()
//                                .attr("Name").less("demo")
//
//                                .attribute("Attri");
//        final String smt = "print query type Sales_Document where Name < \"demo\" select attribute[Attri]";
//        verifyStatement(smt, bldr.getStmt());
//    }
//
//    /**
//     * Prints the.
//     */
//    @Test(description = "print query where greater")
//    public void printWhereGreater()
//    {
//        final AbstractPrintEQLBuilder<?> bldr = EQL
//                        .print()
//                            .query("Sales_Document")
//                            .where()
//                                .attr("Name").greater("demo")
//
//                                .attribute("Attri");
//        final String smt = "print query type Sales_Document where Name > \"demo\" select attribute[Attri]";
//        verifyStatement(smt, bldr.getStmt());
//    }
//
//    /**
//     * Prints the.
//     */
//    @Test(description = "print query where match")
//    public void printWhereMatch()
//    {
//        final AbstractPrintEQLBuilder<?> bldr = EQL
//                        .print()
//                            .query("Sales_Document")
//                            .where()
//                                .attr("Name").like("demo")
//
//                                .attribute("Attri");
//        final String smt = "print query type Sales_Document where Name like \"demo\" select attribute[Attri]";
//        verifyStatement(smt, bldr.getStmt());
//    }
//
//    /**
//     * Prints the.
//     */
//    @Test(description = "print query where not")
//    public void printWhereNot()
//    {
//        final AbstractPrintEQLBuilder<?> bldr = EQL
//                        .print()
//                            .query("Sales_Document")
//                            .where()
//                                .attr("Name").uneq("demo")
//
//                                .attribute("Attri");
//        final String smt = "print query type Sales_Document where Name != \"demo\" select attribute[Attri]";
//        verifyStatement(smt, bldr.getStmt());
//    }
//
//    /**
//     * Prints the.
//     */
//    @Test(description = "print query where nots")
//    public void printWhereNots()
//    {
//        final AbstractPrintEQLBuilder<?> bldr = EQL
//                        .print()
//                            .query("Sales_Document")
//                            .where()
//                                .attr("Name").notin("demo", "test")
//
//                                .attribute("Attri");
//        final String smt = "print query type Sales_Document where Name not in ( \"demo\", \"test\") "
//                        + "select attribute[Attri]";
//        verifyStatement(smt, bldr.getStmt());
//    }

    /**
     * Prints the.
     */
    @Test(description = "basic update")
    public void update()
    {
        final AbstractEQLBuilder<?> bldr = EQL.update("123.456")
                            .set("Name", "123");
        final String smt = "update obj 123.456 set Name = 123";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "basic update")
    public void updateVarious()
    {
        final AbstractEQLBuilder<?> bldr = EQL.update("123.456")
                            .set("Name", "123")
                            .set("Attr2", "demo");
        final String smt = "update obj 123.456 set Name = 123, Attr2 = \"demo\"";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "basic update")
    public void updateList()
    {
        final AbstractEQLBuilder<?> bldr = EQL.update("123.456", "789.012")
                            .set("Name", "123");
        final String smt = "update list ( 123.456, 789.012 ) set Name = 123";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    //@Test(description = "query update")
    public void updateQuery()
    {
        final AbstractEQLBuilder<?> bldr = EQL.update()
                            //.query("Sales_Invoice")
                            .set("Name", "123");
        final String smt = "update query type Sales_Invoice set Name = 123";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    //@Test(description = "query update where")
    public void updateQueryWhere()
    {
        final AbstractEQLBuilder<?> bldr = EQL.update()
                            //.query("Sales_Invoice")
                            //.where()
                           //     .attr("Name").eq("demo")
                            .set("Name", "123");
        final String smt = "update query type Sales_Invoice where Name = \"demo\"set Name = 123";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    //@Test(description = "query update where")
    public void updateQueryWhereSets()
    {
        final AbstractEQLBuilder<?> bldr = EQL.update()
                            //.query("Sales_Invoice")
                           // .where()
                           //     .attr("Name").eq("demo")
                            .set("Name", "123")
                            .set("Attr2", "Value2");
        final String smt = "update query type Sales_Invoice where Name = \"demo\"set Name = 123, Attr2 = \"Value2\"";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "basic insert")
    public void insert()
    {
        final AbstractEQLBuilder<?> bldr = EQL.insert("Sales_Invoice")
                            .set("Name", "123");
        final String smt = "insert type Sales_Invoice set Name = 123";
        verifyStatement(smt, bldr.getStmt());
    }
}
