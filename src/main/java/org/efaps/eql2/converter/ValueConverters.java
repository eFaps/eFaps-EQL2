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

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneOffset;
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
    private static Pattern NOW_ADD_PATTERN = Pattern.compile("nowAdd\\(((?:\\+|\\-)?\\d+),(\\w+)\\)");
    private static Pattern DATE_ADD_PATTERN = Pattern.compile("dateAdd\\(((?:\\+|\\-)?\\d+),(\\w+)\\)");

    @ValueConverter(rule = "FORMAT")
    public IValueConverter<String> format() {
        return new AbstractNullSafeConverter<String>() {

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
    public IValueConverter<String> attribute() {
        return new AbstractNullSafeConverter<String>() {

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
    public IValueConverter<String> clazzName() {
        return new AbstractNullSafeConverter<String>() {

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
    public IValueConverter<String> alias() {
        return new AbstractNullSafeConverter<String>() {

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
        return new AbstractNullSafeConverter<String>()
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
    public IValueConverter<String> NowFunction()
    {
        return new AbstractNullSafeConverter<String>()
        {

            @Override
            protected String internalToString(final String _value)
            {
                return Instant.now().toString();
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
    public IValueConverter<String> NowAddFunction()
    {
        return new AbstractNullSafeConverter<String>()
        {

            @Override
            protected String internalToString(final String _value)
            {
                final var matcher = NOW_ADD_PATTERN.matcher(_value);
                TemporalAmount temporalAmount = Period.ZERO;
                if (matcher.matches()) {
                    final var quantity  = Integer.valueOf(matcher.group(1));
                    final var interval  = matcher.group(2);
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
                }
                return OffsetDateTime.now(ZoneOffset.UTC).plus(temporalAmount).toString();
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
    public IValueConverter<String> DateFunction()
    {
        return new AbstractNullSafeConverter<String>()
        {

            @Override
            protected String internalToString(final String _value)
            {
                return LocalDate.now().toString();
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
    public IValueConverter<String> DateAddFunction()
    {
        return new AbstractNullSafeConverter<String>()
        {

            @Override
            protected String internalToString(final String _value)
            {
                final var matcher = DATE_ADD_PATTERN.matcher(_value);
                TemporalAmount temporalAmount = Period.ZERO;
                if (matcher.matches()) {
                    final var quantity  = Integer.valueOf(matcher.group(1));
                    final var interval  = matcher.group(2);
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
                }
                return LocalDate.now().plus(temporalAmount).toString();
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
}
