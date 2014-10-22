package test.giwaintl.freeDom.parser;

import com.giwaintl.freeDom.grammars.FreeDomBaseListener;
import com.giwaintl.freeDom.grammars.FreeDomLexer;
import com.giwaintl.freeDom.grammars.FreeDomParser;
import com.google.common.io.Files;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import static com.google.common.base.Joiner.on;
import static java.lang.String.format;
import static org.slf4j.LoggerFactory.getLogger;

/**
 */
public class TestParser {
    private static final Logger L = getLogger(TestParser.class);

    private static class TestParseHearer implements ParseTreeListener {

        @Override public void visitTerminal(@NotNull TerminalNode node) {
            L.info(format("terminal node: %s", node.toStringTree()));
        }

        @Override public void visitErrorNode(@NotNull ErrorNode node) {
            L.info(format("ERROR node: %s", node.toStringTree()));
        }

        @Override public void enterEveryRule(@NotNull ParserRuleContext ctx) {
            L.info(format("rule enter : %s", ctx.toStringTree()));
        }

        @Override public void exitEveryRule(@NotNull ParserRuleContext ctx) {
            L.info(format("rule exit : %s", ctx.toStringTree()));
        }
    }

    private static class ParserFreeDomListener extends FreeDomBaseListener {
        @Override public void enterEnumDeclaration(@NotNull FreeDomParser.EnumDeclarationContext ctx) {
            L.info(format("**** Enum d=%d, <<<%s>>>%n", ctx.depth(), ctx.qualifiedName().Identifier()));
        }

        @Override public void enterEnumConstant(@NotNull FreeDomParser.EnumConstantContext ctx) {
            L.info(format("**** Enum CONST d=%d, <<<%s>>>%n", ctx.depth(), ctx.Identifier()));
        }

        @Override public void enterStructDeclaration(@NotNull FreeDomParser.StructDeclarationContext ctx) {
            L.info(format("**** Struct d=%d, <<<%s>>>%n", ctx.depth(), ctx.qualifiedName().Identifier()));
        }

        @Override public void enterFieldDeclaration(@NotNull FreeDomParser.FieldDeclarationContext ctx) {
            final FreeDomParser.FieldDimContext dimCtx = ctx.fieldDim();
            final FreeDomParser.FieldDefaultContext defCtx = ctx.fieldDefault();
            String signInfo = "";
            if (defCtx != null) {
                final FreeDomParser.SignPrefixContext signPrefix = defCtx.signPrefix();
                if (signPrefix != null) signInfo = signPrefix.getText();
            }
            final FreeDomParser.QualifiedNameContext fldFqn = ctx.qualifiedName();
            //final FreeDomParser.StdDataTypeContext stdCtx =  ctx.stdDataType();
            final String fldInfo = fldFqn == null ? "N/A" : fldFqn.Identifier().toString();
            L.info(format("**** Field d=%d, >%s<>>>%s[%s]=%s%s<<<%n", ctx.depth(), ctx.reqOrOpt().FieldObligation(), fldInfo
                , dimCtx == null ? "N/A" : dimCtx.IntegerLiteral(), signInfo,
                defCtx == null ? "N/A" : defCtx.literal().toStringTree()));
        }

        @Override public void enterFreeDomModel(@NotNull FreeDomParser.FreeDomModelContext ctx) {
            L.info(format("FreeDom model =<<<%s>>>%n", ctx.toStringTree()));
        }

        @Override public void enterNamespaceDeclaration(@NotNull FreeDomParser.NamespaceDeclarationContext ctx) {
            L.info(format("Namespace d=%d, <<<%s>>>%n", ctx.depth(), ctx.qualifiedName().Identifier()));
        }

        @Override public void enterQualifiedName(@NotNull FreeDomParser.QualifiedNameContext ctx) {
            L.info(format("qName d=%d, <<<%s>>>%n", ctx.depth(), on(".").join(ctx.Identifier())));
        }

        @Override public void enterIncludeDeclaration(@NotNull FreeDomParser.IncludeDeclarationContext ctx) {
            L.info(format("Include d=%d, <<<%s>>>%n", ctx.depth(), ctx.toStringTree()));
        }

        @Override public void exitIncludeDeclaration(@NotNull FreeDomParser.IncludeDeclarationContext ctx) {
            L.info(format("/include d=%d%n", ctx.depth()));
        }

        @Override public void exitNamespaceDeclaration(@NotNull FreeDomParser.NamespaceDeclarationContext ctx) {
            L.info(format("/namespace d=%d%n", ctx.depth()));
        }

        @Override public void enterVersionDeclaration(@NotNull FreeDomParser.VersionDeclarationContext ctx) {
            L.info(format("Version d=%d, \"%s\"%n", ctx.depth(), ctx.StringLiteral()));
        }

        @Override public void exitVersionDeclaration(@NotNull FreeDomParser.VersionDeclarationContext ctx) {
            L.info(format("/version d=%d%n", ctx.depth()));
        }

        @Before public void init() throws Exception {
            L.info("Listener initialized");
        }

        @After public void destroy() throws Exception {
            L.info("Listener destroyed");
        }
    }

    @Test public void testEnums() throws IOException {

        final String input = Files.toString(new File("data/showOff.freeDom"), Charset.defaultCharset());
        ANTLRInputStream ais = new ANTLRInputStream(input);
        FreeDomLexer hl = new FreeDomLexer(ais);
        CommonTokenStream tokens = new CommonTokenStream(hl);

        // Pass the tokens to the parser
        FreeDomParser parser = new FreeDomParser(tokens);
        parser.addParseListener(new TestParseHearer());

        parser.setTrace(false);  // this outputs to the console, the listener above works fine

        // Specify our entry point
        FreeDomParser.FreeDomModelContext topLevel = parser.freeDomModel();

        // Walk it and attach our listener
        ParseTreeWalker walker = new ParseTreeWalker();
        ParserFreeDomListener listener = new ParserFreeDomListener();
        walker.walk(listener, topLevel);
        L.info(format("Token names:%s%n", on(", ").join(hl.getTokenNames())));
    }

}
