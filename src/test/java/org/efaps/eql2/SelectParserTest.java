package org.efaps.eql2;

import static org.testng.Assert.assertEquals;

import org.efaps.eql2.impl.AttributeSelectElement;
import org.efaps.eql2.impl.FormatSelectElement;
import org.efaps.eql2.impl.LinktoSelectElement;
import org.testng.annotations.Test;

public class SelectParserTest
    extends AbstractTest
{
    @Test(description = "simple attribute")
    public void attribute()
    {
        final var parst = getSelectParser().doParse("attribute[Name]");
        final var select = (ISelect) parst.getRootASTElement();
        assertEquals(select.getElements().length, 1);
        assertEquals(((AttributeSelectElement) select.getElements()[0]).getName(), "Name");
    }

    @Test(description = "linkto with Attribute")
    public void linktoAttr()
    {
        final var parst = getSelectParser().doParse("linkto[Demo].attribute[Name]");
        final var select = (ISelect) parst.getRootASTElement();
        assertEquals(select.getElements().length, 2);
        assertEquals(((LinktoSelectElement) select.getElements()[0]).getName(), "Demo");
        assertEquals(((AttributeSelectElement) select.getElements()[1]).getName(), "Name");
    }

    @Test(description = "Attribute with format")
    public void attrWithFormat()
    {
        final var parst = getSelectParser().doParse("attribute[RateNetTotal].format[#,##0.00]");
        final var select = (ISelect) parst.getRootASTElement();
        assertEquals(select.getElements().length, 2);
        assertEquals(((AttributeSelectElement) select.getElements()[0]).getName(), "RateNetTotal");
        assertEquals(((FormatSelectElement) select.getElements()[1]).getPattern(), "#,##0.00");
    }

    @Test(description = "Attribute with String format")
    public void attrWithStringFormat()
    {
        final var parst = getSelectParser().doParse("attribute[StringAttribute].format[' %s-4 ']");
        final var select = (ISelect) parst.getRootASTElement();
        assertEquals(select.getElements().length, 2);
        assertEquals(((AttributeSelectElement) select.getElements()[0]).getName(), "StringAttribute");
        assertEquals(((FormatSelectElement) select.getElements()[1]).getPattern(), " %s-4 ");
    }

    @Test(description = "Attribute with String format quotes")
    public void attrWithStringFormatQuotes()
    {
        final var parst = getSelectParser().doParse("attribute[StringAttribute].format[\" f%s-9s \"]");
        final var select = (ISelect) parst.getRootASTElement();
        assertEquals(select.getElements().length, 2);
        assertEquals(((AttributeSelectElement) select.getElements()[0]).getName(), "StringAttribute");
        assertEquals(((FormatSelectElement) select.getElements()[1]).getPattern(), " f%s-9s ");
    }
}
