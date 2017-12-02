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
 * TODO comment!
 *
 * @author The eFaps Team
 */
public class WhereTest
    extends AbstractTest
{

    /**
     * Eq true.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = "Name == true")
    public void eqTrue(final String _eqlBase,
                       final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere().element().attribute("Name").comparison(Comparison.EQUAL).value("true");
        verifyStatement(_eqlBase + "Name == true ", _stmt);
        verifyStatement(_eqlBase + "attribute[Name] == true ", _stmt);
        verifyStatement(_eqlBase + "Name eq true ", _stmt);
        verifyStatement(_eqlBase + "attribute[Name] eq true ", _stmt);
        verifyStatement(_eqlBase + "attribute[Name] eq true ", _stmt);
    }

    /**
     * Eq false.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = "attribute[Name] == false")
    public void eqFalse(final String _eqlBase,
                        final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere().element().attribute("Name").equal().value("false");
        verifyStatement(_eqlBase + "Name == false", _stmt);
        verifyStatement(_eqlBase + "attribute[Name] == false", _stmt);
        verifyStatement(_eqlBase + "Name eq false", _stmt);
        verifyStatement(_eqlBase + "attribute[Name] eq false", _stmt);
    }

    /**
     * Eq num.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = "where ATTRIBUTE eq NUMBER")
    public void eqNum(final String _eqlBase,
                      final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere().element().attribute("DocumentLink").equal().value("4");
        verifyStatement(_eqlBase + "DocumentLink == 4", _stmt);
        verifyStatement(_eqlBase + "attribute[DocumentLink] == 4", _stmt);
        verifyStatement(_eqlBase + "DocumentLink eq 4", _stmt);
        verifyStatement(_eqlBase + "attribute[DocumentLink] eq 4", _stmt);
    }

    /**
     * Eq num and eq num.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = "ATTRIBUTE eq NUMBER and ATTRIBUTE eq number")
    public void eqNumAndEqNum(final String _eqlBase,
                              final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere()
            .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                    .element(IEql2Factory.eINSTANCE.createWhereElement().attribute("DocumentLink").equal().value("4")))
            .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm().and()
                    .element(IEql2Factory.eINSTANCE.createWhereElement().attribute("Description").equal().value("567")));
        verifyStatement(_eqlBase + "DocumentLink == 4 and Description == 567", _stmt);
        verifyStatement(_eqlBase + "attribute[DocumentLink] == 4 and attribute[Description] == 567", _stmt);
        verifyStatement(_eqlBase + "DocumentLink eq 4 and Description eq 567", _stmt);
        verifyStatement(_eqlBase + "attribute[DocumentLink] eq 4 and attribute[Description] eq 567", _stmt);
    }

    /**
     * Equals num.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = "ATTRIBUTE eq NUMBER or ATTRIBUTE eq number")
    public void equalsNum(final String _eqlBase,
                          final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere()
                .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                    .element(IEql2Factory.eINSTANCE.createWhereElement().attribute("DocumentLink").equal().value("4")))
                .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm().or()
                    .element(IEql2Factory.eINSTANCE.createWhereElement().attribute("Description").equal().value("567")));
        verifyStatement(_eqlBase + "DocumentLink == 4 or Description == 567", _stmt);
        verifyStatement(_eqlBase + "attribute[DocumentLink] == 4 or attribute[Description] == 567", _stmt);
        verifyStatement(_eqlBase + "DocumentLink eq 4 or Description eq 567", _stmt);
        verifyStatement(_eqlBase + "attribute[DocumentLink] eq 4 or attribute[Description] eq 567", _stmt);
    }

    /**
     * Less num.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = "where ATTRIBUTE < NUMBER")
    public void lessNum(final String _eqlBase,
                        final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere().element().attribute("DocumentLink").less().value("4");
        verifyStatement(_eqlBase + "DocumentLink < 4", _stmt);
    }

    /**
     * Greater num.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = "where ATTRIBUTE > NUMBER")
    public void greaterNum(final String _eqlBase,
                           final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere().element().attribute("DocumentLink").greater().value("4");
        verifyStatement(_eqlBase + "DocumentLink > 4", _stmt);
    }

    /**
     * Unequal num.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = "where ATTRIBUTE !- NUMBER")
    public void unequalNum(final String _eqlBase,
                           final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere().element().attribute("DocumentLink").unequal().value("4");
        verifyStatement(_eqlBase + "DocumentLink != 4", _stmt);
    }

    /**
     * Eq OID.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = "where ATTRIBUTE eq OID")
    public void eqOID(final String _eqlBase,
                      final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere().element().attribute("DocumentLink").equal().value("123.567");
        verifyStatement(_eqlBase + "DocumentLink eq 123.567", _stmt);
        verifyStatement(_eqlBase + "DocumentLink == 123.567", _stmt);
    }

    /**
     * Unequal OID.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = "where ATTRIBUTE !- OID")
    public void unequalOID(final String _eqlBase,
                           final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere().element().attribute("DocumentLink").unequal().value("123.567");
        verifyStatement(_eqlBase + "DocumentLink != 123.567", _stmt);
    }

    /**
     * Eq string.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = "where ATTRIBUTE eq STRING")
    public void eqString(final String _eqlBase,
                         final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere().element().attribute("DocumentLink").equal().value("Blue House");
        verifyStatement(_eqlBase + "DocumentLink == \"Blue House\"", _stmt);
        verifyStatement(_eqlBase + "DocumentLink eq \"Blue House\"", _stmt);
    }

    /**
     * Less string.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = "where ATTRIBUTE < STRING")
    public void lessString(final String _eqlBase,
                           final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere().element().attribute("DocumentLink").less().value("Blue House");
        verifyStatement(_eqlBase + "DocumentLink < \"Blue House\"", _stmt);
    }

    /**
     * Greater string.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = "where ATTRIBUTE > STRING")
    public void greaterString(final String _eqlBase,
                              final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere().element().attribute("DocumentLink").greater().value("Blue House");
        verifyStatement(_eqlBase + "DocumentLink > \"Blue House\"", _stmt);
    }

    /**
     * Unequal string.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = "where ATTRIBUTE !- STRING")
    public void unequalString(final String _eqlBase,
                              final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere().element().attribute("DocumentLink").unequal().value("Blue House");
        verifyStatement(_eqlBase + "DocumentLink != \"Blue House\"", _stmt);
    }

    /**
     * Like string.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = "where ATTRIBUTE like STRING")
    public void likeString(final String _eqlBase,
                           final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere().element().attribute("DocumentLink").like().value("%Blue House");
        verifyStatement(_eqlBase + "DocumentLink like \"%Blue House\"", _stmt);
    }

    /**
     * Eq less greater unequal like.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = "comination test for ")
    public void eqLessGreaterUnequalLike(final String _eqlBase,
                                         final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere()
            .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                    .element(IEql2Factory.eINSTANCE.createWhereElement().attribute("DocumentLink").equal().value("4")))
            .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm().and()
                    .element(IEql2Factory.eINSTANCE.createWhereElement().attribute("Description").less().value("567")))
            .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm().and()
                    .element(IEql2Factory.eINSTANCE.createWhereElement().attribute("House").like().value("Blue House")))
            .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm().and()
                .element(IEql2Factory.eINSTANCE.createWhereElement().attribute("HouseNumber").greater().value("459")));
        verifyStatement(_eqlBase + "DocumentLink == 4 and Description < 567 and "
                        + "House like \"Blue House\" and HouseNumber > 459", _stmt);
    }

    /**
     * In nums.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = "where ATTRIBUTE in (NUMBER,NUMBER,NUMBER)")
    public void inNums(final String _eqlBase,
                       final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere().element().attribute("DocumentLink").in().addValue("4").addValue("7")
            .addValue("12318");
        verifyStatement(_eqlBase + "DocumentLink in (4,7,12318)", _stmt);
    }

    /**
     * In strings.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = "where ATTRIBUTE in (STRING,STRING,STRING)")
    public void inStrings(final String _eqlBase,
                          final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere().element().attribute("DocumentLink").in()
                .addValue("4")
                .addValue("das it ein langer text")
                .addValue("Bla bal bal");
        verifyStatement(_eqlBase + "DocumentLink in (\"4\",\"das it ein langer text\",\"Bla bal bal\")", _stmt);
    }

    /**
     * Eq less greater unequal like in.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = "combination test for attributes ")
    public void eqLessGreaterUnequalLikeIn(final String _eqlBase,
                                           final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere()
            .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                .element(IEql2Factory.eINSTANCE.createWhereElement().attribute("DocumentLink").equal().value("4")))
            .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm().and()
                .element(IEql2Factory.eINSTANCE.createWhereElement().attribute("Description").less().value("567")))
            .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm().and()
                .element(IEql2Factory.eINSTANCE.createWhereElement().attribute("House").like().value("Blue House")))
            .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm().and()
                .element(IEql2Factory.eINSTANCE.createWhereElement().attribute("DocLink").in()
                            .addValue("4").addValue("das it ein langer etxt").addValue("Bla bal bal")))
            .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm().and()
                .element(IEql2Factory.eINSTANCE.createWhereElement().attribute("HouseNumber").greater().value("459")));
        verifyStatement(_eqlBase + "DocumentLink == 4 and Description < 567 and House like \"Blue House\" "
                        + "and DocLink in (\"4\",\"das it ein langer etxt\",\"Bla bal bal\") "
                        + "and HouseNumber > 459", _stmt);
    }

    /**
     * Select eq num.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = "where SELECT eq NUMBER")
    public void selectEqNum(final String _eqlBase,
                            final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere()
            .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                    .element(IEql2Factory.eINSTANCE.createWhereElement()
                        .select(IEql2Factory.eINSTANCE.createWhereSelect()
                                .addElement(IEql2Factory.eINSTANCE.createLinktoSelectElement().name("DocumentLink"))
                                .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().name("Code"))
                        ).value("4")));
        verifyStatement(_eqlBase + "linkto[DocumentLink].attribute[Code] eq 4", _stmt);
    }

    /**
     * Select equals num and equals num.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = "where SELECT == NUMBER and SELECT == number")
    public void selectEqualsNumAndEqualsNum(final String _eqlBase,
                                            final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere()
            .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                .element(IEql2Factory.eINSTANCE.createWhereElement()
                    .select(IEql2Factory.eINSTANCE.createWhereSelect()
                            .addElement(IEql2Factory.eINSTANCE.createLinktoSelectElement().name("DocumentLink"))
                            .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().name("Code"))
                    ).equal().value("4")))
            .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm().and()
                .element(IEql2Factory.eINSTANCE.createWhereElement()
                    .select(IEql2Factory.eINSTANCE.createWhereSelect()
                            .addElement(IEql2Factory.eINSTANCE.createLinktoSelectElement().name("DocumentLink"))
                            .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().name("Description"))
                    ).equal().value("567")));
        verifyStatement(_eqlBase + "linkto[DocumentLink].attribute[Code] eq 4 "
                        + "and linkto[DocumentLink].attribute[Description] == 567", _stmt);
    }

    /**
     * Select less num.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = "where SELECT < NUMBER")
    public void selectLessNum(final String _eqlBase,
                              final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere()
            .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                .element(IEql2Factory.eINSTANCE.createWhereElement()
                    .select(IEql2Factory.eINSTANCE.createWhereSelect()
                            .addElement(IEql2Factory.eINSTANCE.createLinktoSelectElement().name("DocumentLink"))
                            .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().name("Code"))
                    ).less().value("4")));
        verifyStatement(_eqlBase + "linkto[DocumentLink].attribute[Code] < 4", _stmt);
    }

    /**
     * Select greater string.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = "where SELECT > STRING")
    public void selectGreaterString(final String _eqlBase,
                                    final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere()
            .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                .element(IEql2Factory.eINSTANCE.createWhereElement()
                    .select(IEql2Factory.eINSTANCE.createWhereSelect()
                        .addElement(IEql2Factory.eINSTANCE.createLinktoSelectElement().name("DocumentLink"))
                        .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().name("Code"))
                ).greater().value("Blue House")));
        verifyStatement(_eqlBase + "linkto[DocumentLink].attribute[Code] > \"Blue House\"", _stmt);
    }

    /**
     * Select like string.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = "where SELECT like STRING")
    public void selectLikeString(final String _eqlBase,
                                 final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere()
            .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                .element(IEql2Factory.eINSTANCE.createWhereElement()
                    .select(IEql2Factory.eINSTANCE.createWhereSelect()
                        .addElement(IEql2Factory.eINSTANCE.createLinktoSelectElement().name("DocumentLink"))
                        .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().name("Code"))
                ).like().value("099*")));
        verifyStatement(_eqlBase + "linkto[DocumentLink].attribute[Code] like \"099*\"", _stmt);
    }

    /**
     * Select eq less greater unequal like in.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = "combination test for selects ")
    public void selectEqLessGreaterUnequalLikeIn(final String _eqlBase,
                                                 final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere()
            .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                .element(IEql2Factory.eINSTANCE.createWhereElement()
                    .select(IEql2Factory.eINSTANCE.createWhereSelect()
                            .addElement(IEql2Factory.eINSTANCE.createLinktoSelectElement().name("DocumentLink1"))
                            .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().name("Code"))
                    ).equal().value("4")))
            .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm().and()
                .element(IEql2Factory.eINSTANCE.createWhereElement()
                    .select(IEql2Factory.eINSTANCE.createWhereSelect()
                            .addElement(IEql2Factory.eINSTANCE.createLinktoSelectElement().name("DocumentLink2"))
                            .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().name("Description"))
                    ).less().value("567")))
            .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm().and()
                .element(IEql2Factory.eINSTANCE.createWhereElement()
                    .select(IEql2Factory.eINSTANCE.createWhereSelect()
                            .addElement(IEql2Factory.eINSTANCE.createLinktoSelectElement().name("DocumentLink3"))
                            .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().name("DocLink"))
                    ).in().addValue("567").addValue("das it ein langer text").addValue("Bla bal bal")))
            .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm().and()
                .element(IEql2Factory.eINSTANCE.createWhereElement()
                    .select(IEql2Factory.eINSTANCE.createWhereSelect()
                            .addElement(IEql2Factory.eINSTANCE.createLinktoSelectElement().name("DocumentLink4"))
                            .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().name("HouseNumber"))
                    ).greater().value("459")));
        verifyStatement(_eqlBase + "linkto[DocumentLink1].attribute[Code] eq 4 "
                        + "and linkto[DocumentLink2].attribute[Description] < 567 "
                        + "and linkto[DocumentLink3].attribute[DocLink] in (\"567\",\"das it ein langer text\","
                            + "\"Bla bal bal\") "
                        + "and linkto[DocumentLink4].attribute[HouseNumber] > 459", _stmt);
    }

    /**
     * Attr in list.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = " where ID in (1, 6, 7)")
    public void attrInList(final String _eqlBase,
                           final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere()
            .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                    .element(IEql2Factory.eINSTANCE.createWhereElement().attribute("ID").in().addValue("1")
                                    .addValue("6").addValue("7")));
        verifyStatement(_eqlBase + "ID in (1, 6, 7)", _stmt);
    }

    /**
     * Attr in query.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = "where Invoice in ( query type Sales_Invoice select "
                    + "attribute[FromLink] )")
    public void attrInQuery(final String _eqlBase,
                            final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere()
            .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                .element(IEql2Factory.eINSTANCE.createWhereElement().attribute("Invoice").in()
                        .nestedQuery(IEql2Factory.eINSTANCE.createNestedQuery()
                                    .addType("Sales_Invoice").selection(
                                        IEql2Factory.eINSTANCE.createSelection()
                                        .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().name("FromLink")))))));

        verifyStatement(_eqlBase + "Invoice in ( query type Sales_Invoice select attribute[FromLink] )", _stmt);
    }

    /**
     * Attr in query two.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = "where Invoice in ( query type Sales_Invoice where attribute[ID] == 15 "
                    + "select attribute[FromLink]  )")
    public void attrInQuery2(final String _eqlBase,
                             final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere()
            .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                .element(IEql2Factory.eINSTANCE.createWhereElement().attribute("Invoice").in()
                    .nestedQuery(IEql2Factory.eINSTANCE.createNestedQuery().addType("Sales_Invoice")
                        .where(IEql2Factory.eINSTANCE.createWhere()
                            .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                                .element(IEql2Factory.eINSTANCE.createWhereElement()
                                            .attribute("ID").equal().value("15"))))
                .selection(IEql2Factory.eINSTANCE.createSelection()
                                .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                    .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().name("FromLink")
                                ))))));

        verifyStatement(_eqlBase + "Invoice in ( query type Sales_Invoice where attribute[ID] == 15 "
                        + "select attribute[FromLink])", _stmt);
    }

    /**
     * Attr in query 3.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = " where Invoice in ( query type Sales_Invoice )")
    public void attrInQuery3(final String _eqlBase,
                             final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere()
            .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                    .element(IEql2Factory.eINSTANCE.createWhereElement().attribute("Invoice").in()
                            .nestedQuery(IEql2Factory.eINSTANCE.createNestedQuery()
                                .addType("Sales_Invoice"))));

        verifyStatement(_eqlBase + "Invoice in ( query type Sales_Invoice )", _stmt);
    }

    /**
     * Group.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = "T1 and (T2 and T3)")
    public void group1(final String _eqlBase,
                      final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere()
                .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                    .element(IEql2Factory.eINSTANCE.createWhereElement()
                                    .attribute("ATTR1").equal().value("1")))
                .addTerm(IEql2Factory.eINSTANCE.createWhereGroupTerm().and()
                    .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                        .element(IEql2Factory.eINSTANCE.createWhereElement()
                                    .attribute("ATTR2").equal().value("2")))
                    .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm().and()
                        .element(IEql2Factory.eINSTANCE.createWhereElement()
                                    .attribute("ATTR3").equal().value("3"))));
        verifyStatement(_eqlBase + "ATTR1 == 1 and (ATTR2 == 2 and ATTR3 == 3)", _stmt);
    }

    /**
     * Group two.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = "(T1 and T2) and T3")
    public void group2(final String _eqlBase,
                       final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere()
                .addTerm(IEql2Factory.eINSTANCE.createWhereGroupTerm()
                    .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                        .element(IEql2Factory.eINSTANCE.createWhereElement()
                                    .attribute("ATTR1").equal().value("1")))
                    .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm().and()
                        .element(IEql2Factory.eINSTANCE.createWhereElement()
                                    .attribute("ATTR2").equal().value("2"))))
                .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm().and()
                        .element(IEql2Factory.eINSTANCE.createWhereElement()
                                    .attribute("ATTR3").equal().value("3")));
        verifyStatement(_eqlBase + "(ATTR1 == 1 and ATTR2 == 2) and ATTR3 ==3", _stmt);
    }

    /**
     * Group 3.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = " T1 and (T2 and T3) and T4 and T5 and T6")
    public void group3(final String _eqlBase,
                       final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere()
                .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                        .element(IEql2Factory.eINSTANCE.createWhereElement()
                                    .attribute("ATTR1").equal().value("1")))
                .addTerm(IEql2Factory.eINSTANCE.createWhereGroupTerm().and()
                        .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                            .element(IEql2Factory.eINSTANCE.createWhereElement()
                                        .attribute("ATTR2").equal().value("2")))
                        .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm().and()
                            .element(IEql2Factory.eINSTANCE.createWhereElement()
                                        .attribute("ATTR3").equal().value("3"))))
                .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm().and()
                        .element(IEql2Factory.eINSTANCE.createWhereElement()
                                    .attribute("ATTR4").equal().value("4")))
                .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm().and()
                        .element(IEql2Factory.eINSTANCE.createWhereElement()
                                    .attribute("ATTR5").equal().value("5")))
                .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm().and()
                        .element(IEql2Factory.eINSTANCE.createWhereElement()
                                    .attribute("ATTR6").equal().value("6")));
        verifyStatement(_eqlBase + "ATTR1 == 1 and (ATTR2 == 2 and ATTR3 ==3) "
                        + "and ATTR4 == 4 and ATTR5 == 5  and ATTR6 == 6 ", _stmt);
    }

    /**
     * Group for.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = " T1 and ((T2 and T3) and T4) and T5 and T6")
    public void group4(final String _eqlBase,
                       final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere()
                .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                        .element(IEql2Factory.eINSTANCE.createWhereElement().attribute("ATTR1").equal().value("1")))
                .addTerm(IEql2Factory.eINSTANCE.createWhereGroupTerm().and()
                    .addTerm(IEql2Factory.eINSTANCE.createWhereGroupTerm()
                        .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                            .element(IEql2Factory.eINSTANCE.createWhereElement()
                                            .attribute("ATTR2").equal().value("2")))
                        .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm().and()
                            .element(IEql2Factory.eINSTANCE.createWhereElement()
                                            .attribute("ATTR3").equal().value("3"))))
                    .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm().and()
                            .element(IEql2Factory.eINSTANCE.createWhereElement()
                                    .attribute("ATTR4").equal().value("4"))))
               .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm().and()
                           .element(IEql2Factory.eINSTANCE.createWhereElement().attribute("ATTR5").equal().value("5")))
               .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm().and()
                           .element(IEql2Factory.eINSTANCE.createWhereElement().attribute("ATTR6").equal().value("6")));
        verifyStatement(_eqlBase + "ATTR1 == 1 and ((ATTR2 == 2 and ATTR3 == 3) and ATTR4 == 4) "
                        + "and ATTR5 == 5  and ATTR6 == 6 ", _stmt);
    }

    /**
     * Group 5.
     *
     * @param _eqlBase the eql base
     * @param _stmt the stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "Stmts", description = "(T1 and ((T2 and T3) and (T4 and T5))) and T6 ")
    public void group5(final String _eqlBase,
                       final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere()
                .addTerm(IEql2Factory.eINSTANCE.createWhereGroupTerm()
                    .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                        .element(IEql2Factory.eINSTANCE.createWhereElement()
                                    .attribute("ATTR1").equal().value("1")))
                    .addTerm(IEql2Factory.eINSTANCE.createWhereGroupTerm().and()
                        .addTerm(IEql2Factory.eINSTANCE.createWhereGroupTerm()
                            .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                                .element(IEql2Factory.eINSTANCE.createWhereElement()
                                            .attribute("ATTR2").equal().value("2")))
                            .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm().and()
                                .element(IEql2Factory.eINSTANCE.createWhereElement()
                                            .attribute("ATTR3").equal().value("3"))))
                        .addTerm(IEql2Factory.eINSTANCE.createWhereGroupTerm().and()
                            .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                                .element(IEql2Factory.eINSTANCE.createWhereElement()
                                            .attribute("ATTR4").equal().value("4")))
                            .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm().and()
                                .element(IEql2Factory.eINSTANCE.createWhereElement()
                                            .attribute("ATTR5").equal().value("5"))))))
                .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm().and()
                                .element(IEql2Factory.eINSTANCE.createWhereElement()
                                            .attribute("ATTR6").equal().value("6")));
        verifyStatement(_eqlBase + "(ATTR1 == 1 and ((ATTR2 == 2 and ATTR3 == 3) and (ATTR4 == 4 "
                        + "and ATTR5 == 5)))  and ATTR6 == 6 ", _stmt);
    }

    /**
     * Ci commands.
     *
     * @param _context context
     * @return iterator with ciform
     */
    @DataProvider(name = "Stmts")
    public static Iterator<Object[]> stmts(final ITestContext _context)
    {
        final List<Object[]> ret = new ArrayList<>();
        ret.add(new Object[] { "print query type Sales_Invoice where ",
                        IEql2Factory.eINSTANCE.createPrintQueryStatement()
                    .setQueryC(IEql2Factory.eINSTANCE.createQuery().addType("Sales_Invoice")
                                    .where())});
        return ret.iterator();
    }
}
