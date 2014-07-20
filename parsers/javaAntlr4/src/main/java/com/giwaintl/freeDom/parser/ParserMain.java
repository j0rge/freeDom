package com.giwaintl.freeDom.parser;

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

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import static com.google.common.base.Joiner.on;
import static java.lang.System.out;

public class ParserMain {
    static class ParseHearer implements ParseTreeListener {

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

    static class ParserFreeDomListener extends FreeDomBaseListener {
        @Override public void enterEnumDeclaration(@NotNull FreeDomParser.EnumDeclarationContext ctx) {
            out.printf("**** Enum d=%d, <<<%s>>>%n", ctx.depth(), ctx.qualifiedName().Identifier());
        }

        @Override public void enterEnumConstant(@NotNull FreeDomParser.EnumConstantContext ctx) {
            out.printf("**** Enum CONST d=%d, <<<%s>>>%n", ctx.depth(), ctx.Identifier());
        }

        @Override public void enterStructDeclaration(@NotNull FreeDomParser.StructDeclarationContext ctx) {
            out.printf("**** Struct d=%d, <<<%s>>>%n", ctx.depth(), ctx.qualifiedName().Identifier());
        }

        @Override public void enterFieldDeclaration(@NotNull FreeDomParser.FieldDeclarationContext ctx) {
            final FreeDomParser.FieldDimContext dimCtx = ctx.fieldDim();
            final FreeDomParser.FieldDefaultContext defCtx = ctx.fieldDefault();
            String signInfo = "";
            if(defCtx != null) {
                final FreeDomParser.SignPrefixContext signPrefix = defCtx.signPrefix();
                if(signPrefix != null) signInfo = signPrefix.getText();
            }
            final FreeDomParser.QualifiedNameContext fldFqn = ctx.qualifiedName();
            //final FreeDomParser.StdDataTypeContext stdCtx =  ctx.stdDataType();
            final String fldInfo = fldFqn == null ? "N/A" : fldFqn.Identifier().toString();
            out.printf("**** Field d=%d, >%s<>>>%s[%s]=%s%s<<<%n", ctx.depth(), ctx.reqOrOpt().FieldObligation(), fldInfo
               , dimCtx == null ? "N/A" : dimCtx.IntegerLiteral(), signInfo,
                defCtx == null ? "N/A" : defCtx.literal().toStringTree());
        }

        @Override public void enterFreeDomModel(@NotNull FreeDomParser.FreeDomModelContext ctx) {
            out.printf("FreeDom model =<<<%s>>>%n", ctx.toStringTree());
        }

        @Override public void enterNamespaceDeclaration(@NotNull FreeDomParser.NamespaceDeclarationContext ctx) {
            out.printf("Namespace d=%d, <<<%s>>>%n", ctx.depth(), ctx.qualifiedName().Identifier());
        }

        @Override public void enterQualifiedName(@NotNull FreeDomParser.QualifiedNameContext ctx) {
            out.printf("qName d=%d, <<<%s>>>%n", ctx.depth(), on(".").join(ctx.Identifier()));
        }

        @Override public void enterIncludeDeclaration(@NotNull FreeDomParser.IncludeDeclarationContext ctx) {
            out.printf("Include d=%d, <<<%s>>>%n", ctx.depth(), ctx.toStringTree());
        }

        @Override public void exitIncludeDeclaration(@NotNull FreeDomParser.IncludeDeclarationContext ctx) {
            out.printf("/include d=%d%n", ctx.depth());
        }

        @Override public void exitNamespaceDeclaration(@NotNull FreeDomParser.NamespaceDeclarationContext ctx) {
            out.printf("/namespace d=%d%n", ctx.depth());
        }

        @Override public void enterVersionDeclaration(@NotNull FreeDomParser.VersionDeclarationContext ctx) {
            out.printf("Version d=%d, \"%s\"%n", ctx.depth(), ctx.StringLiteral());
        }

        @Override public void exitVersionDeclaration(@NotNull FreeDomParser.VersionDeclarationContext ctx) {
            out.printf("/version d=%d%n", ctx.depth());
        }

    }

    public static void main(String[] args) throws IOException {
        out.printf("args[%d]: >>>%s<<<%n", args.length, on(", ").join(args));
        if (args.length > 0) {
            final String input = Files.toString(new File(args[0]), Charset.defaultCharset());
            out.printf("Input:%n%s%n", input);
            ANTLRInputStream ais = new ANTLRInputStream(input);

//            List<String> largs = Arrays.asList(args);
            FreeDomLexer hl = new FreeDomLexer(ais);
            CommonTokenStream tokens = new CommonTokenStream(hl);

            // Pass the tokens to the parser
            FreeDomParser parser = new FreeDomParser(tokens);
            parser.addParseListener(new ParseHearer());
            parser.setTrace(true);

            // Specify our entry point
            FreeDomParser.FreeDomModelContext topLevel = parser.freeDomModel();

            // Walk it and attach our listener
            ParseTreeWalker walker = new ParseTreeWalker();
            ParserFreeDomListener listener = new ParserFreeDomListener();
            walker.walk(listener, topLevel);
            out.printf("Token names:%s%n", on(", ").join(hl.getTokenNames()));
        }

    }

}
