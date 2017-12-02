/*
 * Copyright 2003 - 2016 The eFaps Team
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

import org.eclipse.xtext.common.services.Ecore2XtextTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.IDValueConverter;
import org.eclipse.xtext.nodemodel.INode;

/**
 * The Class ValueConverter.
 *
 * @author The eFaps Team
 */
public class ValueConverters
    extends Ecore2XtextTerminalConverters
{
    /**
     * Format ValueConverter.
     *
     * @return the IValueConverter<String>
     */
    @ValueConverter(rule = "FORMAT")
    public IValueConverter<String> format()
    {
        return new IValueConverter<String>()
        {

            @Override
            public String toValue(final String _string,
                                  final INode _node)
                throws ValueConverterException
            {
                final String ret;
                if (_string.startsWith("format[")) {
                    ret = _string.substring(7, _string.length() - 1);
                } else {
                    ret = _string;
                }
                return ret;
            }

            @Override
            public String toString(final String _value)
                throws ValueConverterException
            {
                return toValue(_value, null);
            }
        };
    }

    /**
     * Name.
     *
     * @return the i value converter< string>
     */
    @ValueConverter(rule = "Attribute")
    public IValueConverter<String> name()
    {
        return new IDValueConverter()
        {
            @Override
            public String toValue(final String _string,
                                  final INode _node)
                throws ValueConverterException
            {
                return super.toValue(_string, _node);
            }
        };
    }

    /**
     * Clazz name.
     *
     * @return the i value converter< string>
     */
    @ValueConverter(rule = "ClazzName")
    public IValueConverter<String> clazzName()
    {
        return new IDValueConverter()
        {
            @Override
            public String toValue(final String _string,
                                  final INode _node)
                throws ValueConverterException
            {
                return super.toValue(_string == null ? null : _string.trim(), _node);
            }
        };
    }
}
