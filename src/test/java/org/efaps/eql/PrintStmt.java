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

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO comment!
 *
 * @author The eFaps Team
 * @version $Id: $
 */
public class PrintStmt
    extends AbstractSelectStmt
    implements IPrintStmt
{
    private String oid;

    private final Map<String, String> alias = new LinkedHashMap<>();

    @Override
    public void addSelect(final String _select,
                          final String _alias)
    {
        this.alias.put(_select, _alias);
    }

    @Override
    public void setInstance(final String _oid)
    {
        this.oid = _oid;
    }


    /**
     * Getter method for the instance variable {@link #oid}.
     *
     * @return value of instance variable {@link #oid}
     */
    public String getOid()
    {
        return this.oid;
    }

    /**
     * Getter method for the instance variable {@link #alias}.
     *
     * @return value of instance variable {@link #alias}
     */
    public Map<String, String> getAlias()
    {
        return this.alias;
    }

    @Override
    public List<Map<String, Object>> getData()
        throws Exception
    {
        return null;
    }

}
