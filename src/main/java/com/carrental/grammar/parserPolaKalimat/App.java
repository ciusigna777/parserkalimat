package com.carrental.grammar.parserPolaKalimat;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import com.carrental.grammar.dataTypeHelper.DVariables;
import com.carrental.grammar.dataTypeHelper.DVariablesWrapper;
import com.carrental.grammar.generatedclass.*;
import com.carrental.grammar.classTest.*;
/**
 * Hello world!
 *
 */
public class App 
{
	public static void generateDvar(DVariablesWrapper wrapper){
		
	}
    public static void main( String[] args )
    {
    	try{
    		
    		DVariablesWrapper wrapper= new DVariablesWrapper();
			Rental r = new Rental();
			Driver d = new Driver();
			Creditcard cc = new Creditcard();
			OperatingCompany oc = new OperatingCompany();
			
			wrapper.dvar.add(new DVariables(r));
			wrapper.dvar.add(new DVariables(d));
			wrapper.dvar.add(new DVariables(cc));
			wrapper.dvar.add(new DVariables(oc));
    		
			
			//wrapper.printAllVariables();
			
			
			MyCarrentalnewVisitor visitor = new MyCarrentalnewVisitor(wrapper);
			
			visitor.setVariables(wrapper);
			ANTLRInputStream input = new ANTLRInputStream(System.in);
			
			CarrentalnewLexer lexer = new CarrentalnewLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			CarrentalnewParser parser = new CarrentalnewParser(tokens);
			
			
			ParseTree tree = parser.sbvr();
			
			
			visitor.visit(tree);
			//visitor.printWrapper();
			
			
			System.out.println(tree.getText().toString());
			//DVariablesWrapper vars = visitor.getVariables();
			//vars.printAllVariables();
			//System.out.println(visitor.getCodeResult());
			
    	}
		catch(Exception exc){
			exc.printStackTrace();
		}
    }
}
