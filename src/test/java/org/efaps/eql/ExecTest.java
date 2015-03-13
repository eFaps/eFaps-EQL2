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

import org.efaps.eql.eQL.Statement;
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

    public void execEsjp()

    {
        final Statement stmt = getStatement("exec org.efaps.demo.Test");
        System.out.println(stmt);

    }

    @Test
    public void executeEsjp()

    {
        getStatement("execute org.efaps.demo.Test");
    }

    @Test
    public void execEsjpParameter()

    {
        getStatement("exec org.efaps.demo.Test 2");

    }

    @Test
    public void execEsjpParameters()

    {
        final Statement stmt = getStatement("exec org.efaps.demo.Test 2, 44");
        System.out.println(stmt);

    }

    @Test
    public void execEsjpParameters2()

    {
        getStatement("exec org.efaps.demo.Test \"Param1 with space\", 24");

    }

    @Test
    public void execEsjpParameters3()

    {
        final Statement stmt = getStatement("exec org.efaps.demo.Test \"Param1 with space\", \"ABCDE\"");
        System.out.println(stmt);

    }

    @Test
    public void execEsjpMapping()

    {
        final Statement stmt = getStatement("exec org.efaps.demo.Test select 1 as Key");
        System.out.println(stmt);

    }

    @Test
    public void execEsjpMapping1()

    {
        final Statement stmt = getStatement("exec org.efaps.demo.Test select 1 as Key, 5 as Demo");
        System.out.println(stmt);
    }

    @Test
    public void execEsjpParametersMapping()

    {
        final Statement stmt = getStatement("exec org.efaps.demo.Test \"Param1 with space\", \"ABCDE\" select 1 as Key");
        System.out.println(stmt);

    }

    @Test
    public void execEsjpParametersMapping2()

    {
        final Statement stmt = getStatement("exec org.efaps.demo.Test \"Param1 with space\", \"ABCDE\" select 1 as Key, 2 as Demo");
        System.out.println(stmt);

    }
}
