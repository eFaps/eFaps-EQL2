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
     */
    @Test(description = "query type Sales_Invoice")
    public void oneType()
    {

    }

    /**
     * Two types.
     */
    @Test(description = "query type Sales_Invoice, Contacts_Contact")
    public void twoTypes()
    {

    }

    /**
     * Many types.
     */
    @Test(description = "query type Sales_Invoice, Contacts_Contact, HumanResource_Employee")
    public void manyTypes()
    {
    }

    /**
     * Type with number in name.
     *
     * @throws Exception the exception
     */
    @Test(description = "Type contains a number in the name")
    public void typeWithNumberInName()
        throws Exception
    {
    }

    /**
     * Limit.
     */
    @Test(description = "query with a limit")
    public void limit()
    {
    }

    /**
     * Type UUID.
     */
    @Test(description = "query type 0029a77d-65ca-4564-968c-2ef6adf72033, Contacts_Contact, "
                    + "ce71ffa1-98f2-49b4-b892-246cd407b520, afc188bb-96a6-40ac-a48b-cfba985474c5")
    public void typeUUID()
    {
    }
}
