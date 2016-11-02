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
 * The Class QueryTest.
 *
 * @author The eFaps Team
 */
public class QueryTest
    extends AbstractTest
{

    /**
     * One type.
     *
     * @param _eqlBase the eql base
     * @param _queryStmt the query stmt
     */
    @Test(dataProvider = "PrintStmts", description = "type Sales_Invoice")
    public void oneType(final String _eqlBase,
                        final IQueryStmt<?> _queryStmt)
    {
        _queryStmt.getQuery().addType("Sales_Invoice");
        verifyStatement(_eqlBase + "type Sales_Invoice", _queryStmt);
    }

    /**
     * Two types.
     *
     * @param _eqlBase the eql base
     * @param _queryStmt the query stmt
     */
    @Test(dataProvider = "PrintStmts", description = "type Sales_Invoice, Contacts_Contact")
    public void twoTypes(final String _eqlBase,
                         final IQueryStmt<?> _queryStmt)
    {
        _queryStmt.getQuery().addType("Sales_Invoice").addType("Contacts_Contact");
        verifyStatement(_eqlBase + "type Sales_Invoice, Contacts_Contact", _queryStmt);
    }

    /**
     * Many types.
     *
     * @param _eqlBase the eql base
     * @param _queryStmt the query stmt
     */
    @Test(dataProvider = "PrintStmts", description = "type Sales_Invoice, Contacts_Contact,"
                    + "HumanResource_Employee")
    public void manyTypes(final String _eqlBase,
                          final IQueryStmt<?> _queryStmt)
    {
        _queryStmt.getQuery().addType("Sales_Invoice").addType("Contacts_Contact").addType("HumanResource_Employee");
        verifyStatement(_eqlBase + "type Sales_Invoice, Contacts_Contact, HumanResource_Employee", _queryStmt);
    }

    /**
     * Type with number in name.
     *
     * @param _eqlBase the eql base
     * @param _queryStmt the query stmt
     * @throws Exception the exception
     */
    @Test(dataProvider = "PrintStmts", description = "Type contains a number in the name")
    public void typeWithNumberInName(final String _eqlBase,
                                     final IQueryStmt<?> _queryStmt)
        throws Exception
    {
        _queryStmt.getQuery().addType("Sales_Invo2ice").addType("Contacts_Co4ntact");
        verifyStatement(_eqlBase + "type Sales_Invo2ice, Contacts_Co4ntact", _queryStmt);
    }

    /**
     * Limit.
     *
     * @param _eqlBase the eql base
     * @param _queryStmt the query stmt
     */
    @Test(dataProvider = "PrintStmts", description = "query with a limit")
    public void limit(final String _eqlBase,
                      final IQueryStmt<?> _queryStmt)
    {
        _queryStmt.getQuery().addType("Sales_Invoice").setLimitC(IEqlFactory.eINSTANCE.createLimit().setValueC("10"));
        verifyStatement(_eqlBase + "type Sales_Invoice limit 10", _queryStmt);
    }

    /**
     * Type UUID.
     *
     * @param _eqlBase the eql base
     * @param _queryStmt the query stmt
     */
    @Test(dataProvider = "PrintStmts", description = "type 0029a77d-65ca-4564-968c-2ef6adf72033, "
                    + "Contacts_Contact, ce71ffa1-98f2-49b4-b892-246cd407b520, Sales_Invoice")
    public void typeUUID(final String _eqlBase,
                         final IQueryStmt<?> _queryStmt)
    {
        _queryStmt.getQuery().addType("0029a77d-65ca-4564-968c-2ef6adf72033").addType("Contacts_Contact")
            .addType("ce71ffa1-98f2-49b4-b892-246cd407b520").addType("Sales_Invoice");
        verifyStatement(_eqlBase + "type 0029a77d-65ca-4564-968c-2ef6adf72033, Contacts_Contact, "
                        + "ce71ffa1-98f2-49b4-b892-246cd407b520, Sales_Invoice", _queryStmt);
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
        ret.add(new Object[] { "print query ",
                        IEqlFactory.eINSTANCE.createPrintQueryStatement()
                    .setQueryC(IEqlFactory.eINSTANCE.createQuery())});
        return ret.iterator();
    }
}
