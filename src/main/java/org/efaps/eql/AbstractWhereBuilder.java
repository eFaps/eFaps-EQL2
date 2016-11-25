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
package org.efaps.eql;


/**
 * The Class AbstractWhereBuilder.
 *
 * @author The eFaps Team
 * @param <T> the generic type
 */
public abstract class AbstractWhereBuilder<T extends AbstractWhereBuilder<T>>
{

    /** The parent. */
    private final AbstractEQLBuilder<?> parent;

    /**
     * Instantiates a new abstract where builder.
     *
     * @param _parent the parent
     */
    public AbstractWhereBuilder(final AbstractEQLBuilder<?> _parent)
    {
        this.parent = _parent;
    }

    /**
     * Attr.
     *
     * @param _attr the attr
     * @return the t
     */
    public T attr(final String _attr)
    {
        final IWhereElement element = getParent().getCurrentTerm().element();
        element.attribute(_attr);
        return getThis();
    }

    /**
     * Eq.
     *
     * @param _value the value
     * @return the t
     */
    public T eq(final String _value)
    {
        final IWhereElement element = getParent().getCurrentTerm().element();
        element.comparison(Comparison.EQUAL).addValue(_value);
        return getThis();
    }

    /**
     * Eq.
     *
     * @param _value the value
     * @return the t
     */
    public T greater(final String _value)
    {
        final IWhereElement element = getParent().getCurrentTerm().element();
        element.comparison(Comparison.GREATER).addValue(_value);
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
        final IWhereElement element = getParent().getCurrentTerm().element();
        element.comparison(Comparison.LESS).addValue(_value);
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
        final IWhereElement element = getParent().getCurrentTerm().element();
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
        final IWhereElement element = getParent().getCurrentTerm().element();
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
        final IWhereElement element = getParent().getCurrentTerm().element();
        element.comparison(_values.length == 1 ? Comparison.EQUAL : Comparison.IN);
        for (final String value : _values) {
            element.addValue(value);
        }
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
        final IWhereElement element = getParent().getCurrentTerm().element();
        element.comparison(_values.length == 1 ? Comparison.UNEQUAL : Comparison.NOTIN);
        for (final String value : _values) {
            element.addValue(value);
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
        ((IQueryStmt<?>) this.parent.getStmt()).getQuery().where();
        final IWhere where = ((IQueryStmt<?>) this.parent.getStmt()).getQuery().getWhere();
        where.term().and();
        return getThis();
    }

    /**
     * Or.
     *
     * @return the t
     */
    public T or()
    {
        ((IQueryStmt<?>) this.parent.getStmt()).getQuery().where();
        final IWhere where = ((IQueryStmt<?>) this.parent.getStmt()).getQuery().getWhere();
        where.term().or();
        return getThis();
    }

    /**
     * Select.
     *
     * @return the abstract print EQL builder<?>
     */
    public AbstractPrintEQLBuilder<?> select()
    {
        return ((AbstractPrintEQLBuilder<?>) getParent()).select();
    }

    /**
     * Select.
     *
     * @param _attr the attr
     * @param _value the value
     * @return the abstract print EQL builder<?>
     */
    public AbstractUpdateEQLBuilder<?> set(final String _attr,
                                           final String _value)
    {
        return ((AbstractUpdateEQLBuilder<?>) getParent()).set(_attr, _value);
    }

    /**
     * Gets the parent.
     *
     * @return the parent
     */
    protected AbstractEQLBuilder<?> getParent()
    {
        return this.parent;
    }

    /**
     * Gets the this.
     *
     * @return the this
     */
    protected abstract T getThis();

}
