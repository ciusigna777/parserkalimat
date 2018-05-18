package com.carrental.grammar.SBVRClassGenerator.tester;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import com.carrental.grammar.SBVRClassGenerator.generatedClass.SBVRClassGeneratorLexer;
import com.carrental.grammar.SBVRClassGenerator.generatedClass.SBVRClassGeneratorParser;
import com.carrental.grammar.dataTypeHelper.DVariablesWrapper;

public class SBVRClassGeneratorTester {
	public static void main(String[]args){
		try{
			ANTLRInputStream input = new ANTLRInputStream(System.in);
			
			SBVRClassGeneratorLexer lexer = new SBVRClassGeneratorLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			SBVRClassGeneratorParser parser = new SBVRClassGeneratorParser(tokens);
			ParseTree tree = parser.entity();
			MySBVRClassGeneratorVisitor visitor = new MySBVRClassGeneratorVisitor();
			
			
			visitor.visit(tree);
			DVariablesWrapper var = visitor.getVariables();
			
			for(int i=0;i<var.dvar.size();i++){
				System.out.println("Class: "+var.dvar.get(i).getClassName()+"\nVariables: ");
				
				for(int j=0;j<var.dvar.get(i).attributes.size();j++){
					System.out.println(var.dvar.get(i).attributes.get(j).getType()+" "+var.dvar.get(i).attributes.get(j).getName());
				}
				
			}
			//System.out.println(tree.toStringTree(parser));
			
			//System.out.println(visitor.getCodeResult());
			
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
	}
}
