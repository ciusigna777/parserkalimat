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
import com.carrental.grammar.generatedclass.CarrentalnewParser.Ifthenelse_1Context;
import com.carrental.grammar.generatedclass.CarrentalnewParser.Ifthenelse_2Context;
import com.carrental.grammar.generatedclass.CarrentalnewParser.NounContext;
import com.carrental.grammar.generatedclass.CarrentalnewParser.Obligasi_1Context;
import com.carrental.grammar.generatedclass.CarrentalnewParser.Pola_DT_1Context;
import com.carrental.grammar.generatedclass.CarrentalnewParser.Pola_DT_2Context;
import com.carrental.grammar.generatedclass.CarrentalnewParser.Pola_DT_3Context;
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
		
		//return super.visitPola_statement_2(ctx);
		return "testing_return";
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
	
	@Override
	public String visitPola_DT_2(Pola_DT_2Context ctx) {
		// TODO Auto-generated method stub
		
		//baca kalimat dari depan ke belakang
		String term0=ctx.noun(0).getText().toString(); // credit card
		String term1=ctx.noun(1).getText().toString(); // renter(driver)
		String term2=ctx.noun(2).getText().toString(); // rental
		
		if(ctx.verb(0).getText().toString().equalsIgnoreCase("in the name of")){
			// noun_1 is in the name of noun_2: noun_1 dan noun_2 memiliki atribut name, dan noun_1.name==noun_2.name 
			String term_0_convertedName="";
			String term_1_convertedName="";
			if(specialterm.contains(term0)){
				term_0_convertedName=handleSpecialterm(term0);
			}
			else{
				term_0_convertedName=getClassName(term0);
			}
			if(specialterm.contains(term1)){
				term_1_convertedName=handleSpecialterm(term1);
			}
			else{
				term_1_convertedName=getClassName(term1);
			}
			DVariables temp = variables.getClassByName(term_1_convertedName);
			variables.getClassByName(term_0_convertedName).getAttributesByName("name").setCompareTo(temp.getAttributesByName("name").getLabel());
			variables.getClassByName(term_0_convertedName).getAttributesByName("name").setCompareType("==");
		}
		else if(ctx.verb(0).getText().toString().equalsIgnoreCase("<insert another verb concept>")){
			
		}
		
		if(ctx.verb(1).getText().toString().equalsIgnoreCase("responsible for")){
			// noun1 is responsible for noun2 --> noun1 adalah atribut dari noun2. noun2 akan menyimpan noun1 dalam sebuah
			// variabel yang kemudian akan dibandingkan dengan representasi noun1 yang lain
			String atrName="";
			String clsName="";
			if(specialterm.contains(term2)){ //if rental is special term (NO)
				clsName=handleSpecialterm(term2);
			}
			else{
				clsName=getClassName(term2);

			}
			if(specialterm.contains(term1)){ //if renter is special term (YES)
				atrName=handleSpecialterm(term1);
			}
			else{
				atrName=getFieldName(term1);
			}
			
			
			int idx=variables.isClassExist(clsName); //Rental
			variables.dvar.get(idx).setWriteToFile(true);
			variables.dvar.get(idx).getAttributesByName(atrName).setWriteToFile(true);
			int idx2=variables.isClassExist(atrName);
			
			variables.dvar.get(idx).getAttributesByName(atrName).setCompareTo(variables.dvar.get(idx2).getLabel());
			variables.dvar.get(idx).getAttributesByName(atrName).setCompareType("==");
			
		}
		else if(ctx.verb(1).getText().toString().equalsIgnoreCase("<insert another verb>")){
			
		}
		
		
		
		//return super.visitPola_DT_2(ctx);
		return getClassName(term0);
	}
	
	@Override
	public String visitPola_DT_3(Pola_DT_3Context ctx) {
		// TODO Auto-generated method stub
		//N0 K i V N1
		String term_0=ctx.noun(0).getText().toString();
		String term_1=ctx.noun(1).getText().toString();
		String term_0_convertedName="";
		String term_1_convertedName="";
		if(ctx.verb().getText().toString().equals("responsible for")){
			/*
			System.out.println("chk1"+term_0);
			System.out.println("chk2"+term_1);
			*/
			if(specialterm.contains(term_0)){
				term_0_convertedName = handleSpecialterm(term_0);
			}
			else{
				term_0_convertedName = getClassName(term_0);
			}
			if(specialterm.contains(term_1)){
				term_1_convertedName = handleSpecialterm(term_1);
			}
			else{
				term_1_convertedName = getClassName(term_1);
			}
			variables.getClassByName(term_1_convertedName).getAttributesByName(term_0_convertedName).setCompareTo(
					variables.getClassByName(term_0_convertedName).getLabel());
		}
		else if(ctx.verb().getText().toString().equals("<another verb concept>")){
			
		}
		
		
		return super.visitPola_DT_3(ctx);
	}
	
	
}
