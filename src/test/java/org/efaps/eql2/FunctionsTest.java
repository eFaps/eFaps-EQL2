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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.time.temporal.TemporalAdjusters;

import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.testng.annotations.Test;

public class FunctionsTest
    extends AbstractTest
{

    @Test
    public void now()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintObjectStatement().setOidC("123.12")
                        .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                                        .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                                        .addElement(IEql2Factory.eINSTANCE.createFunctionSelectElement()
                                                                        .value(Instant.now().toString()))));

        final IParseResult result = getParser().doParse("print object 123.12 select now()");
        assertFalse(result.hasSyntaxErrors());
        final IEQLElement eObject = (IEQLElement) result.getRootASTElement();
        assertTrue(eObject.eqlStmt().startsWith("print object 123.12  select  "
                        + Instant.now().toString().substring(0, 20)));
        assertTrue(stmt.eqlStmt().startsWith("print object 123.12  select  "
                        + Instant.now().toString().substring(0, 20)));
    }

    @Test
    public void nowAdd()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintObjectStatement().setOidC("123.12")
                        .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                                        .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                                        .addElement(IEql2Factory.eINSTANCE.createFunctionSelectElement()
                                                                        .value(Instant.now().plus(Period.ofDays(4))
                                                                                        .toString()))));
        final IParseResult result = getParser().doParse("print object 123.12 select nowAdd(4,day)");
        assertFalse(result.hasSyntaxErrors());
        final IEQLElement eObject = (IEQLElement) result.getRootASTElement();
        assertTrue(eObject.eqlStmt().startsWith("print object 123.12  select  "
                        + Instant.now().plus(Period.ofDays(4)).toString().substring(0, 20)));
        assertTrue(stmt.eqlStmt().startsWith("print object 123.12  select  "
                        + Instant.now().plus(Period.ofDays(4)).toString().substring(0, 20)));
    }

    @Test
    public void nowAddPositiv()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintObjectStatement().setOidC("123.12")
                        .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                                        .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                                        .addElement(IEql2Factory.eINSTANCE.createFunctionSelectElement()
                                                                        .value(Instant.now().plus(Period.ofDays(4))
                                                                                        .toString()))));
        final IParseResult result = getParser().doParse("print object 123.12 select nowAdd(+4,day)");
        assertFalse(result.hasSyntaxErrors());
        final IEQLElement eObject = (IEQLElement) result.getRootASTElement();
        assertTrue(eObject.eqlStmt().startsWith("print object 123.12  select  "
                        + Instant.now().plus(Period.ofDays(4)).toString().substring(0, 20)));
        assertTrue(stmt.eqlStmt().startsWith("print object 123.12  select  "
                        + Instant.now().plus(Period.ofDays(4)).toString().substring(0, 20)));
    }

    @Test
    public void nowAddNegative()
    {
        final var datetime = OffsetDateTime.now(ZoneOffset.UTC).plusMonths(-2).toString();
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintObjectStatement().setOidC("123.12")
                        .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                                        .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                                        .addElement(IEql2Factory.eINSTANCE.createFunctionSelectElement()
                                                                        .value(datetime))));
        final IParseResult result = getParser().doParse("print object 123.12 select nowAdd(-2,month)");
        assertFalse(result.hasSyntaxErrors());
        final IEQLElement eObject = (IEQLElement) result.getRootASTElement();
        assertTrue(eObject.eqlStmt().startsWith("print object 123.12  select  "
                        + datetime.substring(0, 20)));
        assertTrue(stmt.eqlStmt().startsWith("print object 123.12  select  "
                        + datetime.substring(0, 20)));
    }

    @Test
    public void date()
    {
        final var date = LocalDate.now(Clock.systemUTC()).toString();
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintObjectStatement().setOidC("123.12")
                        .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                                        .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                                        .addElement(IEql2Factory.eINSTANCE.createFunctionSelectElement()
                                                                        .value(date))));

        final IParseResult result = getParser().doParse("print object 123.12 select date()");
        assertFalse(result.hasSyntaxErrors());
        final IEQLElement eObject = (IEQLElement) result.getRootASTElement();
        assertEquals(eObject.eqlStmt(), "print object 123.12  select  " + date);
        assertEquals(stmt.eqlStmt(), "print object 123.12  select  " + date);
    }

    @Test
    public void dateAdd()
    {
        final var date = LocalDate.now(Clock.systemUTC()).plusWeeks(4).toString();
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintObjectStatement().setOidC("123.12")
                        .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                                        .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                                        .addElement(IEql2Factory.eINSTANCE.createFunctionSelectElement()
                                                                        .value(date))));

        final IParseResult result = getParser().doParse("print object 123.12 select dateAdd(4,week)");
        assertFalse(result.hasSyntaxErrors());
        final IEQLElement eObject = (IEQLElement) result.getRootASTElement();
        assertEquals(eObject.eqlStmt(), "print object 123.12  select  " + date);
        assertEquals(stmt.eqlStmt(), "print object 123.12  select  " + date);
    }

    @Test
    public void dateAddPositiv()
    {
        final var date = LocalDate.now(Clock.systemUTC()).plusWeeks(4).toString();
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintObjectStatement().setOidC("123.12")
                        .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                                        .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                                        .addElement(IEql2Factory.eINSTANCE.createFunctionSelectElement()
                                                                        .value(date))));

        final IParseResult result = getParser().doParse("print object 123.12 select dateAdd(+4,week)");
        assertFalse(result.hasSyntaxErrors());
        final IEQLElement eObject = (IEQLElement) result.getRootASTElement();
        assertEquals(eObject.eqlStmt(), "print object 123.12  select  " + date);
        assertEquals(stmt.eqlStmt(), "print object 123.12  select  " + date);
    }

    @Test
    public void dateAddNegative()
    {
        final var date = LocalDate.now(Clock.systemUTC()).minusDays(24).toString();
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintObjectStatement().setOidC("123.12")
                        .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                                        .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                                        .addElement(IEql2Factory.eINSTANCE.createFunctionSelectElement()
                                                                        .value(date))));

        final IParseResult result = getParser().doParse("print object 123.12 select dateAdd(-24,day)");
        assertFalse(result.hasSyntaxErrors());
        final IEQLElement eObject = (IEQLElement) result.getRootASTElement();
        assertEquals(eObject.eqlStmt(), "print object 123.12  select  " + date);
        assertEquals(stmt.eqlStmt(), "print object 123.12  select  " + date);
    }

    @Test
    public void queryNow()
    {
        final var datetime = OffsetDateTime.now(ZoneOffset.UTC).toString();
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintQueryStatement()
                        .query(IEql2Factory.eINSTANCE.createQuery().addType("Sales_Invoice")
                                        .where(IEql2Factory.eINSTANCE.createWhere()
                                                        .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                                                                        .element(IEql2Factory.eINSTANCE
                                                                                        .createWhereElement()
                                                                                        .attribute("Date")
                                                                                        .comparison(Comparison.LESS)
                                                                                        .value(datetime)))))
                        .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                                        .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                                        .addElement(IEql2Factory.eINSTANCE
                                                                        .createAttributeSelectElement()
                                                                        .setNameC("Date"))));
        final IParseResult result = getParser()
                        .doParse("print query type Sales_Invoice where Date < now() select attribute[Date]");
        assertFalse(result.hasSyntaxErrors());
        final IEQLElement eObject = (IEQLElement) result.getRootASTElement();
        assertTrue(eObject.eqlStmt().startsWith("print  query type Sales_Invoice where   attribute[Date] < \""
                        + datetime.substring(0, 20)));
        assertTrue(stmt.eqlStmt().startsWith("print  query type Sales_Invoice where   attribute[Date] < \""
                        + datetime.substring(0, 20)));
    }

    @Test
    public void queryNowAddNegative()
    {
        final var datetime = OffsetDateTime.now(ZoneOffset.UTC).minusHours(3).toString();
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createPrintQueryStatement()
                        .query(IEql2Factory.eINSTANCE.createQuery().addType("Sales_Invoice")
                                        .where(IEql2Factory.eINSTANCE.createWhere()
                                                        .addTerm(IEql2Factory.eINSTANCE.createWhereElementTerm()
                                                                        .element(IEql2Factory.eINSTANCE
                                                                                        .createWhereElement()
                                                                                        .attribute("Date")
                                                                                        .comparison(Comparison.GREATER)
                                                                                        .value(datetime)))))
                        .setSelectionC(IEql2Factory.eINSTANCE.createSelection()
                                        .addSelect(IEql2Factory.eINSTANCE.createSelect()
                                                        .addElement(IEql2Factory.eINSTANCE
                                                                        .createAttributeSelectElement()
                                                                        .setNameC("Date"))));
        final IParseResult result = getParser().doParse("print query type Sales_Invoice where "
                        + "Date > nowAdd(-3, hour) select attribute[Date]");
        for (final INode error : result.getSyntaxErrors()) {
            final var msg = error.getSyntaxErrorMessage();
            System.out.println(msg);
        }

        assertFalse(result.hasSyntaxErrors());
        final IEQLElement eObject = (IEQLElement) result.getRootASTElement();
        assertTrue(eObject.eqlStmt().startsWith("print  query type Sales_Invoice where   attribute[Date] > \""
                        + datetime.substring(0, 20)));
        assertTrue(stmt.eqlStmt().startsWith("print  query type Sales_Invoice where   attribute[Date] > \""
                        + datetime.substring(0, 20)));
    }

    @Test
    public void temporalAdjuster()
    {
        final var datetime = OffsetDateTime.now(ZoneOffset.UTC).minusHours(0).with(TemporalAdjusters.lastDayOfMonth())
                        .toString();

        final IParseResult result1 = getParser().doParse("print object 123.12 select nowAdd( 0,day,lastDayOfMonth)");
        assertFalse(result1.hasSyntaxErrors());
        final IEQLElement eObject1 = (IEQLElement) result1.getRootASTElement();
        final var stmt = eObject1.eqlStmt();

        assertEquals(stmt.substring(0, stmt.lastIndexOf(".")),
                        "print object 123.12  select  " + datetime.substring(0, 19));

        final var localdate = LocalDate.now().minusDays(0).with(TemporalAdjusters.firstDayOfMonth()).toString();

        final IParseResult result = getParser().doParse("print object 123.12 select dateAdd(0, day ,firstDayOfMonth)");
        assertFalse(result.hasSyntaxErrors());
        final IEQLElement eObject = (IEQLElement) result.getRootASTElement();
        assertEquals(eObject.eqlStmt(), "print object 123.12  select  " + localdate);

        final var localdate2 = LocalDate.now(Clock.systemUTC()).minusDays(0)
                        .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).toString();

        final IParseResult result2 = getParser().doParse("print object 123.12 select dateAdd(0,day, firstDayOfWeek )");
        assertFalse(result2.hasSyntaxErrors());
        final IEQLElement eObject2 = (IEQLElement) result2.getRootASTElement();
        assertEquals(eObject2.eqlStmt(), "print object 123.12  select  " + localdate2);

    }
}
