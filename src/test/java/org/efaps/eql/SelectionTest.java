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
                .addSelect(IEqlFactory.eINSTANCE.createSelect()
                        .addElement(IEqlFactory.eINSTANCE.createAttributeSelectElement().setNameC("Name")));
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
            .addSelect(IEqlFactory.eINSTANCE.createSelect()
                .setAliasC("alias")
                .addElement(IEqlFactory.eINSTANCE.createAttributeSelectElement().setNameC("Name")));
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
            .addSelect(IEqlFactory.eINSTANCE.createSelect()
                .setAliasC("ALIAS")
                .addElement(IEqlFactory.eINSTANCE.createAttributeSelectElement().setNameC("Name")));
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
            .addSelect(IEqlFactory.eINSTANCE.createSelect()
                .addElement(IEqlFactory.eINSTANCE.createBaseSelectElement()
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
            .addSelect(IEqlFactory.eINSTANCE.createSelect()
                .setAliasC("Type")
                .addElement(IEqlFactory.eINSTANCE.createBaseSelectElement()
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
            .addSelect(IEqlFactory.eINSTANCE.createSelect()
                .addElement(IEqlFactory.eINSTANCE.createBaseSelectElement()
                                .setElementC(SimpleSelectElement.TYPE))
                .addElement(IEqlFactory.eINSTANCE.createBaseSelectElement()
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
            .addSelect(IEqlFactory.eINSTANCE.createSelect()
                .addElement(IEqlFactory.eINSTANCE.createBaseSelectElement()
                                .setElementC(SimpleSelectElement.TYPE))
                .addElement(IEqlFactory.eINSTANCE.createBaseSelectElement()
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
            .addSelect(IEqlFactory.eINSTANCE.createSelect()
                .addElement(IEqlFactory.eINSTANCE.createBaseSelectElement()
                                .setElementC(SimpleSelectElement.TYPE))
                .addElement(IEqlFactory.eINSTANCE.createBaseSelectElement()
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
            .addSelect(IEqlFactory.eINSTANCE.createSelect()
                .addElement(IEqlFactory.eINSTANCE.createBaseSelectElement()
                                .setElementC(SimpleSelectElement.TYPE))
                .addElement(IEqlFactory.eINSTANCE.createBaseSelectElement()
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
            .addSelect(IEqlFactory.eINSTANCE.createSelect()
                .addElement(IEqlFactory.eINSTANCE.createBaseSelectElement()
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
            .addSelect(IEqlFactory.eINSTANCE.createSelect()
                .addElement(IEqlFactory.eINSTANCE.createBaseSelectElement()
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
            .addSelect(IEqlFactory.eINSTANCE.createSelect()
                .addElement(IEqlFactory.eINSTANCE.createBaseSelectElement()
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
            .addSelect(IEqlFactory.eINSTANCE.createSelect()
                .addElement(IEqlFactory.eINSTANCE.createBaseSelectElement()
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
            .addSelect(IEqlFactory.eINSTANCE.createSelect()
                .addElement(IEqlFactory.eINSTANCE.createBaseSelectElement()
                                .setElementC(SimpleSelectElement.FILE))
                .addElement(IEqlFactory.eINSTANCE.createBaseSelectElement()
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
                .addSelect(IEqlFactory.eINSTANCE.createSelect()
                        .addElement(IEqlFactory.eINSTANCE.createClassSelectElement().setNameC("CLASS_Name")));
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
                .addSelect(IEqlFactory.eINSTANCE.createSelect()
                        .addElement(IEqlFactory.eINSTANCE.createLinktoSelectElement().setNameC("AttributeName")));
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
                .addSelect(IEqlFactory.eINSTANCE.createSelect()
                        .addElement(IEqlFactory.eINSTANCE.createLinkfromSelectElement()
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
                .addSelect(IEqlFactory.eINSTANCE.createSelect()
                        .addElement(IEqlFactory.eINSTANCE.createAttributeSelectElement().setNameC("Date"))
                        .addElement(IEqlFactory.eINSTANCE.createFormatSelectElement().setValueC("YYYY-MM-DD")));
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
                .addSelect(IEqlFactory.eINSTANCE.createSelect()
                        .setAliasC("Algo")
                        .addElement(IEqlFactory.eINSTANCE.createAttributeSelectElement().setNameC("Date"))
                        .addElement(IEqlFactory.eINSTANCE.createFormatSelectElement().setValueC("YYYY-MM-DD")));
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
    public void multiAttributeFormatAlias(final String _eqlBase,
                                          final IPrintStatement<?> _printStmt)
    {
        _printStmt.getSelection()
                .addSelect(IEqlFactory.eINSTANCE.createSelect()
                        .setAliasC("Algo")
                        .addElement(IEqlFactory.eINSTANCE.createAttributeSelectElement().setNameC("Date"))
                        .addElement(IEqlFactory.eINSTANCE.createFormatSelectElement().setValueC("YYYY-MM-DD")))
                .addSelect(IEqlFactory.eINSTANCE.createSelect()
                        .setAliasC("Otro")
                        .addElement(IEqlFactory.eINSTANCE.createAttributeSelectElement().setNameC("Date"))
                        .addElement(IEqlFactory.eINSTANCE.createFormatSelectElement().setValueC("MM-YYYY/DD")));
        verifyStatement(_eqlBase + "select attribute[Date].format[YYYY-MM-DD] as Algo, "
                        + "attribute[Date].format[MM-YYYY/DD] as Otro", _printStmt);
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
                        IEqlFactory.eINSTANCE.createObjectPrintStatement().setOidC("123.345")
                            .setSelectionC(IEqlFactory.eINSTANCE.createSelection()) });
        ret.add(new Object[] { "print list (123.345) ",
                        IEqlFactory.eINSTANCE.createListPrintStatement().addOid("123.345")
                            .setSelectionC(IEqlFactory.eINSTANCE.createSelection())});
        return ret.iterator();
    }
}
