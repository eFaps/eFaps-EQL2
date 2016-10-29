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
 * The Class BaseStatementTest.
 *
 * @author The eFaps Team
 */
public class BaseStatementTest
    extends AbstractTest
{

    /**
     * Object update.
     */
    @Test(description = "update obj")
    public void objectUpdate()
    {
        final Statement stmt = EqlFactory.eINSTANCE.createObjectUpdateStatement();
        verifyStatement("update obj", stmt);
        verifyStatement("update object", stmt);
    }

    /**
     * Object delete.
     */
    @Test(description = "delete obj")
    public void objectDelete()
    {
        final Statement stmt = EqlFactory.eINSTANCE.createObjectDeleteStatement();
        verifyStatement("delete obj", stmt);
        verifyStatement("delete object", stmt);
    }

    /**
     * Insert.
     */
    @Test(description = "insert type")
    public void insert()
    {
        final Statement stmt = EqlFactory.eINSTANCE.createInsertStatement();
        verifyStatement("insert type", stmt);
    }

    /**
     * Exec.
     */
    @Test(description = "exec | execute")
    public void exec()
    {
        final Statement stmt = EqlFactory.eINSTANCE.createExecStatement();
        verifyStatement("exec ", stmt);
        verifyStatement("execute ", stmt);
    }


    /**
     * Ci print type.
     */
    @Test(description = "print ci form")
    public void ciPrintType()
    {
        final Statement stmt = EqlFactory.eINSTANCE.createCIPrintTypeStatement();
        verifyStatement("print ci type", stmt);

    }

    /**
     * Ci print form.
     */
    @Test(description = "print ci form")
    public void ciPrintForm()
    {
        final Statement stmt = EqlFactory.eINSTANCE.createCIPrintFormStatement();
        verifyStatement("print ci form", stmt);

    }
}
