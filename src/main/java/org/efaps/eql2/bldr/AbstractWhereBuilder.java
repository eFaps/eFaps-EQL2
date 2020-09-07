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
package org.efaps.eql2.bldr;

import java.util.Arrays;

import org.efaps.eql2.Comparison;
import org.efaps.eql2.IEql2Factory;
import org.efaps.eql2.INestedQuery;
import org.efaps.eql2.IWhere;
import org.efaps.eql2.IWhereElement;
import org.efaps.eql2.IWhereElementTerm;
import org.efaps.eql2.IWhereTerm;

/**
 * The Class AbstractWhereBuilder.
 *
 * @author The eFaps Team
 * @param <T> the generic type
 */
public abstract class AbstractWhereBuilder<T extends AbstractWhereBuilder<T>>
{

    /** The parent. */
    private IWhere iWhere;
    private AbstractQueryEQLBuilder<?> queryBldr;

    public AbstractPrintEQLBuilder<?> select() {
        queryBldr.getQuery().setWhere(getIWhere());
        return queryBldr.select();
    }

    public AbstractQueryEQLBuilder<?> up() {
        return queryBldr;
    }

    /**
     * Attr.
     *
     * @param _attr the attr
     * @return the t
     */
    public T attribute(final String _attr)
    {
        final IWhereElement element = getCurrentElement();
        element.setAttribute(_attr);
        return getThis();
    }

    /**
     * Attr.
     *
     * @param _attr the attr
     * @return the t
     */
    public T attr(final String _attr)
    {
        return attribute(_attr);
    }

    /**
     * Eq.
     *
     * @param _value the value
     * @return the t
     */
    public T eq(final String _value)
    {
        final IWhereElement element = getCurrentElement();
        element.comparison(Comparison.EQUAL).addValue(_value);
        return getThis();
    }

    /**
     * Eq.
     *
     * @param _value the value
     * @return the t
     */
    public T eq(final Long _value)
    {
        return eq(_value.toString());
    }

    /**
     * Eq.
     *
     * @param _value the value
     * @return the t
     */
    public T eq(final Integer _value)
    {
        return eq(_value.toString());
    }

    /**
     * Eq.
     *
     * @param _value the value
     * @return the t
     */
    public T greater(final String _value)
    {
        final IWhereElement element = getCurrentElement();
        element.comparison(Comparison.GREATER).addValue(_value);
        return getThis();
    }

    /**
     * Eq.
     *
     * @param _value the value
     * @return the t
     */
    public T greaterOrEq(final String _value)
    {
        final IWhereElement element = getCurrentElement();
        element.comparison(Comparison.GREATEREQ).addValue(_value);
        return getThis();
    }

    /**
     * Eq.
     *
     * @param _value the value
     * @return the t
     */
    public T less(final String _value)
    {
        final IWhereElement element = getCurrentElement();
        element.comparison(Comparison.LESS).addValue(_value);
        return getThis();
    }

    /**
     * Eq.
     *
     * @param _value the value
     * @return the t
     */
    public T lessOrEq(final String _value)
    {
        final IWhereElement element = getCurrentElement();
        element.comparison(Comparison.LESSEQ).addValue(_value);
        return getThis();
    }

    /**
     * Eq.
     *
     * @param _value the value
     * @return the t
     */
    public T like(final String _value)
    {
        final IWhereElement element = getCurrentElement();
        element.comparison(Comparison.LIKE).addValue(_value);
        return getThis();
    }

    /**
     * Eq.
     *
     * @param _value the value
     * @return the t
     */
    public T uneq(final String _value)
    {
        final IWhereElement element = getCurrentElement();
        element.comparison(Comparison.UNEQUAL).addValue(_value);
        return getThis();
    }

    /**
     * In.
     *
     * @param _values the values
     * @return the t
     */
    public T in(final String... _values)
    {
        final IWhereElement element = getCurrentElement();
        for (final String value : _values) {
            element.comparison(Comparison.IN).addValue(value);
        }
        return getThis();
    }

    /**
     * Eq.
     *
     * @param _value the value
     * @return the t
     */
    public T in(final Long... _value)
    {
        return in(Arrays.stream(_value)
                        .map(value -> value.toString())
                        .toArray(String[]::new));
    }

    /**
     * Eq.
     *
     * @param _value the value
     * @return the t
     */
    public T in(final Integer... _value)
    {
        return in(Arrays.stream(_value)
                        .map(value -> value.toString())
                        .toArray(String[]::new));
    }

    public T in(final AbstractQueryEQLBuilder<?> _queryBldr)
    {
        final IWhereElement element = getCurrentElement();
        element.comparison(Comparison.IN).nestedQuery((INestedQuery) _queryBldr.getQuery());
        return getThis();
    }

    /**
     * In.
     *
     * @param _values the values
     * @return the t
     */
    public T notin(final String... _values)
    {
        final IWhereElement element = getCurrentElement();
        for (final String value : _values) {
            element.comparison(Comparison.NOTIN).addValue(value);
        }
        return getThis();
    }

    /**
     * And.
     *
     * @return the t
     */
    public T and()
    {
        getIWhere().term().and();
        return getThis();
    }

    /**
     * Or.
     *
     * @return the t
     */
    public T or()
    {
       /* ((IQueryStmt<?>) this.parent.getStmt()).getQuery().where();
        final IWhere where = ((IQueryStmt<?>) this.parent.getStmt()).getQuery().getWhere();
        where.term().or();*/
        return getThis();
    }

    /**
     * Gets the parent.
     *
     * @return the parent
     */
    protected IWhere getIWhere()
    {
        if (this.iWhere == null) {
            this.iWhere = IEql2Factory.eINSTANCE.createWhere();
        }
        return this.iWhere;
    }

    protected IWhereTerm<?> getCurrentTerm()
    {
        final IWhere where = getIWhere();
        if (where.getTermsLength() == 0) {
            where.term();
        }
        return where.getTerms(where.getTermsLength() - 1);
    }

    protected IWhereElement getCurrentElement()
    {
        final IWhereElementTerm whereElementTerm = (IWhereElementTerm) getCurrentTerm();
        return whereElementTerm.element();
    }

    protected void setQuery(final AbstractQueryEQLBuilder<?> _queryEQLBuilder)
    {
        queryBldr = _queryEQLBuilder;
    }

    /**
     * Gets the this.
     *
     * @return the this
     */
    protected abstract T getThis();

}
