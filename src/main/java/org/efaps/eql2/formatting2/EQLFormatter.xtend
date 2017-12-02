/*
 * Copyright 2003 - 2017 The eFaps Team
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
package org.efaps.eql2.formatting2

import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.efaps.eql2.IPrintQueryStatement
import org.efaps.eql2.IPrintStatement
import org.efaps.eql2.IQuery
import org.efaps.eql2.IWhereSelect
import org.efaps.eql2.ISelection
import org.efaps.eql2.ILinktoSelectElement
import org.efaps.eql2.ISelect
import org.efaps.eql2.IAttributeSelectElement
import org.efaps.eql2.ISelectElement
import org.efaps.eql2.IWhereElement
import org.efaps.eql2.IEql2Package
import org.efaps.eql2.IOrder

class EQLFormatter extends AbstractFormatter2
{

    def dispatch void format(
        IPrintStatement<?> _printStatement,
        extension IFormattableDocument _document
    )
    {
        _printStatement.getSelection.format;
        _printStatement.getOrder.format;
        _printStatement.regionFor.keyword(".")
    }

    def dispatch void format(
        IPrintQueryStatement _printQueryStatement,
        extension IFormattableDocument _document
    )
    {
        println(textRegionAccess)
        val pt = _printQueryStatement.regionFor.keyword(".")
        pt.prepend[noSpace].append[oneSpace]

        _printQueryStatement.getQuery.format;
        _printQueryStatement.getSelection.format;
        _printQueryStatement.order.format;
    }

    def dispatch void format(
        IQuery _query,
        extension IFormattableDocument _document
    )
    {
        _query.getWhere.format;
    }

    def dispatch void format(
        IWhereSelect _whereSelect,
        extension IFormattableDocument _document
    )
    {
        val pt = _whereSelect.regionFor.keyword(".")
        pt.prepend[noSpace].append[noSpace]
        for (ISelectElement element : _whereSelect.elements)
        {
            element.format
        }
    }

    def dispatch void format(
        ISelection _selection,
        extension IFormattableDocument _document
    )
    {
        _selection.regionFor.keyword("select").prepend[autowrap]
        _selection.regionFor.keyword(",").prepend[noSpace].append[oneSpace]
        for (ISelect select : _selection.selects)
        {
            select.format
        }
    }

    def dispatch void format(
        ISelect _select,
        extension IFormattableDocument _document
    )
    {
        for (ISelectElement element : _select.elements)
        {
            element.format
        }
    }

    def dispatch void format(
        ILinktoSelectElement _element,
        extension IFormattableDocument _document
    )
    {
        _element.regionFor.keyword("linkto[").append[noSpace]
        _element.regionFor.keyword("]").prepend[noSpace]
    }

    def dispatch void format(
        IAttributeSelectElement _element,
        extension IFormattableDocument _document
    )
    {
        _element.regionFor.keyword("attribute[").append[noSpace]
        _element.regionFor.keyword("]").prepend[noSpace]
    }

    def dispatch void format(
        IWhereElement _whereElement,
        extension IFormattableDocument _document
    )
    {
        _whereElement.regionFor
            .feature(IEql2Package.Literals.WHERE_ELEMENT__VALUES)
            .prepend[space = " \""].append[space = "\" "]

        _whereElement.select.format
    }

    def dispatch void format(
        IOrder _order,
        extension IFormattableDocument _document
    )
    {
        _order.regionFor.keyword(",").prepend[noSpace]
    }
}
