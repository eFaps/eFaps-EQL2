/*
 * Copyright 2003 - 2016 The eFaps Team
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
package org.efaps.eql;

import java.util.ServiceLoader;

/**
 * The Class EQLProvider.
 *
 * @author The eFaps Team
 */
public final class EQLService
{

    /** The instance. */
    private static EQLService INSTANCE;

    /** The loader. */
    private final ServiceLoader<EQL> loader;

    /** The eql. */
    private EQL eql;

    /**
     * Instantiates a new EQL service.
     */
    private EQLService()
    {
        this.loader = ServiceLoader.load(EQL.class);
    }

    /**
     * Gets the eql.
     *
     * @return the eql
     */
    protected EQL getEQL()
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
    protected static synchronized EQLService get()
    {
        if (INSTANCE == null) {
            INSTANCE = new EQLService();
        }
        return INSTANCE;
    }
}
