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

package org.efaps.eql2

import com.google.inject.Injector
import org.eclipse.emf.ecore.EPackage
import org.efaps.eql2.ide.EQLIdeSetup

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class EQLStandaloneSetup extends EQLStandaloneSetupGenerated
{

    /**
     * Do setup.
     */
    def static void doSetup()
    {
        doSetup(null);
    }

    /**
     * Do setup.
     *
     * @param _instance the instance
     */
    def static void doSetup(Object _instance)
    {
        val injector = new EQLIdeSetup().createInjectorAndDoEMFRegistration();
        if (_instance !== null)
        {
            injector.injectMembers(_instance);
        }
    }

    def static <T> T getInstance(Class<T> _class)
    {
        val injector = new EQLIdeSetup().createInjectorAndDoEMFRegistration();
        injector.getInstance(_class)
    }

    override register(Injector injector)
    {
        super.register(injector);
        EPackage.Registry.INSTANCE.put(IEql2Package.eINSTANCE.getNsURI(), IEql2Package.eINSTANCE);
    }
}
