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
package org.efaps.eql2.converter;

import static org.testng.Assert.assertEquals;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValueConvertersTest
{

    @Test(dataProvider = "dateAdd")
    public void dateAddFunction(final String _dateTime, final Integer _quantity, final String _interval,
                                final String _adjuster, final String _value)
    {
        final var clock = Clock.fixed(Instant.parse(_dateTime), ZoneId.of("UTC"));
        final var function = new TestValueConverters(clock).dateAddFunction();
        var eql = "dateAdd(" + _quantity + ", " + _interval;
        if (_interval != null) {
            eql = eql + ", " + _adjuster;
        }
        eql = eql + ")";
        final var result = function.toString(eql);
        assertEquals(result, _value);
    }

    @Test
    public void dateFunction()
    {
        final var clock = Clock.fixed(Instant.parse("2020-12-22T10:15:30.00Z"), ZoneId.of("UTC"));
        final var function = new TestValueConverters(clock).dateFunction();
        final var result = function.toString("date()");
        assertEquals(result, "2020-12-22");
    }

    @Test(dataProvider = "nowAdd")
    public void nowAddFunction(final String _dateTime, final Integer _quantity, final String _interval,
                                final String _adjuster, final String _value)
    {
        final var clock = Clock.fixed(Instant.parse(_dateTime), ZoneId.of("UTC"));
        final var function = new TestValueConverters(clock).nowAddFunction();
        var eql = "nowAdd(" + _quantity + ", " + _interval;
        if (_interval != null) {
            eql = eql + ", " + _adjuster;
        }
        eql = eql + ")";
        final var result = function.toString(eql);
        assertEquals(result, _value);
    }

    @Test
    public void nowFunction()
    {
        final var clock = Clock.fixed(Instant.parse("2020-12-22T10:15:30.00Z"), ZoneId.of("UTC"));
        final var function = new TestValueConverters(clock).nowFunction();
        final var result = function.toString("now()");
        assertEquals(result, "2020-12-22T10:15:30Z");
    }

    @Test
    public void joining()
    {
        final var joining = new ValueConverters().joining();
        assertEquals(joining.toString("joining[\"Hallo World\"]"), "Hallo World");
        assertEquals(joining.toString("joining[HALLO]"), "HALLO");
    }

    @Test
    public void alias()
    {
        final var joining = new ValueConverters().alias();
        assertEquals(joining.toValue("\"Hallo World\"", null), "Hallo World");
        assertEquals(joining.toValue("HALLO", null), "HALLO");
    }

    @DataProvider(name = "dateAdd")
    public static Iterator<Object[]> dateAdd(final ITestContext _context)
    {
        final List<Object[]> ret = new ArrayList<>();
        ret.add(new Object[] { "2014-12-22T10:15:30.00Z", -3, "month", null, "2014-09-22" });
        ret.add(new Object[] { "2015-12-23T10:15:30.00Z", -2, "month", null, "2015-10-23" });
        ret.add(new Object[] { "2016-12-24T10:15:30.00Z", -1, "month", null, "2016-11-24" });
        ret.add(new Object[] { "2014-12-30T10:15:30.00Z", 0, "month", null, "2014-12-30" });
        ret.add(new Object[] { "2016-12-22T10:15:30.00Z", 1, "month", null, "2017-01-22" });
        ret.add(new Object[] { "2017-12-30T10:15:30.00Z", 2, "month", null, "2018-02-28" });
        ret.add(new Object[] { "2018-12-22T10:15:30.00Z", 3, "month", null, "2019-03-22" });

        ret.add(new Object[] { "2018-12-22T10:15:30.00Z", 1, "day", null, "2018-12-23" });
        ret.add(new Object[] { "2018-12-22T10:15:30.00Z", -23, "day", null, "2018-11-29" });

        ret.add(new Object[] { "2018-12-22T10:15:30.00Z", 1, "week", null, "2018-12-29" });
        ret.add(new Object[] { "2018-12-22T10:15:30.00Z", -2, "week", null, "2018-12-08" });

        ret.add(new Object[] { "2018-12-22T10:15:30.00Z", 1, "year", null, "2019-12-22" });
        ret.add(new Object[] { "2018-12-22T10:15:30.00Z", -2, "year", null, "2016-12-22" });

        ret.add(new Object[] { "2014-12-22T10:15:30.00Z", -3, "month", "firstDayOfMonth", "2014-09-01" });
        ret.add(new Object[] { "2014-12-22T10:15:30.00Z", -3, "month", "lastDayOfMonth", "2014-09-30" });

        ret.add(new Object[] { "2014-12-22T10:15:30.00Z", -3, "month", "firstDayOfYear", "2014-01-01" });
        ret.add(new Object[] { "2014-12-22T10:15:30.00Z", -1, "year", "firstDayOfYear", "2013-01-01" });

        ret.add(new Object[] { "2014-12-22T10:15:30.00Z", -1, "year", "lastDayOfYear", "2013-12-31" });

        ret.add(new Object[] { "2014-12-22T10:15:30.00Z", -1, "year", "firstDayOfWeek", "2013-12-16" });

        return ret.iterator();
    }

    @DataProvider(name = "nowAdd")
    public static Iterator<Object[]> nowAdd(final ITestContext _context)
    {
        final List<Object[]> ret = new ArrayList<>();
        ret.add(new Object[] { "2014-12-22T10:15:30.00Z", -3, "hour", null, "2014-12-22T07:15:30Z" });
        ret.add(new Object[] { "2014-12-22T10:15:30.00Z", 2, "day", null, "2014-12-24T10:15:30Z" });

        ret.add(new Object[] { "2014-12-22T10:15:30.00Z", 1, "week", null, "2014-12-29T10:15:30Z" });
        ret.add(new Object[] { "2014-12-22T10:15:30.00Z", 1, "month", null, "2015-01-22T10:15:30Z" });
        ret.add(new Object[] { "2014-12-22T10:15:30.00Z", -3, "month", "firstDayOfMonth", "2014-09-01T10:15:30Z" });
        ret.add(new Object[] { "2014-12-22T10:15:30.00Z", -3, "month", "lastDayOfMonth", "2014-09-30T10:15:30Z" });

        ret.add(new Object[] { "2014-12-22T10:15:30.00Z", -3, "month", "firstDayOfYear", "2014-01-01T10:15:30Z" });
        ret.add(new Object[] { "2014-12-22T10:15:30.00Z", 0, "hour", "firstDayOfYear", "2014-01-01T10:15:30Z" });

        ret.add(new Object[] { "2014-12-22T10:15:30.00Z", 0, "hour", "lastDayOfYear", "2014-12-31T10:15:30Z" });

        ret.add(new Object[] { "2014-12-21T10:15:30.00Z", -1, "hour", "firstDayOfWeek", "2014-12-15T09:15:30Z" });

        return ret.iterator();
    }

    public static class TestValueConverters
        extends ValueConverters
    {

        final Clock clock;

        public TestValueConverters(final Clock _clock)
        {
            clock = _clock;
        }

        @Override
        protected Clock getClock()
        {
            return clock;
        }
    }
}
