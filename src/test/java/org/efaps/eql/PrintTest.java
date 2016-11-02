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
 * The Class PrintTest.
 *
 * @author The eFaps Team
 */
public class PrintTest
    extends AbstractTest
{

    /**
     * Object print.
     */
    @Test(description = "print obj")
    public void object()
    {
        final IEQLElement stmt = IEqlFactory.eINSTANCE.createPrintObjectStatement();
        verifyStatement("print obj", stmt);
        verifyStatement("print object", stmt);
    }

    /**
     * Object print.
     */
    @Test(description = "print obj 123.456")
    public void objectOID()
    {
        final IEQLElement stmt = IEqlFactory.eINSTANCE.createPrintObjectStatement().setOidC("123.456");
        verifyStatement("print obj 123.456", stmt);
        verifyStatement("print object 123.456", stmt);
    }

    /**
     * Object print.
     */
    @Test(description = "print obj 123.456 select attribute[Name]")
    public void objectSelection()
    {
        final IEQLElement stmt = IEqlFactory.eINSTANCE.createPrintObjectStatement().setOidC("123.456")
                        .setSelectionC(IEqlFactory.eINSTANCE.createSelection()
                        .addSelect(IEqlFactory.eINSTANCE.createSelect()
                                        .addElement(IEqlFactory.eINSTANCE.createAttributeSelectElement()
                                                        .setNameC("Name"))));
        verifyStatement("print obj 123.456 select attribute[Name]", stmt);
        verifyStatement("print object 123.456 select attribute[Name]", stmt);
    }

    /**
     * List print OID.
     */
    @Test(description = "print list ()")
    public void list()
    {
        final IEQLElement stmt = IEqlFactory.eINSTANCE.createPrintListStatement().addOid(null);
        verifyStatement("print list ()", stmt);
    }

    /**
     * List print OID.
     */
    @Test(description = "print list (123.456)")
    public void listOID()
    {
        final IEQLElement stmt = IEqlFactory.eINSTANCE.createPrintListStatement().addOid("123.456");
        verifyStatement("print list (123.456)", stmt);
    }

    /**
     * List print OIDs.
     */
    @Test(description = "print list (123.456, 223.456, 323.456)")
    public void listOIDs()
    {
        final IEQLElement stmt = IEqlFactory.eINSTANCE.createPrintListStatement().addOid("123.456").addOid("223.456")
                        .addOid("323.456");
        verifyStatement("print list (123.456, 223.456, 323.456)", stmt);
    }

    /**
     * Query.
     */
    @Test(description = "print query type EFaps_Type")
    public void query()
    {
        final IEQLElement stmt = IEqlFactory.eINSTANCE.createPrintQueryStatement()
                    .setQueryC(IEqlFactory.eINSTANCE.createQuery().addType("EFaps_Type"));
        verifyStatement("print query type EFaps_Type", stmt);
    }

    /**
     * Query attribute.
     */
    @Test(description = "print query type EFaps_Type select attribute[Name]")
    public void queryAttribute()
    {
        final IEQLElement stmt = IEqlFactory.eINSTANCE.createPrintQueryStatement()
                    .setQueryC(IEqlFactory.eINSTANCE.createQuery().addType("EFaps_Type"))
                    .setSelectionC(IEqlFactory.eINSTANCE.createSelection()
                        .addSelect(IEqlFactory.eINSTANCE.createSelect()
                            .addElement(IEqlFactory.eINSTANCE.createAttributeSelectElement().setNameC("Name"))));
        verifyStatement("print query type EFaps_Type select attribute[Name]", stmt);
    }

    /**
     * List print OIDs.
     */
    @Test(description = "print list (123.456, 223.456, 323.456) select attribute[Name] ")
    public void listOIDSelection()
    {
        final IEQLElement stmt = IEqlFactory.eINSTANCE.createPrintListStatement().addOid("123.456").addOid("223.456")
                        .addOid("323.456").setSelectionC(IEqlFactory.eINSTANCE.createSelection().addSelect(
                                        IEqlFactory.eINSTANCE.createSelect().addElement(IEqlFactory.eINSTANCE
                                                        .createAttributeSelectElement().setNameC("Name"))));
        verifyStatement("print list (123.456, 223.456, 323.456) select attribute[Name] ", stmt);
    }
}
