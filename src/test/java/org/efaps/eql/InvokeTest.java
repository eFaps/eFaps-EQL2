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

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * TODO comment!
 *
 * @author The eFaps Team
 * @version $Id: $
 */
public class InvokeTest
    extends AbstractTest
{

    @Test
    public void printOnly()
        throws Exception
    {
        final PrintStmt printStmt = (PrintStmt) getInvoker().invoke("print 12312.2342");
        Assert.assertEquals(printStmt.getOid(), "12312.2342");
    }

    @Test
    public void printWithSelect()
        throws Exception
    {
        final PrintStmt printStmt = (PrintStmt) getInvoker().invoke("print 12312.2342 select attribute[Name] as name");
        Assert.assertEquals(printStmt.getOid(), "12312.2342");
        Assert.assertEquals(printStmt.getAlias().keySet().toArray(), new String[] { "attribute[Name]" });
        Assert.assertEquals(printStmt.getAlias().values().toArray(), new String[] { "name" });
    }
}
