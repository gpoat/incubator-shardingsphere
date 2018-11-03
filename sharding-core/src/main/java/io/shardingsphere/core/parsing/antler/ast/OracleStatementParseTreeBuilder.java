/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
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
 * </p>
 */

package io.shardingsphere.core.parsing.antler.ast;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;

import io.shardingsphere.core.parsing.antler.parser.OracleStatementAdvancedParser;
import io.shardingsphere.parser.antlr.OracleStatementLexer;

/**
 * Oracle tree builder, Create private lexer and parser.
 * 
 * @author duhongjun
 */
public class OracleStatementParseTreeBuilder extends AbstractParseTreeBuilder {

    /**
     * Create lexer instance.
     *
     * @param charStream text stream
     * @return antlr lexer instance
     */
    @Override
    protected Lexer newLexer(final CharStream charStream) {
        return new OracleStatementLexer(charStream);
    }

    /**
     * Create parser instance.
     *
     * @param tokenStream token stream
     * @return antlr parser instance
     */
    @Override
    protected Parser newParser(final TokenStream tokenStream) {
        return new OracleStatementAdvancedParser(tokenStream);
    }

    /**
     * Get SQL parse tree.
     *
     * @param parser instance
     * @return SQL parse tree
     */
    @Override
    protected ParserRuleContext getParserTree(final Parser parser) {
        OracleStatementAdvancedParser parse = (OracleStatementAdvancedParser) parser;
        return parse.execute();
    }
}