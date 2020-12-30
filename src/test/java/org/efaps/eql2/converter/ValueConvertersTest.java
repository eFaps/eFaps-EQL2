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
    public void DateAddFunction(final String _dateTime, final Integer _quantity, final String _interval,
                                final String _adjuster,
                                final String _value)
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

    @DataProvider(name = "dateAdd")
    public static Iterator<Object[]> stmts(final ITestContext _context)
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
