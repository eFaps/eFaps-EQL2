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

import org.efaps.eql2.EQL2;
import org.efaps.eql2.IBaseQuery;
import org.efaps.eql2.IEql2Factory;
import org.efaps.eql2.INestedQuery;
import org.efaps.eql2.IQuery;
import org.efaps.eql2.ISelect;
import org.efaps.eql2.ISelection;
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
    private IBaseQuery<?> baseQuery;

    private AbstractPrintEQLBuilder<?> print;

    private boolean nested;

    /**
     * Query.
     *
     * @param _types the types
     * @return the abstract query EQL builder
     */
    public AbstractQueryEQLBuilder<?> query(final String... _types)
    {
        for (final String type : _types) {
            getQuery().addType(type);
        }
        return getThis();
    }

    public AbstractPrintEQLBuilder<?> select()
    {
        ((PrintQueryStatement) print.getStmt()).setQueryC((IQuery) getQuery());
        return print;
    }

    public AbstractPrintEQLBuilder<?> nestedSelect()
    {
        ((PrintQueryStatement) print.getStmt()).setQueryC((IQuery) getQuery());
        return print;
    }

    /**
     * Where attr eq value.
     *
     * @param _string
     *
     * @return the t
     */
    public T where(final AbstractWhereBuilder<?> _whereBldr)
    {
        getQuery().setWhere(_whereBldr.getIWhere());
        return getThis();
    }

    public AbstractWhereBuilder<?> where()
    {
        final AbstractWhereBuilder<?> ret = EQL2.builder().where();
        this.getQuery().setWhere(ret.getIWhere());
        ret.setQuery(this);
        return ret;
    }

    /**
     * Gets the i query.
     *
     * @return the i query
     */
    protected IBaseQuery<?> getQuery()
    {
        if (baseQuery == null) {
            baseQuery = isNested() ? IEql2Factory.eINSTANCE.createNestedQuery() : IEql2Factory.eINSTANCE.createQuery();
        }
        return baseQuery;
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

    public boolean isNested()
    {
        return nested;
    }

    public T nested(final boolean _nested)
    {
        this.nested = _nested;
        return getThis();
    }

    public T selectable(final ISelectable _selectable)
    {
        final ISelection selection = IEql2Factory.eINSTANCE.createSelection();
        switch (_selectable.getKey()) {
            case AbstractSelectables.Attribute.KEY:
                final String attrName = ((AbstractSelectables.Attribute) _selectable).getAttr();
                final ISelect select = IEql2Factory.eINSTANCE.createSelect();
                selection.addSelect(select);
                select.addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().name(attrName));
                break;
            default:
                break;
        }
        ((INestedQuery) getQuery()).setSelection(selection);
        return getThis();
    }
}
