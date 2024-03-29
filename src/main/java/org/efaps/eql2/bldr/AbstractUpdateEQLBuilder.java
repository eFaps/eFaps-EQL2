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

import org.efaps.eql2.IEql2Factory;
import org.efaps.eql2.IListStmt;
import org.efaps.eql2.IUpdateElementsStmt;

/**
 * The Class PrintEQLBuilder.
 *
 * @author The eFaps Team
 * @param <T> the generic type
 */
public abstract class AbstractUpdateEQLBuilder<T extends AbstractUpdateEQLBuilder<T>>
    extends AbstractEQLBuilder<T>
{
    /**
     * Prints the.
     *
     * @param _oids the oids
     * @return the t
     */
    public T update(final String... _oids)
    {
        if (_oids.length == 1) {
            setStmt(IEql2Factory.eINSTANCE.createUpdateObjectStatement().oid(_oids[0]));
        } else {
            setStmt(IEql2Factory.eINSTANCE.createUpdateListStatement());
            for (final String oid : _oids) {
                ((IListStmt<?>) getStmt()).addOid(oid);
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
        setStmt(IEql2Factory.eINSTANCE.createUpdateQueryStatement());
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
        ((IUpdateElementsStmt<?>) getStmt()).addUpdateElements(IEql2Factory.eINSTANCE.createUpdateElement().attribute(
                        _attrName).value(_value));
        return getThis();
    }
}
