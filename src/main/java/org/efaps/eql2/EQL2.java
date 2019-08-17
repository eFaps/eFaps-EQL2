/*
 * Copyright 2003 - 2019 The eFaps Team
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

import com.google.inject.Inject;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.efaps.eql2.bldr.AbstractDeleteEQLBuilder;
import org.efaps.eql2.bldr.AbstractInsertEQLBuilder;
import org.efaps.eql2.bldr.AbstractPrintEQLBuilder;
import org.efaps.eql2.bldr.AbstractQueryEQLBuilder;
import org.efaps.eql2.bldr.AbstractSelectables;
import org.efaps.eql2.bldr.AbstractUpdateEQLBuilder;
import org.efaps.eql2.bldr.AbstractWhereBuilder;
import org.efaps.eql2.parser.antlr.EQL2Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class EQL.
 *
 * @author The eFaps Team
 */
public abstract class EQL2
{
    /**
     * Logging instance used in this class.
     */
    private static final Logger LOG = LoggerFactory.getLogger(EQL2.class);

    /** The instance. */
    private static EQL2 INSTANCE;

    private static AbstractSelectables SELECTABLES;

    @Inject
    private EQL2Parser parser;

    @Inject
    private Serializer serializer;

    /**
     * Gets the prints the.
     *
     * @return the prints the
     */
    protected abstract AbstractPrintEQLBuilder<?> getPrint();

    /**
     * Gets the query.
     *
     * @return the query
     */
    protected abstract AbstractQueryEQLBuilder<?> getQuery();

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
     * @return the prints the
     */
    protected abstract AbstractDeleteEQLBuilder<? extends AbstractDeleteEQLBuilder<?>> getDelete();

    /**
     * Gets the prints the.
     *
     * @param _parent the parent
     * @return the prints the
     */
    protected abstract AbstractWhereBuilder<?> getWhere();

    protected abstract AbstractSelectables getSelectables();

    /**
     * Parses the statement.
     *
     * @param _stmt the stmt to be parsed
     * @return the istatement
     */
    public static IStatement<?> parse(final CharSequence _stmt) {
        final IParseResult result = eql().parser.doParse(_stmt);
        if (result.hasSyntaxErrors()) {
            final Iterator<INode> iter = result.getSyntaxErrors().iterator();
            while (iter.hasNext()) {
                final INode node = iter.next();
                LOG.warn("Syntax Error: {}", node.getSyntaxErrorMessage().getMessage());
            }
        }
        final IStatement<?> ret = (IStatement<?>) result.getRootASTElement();
        return ret;
    }

    /**
     * To EQL.
     *
     * @param _eobj the eobj
     * @return the string
     */
    public static String toEQL(final EObject _eobj) {
        return eql().serializer.serialize(_eobj);
    }

    public static AbstractSelectables sel() {
        if (SELECTABLES == null) {
            SELECTABLES = eql().getSelectables();
        }
        return SELECTABLES;
    }

    /**
     * Gets the.
     *
     * @return the eql
     */
    protected static EQL2 eql()
    {
        if (INSTANCE == null) {
            INSTANCE = EQL2Service.get().getEQL();
            EQL2StandaloneSetup.doSetup(INSTANCE);
        }
        return INSTANCE;
    }

    public static EQL2Builder<?> builder() {
        return new EQL2Builder<>(EQL2.eql());
    }

    public static class EQL2Builder<T extends EQL2Builder<T>>
    {
        private final EQL2 eql2;
        private StmtFlag[] flags;

        public EQL2Builder(final EQL2 _eql2)
        {
            eql2 = _eql2;
        }

        @SuppressWarnings("unchecked")
        public T with(final StmtFlag... _flags)
        {
            flags = _flags;
            return (T) this;
        }

        public AbstractDeleteEQLBuilder<?> delete(final String... _oids)
        {
            return eql2.getDelete().delete(_oids).with(flags);
        }

        public AbstractInsertEQLBuilder<?> insert(final String _typeName)
        {
            return eql2.getInsert().insert(_typeName).with(flags);
        }

        public AbstractUpdateEQLBuilder<?> update(final String... _oids)
        {
            return eql2.getUpdate().update(_oids).with(flags);
        }

        public AbstractPrintEQLBuilder<?> print(final String... _oids)
        {
            return eql2.getPrint().print(_oids).with(flags);
        }

        public AbstractQueryEQLBuilder<?> query(final String... _types)
        {
            return eql2.getQuery().query(_types);
        }

        public AbstractWhereBuilder<?> where()
        {
            return eql2.getWhere();
        }
    }
}
