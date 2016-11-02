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
        _stmt.getQuery().getWhere()
                .addElement(IEqlFactory.eINSTANCE.createWhereElement()
                        .attribute("Name").comparison(Comparison.EQUAL).value("true"));
        verifyStatement(_eqlBase + "Name == true", _stmt);
        verifyStatement(_eqlBase + "attribute[Name] == true", _stmt);
        verifyStatement(_eqlBase + "Name eq true", _stmt);
        verifyStatement(_eqlBase + "attribute[Name] eq true", _stmt);
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
        _stmt.getQuery().getWhere()
                .addElement(IEqlFactory.eINSTANCE.createWhereElement()
                            .attribute("Name").comparison(Comparison.EQUAL).value("false"));
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
        _stmt.getQuery().getWhere()
                .addElement(IEqlFactory.eINSTANCE.createWhereElement()
                    .attribute("DocumentLink").comparison(Comparison.EQUAL).value("4"));
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
    @Test(dataProvider = "Stmts", description = "where ATTRIBUTE eq NUMBER and ATTRIBUTE eq number")
    public void eqNumAndEqNum(final String _eqlBase,
                              final IQueryStmt<?> _stmt)
        throws Exception
    {
        _stmt.getQuery().getWhere()
                .addElement(IEqlFactory.eINSTANCE.createWhereElement()
                            .attribute("DocumentLink").comparison(Comparison.EQUAL).value("4"))
                .addElement(IEqlFactory.eINSTANCE.createWhereElement()
                                .attribute("Description").comparison(Comparison.EQUAL).value("567"));
        verifyStatement(_eqlBase + "DocumentLink == 4 and Description == 567", _stmt);
        verifyStatement(_eqlBase + "attribute[DocumentLink] == 4 and attribute[Description] == 567", _stmt);
        verifyStatement(_eqlBase + "DocumentLink eq 4 and Description eq 567", _stmt);
        verifyStatement(_eqlBase + "attribute[DocumentLink] eq 4 and attribute[Description] eq 567", _stmt);

    }

    @Test(dataProvider = "Stmts", description = "where ATTRIBUTE == NUMBER")
    public void equalsNum(final String _eqlBase,
                        final IQueryStmt<?> _stmt)
        throws Exception
    {
        //       final Statement stmt = getStatement("print query type Sales_Invoice where DocumentLink == 4");
    }

    @Test(dataProvider = "Stmts", description = "where ATTRIBUTE == NUMBER and ATTRIBUTE == number")
    public void equalsNumAndEqualsNum(final String _eqlBase,
                        final IQueryStmt<?> _stmt)
        throws Exception
    {
        //       final Statement stmt = getStatement("print query type Sales_Invoice where DocumentLink == 4 and Description == 567");
    }

    @Test(dataProvider = "Stmts", description = "where ATTRIBUTE < NUMBER")
    public void lessNum(final String _eqlBase,
                        final IQueryStmt<?> _stmt)
        throws Exception
    {
        //       final Statement stmt = getStatement("print query type Sales_Invoice where DocumentLink < 4");
    }

    @Test(dataProvider = "Stmts", description = "where ATTRIBUTE > NUMBER")
    public void greaterNum(final String _eqlBase,
                        final IQueryStmt<?> _stmt)
        throws Exception
    {
        //      final Statement stmt = getStatement("print query type Sales_Invoice where DocumentLink > 4");
    }

    @Test(dataProvider = "Stmts", description = "where ATTRIBUTE !- NUMBER")
    public void unequalNum(final String _eqlBase,
                        final IQueryStmt<?> _stmt)
        throws Exception
    {
        //       final Statement stmt = getStatement("print query type Sales_Invoice where DocumentLink != 4");
    }

    @Test(dataProvider = "Stmts", description = "where ATTRIBUTE eq OID")
    public void eqOID(final String _eqlBase,
                        final IQueryStmt<?> _stmt)
        throws Exception
    {
        //       final Statement stmt = getStatement("print query type Sales_Invoice where DocumentLink eq 123.567");
    }

    @Test(dataProvider = "Stmts", description = "where ATTRIBUTE == OID")
    public void equalsOID(final String _eqlBase,
                        final IQueryStmt<?> _stmt)
        throws Exception
    {
        //       final Statement stmt = getStatement("print query type Sales_Invoice where DocumentLink == 123.567");
    }

    @Test(dataProvider = "Stmts", description = "where ATTRIBUTE !- OID")
    public void unequalOID(final String _eqlBase,
                        final IQueryStmt<?> _stmt)
        throws Exception
    {
        //        final Statement stmt = getStatement("print query type Sales_Invoice where DocumentLink != 123.567");
    }

    @Test(dataProvider = "Stmts", description = "where ATTRIBUTE eq STRING")
    public void eqString(final String _eqlBase,
                        final IQueryStmt<?> _stmt)
        throws Exception
    {
        //       final Statement stmt = getStatement("print query type Sales_Invoice where DocumentLink eq \"Blaues Hause\"");
    }

    @Test(dataProvider = "Stmts", description = "where ATTRIBUTE == STRING")
    public void equalsString(final String _eqlBase,
                        final IQueryStmt<?> _stmt)
        throws Exception
    {
        //        final Statement stmt = getStatement("print query type Sales_Invoice where DocumentLink == \"Blaues Hause\"");
    }

    @Test(dataProvider = "Stmts", description = "where ATTRIBUTE < STRING")
    public void lessString(final String _eqlBase,
                        final IQueryStmt<?> _stmt)
        throws Exception
    {
        //        final Statement stmt = getStatement("print query type Sales_Invoice where DocumentLink < \"Blaues Hause\"");
    }

    @Test(dataProvider = "Stmts", description = "where ATTRIBUTE > STRING")
    public void greaterString(final String _eqlBase,
                        final IQueryStmt<?> _stmt)
        throws Exception
    {
        //       final Statement stmt = getStatement("print query type Sales_Invoice where DocumentLink > \"Blaues Hause\"");
    }

    @Test(dataProvider = "Stmts", description = "where ATTRIBUTE !- STRING")
    public void unequalString(final String _eqlBase,
                        final IQueryStmt<?> _stmt)
        throws Exception
    {
        //       final Statement stmt = getStatement("print query type Sales_Invoice where DocumentLink != \"Blaues Hause\"");
    }

    @Test(dataProvider = "Stmts", description = "where ATTRIBUTE like STRING")
    public void likeString(final String _eqlBase,
                        final IQueryStmt<?> _stmt)
        throws Exception
    {
        //        final Statement stmt = getStatement("print query type Sales_Invoice where DocumentLink like \"%Blaues Hause\"");
    }

    @Test(dataProvider = "Stmts", description = "comination test for ")
    public void eqLessGreaterUnequalLike(final String _eqlBase,
                        final IQueryStmt<?> _stmt)
        throws Exception
    {
        //        final Statement stmt = getStatement("print query type Sales_Invoice where DocumentLink == 4 and Description < 567 and House like \"%Blaues Hause\" and HouseNumber > 459");
    }

    @Test(dataProvider = "Stmts", description = "where ATTRIBUTE in (NUMBER,NUMBER,NUMBER)")
    public void inNums(final String _eqlBase,
                        final IQueryStmt<?> _stmt)
        throws Exception
    {
        //       final Statement stmt = getStatement("print query type Sales_Invoice where DocumentLink in (4,7,12318)");
    }

    @Test(dataProvider = "Stmts", description = "where ATTRIBUTE in (NUMBER,NUMBER,NUMBER)")
    public void inStrings(final String _eqlBase,
                        final IQueryStmt<?> _stmt)
        throws Exception
    {
        //        final Statement stmt = getStatement("print query type Sales_Invoice where DocumentLink in (\"4\",\"das it ein langer etxt\",\"Bla bal bal\")");
    }

    @Test(dataProvider = "Stmts", description = "combination test for attributes ")
    public void eqLessGreaterUnequalLikeIn(final String _eqlBase,
                        final IQueryStmt<?> _stmt)
        throws Exception
    {
        //       final Statement stmt = getStatement("print query type Sales_Invoice where DocumentLink == 4 and Description < 567 and House like \"%Blaues Hause\" and DocLink in (\"4\",\"das it ein langer etxt\",\"Bla bal bal\") and HouseNumber > 459");
    }

    @Test(dataProvider = "Stmts", description = "where SELECT eq NUMBER")
    public void selectEqNum(final String _eqlBase,
                        final IQueryStmt<?> _stmt)
        throws Exception
    {
        //        final Statement stmt = getStatement("print query type Sales_Invoice where linkto[DocumentLink].attribute[Code] eq 4");
    }

    @Test(dataProvider = "Stmts", description = "where SELECT == NUMBER and SELECT == number")
    public void selectEqualsNumAndEqualsNum(final String _eqlBase,
                        final IQueryStmt<?> _stmt)
        throws Exception
    {
        //        final Statement stmt = getStatement("print query type Sales_Invoice where linkto[DocumentLink].attribute[Code] == 4 and "
     //                   + "linkto[DocumentLink].attribute[Descriptiobn] == 567");
    }

    @Test(dataProvider = "Stmts", description = "where SELECT < NUMBER")
    public void selectLessNum(final String _eqlBase,
                        final IQueryStmt<?> _stmt)
        throws Exception
    {
        //       final Statement stmt = getStatement("print query type Sales_Invoice where linkto[DocumentLink].attribute[Code] < 4");
    }

    @Test(dataProvider = "Stmts", description = "where SELECT > STRING")
    public void selectGreaterString(final String _eqlBase,
                        final IQueryStmt<?> _stmt)
        throws Exception
    {
        //        final Statement stmt = getStatement("print query type Sales_Invoice where linkto[DocumentLink].attribute[Code] > \"Blaues Hause\"");
    }

    @Test(dataProvider = "Stmts", description = "where SELECT like STRING")
    public void selectLikeString(final String _eqlBase,
                        final IQueryStmt<?> _stmt)
        throws Exception
    {
        //final Statement stmt = getStatement("print query type Sales_Invoice where linkto[DeliveryNote].attribute[Name] like \"099*\"");
    }


    @Test(dataProvider = "Stmts", description = "combination test for selects ")
    public void selectEqLessGreaterUnequalLikeIn(final String _eqlBase,
                        final IQueryStmt<?> _stmt)
        throws Exception
    {
        //        final Statement stmt = getStatement("print query type Sales_Invoice where linkto[DocumentLink].attribute[Code] == 4 "
          //              + "and linkto[DocumentLink].attribute[Description]  < 567 "
        //            + "and linkto[DocumentLink].attribute[House]  like \"%Blaues Hause\" "
        //              + "and linkto[DocumentLink].attribute[DocLink] in (\"4\",\"das it ein langer etxt\",\"Bla bal bal\") "
        //              + "and linkto[DocumentLink].attribute[HouseNumber] > 459");
    }

    @Test(dataProvider = "Stmts", description = "combination test for selects ")
    public void typeNameAndEqOID(final String _eqlBase,
                        final IQueryStmt<?> _stmt)
        throws Exception
    {
        //        final Statement stmt = getStatement("print query type Sales_Invoice2DeliveryNote where FromLink == 5710.1126 select linkto[ToLink].attribute[Name] as name");
    }

    @Test(dataProvider = "Stmts", description = "where SELECT > STRING LIMI")
    public void selectGreaterStringWithLimit(final String _eqlBase,
                        final IQueryStmt<?> _stmt)
        throws Exception
    {
//        final Statement stmt = getStatement("print query type Sales_Invoice where linkto[DocumentLink].attribute[Code] > \"Blaues Hause\" limit 1");
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
                        IEqlFactory.eINSTANCE.createPrintQueryStatement()
                    .setQueryC(IEqlFactory.eINSTANCE.createQuery().addType("Sales_Invoice")
                                    .where())});
        return ret.iterator();
    }

}
