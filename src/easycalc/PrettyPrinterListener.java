package easycalc;

import easycalc.grammar.EasyCalcBaseListener;
import easycalc.grammar.EasyCalcParser;

import java.util.Stack;

public class PrettyPrinterListener extends EasyCalcBaseListener {

    private final Stack<String> stack = new Stack<>();
    private final StringBuilder sb = new StringBuilder();

    public String getProgramString() {
        return sb.toString();
    }

    @Override public void exitProgram(EasyCalcParser.ProgramContext ctx) {
        sb.append("$$\n");
    }

    // this method is complete
    @Override public void exitDeclar(EasyCalcParser.DeclarContext ctx) {
        sb.append(ctx.type.getText() + " " + ctx.ID().getText() + ";\n");
    }

    @Override public void exitAssignStmt(EasyCalcParser.AssignStmtContext ctx) {
        String expr = stack.pop();
        sb.append(ctx.ID().getText() + " := " + expr + ";\n");
    }

    @Override public void exitReadStmt(EasyCalcParser.ReadStmtContext ctx) {
        sb.append("read " + ctx.ID().getText() + ";\n");
    }

    @Override public void exitWriteStmt(EasyCalcParser.WriteStmtContext ctx) {
        String expr = stack.pop();
        sb.append("write " + expr + ";\n");
    }

    @Override public void exitLitExpr(EasyCalcParser.LitExprContext ctx) {
        stack.push(ctx.LIT().getText());
    }

    // This method is complete
    @Override public void exitIdExpr(EasyCalcParser.IdExprContext ctx) {
        stack.push(ctx.ID().getText());
    }

    @Override public void exitParenExpr(EasyCalcParser.ParenExprContext ctx) {
        String inside = stack.pop(); // works inside out starting with the expr

        if (inside.startsWith("(") && inside.endsWith(")")) { // keeps checking for mulitple wraps
            inside = inside.substring(1, inside.length() - 1); // if found then resize it back to one set of parthesis
        }
        stack.push("(" + inside + ")");
    }

    @Override public void exitToExpr(EasyCalcParser.ToExprContext ctx) {
        String inside = stack.pop();
        String func = ctx.op.getText();
        stack.push(func + "(" + inside + ")");
    }

    @Override public void exitMulDivExpr(EasyCalcParser.MulDivExprContext ctx) {
        String right = stack.pop();
        String left = stack.pop();
        String func = ctx.op.getText();
        stack.push(left + " " + func + " " + right);
    }

    @Override public void exitAddSubExpr(EasyCalcParser.AddSubExprContext ctx) {
        String right = stack.pop();
        String left = stack.pop();
        String func = ctx.op.getText();
        stack.push(left + " " + func + " " + right);
    }

    @Override public void exitLessGrtrExpr(EasyCalcParser.LessGrtrExprContext ctx) {
        String right = stack.pop();
        String left = stack.pop();
        String func = ctx.op.getText();
        stack.push(left + " " + func + " " + right);
    }

    @Override public void exitEqualExpr(EasyCalcParser.EqualExprContext ctx) {
        String right = stack.pop();
        String left = stack.pop();
        String func = ctx.op.getText();
        stack.push(left + " " + func + " " + right);
    }

    @Override public void exitAndExpr(EasyCalcParser.AndExprContext ctx) {
        String right = stack.pop();
        String left = stack.pop();
        String func = ctx.op.getText();
        stack.push(left + " " + func + " " + right);
    }

    @Override public void exitOrExpr(EasyCalcParser.OrExprContext ctx) {
        String right = stack.pop();
        String left = stack.pop();
        String func = ctx.op.getText();
        stack.push(left + " " + func + " " + right);
    }

    @Override public void exitIfExpr(EasyCalcParser.IfExprContext ctx) {
        String elseExpr = stack.pop();
        String thenExpr = stack.pop();
        String condition = stack.pop();
        String result = "if " + condition + " then " + thenExpr + " else " + elseExpr;
        stack.push(result);
    }
}