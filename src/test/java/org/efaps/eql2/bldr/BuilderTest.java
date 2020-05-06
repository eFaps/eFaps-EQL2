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
 * Class to test the "with Flag part of the builders".
 *
 * @author The eFaps Team
 */
public class BuilderTest
    extends AbstractTest
{

    @Test(dataProvider = "DeleteBuilders")
    public void testDeleteBuilders(final AbstractEQLBuilder<?> _builder, final String _stmt) {
        assertEquals(_builder.build(), _stmt);
    }

    @Test(dataProvider = "InsertBuilders")
    public void testInsertBuilders(final AbstractEQLBuilder<?> _builder, final String _stmt) {
        assertEquals(_builder.build(), _stmt);
    }

    @Test(dataProvider = "UpdateBuilders")
    public void testUpdateBuilders(final AbstractEQLBuilder<?> _builder, final String _stmt) {
        assertEquals(_builder.build(), _stmt);
    }

    @Test(dataProvider = "PrintBuilders")
    public void testPrintBuilders(final AbstractEQLBuilder<?> _builder, final String _stmt) {
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

    @DataProvider(name = "InsertBuilders")
    public static Iterator<Object[]> insertBuilders(final ITestContext _context)
    {
        final List<Object[]> ret = new ArrayList<>();
        ret.add(new Object[] {
                        EQL2.builder()
                            .with(StmtFlag.TRIGGEROFF)
                            .insert("TypeName")
                            .set("Name", "123"),
                        "with trigger-off insert type TypeName set Name = 123"
                            });
        ret.add(new Object[] {
                        EQL2.builder()
                            .with(StmtFlag.TRIGGEROFF, StmtFlag.REQCACHED)
                            .insert("TypeName")
                            .set("Name", "123"),
                        "with trigger-off, request-cached insert type TypeName set Name = 123"
                            });
        ret.add(new Object[] {
                        EQL2.builder()
                            .insert("TypeName")
                            .set("Name", "123"),
                        "insert type TypeName set Name = 123"
                            });
        return ret.iterator();
    }

    @DataProvider(name = "UpdateBuilders")
    public static Iterator<Object[]> updateBuilders(final ITestContext _context)
    {
        final List<Object[]> ret = new ArrayList<>();
        ret.add(new Object[] {
                        EQL2.builder()
                            .with(StmtFlag.TRIGGEROFF)
                            .update("123.456")
                            .set("Name", "123"),
                        "with trigger-off update object 123.456 set Name = 123"
                            });
        ret.add(new Object[] {
                        EQL2.builder()
                            .with(StmtFlag.TRIGGEROFF, StmtFlag.REQCACHED)
                            .update("123.456")
                            .set("Name", "123"),
                        "with trigger-off, request-cached update object 123.456 set Name = 123"
                            });
        ret.add(new Object[] {
                        EQL2.builder()
                            .update("123.456")
                            .set("Name", "123"),
                        "update object 123.456 set Name = 123"
                            });
        ret.add(new Object[] {
                        EQL2.builder()
                            .with(StmtFlag.TRIGGEROFF)
                            .update("123.456", "789.123")
                            .set("Name", "123"),
                        "with trigger-off update list (123.456, 789.123) set Name = 123"
                            });
        ret.add(new Object[] {
                        EQL2.builder()
                            .with(StmtFlag.TRIGGEROFF, StmtFlag.REQCACHED)
                            .update("123.456", "789.123")
                            .set("Name", "123"),
                        "with trigger-off, request-cached update list (123.456, 789.123) set Name = 123"
                            });
        ret.add(new Object[] {
                        EQL2.builder()
                            .update("123.456", "789.123")
                            .set("Name", "123"),
                        "update list (123.456, 789.123) set Name = 123"
                            });
        return ret.iterator();
    }

    @DataProvider(name = "PrintBuilders")
    public static Iterator<Object[]> printBuilders(final ITestContext _context)
    {
        final List<Object[]> ret = new ArrayList<>();
        ret.add(new Object[] {
                        EQL2.builder()
                            .with(StmtFlag.TRIGGEROFF)
                            .print("123.456")
                            .attribute("Name"),
                        "with trigger-off print object 123.456  select  attribute[Name]"
                            });
        ret.add(new Object[] {
                        EQL2.builder()
                            .with(StmtFlag.TRIGGEROFF, StmtFlag.REQCACHED)
                            .print("123.456")
                            .attribute("Name"),
                        "with trigger-off, request-cached print object 123.456  select  attribute[Name]"
                            });
        ret.add(new Object[] {
                        EQL2.builder()
                            .print("123.456")
                            .attribute("Name"),
                        "print object 123.456  select  attribute[Name]"
                            });
        ret.add(new Object[] {
                        EQL2.builder()
                            .with(StmtFlag.TRIGGEROFF)
                            .print("123.456", "789.123")
                            .attribute("Name"),
                        "with trigger-off print list (123.456, 789.123)  select  attribute[Name]"
                            });
        ret.add(new Object[] {
                        EQL2.builder()
                            .with(StmtFlag.TRIGGEROFF, StmtFlag.REQCACHED)
                            .print("123.456", "789.123")
                            .attribute("Name"),
                        "with trigger-off, request-cached print list (123.456, 789.123)  select  attribute[Name]"
                            });
        ret.add(new Object[] {
                        EQL2.builder()
                            .print("123.456", "789.123")
                            .attribute("Name"),
                        "print list (123.456, 789.123)  select  attribute[Name]"
                            });

        ret.add(new Object[] {
                        EQL2.builder()
                            .print("123.456", "789.123")
                            .select("attribute[Name]"),
                        "print list (123.456, 789.123)  select  attribute[Name]"
                            });

        ret.add(new Object[] {
                        EQL2.builder()
                            .print("123.456", "789.123")
                            .attribute("FirstOne")
                            .select("attribute[SecondOne]"),
                        "print list (123.456, 789.123)  select  attribute[FirstOne],  attribute[SecondOne]"
                            });

        ret.add(new Object[] {
                        EQL2.builder()
                            .print("123.456", "789.123")
                            .select("attribute[FirstOne]")
                            .attribute("SecondOne"),
                        "print list (123.456, 789.123)  select  attribute[FirstOne],  attribute[SecondOne]"
                            });

        ret.add(new Object[] {
                        EQL2.builder()
                            .print("123.456", "789.123")
                            .select("attribute[FirstOne]")
                            .select("attribute[SecondOne]"),
                        "print list (123.456, 789.123)  select  attribute[FirstOne],  attribute[SecondOne]"
                            });


        ret.add(new Object[] {
                        EQL2.builder()
                            .print("123.456", "789.123")
                            .select("attribute[FirstOne]")
                            .select("linkto[Something].attribute[SecondOne]"),
                "print list (123.456, 789.123)  select  attribute[FirstOne],  linkto[Something].attribute[SecondOne]"
                            });

        return ret.iterator();
    }
}
