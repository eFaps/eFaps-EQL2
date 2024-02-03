/*
 * Copyright © 2003 - 2024 The eFaps Team (-)
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
 */
package org.efaps.eql2;

import java.util.List;

import org.testng.annotations.Test;

/**
 * The Class InsertTest.
 *
 * @author The eFaps Team
 */
public class InsertTest
    extends AbstractTest
{
    /**
     * Insert.
     */
    @Test(description = "insert type EFaps_Type")
    public void insert()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createInsertStatement().typeName("EFaps_Type");
        verifyStatement("insert type EFaps_Type", stmt);
    }

    /**
     * Sets the attr num.
     */
    @Test(description = "insert type TYPE set ATTR=NUM")
    public void setAttrNum()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createInsertStatement().typeName("EFaps_Type")
                        .addUpdateElements(IEql2Factory.eINSTANCE.createUpdateElement()
                                        .attribute("Number").value("2333"));
        verifyStatement("insert type EFaps_Type set Number = 2333", stmt);
    }

    /**
     * Sets the many attr num.
     */
    @Test(description = "insert type TYPE  set ATTR=NUM,ATTR=NUM,ATTR=NUM")
    public void setManyAttrNum()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createInsertStatement().typeName("EFaps_Type")
                        .update("Number", "2333").update("Number2", "111").update("Number3", "333");
        verifyStatement("insert type EFaps_Type set Number = 2333, Number2 = 111, Number3 = 333", stmt);
    }

    /**
     * Sets the attr str.
     */
    @Test(description = "insert type TYPE set ATTR=STR")
    public void setAttrStr()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createInsertStatement().typeName("EFaps_Type")
                        .update("Name", "Hallo Welt");
        verifyStatement("insert type EFaps_Type set Name = \"Hallo Welt\"", stmt);
    }


    @Test(description = "insert type TYPE set ATTR=ARRAY (with one value)")
    public void setAttrArrayOne()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createInsertStatement().typeName("EFaps_Type")
                        .update("Rate", "1");
        verifyStatement("insert type EFaps_Type set Rate = [1]", stmt);
    }

    @Test(description = "insert type TYPE set ATTR=ARRAY (with 3 values)")
    public void setAttrArrayMany()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createInsertStatement().typeName("EFaps_Type")
                        .addUpdateElements(IEql2Factory.eINSTANCE.createUpdateElement()
                                        .attribute("Rate").value(List.<String>of("1", "2", "3")));
        verifyStatement("insert type EFaps_Type set Rate = [1,2,3]", stmt);
    }

    @Test(description = "insert type TYPE set ATTR=ARRAY (with 3 values)")
    public void setAttributeArrayMany()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createInsertStatement().typeName("EFaps_Type")
                        .addUpdateElements(IEql2Factory.eINSTANCE.createUpdateElement()
                                        .attribute("Rate").value(List.<String>of("1", "2", "3")));
        verifyStatement("insert type EFaps_Type set attribute[Rate] = [1,2,3]", stmt);
    }

    /**
     * Sets the many attr str.
     */
    @Test(description = "insert type TYPE set ATTR=Str, ATRR=STR2")
    public void setManyAttrStr()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createInsertStatement().typeName("EFaps_Type")
                        .update("Name", "Hallo Welt").update("Name2", "Hallo Welt2");
        verifyStatement("insert type EFaps_Type set Name = \"Hallo Welt\", Name2 = \"Hallo Welt2\"", stmt);
    }


    @Test(description = "insert type TYPE set ATTR=Str, ATRR=STR2")
    public void setManyAttributeStr()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createInsertStatement().typeName("EFaps_Type")
                        .update("Name", "Hallo Welt").update("Name2", "Hallo Welt2");
        verifyStatement("insert type EFaps_Type set Name = \"Hallo Welt\", attribute[Name2] = \"Hallo Welt2\"", stmt);
    }

    /**
     * Sets the many attr str.
     */
    @Test(description = "insert type TYPE set ATTR=Str, Attr=Num, ATRR=STR2")
    public void setManyAttrMixed()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createInsertStatement().typeName("EFaps_Type")
                        .update("Name", "Hallo Welt")
                        .update("Number", "333")
                        .addUpdateElements(IEql2Factory.eINSTANCE.createUpdateElement()
                                        .attribute("Array").value(List.<String>of("Val1", "2", "3")))
                        .update("Name2", "Hallo Welt2");
        verifyStatement("insert type EFaps_Type set Name = \"Hallo Welt\", "
                        + "Number = 333, Array = [ \"Val1\",  2,  3], Name2 = \"Hallo Welt2\"", stmt);
    }

    @Test(description = "with trigger-off insert type EFaps_Type set Number = 2333")
    public void setAttrWithFlag()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createInsertStatement()
                        .addFlag(StmtFlag.TRIGGEROFF)
                        .typeName("EFaps_Type")
                        .update("Number", "2333");
        verifyStatement("with trigger-off insert type EFaps_Type set Number = 2333", stmt);
    }

    @Test(description = "with trigger-off, request-cached, company-independent insert type EFaps_Type set Number = 2333")
    public void setAttrWithFlags()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createInsertStatement()
                        .addFlag(StmtFlag.TRIGGEROFF)
                        .addFlag(StmtFlag.REQCACHED)
                        .addFlag(StmtFlag.COMPANYINDEPENDENT)
                        .typeName("EFaps_Type")
                        .update("Number", "2333");
        verifyStatement("with trigger-off, request-cached, company-independent insert type EFaps_Type set Number = 2333", stmt);
    }
}
