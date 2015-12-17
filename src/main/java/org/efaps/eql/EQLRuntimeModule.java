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
 */

package org.efaps.eql;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ide.LexerIdeBindings;
import org.eclipse.xtext.ui.editor.hover.IEObjectHover;
import org.efaps.eql.ui.contentassist.EQLProposalProvider;

/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 */
public class EQLRuntimeModule
    extends org.efaps.eql.AbstractEQLRuntimeModule
{

    /**
     * Configure ILabelProvider.
     *
     * @param _binder the binder
     */
    public void configureILabelProvider(final com.google.inject.Binder _binder)
    {
        _binder.bind(org.eclipse.jface.viewers.ILabelProvider.class).annotatedWith(
                        org.eclipse.xtext.ui.editor.contentassist.ContentProposalLabelProvider.class).to(Fake.class);
    }

    /**
     * Configure ContentLexer.
     *
     * @param _binder the binder
     */
    public void configureContentLexer(final com.google.inject.Binder _binder)
    {
        _binder.bind(org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer.class).annotatedWith(
                        com.google.inject.name.Names.named(LexerIdeBindings.CONTENT_ASSIST)).to(
                                        org.efaps.eql.ide.contentassist.antlr.internal.InternalEQLLexer.class);
    }

    /**
     * Bind i hover.
     *
     * @return the class<? extends org.eclipse.xtext.ui.editor.hover. ie object
     *         hover>
     */
    public Class<? extends org.eclipse.xtext.ui.editor.hover.IEObjectHover> bindIHover()
    {
        return Fake.class;
    }

    /**
     * Bind i content assist parser.
     *
     * @return the class<? extends
     *         org.eclipse.xtext.ui.editor.contentassist.antlr. i content assist
     *         parser>
     */
    @SuppressWarnings("checkstyle:linelength")
    public Class<? extends org.eclipse.xtext.ui.editor.contentassist.antlr.IContentAssistParser> bindIContentAssistParser()
    {
        return org.efaps.eql.ide.contentassist.antlr.EQLParser.class;
    }

    /**
     * Bind ii content proposal provider.
     *
     * @return the class<? extends org.eclipse.xtext.ui.editor.contentassist. i
     *         content proposal provider>
     */
    public Class<? extends org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider> bindIIContentProposalProvider()
    {
        return EQLProposalProvider.class;
    }

    /**
     * The Class Fake.
     *
     */
    public static class Fake
        implements ILabelProvider, IEObjectHover
    {

        @Override
        public void addListener(final ILabelProviderListener _listener)
        {
        }

        @Override
        public void dispose()
        {
        }

        @Override
        public boolean isLabelProperty(final Object _element,
                                       final String _property)
        {
            return false;
        }

        @Override
        public void removeListener(final ILabelProviderListener _listener)
        {
        }

        @Override
        public Image getImage(final Object _element)
        {
            return null;
        }

        @Override
        public String getText(final Object _element)
        {
            return null;
        }

        @Override
        public Object getHoverInfo(final EObject _eObject,
                                   final ITextViewer _textViewer,
                                   final IRegion _hoverRegion)
        {
            return null;
        }
    }

}
