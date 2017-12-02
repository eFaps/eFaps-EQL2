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
package org.efaps.eql2.ide.contentassist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.efaps.eql2.AbstractTest;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * The Class ContentTest.
 *
 * @author The eFaps Team
 */
public class ContentTest
    extends AbstractTest
{

    /**
     * Setup ci name provier.
     */
    @BeforeClass
    public void setupCINameProvier()
    {
        EQLProposals.registerCINameProviders(new ICINameProvider()
        {

            @Override
            public Set<String> getTypeNames()
            {
                final Set<String> ret = new HashSet<>();
                ret.add("Sales_Invoice");
                ret.add("Sales_Receipt");
                ret.add("Contacts_Contact");
                return ret;
            }
        });
    }

    /**
     * Test.
     *
     * @param _partial the partial
     * @param _expected the expected
     * @throws Exception the exception
     */
    @Test(dataProvider = "DataProvider", description = "print ")
    public void proposals(final String _partial,
                          final List<String> _expected)
        throws Exception
    {
        final List<String> proposals = EQLProposals.getProposalList(_partial);
        Assert.assertEqualsNoOrder(proposals.toArray(), _expected.toArray());
    }

    /**
     * Data provider.
     *
     * @param _context the context
     * @return the iterator< object[]>
     */
    @DataProvider(name = "DataProvider")
    public static Iterator<Object[]> dataProvider(final ITestContext _context)
    {
        final List<Object[]> ret = new ArrayList<>();
        ret.add(new Object[] { "print ", Arrays.asList(new String[] { "ci", "obj", "object", "list", "query" }) });

        ret.add(new Object[] { "print obj ", Arrays.asList(new String[] { "132.456" }) });

        ret.add(new Object[] { "print obj 123.456 ", Arrays.asList(new String[] { "select" }) });

        ret.add(new Object[] { "print obj 123.456 select ", Arrays.asList(new String[] { "value", "attribute[",
                        "attributeset[", "base", "class", "class[", "exec", "execute", "file", "id",
                        "instance", "key", "label", "length", "linkfrom[", "linkto[", "name",
                        "oid", "status", "type", "uom", "uuid", "value" }) });

        ret.add(new Object[] { "print obj 123.456 select attribute[Attribute]",
                        Arrays.asList(new String[] { "as", "order", ",", ".", "]" }) });

        ret.add(new Object[] { "print obj 123.456 select attribute[Attribute] as ",
                        Arrays.asList(new String[] { }) });

        ret.add(new Object[] { "print obj 123.456 select attribute[Attribute]. ",
                        Arrays.asList(new String[] { "value", "attribute[",
                                        "attributeset[", "base", "class", "class[", "exec", "execute", "file", "id",
                                        "instance", "key", "label", "length", "linkfrom[", "linkto[", "name",
                                        "oid", "status", "type", "uom", "uuid", "value" }) });

        ret.add(new Object[] { "print query ",
                        Arrays.asList(new String[] { "type" }) });

        ret.add(new Object[] { "print query type ",
                        Arrays.asList(new String[] { "CITYPE" }) });

        ret.add(new Object[] { "print query type S",
                        Arrays.asList(new String[] { "Sales_Invoice", "Sales_Receipt", "," }) });

        ret.add(new Object[] { "print query type C",
                        Arrays.asList(new String[] { "Contacts_Contact", "," }) });
        return ret.iterator();
    }
}
