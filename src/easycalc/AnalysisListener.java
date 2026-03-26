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
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, String> entry : symbolTable.entrySet()) {
            sb.append(entry.getKey()).append(" -> ").append(entry.getValue().toUpperCase()).append("\n");
        }
        return sb.toString();
    }

    public String getErrorMessageString() {
        StringBuilder sb = new StringBuilder();

        for (String err : errorList) {
            sb.append(err).append("\n");
        }
        return sb.toString();
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

    @Override
    public void exitDeclar(EasyCalcParser.DeclarContext ctx) {
        String id = ctx.ID().getText();
        String type = ctx.type.getText().toUpperCase();
        if (symbolTable.containsKey(id)) {
            addRedefErr(ctx.ID().getSymbol());
            errorSentinel = true;
        } else {
            symbolTable.put(id, type);
        }
        errorSentinel = false;
    }

    @Override
    public void exitAssignStmt(EasyCalcParser.AssignStmtContext ctx) {
        if (!errorSentinel) {
            String id = ctx.ID().getText();

            if (!symbolTable.containsKey(id)) {
                addUndefErr(ctx.ID().getSymbol());
            } else if (!stack.isEmpty()) {
                String leftType = symbolTable.get(id);
                String rightType = stack.pop();

                if (!leftType.equals(rightType)) {
                    addTypeClashErr(ctx.ID().getSymbol());
                }
            }
        }

        errorSentinel = false;
    }

    @Override
    public void exitReadStmt(EasyCalcParser.ReadStmtContext ctx) {
        if (!errorSentinel) {
            String id = ctx.ID().getText();

            if (!symbolTable.containsKey(id)) {
                addUndefErr(ctx.ID().getSymbol());
            }
        }

        errorSentinel = false;
    }

    @Override
    public void exitWriteStmt(EasyCalcParser.WriteStmtContext ctx) {
        if (!errorSentinel && !stack.isEmpty()) {
            stack.pop();
        }

        errorSentinel = false;
    }

    @Override
    public void exitLitExpr(EasyCalcParser.LitExprContext ctx) {
        if (errorSentinel) return;

        String text = ctx.getText();

        if (text.equals("true") || text.equals("false")) {
            stack.push("BOOL");
        } else if (text.contains(".")) {
            stack.push("REAL");
        } else {
            stack.push("INT");
        }
    }

    @Override
    public void exitIdExpr(EasyCalcParser.IdExprContext ctx) {
        if (errorSentinel) return;

        String id = ctx.ID().getText();

        if (!symbolTable.containsKey(id)) {
            addUndefErr(ctx.ID().getSymbol());
            errorSentinel = true;
        } else {
            stack.push(symbolTable.get(id));
        }
    }

    @Override
    public void exitToExpr(EasyCalcParser.ToExprContext ctx) {
        if (errorSentinel) return;
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
        if (errorSentinel) return;
        if (stack.size() < 2) return;

        String right = stack.pop();
        String left = stack.pop();

        if (left.equals("BOOL")) {
            addArgErr(ctx.op, ctx.expr(0).getStart(), left);
            errorSentinel = true;
            return;
        }

        if (right.equals("BOOL")) {
            addArgErr(ctx.op, ctx.expr(1).getStart(), right);
            errorSentinel = true;
            return;
        }

        if (!left.equals(right)) {
            addTypeClashErr(ctx.expr(0).getStart());
            errorSentinel = true;
            return;
        }

        stack.push(left);
    }

    @Override
    public void exitAddSubExpr(EasyCalcParser.AddSubExprContext ctx) {
        if (errorSentinel) return;
        if (stack.size() < 2) return;

        String right = stack.pop();
        String left = stack.pop();

        if (left.equals("BOOL")) {
            addArgErr(ctx.op, ctx.expr(0).getStart(), left);
            errorSentinel = true;
            return;
        }

        if (right.equals("BOOL")) {
            addArgErr(ctx.op, ctx.expr(1).getStart(), right);
            errorSentinel = true;
            return;
        }

        if (!left.equals(right)) {
            addTypeClashErr(ctx.expr(0).getStart());
            errorSentinel = true;
            return;
        }

        stack.push(left);
    }

    @Override
    public void exitLessGrtrExpr(EasyCalcParser.LessGrtrExprContext ctx) {
        if (errorSentinel) return;
        if (stack.size() < 2) return;

        String right = stack.pop();
        String left = stack.pop();

        if (left.equals("BOOL")) {
            addArgErr(ctx.op, ctx.expr(0).getStart(), left);
            errorSentinel = true;
            return;
        }

        if (right.equals("BOOL")) {
            addArgErr(ctx.op, ctx.expr(1).getStart(), right);
            errorSentinel = true;
            return;
        }

        if (!left.equals(right)) {
            // Report at left operand start
            addTypeClashErr(ctx.expr(0).getStart());
            errorSentinel = true;
            return;
        }

        stack.push("BOOL");
    }

    @Override
    public void exitEqualExpr(EasyCalcParser.EqualExprContext ctx) {
        if (errorSentinel) return;
        if (stack.size() < 2) return;

        String right = stack.pop();
        String left = stack.pop();

        if (!left.equals(right)) {
            addTypeClashErr(ctx.expr(0).getStart());
            errorSentinel = true;
            return;
        }

        stack.push("BOOL");
    }

    @Override
    public void exitAndExpr(EasyCalcParser.AndExprContext ctx) {
        if (errorSentinel) return;
        if (stack.size() < 2) return;

        String right = stack.pop();
        String left = stack.pop();

        if (!left.equals("BOOL")) {
            addArgErr(ctx.op, ctx.expr(0).getStart(), left);
            errorSentinel = true;
            return;
        }

        if (!right.equals("BOOL")) {
            addArgErr(ctx.op, ctx.expr(1).getStart(), right);
            errorSentinel = true;
            return;
        }

        stack.push("BOOL");
    }

    @Override
    public void exitOrExpr(EasyCalcParser.OrExprContext ctx) {
        if (errorSentinel) return;
        if (stack.size() < 2) return;

        String right = stack.pop();
        String left = stack.pop();

        if (!left.equals("BOOL")) {
            addArgErr(ctx.op, ctx.expr(0).getStart(), left);
            errorSentinel = true;
            return;
        }

        if (!right.equals("BOOL")) {
            addArgErr(ctx.op, ctx.expr(1).getStart(), right);
            errorSentinel = true;
            return;
        }

        stack.push("BOOL");
    }

    @Override
    public void exitIfExpr(EasyCalcParser.IfExprContext ctx) {
        if (errorSentinel) return;
        if (stack.size() < 3) return;

        String elseType = stack.pop();
        String thenType = stack.pop();
        String condType = stack.pop();

        if (!condType.equals("BOOL")) {
            addArgErr(ctx.start, ctx.expr(0).getStart(), condType);
            errorSentinel = true;
            return;
        }

        if (!thenType.equals(elseType)) {
            addTypeClashErr(ctx.expr(1).getStart());
            errorSentinel = true;
            return;
        }

        stack.push(thenType);
    }
}