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
package org.efaps.eql2.bldr;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.efaps.eql2.AbstractTest;
import org.efaps.eql2.EQL2;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/**
 * The Class PrintQueryTest.
 */
public class PrintQueryTest
    extends AbstractTest
{

    @Test(dataProvider = "Builders")
    public void testBuilders(final AbstractEQLBuilder<?> _builder, final String _stmt) {
        assertEquals(_builder.build(), _stmt);
    }

    @DataProvider(name = "Builders")
    public static Iterator<Object[]> builders(final ITestContext _context)
    {
        final List<Object[]> ret = new ArrayList<>();
        ret.add(new Object[] {
                        EQL2.builder()
                            .print()
                            .query("Sales_Document")
                            .select()
                            .attribute("Name"),
                        "print  query type Sales_Document  select  attribute[Name]"
                            });
        ret.add(new Object[] {
                        EQL2.builder()
                            .print()
                            .query("Sales_Document, Product_Product")
                            .select()
                            .attribute("Name"),
                        "print  query type Sales_Document, Product_Product  select  attribute[Name]"
                            });
        ret.add(new Object[] {
                        EQL2.builder()
                            .print()
                            .query("Sales_Document, Product_Product")
                            .select()
                            .attribute("attr1", "attr2"),
                        "print  query type Sales_Document, Product_Product  select  attribute[attr1],  attribute[attr2]"
                            });
        ret.add(new Object[] {
                        EQL2.builder()
                            .print()
                                .query("Sales_Document")
                                    .where()
                                    .attribute("Attri").eq(12)
                            .select()
                            .attribute("Name"),
                        "print  query type Sales_Document where   attribute[Attri] == 12  select  attribute[Name]"
                            });
        ret.add(new Object[] {
                        EQL2.builder()
                            .print()
                                .query("Sales_Document")
                                    .where()
                                    .attribute("Attri").isNull()
                            .select()
                            .attribute("Name"),
                        "print  query type Sales_Document where   attribute[Attri] is null  select  attribute[Name]"
                            });
        ret.add(new Object[] {
                        EQL2.builder()
                            .print()
                                .query("Sales_Document")
                                    .where()
                                    .attribute("Attri").notIsNull()
                            .select()
                            .attribute("Name"),
                        "print  query type Sales_Document where   attribute[Attri] not is null  select  attribute[Name]"
                            });
        ret.add(new Object[] {
                        EQL2.builder()
                            .print()
                                .query("Sales_Document")
                                    .where()
                                    .attribute("Attri").in(
                                                    EQL2.builder().nestedQuery("SubType")
                                                    )
                            .select()
                            .attribute("Name"),
                        "print  query type Sales_Document where   attribute[Attri] in(  query type SubType )"
                        + "  select  attribute[Name]"
                            });

        ret.add(new Object[] {
                        EQL2.builder()
                            .print()
                                .query("Sales_Document")
                                    .where()
                                    .attribute("Attri").in(
                                                    EQL2.builder().nestedQuery("SubType")
                                                        .where()
                                                        .attr("SubAttribut").eq(333)
                                                        .up()
                                                    )
                            .select()
                            .attribute("Name"),
                        "print  query type Sales_Document where   attribute[Attri] in("
                        + "  query type SubType where   attribute[SubAttribut] == 333 )  select  attribute[Name]"
                            });

        ret.add(new Object[] {
                        EQL2.builder()
                            .print()
                                .query("Sales_Document")
                                    .where()
                                    .attribute("Attri").in(
                                                    EQL2.builder().nestedQuery("SubType")
                                                        .where()
                                                        .attr("SubAttribut").eq(333)
                                                        .up()
                                                        .selectable(AbstractSelectables.attribute("OneAttr"))
                                                    )
                            .select()
                            .attribute("Name"),
                        "print  query type Sales_Document where   attribute[Attri] in("
                        + "  query type SubType where   attribute[SubAttribut] == 333 select  attribute[OneAttr] )  "
                        + "select  attribute[Name]"
                            });

        ret.add(new Object[] {
                        EQL2.builder()
                            .print()
                                .query("Sales_Document")
                                    .where()
                                    .linkto("LinktoAttr").attr("Attr2").eq(13)
                            .select()
                            .attribute("Name"),
                        "print  query type Sales_Document where   linkto[LinktoAttr].attribute[Attr2] == 13  "
                        + "select  attribute[Name]"
                            });

        ret.add(new Object[] {
                        EQL2.builder()
                            .print()
                                .query("Sales_Document")
                                    .where()
                                    .attribute("Attr1").eq(12)
                                    .and()
                                    .linkto("LinktoAttr").attr("Attr2").eq(13)
                            .select()
                            .attribute("Name"),
                        "print  query type Sales_Document where   attribute[Attr1] == 12 and "
                        + "linkto[LinktoAttr].attribute[Attr2] == 13  select  attribute[Name]"
                            });

        return ret.iterator();
    }
}
