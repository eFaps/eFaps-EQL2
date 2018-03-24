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

    /** The Constant INSTANCE. */
    public static final String INSTANCE = "instance";

    /**
     * Gets the linkto.
     *
     * @param _linktoAttr the linkto attr
     * @return the linkto
     */
    protected Linkto getLinkto(final String _linktoAttr) {
        return new Linkto(_linktoAttr);
    }

    /**
     * Gets the attribute.
     *
     * @param _attr the attr
     * @return the attribute
     */
    protected Attribute getAttribute(final String _attr) {
        return new Attribute(_attr);
    }

    /**
     * Attribute.
     *
     * @param _attr the attr
     * @return the attribute
     */
    public static Attribute attribute(final String _attr) {
        return  EQL.sel().getAttribute(_attr);
    }

    /**
     * Linkto.
     *
     * @param _linktoAttr the linkto attr
     * @return the abstract linkto
     */
    public static Linkto linkto(final String _linktoAttr)
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
     * The Class AbstractAttrBased.
     */
    public static abstract class AbstractAttrBased
    {

        /** The attr. */
        private final String attr;

        /**
         * Instantiates a new attribute.
         *
         * @param _attr the attr
         */
        public AbstractAttrBased(final String _attr)
        {
            this.attr = _attr;
        }

        /**
         * Gets the attr.
         *
         * @return the attr
         */
        public String getAttr()
        {
            return this.attr;
        }
    }

    /**
     * The Class Attribute.
     */
    public static class Attribute
        extends AbstractAttrBased
        implements ISelectable
    {
        /** The Constant KEY. */
        public static final String KEY = "attribute";

        /**
         * Instantiates a new attribute.
         *
         * @param _attr the attr
         */
        public Attribute(final String _attr) {
            super(_attr);
        }

        @Override
        public String getKey()
        {
            return KEY;
        }
    }

    /**
     * The Class AbstractLinkto.
     */
    public static class Linkto
        extends AbstractAttrBased
        implements ISelectable
    {


        /** The Constant KEY. */
        public static final String KEY = "linkto";

        /** The child. */
        private ISelectable child;

        /**
         * Instantiates a new abstract linkto.
         *
         * @param _attr the attr
         */
        public Linkto(final String _attr)
        {
            super(_attr);
        }

        /**
         * Attr.
         *
         * @param _attr the attr
         * @return the abstract linkto
         */
        public Linkto attr(final String _attr)
        {
            return attribute(_attr);
        }

        /**
         * Attribute.
         *
         * @param _attr the attr
         * @return the abstract linkto
         */
        public Linkto attribute(final String _attr)
        {
            this.child = EQL.sel().getAttribute(_attr);
            return this;
        }

        /**
         * Gets the child.
         *
         * @return the child
         */
        public ISelectable getChild()
        {
            return this.child;
        }

        @Override
        public String getKey()
        {
            return KEY;
        }
    }
}
