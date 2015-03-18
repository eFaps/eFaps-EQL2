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
 * Revision:        $Rev$
 * Last Changed:    $Date$
 * Last Changed By: $Author$
 */

package org.efaps.eql;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * TODO comment!
 *
 * @author The eFaps Team
 * @version $Id: $
 */
public class NonOpQuery
    extends AbstractQueryStmt
{

    @Override
    public List<Map<String, Object>> getData()
        throws Exception
    {
        // Non operational implementation
        return null;
    }

    @Override
    public void addType(final String _type)
    {
        // Non operational implementation
    }

    @Override
    public void addWhereAttrEq(final String _attr,
                               final String _value)
    {
        // Non operational implementation
    }

    @Override
    public void addWhereAttrNotEq(final String _attr,
                                  final String _value)
    {
        // Non operational implementation
    }

    @Override
    public void addWhereAttrGreater(final String _attr,
                                    final String _value)
    {
        // Non operational implementation
    }

    @Override
    public void addWhereAttrLess(final String _attr,
                                 final String _value)
    {
        // Non operational implementation
    }

    @Override
    public void addWhereAttrLike(final String _attr,
                                 final String _value)
    {
        // Non operational implementation
    }

    @Override
    public void addWhereAttrIn(final String _attr,
                               final Collection<String> _values)
    {
        // Non operational implementation
    }
}
