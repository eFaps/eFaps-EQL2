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

import java.util.ArrayList;
import java.util.List;

/**
 * TODO comment!
 *
 * @author The eFaps Team
 * @version $Id: $
 */
public abstract class AbstractExecStmt
    extends AbstractSelectStmt
    implements IExecStmt
{

    private String esjpName;

    private final List<String> parameters = new ArrayList<>();

    /**
     * Getter method for the instance variable {@link #className}.
     *
     * @return value of instance variable {@link #className}
     */
    public String getESJPName()
    {
        return this.esjpName;
    }

    /**
     * Setter method for instance variable {@link #className}.
     *
     * @param _className value for instance variable {@link #className}
     */
    @Override
    public void setESJPName(final String _className)
        throws Exception
    {
        this.esjpName = _className;
    }
    @Override
    public void addParameter(final String _parameter)
        throws Exception
    {
        this.parameters.add(_parameter);
    }


    /**
     * Getter method for the instance variable {@link #parameters}.
     *
     * @return value of instance variable {@link #parameters}
     */
    public List<String> getParameters()
    {
        return this.parameters;
    }
}
