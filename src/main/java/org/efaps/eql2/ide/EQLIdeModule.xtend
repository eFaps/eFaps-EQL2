/*
 * generated by Xtext 2.11.0 for eFaps-EQL
 */
package org.efaps.eql2.ide

import org.eclipse.xtext.ide.editor.contentassist.antlr.IContentAssistParser
import org.efaps.eql2.ide.contentassist.antlr.PartialEQLContentAssistParser

/**
 * Use this class to register ide components.
 */
class EQLIdeModule extends AbstractEQLIdeModule {

    // contributed by org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
    override Class<? extends IContentAssistParser> bindIContentAssistParser() {
        return typeof (PartialEQLContentAssistParser);
    }
}