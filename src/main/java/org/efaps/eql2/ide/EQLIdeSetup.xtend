/*
 * generated by Xtext 2.11.0 for eFaps-EQL
 */
package org.efaps.eql2.ide

import com.google.inject.Guice
import org.eclipse.xtext.util.Modules2
import org.efaps.eql2.EQLRuntimeModule
import org.efaps.eql2.EQLStandaloneSetup

/**
 * Initialization support for running Xtext languages as language servers.
 */
class EQLIdeSetup extends EQLStandaloneSetup {

    override createInjector() {
        Guice.createInjector(Modules2.mixin(new EQLRuntimeModule, new EQLIdeModule))
    }

}