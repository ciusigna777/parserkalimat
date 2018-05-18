// Generated from SBVRClassGenerator.g4 by ANTLR 4.3
package com.carrental.grammar.SBVRClassGenerator.generatedClass;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SBVRClassGeneratorParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__14=1, T__13=2, T__12=3, T__11=4, T__10=5, T__9=6, T__8=7, T__7=8, T__6=9, 
		T__5=10, T__4=11, T__3=12, T__2=13, T__1=14, T__0=15, WS=16;
	public static final String[] tokenNames = {
		"<INVALID>", "'branch'", "'driver'", "'type is'", "'integer'", "'Datetime'", 
		"'float'", "'arraylist'", "'String'", "'pickup branch'", "'car'", "'rental'", 
		"'double'", "'rentalID'", "'return branch'", "'has'", "WS"
	};
	public static final int
		RULE_entity = 0, RULE_attrStatement = 1, RULE_className = 2, RULE_attribute = 3, 
		RULE_attrType = 4;
	public static final String[] ruleNames = {
		"entity", "attrStatement", "className", "attribute", "attrType"
	};

	@Override
	public String getGrammarFileName() { return "SBVRClassGenerator.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SBVRClassGeneratorParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class EntityContext extends ParserRuleContext {
		public AttrStatementContext attrStatement(int i) {
			return getRuleContext(AttrStatementContext.class,i);
		}
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public List<AttrStatementContext> attrStatement() {
			return getRuleContexts(AttrStatementContext.class);
		}
		public EntityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SBVRClassGeneratorListener ) ((SBVRClassGeneratorListener)listener).enterEntity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SBVRClassGeneratorListener ) ((SBVRClassGeneratorListener)listener).exitEntity(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SBVRClassGeneratorVisitor ) return ((SBVRClassGeneratorVisitor<? extends T>)visitor).visitEntity(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EntityContext entity() throws RecognitionException {
		EntityContext _localctx = new EntityContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_entity);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10); className();
			setState(14);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__5) | (1L << T__4))) != 0)) {
				{
				{
				setState(11); attrStatement();
				}
				}
				setState(16);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class AttrStatementContext extends ParserRuleContext {
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttrTypeContext attrType() {
			return getRuleContext(AttrTypeContext.class,0);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public AttrStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SBVRClassGeneratorListener ) ((SBVRClassGeneratorListener)listener).enterAttrStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SBVRClassGeneratorListener ) ((SBVRClassGeneratorListener)listener).exitAttrStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SBVRClassGeneratorVisitor ) return ((SBVRClassGeneratorVisitor<? extends T>)visitor).visitAttrStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrStatementContext attrStatement() throws RecognitionException {
		AttrStatementContext _localctx = new AttrStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_attrStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17); className();
			setState(18); match(T__0);
			setState(19); attribute();
			setState(20); attribute();
			setState(21); match(T__12);
			setState(22); attrType();
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

	public static class ClassNameContext extends ParserRuleContext {
		public ClassNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_className; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SBVRClassGeneratorListener ) ((SBVRClassGeneratorListener)listener).enterClassName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SBVRClassGeneratorListener ) ((SBVRClassGeneratorListener)listener).exitClassName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SBVRClassGeneratorVisitor ) return ((SBVRClassGeneratorVisitor<? extends T>)visitor).visitClassName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassNameContext className() throws RecognitionException {
		ClassNameContext _localctx = new ClassNameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_className);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__5) | (1L << T__4))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class AttributeContext extends ParserRuleContext {
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SBVRClassGeneratorListener ) ((SBVRClassGeneratorListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SBVRClassGeneratorListener ) ((SBVRClassGeneratorListener)listener).exitAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SBVRClassGeneratorVisitor ) return ((SBVRClassGeneratorVisitor<? extends T>)visitor).visitAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__2) | (1L << T__1))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class AttrTypeContext extends ParserRuleContext {
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public AttrTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SBVRClassGeneratorListener ) ((SBVRClassGeneratorListener)listener).enterAttrType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SBVRClassGeneratorListener ) ((SBVRClassGeneratorListener)listener).exitAttrType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SBVRClassGeneratorVisitor ) return ((SBVRClassGeneratorVisitor<? extends T>)visitor).visitAttrType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrTypeContext attrType() throws RecognitionException {
		AttrTypeContext _localctx = new AttrTypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_attrType);
		try {
			setState(36);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(28); match(T__7);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(29); match(T__11);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(30); match(T__9);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 4);
				{
				setState(31); match(T__3);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 5);
				{
				setState(32); match(T__8);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 6);
				{
				setState(33); match(T__10);
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 7);
				{
				setState(34); match(T__14);
				}
				break;
			case T__13:
			case T__5:
			case T__4:
				enterOuterAlt(_localctx, 8);
				{
				setState(35); className();
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\22)\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\7\2\17\n\2\f\2\16\2\22\13\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5"+
		"\6\'\n\6\3\6\2\2\7\2\4\6\b\n\2\4\4\2\4\4\f\r\4\2\13\13\17\20+\2\f\3\2"+
		"\2\2\4\23\3\2\2\2\6\32\3\2\2\2\b\34\3\2\2\2\n&\3\2\2\2\f\20\5\6\4\2\r"+
		"\17\5\4\3\2\16\r\3\2\2\2\17\22\3\2\2\2\20\16\3\2\2\2\20\21\3\2\2\2\21"+
		"\3\3\2\2\2\22\20\3\2\2\2\23\24\5\6\4\2\24\25\7\21\2\2\25\26\5\b\5\2\26"+
		"\27\5\b\5\2\27\30\7\5\2\2\30\31\5\n\6\2\31\5\3\2\2\2\32\33\t\2\2\2\33"+
		"\7\3\2\2\2\34\35\t\3\2\2\35\t\3\2\2\2\36\'\7\n\2\2\37\'\7\6\2\2 \'\7\b"+
		"\2\2!\'\7\16\2\2\"\'\7\t\2\2#\'\7\7\2\2$\'\7\3\2\2%\'\5\6\4\2&\36\3\2"+
		"\2\2&\37\3\2\2\2& \3\2\2\2&!\3\2\2\2&\"\3\2\2\2&#\3\2\2\2&$\3\2\2\2&%"+
		"\3\2\2\2\'\13\3\2\2\2\4\20&";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}