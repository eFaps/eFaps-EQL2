/*
 * Copyright 2003 - 2015 The eFaps Team
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

package org.efaps.eql.stmt.parts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.efaps.eql.eQL.Comparison;

/**
 * TODO comment!
 *
 * @author The eFaps Team
 */
public class AbstractQueryPart
    extends AbstractObjectSelectPart
    implements IQueryStmtPart
{

    /**
     * List of types for the Query.
     */
    private final List<String> types = new ArrayList<>();

    private final List<Where> wheres = new ArrayList<>();

    @Override
    public void addType(final String _type)
        throws Exception
    {
        this.types.add(_type);
    }

    @Override
    public void addWhereAttrEq(final String _attr,
                               final String _value)
        throws Exception
    {
        this.wheres.add(new Where().setAttribute(_attr).addValue(_value).setComparison(Comparison.EQUAL));
    }

    @Override
    public void addWhereAttrNotEq(final String _attr,
                                  final String _value)
        throws Exception
    {
        this.wheres.add(new Where().setAttribute(_attr).addValue(_value).setComparison(Comparison.UNEQUAL));
    }

    @Override
    public void addWhereAttrGreater(final String _attr,
                                    final String _value)
        throws Exception
    {
        this.wheres.add(new Where().setAttribute(_attr).addValue(_value).setComparison(Comparison.GREATER));
    }

    @Override
    public void addWhereAttrLess(final String _attr,
                                 final String _value)
        throws Exception
    {
        this.wheres.add(new Where().setAttribute(_attr).addValue(_value).setComparison(Comparison.LESS));
    }

    @Override
    public void addWhereAttrLike(final String _attr,
                                 final String _value)
        throws Exception
    {
        this.wheres.add(new Where().setAttribute(_attr).addValue(_value).setComparison(Comparison.LIKE));
    }

    @Override
    public void addWhereAttrIn(final String _attr,
                               final String... _values)
        throws Exception
    {
        this.wheres.add(new Where().setAttribute(_attr).addValue(_values).setComparison(Comparison.IN));
    }

    @Override
    public void addWhereSelectEq(final String _select,
                                 final String _value)
        throws Exception
    {
        this.wheres.add(new Where().setSelect(_select).addValue(_value).setComparison(Comparison.EQUAL));
    }

    @Override
    public void addWhereSelectLike(final String _select,
                                   final String _value)
        throws Exception
    {
        this.wheres.add(new Where().setSelect(_select).addValue(_value).setComparison(Comparison.LIKE));
    }

    @Override
    public void addWhereSelectGreater(final String _select,
                                      final String _value)
        throws Exception
    {
        this.wheres.add(new Where().setSelect(_select).addValue(_value).setComparison(Comparison.GREATER));
    }

    @Override
    public void addWhereSelectLess(final String _select,
                                   final String _value)
        throws Exception
    {
        this.wheres.add(new Where().setSelect(_select).addValue(_value).setComparison(Comparison.LESS));
    }

    /**
     * Getter method for the instance variable {@link #types}.
     *
     * @return value of instance variable {@link #types}
     */
    public List<String> getTypes()
    {
        return this.types;
    }

    /**
     * Getter method for the instance variable {@link #wheres}.
     *
     * @return value of instance variable {@link #wheres}
     */
    public List<Where> getWheres()
    {
        return this.wheres;
    }

    public static class Where
    {

        private String attribute;
        private String select;

        private final List<String> values = new ArrayList<>();;

        private Comparison comparison;

        /**
         * Getter method for the instance variable {@link #attribute}.
         *
         * @return value of instance variable {@link #attribute}
         */
        public String getAttribute()
        {
            return this.attribute;
        }

        /**
         * Setter method for instance variable {@link #attribute}.
         *
         * @param _attribute value for instance variable {@link #attribute}
         */
        public Where setAttribute(final String _attribute)
        {
            this.attribute = _attribute;
            return this;
        }

        /**
         * Getter method for the instance variable {@link #value}.
         *
         * @return value of instance variable {@link #value}
         */
        public List<String> getValues()
        {
            return this.values;
        }

        /**
         * Setter method for instance variable {@link #value}.
         *
         * @param _value value for instance variable {@link #value}
         */
        public Where addValue(final String... _value)
        {
            this.values.addAll(Arrays.asList(_value));
            return this;
        }

        /**
         * Getter method for the instance variable {@link #comparison}.
         *
         * @return value of instance variable {@link #comparison}
         */
        public Comparison getComparison()
        {
            return this.comparison;
        }

        /**
         * Setter method for instance variable {@link #comparison}.
         *
         * @param _comparison value for instance variable {@link #comparison}
         */
        public Where setComparison(final Comparison _comparison)
        {
            this.comparison = _comparison;
            return this;
        }

        /**
         * Getter method for the instance variable {@link #select}.
         *
         * @return value of instance variable {@link #select}
         */
        public String getSelect()
        {
            return this.select;
        }

        /**
         * Setter method for instance variable {@link #select}.
         *
         * @param _select value for instance variable {@link #select}
         */
        public Where setSelect(final String _select)
        {
            this.select = _select;
            return this;
        }
    }
}
