/*
 * Copyright 2003 - 2015 The eFaps Team
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
 * Revision:        $Rev$
 * Last Changed:    $Date$
 * Last Changed By: $Author$
 */

package org.efaps.eql;

import org.efaps.eql.eQL.ExecPart;
import org.efaps.eql.eQL.Statement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * TODO comment!
 *
 * @author The eFaps Team
 * @version $Id: $
 */
public class ExecTest
    extends AbstractTest
{

    @Test
    public void execEsjp()
    {
        final Statement stmt = getStatement("exec org.efaps.demo.Test");
        final ExecPart exec = stmt.getExecPart();
        Assert.assertEquals(exec.getClassName(), "org.efaps.demo.Test");
    }

    @Test
    public void executeEsjp()
    {
        final Statement stmt = getStatement("execute org.efaps.demo.Test");
        final ExecPart exec = stmt.getExecPart();
        Assert.assertEquals(exec.getClassName(), "org.efaps.demo.Test");
    }

    @Test
    public void execEsjpOneNumericParameter()
    {
        final Statement stmt = getStatement("exec org.efaps.demo.Test 2");
        final ExecPart exec = stmt.getExecPart();
        Assert.assertEquals(exec.getClassName(), "org.efaps.demo.Test");
        Assert.assertEquals(exec.getParameters().get(0), "2");
    }

    @Test
    public void execEsjpTwoNumericParameter()
    {
        final Statement stmt = getStatement("exec org.efaps.demo.Test 2, 44");
        final ExecPart exec = stmt.getExecPart();
        Assert.assertEquals(exec.getClassName(), "org.efaps.demo.Test");
        Assert.assertEquals(exec.getParameters().toArray(), new String[] {"2", "44"});
    }

    @Test
    public void execEsjpManyNumericParameter()
    {
        final Statement stmt = getStatement("exec org.efaps.demo.Test 2, 44, 4, 567");
        final ExecPart exec = stmt.getExecPart();
        Assert.assertEquals(exec.getClassName(), "org.efaps.demo.Test");
        Assert.assertEquals(exec.getParameters().toArray(), new String[] {"2", "44", "4", "567"});

    }

    @Test
    public void execEsjpParameters2()
    {
        getStatement("exec org.efaps.demo.Test \"Param1 with space\", 24");

    }

    @Test
    public void execEsjpParameters3()
    {
        getStatement("exec org.efaps.demo.Test \"Param1 with space\", \"ABCDE\"");


    }

    @Test
    public void execEsjpMapping()
    {
        getStatement("exec org.efaps.demo.Test select 1 as Key");


    }

    @Test
    public void execEsjpMapping1()
    {
        getStatement("exec org.efaps.demo.Test select 1 as Key, 5 as Demo");

    }

    @Test
    public void execEsjpParametersMapping()
    {
        getStatement("exec org.efaps.demo.Test \"Param1 with space\", \"ABCDE\" select 1 as Key");


    }

    @Test
    public void execEsjpParametersMapping2()
    {
        getStatement("exec org.efaps.demo.Test \"Param1 with space\", \"ABCDE\" select 1 as Key, 2 as Demo");


    }
}
