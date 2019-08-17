/*
 * Copyright 2003 - 2019 The eFaps Team
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

import org.efaps.eql2.EQL2;
import org.efaps.eql2.IEql2Factory;
import org.efaps.eql2.IQuery;
import org.efaps.eql2.impl.PrintQueryStatement;

/**
 * The Class AbstractQueryEQLBuilder.
 *
 * @param <T> the generic type
 */
public class AbstractQueryEQLBuilder<T extends AbstractQueryEQLBuilder<T>>
    extends AbstractEQLBuilder<T>
{

    /** The i query. */
    private IQuery iQuery;

    private AbstractPrintEQLBuilder<?> print;

    /**
     * Query.
     *
     * @param _types the types
     * @return the abstract query EQL builder
     */
    public AbstractQueryEQLBuilder<?> query(final String... _types)
    {
        for (final String type : _types) {
            getIQuery().addType(type);
        }
        return getThis();
    }

    public AbstractPrintEQLBuilder<?> select() {
        ((PrintQueryStatement) print.getStmt()).setQueryC(getIQuery());
        return print;
    }

    /**
     * Where attr eq value.
     * @param _string
     *
     * @return the t
     */
    public T where(final AbstractWhereBuilder<?> _whereBldr)
    {
        getIQuery().setWhere(_whereBldr.getIWhere());
        return getThis();
    }

    public AbstractWhereBuilder<?> where() {
        final AbstractWhereBuilder<?> ret = EQL2.builder().where();
        ret.setQuery(this);
        return ret;
    }

    /**
     * Gets the i query.
     *
     * @return the i query
     */
    protected IQuery getIQuery() {
        if (this.iQuery == null) {
            this.iQuery = IEql2Factory.eINSTANCE.createQuery();
        }
        return this.iQuery;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected T getThis()
    {
        return (T) this;
    }

    protected void setPrint(final AbstractPrintEQLBuilder<?> _printEQLBuilder)
    {
        this.print = _printEQLBuilder;
    }
}
