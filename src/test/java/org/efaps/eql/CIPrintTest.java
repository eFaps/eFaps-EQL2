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
        final Statement stmt = EqlFactory.eINSTANCE.createCIPrintTypeStatement();
        verifyStatement("print ci type ", stmt);

    }

    /**
     * Ci print form.
     */
    @Test(description = "print ci form EFaps_InvoiceForm")
    public void ciPrintForm()
    {
        final Statement stmt = EqlFactory.eINSTANCE.createCIPrintFormStatement().setNameC("EFaps_InvoiceForm");
        verifyStatement("print ci form EFaps_InvoiceForm", stmt);
    }
}
