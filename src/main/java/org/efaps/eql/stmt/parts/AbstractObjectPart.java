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
import java.util.Arrays;
import java.util.List;

import org.efaps.eql.stmt.AbstractEQLStmt;

/**
 * TODO comment!
 *
 * @author The eFaps Team
 */
public class AbstractObjectPart
    extends AbstractEQLStmt
    implements IObjectStmtPart
{

    /**
     * Instance to be updated.
     */
    private final List<String> instances = new ArrayList<>();

    @Override
    public void addInstance(final String... _oid)
        throws Exception
    {
        this.instances.addAll(Arrays.asList(_oid));
    }

    /**
     * Getter method for the instance variable {@link #instance}.
     *
     * @return value of instance variable {@link #instance}
     */
    public List<String> getInstances()
    {
        return this.instances;
    }

}