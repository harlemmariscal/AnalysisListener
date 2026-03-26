package easycalc;

import java.util.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import easycalc.grammar.*;

public class AnalysisApp {

    public static void main(String[] args) {

        // ======================================================
        // Read in multiple lines of input
        // ======================================================

        StringBuilder sb = new StringBuilder();
        Scanner scan = new Scanner(System.in);
        String nextLine = scan.nextLine();
        while (!nextLine.contains("$$")) {
            sb.append(nextLine).append("\n");
            scan = new Scanner(System.in);
            nextLine = scan.nextLine();
        }
        scan.close();
        sb.append(nextLine).append("\n");
        String str = sb.toString();

        // ======================================================
        // Create the parse tree from the input stream
        // ======================================================

        CharStream input = CharStreams.fromString(str);
        AnalysisListener printer = getAnalysisListener(input);
        System.out.println(printer.getSymbolTableString()); // print symbol table
        System.out.println(printer.getErrorMessageString()); // print error messages
    }

    private static AnalysisListener getAnalysisListener(CharStream input) {
        EasyCalcLexer lexer = new EasyCalcLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        EasyCalcParser parser = new EasyCalcParser(tokens);
        ParseTree tree = parser.program(); // begin parsing at program rule

        // ======================================================
        // Walk the tree with the analysis listener
        // ======================================================

        ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
        AnalysisListener printer = new AnalysisListener();
        walker.walk(printer, tree); // initiate walk of tree with listener
        return printer;
    }
}