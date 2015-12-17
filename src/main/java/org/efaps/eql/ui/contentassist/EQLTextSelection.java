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
package org.efaps.eql.ui.contentassist;

import org.eclipse.jface.text.ITextSelection;

/**
 * The Class EQLTextSelection.
 *
 * @author The eFaps Team
 */
public class EQLTextSelection
    implements ITextSelection
{

    /** The offset. */
    int offset;

    /** The txt. */
    private final String txt;

    /**
     * Instantiates a new EQL text selection.
     *
     * @param _txt the txt
     * @param _offset the offset
     */
    public EQLTextSelection(final String _txt,
                            final int _offset)
    {
        this.txt = _txt;
        this.offset = _offset;
    }

    @Override
    public boolean isEmpty()
    {
        return this.txt.isEmpty();
    }

    @Override
    public int getOffset()
    {
        return this.offset;
    }

    @Override
    public int getLength()
    {
        return this.txt.length();
    }

    @Override
    public int getStartLine()
    {
        return 0;
    }

    @Override
    public int getEndLine()
    {
        return 0;
    }

    @Override
    public String getText()
    {
        return this.txt;
    }
}
