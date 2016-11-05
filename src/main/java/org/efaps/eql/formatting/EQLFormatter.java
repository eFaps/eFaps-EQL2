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
package org.efaps.eql.formatting;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

/**
 * This class contains custom formatting declarations.
 *
 * See
 * https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#formatting
 * on how and when to use it.
 *
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an
 * example
 */
public class EQLFormatter
    extends AbstractDeclarativeFormatter
{

    @Override
    protected void configureFormatting(final FormattingConfig _fconf)
    {
        final org.efaps.eql.services.EQLGrammarAccess gr = (org.efaps.eql.services.EQLGrammarAccess) getGrammarAccess();

        for (final Keyword comma : gr.findKeywords(",", "]")) {
            _fconf.setNoLinewrap().before(comma);
            _fconf.setNoSpace().before(comma);
        }

        for (final Keyword keyWord : gr.findKeywords("linkto[", "attribute[")) {
            _fconf.setNoSpace().after(keyWord);
        }

        for (final Keyword keyWord : gr.findKeywords(".")) {
            _fconf.setNoSpace().around(keyWord);
        }
    }
}
