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

import org.eclipse.xtext.parser.IParseResult;
import org.efaps.eql.eQL.ExecPart;
import org.efaps.eql.eQL.ExecSelect;
import org.efaps.eql.eQL.OneOrder;
import org.efaps.eql.eQL.OneSelect;
import org.efaps.eql.eQL.OneUpdate;
import org.efaps.eql.eQL.OneWhere;
import org.efaps.eql.eQL.OrderPart;
import org.efaps.eql.eQL.PrintPart;
import org.efaps.eql.eQL.QueryPart;
import org.efaps.eql.eQL.SelectPart;
import org.efaps.eql.eQL.Statement;
import org.efaps.eql.eQL.UpdatePart;
import org.efaps.eql.eQL.WherePart;
import org.efaps.eql.parser.antlr.EQLParser;
import org.efaps.eql.validation.EQLJavaValidator;

import com.google.inject.Inject;

/**
 * TODO comment!
 *
 * @author The eFaps Team
 * @version $Id: $
 */
public class EQLInvoker
{

    @Inject
    private EQLParser parser;

    @Inject
    private EQLJavaValidator validator;

    /**
     *
     */
    public EQLInvoker()
    {
        EQLStandaloneSetup.doSetup(this);
    }

    /**
     * Getter method for the instance variable {@link #parser}.
     *
     * @return value of instance variable {@link #parser}
     */
    public EQLParser getParser()
    {
        return this.parser;
    }

    public IEQLStmt invoke(final String _stmt)
        throws Exception
    {
        IEQLStmt ret = null;
        final IParseResult result = getParser().doParse(_stmt);
        final Statement stmt = (Statement) result.getRootASTElement();
        if (stmt != null) {
            if (stmt.getPrintPart() != null) {
                final PrintPart printPart = stmt.getPrintPart();
                final IPrintStmt print = getIPrint();
                print.setInstance(printPart.getOid());
                ret = print;
            } else if (stmt.getExecPart() != null) {
                final ExecPart execPart = stmt.getExecPart();
                final IExecStmt exec = getIExec();
                exec.setESJPName(execPart.getClassName());
                for (final String parameter : execPart.getParameters()) {
                    exec.addParameter(parameter);
                }
                for (final ExecSelect exSel : execPart.getExecSelect()) {
                    exec.addSelect(exSel.getSelect(), exSel.getAlias());
                }
                ret = exec;
            } else if (stmt.getQueryPart() != null) {
                final QueryPart queryPart = stmt.getQueryPart();
                final IQueryStmt query = getIQuery();
                for (final String type : queryPart.getTypes()) {
                    query.addType(type);
                }
                ret = query;
                if (stmt.getWherePart() != null) {
                    final WherePart wherePart = stmt.getWherePart();
                    for (final OneWhere oneWhere : wherePart.getWheres()) {
                        if (oneWhere.getAttribute() != null) {
                            switch (oneWhere.getComparison()) {
                                case EQUAL:
                                    query.addWhereAttrEq(oneWhere.getAttribute(), oneWhere.getValue());
                                    break;
                                case GREATER:
                                    query.addWhereAttrGreater(oneWhere.getAttribute(), oneWhere.getValue());
                                    break;
                                case LESS:
                                    query.addWhereAttrLess(oneWhere.getAttribute(), oneWhere.getValue());
                                    break;
                                case LIKE:
                                    query.addWhereAttrLike(oneWhere.getAttribute(), oneWhere.getValue());
                                    break;
                                case UNEQUAL:
                                    query.addWhereAttrNotEq(oneWhere.getAttribute(), oneWhere.getValue());
                                    break;
                                case IN:
                                    query.addWhereAttrIn(oneWhere.getAttribute(), oneWhere.getValues());
                                    break;
                                default:
                                    break;
                            }
                        } else if (oneWhere.getSelect() != null) {
                            switch (oneWhere.getComparison()) {
                                case EQUAL:
                                    query.addWhereSelectEq(oneWhere.getAttribute(), oneWhere.getValue());
                                    break;
                                case GREATER:
                                    query.addWhereSelectGreater(oneWhere.getAttribute(), oneWhere.getValue());
                                    break;
                                case LESS:
                                    query.addWhereSelectLess(oneWhere.getAttribute(), oneWhere.getValue());
                                    break;
                                case LIKE:
                                case UNEQUAL:
                                case IN:
                                default:
                                    break;
                            }
                        }
                    }
                }
                if (stmt.getOrderPart() != null) {
                    final OrderPart orderPart = stmt.getOrderPart();
                    for (final OneOrder oneOrder : orderPart.getOneOrder()) {
                        query.addOrder(oneOrder.getKey(), oneOrder.isDesc());
                    }
                }
            } else if (stmt.getUpdatePart() != null) {
                final UpdatePart updatePart = stmt.getUpdatePart();
                final IUpdateStmt update = getIUpdate();
                update.setInstance(updatePart.getOid());
                for (final OneUpdate oneUpdate : updatePart.getUpdates()) {
                    update.addUpdate(oneUpdate.getAttribute(), oneUpdate.getValue());
                }
                ret = update;
            }

            if (stmt.getSelectPart() != null && ret != null && ret instanceof ISelectStmt) {
                final SelectPart selectPart = stmt.getSelectPart();
                for (final OneSelect sel : selectPart.getSelects()) {
                    ((ISelectStmt) ret).addSelect(sel.getSelect(), sel.getAlias());
                }
            }
        }
        return ret;
    }

    /**
     * Getter method for the instance variable {@link #validator}.
     *
     * @return value of instance variable {@link #validator}
     */
    public EQLJavaValidator getValidator()
    {
        return this.validator;
    }

    protected IPrintStmt getIPrint()
    {
        return new NonOpPrint();
    }

    protected IQueryStmt getIQuery()
    {
        return new NonOpQuery();
    }

    protected IExecStmt getIExec()
    {
        return new NonOpExec();
    }

    protected IUpdateStmt getIUpdate()
    {
        return new NonOpUpdate();
    }
}
