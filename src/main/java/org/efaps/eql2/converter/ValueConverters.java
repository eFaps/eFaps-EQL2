/*
 * Copyright 2003 - 2018 The eFaps Team
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

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalAmount;
import java.util.regex.Pattern;

import org.eclipse.xtext.common.services.Ecore2XtextTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.nodemodel.INode;

/**
 * The Class ValueConverter.
 *
 * @author The eFaps Team
 */
public class ValueConverters
    extends Ecore2XtextTerminalConverters
{

    private static Pattern NOW_ADD_PATTERN = Pattern.compile("nowAdd\\(((?:\\+|\\-)?\\d+),(\\w+)(?:(?:,)(\\w+))?\\)");
    private static Pattern DATE_ADD_PATTERN = Pattern.compile("dateAdd\\(((?:\\+|\\-)?\\d+),(\\w+)(?:(?:,)(\\w+))?\\)");

    @ValueConverter(rule = "FORMAT")
    public IValueConverter<String> format()
    {
        return new AbstractNullSafeConverter<>()
        {

            @Override
            protected String internalToString(final String _value)
            {
                final String ret;
                if (_value.startsWith("format[\"") || _value.startsWith("format['")) {
                    ret = _value.substring(8, _value.length() - 2);
                } else if (_value.startsWith("format[")) {
                    ret = _value.substring(7, _value.length() - 1);
                } else {
                    ret = _value;
                }
                return ret;
            }

            @Override
            protected String internalToValue(final String _string, final INode _node)
                throws ValueConverterException
            {
                return internalToString(_string);
            }
        };
    }

    @ValueConverter(rule = "Attribute")
    public IValueConverter<String> attribute()
    {
        return new AbstractNullSafeConverter<>()
        {

            @Override
            protected String internalToString(final String _value)
            {
                return _value;
            }

            @Override
            protected String internalToValue(final String _string, final INode _node)
                throws ValueConverterException
            {
                return _string.startsWith("^") ? _string.substring(1) : _string;
            }
        };
    }

    @ValueConverter(rule = "ClazzName")
    public IValueConverter<String> clazzName()
    {
        return new AbstractNullSafeConverter<>()
        {

            @Override
            protected String internalToString(final String _value)
            {
                return _value;
            }

            @Override
            protected String internalToValue(final String _string, final INode _node)
                throws ValueConverterException
            {
                return _string.startsWith("^") ? _string.substring(1).trim() : _string.trim();
            }
        };
    }

    @ValueConverter(rule = "Alias")
    public IValueConverter<String> alias()
    {
        return new AbstractNullSafeConverter<>()
        {

            @Override
            protected String internalToString(final String _value)
            {
                return _value;
            }

            @Override
            protected String internalToValue(final String _string, final INode _node)
                throws ValueConverterException
            {
                return _string.startsWith("\"")
                                ? _string.substring(1, _string.length() - 1)
                                : _string;
            }
        };
    }

    @ValueConverter(rule = "UpdateValue")
    public IValueConverter<String> updateValue()
    {
        return new AbstractNullSafeConverter<>()
        {

            @Override
            protected String internalToString(final String _value)
            {
                return _value;
            }

            @Override
            protected String internalToValue(final String _string, final INode _node)
                throws ValueConverterException
            {
                return _string.startsWith("\"")
                                ? _string.substring(1, _string.length() - 1)
                                : _string;
            }
        };
    }


    @ValueConverter(rule = "JOINING")
    public IValueConverter<String> joining()
    {
        return new AbstractNullSafeConverter<>()
        {

            @Override
            protected String internalToString(final String _value)
            {
                String ret;
                if (_value.startsWith("joining[\"")) {
                    ret = _value.substring(9, _value.length() - 2);
                } else if (_value.startsWith("joining[")) {
                    ret = _value.substring(8, _value.length() - 1);
                } else {
                    ret = _value;
                }
                return ret;
            }

            @Override
            protected String internalToValue(final String _string,
                                             final INode _node)
                throws ValueConverterException
            {
                return internalToString(_string);
            }
        };
    }

    @ValueConverter(rule = "NOW_FUNCTION")
    public IValueConverter<String> nowFunction()
    {
        return new AbstractNullSafeConverter<>()
        {

            @Override
            protected String internalToString(final String _value)
            {
                return OffsetDateTime.now(getClock()).toString();
            }

            @Override
            protected String internalToValue(final String _string,
                                             final INode _node)
                throws ValueConverterException
            {
                return internalToString(_string);
            }
        };
    }

    @ValueConverter(rule = "NOW_ADD_FUNCTION")
    public IValueConverter<String> nowAddFunction()
    {
        return new AbstractNullSafeConverter<>()
        {

            @Override
            protected String internalToString(final String _value)
            {
                final var value = _value.replace(" " , "");
                final var matcher = NOW_ADD_PATTERN.matcher(value);
                TemporalAmount temporalAmount = Period.ZERO;
                TemporalAdjuster temporalAdjuster = null;
                if (matcher.matches()) {
                    final var quantity = Integer.valueOf(matcher.group(1));
                    final var interval = matcher.group(2);
                    switch (interval) {
                        case "hour":
                            temporalAmount = Duration.ofHours(quantity);
                            break;
                        case "day":
                            temporalAmount = Period.ofDays(quantity);
                            break;
                        case "week":
                            temporalAmount = Period.ofWeeks(quantity);
                            break;
                        case "month":
                            temporalAmount = Period.ofMonths(quantity);
                            break;
                        default:
                            break;
                    }
                    final var adjuster = matcher.group(3);
                    if (adjuster != null) {
                        switch (adjuster) {
                            case "firstDayOfMonth":
                                temporalAdjuster = TemporalAdjusters.firstDayOfMonth();
                                break;
                            case "lastDayOfMonth":
                                temporalAdjuster = TemporalAdjusters.lastDayOfMonth();
                                break;
                            case "firstDayOfYear":
                                temporalAdjuster = TemporalAdjusters.firstDayOfYear();
                                break;
                            case "lastDayOfYear":
                                temporalAdjuster = TemporalAdjusters.lastDayOfYear();
                                break;
                            case "firstDayOfWeek":
                                temporalAdjuster = TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY);
                                break;
                            default:
                                break;
                        }
                    }
                }
                var ret = OffsetDateTime.now(getClock()).plus(temporalAmount);
                if (temporalAdjuster != null) {
                    ret = ret.with(temporalAdjuster);
                }
                return ret.toString();
            }

            @Override
            protected String internalToValue(final String _string,
                                             final INode _node)
                throws ValueConverterException
            {
                return internalToString(_string);
            }
        };
    }

    @ValueConverter(rule = "DATE_FUNCTION")
    public IValueConverter<String> dateFunction()
    {
        return new AbstractNullSafeConverter<>()
        {

            @Override
            protected String internalToString(final String _value)
            {
                return LocalDate.now(getClock()).toString();
            }

            @Override
            protected String internalToValue(final String _string,
                                             final INode _node)
                throws ValueConverterException
            {
                return internalToString(_string);
            }
        };
    }

    @ValueConverter(rule = "DATE_ADD_FUNCTION")
    public IValueConverter<String> dateAddFunction()
    {
        return new AbstractNullSafeConverter<>()
        {

            @Override
            protected String internalToString(final String _value)
            {
                final var value = _value.replace(" " , "");
                final var matcher = DATE_ADD_PATTERN.matcher(value);
                TemporalAmount temporalAmount = Period.ZERO;
                TemporalAdjuster temporalAdjuster = null;
                if (matcher.matches()) {
                    final var quantity = Integer.valueOf(matcher.group(1));
                    final var interval = matcher.group(2);
                    switch (interval) {
                        case "day":
                            temporalAmount = Period.ofDays(quantity);
                            break;
                        case "week":
                            temporalAmount = Period.ofWeeks(quantity);
                            break;
                        case "month":
                            temporalAmount = Period.ofMonths(quantity);
                            break;
                        case "year":
                            temporalAmount = Period.ofYears(quantity);
                        default:
                            break;
                    }
                    final var adjuster = matcher.group(3);
                    if (adjuster != null) {
                        switch (adjuster) {
                            case "firstDayOfMonth":
                                temporalAdjuster = TemporalAdjusters.firstDayOfMonth();
                                break;
                            case "lastDayOfMonth":
                                temporalAdjuster = TemporalAdjusters.lastDayOfMonth();
                                break;
                            case "firstDayOfYear":
                                temporalAdjuster = TemporalAdjusters.firstDayOfYear();
                                break;
                            case "lastDayOfYear":
                                temporalAdjuster = TemporalAdjusters.lastDayOfYear();
                                break;
                            case "firstDayOfWeek":
                                temporalAdjuster = TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY);
                                break;
                            default:
                                break;
                        }
                    }
                }
                var ret = LocalDate.now(getClock()).plus(temporalAmount);
                if (temporalAdjuster != null) {
                    ret = ret.with(temporalAdjuster);
                }
                return ret.toString();
            }

            @Override
            protected String internalToValue(final String _string,
                                             final INode _node)
                throws ValueConverterException
            {
                return internalToString(_string);
            }
        };
    }

    protected Clock getClock() {
        return Clock.systemUTC();
    }
}
