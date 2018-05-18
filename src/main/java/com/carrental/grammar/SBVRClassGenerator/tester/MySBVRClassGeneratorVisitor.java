package com.carrental.grammar.SBVRClassGenerator.tester;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import com.carrental.grammar.SBVRClassGenerator.generatedClass.*;
import com.carrental.grammar.SBVRClassGenerator.generatedClass.SBVRClassGeneratorParser.AttrStatementContext;
import com.carrental.grammar.SBVRClassGenerator.generatedClass.SBVRClassGeneratorParser.EntityContext;
import com.carrental.grammar.generatedclass.CarrentalnewLexer;
import com.carrental.grammar.generatedclass.CarrentalnewParser;
import com.carrental.grammar.parserPolaKalimat.MyCarrentalnewVisitor;

import com.carrental.grammar.dataTypeHelper.*;

public class MySBVRClassGeneratorVisitor extends SBVRClassGeneratorBaseVisitor<String> {
	
	private DVariablesWrapper variables;
	
	public MySBVRClassGeneratorVisitor() {
		// TODO Auto-generated constructor stub
		variables = new DVariablesWrapper();
	}
	
	
	@Override
	public String visitEntity(EntityContext ctx) {
		// TODO Auto-generated method stub
		String className=VariablesConverter.getInstance().getClassName(ctx.className().getText().toString());
		//variables.dvar.add(new DVariables(className, className));
		return super.visitEntity(ctx);
	}
	
	@Override
	public String visitAttrStatement(AttrStatementContext ctx) {
		// TODO Auto-generated method stub
		String className=VariablesConverter.getInstance().getClassName(ctx.className().getText().toString());
		
		int idx = variables.isClassExist(className);
		if(idx>-1){
			String fieldName = VariablesConverter.getInstance().getFieldName(ctx.attribute(0).getText().toString());
			DAttributes tempAttr = new DAttributes(fieldName,fieldName);
			tempAttr.setType(ctx.attrType().getText().toString());
			variables.dvar.get(idx).attributes.add(tempAttr);
		}
		
		
		return super.visitAttrStatement(ctx);
	}
	
	public DVariablesWrapper getVariables(){
		return this.variables;
	}
}
