/*
 * Copyright 2003 - 2019 The eFaps Team
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

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.efaps.eql2.AbstractTest;
import org.efaps.eql2.EQL2;
import org.efaps.eql2.StmtFlag;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * The Class bldrTest.
 *
 * @author The eFaps Team
 */
public class BuilderTest
    extends AbstractTest
{
    /**
     * Prints the query limit.
     */
   // @Test(description = "print query limit")
    public void printQueryLimit()
    {
        final AbstractPrintEQLBuilder<?> bldr = EQL2
                        .print()
                        //    .limit(10)
                        .attribute("Attri");
        final String smt = "print query type Sales_Document limit 10 select attribute[Attri]";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    @Test(description = "basic update")
    public void update()
    {
        final AbstractEQLBuilder<?> bldr = EQL2.update("123.456")
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
        final AbstractEQLBuilder<?> bldr = EQL2.update("123.456")
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
        final AbstractEQLBuilder<?> bldr = EQL2.update("123.456", "789.012")
                            .set("Name", "123");
        final String smt = "update list ( 123.456, 789.012 ) set Name = 123";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    //@Test(description = "query update")
    public void updateQuery()
    {
        final AbstractEQLBuilder<?> bldr = EQL2.update()
                            //.query("Sales_Invoice")
                            .set("Name", "123");
        final String smt = "update query type Sales_Invoice set Name = 123";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    //@Test(description = "query update where")
    public void updateQueryWhere()
    {
        final AbstractEQLBuilder<?> bldr = EQL2.update()
                            //.query("Sales_Invoice")
                            //.where()
                           //     .attr("Name").eq("demo")
                            .set("Name", "123");
        final String smt = "update query type Sales_Invoice where Name = \"demo\"set Name = 123";
        verifyStatement(smt, bldr.getStmt());
    }

    /**
     * Prints the.
     */
    //@Test(description = "query update where")
    public void updateQueryWhereSets()
    {
        final AbstractEQLBuilder<?> bldr = EQL2.update()
                            //.query("Sales_Invoice")
                           // .where()
                           //     .attr("Name").eq("demo")
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
        final AbstractEQLBuilder<?> bldr = EQL2.insert("Sales_Invoice")
                            .set("Name", "123");
        final String smt = "insert type Sales_Invoice set Name = 123";
        verifyStatement(smt, bldr.getStmt());
    }

    @Test(dataProvider = "DeleteBuilders")
    public void testDeleteBuilders(final AbstractEQLBuilder<?> _builder, final String _stmt) {
        assertEquals(_builder.build(), _stmt);
    }

    @DataProvider(name = "DeleteBuilders")
    public static Iterator<Object[]> deleteBuilders(final ITestContext _context)
    {
        final List<Object[]> ret = new ArrayList<>();
        ret.add(new Object[] {
                        EQL2.builder()
                            .with(StmtFlag.TRIGGEROFF)
                            .delete("123.456"),
                        "with trigger-off delete object 123.456"
                            });
        ret.add(new Object[] {
                        EQL2.builder()
                            .with(StmtFlag.TRIGGEROFF)
                            .delete("123.456", "789.123"),
                        "with trigger-off delete list (123.456, 789.123)"
                            });
        ret.add(new Object[] {
                        EQL2.builder()
                            .with(StmtFlag.TRIGGEROFF, StmtFlag.REQCACHED)
                            .delete("123.456"),
                        "with trigger-off, request-cached delete object 123.456"
                            });
        ret.add(new Object[] {
                        EQL2.builder()
                            .with(StmtFlag.TRIGGEROFF, StmtFlag.REQCACHED)
                            .delete("123.456", "789.123"),
                        "with trigger-off, request-cached delete list (123.456, 789.123)"
                            });
        ret.add(new Object[] {
                        EQL2.builder()
                            .delete("123.456"),
                        "delete object 123.456"
                            });
        ret.add(new Object[] {
                        EQL2.builder()
                            .delete("123.456", "789.123"),
                        "delete list (123.456, 789.123)"
                            });
        return ret.iterator();
    }

}
