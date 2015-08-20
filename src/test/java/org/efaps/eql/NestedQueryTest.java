package org.efaps.eql;

import org.eclipse.emf.common.util.EList;
import org.efaps.eql.eQL.NestedQueryPart;
import org.efaps.eql.eQL.OneWhere;
import org.efaps.eql.eQL.Statement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestedQueryTest
    extends AbstractTest
{

    @Test(description = "print query type Sales_Invoice select one Attribute")
    public void subQuery()
        throws Exception
    {
        final Statement stmt = getStatement("print query type Sales_InvoicePosition where Invoice in "
                        + "( query type Sales_Invoice select attribute[ID] )");
        final EList<OneWhere> wheres = stmt.getQueryPart().getWherePart().getWheres();
        final NestedQueryPart subQuery = wheres.get(0).getNestedQueryPart();

        Assert.assertEquals(subQuery.getTypes().get(0), "Sales_Invoice");
        Assert.assertEquals(subQuery.getSelectPart().getSelects().get(0).getSelect(), "attribute[ID]");
    }


    @Test(description = "print query type Sales_Invoice select one Attribute")
    public void subQueryWithWhere()
        throws Exception
    {
        final Statement stmt = getStatement("print query type Sales_InvoicePosition where Invoice in "
                        + "( query type Sales_Invoice where attribute[ID] == 15 select attribute[ID] )");
        final EList<OneWhere> wheres = stmt.getQueryPart().getWherePart().getWheres();
        final NestedQueryPart subQuery = wheres.get(0).getNestedQueryPart();

        Assert.assertEquals(subQuery.getTypes().get(0), "Sales_Invoice");
        Assert.assertEquals(subQuery.getSelectPart().getSelects().get(0).getSelect(), "attribute[ID]");
    }

    @Test(description = "print query type Sales_Invoice select one Attribute")
    public void subQueryWithoutSelect()
        throws Exception
    {
        final Statement stmt = getStatement("print query type Sales_InvoicePosition where Invoice in "
                        + "( query type Sales_Invoice )");
        final EList<OneWhere> wheres = stmt.getQueryPart().getWherePart().getWheres();
        final NestedQueryPart subQuery = wheres.get(0).getNestedQueryPart();

        Assert.assertEquals(subQuery.getTypes().get(0), "Sales_Invoice");
        Assert.assertTrue(subQuery.getSelectPart() == null);
    }


}
