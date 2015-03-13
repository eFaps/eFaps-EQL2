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
 * Revision:        $Rev$
 * Last Changed:    $Date$
 * Last Changed By: $Author$
 */
package org.efaps.eql;

import org.efaps.eql.eQL.QueryPart;
import org.efaps.eql.eQL.Statement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * TODO comment!
 *
 * @author The eFaps Team
 * @version $Id: $
 */
public class QueryTest
    extends AbstractTest
{

    @Test()
    public void oneType()
    {
        final Statement stmt = getStatement("query type Sales_Invoice");
        final QueryPart query = stmt.getQueryPart();
        Assert.assertEquals(query.getTypes().get(0), "Sales_Invoice");
    }

    @Test()
    public void twoTypes()
    {
        final Statement stmt = getStatement("query type Sales_Invoice, Contacts_Contact");
        final QueryPart query = stmt.getQueryPart();
        Assert.assertEquals(query.getTypes().get(0), "Sales_Invoice");
        Assert.assertEquals(query.getTypes().get(1), "Contacts_Contact");
    }

    @Test()
    public void manyTypes()
    {
        final Statement stmt = getStatement("query type Sales_Invoice, Contacts_Contact, HumanResource_Employee");
        final QueryPart query = stmt.getQueryPart();
        Assert.assertEquals(query.getTypes().get(0), "Sales_Invoice");
        Assert.assertEquals(query.getTypes().get(1), "Contacts_Contact");
        Assert.assertEquals(query.getTypes().get(2), "HumanResource_Employee");
    }
}
