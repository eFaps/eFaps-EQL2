/*
 * Copyright 2003 - 2018 The eFaps Team
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

package org.efaps.eql2.bldr;

import org.efaps.eql2.EQL;

/**
 * The Class AbstractSelectables.
 */
public abstract class AbstractSelectables
{
    public static final String INSTANCE = "instance";

    /**
     * Gets the linkto.
     *
     * @param _linktoAttr the linkto attr
     * @return the linkto
     */
    protected abstract AbstractLinkto getLinkto(final String _linktoAttr);

    /**
     * Linkto.
     *
     * @param _linktoAttr the linkto attr
     * @return the abstract linkto
     */
    public static AbstractLinkto linkto(final String _linktoAttr)
    {
        return EQL.sel().getLinkto(_linktoAttr);
    }

    /**
     * Instance.
     *
     * @return the instance
     */
    public static Simple instance() {
        return new Simple(INSTANCE);
    }

    /**
     * The Class Simple.
     */
    public static class Simple
        implements ISelectable
    {

        /** The key. */
        private final String key;

        /**
         * Instantiates a new simple.
         *
         * @param _key the key
         */
        public Simple(final String _key)
        {
            this.key = _key;
        }

        @Override
        public String getKey()
        {
            return this.key;
        }
    }

    /**
     * The Class AbstractLinkto.
     */
    public static class AbstractLinkto
        implements ISelectable
    {

        /** The Constant KEY. */
        public static final String KEY = "linkto";

        /** The linkto attr. */
        private final String linktoAttr;

        /** The attr. */
        private String attr;

        /**
         * Instantiates a new abstract linkto.
         *
         * @param _attr the attr
         */
        public AbstractLinkto(final String _attr)
        {
            this.linktoAttr = _attr;
        }

        /**
         * Attr.
         *
         * @param _attr the attr
         * @return the abstract linkto
         */
        public AbstractLinkto attr(final String _attr)
        {
            return attribute(_attr);
        }

        /**
         * Attribute.
         *
         * @param _attr the attr
         * @return the abstract linkto
         */
        public AbstractLinkto attribute(final String _attr)
        {
            this.attr = _attr;
            return this;
        }

        /**
         * Gets the linkto attr.
         *
         * @return the linkto attr
         */
        protected String getLinktoAttr()
        {
            return this.linktoAttr;
        }

        /**
         * Gets the attr.
         *
         * @return the attr
         */
        protected String getAttr()
        {
            return this.attr;
        }
        @Override
        public String getKey()
        {
            return KEY;
        }
    }
}
