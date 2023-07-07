/*
 * Copyright 2003 - 2017 The eFaps Team
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

import org.apache.commons.lang3.ArrayUtils;
import org.efaps.eql2.EQL2;
import org.efaps.eql2.IAttributeSelectElement;
import org.efaps.eql2.IBaseSelectElement;
import org.efaps.eql2.IClassSelectElement;
import org.efaps.eql2.IEql2Factory;
import org.efaps.eql2.IExecSelectElement;
import org.efaps.eql2.ILinkfromSelectElement;
import org.efaps.eql2.ILinktoSelectElement;
import org.efaps.eql2.IListStmt;
import org.efaps.eql2.IPrintStatement;
import org.efaps.eql2.IQuery;
import org.efaps.eql2.ISelect;
import org.efaps.eql2.ISelectElement;
import org.efaps.eql2.ISelection;
import org.efaps.eql2.SimpleSelectElement;
import org.efaps.eql2.impl.PrintQueryStatement;

/**
 * The Class PrintEQLBuilder.
 *
 * @author The eFaps Team
 * @param <T> the generic type
 */
public abstract class AbstractPrintEQLBuilder<T extends AbstractPrintEQLBuilder<T>>
    extends AbstractEQLBuilder<T>
{

    /**
     * Prints the.
     *
     * @param _oids the oids
     * @return the t
     */
    public T print(final String... _oids)
    {
        if (_oids == null ||_oids.length == 0) {
            setStmt(IEql2Factory.eINSTANCE.createPrintQueryStatement());
        } else if (_oids.length == 1) {
            setStmt(IEql2Factory.eINSTANCE.createPrintObjectStatement().oid(_oids[0]));
        } else {
            setStmt(IEql2Factory.eINSTANCE.createPrintListStatement());
            for (final String oid : _oids) {
                ((IListStmt<?>) getStmt()).addOid(oid);
            }
        }
        ((IPrintStatement<?>) getStmt()).selection();
        return getThis();
    }

    /**
     * Prints the.
     *
     * @param _oids the oids
     * @return the t
     */
    public T print(final AbstractQueryEQLBuilder<?> _queryBuilder)
    {
        setStmt(IEql2Factory.eINSTANCE.createPrintQueryStatement());
        ((IPrintStatement<?>) getStmt()).selection();
        ((PrintQueryStatement) getStmt()).setQueryC((IQuery) _queryBuilder.getQuery());
        return getThis();
    }

    public AbstractQueryEQLBuilder<?> query(final String... _types) {
        final AbstractQueryEQLBuilder<?> ret = EQL2.builder().query(_types);
        ret.setPrint(this);
        return ret;
    }

    /**
     * Attribute.
     *
     * @param _attrName the attr name
     * @return the t
     */
    public T attribute(final String... _attrName)
    {
        initSelect();
        for (final String attrName : _attrName) {
            final ISelection selection = ((IPrintStatement<?>) getStmt()).getSelection();
            ISelect select = selection.getSelects(selection.getSelectsLength() - 1);
            if (ArrayUtils.isNotEmpty(select.getElements())) {
                final ISelectElement lastElement = select.getElements(select.getElementsLength() - 1);
                if (!connectable(lastElement)) {
                    ((IPrintStatement<?>) getStmt()).getSelection().addSelect(IEql2Factory.eINSTANCE.createSelect());
                    select = selection.getSelects(selection.getSelectsLength() - 1);
                }
            }
            select.addElement(IEql2Factory.eINSTANCE.createAttributeSelectElement().name(attrName));
        }
        return getThis();
    }

    public T attributeSet(final String... _attrSetName)
    {
        initSelect();
        for (final String attrSetName : _attrSetName) {
            final ISelection selection = ((IPrintStatement<?>) getStmt()).getSelection();
            ISelect select = selection.getSelects(selection.getSelectsLength() - 1);
            if (ArrayUtils.isNotEmpty(select.getElements())) {
                final ISelectElement lastElement = select.getElements(select.getElementsLength() - 1);
                if (!connectable(lastElement)) {
                    ((IPrintStatement<?>) getStmt()).getSelection().addSelect(IEql2Factory.eINSTANCE.createSelect());
                    select = selection.getSelects(selection.getSelectsLength() - 1);
                }
            }
            select.addElement(IEql2Factory.eINSTANCE.createAttributeSetSelectElement().name(attrSetName));
        }
        return getThis();
    }

    protected boolean connectable(final ISelectElement element)
    {
        return !(element instanceof IAttributeSelectElement
                        || element instanceof IBaseSelectElement
                        || element instanceof IExecSelectElement);
    }

    /**
     * Linkto.
     *
     * @param _attrName the attr name
     * @return the t
     */
    public T linkto(final String _attrName)
    {
        initSelect();
        final ISelection selection = ((IPrintStatement<?>) getStmt()).getSelection();
        final ISelect currentSelect = selection.getSelects(selection.getSelectsLength() - 1);
        if (currentSelect.getElementsLength() > 0) {
            final ISelectElement element = currentSelect.getElements()[currentSelect.getElementsLength() - 1];
            if (!(element instanceof ILinktoSelectElement || element instanceof ILinkfromSelectElement
                            || element instanceof IClassSelectElement)) {
                selection.addSelect(IEql2Factory.eINSTANCE.createSelect());
            }
        }
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEql2Factory.eINSTANCE
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
        initSelect();
        final ISelection selection = ((IPrintStatement<?>) getStmt()).getSelection();
        final ISelect currentSelect = selection.getSelects(selection.getSelectsLength() - 1);
        if (currentSelect.getElementsLength() > 0) {
            final ISelectElement element = currentSelect.getElements()[currentSelect.getElementsLength() - 1];
            if (!(element instanceof ILinktoSelectElement || element instanceof ILinkfromSelectElement
                            || element instanceof IClassSelectElement)) {
                selection.addSelect(IEql2Factory.eINSTANCE.createSelect());
            }
        }
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEql2Factory.eINSTANCE
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
        initSelect();
        final ISelection selection = ((IPrintStatement<?>) getStmt()).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEql2Factory.eINSTANCE
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
        final ISelection selection = ((IPrintStatement<?>) getStmt()).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEql2Factory.eINSTANCE
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
        initSelect();
        final ISelection selection = ((IPrintStatement<?>) getStmt()).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEql2Factory.eINSTANCE
                        .createBaseSelectElement().setElementC(SimpleSelectElement.CLASS));
        return getThis();
    }

    public T clazz(final String _type)
    {
        initSelect();

        final ISelection selection = ((IPrintStatement<?>) getStmt()).getSelection();
        final ISelect currentSelect = selection.getSelects(selection.getSelectsLength() - 1);
        if (currentSelect.getElementsLength() > 0) {
            final ISelectElement element = currentSelect.getElements()[currentSelect.getElementsLength() - 1];
            if (!(element instanceof ILinktoSelectElement || element instanceof ILinkfromSelectElement
                            || element instanceof IClassSelectElement)) {
                selection.addSelect(IEql2Factory.eINSTANCE.createSelect());
            }
        }
        selection.getSelects(selection.getSelectsLength() - 1)
                        .addElement(IEql2Factory.eINSTANCE.createClassSelectElement().setNameC(_type));
        return getThis();
    }

    /**
     * Instance.
     *
     * @return the t
     */
    public T file()
    {
        initSelect();
        final ISelection selection = ((IPrintStatement<?>) getStmt()).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEql2Factory.eINSTANCE
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
        initSelect();
        final ISelection selection = ((IPrintStatement<?>) getStmt()).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEql2Factory.eINSTANCE
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
        initSelect();
        final ISelection selection = ((IPrintStatement<?>) getStmt()).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEql2Factory.eINSTANCE
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
        initSelect();
        final ISelection selection = ((IPrintStatement<?>) getStmt()).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEql2Factory.eINSTANCE
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
        initSelect();
        final ISelection selection = ((IPrintStatement<?>) getStmt()).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEql2Factory.eINSTANCE
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
        initSelect();
        final ISelection selection = ((IPrintStatement<?>) getStmt()).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEql2Factory.eINSTANCE
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
        initSelect();
        final ISelection selection = ((IPrintStatement<?>) getStmt()).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEql2Factory.eINSTANCE
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
        initSelect();
        final ISelection selection = ((IPrintStatement<?>) getStmt()).getSelection();
        var select = selection.getSelects(selection.getSelectsLength() - 1);
        if (ArrayUtils.isNotEmpty(select.getElements())) {
            final ISelectElement lastElement = select.getElements(select.getElementsLength() - 1);
            if (!connectable(lastElement)) {
                ((IPrintStatement<?>) getStmt()).getSelection().addSelect(IEql2Factory.eINSTANCE.createSelect());
                select = selection.getSelects(selection.getSelectsLength() - 1);
            }
        }
        select.addElement(IEql2Factory.eINSTANCE.createBaseSelectElement().setElementC(SimpleSelectElement.STATUS));
        return getThis();
    }

    /**
     * Type.
     *
     * @return the t
     */
    public T type()
    {
        initSelect();
        final ISelection selection = ((IPrintStatement<?>) getStmt()).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEql2Factory.eINSTANCE
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
        initSelect();
        final ISelection selection = ((IPrintStatement<?>) getStmt()).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEql2Factory.eINSTANCE
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
        initSelect();
        final ISelection selection = ((IPrintStatement<?>) getStmt()).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEql2Factory.eINSTANCE
                        .createBaseSelectElement().setElementC(SimpleSelectElement.UOM));
        return getThis();
    }

    /**
     * Value.
     *
     * @return the t
     */
    public T first()
    {
        initSelect();
        final ISelection selection = ((IPrintStatement<?>) getStmt()).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEql2Factory.eINSTANCE
                        .createBaseSelectElement().setElementC(SimpleSelectElement.FIRST));
        return getThis();
    }

    public T last()
    {
        initSelect();
        final ISelection selection = ((IPrintStatement<?>) getStmt()).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEql2Factory.eINSTANCE
                        .createBaseSelectElement().setElementC(SimpleSelectElement.LAST));
        return getThis();
    }

    /**
     * Value.
     *
     * @return the t
     */
    public T value()
    {
        initSelect();
        final ISelection selection = ((IPrintStatement<?>) getStmt()).getSelection();
        selection.getSelects(selection.getSelectsLength() - 1).addElement(IEql2Factory.eINSTANCE
                        .createBaseSelectElement().setElementC(SimpleSelectElement.VALUE));
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
        final ISelection selection = ((IPrintStatement<?>) getStmt()).getSelection();
        final ISelect select = selection.getSelects(selection.getSelectsLength() - 1);
        select.alias(_alias);
        return getThis();
    }

    /**
     * Select.
     *
     * @param _selects the selects
     * @return the t
     */
    public T select(final ISelectable... _selects) {
        for (final ISelectable select : _selects) {
            switch (select.getKey()) {
                case AbstractSelectables.Attribute.KEY:
                    attribute(((AbstractSelectables.Attribute) select).getAttr());
                    break;
                case AbstractSelectables.Linkto.KEY:
                    final AbstractSelectables.Linkto linkto = (AbstractSelectables.Linkto) select;
                    linkto(linkto.getAttr());
                    select(linkto.getChild());
                    break;
                case AbstractSelectables.INSTANCE:
                    instance();
                    break;
                default:
                    break;
            }
        }
        return getThis();
    }

    public T select(final String... _selects) {
        for (final var select : _selects) {
            final var iSelect = EQL2.parseSelect(select);
            final ISelection selection = ((IPrintStatement<?>) getStmt()).getSelection();
            selection.addSelect(iSelect);
        }
        return getThis();
    }


    public T orderBy(final String _key) {
        return orderBy(_key, false);
    }

    public T orderBy(final String _key, final boolean _desc) {
        ((PrintQueryStatement) getStmt()).orderBy(_key, _desc);
        return getThis();
    }

    /**
     * Inits the select.
     */
    protected void initSelect() {
        final ISelection selection = ((IPrintStatement<?>) getStmt()).getSelection();
        if (ArrayUtils.isEmpty(selection.getSelects())) {
            ((IPrintStatement<?>) getStmt()).getSelection().addSelect(IEql2Factory.eINSTANCE.createSelect());
        }
    }
}
