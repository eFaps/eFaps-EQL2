/*
 * Copyright 2003 - 2020 The eFaps Team
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

import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.testng.annotations.Test;

public class RandomParserTest
    extends AbstractTest
{

    @Test(description = "print obj")
    public void random1()
    {
        final var stmt = "print  query type Accounting_AccountAbstract where   attribute[PeriodAbstractLink] == 2 "
                        + "and attribute[ParentLink] is null select  attribute[Type]  as type, "
                        + "attribute[Name] as name, "
                        + "attribute[Description]  as description, "
                        + "attribute[SumBooked]  as sumBooked, "
                        + "attribute[SumReport]  as sumReportDebit, "
                        + "attribute[SumReport]  as sumReportCredit, "
                        + "linkto[ParentLink].attribute[Name] as parentLink, "
                        + "linkto[ParentLink].oid as parentLinkAOID, attribute[Summary]  as summary";
        final IParseResult result = getParser().doParse(stmt);
        for (final INode error : result.getSyntaxErrors()) {
            System.out.println(error.getSyntaxErrorMessage());
        }
    }

}
