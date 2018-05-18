// Generated from SBVRClassGenerator.g4 by ANTLR 4.3
package com.carrental.grammar.SBVRClassGenerator.generatedClass;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SBVRClassGeneratorParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SBVRClassGeneratorVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SBVRClassGeneratorParser#className}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassName(@NotNull SBVRClassGeneratorParser.ClassNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link SBVRClassGeneratorParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(@NotNull SBVRClassGeneratorParser.AttributeContext ctx);

	/**
	 * Visit a parse tree produced by {@link SBVRClassGeneratorParser#attrStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrStatement(@NotNull SBVRClassGeneratorParser.AttrStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SBVRClassGeneratorParser#entity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntity(@NotNull SBVRClassGeneratorParser.EntityContext ctx);

	/**
	 * Visit a parse tree produced by {@link SBVRClassGeneratorParser#attrType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrType(@NotNull SBVRClassGeneratorParser.AttrTypeContext ctx);
}