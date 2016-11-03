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
        final IEQLElement stmt = IEqlFactory.eINSTANCE.createInsertStatement().typeName("EFaps_Type");
        verifyStatement("insert type EFaps_Type", stmt);
    }

    /**
     * Sets the attr num.
     */
    @Test(description = "insert type TYPE set ATTR=NUM")
    public void setAttrNum()
    {
        final IEQLElement stmt = IEqlFactory.eINSTANCE.createInsertStatement().typeName("EFaps_Type")
                        .update("Number", "2333");
        verifyStatement("insert type EFaps_Type set Number = 2333", stmt);
    }

    /**
     * Sets the many attr num.
     */
    @Test(description = "insert type TYPE  set ATTR=NUM,ATTR=NUM,ATTR=NUM")
    public void setManyAttrNum()
    {
        final IEQLElement stmt = IEqlFactory.eINSTANCE.createInsertStatement().typeName("EFaps_Type")
                        .update("Number", "2333").update("Number2", "111").update("Number3", "333");
        verifyStatement("insert type EFaps_Type set Number = 2333, Number2 = 111, Number3 = 333", stmt);
    }

    /**
     * Sets the attr str.
     */
    @Test(description = "insert type TYPE set ATTR=STR")
    public void setAttrStr()
    {
        final IEQLElement stmt = IEqlFactory.eINSTANCE.createInsertStatement().typeName("EFaps_Type")
                        .update("Name", "Hallo Welt");
        verifyStatement("insert type EFaps_Type set Name = \"Hallo Welt\"", stmt);
    }

    /**
     * Sets the many attr str.
     */
    @Test(description = "insert type TYPE set ATTR=Str, ATRR=STR2")
    public void setManyAttrStr()
    {
        final IEQLElement stmt = IEqlFactory.eINSTANCE.createInsertStatement().typeName("EFaps_Type")
                        .update("Name", "Hallo Welt").update("Name2", "Hallo Welt2");
        verifyStatement("insert type EFaps_Type set Name = \"Hallo Welt\", Name2 = \"Hallo Welt2\"", stmt);
    }

    /**
     * Sets the many attr str.
     */
    @Test(description = "insert type TYPE set ATTR=Str, Attr=Num, ATRR=STR2")
    public void setManyAttrMixed()
    {
        final IEQLElement stmt = IEqlFactory.eINSTANCE.createInsertStatement().typeName("EFaps_Type")
                        .update("Name", "Hallo Welt").update("Number", "333").update("Name2", "Hallo Welt2");
        verifyStatement("insert type EFaps_Type set Name = \"Hallo Welt\", "
                        + "Number = 333, Name2 = \"Hallo Welt2\"", stmt);
    }
}
