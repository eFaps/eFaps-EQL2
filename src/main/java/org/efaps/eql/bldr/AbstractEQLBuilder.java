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
package org.efaps.eql.bldr;

import org.efaps.eql.EQL;
import org.efaps.eql.IEqlFactory;
import org.efaps.eql.IPrintStatement;
import org.efaps.eql.IQueryStmt;
import org.efaps.eql.ISelect;
import org.efaps.eql.ISelection;
import org.efaps.eql.IStatement;
import org.efaps.eql.IWhere;
import org.efaps.eql.SimpleSelectElement;
import org.efaps.eql.impl.WhereElementTerm;

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
     * As.
     *
     * @param _alias the alias
     * @return the t
     */
    public T as(final String _alias)
    {
        final ISelection selection = ((IPrintStatement<?>) this.stmt).getSelection();
        final ISelect select = selection.getSelects(selection.getSelectsLength() - 1);
        select.alias(_alias);
        return getThis();
    }

    /**
     * Attribute.
     *
     * @param _attrName the attr name
     * @return the t
     */
    public T attribute(final String _attrName)
    {
        final ISelection selection = ((IPrintStatement<?>) this.stmt).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEqlFactory.eINSTANCE
                        .createAttributeSelectElement().name(_attrName));
        return getThis();
    }

    /**
     * Linkto.
     *
     * @param _attrName the attr name
     * @return the t
     */
    public T linkto(final String _attrName)
    {
        final ISelection selection = ((IPrintStatement<?>) this.stmt).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEqlFactory.eINSTANCE
                        .createLinktoSelectElement().name(_attrName));
        return getThis();
    }

    /**
     * Linkto.
     *
     * @param _type the type
     * @param _attrName the attr name
     * @return the t
     */
    public T linkfrom(final String _type,
                      final String _attrName)
    {
        final ISelection selection = ((IPrintStatement<?>) this.stmt).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEqlFactory.eINSTANCE
                        .createLinkfromSelectElement().typeName(_type).attribute(_attrName));
        return getThis();
    }

    /**
     * Instance.
     *
     * @return the t
     */
    public T instance()
    {
        final ISelection selection = ((IPrintStatement<?>) this.stmt).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEqlFactory.eINSTANCE
                        .createBaseSelectElement().setElementC(SimpleSelectElement.INSTANCE));
        return getThis();
    }

    /**
     * Instance.
     *
     * @return the t
     */
    public T base()
    {
        final ISelection selection = ((IPrintStatement<?>) this.stmt).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEqlFactory.eINSTANCE
                        .createBaseSelectElement().setElementC(SimpleSelectElement.BASE));
        return getThis();
    }

    /**
     * Instance.
     *
     * @return the t
     */
    public T clazz()
    {
        final ISelection selection = ((IPrintStatement<?>) this.stmt).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEqlFactory.eINSTANCE
                        .createBaseSelectElement().setElementC(SimpleSelectElement.CLASS));
        return getThis();
    }

    /**
     * Instance.
     *
     * @return the t
     */
    public T file()
    {
        final ISelection selection = ((IPrintStatement<?>) this.stmt).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEqlFactory.eINSTANCE
                        .createBaseSelectElement().setElementC(SimpleSelectElement.FILE));
        return getThis();
    }

    /**
     * Instance.
     *
     * @return the t
     */
    public T id()
    {
        final ISelection selection = ((IPrintStatement<?>) this.stmt).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEqlFactory.eINSTANCE
                        .createBaseSelectElement().setElementC(SimpleSelectElement.ID));
        return getThis();
    }

    /**
     * Instance.
     *
     * @return the t
     */
    public T key()
    {
        final ISelection selection = ((IPrintStatement<?>) this.stmt).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEqlFactory.eINSTANCE
                        .createBaseSelectElement().setElementC(SimpleSelectElement.KEY));
        return getThis();
    }

    /**
     * Instance.
     *
     * @return the t
     */
    public T label()
    {
        final ISelection selection = ((IPrintStatement<?>) this.stmt).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEqlFactory.eINSTANCE
                        .createBaseSelectElement().setElementC(SimpleSelectElement.LABEL));
        return getThis();
    }

    /**
     * Instance.
     *
     * @return the t
     */
    public T length()
    {
        final ISelection selection = ((IPrintStatement<?>) this.stmt).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEqlFactory.eINSTANCE
                        .createBaseSelectElement().setElementC(SimpleSelectElement.LENGTH));
        return getThis();
    }

    /**
     * Instance.
     *
     * @return the t
     */
    public T name()
    {
        final ISelection selection = ((IPrintStatement<?>) this.stmt).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEqlFactory.eINSTANCE
                        .createBaseSelectElement().setElementC(SimpleSelectElement.NAME));
        return getThis();
    }

    /**
     * Oid.
     *
     * @return the t
     */
    public T oid()
    {
        final ISelection selection = ((IPrintStatement<?>) this.stmt).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEqlFactory.eINSTANCE
                        .createBaseSelectElement().setElementC(SimpleSelectElement.OID));
        return getThis();
    }

    /**
     * Status.
     *
     * @return the t
     */
    public T status()
    {
        final ISelection selection = ((IPrintStatement<?>) this.stmt).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEqlFactory.eINSTANCE
                        .createBaseSelectElement().setElementC(SimpleSelectElement.STATUS));
        return getThis();
    }

    /**
     * Type.
     *
     * @return the t
     */
    public T type()
    {
        final ISelection selection = ((IPrintStatement<?>) this.stmt).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEqlFactory.eINSTANCE
                        .createBaseSelectElement().setElementC(SimpleSelectElement.TYPE));
        return getThis();
    }

    /**
     * Uuid.
     *
     * @return the t
     */
    public T uuid()
    {
        final ISelection selection = ((IPrintStatement<?>) this.stmt).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEqlFactory.eINSTANCE
                        .createBaseSelectElement().setElementC(SimpleSelectElement.UUID));
        return getThis();
    }

    /**
     * Uom.
     *
     * @return the t
     */
    public T uom()
    {
        final ISelection selection = ((IPrintStatement<?>) this.stmt).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEqlFactory.eINSTANCE
                        .createBaseSelectElement().setElementC(SimpleSelectElement.UOM));
        return getThis();
    }

    /**
     * Value.
     *
     * @return the t
     */
    public T value()
    {
        final ISelection selection = ((IPrintStatement<?>) this.stmt).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEqlFactory.eINSTANCE
                        .createBaseSelectElement().setElementC(SimpleSelectElement.VALUE));
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
