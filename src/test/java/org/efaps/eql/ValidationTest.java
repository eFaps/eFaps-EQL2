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

import org.efaps.eql.validation.EFapsDiagnostic;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * TODO comment!
 *
 * @author The eFaps Team
 * @version $Id: $
 */
public class ValidationTest
    extends AbstractTest
    {

        @Test(description = "After in no empty () allowed")
        public void inEmpty()
            throws Exception
        {
            getStatement("where DocumentLink in ()");
            Assert.assertEquals(((EFapsDiagnostic) getDiagnostic().getChildren().get(0)).getIssueCode(), "E001");
        }
}
