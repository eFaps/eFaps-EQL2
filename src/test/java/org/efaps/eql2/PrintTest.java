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
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintObjectStatement();
        verifyStatement("print obj", stmt);
        verifyStatement("print object", stmt);
    }

    /**
     * Object print.
     */
    @Test(description = "print obj 123.456")
    public void objectOID()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintObjectStatement().setOidC("123.456");
        verifyStatement("print obj 123.456", stmt);
        verifyStatement("print object 123.456", stmt);
    }

    /**
     * Object print.
     */
    @Test(description = "print obj 123.456 select attribute[Name]")
    public void objectSelection()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintObjectStatement().setOidC("123.456")
                        .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                        .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                        .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement()
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
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintListStatement().addOid(null);
        verifyStatement("print list ()", stmt);
    }

    /**
     * List print OID.
     */
    @Test(description = "print list (123.456)")
    public void listOID()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintListStatement().addOid("123.456");
        verifyStatement("print list (123.456)", stmt);
    }

    /**
     * List print OIDs.
     */
    @Test(description = "print list (123.456, 223.456, 323.456)")
    public void listOIDs()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintListStatement().addOid("123.456").addOid("223.456")
                        .addOid("323.456");
        verifyStatement("print list (123.456, 223.456, 323.456)", stmt);
    }

    /**
     * Query.
     */
    @Test(description = "print query type EFaps_Type")
    public void query()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintQueryStatement()
                    .setQueryC(IEql2Factory.eINSTANCE.createQuery().addType("EFaps_Type"));
        verifyStatement("print query type EFaps_Type", stmt);
    }

    /**
     * Query attribute.
     */
    @Test(description = "print query type EFaps_Type select attribute[Name]")
    public void queryAttribute()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintQueryStatement()
                    .setQueryC(IEql2Factory.eINSTANCE.createQuery().addType("EFaps_Type"))
                    .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                        .addSelect(IEql2Factory.eINSTANCE.createSelect()
                            .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("Name"))));
        verifyStatement("print query type EFaps_Type select attribute[Name]", stmt);
    }

    /**
     * List print OIDs.
     */
    @Test(description = "print list (123.456, 223.456, 323.456) select attribute[Name] ")
    public void listOIDSelection()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintListStatement().addOid("123.456").addOid("223.456")
                        .addOid("323.456").setSelectionC(IEql2Factory.eINSTANCE.createSelection().addSelect(
                                        IEql2Factory.eINSTANCE.createSelect().addElement(IEql2Factory.eINSTANCE
                                                        .createAttributeSelectElement().setNameC("Name"))));
        verifyStatement("print list (123.456, 223.456, 323.456) select attribute[Name] ", stmt);
    }

    @Test(description = "with trigger-off print obj 123.456 select attribute[Name]")
    public void objectWithFlag()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintObjectStatement()
                        .addFlag(Flag.TRIGGEROFF)
                        .oid("123.456")
                        .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                                        .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                        .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement()
                                        .setNameC("Name"))));

        verifyStatement("with trigger-off print obj 123.456 select attribute[Name]", stmt);
    }

    @Test(description = "with trigger-off, request-cached, company-independent print obj 123.456 select attribute[Name]")
    public void objectWithFlags()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintObjectStatement()
                        .addFlag(Flag.TRIGGEROFF)
                        .addFlag(Flag.REQCACHED)
                        .addFlag(Flag.COMPANYINDEPENDENT)
                        .oid("123.456")
                        .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                                        .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                        .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement()
                                        .setNameC("Name"))));

        verifyStatement("with trigger-off, request-cached, company-independent print obj 123.456 select attribute[Name]", stmt);
    }

    @Test(description = "with trigger-off print list (123.456, 223.456, 323.456) select attribute[Name]")
    public void listWithFlag()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintListStatement()
                        .addFlag(Flag.TRIGGEROFF)
                        .addOid("123.456")
                        .addOid("223.456")
                        .addOid("323.456")
                        .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                                        .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                        .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement()
                                        .setNameC("Name"))));

        verifyStatement("with trigger-off print list (123.456, 223.456, 323.456) select attribute[Name]", stmt);
    }

    @Test(description = "with trigger-off print list (123.456, 223.456, 323.456) select attribute[Name]")
    public void listWithFlags()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintListStatement()
                        .addFlag(Flag.TRIGGEROFF)
                        .addFlag(Flag.REQCACHED)
                        .addFlag(Flag.COMPANYINDEPENDENT)
                        .addOid("123.456")
                        .addOid("223.456")
                        .addOid("323.456")
                        .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                                        .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                        .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement()
                                        .setNameC("Name"))));

        verifyStatement("with trigger-off, request-cached, company-independent print list (123.456, 223.456, 323.456)"
                        + " select attribute[Name]", stmt);
    }

    @Test(description = "with trigger-off print query type EFaps_Type select attribute[Name]")
    public void queryWithFlag()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintQueryStatement()
                    .addFlag(Flag.TRIGGEROFF)
                    .setQueryC(IEql2Factory.eINSTANCE.createQuery().addType("EFaps_Type"))
                    .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                        .addSelect(IEql2Factory.eINSTANCE.createSelect()
                            .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("Name"))));
        verifyStatement("with trigger-off print query type EFaps_Type select attribute[Name]", stmt);
    }

    @Test(description = "with trigger-off, request-cached, company-independent print query type EFaps_Type select attribute[Name]")
    public void queryWithFlags()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintQueryStatement()
                    .addFlag(Flag.TRIGGEROFF)
                    .addFlag(Flag.REQCACHED)
                    .addFlag(Flag.COMPANYINDEPENDENT)
                    .setQueryC(IEql2Factory.eINSTANCE.createQuery().addType("EFaps_Type"))
                    .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                        .addSelect(IEql2Factory.eINSTANCE.createSelect()
                            .addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().setNameC("Name"))));
        verifyStatement("with trigger-off, request-cached, company-independent print query type EFaps_Type select attribute[Name]", stmt);
    }

}
