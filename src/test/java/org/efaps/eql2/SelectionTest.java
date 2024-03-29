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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
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

    @Test(dataProvider = "PrintStmtsAndAlias", description = " select attribute[Name] as ALIAS")
    public void attributeAlias(final String _eqlBase,
                               final IPrintStatement<?> _printStmt,
                               final String _alias)
        throws Exception
    {
        final String alias = _alias.startsWith("\"") ? _alias.substring(1, _alias.length() - 1) : _alias;
        _printStmt.getSelection()
            .addSelect(IEql2Factory.eINSTANCE.createSelect()
                .setAliasC(alias)
                .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("Name")));
        verifyStatement(_eqlBase + "select attribute[Name] as " + _alias, _printStmt);
    }

    @Test(dataProvider = "PrintStmts", description = "select attribute[Name].first")
    public void attributeFirst(final String _eqlBase,
                               final IPrintStatement<?> _printStmt)
        throws Exception
    {
        _printStmt.getSelection()
            .addSelect(IEql2Factory.eINSTANCE.createSelect()
                .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("Name"))
                .addElement(IEql2Factory.eINSTANCE.createBaseSelectElement().setElementC(SimpleSelectElement.FIRST)));
        verifyStatement(_eqlBase + "select attribute[Name].first", _printStmt);
    }

    @Test(dataProvider = "PrintStmts", description = "select attribute[Name].last")
    public void attributeLast(final String _eqlBase,
                               final IPrintStatement<?> _printStmt)
        throws Exception
    {
        _printStmt.getSelection()
        .addSelect(IEql2Factory.eINSTANCE.createSelect()
            .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("Name"))
            .addElement(IEql2Factory.eINSTANCE.createBaseSelectElement().setElementC(SimpleSelectElement.LAST)));
        verifyStatement(_eqlBase + "select attribute[Name].last", _printStmt);
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
    @Test(dataProvider = "PrintStmts", description = "select msgphrase[MsgPhrase_Name]")
    public void msgPhrase(final String _eqlBase,
                          final IPrintStatement<?> _printStmt)
    {
        _printStmt.getSelection()
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .addElement(IEql2Factory.eINSTANCE.createMsgPhraseSelectElement().setNameC("MsgPhrase_Name")));
        verifyStatement(_eqlBase + "select msgphrase[MsgPhrase_Name]", _printStmt);
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

    @Test(dataProvider = "PrintStmts", description = "select linkfrom[TypeName#AttributeName, filter attribute[Name] eq true]")
    public void linkfromWithFilter(final String _eqlBase,
                         final IPrintStatement<?> _printStmt)
    {
        final var filter =(IFilter) IEql2Factory.eINSTANCE.createFilter()
                        .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                        .element(IEql2Factory.eINSTANCE.createWhereElement().attribute("Name").equal().value("true")));
        _printStmt.getSelection()
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .addElement(IEql2Factory.eINSTANCE.createLinkfromSelectElement()
                                        .setTypeNameC("TypeName").setAttributeC("AttributeName")
                                        .setFilterC(filter)));
        verifyStatement(_eqlBase + "select linkfrom[TypeName#AttributeName, filter Name eq true]", _printStmt);
    }

    /**
     * Object print.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     */
    @Test(dataProvider = "PrintStmts", description = "select linkfrom[First:Second#AttributeName]")
    public void linkfromAttributeSet(final String _eqlBase,
                         final IPrintStatement<?> _printStmt)
    {
        _printStmt.getSelection()
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .addElement(IEql2Factory.eINSTANCE.createLinkfromSelectElement()
                                        .setTypeNameC("First:Second").setAttributeC("AttributeName")));
        verifyStatement(_eqlBase + "select linkfrom[First:Second#AttributeName]", _printStmt);
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
                        .addElement(IEql2Factory.eINSTANCE.createFormatSelectElement().setPatternC("YYYY-MM-DD")));
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
                        .addElement(IEql2Factory.eINSTANCE.createFormatSelectElement().setPatternC("YYYY-MM-DD")));
        verifyStatement(_eqlBase + "select attribute[Date].format[YYYY-MM-DD] as Algo", _printStmt);
    }

    /**
     * Object print.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     */
    @Test(dataProvider = "PrintStmts", description = "attribute[RateNetTotal].format[#,##0.00] as Formated")
    public void attributeFormatNumberAlias(final String _eqlBase,
                                           final IPrintStatement<?> _printStmt)
    {
        _printStmt.getSelection()
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .setAliasC("Formated")
                        .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("RateNetTotal"))
                        .addElement(IEql2Factory.eINSTANCE.createFormatSelectElement().setPatternC("#,##0.00")));
        verifyStatement(_eqlBase + "select attribute[RateNetTotal].format[#,##0.00] as Formated", _printStmt);
    }

    @Test(dataProvider = "PrintStmts", description = "attribute[StringValue].format['%s'] as Formated")
    public void attributeStringFormat(final String _eqlBase,
                                     final IPrintStatement<?> _printStmt)
    {
        _printStmt.getSelection()
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .setAliasC("Formated")
                        .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("StringValue"))
                        .addElement(IEql2Factory.eINSTANCE.createFormatSelectElement().setPatternC("%s")));
        verifyStatement(_eqlBase + "select attribute[StringValue].format['%s'] as Formated", _printStmt);
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
                        .addElement(IEql2Factory.eINSTANCE.createFormatSelectElement().setPatternC("YYYY-MM-DD")))
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .setAliasC("Otro")
                        .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("Date"))
                        .addElement(IEql2Factory.eINSTANCE.createFormatSelectElement().setPatternC("MM-YYYY/DD")));
        verifyStatement(_eqlBase + "select attribute[Date].format[YYYY-MM-DD] as Algo, "
                        + "attribute[Date].format[MM-YYYY/DD] as Otro", _printStmt);
    }

    /**
     * Object print.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     */
    @Test(dataProvider = "PrintStmts", description = "select attribute[SomeAttribute].joining[123]")
    public void attributeJoiningNUM(final String _eqlBase,
                                    final IPrintStatement<?> _printStmt)
    {
        _printStmt.getSelection()
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("SomeAttribute"))
                        .addElement(IEql2Factory.eINSTANCE.createJoiningSelectElement().setSeparatorC("123")));
        verifyStatement(_eqlBase + "select attribute[SomeAttribute].joining[123]", _printStmt);
    }

    /**
     * Object print.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     */
    @Test(dataProvider = "PrintStmts", description = "select attribute[SomeAttribute].joining[\", \"]")
    public void attributeJoiningString(final String _eqlBase,
                                       final IPrintStatement<?> _printStmt)
    {
        _printStmt.getSelection()
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("SomeAttribute"))
                        .addElement(IEql2Factory.eINSTANCE.createJoiningSelectElement().setSeparatorC(", ")));
        verifyStatement(_eqlBase + "select attribute[SomeAttribute].joining[\", \"]", _printStmt);
    }

    @Test(dataProvider = "PrintStmts", description = "select attribute[SomeAttribute].joining[123] as Algo")
    public void attributeJoiningAliasNUM(final String _eqlBase,
                                     final IPrintStatement<?> _printStmt)
    {
        _printStmt.getSelection()
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .setAliasC("Algo")
                        .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("SomeAttribute"))
                        .addElement(IEql2Factory.eINSTANCE.createJoiningSelectElement().setSeparatorC("123")));
        verifyStatement(_eqlBase + "select attribute[SomeAttribute].joining[123] as Algo", _printStmt);
    }

    @Test(dataProvider = "PrintStmts", description = "select attribute[SomeAttribute].joining[\", \"] as Algo")
    public void attributeJoiningAliasString(final String _eqlBase,
                                            final IPrintStatement<?> _printStmt)
    {
        _printStmt.getSelection()
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .setAliasC("Algo")
                        .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("SomeAttribute"))
                        .addElement(IEql2Factory.eINSTANCE.createJoiningSelectElement().setSeparatorC(", ")));
        verifyStatement(_eqlBase + "select attribute[SomeAttribute].joining[\", \"] as Algo", _printStmt);
    }

    /**
     * Object print.
     *
     * @param _eqlBase the eql base
     * @param _printStmt the print stmt
     */
    @Test(dataProvider = "PrintStmts", description = "select attribute[SomeAttribute].joining[123] as Algo,"
                    + "attribute[SomeAttribute].joining[\", \"] as Otro")
    public void nAttributeJoiningAlias(final String _eqlBase,
                                      final IPrintStatement<?> _printStmt)
    {
        _printStmt.getSelection()
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .setAliasC("Algo")
                        .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("SomeAttribute"))
                        .addElement(IEql2Factory.eINSTANCE.createJoiningSelectElement().setSeparatorC("123")))
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .setAliasC("Otro")
                        .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("SomeAttribute"))
                        .addElement(IEql2Factory.eINSTANCE.createJoiningSelectElement().setSeparatorC(", ")));
        verifyStatement(_eqlBase + "select attribute[SomeAttribute].joining[123] as Algo, "
                        + "attribute[SomeAttribute].joining[\", \"] as Otro", _printStmt);
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

    @Test(dataProvider = "PrintStmts", description = "select exec org.efaps.esjp.sales.tax.select.RateTaxSelect \"IGV\" as igv")
    public void execSelectSelectAsPackageName(final String _eqlBase,
                                              final IPrintStatement<?> _printStmt)
    {
        _printStmt.getSelection()
                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                        .setAliasC("igv")
                        .addElement(IEql2Factory.eINSTANCE.createExecSelectElement()
                                        .setClassNameC("org.efaps.esjp.sales.tax.select.RateTaxSelect")
                                        .addParameter("IGV")));
        verifyStatement(_eqlBase + "select exec org.efaps.esjp.sales.tax.select.RateTaxSelect \"IGV\" as igv", _printStmt);
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
        return getBaseObjects().iterator();
    }

    @DataProvider(name = "PrintStmtsAndAlias")
    public static Iterator<Object[]> printStmtsAndAlias(final ITestContext _context)
    {
        final List<Object[]> ret = new ArrayList<>();
        String[] aliases = new String[] { "HansWurst", "ONLYCAP", "onlysmall", "numer9", "\"alias with space\"" };
        final String[] keywords = new String[] { "type", "oid", "instance", "label", "id", "uuid", "name", "class", "value",
                        "base", "uom", "file", "length", "status", "key", "first", "last" };
        aliases = ArrayUtils.addAll(aliases, keywords);
        for (final String alias: aliases) {
            for (final Object[] base : getBaseObjects()) {
                ret.add(ArrayUtils.add(base, alias));
            }
        }
        return ret.iterator();
    }

    private static List<Object[]> getBaseObjects() {
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
        return ret;
    }
}
