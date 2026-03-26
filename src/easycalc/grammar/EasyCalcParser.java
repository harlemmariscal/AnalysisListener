// Generated from /Users/harlemmariscal/IdeaProjects/Project 1/src/easycalc/grammar/EasyCalc.g4 by ANTLR 4.13.2
package easycalc.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class EasyCalcParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DSTOP=1, SSTOP=2, BOOL=3, INT=4, REAL=5, ASSIGN=6, READ=7, WRITE=8, LPAREN=9, 
		RRAPEN=10, TINT=11, TREAL=12, MUL=13, DIV=14, ADD=15, SUB=16, LESS=17, 
		GRTR=18, EQUAL=19, AND=20, OR=21, IF=22, THEN=23, ELSE=24, LIT=25, ID=26, 
		WS=27;
	public static final int
		RULE_program = 0, RULE_declar = 1, RULE_stmt = 2, RULE_expr = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declar", "stmt", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'$$'", "';'", "'bool'", "'int'", "'real'", "':='", "'read'", "'write'", 
			"'('", "')'", "'to_int'", "'to_real'", "'*'", "'/'", "'+'", "'-'", "'<'", 
			"'>'", "'=='", "'and'", "'or'", "'if'", "'then'", "'else'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DSTOP", "SSTOP", "BOOL", "INT", "REAL", "ASSIGN", "READ", "WRITE", 
			"LPAREN", "RRAPEN", "TINT", "TREAL", "MUL", "DIV", "ADD", "SUB", "LESS", 
			"GRTR", "EQUAL", "AND", "OR", "IF", "THEN", "ELSE", "LIT", "ID", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "EasyCalc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EasyCalcParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode DSTOP() { return getToken(EasyCalcParser.DSTOP, 0); }
		public List<DeclarContext> declar() {
			return getRuleContexts(DeclarContext.class);
		}
		public DeclarContext declar(int i) {
			return getRuleContext(DeclarContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyCalcVisitor ) return ((EasyCalcVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 56L) != 0)) {
				{
				{
				setState(8);
				declar();
				}
				}
				setState(13);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(17);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 67109248L) != 0)) {
				{
				{
				setState(14);
				stmt();
				}
				}
				setState(19);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(20);
			match(DSTOP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarContext extends ParserRuleContext {
		public Token type;
		public TerminalNode ID() { return getToken(EasyCalcParser.ID, 0); }
		public TerminalNode SSTOP() { return getToken(EasyCalcParser.SSTOP, 0); }
		public TerminalNode BOOL() { return getToken(EasyCalcParser.BOOL, 0); }
		public TerminalNode INT() { return getToken(EasyCalcParser.INT, 0); }
		public TerminalNode REAL() { return getToken(EasyCalcParser.REAL, 0); }
		public DeclarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).enterDeclar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).exitDeclar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyCalcVisitor ) return ((EasyCalcVisitor<? extends T>)visitor).visitDeclar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarContext declar() throws RecognitionException {
		DeclarContext _localctx = new DeclarContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			((DeclarContext)_localctx).type = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 56L) != 0)) ) {
				((DeclarContext)_localctx).type = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(23);
			match(ID);
			setState(24);
			match(SSTOP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StmtContext extends ParserRuleContext {
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	 
		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignStmtContext extends StmtContext {
		public TerminalNode ID() { return getToken(EasyCalcParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(EasyCalcParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SSTOP() { return getToken(EasyCalcParser.SSTOP, 0); }
		public AssignStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).enterAssignStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).exitAssignStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyCalcVisitor ) return ((EasyCalcVisitor<? extends T>)visitor).visitAssignStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WriteStmtContext extends StmtContext {
		public TerminalNode WRITE() { return getToken(EasyCalcParser.WRITE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SSTOP() { return getToken(EasyCalcParser.SSTOP, 0); }
		public WriteStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).enterWriteStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).exitWriteStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyCalcVisitor ) return ((EasyCalcVisitor<? extends T>)visitor).visitWriteStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReadStmtContext extends StmtContext {
		public TerminalNode READ() { return getToken(EasyCalcParser.READ, 0); }
		public TerminalNode ID() { return getToken(EasyCalcParser.ID, 0); }
		public TerminalNode SSTOP() { return getToken(EasyCalcParser.SSTOP, 0); }
		public ReadStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).enterReadStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).exitReadStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyCalcVisitor ) return ((EasyCalcVisitor<? extends T>)visitor).visitReadStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stmt);
		try {
			setState(38);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new AssignStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				match(ID);
				setState(27);
				match(ASSIGN);
				setState(28);
				expr(0);
				setState(29);
				match(SSTOP);
				}
				break;
			case READ:
				_localctx = new ReadStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				match(READ);
				setState(32);
				match(ID);
				setState(33);
				match(SSTOP);
				}
				break;
			case WRITE:
				_localctx = new WriteStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(34);
				match(WRITE);
				setState(35);
				expr(0);
				setState(36);
				match(SSTOP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(EasyCalcParser.AND, 0); }
		public AndExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).exitAndExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyCalcVisitor ) return ((EasyCalcVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LessGrtrExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LESS() { return getToken(EasyCalcParser.LESS, 0); }
		public TerminalNode GRTR() { return getToken(EasyCalcParser.GRTR, 0); }
		public LessGrtrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).enterLessGrtrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).exitLessGrtrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyCalcVisitor ) return ((EasyCalcVisitor<? extends T>)visitor).visitLessGrtrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(EasyCalcParser.EQUAL, 0); }
		public EqualExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).enterEqualExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).exitEqualExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyCalcVisitor ) return ((EasyCalcVisitor<? extends T>)visitor).visitEqualExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfExprContext extends ExprContext {
		public TerminalNode IF() { return getToken(EasyCalcParser.IF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode THEN() { return getToken(EasyCalcParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(EasyCalcParser.ELSE, 0); }
		public IfExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).enterIfExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).exitIfExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyCalcVisitor ) return ((EasyCalcVisitor<? extends T>)visitor).visitIfExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(EasyCalcParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(EasyCalcParser.DIV, 0); }
		public MulDivExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).enterMulDivExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).exitMulDivExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyCalcVisitor ) return ((EasyCalcVisitor<? extends T>)visitor).visitMulDivExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(EasyCalcParser.ID, 0); }
		public IdExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).enterIdExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).exitIdExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyCalcVisitor ) return ((EasyCalcVisitor<? extends T>)visitor).visitIdExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ToExprContext extends ExprContext {
		public Token op;
		public TerminalNode LPAREN() { return getToken(EasyCalcParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RRAPEN() { return getToken(EasyCalcParser.RRAPEN, 0); }
		public TerminalNode TINT() { return getToken(EasyCalcParser.TINT, 0); }
		public TerminalNode TREAL() { return getToken(EasyCalcParser.TREAL, 0); }
		public ToExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).enterToExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).exitToExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyCalcVisitor ) return ((EasyCalcVisitor<? extends T>)visitor).visitToExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LitExprContext extends ExprContext {
		public TerminalNode LIT() { return getToken(EasyCalcParser.LIT, 0); }
		public LitExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).enterLitExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).exitLitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyCalcVisitor ) return ((EasyCalcVisitor<? extends T>)visitor).visitLitExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExprContext extends ExprContext {
		public TerminalNode LPAREN() { return getToken(EasyCalcParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RRAPEN() { return getToken(EasyCalcParser.RRAPEN, 0); }
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).exitParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyCalcVisitor ) return ((EasyCalcVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ADD() { return getToken(EasyCalcParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(EasyCalcParser.SUB, 0); }
		public AddSubExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).enterAddSubExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).exitAddSubExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyCalcVisitor ) return ((EasyCalcVisitor<? extends T>)visitor).visitAddSubExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(EasyCalcParser.OR, 0); }
		public OrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EasyCalcListener ) ((EasyCalcListener)listener).exitOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EasyCalcVisitor ) return ((EasyCalcVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LIT:
				{
				_localctx = new LitExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(41);
				match(LIT);
				}
				break;
			case ID:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(42);
				match(ID);
				}
				break;
			case LPAREN:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(43);
				match(LPAREN);
				setState(44);
				expr(0);
				setState(45);
				match(RRAPEN);
				}
				break;
			case TINT:
			case TREAL:
				{
				_localctx = new ToExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(47);
				((ToExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==TINT || _la==TREAL) ) {
					((ToExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(48);
				match(LPAREN);
				setState(49);
				expr(0);
				setState(50);
				match(RRAPEN);
				}
				break;
			case IF:
				{
				_localctx = new IfExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(52);
				match(IF);
				setState(53);
				expr(0);
				setState(54);
				match(THEN);
				setState(55);
				expr(0);
				setState(56);
				match(ELSE);
				setState(57);
				expr(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(81);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(79);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(61);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(62);
						((MulDivExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((MulDivExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(63);
						expr(8);
						}
						break;
					case 2:
						{
						_localctx = new AddSubExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(64);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(65);
						((AddSubExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AddSubExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(66);
						expr(7);
						}
						break;
					case 3:
						{
						_localctx = new LessGrtrExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(67);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(68);
						((LessGrtrExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==LESS || _la==GRTR) ) {
							((LessGrtrExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(69);
						expr(6);
						}
						break;
					case 4:
						{
						_localctx = new EqualExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(70);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(71);
						((EqualExprContext)_localctx).op = match(EQUAL);
						setState(72);
						expr(5);
						}
						break;
					case 5:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(73);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(74);
						((AndExprContext)_localctx).op = match(AND);
						setState(75);
						expr(4);
						}
						break;
					case 6:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(76);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(77);
						((OrExprContext)_localctx).op = match(OR);
						setState(78);
						expr(3);
						}
						break;
					}
					} 
				}
				setState(83);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001bU\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0005\u0000\n\b"+
		"\u0000\n\u0000\f\u0000\r\t\u0000\u0001\u0000\u0005\u0000\u0010\b\u0000"+
		"\n\u0000\f\u0000\u0013\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002\'\b\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003<\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0005\u0003P\b\u0003\n\u0003\f\u0003S\t\u0003\u0001"+
		"\u0003\u0000\u0001\u0006\u0004\u0000\u0002\u0004\u0006\u0000\u0005\u0001"+
		"\u0000\u0003\u0005\u0001\u0000\u000b\f\u0001\u0000\r\u000e\u0001\u0000"+
		"\u000f\u0010\u0001\u0000\u0011\u0012^\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0002\u0016\u0001\u0000\u0000\u0000\u0004&\u0001\u0000\u0000\u0000\u0006"+
		";\u0001\u0000\u0000\u0000\b\n\u0003\u0002\u0001\u0000\t\b\u0001\u0000"+
		"\u0000\u0000\n\r\u0001\u0000\u0000\u0000\u000b\t\u0001\u0000\u0000\u0000"+
		"\u000b\f\u0001\u0000\u0000\u0000\f\u0011\u0001\u0000\u0000\u0000\r\u000b"+
		"\u0001\u0000\u0000\u0000\u000e\u0010\u0003\u0004\u0002\u0000\u000f\u000e"+
		"\u0001\u0000\u0000\u0000\u0010\u0013\u0001\u0000\u0000\u0000\u0011\u000f"+
		"\u0001\u0000\u0000\u0000\u0011\u0012\u0001\u0000\u0000\u0000\u0012\u0014"+
		"\u0001\u0000\u0000\u0000\u0013\u0011\u0001\u0000\u0000\u0000\u0014\u0015"+
		"\u0005\u0001\u0000\u0000\u0015\u0001\u0001\u0000\u0000\u0000\u0016\u0017"+
		"\u0007\u0000\u0000\u0000\u0017\u0018\u0005\u001a\u0000\u0000\u0018\u0019"+
		"\u0005\u0002\u0000\u0000\u0019\u0003\u0001\u0000\u0000\u0000\u001a\u001b"+
		"\u0005\u001a\u0000\u0000\u001b\u001c\u0005\u0006\u0000\u0000\u001c\u001d"+
		"\u0003\u0006\u0003\u0000\u001d\u001e\u0005\u0002\u0000\u0000\u001e\'\u0001"+
		"\u0000\u0000\u0000\u001f \u0005\u0007\u0000\u0000 !\u0005\u001a\u0000"+
		"\u0000!\'\u0005\u0002\u0000\u0000\"#\u0005\b\u0000\u0000#$\u0003\u0006"+
		"\u0003\u0000$%\u0005\u0002\u0000\u0000%\'\u0001\u0000\u0000\u0000&\u001a"+
		"\u0001\u0000\u0000\u0000&\u001f\u0001\u0000\u0000\u0000&\"\u0001\u0000"+
		"\u0000\u0000\'\u0005\u0001\u0000\u0000\u0000()\u0006\u0003\uffff\uffff"+
		"\u0000)<\u0005\u0019\u0000\u0000*<\u0005\u001a\u0000\u0000+,\u0005\t\u0000"+
		"\u0000,-\u0003\u0006\u0003\u0000-.\u0005\n\u0000\u0000.<\u0001\u0000\u0000"+
		"\u0000/0\u0007\u0001\u0000\u000001\u0005\t\u0000\u000012\u0003\u0006\u0003"+
		"\u000023\u0005\n\u0000\u00003<\u0001\u0000\u0000\u000045\u0005\u0016\u0000"+
		"\u000056\u0003\u0006\u0003\u000067\u0005\u0017\u0000\u000078\u0003\u0006"+
		"\u0003\u000089\u0005\u0018\u0000\u00009:\u0003\u0006\u0003\u0001:<\u0001"+
		"\u0000\u0000\u0000;(\u0001\u0000\u0000\u0000;*\u0001\u0000\u0000\u0000"+
		";+\u0001\u0000\u0000\u0000;/\u0001\u0000\u0000\u0000;4\u0001\u0000\u0000"+
		"\u0000<Q\u0001\u0000\u0000\u0000=>\n\u0007\u0000\u0000>?\u0007\u0002\u0000"+
		"\u0000?P\u0003\u0006\u0003\b@A\n\u0006\u0000\u0000AB\u0007\u0003\u0000"+
		"\u0000BP\u0003\u0006\u0003\u0007CD\n\u0005\u0000\u0000DE\u0007\u0004\u0000"+
		"\u0000EP\u0003\u0006\u0003\u0006FG\n\u0004\u0000\u0000GH\u0005\u0013\u0000"+
		"\u0000HP\u0003\u0006\u0003\u0005IJ\n\u0003\u0000\u0000JK\u0005\u0014\u0000"+
		"\u0000KP\u0003\u0006\u0003\u0004LM\n\u0002\u0000\u0000MN\u0005\u0015\u0000"+
		"\u0000NP\u0003\u0006\u0003\u0003O=\u0001\u0000\u0000\u0000O@\u0001\u0000"+
		"\u0000\u0000OC\u0001\u0000\u0000\u0000OF\u0001\u0000\u0000\u0000OI\u0001"+
		"\u0000\u0000\u0000OL\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000"+
		"QO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000R\u0007\u0001\u0000"+
		"\u0000\u0000SQ\u0001\u0000\u0000\u0000\u0006\u000b\u0011&;OQ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}