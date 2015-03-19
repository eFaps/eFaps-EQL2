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
 * Revision:        $Rev$
 * Last Changed:    $Date$
 * Last Changed By: $Author$
 */

package org.efaps.eql;

import org.efaps.eql.eQL.Comparison;
import org.efaps.eql.eQL.Statement;
import org.efaps.eql.eQL.WherePart;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * TODO comment!
 *
 * @author The eFaps Team
 * @version $Id: $
 */
public class WhereTest
    extends AbstractTest
{

    @Test(description = "where ATTRIBUTE eq NUMBER")
    public void eqNum()
        throws Exception
    {
        final Statement stmt = getStatement("where DocumentLink eq 4");
        final WherePart where = stmt.getWherePart();
        Assert.assertEquals(where.getWheres().get(0).getAttribute(), "DocumentLink");
        Assert.assertEquals(where.getWheres().get(0).getComparison(), Comparison.EQUAL);
        Assert.assertEquals(where.getWheres().get(0).getValue(), "4");
    }

    @Test(description = "where ATTRIBUTE eq NUMBER and ATTRIBUTE eq number")
    public void eqNumAndEqNum()
        throws Exception
    {
        final Statement stmt = getStatement("where DocumentLink eq 4 and Description eq 567");
        final WherePart where = stmt.getWherePart();
        Assert.assertEquals(where.getWheres().get(0).getAttribute(), "DocumentLink");
        Assert.assertEquals(where.getWheres().get(0).getComparison(), Comparison.EQUAL);
        Assert.assertEquals(where.getWheres().get(0).getValue(), "4");
        Assert.assertEquals(where.getWheres().get(1).getAttribute(), "Description");
        Assert.assertEquals(where.getWheres().get(1).getComparison(), Comparison.EQUAL);
        Assert.assertEquals(where.getWheres().get(1).getValue(), "567");
    }

    @Test(description = "where ATTRIBUTE == NUMBER")
    public void equalsNum()
        throws Exception
    {
        final Statement stmt = getStatement("where DocumentLink == 4");
        final WherePart where = stmt.getWherePart();
        Assert.assertEquals(where.getWheres().get(0).getAttribute(), "DocumentLink");
        Assert.assertEquals(where.getWheres().get(0).getComparison(), Comparison.EQUAL);
        Assert.assertEquals(where.getWheres().get(0).getValue(), "4");
    }

    @Test(description = "where ATTRIBUTE == NUMBER and ATTRIBUTE == number")
    public void equalsNumAndEqualsNum()
        throws Exception
    {
        final Statement stmt = getStatement("where DocumentLink == 4 and Description == 567");
        final WherePart where = stmt.getWherePart();
        Assert.assertEquals(where.getWheres().get(0).getAttribute(), "DocumentLink");
        Assert.assertEquals(where.getWheres().get(0).getComparison(), Comparison.EQUAL);
        Assert.assertEquals(where.getWheres().get(0).getValue(), "4");
        Assert.assertEquals(where.getWheres().get(1).getAttribute(), "Description");
        Assert.assertEquals(where.getWheres().get(1).getComparison(), Comparison.EQUAL);
        Assert.assertEquals(where.getWheres().get(1).getValue(), "567");
    }

    @Test(description = "where ATTRIBUTE < NUMBER")
    public void lessNum()
        throws Exception
    {
        final Statement stmt = getStatement("where DocumentLink < 4");
        final WherePart where = stmt.getWherePart();
        Assert.assertEquals(where.getWheres().get(0).getAttribute(), "DocumentLink");
        Assert.assertEquals(where.getWheres().get(0).getComparison(), Comparison.LESS);
        Assert.assertEquals(where.getWheres().get(0).getValue(), "4");
    }

    @Test(description = "where ATTRIBUTE > NUMBER")
    public void greaterNum()
        throws Exception
    {
        final Statement stmt = getStatement("where DocumentLink > 4");
        final WherePart where = stmt.getWherePart();
        Assert.assertEquals(where.getWheres().get(0).getAttribute(), "DocumentLink");
        Assert.assertEquals(where.getWheres().get(0).getComparison(), Comparison.GREATER);
        Assert.assertEquals(where.getWheres().get(0).getValue(), "4");
    }

    @Test(description = "where ATTRIBUTE !- NUMBER")
    public void unequalNum()
        throws Exception
    {
        final Statement stmt = getStatement("where DocumentLink != 4");
        final WherePart where = stmt.getWherePart();
        Assert.assertEquals(where.getWheres().get(0).getAttribute(), "DocumentLink");
        Assert.assertEquals(where.getWheres().get(0).getComparison(), Comparison.UNEQUAL);
        Assert.assertEquals(where.getWheres().get(0).getValue(), "4");
    }

    @Test(description = "where ATTRIBUTE eq OID")
    public void eqOID()
        throws Exception
    {
        final Statement stmt = getStatement("where DocumentLink eq 123.567");
        final WherePart where = stmt.getWherePart();
        Assert.assertEquals(where.getWheres().get(0).getAttribute(), "DocumentLink");
        Assert.assertEquals(where.getWheres().get(0).getComparison(), Comparison.EQUAL);
        Assert.assertEquals(where.getWheres().get(0).getValue(), "123.567");
    }

    @Test(description = "where ATTRIBUTE == OID")
    public void equalsOID()
        throws Exception
    {
        final Statement stmt = getStatement("where DocumentLink == 123.567");
        final WherePart where = stmt.getWherePart();
        Assert.assertEquals(where.getWheres().get(0).getAttribute(), "DocumentLink");
        Assert.assertEquals(where.getWheres().get(0).getComparison(), Comparison.EQUAL);
        Assert.assertEquals(where.getWheres().get(0).getValue(), "123.567");
    }

    @Test(description = "where ATTRIBUTE !- OID")
    public void unequalOID()
        throws Exception
    {
        final Statement stmt = getStatement("where DocumentLink != 123.567");
        final WherePart where = stmt.getWherePart();
        Assert.assertEquals(where.getWheres().get(0).getAttribute(), "DocumentLink");
        Assert.assertEquals(where.getWheres().get(0).getComparison(), Comparison.UNEQUAL);
        Assert.assertEquals(where.getWheres().get(0).getValue(), "123.567");
    }

    @Test(description = "where ATTRIBUTE eq STRING")
    public void eqString()
        throws Exception
    {
        final Statement stmt = getStatement("where DocumentLink eq \"Blaues Hause\"");
        final WherePart where = stmt.getWherePart();
        Assert.assertEquals(where.getWheres().get(0).getAttribute(), "DocumentLink");
        Assert.assertEquals(where.getWheres().get(0).getComparison(), Comparison.EQUAL);
        Assert.assertEquals(where.getWheres().get(0).getValue(), "Blaues Hause");
    }

    @Test(description = "where ATTRIBUTE == STRING")
    public void equalsString()
        throws Exception
    {
        final Statement stmt = getStatement("where DocumentLink == \"Blaues Hause\"");
        final WherePart where = stmt.getWherePart();
        Assert.assertEquals(where.getWheres().get(0).getAttribute(), "DocumentLink");
        Assert.assertEquals(where.getWheres().get(0).getComparison(), Comparison.EQUAL);
        Assert.assertEquals(where.getWheres().get(0).getValue(), "Blaues Hause");
    }

    @Test(description = "where ATTRIBUTE < STRING")
    public void lessString()
        throws Exception
    {
        final Statement stmt = getStatement("where DocumentLink < \"Blaues Hause\"");
        final WherePart where = stmt.getWherePart();
        Assert.assertEquals(where.getWheres().get(0).getAttribute(), "DocumentLink");
        Assert.assertEquals(where.getWheres().get(0).getComparison(), Comparison.LESS);
        Assert.assertEquals(where.getWheres().get(0).getValue(), "Blaues Hause");
    }

    @Test(description = "where ATTRIBUTE > STRING")
    public void greaterString()
        throws Exception
    {
        final Statement stmt = getStatement("where DocumentLink > \"Blaues Hause\"");
        final WherePart where = stmt.getWherePart();
        Assert.assertEquals(where.getWheres().get(0).getAttribute(), "DocumentLink");
        Assert.assertEquals(where.getWheres().get(0).getComparison(), Comparison.GREATER);
        Assert.assertEquals(where.getWheres().get(0).getValue(), "Blaues Hause");
    }

    @Test(description = "where ATTRIBUTE !- STRING")
    public void unequalString()
        throws Exception
    {
        final Statement stmt = getStatement("where DocumentLink != \"Blaues Hause\"");
        final WherePart where = stmt.getWherePart();
        Assert.assertEquals(where.getWheres().get(0).getAttribute(), "DocumentLink");
        Assert.assertEquals(where.getWheres().get(0).getComparison(), Comparison.UNEQUAL);
        Assert.assertEquals(where.getWheres().get(0).getValue(), "Blaues Hause");
    }

    @Test(description = "where ATTRIBUTE like STRING")
    public void likeString()
        throws Exception
    {
        final Statement stmt = getStatement("where DocumentLink like \"%Blaues Hause\"");
        final WherePart where = stmt.getWherePart();
        Assert.assertEquals(where.getWheres().get(0).getAttribute(), "DocumentLink");
        Assert.assertEquals(where.getWheres().get(0).getComparison(), Comparison.LIKE);
        Assert.assertEquals(where.getWheres().get(0).getValue(), "%Blaues Hause");
    }

    @Test(description = "comination test for ")
    public void eqLessGreaterUnequalLike()
        throws Exception
    {
        final Statement stmt = getStatement("where DocumentLink == 4 and Description < 567 and House like \"%Blaues Hause\" and HouseNumber > 459");
        final WherePart where = stmt.getWherePart();
        Assert.assertEquals(where.getWheres().get(0).getAttribute(), "DocumentLink");
        Assert.assertEquals(where.getWheres().get(0).getComparison(), Comparison.EQUAL);
        Assert.assertEquals(where.getWheres().get(0).getValue(), "4");
        Assert.assertEquals(where.getWheres().get(1).getAttribute(), "Description");
        Assert.assertEquals(where.getWheres().get(1).getComparison(), Comparison.LESS);
        Assert.assertEquals(where.getWheres().get(1).getValue(), "567");
        Assert.assertEquals(where.getWheres().get(2).getAttribute(), "House");
        Assert.assertEquals(where.getWheres().get(2).getComparison(), Comparison.LIKE);
        Assert.assertEquals(where.getWheres().get(2).getValue(), "%Blaues Hause");
        Assert.assertEquals(where.getWheres().get(3).getAttribute(), "HouseNumber");
        Assert.assertEquals(where.getWheres().get(3).getComparison(), Comparison.GREATER);
        Assert.assertEquals(where.getWheres().get(3).getValue(), "459");
    }

    @Test(description = "where ATTRIBUTE in (NUMBER,NUMBER,NUMBER)")
    public void inNums()
        throws Exception
    {
        final Statement stmt = getStatement("where DocumentLink in (4,7,12318)");
        final WherePart where = stmt.getWherePart();
        Assert.assertEquals(where.getWheres().get(0).getAttribute(), "DocumentLink");
        Assert.assertEquals(where.getWheres().get(0).getComparison(), Comparison.IN);
        Assert.assertEquals(where.getWheres().get(0).getValues().toArray(),
                        new String[] { "4", "7", "12318" });
    }

    @Test(description = "where ATTRIBUTE in (NUMBER,NUMBER,NUMBER)")
    public void inStrings()
        throws Exception
    {
        final Statement stmt = getStatement("where DocumentLink in (\"4\",\"das it ein langer etxt\",\"Bla bal bal\")");
        final WherePart where = stmt.getWherePart();
        Assert.assertEquals(where.getWheres().get(0).getAttribute(), "DocumentLink");
        Assert.assertEquals(where.getWheres().get(0).getComparison(), Comparison.IN);
        Assert.assertEquals(where.getWheres().get(0).getValues().toArray(),
                        new String[] { "4", "das it ein langer etxt", "Bla bal bal" });
    }

    @Test(description = "combination test for attributes ")
    public void eqLessGreaterUnequalLikeIn()
        throws Exception
    {
        final Statement stmt = getStatement("where DocumentLink == 4 and Description < 567 and House like \"%Blaues Hause\" and DocLink in (\"4\",\"das it ein langer etxt\",\"Bla bal bal\") and HouseNumber > 459");
        final WherePart where = stmt.getWherePart();
        Assert.assertEquals(where.getWheres().get(0).getAttribute(), "DocumentLink");
        Assert.assertEquals(where.getWheres().get(0).getComparison(), Comparison.EQUAL);
        Assert.assertEquals(where.getWheres().get(0).getValue(), "4");
        Assert.assertEquals(where.getWheres().get(1).getAttribute(), "Description");
        Assert.assertEquals(where.getWheres().get(1).getComparison(), Comparison.LESS);
        Assert.assertEquals(where.getWheres().get(1).getValue(), "567");
        Assert.assertEquals(where.getWheres().get(2).getAttribute(), "House");
        Assert.assertEquals(where.getWheres().get(2).getComparison(), Comparison.LIKE);
        Assert.assertEquals(where.getWheres().get(2).getValue(), "%Blaues Hause");

        Assert.assertEquals(where.getWheres().get(3).getAttribute(), "DocLink");
        Assert.assertEquals(where.getWheres().get(3).getComparison(), Comparison.IN);
        Assert.assertEquals(where.getWheres().get(3).getValues().toArray(),
                        new String[] { "4", "das it ein langer etxt", "Bla bal bal" });

        Assert.assertEquals(where.getWheres().get(4).getAttribute(), "HouseNumber");
        Assert.assertEquals(where.getWheres().get(4).getComparison(), Comparison.GREATER);
        Assert.assertEquals(where.getWheres().get(4).getValue(), "459");
    }

    @Test(description = "where SELECT eq NUMBER")
    public void selectEqNum()
        throws Exception
    {
        final Statement stmt = getStatement("where linkto[DocumentLink].attribute[Code] eq 4");
        final WherePart where = stmt.getWherePart();
        Assert.assertEquals(where.getWheres().get(0).getSelect(), "linkto[DocumentLink].attribute[Code]");
        Assert.assertEquals(where.getWheres().get(0).getComparison(), Comparison.EQUAL);
        Assert.assertEquals(where.getWheres().get(0).getValue(), "4");
    }

    @Test(description = "where SELECT == NUMBER and SELECT == number")
    public void selectEqualsNumAndEqualsNum()
        throws Exception
    {
        final Statement stmt = getStatement("where linkto[DocumentLink].attribute[Code] == 4 and "
                        + "linkto[DocumentLink].attribute[Descriptiobn] == 567");
        final WherePart where = stmt.getWherePart();
        Assert.assertEquals(where.getWheres().get(0).getSelect(), "linkto[DocumentLink].attribute[Code]");
        Assert.assertEquals(where.getWheres().get(0).getComparison(), Comparison.EQUAL);
        Assert.assertEquals(where.getWheres().get(0).getValue(), "4");
        Assert.assertEquals(where.getWheres().get(1).getSelect(), "linkto[DocumentLink].attribute[Descriptiobn]");
        Assert.assertEquals(where.getWheres().get(1).getComparison(), Comparison.EQUAL);
        Assert.assertEquals(where.getWheres().get(1).getValue(), "567");
    }

    @Test(description = "where SELECT < NUMBER")
    public void selectLessNum()
        throws Exception
    {
        final Statement stmt = getStatement("where linkto[DocumentLink].attribute[Code] < 4");
        final WherePart where = stmt.getWherePart();
        Assert.assertEquals(where.getWheres().get(0).getSelect(), "linkto[DocumentLink].attribute[Code]");
        Assert.assertEquals(where.getWheres().get(0).getComparison(), Comparison.LESS);
        Assert.assertEquals(where.getWheres().get(0).getValue(), "4");
    }

    @Test(description = "where SELECT > STRING")
    public void selectGreaterString()
        throws Exception
    {
        final Statement stmt = getStatement("where linkto[DocumentLink].attribute[Code] > \"Blaues Hause\"");
        final WherePart where = stmt.getWherePart();
        Assert.assertEquals(where.getWheres().get(0).getSelect(), "linkto[DocumentLink].attribute[Code]");
        Assert.assertEquals(where.getWheres().get(0).getComparison(), Comparison.GREATER);
        Assert.assertEquals(where.getWheres().get(0).getValue(), "Blaues Hause");
    }


    @Test(description = "combination test for selects ")
    public void selectEqLessGreaterUnequalLikeIn()
        throws Exception
    {
        final Statement stmt = getStatement("where linkto[DocumentLink].attribute[Code] == 4 "
                        + "and linkto[DocumentLink].attribute[Description]  < 567 "
                        + "and linkto[DocumentLink].attribute[House]  like \"%Blaues Hause\" "
                        + "and linkto[DocumentLink].attribute[DocLink] in (\"4\",\"das it ein langer etxt\",\"Bla bal bal\") "
                        + "and linkto[DocumentLink].attribute[HouseNumber] > 459");
        final WherePart where = stmt.getWherePart();
        Assert.assertEquals(where.getWheres().get(0).getSelect(), "linkto[DocumentLink].attribute[Code]");
        Assert.assertEquals(where.getWheres().get(0).getComparison(), Comparison.EQUAL);
        Assert.assertEquals(where.getWheres().get(0).getValue(), "4");
        Assert.assertEquals(where.getWheres().get(1).getSelect(), "linkto[DocumentLink].attribute[Description]");
        Assert.assertEquals(where.getWheres().get(1).getComparison(), Comparison.LESS);
        Assert.assertEquals(where.getWheres().get(1).getValue(), "567");
        Assert.assertEquals(where.getWheres().get(2).getSelect(), "linkto[DocumentLink].attribute[House]");
        Assert.assertEquals(where.getWheres().get(2).getComparison(), Comparison.LIKE);
        Assert.assertEquals(where.getWheres().get(2).getValue(), "%Blaues Hause");

        Assert.assertEquals(where.getWheres().get(3).getSelect(), "linkto[DocumentLink].attribute[DocLink]");
        Assert.assertEquals(where.getWheres().get(3).getComparison(), Comparison.IN);
        Assert.assertEquals(where.getWheres().get(3).getValues().toArray(),
                        new String[] { "4", "das it ein langer etxt", "Bla bal bal" });

        Assert.assertEquals(where.getWheres().get(4).getSelect(), "linkto[DocumentLink].attribute[HouseNumber]");
        Assert.assertEquals(where.getWheres().get(4).getComparison(), Comparison.GREATER);
        Assert.assertEquals(where.getWheres().get(4).getValue(), "459");
    }

}
