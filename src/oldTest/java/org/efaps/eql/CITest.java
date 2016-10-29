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

import org.efaps.eql.eQL.CINature;
import org.efaps.eql.eQL.CIPrintPart;
import org.efaps.eql.eQL.Statement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * The Class CITest.
 *
 * @author The eFaps Team
 */
public class CITest
    extends AbstractTest
{

    /**
     * Prints the type test.
     */
    @Test(description = "print ci type Admin _user_Person")
    public void printTypeTest()
    {
        final Statement stmt = getStatement("print ci type Admin_User_Person");
        final CIPrintPart ciPrintPart = stmt.getCiPrintPart();
        Assert.assertNotNull(ciPrintPart);
        Assert.assertEquals(CINature.TYPE, ciPrintPart.getCiNature());
        Assert.assertEquals("Admin_User_Person", ciPrintPart.getCi());
    }

    /**
     * Prints the type test.
     */
    @Test(description = "print ci type Admin _user_Person")
    public void printFormTest()
    {
        final Statement stmt = getStatement("print ci form Admin_User_PersonForm");
        final CIPrintPart ciPrintPart = stmt.getCiPrintPart();
        Assert.assertNotNull(ciPrintPart);
        Assert.assertEquals(CINature.FORM, ciPrintPart.getCiNature());
        Assert.assertEquals("Admin_User_PersonForm", ciPrintPart.getCi());
    }
    /**
     * Prints the type test.
     */
    @Test(description = "print ci type Admin _user_Person")
    public void printFormTestUUID()
    {
        final Statement stmt = getStatement("print ci form f84716ca-fd71-44ff-9907-0493e2165776");
        final CIPrintPart ciPrintPart = stmt.getCiPrintPart();
        Assert.assertNotNull(ciPrintPart);
        Assert.assertEquals(CINature.FORM, ciPrintPart.getCiNature());
        Assert.assertEquals("f84716ca-fd71-44ff-9907-0493e2165776", ciPrintPart.getCi());
    }
}
