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


/**
 * TODO comment!
 *
 * @author The eFaps Team
 */
public interface IQueryStmtPart
{

    /**
     * @param _type Type to be added to the Statement
     */
    void addType(final String _type)
        throws Exception;

    /**
     * @param _attr Select to be added to the Statement
     * @param _value alias for the related select
     */
    void addWhereAttrEq(final String _attr,
                        final String _value)
        throws Exception;

    /**
     * @param _attr Select to be added to the Statement
     * @param _value alias for the related select
     */
    void addWhereAttrNotEq(final String _attr,
                           final String _value)
        throws Exception;

    /**
     * @param _select Select to be added to the Statement
     * @param _alias alias for the related select
     */
    void addWhereAttrGreater(final String _attr,
                             final String _value)
        throws Exception;

    /**
     * @param _select Select to be added to the Statement
     * @param _alias alias for the related select
     */
    void addWhereAttrLess(final String _attr,
                          final String _value)
        throws Exception;

    /**
     * @param _select Select to be added to the Statement
     * @param _alias alias for the related select
     */
    void addWhereAttrLike(final String _attr,
                          final String _value)
        throws Exception;

    /**
     * @param _attr Name of the Attribute
     * @param _values list of values
     */
    void addWhereAttrIn(final String _attr,
                        final String... _values)
        throws Exception;

    void addWhereSelectEq(final String _select,
                          final String _value)
        throws Exception;

    void addWhereSelectLike(final String _select,
                            final String _value)
        throws Exception;

    void addWhereSelectGreater(final String _select,
                               final String _value)
        throws Exception;

    void addWhereSelectLess(final String _select,
                            final String _value)
        throws Exception;

}
