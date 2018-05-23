package com.carrental.grammar.parserPolaKalimat;

import com.carrental.grammar.dataTypeHelper.DAttributes;
import com.carrental.grammar.dataTypeHelper.DVariables;
import com.carrental.grammar.dataTypeHelper.DVariablesWrapper;

import java.util.ArrayList;

import org.antlr.v4.tool.Attribute;
import org.codehaus.plexus.util.StringUtils;
import com.carrental.grammar.generatedclass.CarrentalnewBaseVisitor;
import com.carrental.grammar.generatedclass.CarrentalnewParser;
import com.carrental.grammar.generatedclass.CarrentalnewVisitor;
import com.carrental.grammar.generatedclass.CarrentalnewParser.DT_NOUNContext;
import com.carrental.grammar.generatedclass.CarrentalnewParser.Ifthenelse_1Context;
import com.carrental.grammar.generatedclass.CarrentalnewParser.Ifthenelse_2Context;
import com.carrental.grammar.generatedclass.CarrentalnewParser.NounContext;
import com.carrental.grammar.generatedclass.CarrentalnewParser.Obligasi_1Context;
import com.carrental.grammar.generatedclass.CarrentalnewParser.Pola_DT_1Context;
import com.carrental.grammar.generatedclass.CarrentalnewParser.Pola_DT_2Context;
import com.carrental.grammar.generatedclass.CarrentalnewParser.Pola_statement_1Context;
import com.carrental.grammar.generatedclass.CarrentalnewParser.Pola_statement_2Context;
import com.carrental.grammar.generatedclass.CarrentalnewParser.Pola_statement_3Context;
import com.carrental.grammar.generatedclass.CarrentalnewParser.Pola_statement_5Context;
import com.carrental.grammar.generatedclass.CarrentalnewParser.StatementContext;;
//SELALU ADA SPECIAL CASE DIMANA TERM BISA DIIKUTI OLEH KATA SIFAT.
//CONTOH: OPEN RENTAL --> RENTAL YANG MEMILIKI ATRIBUT OPEN, DAN NILAI ATRIBUT TERSEBUT TRUE
//SPECIAL TERM ADALAH TERM YANG MEMILIKI KATA SIFAT UNTUK MENERANGKAN NYA
public class MyCarrentalnewVisitor extends CarrentalnewBaseVisitor<String> {
	
	private String addressHelper;
	private String codeResult;
	private ArrayList<String>specialterm;
	private DVariablesWrapper variables;
	public MyCarrentalnewVisitor(DVariablesWrapper wrapper) {
		// TODO Auto-generated constructor stub
		addressHelper="";
		codeResult="";
		specialterm = new ArrayList<String>();
		variables = wrapper;
		addSpecialTerm("open rental");
		addSpecialTerm("renter");
	}
	//method helper untuk kelas ini
	//method untuk visit tree diletakan sesudah method helper
	
	public void addSpecialTerm(String term){
		specialterm.add(term);
	}
	
	private String handleSpecialterm(String term){
		//method ini digunakan untuk mentranslasikan special term menjadi kata/term/atribut yang dikenali oleh translator
		
		/*ver 2.0
		 *method ini mempunyai nilai kembalian berupa nama kelas/atribut dari special term tersebut */
		if(specialterm.contains(term)){
			if(term.equalsIgnoreCase("open rental")){
				int idx=variables.isClassExist("Rental");
				if(idx>=0){ //jika kelas dengan nama Rental ada
					variables.dvar.get(idx).setWriteToFile(true); 
					try{
						//open rental berarti nilai dari atribut open akan dibandingkan dengan true
						variables.dvar.get(idx).getAttributesByName("open").setCompareTo("true");
						variables.dvar.get(idx).getAttributesByName("open").setCompareType("==");
						variables.dvar.get(idx).getAttributesByName("open").setWriteToFile(true);
					}
					catch(Exception e){
						e.printStackTrace();
					}
					return "Rental";
				}
			}
			else if(term.equalsIgnoreCase("renter")){ //renter adalah driver
				int idx=variables.isClassExist("Driver");
				if(idx>=0){
					variables.dvar.get(idx).setWriteToFile(true);
					return "Driver";
				}
			}
		}
		return "null";
	}
	
