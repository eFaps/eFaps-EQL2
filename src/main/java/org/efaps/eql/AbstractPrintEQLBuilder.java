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
     * @return the t
     */
    public T print()
    {
        setStmt(IEqlFactory.eINSTANCE.createPrintQueryStatement());
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
            setStmt(IEqlFactory.eINSTANCE.createPrintObjectStatement().oid(_oids[0]));
        } else {
            setStmt(IEqlFactory.eINSTANCE.createPrintListStatement());
            for (final String oid : _oids) {
                ((IListStmt<?>) getStmt()).addOid(oid);
            }
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
        ((IPrintStatement<?>) getStmt()).selection();
        ((IPrintStatement<?>) getStmt()).getSelection().addSelect(IEqlFactory.eINSTANCE.createSelect());
        return getThis();
    }
}
