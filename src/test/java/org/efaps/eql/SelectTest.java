/*
 *
 *  Copyright 2003 - 2015 The eFaps Team
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *  Revision:        $Rev: 14661 $
 *  Last Changed:    $Date: 2014-12-23 01:54:38 -0500 (Tue, 23 Dec 2014) $
 *  Last Changed By: $Author: jan@moxter.net $
 */

package org.efaps.eql;

import java.util.ArrayList;
import java.util.List;

import org.efaps.eql.eQL.OneSelect;
import org.efaps.eql.eQL.SelectPart;
import org.efaps.eql.eQL.Statement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectTest
    extends AbstractTest
{

    @Test(description = "Select one Attribute")
    public void oneAttribute()
        throws Exception
    {
        final Statement stmt = getStatement("select attribute[Name]");
        final SelectPart select = stmt.getSelectPart();
        Assert.assertEquals("attribute[Name]", select.getSelects().get(0).getSelect());
    }

    @Test(description = "Select one Attribute with Alias")
    public void oneAttributeWithAlias()
        throws Exception
    {
        final Statement stmt = getStatement("select attribute[Name] as name");
        final SelectPart select = stmt.getSelectPart();
        Assert.assertEquals("attribute[Name]", select.getSelects().get(0).getSelect());
        Assert.assertEquals("name", select.getSelects().get(0).getAlias());
    }

    @Test(description = "Select one Attribute with capitalized Alias")
    public void oneAttributeWithAliasCapitalize()
        throws Exception
    {
        final Statement stmt = getStatement("select attribute[Name] as Name");
        final SelectPart select = stmt.getSelectPart();
        Assert.assertEquals("attribute[Name]", select.getSelects().get(0).getSelect());
        Assert.assertEquals("Name", select.getSelects().get(0).getAlias());
    }

    @Test(description = "Select one type.label with Alias")
    public void oneTypeLabel()
        throws Exception
    {
        final Statement stmt = getStatement("select type.label");
        final SelectPart select = stmt.getSelectPart();
        Assert.assertEquals("type.label", select.getSelects().get(0).getSelect());
    }

    @Test(description = "Select two type.label with Alias")
    public void twoTypeLabel()
        throws Exception
    {
        final Statement stmt = getStatement("select status.label, type.name");
        final SelectPart select = stmt.getSelectPart();
        final List<String> selects = new ArrayList<>();

        for (final OneSelect part : select.getSelects()) {
            selects.add(part.getSelect());
        }
        Assert.assertEquals(new String[] { "status.label", "type.name" }, selects.toArray());
    }

    @Test(description = "many different selects without Alias")
    public void manySelects()
        throws Exception
    {
        final Statement stmt = getStatement("select type.label, attribute[Name], linkto[Object].attribute[Code]");
        final SelectPart select = stmt.getSelectPart();
        final List<String> selects = new ArrayList<>();

        for (final OneSelect part : select.getSelects()) {
            selects.add(part.getSelect());
        }
        Assert.assertEquals(new String[] { "type.label", "attribute[Name]", "linkto[Object].attribute[Code]" },
                        selects.toArray());
    }

    @Test(description = "many different selects with Alias")
    public void manySelectsWithAlias()
        throws Exception
    {
        final Statement stmt = getStatement("select type.label as Type, attribute[Name] as Name, linkto[Object].attribute[Code] as code");
        final SelectPart select = stmt.getSelectPart();
        final List<String> selects = new ArrayList<>();
        final List<String> alias = new ArrayList<>();

        for (final OneSelect part : select.getSelects()) {
            selects.add(part.getSelect());
            alias.add(part.getAlias());
        }
        Assert.assertEquals(new String[] { "type.label", "attribute[Name]", "linkto[Object].attribute[Code]" },
                        selects.toArray());
        Assert.assertEquals(new String[] { "Type", "Name", "code" }, alias.toArray());
    }

    @Test(description = "Format select")
    public void formatSelects()
        throws Exception
    {
        final Statement stmt = getStatement("select attribute[Date].format[YYYY-MM-dd], linkto[DeliveryNote].attribute[Date].format[YYYY/MM/dd]");
        final SelectPart select = stmt.getSelectPart();
        final List<String> selects = new ArrayList<>();

        for (final OneSelect part : select.getSelects()) {
            selects.add(part.getSelect());
        }
        Assert.assertEquals(new String[] { "attribute[Date].format[YYYY-MM-dd]", "linkto[DeliveryNote].attribute[Date].format[YYYY/MM/dd]" },
                        selects.toArray());
    }

}