	public String getCodeResult(){
		return codeResult;
	}
	
	public String getFieldName(String input){
		String result="";
		String[]temp = input.split(" ");
		if(temp.length>1){
			for(int i=0;i<temp.length;i++){
				if(i==0){
					result+=temp[i];
				}
				else{
					result+= temp[i].substring(0, 1).toUpperCase()+temp[i].substring(1);
				}
			}
			return result;
		}
		return input;
	}
	
	public String getClassName(String input){
		String result="";
		String[]temp = input.split(" ");
		if(temp.length>1){
			for(int i=0;i<temp.length;i++){
				result+= temp[i].substring(0, 1).toUpperCase()+temp[i].substring(1);
			}
			return result;
		}
		return input;
	}
	
	public String getDroolsVariableName(String input){
		String result="";
		String[]temp = input.split(" ");
		if(temp.length>1){
			for(int i=0;i<temp.length;i++){
				result+= temp[i];
			}
		}
		return result;
		
	}
	
	public void printStringResult(){
		System.out.println(codeResult);
	}
	
	public DVariablesWrapper getVariables(){
		return this.variables;
	}
	
	public void setVariables(DVariablesWrapper wrapper){
		this.variables = wrapper;
	}
	
	public void printWrapper(){
		
		for(int i=0;i<variables.dvar.size();i++){
			System.out.print(variables.dvar.get(i).className+"(");
			
			for(int j=0;j<variables.dvar.get(i).getAttributes().size();j++){
				DAttributes temp = variables.dvar.get(i).getAttributes().get(j);
				if(temp.getCompareTo().equalsIgnoreCase("none")){
					System.out.print(temp.getLabel()+":"+temp.getName());
				}
				else{
					System.out.print(temp.getName()+temp.getCompareType()+temp.getCompareTo());
				}
				
				if(j<variables.dvar.get(i).getAttributes().size()-1){
					System.out.print(",");
				}
			}
			
			System.out.println(")");
		}
		/*
		System.out.print(variables.dvar.get(idx).className+"(");
		for(int i=0;i<variables.dvar.get(idx).getAttributes().size();i++){
			DAttributes temp = variables.dvar.get(idx).getAttributes().get(i);
			if(temp.getCompareTo().equalsIgnoreCase("none")){
				System.out.print(temp.getLabel()+":"+temp.getName());
			}
			else{
				System.out.print(temp.getName()+"=="+temp.getCompareTo());
			}
			
			if(i<variables.dvar.get(idx).getAttributes().size()-1){
				System.out.print(",");
			}
		}
		System.out.print(")");*/
	}
	//-----------------------------------------end helper-----------------------------------------------------------------------
	
	@Override
	public String visitNoun(NounContext ctx) {
		// TODO Auto-generated method stub
		return ctx.getText().toString();
	}
	
	@Override
	public String visitObligasi_1(Obligasi_1Context ctx) {
		// TODO Auto-generated method stub
		
		codeResult="";
		//System.out.println(ctx.modalobligasi().getText());
		
		if(ctx.modalobligasi().getText().toString().equalsIgnoreCase("it is obligatory that")){
			//when negasi dari statement bernilai true, extract statement tersebut dari memori
			codeResult+="when\n not";
			addressHelper="OBLIGATION";
		}
		else if (ctx.modalobligasi().getText().toString()=="it is prohibited that"){
			
		}
		else if (ctx.modalobligasi().getText().toString()=="it is impossible that"){
			
		}
		return super.visitObligasi_1(ctx);
		//return codeResult;
	}
	
	@Override
	public String visitIfthenelse_1(Ifthenelse_1Context ctx) {
		
		return super.visitIfthenelse_1(ctx);
	}
	
	@Override
	public String visitIfthenelse_2(Ifthenelse_2Context ctx) {
		// TODO Auto-generated method stub
		
		
		return super.visitIfthenelse_2(ctx);
		
	}
	
	
	
