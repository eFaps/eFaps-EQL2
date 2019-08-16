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
package org.efaps.eql2;

import org.testng.annotations.Test;

/**
 * The Class DeleteTest.
 *
 * @author The eFaps Team
 */
public class DeleteTest
    extends AbstractTest
{

    /**
     * Object delete.
     */
    @Test(description = "delete obj 123.456")
    public void obj()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createDeleteObjectStatement().setOidC("123.456");
        verifyStatement("delete obj 123.456", stmt);
        verifyStatement("delete object 123.456", stmt);
    }

    /**
     * Object delete.
     */
    @Test(description = "delete list (123.456, 789.456, 456.123)")
    public void list()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createDeleteListStatement()
                        .addOid("123.456").addOid("789.456").addOid("456.123");
        verifyStatement("delete list (123.456, 789.456, 456.123)", stmt);
    }

    @Test(description = "with trigger-off delete obj 123.456")
    public void objWithFlag()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createDeleteObjectStatement()
                        .addFlag(Flag.TRIGGEROFF)
                        .setOidC("123.456");
        verifyStatement("with trigger-off delete obj 123.456", stmt);
        verifyStatement("with trigger-off delete object 123.456", stmt);
    }

    @Test(description = "with trigger-off, request-cached, company-independent delete obj 123.456")
    public void objWithFlags()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createDeleteObjectStatement()
                        .addFlag(Flag.TRIGGEROFF)
                        .addFlag(Flag.REQCACHED)
                        .addFlag(Flag.COMPANYINDEPENDENT)
                        .setOidC("123.456");
        verifyStatement("with trigger-off, request-cached, company-independent delete obj 123.456", stmt);
        verifyStatement("with trigger-off, request-cached, company-independent delete object 123.456", stmt);
    }

    @Test(description = "with trigger-off delete list (123.456, 789.456, 456.123)")
    public void listWithFlag()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createDeleteListStatement()
                        .addFlag(Flag.TRIGGEROFF)
                        .addOid("123.456")
                        .addOid("789.456")
                        .addOid("456.123");
        verifyStatement("with trigger-off delete list (123.456, 789.456, 456.123)", stmt);
    }

    @Test(description = "with trigger-off, request-cached, company-independent delete list (123.456, 789.456, 456.123)")
    public void listWithFlags()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createDeleteListStatement()
                        .addFlag(Flag.TRIGGEROFF)
                        .addFlag(Flag.REQCACHED)
                        .addFlag(Flag.COMPANYINDEPENDENT)
                        .addOid("123.456")
                        .addOid("789.456")
                        .addOid("456.123");
        verifyStatement("with trigger-off, request-cached, company-independent delete list (123.456, 789.456, 456.123)", stmt);
    }

}
