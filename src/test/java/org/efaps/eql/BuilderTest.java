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

import org.testng.annotations.Test;

/**
 * The Class BuilderTest.
 *
 * @author The eFaps Team
 */
public class BuilderTest
    extends AbstractTest
{

    /**
     * Prints the.
     */
    @Test(description = "Select one attribute")
    public void printSelAttr()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print("13.46")
                            .select()
                                .attribute("attr");
        final String smt = "print obj 13.46 select attribute[attr]";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "Select attribute Alias")
    public void printSelAttrAlias()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print("13.46")
                            .select()
                                .attribute("attr")
                                .as("Brown");
        final String smt = "print obj 13.46 select attribute[attr] as Brown";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "Select more attribute")
    public void printSelAttrAttr()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print("13.46")
                            .select()
                                .attribute("attr")
                            .select()
                                .attribute("attr2");
        final String smt = "print obj 13.46 select attribute[attr], attribute[attr2]";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "Select more attribute Alias")
    public void printSelAttrAttrAlias()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print("13.46")
                            .select()
                                .attribute("attr")
                                .as("Alias1")
                            .select()
                                .attribute("attr2")
                                .as("Alias2");
        final String smt = "print obj 13.46 select attribute[attr] as Alias1, attribute[attr2] as Alias2";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "Select more attribute")
    public void printSelLinko()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print("13.46")
                            .select()
                                .linkto("attr1")
                                .attribute("attr");
        final String smt = "print obj 13.46 select linkto[attr1].attribute[attr]";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "Select more attribute")
    public void printSelLinko2()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print("13.46")
                            .select()
                                .linkto("attr1")
                                .attribute("attr")
                            .select()
                                .attribute("attr2");
        final String smt = "print obj 13.46 select linkto[attr1].attribute[attr], attribute[attr2]";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "instance")
    public void printSelInstance()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print("13.46")
                            .select()
                                .instance();
        final String smt = "print obj 13.46 select instance";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "linkto instance")
    public void printSelLinkoInstance()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print("13.46")
                            .select()
                                .linkto("attr1")
                                .instance();
        final String smt = "print obj 13.46 select linkto[attr1].instance";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "linkfrom instance")
    public void printSelLinkFrom()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print("13.46")
                            .select()
                                .linkfrom("Type_name", "Attr").instance();
        final String smt = "print obj 13.46 select linkfrom[Type_name#Attr].instance";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "linkfrom attribute")
    public void printSelLinkFromAttr()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print("13.46")
                            .select()
                                .linkfrom("Type_name", "Attr").attribute("Attr");
        final String smt = "print obj 13.46 select linkfrom[Type_name#Attr].attribute[Attr]";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "linkfrom linkto attribute")
    public void printSelLinkFromLinktoAttr()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print("13.46")
                            .select()
                                .linkfrom("Type_name", "Attr").linkto("LinktoAttr") .attribute("Attr");
        final String smt = "print obj 13.46 select linkfrom[Type_name#Attr].linkto[LinktoAttr].attribute[Attr]";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "oid")
    public void printSelOID()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print("13.46")
                            .select().oid();
        final String smt = "print obj 13.46 select oid";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "type")
    public void printSelType()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print("13.46")
                            .select().type();
        final String smt = "print obj 13.46 select type";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "value")
    public void printSelValue()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print("13.46")
                            .select().attribute("Attr").value();
        final String smt = "print obj 13.46 select attribute[Attr].value";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "label")
    public void printSelLabel()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print("13.46")
                            .select().type().label();
        final String smt = "print obj 13.46 select type.label";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "id")
    public void printSelID()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print("13.46")
                            .select().id();
        final String smt = "print obj 13.46 select id";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "name")
    public void printSelName()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print("13.46")
                            .select().file().name();
        final String smt = "print obj 13.46 select file.name";
        verifyStatement(smt, builder.getStmt());
    }
    /**
     * Prints the.
     */
    @Test(description = "key")
    public void printSelKey()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print("13.46")
                            .select().key();
        final String smt = "print obj 13.46 select key";
        verifyStatement(smt, builder.getStmt());
    }
    /**
     * Prints the.
     */
    @Test(description = "status")
    public void printSelStatus()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print("13.46")
                            .select().status();
        final String smt = "print obj 13.46 select status";
        verifyStatement(smt, builder.getStmt());
    }
    /**
     * Prints the.
     */
    @Test(description = "file")
    public void printSelFile()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print("13.46")
                            .select()
                                .file();
        final String smt = "print obj 13.46 select file";
        verifyStatement(smt, builder.getStmt());
    }
    /**
     * Prints the.
     */
    @Test(description = "length")
    public void printSelLength()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print("13.46")
                            .select().file().length();
        final String smt = "print obj 13.46 select file.length";
        verifyStatement(smt, builder.getStmt());
    }
    /**
     * Prints the.
     */
    @Test(description = "base")
    public void printSelBase()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print("13.46")
                            .select()
                                .attribute("Attr").base();
        final String smt = "print obj 13.46 select attribute[Attr].base";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "uom")
    public void printSelUoM()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print("13.46")
                            .select().attribute("Attr").uom();
        final String smt = "print obj 13.46 select attribute[Attr].uom";
        verifyStatement(smt, builder.getStmt());
    }
    /**
     * Prints the.
     */
    @Test(description = "class")
    public void printSelClass()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print("13.46")
                            .select()
                                .clazz();
        final String smt = "print obj 13.46 select class";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "uuid")
    public void printSelUUID()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print("13.46")
                            .select().type().uuid();
        final String smt = "print obj 13.46 select type.uuid";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "uuid")
    public void printList()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print("123.456", "789.012", "345.678")
                            .select().type().uuid();
        final String smt = "print list (123.456, 789.012, 345.678) select type.uuid";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "print query ")
    public void printQuery()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print()
                            .query("Sales_Document")
                            .select().attribute("Attri");
        final String smt = "print query type Sales_Document select attribute[Attri]";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "print query types")
    public void printQueryTypes()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print()
                            .query("Sales_Document", "Sales_Invoice")
                            .select().attribute("Attri");
        final String smt = "print query type Sales_Document, Sales_Invoice select attribute[Attri]";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the query limit.
     */
    @Test(description = "print query limit")
    public void printQueryLimit()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print()
                            .query("Sales_Document")
                                .limit(10)
                            .select().attribute("Attri");
        final String smt = "print query type Sales_Document limit 10 select attribute[Attri]";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "print query ")
    public void printWhereEq()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print()
                            .query("Sales_Document")
                            .where()
                                .attrEqValue("Name", "demo")
                            .select()
                                .attribute("Attri");
        final String smt = "print query type Sales_Document where Name eq \"demo\" select attribute[Attri]";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "print query ")
    public void printWhereEqValues()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print()
                            .query("Sales_Document")
                            .where()
                                .attrEqValue("Name", "demo", "test")
                            .select()
                                .attribute("Attri");
        final String smt = "print query type Sales_Document where Name in (\"demo\", \"test\") select attribute[Attri]";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the where eq and eq.
     */
    @Test(description = "print query eq and eq")
    public void printWhereEqAndEq()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print()
                            .query("Sales_Document")
                            .where()
                                .attrEqValue("Name", "demo")
                                .and()
                                .attrEqValue("Attr2", "5")
                            .select()
                                .attribute("Attri");
        final String smt = "print query type Sales_Document where Name eq \"demo\" and Attr2 == 5 "
                        + "select attribute[Attri]";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the where eq and eq.
     */
    @Test(description = "print query eq and eq or eq")
    public void printWhereEqAndEqOrEq()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print()
                            .query("Sales_Document")
                            .where()
                                .attrEqValue("Name", "demo")
                                .and()
                                .attrEqValue("Attr2", "5")
                                .or()
                                .attrEqValue("Attr3", "7")
                            .select()
                                .attribute("Attri");
        final String smt = "print query type Sales_Document where Name eq \"demo\" and Attr2 == 5 "
                        + "or Attr3 == 7 select attribute[Attri]";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "print query where less")
    public void printWhereLess()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print()
                            .query("Sales_Document")
                            .where()
                                .attrLessValue("Name", "demo")
                            .select()
                                .attribute("Attri");
        final String smt = "print query type Sales_Document where Name < \"demo\" select attribute[Attri]";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "print query where greater")
    public void printWhereGreater()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print()
                            .query("Sales_Document")
                            .where()
                                .attrGreaterValue("Name", "demo")
                            .select()
                                .attribute("Attri");
        final String smt = "print query type Sales_Document where Name > \"demo\" select attribute[Attri]";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "print query where match")
    public void printWhereMatch()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print()
                            .query("Sales_Document")
                            .where()
                                .attrMatchValue("Name", "demo")
                            .select()
                                .attribute("Attri");
        final String smt = "print query type Sales_Document where Name like \"demo\" select attribute[Attri]";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "print query where not")
    public void printWhereNot()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print()
                            .query("Sales_Document")
                            .where()
                                .attrNotValue("Name", "demo")
                            .select()
                                .attribute("Attri");
        final String smt = "print query type Sales_Document where Name != \"demo\" select attribute[Attri]";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "print query where nots")
    public void printWhereNots()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .print()
                            .query("Sales_Document")
                            .where()
                                .attrNotValue("Name", "demo", "test")
                            .select()
                                .attribute("Attri");
        final String smt = "print query type Sales_Document where Name not in ( \"demo\", \"test\") "
                        + "select attribute[Attri]";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "basic update")
    public void update()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .update("123.456")
                            .set("Name", "123");
        final String smt = "update obj 123.456 set Name = 123";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "basic update")
    public void updateVarious()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .update("123.456")
                            .set("Name", "123")
                            .set("Attr2", "demo");
        final String smt = "update obj 123.456 set Name = 123, Attr2 = \"demo\"";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "basic update")
    public void updateList()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .update("123.456", "789.012")
                            .set("Name", "123");
        final String smt = "update list ( 123.456, 789.012 ) set Name = 123";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "query update")
    public void updateQuery()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .update()
                            .query("Sales_Invoice")
                            .set("Name", "123");
        final String smt = "update query type Sales_Invoice set Name = 123";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "query update where")
    public void updateQueryWhere()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .update()
                            .query("Sales_Invoice")
                            .where()
                                .attrEqValue("Name", "demo")
                            .set("Name", "123");
        final String smt = "update query type Sales_Invoice where Name = \"demo\"set Name = 123";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "basic insert")
    public void insert()
    {
        final EQLBuilder builder = new EQLBuilder()
                        .insert("Sales_Invoice")
                            .set("Name", "123");
        final String smt = "insert type Sales_Invoice set Name = 123";
        verifyStatement(smt, builder.getStmt());
    }

    /**
     * The Class EQLBuilder.
     *
     */
    public static class EQLBuilder
        extends AbstractEQLBuilder<EQLBuilder>
    {

    }
}
