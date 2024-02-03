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

public abstract class AbstractDeleteEQLBuilder<T extends AbstractDeleteEQLBuilder<T>>
    extends AbstractEQLBuilder<T>
{
    public T delete(final String... _oids)
    {
        if (_oids.length == 1) {
            setStmt(IEql2Factory.eINSTANCE.createDeleteObjectStatement().oid(_oids[0]));
        } else {
            setStmt(IEql2Factory.eINSTANCE.createDeleteListStatement());
            for (final String oid : _oids) {
                ((IListStmt<?>) getStmt()).addOid(oid);
            }
        }
        return getThis();
    }
}
