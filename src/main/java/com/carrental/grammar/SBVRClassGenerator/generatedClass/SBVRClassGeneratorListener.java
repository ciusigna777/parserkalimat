// Generated from SBVRClassGenerator.g4 by ANTLR 4.3
package com.carrental.grammar.SBVRClassGenerator.generatedClass;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SBVRClassGeneratorParser}.
 */
public interface SBVRClassGeneratorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SBVRClassGeneratorParser#className}.
	 * @param ctx the parse tree
	 */
	void enterClassName(@NotNull SBVRClassGeneratorParser.ClassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SBVRClassGeneratorParser#className}.
	 * @param ctx the parse tree
	 */
	void exitClassName(@NotNull SBVRClassGeneratorParser.ClassNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link SBVRClassGeneratorParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(@NotNull SBVRClassGeneratorParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SBVRClassGeneratorParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(@NotNull SBVRClassGeneratorParser.AttributeContext ctx);

	/**
	 * Enter a parse tree produced by {@link SBVRClassGeneratorParser#attrStatement}.
	 * @param ctx the parse tree
	 */
	void enterAttrStatement(@NotNull SBVRClassGeneratorParser.AttrStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SBVRClassGeneratorParser#attrStatement}.
	 * @param ctx the parse tree
	 */
	void exitAttrStatement(@NotNull SBVRClassGeneratorParser.AttrStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link SBVRClassGeneratorParser#entity}.
	 * @param ctx the parse tree
	 */
	void enterEntity(@NotNull SBVRClassGeneratorParser.EntityContext ctx);
	/**
	 * Exit a parse tree produced by {@link SBVRClassGeneratorParser#entity}.
	 * @param ctx the parse tree
	 */
	void exitEntity(@NotNull SBVRClassGeneratorParser.EntityContext ctx);

	/**
	 * Enter a parse tree produced by {@link SBVRClassGeneratorParser#attrType}.
	 * @param ctx the parse tree
	 */
	void enterAttrType(@NotNull SBVRClassGeneratorParser.AttrTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SBVRClassGeneratorParser#attrType}.
	 * @param ctx the parse tree
	 */
	void exitAttrType(@NotNull SBVRClassGeneratorParser.AttrTypeContext ctx);
}