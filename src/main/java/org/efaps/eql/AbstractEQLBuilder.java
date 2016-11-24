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
     * @param _oid the oid
     * @return the t
     */
    public T print(final String _oid)
    {
        this.stmt = IEqlFactory.eINSTANCE.createPrintObjectStatement().oid(_oid);
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
