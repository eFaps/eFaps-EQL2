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

import static org.testng.Assert.assertEquals;

import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.efaps.eql2.impl.AttributeSelectElement;
import org.efaps.eql2.impl.LinkfromSelectElement;
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

    @Test()
    public void linkFormWithFilter1()
    {
        final var stmt = "print obj 7044.3 select attribute[Name], "
                        + "linkfrom[Products_Conversion#ProductLink, filter attribute[ConversionType] eq 0]"
                        + ".attribute[OID]";
        final IParseResult result = getParser().doParse(stmt);
        final var print = (IPrintObjectStatement) result.getRootASTElement();
        assertEquals(print.getOid(), "7044.3");
        assertEquals(print.getSelection().getSelectsLength(), 2);

        final var select = print.getSelection().getSelects(1);
        final var linkfrom = (LinkfromSelectElement) select.getElements(0);
        assertEquals(linkfrom.getTypeName(), "Products_Conversion");
        assertEquals(linkfrom.getAttribute(), "ProductLink");
        final var filter = linkfrom.getFilter();
        assertEquals(filter.getTermsLength(), 1);
        final var term = (IWhereElementTerm) filter.getTerms(0);
        final var attrSel =(IAttributeSelectElement) term.getElement().getSelect().getElements(0);
        assertEquals(attrSel.getName(), "ConversionType");
        assertEquals(term.getElement().getComparison(), Comparison.EQUAL);
        assertEquals(term.getElement().getValues(0), "0");

        final var attSelEl = (AttributeSelectElement) select.getElements(1);
        assertEquals(attSelEl.getName(), "OID");
    }

    @Test()
    public void linkFormWithFilter2()
    {
        final var stmt = "print obj 7044.3 select attribute[Name], "
                        + "linkfrom[Products_Conversion#ProductLink, filter attribute[ConversionType] eq 0]"
                        + ".attribute[OID], attribute[SomethingElse]";
        final IParseResult result = getParser().doParse(stmt);
        final var print = (IPrintObjectStatement) result.getRootASTElement();
        assertEquals(print.getOid(), "7044.3");
        assertEquals(print.getSelection().getSelectsLength(), 3);

        final var select1 = print.getSelection().getSelects(0);
        final var attSelEl = (IAttributeSelectElement) select1.getElements(0);
        assertEquals(attSelEl.getName(), "Name");

        final var select2 = print.getSelection().getSelects(1);
        final var linkfrom = (LinkfromSelectElement) select2.getElements(0);
        assertEquals(linkfrom.getTypeName(), "Products_Conversion");
        assertEquals(linkfrom.getAttribute(), "ProductLink");
        final var filter = linkfrom.getFilter();
        assertEquals(filter.getTermsLength(), 1);
        final var term = (IWhereElementTerm) filter.getTerms(0);
        final var attrSel =(IAttributeSelectElement) term.getElement().getSelect().getElements(0);
        assertEquals(attrSel.getName(), "ConversionType");
        assertEquals(term.getElement().getComparison(), Comparison.EQUAL);
        assertEquals(term.getElement().getValues(0), "0");

        final var attSelEl1 = (IAttributeSelectElement) select2.getElements(1);
        assertEquals(attSelEl1.getName(), "OID");

        final var select3 = print.getSelection().getSelects(2);
        final var attSelEl2 = (IAttributeSelectElement) select3.getElements(0);
        assertEquals(attSelEl2.getName(), "SomethingElse");
    }

    @Test()
    public void linkFormWithFilter3()
    {
        final var stmt = "print obj 7044.3 select attribute[Name], "
                        + "linkfrom[Products_Conversion#ProductLink, filter attribute[ConversionType] == 'TRANSPORT']"
                        + ".attribute[OID].first, attribute[SomethingElse]";
        final IParseResult result = getParser().doParse(stmt);
        final var print = (IPrintObjectStatement) result.getRootASTElement();
        assertEquals(print.getOid(), "7044.3");
        assertEquals(print.getSelection().getSelectsLength(), 3);

        final var select1 = print.getSelection().getSelects(0);
        final var attSelEl = (IAttributeSelectElement) select1.getElements(0);
        assertEquals(attSelEl.getName(), "Name");

        final var select2 = print.getSelection().getSelects(1);
        final var linkfrom = (LinkfromSelectElement) select2.getElements(0);
        assertEquals(linkfrom.getTypeName(), "Products_Conversion");
        assertEquals(linkfrom.getAttribute(), "ProductLink");
        final var filter = linkfrom.getFilter();
        assertEquals(filter.getTermsLength(), 1);
        final var term = (IWhereElementTerm) filter.getTerms(0);
        final var attrSel =(IAttributeSelectElement) term.getElement().getSelect().getElements(0);
        assertEquals(attrSel.getName(), "ConversionType");
        assertEquals(term.getElement().getComparison(), Comparison.EQUAL);
        assertEquals(term.getElement().getValues(0), "TRANSPORT");

        final var attSelEl1 = (IAttributeSelectElement) select2.getElements(1);
        assertEquals(attSelEl1.getName(), "OID");

        final var baseSelEl = (IBaseSelectElement) select2.getElements(2);
        assertEquals(baseSelEl.getElement(), SimpleSelectElement.FIRST);

        final var select3 = print.getSelection().getSelects(2);
        final var attSelEl2 = (IAttributeSelectElement) select3.getElements(0);
        assertEquals(attSelEl2.getName(), "SomethingElse");
    }


}
