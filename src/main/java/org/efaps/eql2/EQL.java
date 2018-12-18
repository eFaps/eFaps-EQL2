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
import org.efaps.eql2.parser.antlr.EQLParser;

/**
 * The Class EQL.
 *
 * @author The eFaps Team
 */
public abstract class EQL
{

    /** The instance. */
    private static EQL INSTANCE;

    private static AbstractSelectables SELECTABLES;

    @Inject
    private EQLParser parser;

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
    protected abstract AbstractDeleteEQLBuilder<?> getDelete();

    /**
     * Gets the prints the.
     *
     * @param _parent the parent
     * @return the prints the
     */
    protected abstract AbstractWhereBuilder<?> getWhere();


    protected abstract AbstractSelectables getSelectables();

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
     * Prints the.
     *
     * @param _oid the oid
     * @return the abstract print EQL builder<?>
     */
    public static AbstractPrintEQLBuilder<?> print(final AbstractQueryEQLBuilder<?> _queryBuilder)
    {
        return eql().getPrint().print(_queryBuilder);
    }

    /**
     * Prints the.
     *
     * @param _oid the oid
     * @return the abstract print EQL builder<?>
     */
    public static AbstractQueryEQLBuilder<?> query(final String... _types)
    {
        return eql().getQuery().query(_types);
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
      * Delete.
      *
      * @param _oids the oids
      * @return the abstract update EQL builder
      */
     public static AbstractDeleteEQLBuilder<?> delete(final String... _oids)
    {
        return eql().getDelete().delete(_oids);
    }

    /**
     * Insert.
     *
     * @param _parent the parent
     * @return the abstract EQL builder<?>
     */
    public static AbstractWhereBuilder<?> where()
    {
        return eql().getWhere();
    }

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
                System.out.println(node.getSyntaxErrorMessage().getMessage());
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
    protected static EQL eql()
    {
        if (INSTANCE == null) {
            INSTANCE = EQLService.get().getEQL();
            EQLStandaloneSetup.doSetup(INSTANCE);
        }
        return INSTANCE;
    }
}
