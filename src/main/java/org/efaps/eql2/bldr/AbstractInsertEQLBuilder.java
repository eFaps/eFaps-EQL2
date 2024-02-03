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

/**
 * The Class PrintEQLBuilder.
 *
 * @author The eFaps Team
 * @param <T> the generic type
 */
public abstract class AbstractInsertEQLBuilder<T extends AbstractInsertEQLBuilder<T>>
    extends AbstractUpdateEQLBuilder<T>
{
    /**
     * Prints the.
     *
     * @param _type the type
     * @return the t
     */
    public T insert(final String _type)
    {
        setStmt(IEql2Factory.eINSTANCE.createInsertStatement().typeName(_type));
        return getThis();
    }
}
