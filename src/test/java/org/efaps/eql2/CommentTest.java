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
/*
 * Copyright 2003 - 2022 The eFaps Team
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

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Instant;

import org.eclipse.xtext.parser.IParseResult;
import org.testng.annotations.Test;

public class CommentTest
extends AbstractTest
{
    @Test(description = "ignores single line Comment")
    public void ignoresSingleLineComment()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintObjectStatement().setOidC("123.12")
                        .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                                        .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                                        .addElement(IEql2Factory.eINSTANCE.createFunctionSelectElement()
                                                                        .value(Instant.now().toString()))));

        final IParseResult result = getParser().doParse("//this is a single line comment\n"
                        + " print object 123.12 select now()");
        assertFalse(result.hasSyntaxErrors());
        final IEQLElement eObject = (IEQLElement) result.getRootASTElement();
        assertTrue(eObject.eqlStmt().startsWith("print object 123.12  select  "
                        + Instant.now().toString().substring(0, 20)));
        assertTrue(stmt.eqlStmt().startsWith("print object 123.12  select  "
                        + Instant.now().toString().substring(0, 20)));
    }

    @Test(description = "ignores multi line Comment")
    public void ignoresMultiLineComment()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintObjectStatement();
        verifyStatement("/*this is a comment\n"
                        + "that is over multiple lines\n"
                        + "and finished hier\n"
                        + "*/\n  print obj", stmt);
    }


}
