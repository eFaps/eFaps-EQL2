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
 * The Class CIPrintTest.
 *
 * @author The eFaps Team
 */
public class CIPrintTest
    extends AbstractTest
{
    /**
     * Ci print type.
     */
    @Test(description = "print ci type ")
    public void ciPrintType()
    {
        final IEQLElement stmt = IEqlFactory.eINSTANCE.createCIPrintTypeStatement();
        verifyStatement("print ci type ", stmt);

    }

    /**
     * Ci print type.
     */
    @Test(description = "print ci type EFaps_Type")
    public void ciPrintTypeName()
    {
        final IEQLElement stmt = IEqlFactory.eINSTANCE.createCIPrintTypeStatement().typeName("EFaps_Type");
        verifyStatement("print ci type EFaps_Type", stmt);
    }

    /**
     * Ci print type.
     */
    @Test(description = "print ci type f84716ca-fd71-44ff-9907-0493e2165776")
    public void ciPrintTypeUUID()
    {
        final IEQLElement stmt = IEqlFactory.eINSTANCE.createCIPrintTypeStatement()
                        .typeName("f84716ca-fd71-44ff-9907-0493e2165776");
        verifyStatement("print ci type f84716ca-fd71-44ff-9907-0493e2165776", stmt);
    }

    /**
     * Ci print form.
     */
    @Test(description = "print ci form EFaps_InvoiceForm")
    public void ciPrintFormName()
    {
        final IEQLElement stmt = IEqlFactory.eINSTANCE.createCIPrintFormStatement()
                        .name("EFaps_InvoiceForm");
        verifyStatement("print ci form EFaps_InvoiceForm", stmt);
    }

    /**
     * Ci print form.
     */
    @Test(description = "print ci form f84716ca-fd71-44ff-9907-0493e2165776")
    public void ciPrintFormUUID()
    {
        final IEQLElement stmt = IEqlFactory.eINSTANCE.createCIPrintFormStatement()
                        .name("f84716ca-fd71-44ff-9907-0493e2165776");
        verifyStatement("print ci form f84716ca-fd71-44ff-9907-0493e2165776", stmt);
    }
}
