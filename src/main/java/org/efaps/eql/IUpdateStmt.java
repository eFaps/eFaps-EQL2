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


/**
 * TODO comment!
 *
 * @author The eFaps Team
 * @version $Id: $
 */
public interface IUpdateStmt
    extends IEQLStmt
{

    /**
     * @param _oid set the object the Statement will be executed for
     * @throws Exception on error
     */
    void setInstance(final String _oid)
        throws Exception;

    /**
     * @param _attribute Attribute to be added to the Update
     * @param _value value for the related Attribute
     * @throws Exception on error
     */
    void addUpdate(final String _attribute,
                   final String _value)
        throws Exception;

    /**
     * Execute the update.
     * @throws Exception on error
     */
    void execute()
        throws Exception;
}
