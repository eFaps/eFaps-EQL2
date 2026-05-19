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

import static org.testng.Assert.assertFalse;

import org.testng.annotations.Test;

public class SyntaxTest
    extends AbstractTest
{
    @Test(description = "obj")
    public void isnull() {
        final var stmt =   "print query type Loyalty_ProgramAbstract where Identifier is null  select oid";
        final var result  = getParser().doParse(stmt);
        if (result.hasSyntaxErrors()) {
            result.getSyntaxErrors().forEach(error -> {
                final var msg = error.getSyntaxErrorMessage();
                System.out.println(msg);
            });
        }
        assertFalse(result.hasSyntaxErrors());
    }
}
