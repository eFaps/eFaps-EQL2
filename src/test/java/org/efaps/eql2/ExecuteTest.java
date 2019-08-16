/*
 * Copyright 2003 - 2019 The eFaps Team
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
package org.efaps.eql2;

import org.testng.annotations.Test;

/**
 * The Class ExecuteTest.
 *
 * @author The eFaps Team
 */
public class ExecuteTest
    extends AbstractTest
{

    /**
     * Exec.
     */
    @Test(description = "org.efaps.demo.Test")
    public void exec()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createExecStatement().className("org.efaps.demo.Test");
        verifyStatement("exec org.efaps.demo.Test", stmt);
        verifyStatement("execute org.efaps.demo.Test", stmt);
    }

    /**
     * Exec esjp one numeric parameter.
     */
    @Test(description = "org.efaps.demo.Test 2")
    public void execEsjpOneNumericParameter()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createExecStatement().className("org.efaps.demo.Test")
                        .addParameter("2");
        verifyStatement("exec org.efaps.demo.Test 2", stmt);
        verifyStatement("execute org.efaps.demo.Test 2", stmt);
    }

    /**
     * Exec esjp two numeric parameter.
     */
    @Test(description = "exec org.efaps.demo.Test 2, 44")
    public void execEsjpTwoNumericParameter()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createExecStatement().className("org.efaps.demo.Test")
                        .addParameter("2").addParameter("44");
        verifyStatement("exec org.efaps.demo.Test 2, 44", stmt);
        verifyStatement("execute org.efaps.demo.Test 2, 44", stmt);
    }

    /**
     * Exec esjp many numeric parameter.
     */
    @Test(description = "exec org.efaps.demo.Test 2, 44, 4, 567")
    public void execEsjpManyNumericParameter()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createExecStatement().className("org.efaps.demo.Test")
                        .addParameter("2").addParameter("44").addParameter("4").addParameter("567");
        verifyStatement("exec org.efaps.demo.Test 2, 44, 4, 567", stmt);
        verifyStatement("execute org.efaps.demo.Test 2, 44, 4, 567", stmt);
    }

    /**
     * Exec esjp one string parameter.
     */
    @Test(description = "exec org.efaps.demo.Test \"ABC DE D\"")
    public void execEsjpOneStringParameter()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createExecStatement().className("org.efaps.demo.Test")
                        .addParameter("ABC DE D");
        verifyStatement("exec org.efaps.demo.Test \"ABC DE D\"", stmt);
        verifyStatement("execute org.efaps.demo.Test \"ABC DE D\"", stmt);
    }

    /**
     * Exec esjp two string parameter.
     */
    @Test(description = "org.efaps.demo.Test \"ABC DE D\", \"another string\"")
    public void execEsjpTwoStringParameter()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createExecStatement().className("org.efaps.demo.Test")
                        .addParameter("ABC DE D").addParameter("another string");
        verifyStatement("exec org.efaps.demo.Test \"ABC DE D\", \"another string\"", stmt);
        verifyStatement("execute org.efaps.demo.Test \"ABC DE D\", \"another string\"", stmt);
    }

    /**
     * Exec esjp many string parameter.
     */
    @Test(description = "org.efaps.demo.Test \"ABC DE D\", \"another string\", \"Third one\"")
    public void execEsjpManyStringParameter()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createExecStatement().className("org.efaps.demo.Test")
                        .addParameter("ABC DE D").addParameter("another string").addParameter("Third one");
        verifyStatement("exec org.efaps.demo.Test \"ABC DE D\", \"another string\", \"Third one\"", stmt);
        verifyStatement("execute org.efaps.demo.Test \"ABC DE D\", \"another string\", \"Third one\"", stmt);
    }

    /**
     * Exec esjp mixed parameters.
     */
    @Test(description = "exec org.efaps.demo.Test \"ABC DE D\", 2, \"Third one\"")
    public void execEsjpMixedParameters()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createExecStatement().className("org.efaps.demo.Test")
                        .addParameter("ABC DE D").addParameter("2").addParameter("Third one");
        verifyStatement("exec org.efaps.demo.Test \"ABC DE D\", 2, \"Third one\"", stmt);
        verifyStatement("execute org.efaps.demo.Test \"ABC DE D\", 2, \"Third one\"", stmt);
    }

    /**
     * Exec esjp one mapping.
     */
    @Test(description = "org.efaps.demo.Test select 1 as Key")
    public void execEsjpOneMapping()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createExecStatement().className("org.efaps.demo.Test")
                        .addSelection(IEql2Factory.eINSTANCE.createExecSelectionElement()
                                        .index("1").alias("Key"));
        verifyStatement("exec org.efaps.demo.Test select 1 as Key", stmt);
    }

    /**
     * Exec esjp two mapping.
     */
    @Test(description = "org.efaps.demo.Test select 1 as Key, 5 as Demo")
    public void execEsjpTwoMapping()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createExecStatement().className("org.efaps.demo.Test")
                        .addSelection(IEql2Factory.eINSTANCE.createExecSelectionElement()
                                        .index("1").alias("Key"))
                        .addSelection(IEql2Factory.eINSTANCE.createExecSelectionElement()
                                        .index("5").alias("Demo"));
        verifyStatement("exec org.efaps.demo.Test select 1 as Key, 5 as Demo", stmt);
    }

    /**
     * Exec esjp many mapping.
     */
    @Test(description = "org.efaps.demo.Test select 1 as Key, 5 as Demo, 8 as etwas")
    public void execEsjpManyMapping()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createExecStatement().className("org.efaps.demo.Test")
                        .addSelection(IEql2Factory.eINSTANCE.createExecSelectionElement()
                                        .index("1").alias("Key"))
                        .addSelection(IEql2Factory.eINSTANCE.createExecSelectionElement()
                                        .index("5").alias("Demo"))
                        .addSelection(IEql2Factory.eINSTANCE.createExecSelectionElement()
                                        .index("8").alias("etwas"));
        verifyStatement("exec org.efaps.demo.Test select 1 as Key, 5 as Demo, 8 as etwas", stmt);
    }

    /**
     * Exec esjp parameters mapping.
     */
    @Test(description = "org.efaps.demo.Test \"Param1 with space\", \"ABCDE\" select 1 as Key")
    public void execEsjpParametersMapping()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createExecStatement().className("org.efaps.demo.Test")
                        .addParameter("Param1 with space").addParameter("ABCDE")
                        .addSelection(IEql2Factory.eINSTANCE.createExecSelectionElement()
                                        .index("1").alias("Key"));
        verifyStatement("exec org.efaps.demo.Test \"Param1 with space\", \"ABCDE\" select 1 as Key", stmt);
    }

    /**
     * Exec esjp many parameters mapping two.
     */
    @Test(description = "org.efaps.demo.Test \"Param1 with space\", \"ABCDE\" select 1 as Key, 2 as demo")
    public void execEsjpManyParametersMapping2()
    {
        //("exec org.efaps.demo.Test \"Param1 with space\", \"ABCDE\" select 1 as Key, 2 as Demo");
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createExecStatement().className("org.efaps.demo.Test")
                        .addParameter("Param1 with space").addParameter("ABCDE")
                        .addSelection(IEql2Factory.eINSTANCE.createExecSelectionElement()
                                        .index("1").alias("Key"))
                        .addSelection(IEql2Factory.eINSTANCE.createExecSelectionElement()
                                        .index("2").alias("demo"));
        verifyStatement("exec org.efaps.demo.Test \"Param1 with space\", \"ABCDE\" select 1 as Key, 2 as demo", stmt);
    }

    /**
     * Exec esjp many parameters mapping 3.
     */
    @Test(description = "exec org.efaps.demo.Test \"Param1 with space\", \"ABCDE\" select 1, 2 as demo, 8")
    public void execEsjpManyParametersMapping3()
    {
      //("exec org.efaps.demo.Test \"Param1 with space\", \"ABCDE\" select 1 as Key, 2 as Demo");
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createExecStatement().className("org.efaps.demo.Test")
                        .addParameter("Param1 with space").addParameter("ABCDE")
                        .addSelection(IEql2Factory.eINSTANCE.createExecSelectionElement()
                                        .index("1"))
                        .addSelection(IEql2Factory.eINSTANCE.createExecSelectionElement()
                                        .index("2").alias("demo"))
                        .addSelection(IEql2Factory.eINSTANCE.createExecSelectionElement()
                                        .index("8"));
        verifyStatement("exec org.efaps.demo.Test \"Param1 with space\", \"ABCDE\" select 1, 2 as demo, 8", stmt);
    }

    @Test(description = "with trigger-off exec org.efaps.demo.Test")
    public void execWithFlag()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createExecStatement()
                        .addFlag(StmtFlag.TRIGGEROFF)
                        .className("org.efaps.demo.Test");

        verifyStatement("with trigger-off exec org.efaps.demo.Test", stmt);
        verifyStatement("with trigger-off execute org.efaps.demo.Test", stmt);
    }

    @Test(description = "with trigger-off, request-cached, company-independent  exec org.efaps.demo.Test")
    public void execWithFlags()
    {
        final IEQLElement stmt = IEql2Factory.eINSTANCE.createExecStatement()
                        .addFlag(StmtFlag.TRIGGEROFF)
                        .addFlag(StmtFlag.REQCACHED)
                        .addFlag(StmtFlag.COMPANYINDEPENDENT)
                        .className("org.efaps.demo.Test");

        verifyStatement("with trigger-off, request-cached, company-independent  exec org.efaps.demo.Test", stmt);
        verifyStatement("with trigger-off, request-cached, company-independent  execute org.efaps.demo.Test", stmt);
    }
}
