/*
 * Copyright 2003 - 2015 The eFaps Team
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
package org.efaps.eql.ui.contentassist;

import java.util.List;

import org.efaps.eql.AbstractTest;
import org.testng.Assert;
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
     * Test.
     *
     * @throws Exception the exception
     */
    @Test(description = "delete")
    public void delete()
        throws Exception
    {
        final List<String> proposals = EQLProposals.getProposalList("delete");
        Assert.assertEqualsNoOrder(proposals.toArray(), new String[] { "111.222", "obj", "object", "list", "query" },
                        "Different");
    }

    /**
     * Test.
     *
     * @throws Exception the exception
     */
    @Test(description = "update")
    public void update()
        throws Exception
    {
        final List<String> proposals = EQLProposals.getProposalList("update");
        Assert.assertEqualsNoOrder(proposals.toArray(), new String[] { "111.222", "obj", "object", "list", "query" },
                        "Different");
    }

    /**
     * Test.
     *
     * @throws Exception the exception
     */
    @Test(description = "insert")
    public void insert()
        throws Exception
    {
        final List<String> proposals = EQLProposals.getProposalList("insert");
        Assert.assertEqualsNoOrder(proposals.toArray(), new String[] { "type" },
                        "Different");
    }

    /**
     * Test.
     *
     * @throws Exception the exception
     */
    @Test(description = "insert type ")
    public void insertType()
        throws Exception
    {
        final List<String> proposals = EQLProposals.getProposalList("insert type ");
        Assert.assertEqualsNoOrder(proposals.toArray(), new String[] { "TYPE" },
                        "Different");
    }

    /**
     * Test.
     *
     * @throws Exception the exception
     */
    @Test(description = "insert type Sales_Invoice")
    public void insertTypeTYPE()
        throws Exception
    {
        final List<String> proposals = EQLProposals.getProposalList("insert type Sales_Invoice ");
        Assert.assertEqualsNoOrder(proposals.toArray(), new String[] { "set" },
                        "Different");
    }

    /**
     * Test.
     *
     * @throws Exception the exception
     */
    @Test(description = "insert type Sales_Invoice set ")
    public void insertTypeTYPEset()
        throws Exception
    {
        final List<String> proposals = EQLProposals.getProposalList("insert type Sales_Invoice set ");
        Assert.assertEqualsNoOrder(proposals.toArray(), new String[] { "ATTRIBUTE" },
                        "Different");
    }

    /**
     * Test.
     *
     * @throws Exception the exception
     */
    @Test(description = "print")
    public void print()
        throws Exception
    {
        final List<String> proposals = EQLProposals.getProposalList("print");
        Assert.assertEqualsNoOrder(proposals.toArray(), new String[] { "111.222" },
                        "Different");
    }
}
