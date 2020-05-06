package org.efaps.eql2;

import static org.testng.Assert.assertEquals;

import org.efaps.eql2.impl.AttributeSelectElement;
import org.efaps.eql2.impl.LinktoSelectElement;
import org.testng.annotations.Test;

public class SelectParserTest
    extends AbstractTest
{

    @Test(description = "print obj")
    public void object()
    {
        final var parst = getSelectParser().doParse("linkto[Demo].attribute[Name]");
        final var select = (ISelect) parst.getRootASTElement();
        assertEquals(select.getElements().length, 2);
        assertEquals(((LinktoSelectElement) select.getElements()[0]).getName(), "Demo");
        assertEquals(((AttributeSelectElement) select.getElements()[1]).getName(), "Name");
    }
}
