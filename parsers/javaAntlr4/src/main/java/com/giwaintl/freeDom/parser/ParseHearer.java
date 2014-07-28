package com.giwaintl.freeDom.parser;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.slf4j.Logger;

import static java.lang.System.out;
import static org.slf4j.LoggerFactory.getLogger;

/**
 */
public class ParseHearer implements ParseTreeListener {
    private static final Logger L = getLogger(ModelParseListener.class);

    @Override public void visitTerminal(@NotNull TerminalNode node) {
        out.printf("terminal node: %s", node.toStringTree());
    }

    @Override public void visitErrorNode(@NotNull ErrorNode node) {
        out.printf("ERROR node: %s", node.toStringTree());
    }

    @Override public void enterEveryRule(@NotNull ParserRuleContext ctx) {
        out.printf("rule enter : %s", ctx.toStringTree());
    }

    @Override public void exitEveryRule(@NotNull ParserRuleContext ctx) {
        out.printf("rule exit : %s", ctx.toStringTree());
    }
}
