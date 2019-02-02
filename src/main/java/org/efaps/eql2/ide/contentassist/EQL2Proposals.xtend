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
package org.efaps.eql2.ide.contentassist

import java.util.ArrayList
import java.util.HashSet
import java.util.List
import java.util.Set
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.TextRegion
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.eclipse.xtext.util.LazyStringInputStream
import org.efaps.eql2.ide.EQL2IdeSetup

/**
 * The Class EQLProposals.
 *
 * @author The eFaps Team
 */
class EQL2Proposals
{

    /** The log. */
    static Logger LOG = LoggerFactory.getLogger(typeof(EQL2Proposals));

    /** The cinameproviders. */
    static Set<ICINameProvider> CINAMEPROVIDERS = new HashSet;

    /**
     * Gets the CI name providers.
     *
     * @param _provider the provider
     */
    static def registerCINameProviders(ICINameProvider _provider)
    {
        CINAMEPROVIDERS.add(_provider);
    }

    /**
     * Gets the CI name providers.
     *
     * @return the CI name providers
     */
    static def Set<ICINameProvider> getCINameProviders()
    {
        return CINAMEPROVIDERS;
    }

    static def List<String> getProposalList(String _text)
    {
        val List<String> ret = new ArrayList;
        try
        {
            val resource = EQL2IdeSetup.getInstance(XtextResource);
            resource.load(new LazyStringInputStream(_text), null);
            val cas = EQL2IdeSetup.getInstance(EQL2ContentAssistService)
            val selection = new TextRegion(_text.length, 0)
            val result2 = cas.createProposals(resource, resource.parseResult.rootNode.text, selection, _text.length,
                1000)
            result2.forEach[ e | ret.add(e.proposal)]
            println(ret)
        }
        catch (Exception e)
        {
            LOG.error("Catched error", e);
        }
        return ret;
    }
}
