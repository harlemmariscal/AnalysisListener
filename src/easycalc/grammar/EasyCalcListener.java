// Generated from /Users/harlemmariscal/IdeaProjects/Project 1/src/easycalc/grammar/EasyCalc.g4 by ANTLR 4.13.2
package easycalc.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EasyCalcParser}.
 */
public interface EasyCalcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EasyCalcParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(EasyCalcParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyCalcParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(EasyCalcParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyCalcParser#declar}.
	 * @param ctx the parse tree
	 */
	void enterDeclar(EasyCalcParser.DeclarContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyCalcParser#declar}.
	 * @param ctx the parse tree
	 */
	void exitDeclar(EasyCalcParser.DeclarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignStmt}
	 * labeled alternative in {@link EasyCalcParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignStmt(EasyCalcParser.AssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignStmt}
	 * labeled alternative in {@link EasyCalcParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignStmt(EasyCalcParser.AssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReadStmt}
	 * labeled alternative in {@link EasyCalcParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterReadStmt(EasyCalcParser.ReadStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReadStmt}
	 * labeled alternative in {@link EasyCalcParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitReadStmt(EasyCalcParser.ReadStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WriteStmt}
	 * labeled alternative in {@link EasyCalcParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterWriteStmt(EasyCalcParser.WriteStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WriteStmt}
	 * labeled alternative in {@link EasyCalcParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitWriteStmt(EasyCalcParser.WriteStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AndExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(EasyCalcParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AndExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(EasyCalcParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LessGrtrExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLessGrtrExpr(EasyCalcParser.LessGrtrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LessGrtrExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLessGrtrExpr(EasyCalcParser.LessGrtrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqualExpr(EasyCalcParser.EqualExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqualExpr(EasyCalcParser.EqualExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIfExpr(EasyCalcParser.IfExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIfExpr(EasyCalcParser.IfExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDivExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDivExpr(EasyCalcParser.MulDivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDivExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDivExpr(EasyCalcParser.MulDivExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(EasyCalcParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(EasyCalcParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterToExpr(EasyCalcParser.ToExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitToExpr(EasyCalcParser.ToExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LitExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLitExpr(EasyCalcParser.LitExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LitExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLitExpr(EasyCalcParser.LitExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(EasyCalcParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(EasyCalcParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSubExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExpr(EasyCalcParser.AddSubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSubExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExpr(EasyCalcParser.AddSubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OrExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(EasyCalcParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OrExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(EasyCalcParser.OrExprContext ctx);
}