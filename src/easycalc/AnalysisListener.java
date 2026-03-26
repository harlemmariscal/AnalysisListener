package easycalc;

import easycalc.grammar.EasyCalcBaseListener;
import easycalc.grammar.EasyCalcParser;
import org.antlr.v4.runtime.Token;

import java.util.*;

public class AnalysisListener extends EasyCalcBaseListener  {


    private final SortedMap<String, String> symbolTable = new TreeMap<>();

    private final List<String> errorList = new ArrayList<>();

    private final Stack<String> stack = new Stack<>();

    private boolean errorSentinel = false;


    public String getSymbolTableString() {
        return null;
    }

    public String getErrorMessageString() {
        return null;
    }


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


    @Override public void exitDeclar(EasyCalcParser.DeclarContext ctx) {

        String id = ctx.ID().getText();
        String type = ctx.type.getText();
        if (symbolTable.containsKey(id)) {
            addRedefErr(ctx.ID().getSymbol());
            errorSentinel = true;
        } else {
            symbolTable.put(id, type);
        }

    }

    @Override public void exitAssignStmt(EasyCalcParser.AssignStmtContext ctx) {

    }

    @Override public void exitReadStmt(EasyCalcParser.ReadStmtContext ctx) {

    }

    @Override public void exitWriteStmt(EasyCalcParser.WriteStmtContext ctx) {

    }

    @Override public void exitLitExpr(EasyCalcParser.LitExprContext ctx) {

    }

    @Override public void exitIdExpr(EasyCalcParser.IdExprContext ctx) {

    }

    @Override
    public void exitToExpr(EasyCalcParser.ToExprContext ctx) {
        if(errorSentinel) return;
        String exprType = stack.pop();
        if(ctx.op.getText().equals("to_int") && exprType.equals("REAL")) {
            stack.push("INT");
        } else if(ctx.op.getText().equals("to_real") && exprType.equals("INT")) {
            stack.push("REAL");
        } else {
            addArgErr(ctx.op, ctx.expr().getStart(), exprType);
            errorSentinel = true;
        }
    }

    @Override public void exitMulDivExpr(EasyCalcParser.MulDivExprContext ctx) {

    }

    @Override public void exitAddSubExpr(EasyCalcParser.AddSubExprContext ctx) {

    }

    @Override public void exitLessGrtrExpr(EasyCalcParser.LessGrtrExprContext ctx) {

    }

    @Override public void exitEqualExpr(EasyCalcParser.EqualExprContext ctx) {

    }

    @Override public void exitAndExpr(EasyCalcParser.AndExprContext ctx) {

    }

    @Override public void exitOrExpr(EasyCalcParser.OrExprContext ctx) {

    }

    @Override public void exitIfExpr(EasyCalcParser.IfExprContext ctx) {

    }

}
