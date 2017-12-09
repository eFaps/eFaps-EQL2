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

import org.efaps.eql2.AbstractTest;
import org.efaps.eql2.EQL;
import org.testng.annotations.Test;

/**
 *
 * @author The eFaps Team
 */
public class PrintObjTest
    extends AbstractTest
{

    @Test(description = "Select one attribute")
    public void printSelAttr()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL.print("13.46")
                        .attribute("ATTRNAME");
        final String stmt =  String.format("print obj 13.46 select attribute[%s]", "ATTRNAME");
        verifyStatement(stmt, bldr.getStmt());
    }

    @Test(description = "Select more attribute")
    public void printSelAttrAttr()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                        .attribute("attr")
                        .attribute("attr2");
        final String stmt = "print obj 13.46 select attribute[attr], attribute[attr2]";
        verifyStatement(stmt, bldr.getStmt());
    }

    @Test(description = "Select more attribute Alias")
    public void printSelAttrAttrAlias()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                        .attribute("attr")
                        .as("Alias1")
                        .attribute("attr2")
                        .as("Alias2");
        final String smt = "print obj 13.46 select attribute[attr] as Alias1, attribute[attr2] as Alias2";
        verifyStatement(smt, bldr.getStmt());
    }

    @Test(description = "Select more attribute")
    public void printSelLinko()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                        .linkto("attr1")
                            .attribute("attr");
        final String smt = "print obj 13.46 select linkto[attr1].attribute[attr]";
        verifyStatement(smt, bldr.getStmt());
    }

    @Test(description = "Select more attribute")
    public void printSelLinko2()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                        .linkto("attr1")
                            .attribute("attr")
                        .attribute("attr2");
        final String smt = "print obj 13.46 select linkto[attr1].attribute[attr], attribute[attr2]";
        verifyStatement(smt, bldr.getStmt());
    }

    @Test(description = "instance")
    public void printSelInstance()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                        .instance();
        final String smt = "print obj 13.46 select instance";
        verifyStatement(smt, bldr.getStmt());
    }

    @Test(description = "linkto instance")
    public void printSelLinkoInstance()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                        .linkto("attr1")
                        .instance();
        final String smt = "print obj 13.46 select linkto[attr1].instance";
        verifyStatement(smt, bldr.getStmt());
    }

    @Test(description = "linkfrom instance")
    public void printSelLinkFrom()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                        .linkfrom("Type_name", "Attr")
                            .instance();
        final String smt = "print obj 13.46 select linkfrom[Type_name#Attr].instance";
        verifyStatement(smt, bldr.getStmt());
    }

    @Test(description = "linkfrom attribute")
    public void printSelLinkFromAttr()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                        .linkfrom("Type_name", "Attr")
                            .attribute("Attr");
        final String smt = "print obj 13.46 select linkfrom[Type_name#Attr].attribute[Attr]";
        verifyStatement(smt, bldr.getStmt());
    }

    @Test(description = "linkfrom linkto attribute")
    public void printSelLinkFromLinktoAttr()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                        .linkfrom("Type_name", "Attr")
                            .linkto("LinktoAttr")
                                .attribute("Attr");
        final String smt = "print obj 13.46 select linkfrom[Type_name#Attr].linkto[LinktoAttr].attribute[Attr]";
        verifyStatement(smt, bldr.getStmt());
    }

    @Test(description = "oid")
    public void printSelOID()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                        .oid();
        final String smt = "print obj 13.46 select oid";
        verifyStatement(smt, bldr.getStmt());
    }

   @Test(description = "type")
    public void printSelType()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                        .type();
        final String smt = "print obj 13.46 select type";
        verifyStatement(smt, bldr.getStmt());
    }

    @Test(description = "value")
    public void printSelValue()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                        .attribute("Attr")
                        .value();
        final String smt = "print obj 13.46 select attribute[Attr].value";
        verifyStatement(smt, bldr.getStmt());
    }

   @Test(description = "label")
    public void printSelLabel()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                        .type()
                        .label();
        final String smt = "print obj 13.46 select type.label";
        verifyStatement(smt, bldr.getStmt());
    }

   @Test(description = "id")
    public void printSelID()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                        .id();
        final String smt = "print obj 13.46 select id";
        verifyStatement(smt, bldr.getStmt());
    }

   @Test(description = "name")
    public void printSelName()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                        .file()
                        .name();
        final String smt = "print obj 13.46 select file.name";
        verifyStatement(smt, bldr.getStmt());
    }

   @Test(description = "key")
    public void printSelKey()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                        .key();
        final String smt = "print obj 13.46 select key";
        verifyStatement(smt, bldr.getStmt());
    }

    @Test(description = "status")
    public void printSelStatus()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                        .status();
        final String smt = "print obj 13.46 select status";
        verifyStatement(smt, bldr.getStmt());
    }

    @Test(description = "file")
    public void printSelFile()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                        .file();
        final String smt = "print obj 13.46 select file";
        verifyStatement(smt, bldr.getStmt());
    }

    @Test(description = "length")
    public void printSelLength()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                        .file()
                        .length();
        final String smt = "print obj 13.46 select file.length";
        verifyStatement(smt, bldr.getStmt());
    }

    @Test(description = "base")
    public void printSelBase()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                        .attribute("Attr")
                        .base();
        final String smt = "print obj 13.46 select attribute[Attr].base";
        verifyStatement(smt, bldr.getStmt());
    }

    @Test(description = "uom")
    public void printSelUoM()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                        .attribute("Attr")
                        .uom();
        final String smt = "print obj 13.46 select attribute[Attr].uom";
        verifyStatement(smt, bldr.getStmt());
    }

    @Test(description = "class")
    public void printSelClass()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                        .clazz();
        final String smt = "print obj 13.46 select class";
        verifyStatement(smt, bldr.getStmt());
    }

    @Test(description = "uuid")
    public void printSelUUID()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("13.46")
                        .type()
                        .uuid();
        final String smt = "print obj 13.46 select type.uuid";
        verifyStatement(smt, bldr.getStmt());
    }

    @Test(description = "uuid")
    public void printList()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL
                        .print("123.456", "789.012", "345.678")
                        .type()
                        .uuid();
        final String smt = "print list (123.456, 789.012, 345.678) select type.uuid";
        verifyStatement(smt, bldr.getStmt());
    }

}
