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
package org.efaps.eql;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.eclipse.xtext.util.LazyStringInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.inject.Inject;

/**
 * The Class FormatterTest.
 *
 * @author The eFaps Team
 */
public class FormatterTest
    extends AbstractTest
{

    /** The log. */
    private static Logger LOG = LoggerFactory.getLogger(FormatterTest.class);


    /** The serializer. */
    @Inject
    private Serializer serializer;

    /**
     * Demo.
     *
     * @param _orig the orig
     * @param _targetFrmtd the target frmtd
     * @throws IOException
     */
    @Test(dataProvider = "DataProvider")
    public void verifyFormatedStr(final String _orig,
                                  final String _targetFrmtd) throws IOException
    {
        final XtextResource resource = new XtextResource();
        EQLStandaloneSetup.doSetup(resource);

        resource.load(new LazyStringInputStream(_orig), null);


        final IParseResult result = resource.getParseResult();
        final EObject obj = result.getRootASTElement();
        final String frmtd = this.serializer.serialize(obj, SaveOptions.newBuilder().format().getOptions());
        FormatterTest.LOG.info(frmtd);
        System.out.println(frmtd);
        Assert.assertEquals(frmtd, _targetFrmtd);
    }

    /**
     * Data provider.
     *
     * @param _context the context
     * @return the iterator< object[]>
     */
    @DataProvider(name = "DataProvider")
    public static Iterator<Object[]> dataProvider(final ITestContext _context)
    {
        final List<Object[]> ret = new ArrayList<>();
        ret.add(new Object[] { "  print      query  type  Sales_Invoice where linkto[TaxId].attribute[CAT] eq \"Demo\" "
                        + "select attribute[ Name] , attribute[Other]",
            "print query type Sales_Invoice where linkto[TaxId].attribute[CAT] == \"Demo\""
            + " select attribute[Name], attribute[Other]"});

        ret.add(new Object[] { "  print    query  type  Sales_Invoice where linkto[ TaxId].attribute[CAT] eq \"Demo\" "
                        + "select attribute[ Name] , attribute[Other] order by demo ,test",
            "print query type Sales_Invoice where linkto[TaxId].attribute[CAT] == \"Demo\""
            + " select attribute[Name], attribute[Other] order by demo, test"});

        return ret.iterator();
    }
}
