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

    /**
     * Prints the.
     *
     * @param _type the type
     * @return the t
     */
    public T insert(final String _type)
    {
        this.stmt = IEqlFactory.eINSTANCE.createInsertStatement().typeName(_type);
        return getThis();
    }

    /**
     * Prints the.
     *
     * @param _oids the oids
     * @return the t
     */
    public T update(final String... _oids)
    {
        if (_oids.length == 1) {
            this.stmt = IEqlFactory.eINSTANCE.createUpdateObjectStatement().oid(_oids[0]);
        } else {
            this.stmt = IEqlFactory.eINSTANCE.createUpdateListStatement();
            for (final String oid : _oids) {
                ((IListStmt<?>) this.stmt).addOid(oid);
            }
        }
        return getThis();
    }

    /**
     * Prints the.
     *
     * @return the t
     */
    public T update()
    {
        this.stmt = IEqlFactory.eINSTANCE.createUpdateQueryStatement();
        return getThis();
    }

    /**
     * Sets the.
     *
     * @param _attrName the attr name
     * @param _value the value
     * @return the t
     */
    public T set(final String _attrName,
                 final String _value)
    {
        ((IUpdateElementsStmt<?>) this.stmt).addUpdateElements(IEqlFactory.eINSTANCE.createUpdateElement().attribute(
                        _attrName).value(_value));
        return getThis();
    }

    /**
     * Prints the.
     *
     * @param _oids the oids
     * @return the t
     */
    public T print(final String... _oids)
    {
        if (_oids.length == 1) {
            this.stmt = IEqlFactory.eINSTANCE.createPrintObjectStatement().oid(_oids[0]);
        } else {
            this.stmt = IEqlFactory.eINSTANCE.createPrintListStatement();
            for (final String oid : _oids) {
                ((IListStmt<?>) this.stmt).addOid(oid);
            }
        }
        return getThis();
    }

    /**
     * Prints the.
     *
     * @return the t
     */
    public T print()
    {
        this.stmt = IEqlFactory.eINSTANCE.createPrintQueryStatement();
        return getThis();
    }

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
     * Select.
     *
     * @return the t
     */
    public T select()
    {
        ((IPrintStatement<?>) this.stmt).selection();
        ((IPrintStatement<?>) this.stmt).getSelection().addSelect(IEqlFactory.eINSTANCE.createSelect());
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
    public T where()
    {
        ((IQueryStmt<?>) this.stmt).getQuery().where();
        return getThis();
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
     * Where attr eq value.
     *
     * @param _attrName the attr name
     * @param _values the values
     * @return the t
     */
    public T attrEqValue(final String _attrName,
                         final String... _values)
    {
        final IWhereElement element = getCurrentTerm().element();
        element.attribute(_attrName);
        element.comparison(_values.length == 1 ? Comparison.EQUAL : Comparison.IN);
        for (final String value : _values) {
            element.addValue(value);
        }
        return getThis();
    }

    /**
     * Where attr eq value.
     *
     * @param _attrName the attr name
     * @param _value the value
     * @return the t
     */
    public T attrLessValue(final String _attrName,
                           final String _value)
    {
        final IWhereElement element = getCurrentTerm().element();
        element.attribute(_attrName).comparison(Comparison.LESS).addValue(_value);
        return getThis();
    }

    /**
     * Where attr eq value.
     *
     * @param _attrName the attr name
     * @param _value the value
     * @return the t
     */
    public T attrGreaterValue(final String _attrName,
                              final String _value)
    {
        final IWhereElement element = getCurrentTerm().element();
        element.attribute(_attrName).comparison(Comparison.GREATER).addValue(_value);
        return getThis();
    }

    /**
     * Where attr eq value.
     *
     * @param _attrName the attr name
     * @param _value the value
     * @return the t
     */
    public T attrMatchValue(final String _attrName,
                              final String _value)
    {
        final IWhereElement element = getCurrentTerm().element();
        element.attribute(_attrName).comparison(Comparison.LIKE).addValue(_value);
        return getThis();
    }

    /**
     * Where attr eq value.
     *
     * @param _attrName the attr name
     * @param _values the values
     * @return the t
     */
    public T attrNotValue(final String _attrName,
                          final String... _values)
    {
        final IWhereElement element = getCurrentTerm().element();
        element.attribute(_attrName);
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
        ((IQueryStmt<?>) this.stmt).getQuery().where();
        final IWhere where = ((IQueryStmt<?>) this.stmt).getQuery().getWhere();
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
        ((IQueryStmt<?>) this.stmt).getQuery().where();
        final IWhere where = ((IQueryStmt<?>) this.stmt).getQuery().getWhere();
        where.term().or();
        return getThis();
    }

    /**
     * Gets the this.
     *
     * @return the this
     */
    @SuppressWarnings("unchecked")
    protected T getThis()
    {
        return (T) this;
    }

    /**
     * Gets the stmt.
     *
     * @return the stmt
     */
    protected IStatement<?> getStmt()
    {
        return this.stmt;
    }

}
