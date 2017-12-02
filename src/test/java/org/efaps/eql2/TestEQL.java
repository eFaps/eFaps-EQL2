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
package org.efaps.eql2;

import org.efaps.eql2.bldr.AbstractEQLBuilder;
import org.efaps.eql2.bldr.AbstractInsertEQLBuilder;
import org.efaps.eql2.bldr.AbstractPrintEQLBuilder;
import org.efaps.eql2.bldr.AbstractUpdateEQLBuilder;
import org.efaps.eql2.bldr.AbstractWhereBuilder;

/**
 * The Class TestEQL.
 *
 * @author The eFaps Team
 */
public class TestEQL
    extends EQL
{

    @Override
    protected AbstractPrintEQLBuilder<?> getPrint()
    {
        return new PrintEQLBuilder();
    }

    @Override
    protected AbstractUpdateEQLBuilder<?> getUpdate()
    {
        return new UpdateEQLBuilder();
    }

    @Override
    protected AbstractInsertEQLBuilder<?> getInsert()
    {
        return new InsertEQLBuilder();
    }

    @Override
    protected AbstractWhereBuilder<?> getWhere(final AbstractEQLBuilder<?> _parent)
    {
        return new WhereBuilder(_parent);
    }

    /**
     * The Class PrintEQLBuilder.
     *
     */
    public static class PrintEQLBuilder
        extends AbstractPrintEQLBuilder<PrintEQLBuilder>
    {
        @Override
        protected PrintEQLBuilder getThis()
        {
            return this;
        }
    }

    /**
     * The Class PrintEQLBuilder.
     *
     */
    public static class UpdateEQLBuilder
        extends AbstractUpdateEQLBuilder<UpdateEQLBuilder>
    {
        @Override
        protected UpdateEQLBuilder getThis()
        {
            return this;
        }
    }

    /**
     * The Class PrintEQLBuilder.
     *
     */
    public static class InsertEQLBuilder
        extends AbstractInsertEQLBuilder<InsertEQLBuilder>
    {
        @Override
        protected InsertEQLBuilder getThis()
        {
            return this;
        }
    }

    /**
     * The Class PrintEQLBuilder.
     *
     */
    public static class WhereBuilder
        extends AbstractWhereBuilder<WhereBuilder>
    {

        /**
         * Instantiates a new where builder.
         *
         * @param _parent the parent
         */
        public WhereBuilder(final AbstractEQLBuilder<?> _parent)
        {
            super(_parent);
        }

        @Override
        protected WhereBuilder getThis()
        {
            return this;
        }
    }

}
