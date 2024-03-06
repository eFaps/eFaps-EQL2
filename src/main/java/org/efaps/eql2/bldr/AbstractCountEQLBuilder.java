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
package org.efaps.eql2.bldr;

import org.efaps.eql2.EQL2;
import org.efaps.eql2.ICountQueryStatement;
import org.efaps.eql2.IEql2Factory;
import org.efaps.eql2.IQuery;

public abstract class AbstractCountEQLBuilder<T extends AbstractCountEQLBuilder<T>>
    extends AbstractEQLBuilder<T>
{
    /** The i query. */
    private IQuery query;

    public T query(final String... _types)
    {
        setStmt(IEql2Factory.eINSTANCE.createCountQueryStatement());
        for (final String type : _types) {
            getQuery().addType(type);
        }
        return getThis();
    }

    protected IQuery getQuery()
    {
        if (query == null) {
            query = IEql2Factory.eINSTANCE.createQuery();
            ((ICountQueryStatement) getStmt()).setQuery(query);
        }
        return query;
    }

    public AbstractWhereBuilder<?> where()
    {
        final AbstractWhereBuilder<?> ret = EQL2.builder().where();
        this.getQuery().setWhere(ret.getIWhere());
        ret.setCount(this);
        return ret;
    }
}
