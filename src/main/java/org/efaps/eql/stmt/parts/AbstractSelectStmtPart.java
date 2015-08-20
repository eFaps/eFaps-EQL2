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

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * TODO comment!
 *
 * @author The eFaps Team
 */
public abstract class AbstractSelectStmtPart
    extends AbstractQueryStmtPart
    implements ISelectStmtPart
{

    private final Map<String, String> alias2Selects = new LinkedHashMap<>();

    private final Map<String, Boolean> sortKey2desc = new LinkedHashMap<>();

    @Override
    public void addSelect(final String _select,
                          final String _alias)
        throws Exception
    {
        String alias;
        if (_alias == null) {
            alias = Integer.valueOf(getAlias2Selects().size() + 1).toString();
        } else {
            alias = _alias;
        }
        getAlias2Selects().put(alias, _select);
    }

    @Override
    public Map<String, String> getAlias2Selects()
        throws Exception
    {
        return this.alias2Selects;
    }

    @Override
    public Map<String, Boolean> getSortKey2desc()
        throws Exception
    {
        return this.sortKey2desc;
    }

    @Override
    public void addOrder(final String _key,
                         final Boolean _desc)
        throws Exception
    {
        getSortKey2desc().put(_key, _desc);
    }
}
