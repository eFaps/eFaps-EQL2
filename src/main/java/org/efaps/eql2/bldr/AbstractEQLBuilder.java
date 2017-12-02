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
package org.efaps.eql2.bldr;

import org.efaps.eql2.EQL;
import org.efaps.eql2.IQueryStmt;
import org.efaps.eql2.IStatement;
import org.efaps.eql2.IWhere;
import org.efaps.eql2.impl.WhereElementTerm;

/**
 * The Class AbstractEQLBuilder.
 *
 * @author The eFaps Team
 * @param <T> the generic type
 */
public abstract class AbstractEQLBuilder<T extends AbstractEQLBuilder<T>>
{

    /** The stmt. */
    private IStatement<?> stmt;

    /** The where. */
    private AbstractWhereBuilder<?> whereBldr;

    /**
     * Query.
     *
     * @param _types the types
     * @return the t
     */
    public T query(final String... _types)
    {
        ((IQueryStmt<?>) this.stmt).query();
        for (final String type : _types) {
            ((IQueryStmt<?>) this.stmt).getQuery().addType(type);
        }
        return getThis();
    }

    /**
     * Where attr eq value.
     *
     * @return the t
     */
    public AbstractWhereBuilder<?> where()
    {
        ((IQueryStmt<?>) this.stmt).getQuery().where();
        if (this.whereBldr == null) {
            this.whereBldr = EQL.where(this);
        }
        return this.whereBldr;
    }

    /**
     * Gets the current term.
     *
     * @return the current term
     */
    protected WhereElementTerm getCurrentTerm()
    {
        ((IQueryStmt<?>) this.stmt).getQuery().where();
        final IWhere where = ((IQueryStmt<?>) this.stmt).getQuery().getWhere();
        if (where.getTermsLength() == 0) {
            where.term();
        }
        return (WhereElementTerm) where.getTerms(where.getTermsLength() - 1);
    }

    /**
     * Limit.
     *
     * @param _limit the limit
     * @return the t
     */
    public T limit(final int _limit)
    {
        ((IQueryStmt<?>) this.stmt).getQuery().limit(String.valueOf(_limit));
        return getThis();
    }

    /**
     * Gets the this.
     *
     * @return the this
     */
    protected abstract T getThis();

    /**
     * Gets the stmt.
     *
     * @return the stmt
     */
    protected IStatement<?> getStmt()
    {
        return this.stmt;
    }

    /**
     * Sets the stmt.
     *
     * @param _stmt the new stmt
     */
    protected void setStmt(final IStatement<?> _stmt)
    {
        this.stmt = _stmt;
    }
}