	@Override
	public String visitPola_statement_1(Pola_statement_1Context ctx) {
		// ex: it is obligatory that each operating company has at least one insurer
		String c_0=visitTerm(ctx.term(0));
		String c_1=visitTerm(ctx.term(1));
		if(ctx.verb().getText().toString().equalsIgnoreCase("has")){
			//noun1 has noun2
			if(ctx.quantification(1).getText().toString().equalsIgnoreCase("at least one")){
				//noun1 has at least one noun2 --> noun1 memiliki atribut noun2, dan size dari noun2 >=1
				System.out.println("c_0: "+c_0);
				System.out.println("c_1: "+c_1);
				String c_0_className = getClassName(c_0);
				String c_1_attrName = getFieldName(c_1);
				if(variables.getClassByName(c_0_className).getAttributesByName(c_1).getType().equalsIgnoreCase("arraylist")){
					variables.getClassByName(c_0_className).getAttributesByName(c_1).setCompareTo("1");
					variables.getClassByName(c_0_className).getAttributesByName(c_1).setCompareType(">=");
					variables.getClassByName(c_0_className).getAttributesByName(c_1).setName(c_1+".size");
				}
				else{
					variables.getClassByName(c_0_className).getAttributesByName(c_1).setCompareTo("1");
					variables.getClassByName(c_0_className).getAttributesByName(c_1).setCompareType(">=");
				}	
			}
			else if(ctx.quantification(1).getText().toString().equalsIgnoreCase("<inser another quantification>")){
				
			}
		}
		else if(ctx.verb().getText().toString().equalsIgnoreCase("of")){
			
		}
		return super.visitPola_statement_1(ctx);
	}
	
	@Override
	public String visitPola_statement_2(Pola_statement_2Context ctx) {
		
		String c_0=visitTerm(ctx.term(0));
		String c_1=visitTerm(ctx.term(1));
		
		if(ctx.verb().getText().toString().equalsIgnoreCase("provisionally charged to")){
			//c_0, dalam hal ini adalah rental, memiliki atribut c_1(credit card)
			//
			
			//System.out.println("checkpoint1 "+c_0);
			//System.out.println("checkpoint2 "+c_1);
			
			for(int i=0;i<variables.getClassByName(c_0).getAttributesByType(c_1).size();i++){
				String compareToLabel = variables.getClassByName(c_1).getLabel();
				variables.getClassByName(c_0).getAttributesByType(c_1).get(i).setCompareTo(compareToLabel);
				variables.getClassByName(c_0).getAttributesByType(c_1).get(i).setCompareType("==");
			}
		}
		
		else if(ctx.verb().getText().toString().equalsIgnoreCase("<another verb concept>")){
			
		}
		
		return super.visitPola_statement_2(ctx);
		//return "testing_return";
	}
	
	@Override
	public String visitPola_statement_3(Pola_statement_3Context ctx) {
		// TODO Auto-generated method stub
		//System.out.println("checkpoint_lalal"+ctx.verb(0).getText().toString());
		return super.visitPola_statement_3(ctx);
	}
	
	@Override
	public String visitPola_statement_5(Pola_statement_5Context ctx) {
		// TODO Auto-generated method stub
		System.out.println("checkpoint_1  "+ctx.term().size());
		return super.visitPola_statement_5(ctx);
	}
	
