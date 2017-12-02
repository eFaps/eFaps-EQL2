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
package org.efaps.eql2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * The Class SelectionTest.
 *
 * @author The eFaps Team
 */
public class SelectionTest
    extends AbstractTest
{

    /**
     * Object print.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     */
    @Test(dataProvider = "PrintStmts", description = "select attribute[Name]")
    public void attribute(final String _eqlBase,
                          final IPrintStatement<?> _printStmt)
    {
        _printStmt.getSelection()
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("Name")));
        verifyStatement(_eqlBase + "select attribute[Name]", _printStmt);
    }

    /**
     * Attribute with alias.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "PrintStmts", description = " select attribute[Name] as alias")
    public void attributeAlias(final String _eqlBase,
                               final IPrintStatement<?> _printStmt)
        throws Exception
    {
        _printStmt.getSelection()
            .addSelect(IEql2Factory.eINSTANCE.createSelect()
                .setAliasC("alias")
                .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("Name")));
        verifyStatement(_eqlBase + "select attribute[Name] as alias", _printStmt);
    }

    /**
     * Attribute with alias cap.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "PrintStmts", description = "select attribute[Name] as ALIAS")
    public void attributeWithAliasCap(final String _eqlBase,
                                      final IPrintStatement<?> _printStmt)
        throws Exception
    {
        _printStmt.getSelection()
            .addSelect(IEql2Factory.eINSTANCE.createSelect()
                .setAliasC("ALIAS")
                .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("Name")));
        verifyStatement(_eqlBase + "select attribute[Name] as ALIAS", _printStmt);
    }

    /**
     * Type.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "PrintStmts", description = "select type")
    public void type(final String _eqlBase,
                     final IPrintStatement<?> _printStmt)
        throws Exception
    {
        _printStmt.getSelection()
            .addSelect(IEql2Factory.eINSTANCE.createSelect()
                .addElement(IEql2Factory.eINSTANCE.createBaseSelectElement()
                                .setElementC(SimpleSelectElement.TYPE)));
        verifyStatement(_eqlBase + "select type", _printStmt);
    }

    /**
     * Type.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "PrintStmts", description = "select type as Type")
    public void typeAlias(final String _eqlBase,
                          final IPrintStatement<?> _printStmt)
        throws Exception
    {
        _printStmt.getSelection()
            .addSelect(IEql2Factory.eINSTANCE.createSelect()
                .setAliasC("Type")
                .addElement(IEql2Factory.eINSTANCE.createBaseSelectElement()
                                .setElementC(SimpleSelectElement.TYPE)));
        verifyStatement(_eqlBase + "select type as Type", _printStmt);
    }

    /**
     * Type.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "PrintStmts", description = "select type.label")
    public void typeLabel(final String _eqlBase,
                     final IPrintStatement<?> _printStmt)
        throws Exception
    {
        _printStmt.getSelection()
            .addSelect(IEql2Factory.eINSTANCE.createSelect()
                .addElement(IEql2Factory.eINSTANCE.createBaseSelectElement()
                                .setElementC(SimpleSelectElement.TYPE))
                .addElement(IEql2Factory.eINSTANCE.createBaseSelectElement()
                                .setElementC(SimpleSelectElement.LABEL)));
        verifyStatement(_eqlBase + "select type.label", _printStmt);
    }

    /**
     * Type.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "PrintStmts", description = "select type.name")
    public void typeName(final String _eqlBase,
                     final IPrintStatement<?> _printStmt)
        throws Exception
    {
        _printStmt.getSelection()
            .addSelect(IEql2Factory.eINSTANCE.createSelect()
                .addElement(IEql2Factory.eINSTANCE.createBaseSelectElement()
                                .setElementC(SimpleSelectElement.TYPE))
                .addElement(IEql2Factory.eINSTANCE.createBaseSelectElement()
                                .setElementC(SimpleSelectElement.NAME)));
        verifyStatement(_eqlBase + "select type.name", _printStmt);
    }

    /**
     * Type.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "PrintStmts", description = "select type.id")
    public void typeId(final String _eqlBase,
                     final IPrintStatement<?> _printStmt)
        throws Exception
    {
        _printStmt.getSelection()
            .addSelect(IEql2Factory.eINSTANCE.createSelect()
                .addElement(IEql2Factory.eINSTANCE.createBaseSelectElement()
                                .setElementC(SimpleSelectElement.TYPE))
                .addElement(IEql2Factory.eINSTANCE.createBaseSelectElement()
                                .setElementC(SimpleSelectElement.ID)));
        verifyStatement(_eqlBase + "select type.id", _printStmt);
    }

    /**
     * Type.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "PrintStmts", description = "select type.uuid")
    public void typeUUID(final String _eqlBase,
                     final IPrintStatement<?> _printStmt)
        throws Exception
    {
        _printStmt.getSelection()
            .addSelect(IEql2Factory.eINSTANCE.createSelect()
                .addElement(IEql2Factory.eINSTANCE.createBaseSelectElement()
                                .setElementC(SimpleSelectElement.TYPE))
                .addElement(IEql2Factory.eINSTANCE.createBaseSelectElement()
                                .setElementC(SimpleSelectElement.UUID)));
        verifyStatement(_eqlBase + "select type.uuid", _printStmt);
    }

    /**
     * OID.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "PrintStmts", description = "select oid")
    public void oid(final String _eqlBase,
                     final IPrintStatement<?> _printStmt)
        throws Exception
    {
        _printStmt.getSelection()
            .addSelect(IEql2Factory.eINSTANCE.createSelect()
                .addElement(IEql2Factory.eINSTANCE.createBaseSelectElement()
                                .setElementC(SimpleSelectElement.OID)));
        verifyStatement(_eqlBase + "select oid", _printStmt);
    }

    /**
     * ID.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "PrintStmts", description = "select id")
    public void id(final String _eqlBase,
                     final IPrintStatement<?> _printStmt)
        throws Exception
    {
        _printStmt.getSelection()
            .addSelect(IEql2Factory.eINSTANCE.createSelect()
                .addElement(IEql2Factory.eINSTANCE.createBaseSelectElement()
                                .setElementC(SimpleSelectElement.ID)));
        verifyStatement(_eqlBase + "select id", _printStmt);
    }

    /**
     * ID.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "PrintStmts", description = "select instance")
    public void instance(final String _eqlBase,
                         final IPrintStatement<?> _printStmt)
        throws Exception
    {
        _printStmt.getSelection()
            .addSelect(IEql2Factory.eINSTANCE.createSelect()
                .addElement(IEql2Factory.eINSTANCE.createBaseSelectElement()
                                .setElementC(SimpleSelectElement.INSTANCE)));
        verifyStatement(_eqlBase + "select instance", _printStmt);
    }

    /**
     * ID.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "PrintStmts", description = "select status")
    public void status(final String _eqlBase,
                       final IPrintStatement<?> _printStmt)
        throws Exception
    {
        _printStmt.getSelection()
            .addSelect(IEql2Factory.eINSTANCE.createSelect()
                .addElement(IEql2Factory.eINSTANCE.createBaseSelectElement()
                                .setElementC(SimpleSelectElement.STATUS)));
        verifyStatement(_eqlBase + "select status", _printStmt);
    }

    /**
     * ID.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "PrintStmts", description = "select file.length")
    public void fileLength(final String _eqlBase,
                           final IPrintStatement<?> _printStmt)
        throws Exception
    {
        _printStmt.getSelection()
            .addSelect(IEql2Factory.eINSTANCE.createSelect()
                .addElement(IEql2Factory.eINSTANCE.createBaseSelectElement()
                                .setElementC(SimpleSelectElement.FILE))
                .addElement(IEql2Factory.eINSTANCE.createBaseSelectElement()
                                .setElementC(SimpleSelectElement.LENGTH)));
        verifyStatement(_eqlBase + "select file.length", _printStmt);
    }

    /**
     * Object print.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     */
    @Test(dataProvider = "PrintStmts", description = "select class[CLASS_Name]")
    public void clazz(final String _eqlBase,
                      final IPrintStatement<?> _printStmt)
    {
        _printStmt.getSelection()
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .addElement(IEql2Factory.eINSTANCE.createClassSelectElement().setNameC("CLASS_Name")));
        verifyStatement(_eqlBase + "select class[CLASS_Name]", _printStmt);
    }

    /**
     * Object print.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     */
    @Test(dataProvider = "PrintStmts", description = "select linkto[AttributeName]")
    public void linkto(final String _eqlBase,
                      final IPrintStatement<?> _printStmt)
    {
        _printStmt.getSelection()
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .addElement(IEql2Factory.eINSTANCE.createLinktoSelectElement().setNameC("AttributeName")));
        verifyStatement(_eqlBase + "select linkto[AttributeName]", _printStmt);
    }

    /**
     * Object print.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     */
    @Test(dataProvider = "PrintStmts", description = "select linkfrom[TypeName#AttributeName]")
    public void linkfrom(final String _eqlBase,
                         final IPrintStatement<?> _printStmt)
    {
        _printStmt.getSelection()
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .addElement(IEql2Factory.eINSTANCE.createLinkfromSelectElement()
                                        .setTypeNameC("TypeName").setAttributeC("AttributeName")));
        verifyStatement(_eqlBase + "select linkfrom[TypeName#AttributeName]", _printStmt);
    }

    /**
     * Object print.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     */
    @Test(dataProvider = "PrintStmts", description = "select attribute[Date].format[YYYY-MM-DD]")
    public void attributeFormat(final String _eqlBase,
                                final IPrintStatement<?> _printStmt)
    {
        _printStmt.getSelection()
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("Date"))
                        .addElement(IEql2Factory.eINSTANCE.createFormatSelectElement().setValueC("YYYY-MM-DD")));
        verifyStatement(_eqlBase + "select attribute[Date].format[YYYY-MM-DD]", _printStmt);
    }

    /**
     * Object print.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     */
    @Test(dataProvider = "PrintStmts", description = "select attribute[Date].format[YYYY-MM-DD] as Algo")
    public void attributeFormatAlias(final String _eqlBase,
                                     final IPrintStatement<?> _printStmt)
    {
        _printStmt.getSelection()
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .setAliasC("Algo")
                        .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("Date"))
                        .addElement(IEql2Factory.eINSTANCE.createFormatSelectElement().setValueC("YYYY-MM-DD")));
        verifyStatement(_eqlBase + "select attribute[Date].format[YYYY-MM-DD] as Algo", _printStmt);
    }

    /**
     * Object print.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     */
    @Test(dataProvider = "PrintStmts", description = "select attribute[Date].format[YYYY-MM-DD] as Algo,"
                    + "attribute[Date].format[MM-YYYY/DD] as Otro")
    public void nAttributeFormatAlias(final String _eqlBase,
                                      final IPrintStatement<?> _printStmt)
    {
        _printStmt.getSelection()
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .setAliasC("Algo")
                        .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("Date"))
                        .addElement(IEql2Factory.eINSTANCE.createFormatSelectElement().setValueC("YYYY-MM-DD")))
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .setAliasC("Otro")
                        .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("Date"))
                        .addElement(IEql2Factory.eINSTANCE.createFormatSelectElement().setValueC("MM-YYYY/DD")));
        verifyStatement(_eqlBase + "select attribute[Date].format[YYYY-MM-DD] as Algo, "
                        + "attribute[Date].format[MM-YYYY/DD] as Otro", _printStmt);
    }

    /**
     * n Attributes.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "PrintStmts", description = " select attribute[Name1], attribute[Name2],"
                    + " attribute[Name3], attribute[Name4]")
    public void nAttributes(final String _eqlBase,
                            final IPrintStatement<?> _printStmt)
        throws Exception
    {
        _printStmt.getSelection()
            .addSelect(IEql2Factory.eINSTANCE.createSelect()
                .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("Name1")))
            .addSelect(IEql2Factory.eINSTANCE.createSelect()
                .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("Name2")))
            .addSelect(IEql2Factory.eINSTANCE.createSelect()
                .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("Name3")))
            .addSelect(IEql2Factory.eINSTANCE.createSelect()
                .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("Name4")));
        verifyStatement(_eqlBase + "select attribute[Name1], attribute[Name2], "
                        + "attribute[Name3], attribute[Name4]", _printStmt);
    }

    /**
     * Object print.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     */
    @Test(dataProvider = "PrintStmts", description = "select linkto[LinkTo].linkto[Linkto2].attribute[Attribute] "
                    + "as First, attribute[OneAttribute].base")
    public void nElements(final String _eqlBase,
                          final IPrintStatement<?> _printStmt)
    {
        _printStmt.getSelection()
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .setAliasC("First")
                        .addElement(IEql2Factory.eINSTANCE.createLinktoSelectElement().setNameC("LinkTo"))
                        .addElement(IEql2Factory.eINSTANCE.createLinktoSelectElement().setNameC("Linkto2"))
                        .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("Attribute")))
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("OneAttribute"))
                        .addElement(IEql2Factory.eINSTANCE.createBaseSelectElement()
                                        .setElementC(SimpleSelectElement.BASE)));
        verifyStatement(_eqlBase + "select linkto[LinkTo].linkto[Linkto2].attribute[Attribute] "
                        + "as First, attribute[OneAttribute].base", _printStmt);
    }

    /**
     * Exec select.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     */
    @Test(dataProvider = "PrintStmts", description = "select exec org.efaps.Demo as Test")
    public void execSelect(final String _eqlBase,
                           final IPrintStatement<?> _printStmt)
    {
        _printStmt.getSelection()
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .setAliasC("Test")
                        .addElement(IEql2Factory.eINSTANCE.createExecSelectElement().setClassNameC("org.efaps.Demo")));
        verifyStatement(_eqlBase + "select exec org.efaps.Demo as Test", _printStmt);
    }

    /**
     * Exec two selects.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     */
    @Test(dataProvider = "PrintStmts", description = "select exec org.efaps.Demo as One, exec org.efaps.esjp.Versuch"
                    + " as TWO")
    public void execTwoSelects(final String _eqlBase,
                               final IPrintStatement<?> _printStmt)
    {
        _printStmt.getSelection()
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .setAliasC("One")
                        .addElement(IEql2Factory.eINSTANCE.createExecSelectElement().setClassNameC("org.efaps.Demo")))
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .setAliasC("TWO")
                        .addElement(IEql2Factory.eINSTANCE.createExecSelectElement()
                                        .setClassNameC("org.efaps.esjp.Versuch")));
        verifyStatement(_eqlBase + "select exec org.efaps.Demo as One, exec org.efaps.esjp.Versuch as TWO", _printStmt);
    }


    /**
     * Exec select parameter.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     */
    @Test(dataProvider = "PrintStmts", description = "select exec org.efaps.Demo \"PARA\" as One")
    public void execSelectParameter(final String _eqlBase,
                                    final IPrintStatement<?> _printStmt)
    {
        _printStmt.getSelection()
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .setAliasC("One")
                        .addElement(IEql2Factory.eINSTANCE.createExecSelectElement().setClassNameC("org.efaps.Demo")
                                        .addParameter("PARA")));
        verifyStatement(_eqlBase + "select exec org.efaps.Demo \"PARA\" as One", _printStmt);
    }

    /**
     * Exec select two parameters.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     */
    @Test(dataProvider = "PrintStmts", description = "select exec org.efaps.Demo \"PARA\", \"Para2\" as One")
    public void execSelectTwoParameters(final String _eqlBase,
                                        final IPrintStatement<?> _printStmt)
    {
        _printStmt.getSelection()
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .setAliasC("One")
                        .addElement(IEql2Factory.eINSTANCE.createExecSelectElement().setClassNameC("org.efaps.Demo")
                                        .addParameter("PARA")
                                        .addParameter("Para2")));
        verifyStatement(_eqlBase + "select exec org.efaps.Demo \"PARA\", \"Para2\" as One", _printStmt);
    }

    /**
     * Exec select parameter number.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     */
    @Test(dataProvider = "PrintStmts", description = "select exec org.efaps.Demo 12 as One")
    public void execSelectParameterNumber(final String _eqlBase,
                                          final IPrintStatement<?> _printStmt)
    {
        _printStmt.getSelection()
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .setAliasC("One")
                        .addElement(IEql2Factory.eINSTANCE.createExecSelectElement().setClassNameC("org.efaps.Demo")
                                        .addParameter("12")));
        verifyStatement(_eqlBase + "select exec org.efaps.Demo 12 as One", _printStmt);
    }

    /**
     * Exec select two parameter number.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     */
    @Test(dataProvider = "PrintStmts", description = "select exec org.efaps.Demo 12,890 as One")
    public void execSelectTwoParameterNumber(final String _eqlBase,
                                             final IPrintStatement<?> _printStmt)
    {
        _printStmt.getSelection()
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .setAliasC("One")
                        .addElement(IEql2Factory.eINSTANCE.createExecSelectElement().setClassNameC("org.efaps.Demo")
                                        .addParameter("12").addParameter("890")));
        verifyStatement(_eqlBase + "select exec org.efaps.Demo 12,890 as One", _printStmt);
    }

    /**
     * Exec select mixed parameters.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     */
    @Test(dataProvider = "PrintStmts", description = "select exec org.efaps.Demo \"Hallo Welt\", 12, "
                    + "12, \"StringPara\", 890 as One")
    public void execSelectMixedParameters(final String _eqlBase,
                                          final IPrintStatement<?> _printStmt)
    {
        _printStmt.getSelection()
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .setAliasC("One")
                        .addElement(IEql2Factory.eINSTANCE.createExecSelectElement().setClassNameC("org.efaps.Demo")
                                        .addParameter("Hallo Welt").addParameter("12").addParameter("12")
                                        .addParameter("StringPara").addParameter("890")));
        verifyStatement(_eqlBase + "select exec org.efaps.Demo \"Hallo Welt\", 12, "
                        + "12, \"StringPara\", 890 as One", _printStmt);
    }

    /**
     * Attribute exec select.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     */
    @Test(dataProvider = "PrintStmts", description = "select attribute[AttrName], exec org.efaps.Demo as Test")
    public void attributeExecSelect(final String _eqlBase,
                                    final IPrintStatement<?> _printStmt)
    {
        _printStmt.getSelection()
            .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("AttrName")))
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .setAliasC("Test")
                        .addElement(IEql2Factory.eINSTANCE.createExecSelectElement().setClassNameC("org.efaps.Demo")));
        verifyStatement(_eqlBase + "select attribute[AttrName], exec org.efaps.Demo as Test", _printStmt);
    }

    /**
     * Attribute alias exec select.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     */
    @Test(dataProvider = "PrintStmts", description = "select attribute[AttrName] as Test2, "
                    + "exec org.efaps.Demo as Test")
    public void attributeAliasExecSelect(final String _eqlBase,
                                         final IPrintStatement<?> _printStmt)
    {
        _printStmt.getSelection()
            .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .setAliasC("Test2")
                        .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("AttrName")))
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .setAliasC("Test")
                        .addElement(IEql2Factory.eINSTANCE.createExecSelectElement().setClassNameC("org.efaps.Demo")));
        verifyStatement(_eqlBase + "select attribute[AttrName] as Test2, "
                        + "exec org.efaps.Demo as Test", _printStmt);
    }

    /**
     * Exec attribute select.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     */
    @Test(dataProvider = "PrintStmts", description = "select exec org.efaps.Demo as Test,"
                    + "attribute[AttrName] as Test2")
    public void execAttributeSelect(final String _eqlBase,
                                    final IPrintStatement<?> _printStmt)
    {
        _printStmt.getSelection()
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .setAliasC("Test")
                        .addElement(IEql2Factory.eINSTANCE.createExecSelectElement().setClassNameC("org.efaps.Demo")))
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                .setAliasC("Test2")
                                .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("AttrName")));
        verifyStatement(_eqlBase + "select exec org.efaps.Demo as Test,"
                        + "attribute[AttrName] as Test2", _printStmt);
    }

    /**
     * Ci commands.
     *
     * @param _context context
     * @return iterator with ciform
     */
    @DataProvider(name = "PrintStmts")
    public static Iterator<Object[]> printStmts(final ITestContext _context)
    {
        final List<Object[]> ret = new ArrayList<>();
        ret.add(new Object[] { "print obj 123.345 ",
                        IEql2Factory.eINSTANCE.createPrintObjectStatement().setOidC("123.345")
                            .setSelectionC(IEql2Factory.eINSTANCE.createSelection()) });

        ret.add(new Object[] { "print list (123.345) ",
                        IEql2Factory.eINSTANCE.createPrintListStatement().addOid("123.345")
                            .setSelectionC(IEql2Factory.eINSTANCE.createSelection())});

        ret.add(new Object[] { "print query type EFaps_Type ",
                        IEql2Factory.eINSTANCE.createPrintQueryStatement()
                    .setQueryC(IEql2Factory.eINSTANCE.createQuery().addType("EFaps_Type"))
                    .setSelectionC(IEql2Factory.eINSTANCE.createSelection())});

        ret.add(new Object[] { "print query type EFaps_Type, ce71ffa1-98f2-49b4-b892-246cd407b520, Sales_Invoice ",
                        IEql2Factory.eINSTANCE.createPrintQueryStatement()
                    .setQueryC(IEql2Factory.eINSTANCE.createQuery().addType("EFaps_Type")
                                    .addType("ce71ffa1-98f2-49b4-b892-246cd407b520")
                                    .addType("Sales_Invoice"))
                    .setSelectionC(IEql2Factory.eINSTANCE.createSelection())});

        ret.add(new Object[] { "print query type EFaps_Type where attribute[DocumentLink] == 4 ",
                        IEql2Factory.eINSTANCE.createPrintQueryStatement()
                        .setSelectionC(IEql2Factory.eINSTANCE.createSelection())
                    .setQueryC(IEql2Factory.eINSTANCE.createQuery().addType("EFaps_Type")
                    .where(IEql2Factory.eINSTANCE.createWhere().addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                                    .element(IEql2Factory.eINSTANCE.createWhereElement()
                                                    .attribute("DocumentLink").equal().value("4")))))});
        return ret.iterator();
    }
}
