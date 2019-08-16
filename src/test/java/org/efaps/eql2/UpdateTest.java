/*
 * Copyright 2003 - 2019 The eFaps Team
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
 * The Class UpdateTest.
 *
 * @author The eFaps Team
 */
public class UpdateTest
    extends AbstractTest
{
    /**
     * Object update.
     */
    @Test(description = "obj")
    public void objectUpdate()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createUpdateObjectStatement();
        verifyStatement("update obj", stmt);
        verifyStatement("update object", stmt);
    }

    /**
     * Update.
     *
     * @throws Exception the exception
     */
    @Test(description = "obj 124.879")
    public void update()
        throws Exception
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createUpdateObjectStatement().oid("124.879");
        verifyStatement("update obj 124.879", stmt);
        verifyStatement("update object 124.879", stmt);
    }

    /**
     * Sets the attr num.
     *
     * @throws Exception the exception
     */
    @Test(description = "obj 124.879 set ATTR=NUM")
    public void setAttrNum()
        throws Exception
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createUpdateObjectStatement().oid("124.879")
                        .update("Name", "1234");
        verifyStatement("update obj 124.879 set Name=1234", stmt);
        verifyStatement("update object 124.879 set Name=1234", stmt);
    }

    /**
     * Sets the many attr num.
     *
     * @throws Exception the exception
     */
    @Test(description = "obj 124.879 set ATTR=NUM, ATTR=NUM, ATTR=NUM")
    public void setManyAttrNum()
        throws Exception
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createUpdateObjectStatement().oid("124.879")
                        .update("Num1", "1234") .update("Num2", "567") .update("Num3", "89");
        verifyStatement("update obj 124.879 set Num1=1234, Num2=567, Num3=89", stmt);
        verifyStatement("update object 124.879 set Num1=1234, Num2=567, Num3=89", stmt);
    }

    /**
     * Sets the attr str.
     *
     * @throws Exception the exception
     */
    @Test(description = "update 124.879 set ATTR=STR")
    public void setAttrStr()
        throws Exception
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createUpdateObjectStatement().oid("124.879")
                        .update("Code", "Hallo Welt");
        verifyStatement("update obj 124.879 set Code=\"Hallo Welt\"", stmt);
    }

    /**
     * Sets the many attr str.
     *
     * @throws Exception the exception
     */
    @Test(description = "update 124.879 set ATTR=Str, ATRR=STR2")
    public void setManyAttrStr()
        throws Exception
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createUpdateObjectStatement().oid("124.879")
                        .update("Code", "Hallo Welt").update("Code2", "Hallo Welt 2");
        verifyStatement("update obj 124.879 set Code=\"Hallo Welt\", Code2=\"Hallo Welt 2\"", stmt);
    }

    /**
     * Sets the list attr num.
     *
     * @throws Exception the exception
     */
    @Test(description = "update LIST set ATTR=NUM")
    public void setListAttrNum()
        throws Exception
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createUpdateListStatement().addOid("124.879")
                        .update("Code", "11");
        verifyStatement("update list (124.879) set Code=11", stmt);
    }

    /**
     * Sets the list many attr num.
     *
     * @throws Exception the exception
     */
    @Test(description = "update LIST set ATTR=NUM")
    public void setListManyAttrNum()
        throws Exception
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createUpdateListStatement().addOid("124.879")
                        .addOid("546.234").addOid("646.77")
                        .update("Code", "11");
        verifyStatement("update list (124.879, 546.234, 646.77) set Code=11", stmt);
    }

    /**
     * Sets the list many attr num.
     *
     * @throws Exception the exception
     */
    @Test(description = "update LIST set ATTR=Str,Attr=Num")
    public void setListManyAttrStrNum()
        throws Exception
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createUpdateListStatement().addOid("124.879")
                        .addOid("546.234").addOid("646.77")
                        .update("Code", "Blue Shoes") .update("Code2", "33");
        verifyStatement("update list (124.879, 546.234, 646.77) set Code=\"Blue Shoes\", Code2 = 33", stmt);
    }

    /**
     * Query set attr num.
     *
     * @throws Exception the exception
     */
    @Test(description = "update QUERY set ATTR=NUM")
    public void querySetAttrNum()
        throws Exception
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createUpdateQueryStatement()
                        .query(IEql2Factory.eINSTANCE.createQuery().addType("EFaps_Type"))
                        .update("Code2", "33");
        verifyStatement("update query type EFaps_Type set Code2 = 33", stmt);
    }

    /**
     * Query where set attr num.
     *
     * @throws Exception the exception
     */
    @Test(description = "update QUERY WHERE set ATTR=NUM")
    public void queryWhereSetAttrNum()
        throws Exception
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createUpdateQueryStatement()
                        .query(IEql2Factory.eINSTANCE.createQuery().addType("EFaps_Type")
                            .where(IEql2Factory.eINSTANCE.createWhere()
                                .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                                    .element(IEql2Factory.eINSTANCE.createWhereElement()
                                                    .attribute("Name").equal().value("3")))))
                        .update("Code2", "33");
        verifyStatement("update query type EFaps_Type where Name == 3 set Code2 = 33", stmt);
    }

    /**
     * Sets the attribute with hyphen.
     *
     * @throws Exception the exception
     */
    @Test(description = "update obj 5710.4137 set Name = \"001-064056\"")
    public void setAttributeWithHyphen()
        throws Exception
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createUpdateObjectStatement().oid("5710.4137")
                        .update("Name", "001-064056");
        verifyStatement("update obj 5710.4137 set Name = \"001-064056\"", stmt);
    }

    @Test(description = "with trigger-off update obj 124.879 set Name=1234")
    public void objWithFlag()
        throws Exception
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createUpdateObjectStatement()
                        .addFlag(StmtFlag.TRIGGEROFF)
                        .oid("124.879")
                        .update("Name", "1234");
        verifyStatement("with trigger-off update obj 124.879 set Name=1234", stmt);
        verifyStatement("with trigger-off update object 124.879 set Name=1234", stmt);
    }

    @Test(description = "with trigger-off, request-cached, company-independent update obj 124.879 set Name=1234")
    public void objWithFlags()
        throws Exception
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createUpdateObjectStatement()
                        .addFlag(StmtFlag.TRIGGEROFF)
                        .addFlag(StmtFlag.REQCACHED)
                        .addFlag(StmtFlag.COMPANYINDEPENDENT)
                        .oid("124.879")
                        .update("Name", "1234");
        verifyStatement("with trigger-off, request-cached, company-independent update obj 124.879 set Name=1234", stmt);
        verifyStatement("with trigger-off, request-cached, company-independent update object 124.879 set Name=1234", stmt);
    }

    @Test(description = "with trigger-off update list (124.879) set Code=11")
    public void listWithFlag()
        throws Exception
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createUpdateListStatement()
                        .addFlag(StmtFlag.TRIGGEROFF)
                        .addOid("124.879")
                        .update("Code", "11");
        verifyStatement("with trigger-off update list (124.879) set Code=11", stmt);
    }

    @Test(description = "with trigger-off, request-cached, company-independent update list (124.879) set Code=11")
    public void listWithFlags()
        throws Exception
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createUpdateListStatement()
                        .addFlag(StmtFlag.TRIGGEROFF)
                        .addFlag(StmtFlag.REQCACHED)
                        .addFlag(StmtFlag.COMPANYINDEPENDENT)
                        .addOid("124.879")
                        .update("Code", "11");
        verifyStatement("with trigger-off, request-cached, company-independent update list (124.879) set Code=11", stmt);
    }

    @Test(description = "with trigger-off update query type EFaps_Type set Code2 = 33")
    public void queryWithFlag()
        throws Exception
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createUpdateQueryStatement()
                        .addFlag(StmtFlag.TRIGGEROFF)
                        .query(IEql2Factory.eINSTANCE.createQuery().addType("EFaps_Type"))
                        .update("Code2", "33");
        verifyStatement("with trigger-off update query type EFaps_Type set Code2 = 33", stmt);
    }

    @Test(description = "with trigger-off, request-cached, company-independent update query type EFaps_Type set Code2 = 33")
    public void queryWithFlags()
        throws Exception
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createUpdateQueryStatement()
                        .addFlag(StmtFlag.TRIGGEROFF)
                        .addFlag(StmtFlag.REQCACHED)
                        .addFlag(StmtFlag.COMPANYINDEPENDENT)
                        .query(IEql2Factory.eINSTANCE.createQuery().addType("EFaps_Type"))
                        .update("Code2", "33");
        verifyStatement("with trigger-off, request-cached, company-independent update query type EFaps_Type set Code2 = 33", stmt);
    }
}
