// Generated from /Users/harlemmariscal/IdeaProjects/Project 1/src/easycalc/grammar/EasyCalc.g4 by ANTLR 4.13.2
package easycalc.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EasyCalcParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EasyCalcVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EasyCalcParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(EasyCalcParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyCalcParser#declar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclar(EasyCalcParser.DeclarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignStmt}
	 * labeled alternative in {@link EasyCalcParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStmt(EasyCalcParser.AssignStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReadStmt}
	 * labeled alternative in {@link EasyCalcParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadStmt(EasyCalcParser.ReadStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WriteStmt}
	 * labeled alternative in {@link EasyCalcParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteStmt(EasyCalcParser.WriteStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(EasyCalcParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessGrtrExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessGrtrExpr(EasyCalcParser.LessGrtrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqualExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualExpr(EasyCalcParser.EqualExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExpr(EasyCalcParser.IfExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDivExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivExpr(EasyCalcParser.MulDivExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(EasyCalcParser.IdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToExpr(EasyCalcParser.ToExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LitExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLitExpr(EasyCalcParser.LitExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(EasyCalcParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSubExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpr(EasyCalcParser.AddSubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrExpr}
	 * labeled alternative in {@link EasyCalcParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(EasyCalcParser.OrExprContext ctx);
}