// Generated from SBVRClassGenerator.g4 by ANTLR 4.3
package com.carrental.grammar.SBVRClassGenerator.generatedClass;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SBVRClassGeneratorLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__14=1, T__13=2, T__12=3, T__11=4, T__10=5, T__9=6, T__8=7, T__7=8, T__6=9, 
		T__5=10, T__4=11, T__3=12, T__2=13, T__1=14, T__0=15, WS=16;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'"
	};
	public static final String[] ruleNames = {
		"T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", 
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "WS"
	};


	public SBVRClassGeneratorLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SBVRClassGenerator.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\22\u00a3\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\21\6\21\u009e\n\21\r\21\16\21\u009f\3\21\3\21\2"+
		"\2\22\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22\3\2\3\5\2\13\f\17\17\"\"\u00a3\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2\5*\3\2\2\2\7\61\3\2\2"+
		"\2\t9\3\2\2\2\13A\3\2\2\2\rJ\3\2\2\2\17P\3\2\2\2\21Z\3\2\2\2\23a\3\2\2"+
		"\2\25o\3\2\2\2\27s\3\2\2\2\31z\3\2\2\2\33\u0081\3\2\2\2\35\u008a\3\2\2"+
		"\2\37\u0098\3\2\2\2!\u009d\3\2\2\2#$\7d\2\2$%\7t\2\2%&\7c\2\2&\'\7p\2"+
		"\2\'(\7e\2\2()\7j\2\2)\4\3\2\2\2*+\7f\2\2+,\7t\2\2,-\7k\2\2-.\7x\2\2."+
		"/\7g\2\2/\60\7t\2\2\60\6\3\2\2\2\61\62\7v\2\2\62\63\7{\2\2\63\64\7r\2"+
		"\2\64\65\7g\2\2\65\66\7\"\2\2\66\67\7k\2\2\678\7u\2\28\b\3\2\2\29:\7k"+
		"\2\2:;\7p\2\2;<\7v\2\2<=\7g\2\2=>\7i\2\2>?\7g\2\2?@\7t\2\2@\n\3\2\2\2"+
		"AB\7F\2\2BC\7c\2\2CD\7v\2\2DE\7g\2\2EF\7v\2\2FG\7k\2\2GH\7o\2\2HI\7g\2"+
		"\2I\f\3\2\2\2JK\7h\2\2KL\7n\2\2LM\7q\2\2MN\7c\2\2NO\7v\2\2O\16\3\2\2\2"+
		"PQ\7c\2\2QR\7t\2\2RS\7t\2\2ST\7c\2\2TU\7{\2\2UV\7n\2\2VW\7k\2\2WX\7u\2"+
		"\2XY\7v\2\2Y\20\3\2\2\2Z[\7U\2\2[\\\7v\2\2\\]\7t\2\2]^\7k\2\2^_\7p\2\2"+
		"_`\7i\2\2`\22\3\2\2\2ab\7r\2\2bc\7k\2\2cd\7e\2\2de\7m\2\2ef\7w\2\2fg\7"+
		"r\2\2gh\7\"\2\2hi\7d\2\2ij\7t\2\2jk\7c\2\2kl\7p\2\2lm\7e\2\2mn\7j\2\2"+
		"n\24\3\2\2\2op\7e\2\2pq\7c\2\2qr\7t\2\2r\26\3\2\2\2st\7t\2\2tu\7g\2\2"+
		"uv\7p\2\2vw\7v\2\2wx\7c\2\2xy\7n\2\2y\30\3\2\2\2z{\7f\2\2{|\7q\2\2|}\7"+
		"w\2\2}~\7d\2\2~\177\7n\2\2\177\u0080\7g\2\2\u0080\32\3\2\2\2\u0081\u0082"+
		"\7t\2\2\u0082\u0083\7g\2\2\u0083\u0084\7p\2\2\u0084\u0085\7v\2\2\u0085"+
		"\u0086\7c\2\2\u0086\u0087\7n\2\2\u0087\u0088\7K\2\2\u0088\u0089\7F\2\2"+
		"\u0089\34\3\2\2\2\u008a\u008b\7t\2\2\u008b\u008c\7g\2\2\u008c\u008d\7"+
		"v\2\2\u008d\u008e\7w\2\2\u008e\u008f\7t\2\2\u008f\u0090\7p\2\2\u0090\u0091"+
		"\7\"\2\2\u0091\u0092\7d\2\2\u0092\u0093\7t\2\2\u0093\u0094\7c\2\2\u0094"+
		"\u0095\7p\2\2\u0095\u0096\7e\2\2\u0096\u0097\7j\2\2\u0097\36\3\2\2\2\u0098"+
		"\u0099\7j\2\2\u0099\u009a\7c\2\2\u009a\u009b\7u\2\2\u009b \3\2\2\2\u009c"+
		"\u009e\t\2\2\2\u009d\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u009d\3\2"+
		"\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\b\21\2\2\u00a2"+
		"\"\3\2\2\2\4\2\u009f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}