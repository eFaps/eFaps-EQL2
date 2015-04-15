/*
 * Copyright 2003 - 2015 The eFaps Team
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

package org.efaps.eql.stmt.parts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * TODO comment!
 *
 * @author The eFaps Team
 */
public class AbstractQueryPart
    extends AbstractObjectSelectPart
    implements IQueryStmtPart
{
    /**
     * List of types for the Query.
     */
    private final List<String> types = new ArrayList<>();

    @Override
    public void addType(final String _type)
        throws Exception
    {
        this.types.add(_type);
    }

    /*
     * (non-Javadoc)
     * @see
     * org.efaps.eql.stmt.parts.IQueryStmtPart#addWhereAttrEq(java.lang.String,
     * java.lang.String)
     */
    @Override
    public void addWhereAttrEq(final String _attr,
                               final String _value)
        throws Exception
    {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * @see
     * org.efaps.eql.stmt.parts.IQueryStmtPart#addWhereAttrNotEq(java.lang.String
     * , java.lang.String)
     */
    @Override
    public void addWhereAttrNotEq(final String _attr,
                                  final String _value)
        throws Exception
    {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * @see
     * org.efaps.eql.stmt.parts.IQueryStmtPart#addWhereAttrGreater(java.lang
     * .String, java.lang.String)
     */
    @Override
    public void addWhereAttrGreater(final String _attr,
                                    final String _value)
        throws Exception
    {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * @see
     * org.efaps.eql.stmt.parts.IQueryStmtPart#addWhereAttrLess(java.lang.String
     * , java.lang.String)
     */
    @Override
    public void addWhereAttrLess(final String _attr,
                                 final String _value)
        throws Exception
    {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * @see
     * org.efaps.eql.stmt.parts.IQueryStmtPart#addWhereAttrLike(java.lang.String
     * , java.lang.String)
     */
    @Override
    public void addWhereAttrLike(final String _attr,
                                 final String _value)
        throws Exception
    {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * @see
     * org.efaps.eql.stmt.parts.IQueryStmtPart#addWhereAttrIn(java.lang.String,
     * java.util.Collection)
     */
    @Override
    public void addWhereAttrIn(final String _attr,
                               final Collection<String> _values)
        throws Exception
    {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * @see
     * org.efaps.eql.stmt.parts.IQueryStmtPart#addWhereSelectEq(java.lang.String
     * , java.lang.String)
     */
    @Override
    public void addWhereSelectEq(final String _select,
                                 final String _value)
        throws Exception
    {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * @see
     * org.efaps.eql.stmt.parts.IQueryStmtPart#addWhereSelectLike(java.lang.
     * String, java.lang.String)
     */
    @Override
    public void addWhereSelectLike(final String _select,
                                   final String _value)
        throws Exception
    {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * @see
     * org.efaps.eql.stmt.parts.IQueryStmtPart#addWhereSelectGreater(java.lang
     * .String, java.lang.String)
     */
    @Override
    public void addWhereSelectGreater(final String _select,
                                      final String _value)
        throws Exception
    {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * @see
     * org.efaps.eql.stmt.parts.IQueryStmtPart#addWhereSelectLess(java.lang.
     * String, java.lang.String)
     */
    @Override
    public void addWhereSelectLess(final String _select,
                                   final String _value)
        throws Exception
    {
        // TODO Auto-generated method stub

    }


    /**
     * Getter method for the instance variable {@link #types}.
     *
     * @return value of instance variable {@link #types}
     */
    public List<String> getTypes()
    {
        return this.types;
    }

}
