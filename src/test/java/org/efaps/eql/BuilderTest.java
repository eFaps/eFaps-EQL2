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
     * The Class EQLBuilder.
     *
     */
    public static class EQLBuilder
        extends AbstractEQLBuilder<EQLBuilder>
    {

    }
}
