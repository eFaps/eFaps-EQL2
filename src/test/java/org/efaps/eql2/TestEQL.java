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
package org.efaps.eql2;

import org.efaps.eql2.bldr.AbstractDeleteEQLBuilder;
import org.efaps.eql2.bldr.AbstractInsertEQLBuilder;
import org.efaps.eql2.bldr.AbstractPrintEQLBuilder;
import org.efaps.eql2.bldr.AbstractQueryEQLBuilder;
import org.efaps.eql2.bldr.AbstractSelectables;
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
    protected AbstractQueryEQLBuilder<?> getQuery()
    {
        return new QueryEQLBuilder();
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
    protected AbstractDeleteEQLBuilder<?> getDelete()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected AbstractWhereBuilder<?> getWhere()
    {
        return new WhereBuilder();
    }

    @Override
    protected AbstractSelectables getSelectables()
    {
        return new Selectables();
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
    public static class QueryEQLBuilder
        extends AbstractQueryEQLBuilder<QueryEQLBuilder>
    {
        @Override
        protected QueryEQLBuilder getThis()
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
        public WhereBuilder()
        {
            super();
        }

        @Override
        protected WhereBuilder getThis()
        {
            return this;
        }
    }

    /**
     * The Class Selectables.
     */
    public static class Selectables
        extends AbstractSelectables
    {
    }
}