	@Override
	public String visitPola_DT_1(Pola_DT_1Context ctx) {
		// TODO Auto-generated method stub
		
		/*
		if(ctx.verb().getText().toString().equalsIgnoreCase("of")){
			//term0 of term1, artinya term0 adalah atribut dari term1
			String term0 = ctx.noun(0).getText().toString();
			String term1 = ctx.noun(1).getText().toString();
			
			if(specialterm.contains(term1)){
				int tempIdx=handleSpecialterm(term1)-1;
				variables.dvar.get(tempIdx).attributes.add(new DAttributes(getFieldName(term0), getFieldName(term0)));
			}
			else{
				int tempIdx = variables.isClassExist(term1);
				if(tempIdx==-1){
					DVariables temp = new DVariables(getClassName(term1), getFieldName(term1));
					temp.attributes.add(new DAttributes(getFieldName(term0), getFieldName(term0)));
					variables.dvar.add(temp);
				}
				else{
					variables.dvar.get(tempIdx).attributes.add(new DAttributes(getFieldName(term0), getFieldName(term0)));
				}
			}
		}
		else if(ctx.verb().getText().toString().equalsIgnoreCase("has")){
			//term0 has term1 artinya term1 adalah atribut dari term0
			String term0 = ctx.noun(0).getText().toString();
			String term1 = ctx.noun(1).getText().toString();
			if(specialterm.contains(term0)){
				handleSpecialterm(term0);
			}
			else{
				int tempIdx = variables.isClassExist(term0);
				if(tempIdx==-1){
					DVariables temp = new DVariables(getClassName(term0),"");
					temp.attributes.add(new DAttributes(getFieldName(term1), getFieldName(term1)));
					variables.dvar.add(temp);
				}
				else{
					variables.dvar.get(tempIdx).attributes.add(new DAttributes(getFieldName(term1), getFieldName(term1)));
				}
			}
			
		}
		else if(ctx.verb().getText().toString().equalsIgnoreCase("for")){
			String term0 = ctx.noun(0).getText().toString();
			String term1 = ctx.noun(1).getText().toString();
			
			
			
		}*/
		
		
		/*----------------------------------------------------------------------------------------------------------------------------*/
		/*kode di bawah ini akan memanfaatkan atribut writeToFile yang dimiliki oleh Sattrbutes*/
		if(ctx.verb().getText().toString().equalsIgnoreCase("of")){
			String term0=ctx.noun(0).getText().toString();
			String term1=ctx.noun(1).getText().toString();
			String cls="";
			if(specialterm.contains(term1)){
				cls=handleSpecialterm(term1);
				String atrName="";
				int idx=variables.isClassExist(cls);
				//asumsi idx selalu bernilai >=0
				if(specialterm.contains(term0)){
					atrName=handleSpecialterm(term0);
					
				}
				else{
					atrName=getFieldName(term0);
				}
				variables.dvar.get(idx).getAttributesByName(atrName).setWriteToFile(true);
			}
			else{
				cls=handleSpecialterm(term1);
				String atrName=getFieldName(term0);
				int idx=variables.isClassExist(cls);
				variables.dvar.get(idx).setWriteToFile(true);
				variables.dvar.get(idx).getAttributesByName(atrName).setWriteToFile(true);
			}
			if(specialterm.contains(term0)){
				handleSpecialterm(term0);
			}
			else{
				
			}
			
			//if(variables.isClassExist(getClassName(input)))
			return getClassName(cls);
		}
		else if(ctx.verb().getText().toString().equalsIgnoreCase("has")){
			
		}
		
		return super.visitPola_DT_1(ctx);
	}
	private int angka=0;
	@Override
	public String visitPola_DT_2(Pola_DT_2Context ctx) {
		// TODO Auto-generated method stub
		//baca kalimat dari depan ke belakang
		
		if(ctx.verb().getText().toString().equalsIgnoreCase("responsible for")){
			//credit card that is in the name of the 
			//renter who is responsible for the rental
			String keyword=ctx.keyword().getText().toString();
			String identifier=ctx.identifier().getText().toString();
			String term_0_converted="";
			String term_1_converted="";
			//handle kata benda sebelum "who"
			if(keyword.equalsIgnoreCase("who")){
				//kata di belakang "who" sudah pasti kata benda (NOUN)
				if(identifier.equalsIgnoreCase("is")){
					String term_0=ctx.dt(0).getChild(ctx.dt(0).getChildCount()-1).getText().toString();
					if(specialterm.contains(term_0)){
						term_0_converted=handleSpecialterm(term_0);
					}
					else{
						term_0_converted=getClassName(term_0);
					}
					
				}
				else{
					
				}
			}
			//handle kata benda sesudah "responsible for"
			String term_1=ctx.dt(1).getChild(ctx.dt(1).getChildCount()-1).getText().toString();
			if(specialterm.contains(term_1)){
				term_1_converted=handleSpecialterm(term_1);
			}
			else{
				
			}
			
			for(int i=0;i<ctx.dt().size();i++){
				System.out.println(ctx.dt(i).getText().toString());
				
			}
		}
		else if(ctx.verb().getText().toString().equalsIgnoreCase("in the name of")){
			System.out.println("CHK_2");
			for(int i=0;i<ctx.dt().size();i++){
				System.out.println(ctx.dt(i).getText().toString());
			}
		}
		return super.visitPola_DT_2(ctx);
		//return getClassName(term0);
	}
	
	@Override
	public String visitDT_NOUN(DT_NOUNContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("CHK_3");
		return ctx.getText().toString();
	}
	
}
