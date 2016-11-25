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
package org.efaps.eql.bldr;

import org.efaps.eql.AbstractTest;
import org.efaps.eql.EQL;
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
     * Prints the.
     */
    @Test(description = "Select one attribute")
    public void printSelAttr()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL.print("13.46").select()
                          .attribute("attr");
        final String smt = "print obj 13.46 select attribute[attr]";
        verifyStatement(smt, bldr.getStmt());
    }


    /**
     * Prints the.
     */
    @Test(description = "Select more attribute")
    public void printSelAttrAttr()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                            .select()
                                .attribute("attr")
                            .select()
                                .attribute("attr2");
        final String smt = "print obj 13.46 select attribute[attr], attribute[attr2]";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "Select more attribute Alias")
    public void printSelAttrAttrAlias()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                            .select()
                                .attribute("attr")
                                .as("Alias1")
                            .select()
                                .attribute("attr2")
                                .as("Alias2");
        final String smt = "print obj 13.46 select attribute[attr] as Alias1, attribute[attr2] as Alias2";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "Select more attribute")
    public void printSelLinko()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                            .select()
                                .linkto("attr1")
                                .attribute("attr");
        final String smt = "print obj 13.46 select linkto[attr1].attribute[attr]";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "Select more attribute")
    public void printSelLinko2()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                            .select()
                                .linkto("attr1")
                                .attribute("attr")
                            .select()
                                .attribute("attr2");
        final String smt = "print obj 13.46 select linkto[attr1].attribute[attr], attribute[attr2]";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "instance")
    public void printSelInstance()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                            .select()
                                .instance();
        final String smt = "print obj 13.46 select instance";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "linkto instance")
    public void printSelLinkoInstance()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                            .select()
                                .linkto("attr1")
                                .instance();
        final String smt = "print obj 13.46 select linkto[attr1].instance";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "linkfrom instance")
    public void printSelLinkFrom()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                            .select()
                                .linkfrom("Type_name", "Attr").instance();
        final String smt = "print obj 13.46 select linkfrom[Type_name#Attr].instance";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "linkfrom attribute")
    public void printSelLinkFromAttr()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                            .select()
                                .linkfrom("Type_name", "Attr").attribute("Attr");
        final String smt = "print obj 13.46 select linkfrom[Type_name#Attr].attribute[Attr]";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "linkfrom linkto attribute")
    public void printSelLinkFromLinktoAttr()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                            .select()
                                .linkfrom("Type_name", "Attr").linkto("LinktoAttr") .attribute("Attr");
        final String smt = "print obj 13.46 select linkfrom[Type_name#Attr].linkto[LinktoAttr].attribute[Attr]";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "oid")
    public void printSelOID()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                            .select().oid();
        final String smt = "print obj 13.46 select oid";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "type")
    public void printSelType()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                            .select().type();
        final String smt = "print obj 13.46 select type";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "value")
    public void printSelValue()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                            .select().attribute("Attr").value();
        final String smt = "print obj 13.46 select attribute[Attr].value";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "label")
    public void printSelLabel()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                            .select().type().label();
        final String smt = "print obj 13.46 select type.label";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "id")
    public void printSelID()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                            .select().id();
        final String smt = "print obj 13.46 select id";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "name")
    public void printSelName()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                            .select().file().name();
        final String smt = "print obj 13.46 select file.name";
        verifyStatement(smt, bldr.getStmt());
    }
    /**
     * Prints the.
     */
    @Test(description = "key")
    public void printSelKey()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                            .select().key();
        final String smt = "print obj 13.46 select key";
        verifyStatement(smt, bldr.getStmt());
    }
    /**
     * Prints the.
     */
    @Test(description = "status")
    public void printSelStatus()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                            .select().status();
        final String smt = "print obj 13.46 select status";
        verifyStatement(smt, bldr.getStmt());
    }
    /**
     * Prints the.
     */
    @Test(description = "file")
    public void printSelFile()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                            .select()
                                .file();
        final String smt = "print obj 13.46 select file";
        verifyStatement(smt, bldr.getStmt());
    }
    /**
     * Prints the.
     */
    @Test(description = "length")
    public void printSelLength()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                            .select().file().length();
        final String smt = "print obj 13.46 select file.length";
        verifyStatement(smt, bldr.getStmt());
    }
    /**
     * Prints the.
     */
    @Test(description = "base")
    public void printSelBase()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                            .select()
                                .attribute("Attr").base();
        final String smt = "print obj 13.46 select attribute[Attr].base";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "uom")
    public void printSelUoM()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                            .select().attribute("Attr").uom();
        final String smt = "print obj 13.46 select attribute[Attr].uom";
        verifyStatement(smt, bldr.getStmt());
    }
    /**
     * Prints the.
     */
    @Test(description = "class")
    public void printSelClass()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                            .select()
                                .clazz();
        final String smt = "print obj 13.46 select class";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "uuid")
    public void printSelUUID()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                            .select().type().uuid();
        final String smt = "print obj 13.46 select type.uuid";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "uuid")
    public void printList()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("123.456", "789.012", "345.678")
                            .select().type().uuid();
        final String smt = "print list (123.456, 789.012, 345.678) select type.uuid";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "print query ")
    public void printQuery()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print()
                            .query("Sales_Document")
                            .select().attribute("Attri");
        final String smt = "print query type Sales_Document select attribute[Attri]";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "print query types")
    public void printQueryTypes()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print()
                            .query("Sales_Document", "Sales_Invoice")
                            .select().attribute("Attri");
        final String smt = "print query type Sales_Document, Sales_Invoice select attribute[Attri]";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the query limit.
     */
    @Test(description = "print query limit")
    public void printQueryLimit()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print()
                            .query("Sales_Document")
                                .limit(10)
                            .select().attribute("Attri");
        final String smt = "print query type Sales_Document limit 10 select attribute[Attri]";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "print query ")
    public void printWhereEq()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print()
                            .query("Sales_Document")
                            .where()
                                .attr("Name").eq("demo")
                            .select()
                                .attribute("Attri");
        final String smt = "print query type Sales_Document where Name eq \"demo\" select attribute[Attri]";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "print query ")
    public void printWhereEqValues()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print()
                            .query("Sales_Document")
                            .where()
                                .attr("Name").in("demo", "test")
                            .select()
                                .attribute("Attri");
        final String smt = "print query type Sales_Document where Name in (\"demo\", \"test\") select attribute[Attri]";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the where eq and eq.
     */
    @Test(description = "print query eq and eq")
    public void printWhereEqAndEq()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print()
                            .query("Sales_Document")
                            .where()
                                .attr("Name").eq("demo")
                                .and()
                                .attr("Attr2").eq("5")
                            .select()
                                .attribute("Attri");
        final String smt = "print query type Sales_Document where Name eq \"demo\" and Attr2 == 5 "
                        + "select attribute[Attri]";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the where eq and eq.
     */
    @Test(description = "print query eq and eq or eq")
    public void printWhereEqAndEqOrEq()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print()
                            .query("Sales_Document")
                            .where()
                                .attr("Name").eq("demo")
                                .and()
                                .attr("Attr2").eq("5")
                                .or()
                                .attr("Attr3").eq("7")
                            .select()
                                .attribute("Attri");
        final String smt = "print query type Sales_Document where Name eq \"demo\" and Attr2 == 5 "
                        + "or Attr3 == 7 select attribute[Attri]";
        verifyStatement(smt, bldr.getStmt());
    }


    /**
     * Prints the.
     */
    @Test(description = "print query where less")
    public void printWhereLess()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print()
                            .query("Sales_Document")
                            .where()
                                .attr("Name").less("demo")
                            .select()
                                .attribute("Attri");
        final String smt = "print query type Sales_Document where Name < \"demo\" select attribute[Attri]";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "print query where greater")
    public void printWhereGreater()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print()
                            .query("Sales_Document")
                            .where()
                                .attr("Name").greater("demo")
                            .select()
                                .attribute("Attri");
        final String smt = "print query type Sales_Document where Name > \"demo\" select attribute[Attri]";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "print query where match")
    public void printWhereMatch()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print()
                            .query("Sales_Document")
                            .where()
                                .attr("Name").like("demo")
                            .select()
                                .attribute("Attri");
        final String smt = "print query type Sales_Document where Name like \"demo\" select attribute[Attri]";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "print query where not")
    public void printWhereNot()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print()
                            .query("Sales_Document")
                            .where()
                                .attr("Name").uneq("demo")
                            .select()
                                .attribute("Attri");
        final String smt = "print query type Sales_Document where Name != \"demo\" select attribute[Attri]";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "print query where nots")
    public void printWhereNots()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print()
                            .query("Sales_Document")
                            .where()
                                .attr("Name").notin("demo", "test")
                            .select()
                                .attribute("Attri");
        final String smt = "print query type Sales_Document where Name not in ( \"demo\", \"test\") "
                        + "select attribute[Attri]";
        verifyStatement(smt, bldr.getStmt());
    }

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
    @Test(description = "query update")
    public void updateQuery()
    {
        final AbstractEQLBuilder<?> bldr = EQL.update()
                            .query("Sales_Invoice")
                            .set("Name", "123");
        final String smt = "update query type Sales_Invoice set Name = 123";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "query update where")
    public void updateQueryWhere()
    {
        final AbstractEQLBuilder<?> bldr = EQL.update()
                            .query("Sales_Invoice")
                            .where()
                                .attr("Name").eq("demo")
                            .set("Name", "123");
        final String smt = "update query type Sales_Invoice where Name = \"demo\"set Name = 123";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "query update where")
    public void updateQueryWhereSets()
    {
        final AbstractEQLBuilder<?> bldr = EQL.update()
                            .query("Sales_Invoice")
                            .where()
                                .attr("Name").eq("demo")
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
