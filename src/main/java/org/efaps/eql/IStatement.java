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


/**
 * TODO comment!
 *
 * @author The eFaps Team
 * @version $Id$
 */
public interface IStatement
{


    /**
     * @param _select Select to be added to the Statement
     * @param _value  alias for the related select
     */
    public void addWhereSelectEq(final String _select,
                                 final String _value);
    /**

    /**
     * @param _select     Name of the Attribute
     * @param _values   list of values
     */
    public void addWhereSelectIn(final String _select,
                                 final Collection<String> _values);


    /**
     * @param _select Select to be added to the Statement
     * @param _alias  alias for the related select
     */
    public void addWhereSelectGreater(final String _select,
                                      final String _value);


    /**
     * @param _select Select to be added to the Statement
     * @param _alias  alias for the related select
     */
    public void addWhereSelectLess(final String _select,
                                   final String _value);

}
