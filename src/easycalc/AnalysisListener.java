package easycalc;

import easycalc.grammar.EasyCalcBaseListener;
import easycalc.grammar.EasyCalcParser;
import org.antlr.v4.runtime.Token;

import java.util.*;

public class AnalysisListener extends EasyCalcBaseListener {

    private final List<String> errorList = new ArrayList<>();


    private final SortedMap<String, String> symbolTable = new TreeMap<>();


    private final Stack<String> stack = new Stack<>();


    private boolean errorSentinel = false;



    public String getErrorMessageString() {
        StringBuilder sb = new StringBuilder();

        for (String err : errorList) {
            sb.append(err).append("\n");
        }
        return sb.toString();
    }


    public String getSymbolTableString() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, String> entry : symbolTable.entrySet()) {
            sb.append(entry.getKey()).append(" -> ").append(entry.getValue().toUpperCase()).append("\n");
        }
        return sb.toString();
    }

    // Given methods from the man himself
    private void addRedefErr(Token token) {
        String tokenStr = token.getText();
        int line = token.getLine();
        int pos = token.getCharPositionInLine() + 1;
        String err = "redefinition of " + tokenStr + " at " + line + ":" + pos;
        errorList.add(err);
    }

    private void addUndefErr(Token token) {
        String tokenStr = token.getText();
        int line = token.getLine();
        int pos = token.getCharPositionInLine() + 1;
        String err = tokenStr + " undefined at " + line + ":" + pos;
        errorList.add(err);
    }

    private void addTypeClashErr(Token token) {
        int line = token.getLine();
        int pos = token.getCharPositionInLine() + 1;
        String err = "type clash at " + line + ":" + pos;
        errorList.add(err);
    }

    private void addArgErr(Token optrToken, Token opndToken, String type) {
        String tokenStr = optrToken.getText();
        int line = opndToken.getLine();
        int pos = opndToken.getCharPositionInLine() + 1;
        String err = tokenStr + " undefined for " + type + " at " + line + ":" + pos;
        errorList.add(err);
    }

    @Override
    public void exitDeclar(EasyCalcParser.DeclarContext ctx) {
        String id = ctx.ID().getText();           // get the id
        String type = ctx.type.getText().toUpperCase(); // get the type
        if (symbolTable.containsKey(id)) {        // if the id is found in the symbol table
            addRedefErr(ctx.ID().getSymbol());    // redef error
            errorSentinel = true;                 // set the error sentinel to true from false
        } else {
            symbolTable.put(id, type);            // otherwise throw the id and type into the sorted map
        }
        errorSentinel = false;
    }

    @Override
    public void exitAssignStmt(EasyCalcParser.AssignStmtContext ctx) {
        if (!errorSentinel) {                     // only run if no error has occurred yet
            String id = ctx.ID().getText();       // get the id

            if (!symbolTable.containsKey(id)) {   // if the id is not in the symbol table
                addUndefErr(ctx.ID().getSymbol()); // undef error
            } else if (!stack.isEmpty()) {        // otherwise check the stack
                String leftType = symbolTable.get(id); // get the declared type of the id
                String rightType = stack.pop();        // pop the expression type off the stack

                if (!leftType.equals(rightType)) {     // if the types don't match
                    addTypeClashErr(ctx.ID().getSymbol()); // type clash error
                }
            }
        }
        errorSentinel = false;                    // reset the sentinel for the next statement
    }

    @Override
    public void exitReadStmt(EasyCalcParser.ReadStmtContext ctx) {
        if (!errorSentinel) {                     // only run if no error has occurred yet
            String id = ctx.ID().getText();       // get the id

            if (!symbolTable.containsKey(id)) {   // if the id is not in the symbol table
                addUndefErr(ctx.ID().getSymbol()); // undef error
            }
        }
        errorSentinel = false;                    // reset the sentinel for the next statement
    }

    @Override
    public void exitWriteStmt(EasyCalcParser.WriteStmtContext ctx) {
        if (!errorSentinel && !stack.isEmpty()) { // only pop if no error and stack has something
            stack.pop();                          // clear the expression type off the stack
        }
        errorSentinel = false;                    // reset the sentinel for the next statement
    }

    @Override
    public void exitLitExpr(EasyCalcParser.LitExprContext ctx) {
        if (errorSentinel) {                      // if an error already occurred skip this
            return;
        }
        String text = ctx.getText();              // get the literal text

        if (text.equals("true") || text.equals("false")) { // if it's a boolean literal
            stack.push("BOOL");                   // push BOOL onto the stack
        } else if (text.contains(".")) {          // if it has a decimal point
            stack.push("REAL");                   // push REAL onto the stack
        } else {                                  // otherwise it's a whole number
            stack.push("INT");                    // push INT onto the stack
        }
    }

    @Override
    public void exitIdExpr(EasyCalcParser.IdExprContext ctx) {
        if (errorSentinel) {                      // if an error already occurred skip this
            return;
        }

        String id = ctx.ID().getText();           // get the id

        if (!symbolTable.containsKey(id)) {       // if the id is not in the symbol table
            addUndefErr(ctx.ID().getSymbol());    // undef error
            errorSentinel = true;                 // set the error sentinel to true
        } else {
            stack.push(symbolTable.get(id));      // otherwise push its type onto the stack
        }
    }

    // GIVEN AND COMPLETE DO NOT CHANGE
    @Override
    public void exitToExpr(EasyCalcParser.ToExprContext ctx) {
        if (errorSentinel) {
            return;
        }
        String exprType = stack.pop();
        if (ctx.op.getText().equals("to_int") && exprType.equals("REAL")) {
            stack.push("INT");
        } else if (ctx.op.getText().equals("to_real") && exprType.equals("INT")) {
            stack.push("REAL");
        } else {
            addArgErr(ctx.op, ctx.expr().getStart(), exprType);
            errorSentinel = true;
        }
    }

    @Override
    public void exitMulDivExpr(EasyCalcParser.MulDivExprContext ctx) {
        if (errorSentinel) {                      // if an error already occurred skip this
            return;
        }
        if (stack.size() < 2) {                   // need two operands on the stack
            return;
        }

        String right = stack.pop();               // pop the right operand type
        String left = stack.pop();                // pop the left operand type

        if (left.equals("BOOL")) {                // * and / don't work on booleans
            addArgErr(ctx.op, ctx.expr(0).getStart(), left); // arg error on left
            errorSentinel = true;
            return;
        }

        if (right.equals("BOOL")) {               // check right operand too
            addArgErr(ctx.op, ctx.expr(1).getStart(), right); // arg error on right
            errorSentinel = true;
            return;
        }

        if (!left.equals(right)) {                // both operands must be the same type
            addTypeClashErr(ctx.expr(0).getStart()); // type clash error
            errorSentinel = true;
            return;
        }

        stack.push(left);                         // push the result type onto the stack
    }

    @Override
    public void exitAddSubExpr(EasyCalcParser.AddSubExprContext ctx) {
        if (errorSentinel) {                      // if an error already occurred skip this
            return;
        }
        if (stack.size() < 2) {                   // need two operands on the stack
            return;
        }

        String right = stack.pop();               // pop the right operand type
        String left = stack.pop();                // pop the left operand type

        if (left.equals("BOOL")) {                // + and - don't work on booleans
            addArgErr(ctx.op, ctx.expr(0).getStart(), left); // arg error on left
            errorSentinel = true;
            return;
        }

        if (right.equals("BOOL")) {               // check right operand too
            addArgErr(ctx.op, ctx.expr(1).getStart(), right); // arg error on right
            errorSentinel = true;
            return;
        }

        if (!left.equals(right)) {                // both operands must be the same type
            addTypeClashErr(ctx.expr(0).getStart()); // type clash error
            errorSentinel = true;
            return;
        }

        stack.push(left);                         // push the result type onto the stack
    }

    @Override
    public void exitLessGrtrExpr(EasyCalcParser.LessGrtrExprContext ctx) {
        if (errorSentinel) {                      // if an error already occurred skip this
            return;
        }
        if (stack.size() < 2) {                   // need two operands on the stack
            return;
        }

        String right = stack.pop();               // pop the right operand type
        String left = stack.pop();                // pop the left operand type

        if (left.equals("BOOL")) {                // < and > don't work on booleans
            addArgErr(ctx.op, ctx.expr(0).getStart(), left); // arg error on left
            errorSentinel = true;
            return;
        }

        if (right.equals("BOOL")) {               // check right operand too
            addArgErr(ctx.op, ctx.expr(1).getStart(), right); // arg error on right
            errorSentinel = true;
            return;
        }

        if (!left.equals(right)) {                // both operands must be the same type
            addTypeClashErr(ctx.expr(0).getStart()); // type clash error
            errorSentinel = true;
            return;
        }

        stack.push("BOOL");                       // comparison always produces a boolean
    }

    @Override
    public void exitEqualExpr(EasyCalcParser.EqualExprContext ctx) {
        if (errorSentinel) {                      // if an error already occurred skip this
            return;
        }
        if (stack.size() < 2) {                   // need two operands on the stack
            return;
        }

        String right = stack.pop();               // pop the right operand type
        String left = stack.pop();                // pop the left operand type

        if (!left.equals(right)) {                // both sides of == must be the same type
            addTypeClashErr(ctx.expr(0).getStart()); // type clash error
            errorSentinel = true;
            return;
        }

        stack.push("BOOL");                       // equality check always produces a boolean
    }

    @Override
    public void exitAndExpr(EasyCalcParser.AndExprContext ctx) {
        if (errorSentinel) {                      // if an error already occurred skip this
            return;
        }
        if (stack.size() < 2) {                   // need two operands on the stack
            return;
        }

        String right = stack.pop();               // pop the right operand type
        String left = stack.pop();                // pop the left operand type

        if (!left.equals("BOOL")) {               // and only works on booleans
            addArgErr(ctx.op, ctx.expr(0).getStart(), left); // arg error on left
            errorSentinel = true;
            return;
        }

        if (!right.equals("BOOL")) {              // check right operand too
            addArgErr(ctx.op, ctx.expr(1).getStart(), right); // arg error on right
            errorSentinel = true;
            return;
        }

        stack.push("BOOL");                       // push the result type onto the stack
    }

    @Override
    public void exitOrExpr(EasyCalcParser.OrExprContext ctx) {
        if (errorSentinel) {                      // if an error already occurred skip this
            return;
        }
        if (stack.size() < 2) {                   // need two operands on the stack
            return;
        }

        String right = stack.pop();               // pop the right operand type
        String left = stack.pop();                // pop the left operand type

        if (!left.equals("BOOL")) {               // or only works on booleans
            addArgErr(ctx.op, ctx.expr(0).getStart(), left); // arg error on left
            errorSentinel = true;
            return;
        }

        if (!right.equals("BOOL")) {              // check right operand too
            addArgErr(ctx.op, ctx.expr(1).getStart(), right); // arg error on right
            errorSentinel = true;
            return;
        }

        stack.push("BOOL");                       // push the result type onto the stack
    }

    @Override
    public void exitIfExpr(EasyCalcParser.IfExprContext ctx) {
        if (errorSentinel) {                      // if an error already occurred skip this
            return;
        }
        if (stack.size() < 3) {                   // need three expressions on the stack
            return;
        }

        String elseType = stack.pop();            // pop the else branch type
        String thenType = stack.pop();            // pop the then branch type
        String condType = stack.pop();            // pop the condition type

        if (!condType.equals("BOOL")) {           // the condition must be a boolean
            addArgErr(ctx.start, ctx.expr(0).getStart(), condType); // arg error on condition
            errorSentinel = true;
            return;
        }

        if (!thenType.equals(elseType)) {         // then and else branches must match types
            addTypeClashErr(ctx.expr(1).getStart()); // type clash error
            errorSentinel = true;
            return;
        }

        stack.push(thenType);                     // push the result type onto the stack
    }
}