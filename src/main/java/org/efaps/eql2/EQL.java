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

import org.efaps.eql.bldr.AbstractEQLBuilder;
import org.efaps.eql.bldr.AbstractInsertEQLBuilder;
import org.efaps.eql.bldr.AbstractPrintEQLBuilder;
import org.efaps.eql.bldr.AbstractUpdateEQLBuilder;
import org.efaps.eql.bldr.AbstractWhereBuilder;

/**
 * The Class EQL.
 *
 * @author The eFaps Team
 */
public abstract class EQL
{

    /** The instance. */
    private static EQL INSTANCE;

    /**
     * Gets the prints the.
     *
     * @return the prints the
     */
    protected abstract AbstractPrintEQLBuilder<?> getPrint();

    /**
     * Gets the prints the.
     *
     * @return the prints the
     */
    protected abstract AbstractUpdateEQLBuilder<?> getUpdate();

    /**
     * Gets the prints the.
     *
     * @return the prints the
     */
    protected abstract AbstractInsertEQLBuilder<?> getInsert();

    /**
     * Gets the prints the.
     *
     * @param _parent the parent
     * @return the prints the
     */
    protected abstract AbstractWhereBuilder<?> getWhere(AbstractEQLBuilder<?> _parent);

    /**
     * Prints the.
     *
     * @return the abstract print EQL builder<?>
     */
    public static AbstractPrintEQLBuilder<?> print()
    {
        return eql().getPrint().print();
    }

    /**
     * Prints the.
     *
     * @param _oid the oid
     * @return the abstract print EQL builder<?>
     */
    public static AbstractPrintEQLBuilder<?> print(final String... _oid)
    {
        return eql().getPrint().print(_oid);
    }

    /**
     * Update.
     *
     * @return the abstract EQL builder<?>
     */
    public static AbstractUpdateEQLBuilder<?> update()
    {
        return eql().getUpdate().update();
    }

    /**
     * Update.
     *
     * @param _oid the oid
     * @return the abstract EQL builder<?>
     */
    public static AbstractUpdateEQLBuilder<?> update(final String... _oid)
    {
        return eql().getUpdate().update(_oid);
    }

    /**
     * Insert.
     *
     * @param _typeName the type name
     * @return the abstract EQL builder<?>
     */
    public static AbstractInsertEQLBuilder<?> insert(final String _typeName)
    {
        return eql().getInsert().insert(_typeName);
    }

    /**
     * Insert.
     *
     * @param _parent the parent
     * @return the abstract EQL builder<?>
     */
    public static AbstractWhereBuilder<?> where(final AbstractEQLBuilder<?> _parent)
    {
        return eql().getWhere(_parent);
    }

    /**
     * Gets the.
     *
     * @return the eql
     */
    protected static EQL eql()
    {
        if (INSTANCE == null) {
            INSTANCE = EQLService.get().getEQL();
        }
        return INSTANCE;
    }
}
