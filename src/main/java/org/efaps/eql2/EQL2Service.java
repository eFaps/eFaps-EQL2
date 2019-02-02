/*
 * Copyright 2003 - 2019 The eFaps Team
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

import java.util.ServiceLoader;

/**
 * The Class EQLProvider.
 *
 * @author The eFaps Team
 */
public final class EQL2Service
{

    /** The instance. */
    private static EQL2Service INSTANCE;

    /** The loader. */
    private final ServiceLoader<EQL2> loader;

    /** The eql. */
    private EQL2 eql;

    /**
     * Instantiates a new EQL service.
     */
    private EQL2Service()
    {
        this.loader = ServiceLoader.load(EQL2.class);
    }

    /**
     * Gets the eql.
     *
     * @return the eql
     */
    protected EQL2 getEQL()
    {
        if (this.eql == null) {
            this.eql = this.loader.iterator().next();
        }
        return this.eql;
    }

    /**
     * Gets the.
     *
     * @return the EQL service
     */
    protected static synchronized EQL2Service get()
    {
        if (INSTANCE == null) {
            INSTANCE = new EQL2Service();
        }
        return INSTANCE;
    }
}
