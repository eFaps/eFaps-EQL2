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
package org.efaps.eql

import org.efaps.eql.converter.ValueConverters
import org.eclipse.jface.viewers.ILabelProvider
import org.eclipse.jface.viewers.ILabelProviderListener
import org.eclipse.xtext.ide.LexerIdeBindings

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
class EQLRuntimeModule extends AbstractEQLRuntimeModule
{
    override bindIValueConverterService()
    {
        return typeof(ValueConverters)
    }

    def configureContentLexer(com.google.inject.Binder _binder)
    {
        _binder.bind(typeof(org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer)).annotatedWith(
            com.google.inject.name.Names.named(LexerIdeBindings.CONTENT_ASSIST)).to(
            typeof(org.efaps.eql.ide.contentassist.antlr.internal.InternalEQLLexer));
    }

    def Class<? extends org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext.Builder> bindContextBuilder()
    {
        return typeof(org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext.Builder)
    }


    def Class<? extends org.eclipse.xtext.ide.editor.contentassist.antlr.IContentAssistParser> bindContentAssistParser()
    {
        return typeof(org.efaps.eql.ide.contentassist.antlr.EQLParser)
    }


    static class Fake implements ILabelProvider
    {

        override getImage(Object element)
        {
            null
        }

        override getText(Object element)
        {
            null
        }

        override addListener(ILabelProviderListener listener)
        {
        }

        override dispose()
        {
        }

        override isLabelProperty(Object element, String property)
        {
            false
        }

        override removeListener(ILabelProviderListener listener)
        {
        }
    }
}
