package com.carrental.grammar.dataTypeHelper;

import java.util.ArrayList;

public class DVariablesWrapper {
	public ArrayList<DVariables> dvar;
	public String modality;
	public DVariablesWrapper(){
		dvar = new ArrayList<DVariables>();
		modality="";
	}
	public int isClassExist(String clsName){
		for(int i=0;i<dvar.size();i++){
			if(dvar.get(i).getClassName().toString().equalsIgnoreCase(clsName)){
				return i;
			}
		}
		return -1;
	}
	public DVariables getClassByName(String className){
		DVariables temp=null;
		for(int i=0;i<dvar.size();i++){
			if(dvar.get(i).getClassName().equalsIgnoreCase(className)){
				return dvar.get(i);
			}
		}
		return temp;
	}
	
	public int isVariableNameExist(String varName){
		for(int i=0;i<dvar.size();i++){
			if(dvar.get(i).getVariableName().toString().equals(varName)){
				return i;
			}
		}
		return -1;
	}
	
	public void printAllVariables(){
		for(int i=0;i<dvar.size();i++){
			System.out.println("Class Name: "+dvar.get(i).className);
			System.out.println("Class Label: "+dvar.get(i).label);
			System.out.println("Attributes to be written: ");
			for(int j=0;j<dvar.get(i).attributes.size();j++){
				System.out.println("AttrName: "+dvar.get(i).attributes.get(j).getName()+"; AttrLbl: "+dvar.get(i).attributes.get(j).getLabel()+"; Cmpr: "+dvar.get(i).attributes.get(j).getCompareTo());		
			}
			System.out.println("============================================================================================");
		}
	}
	
	public void writeToDRL(String ruleName){
		System.out.println("rule "+ruleName);
		System.out.println("when");
		System.out.println("end");
		
	}
	
	public void getWhenStatementBasedOnModality(){
		if(this.modality.equalsIgnoreCase("obligation")){
			for(int i=0;i<dvar.size();i++){
				for(int j=0;j<dvar.get(i).attributes.size();j++){
					if(!dvar.get(i).attributes.get(j).getCompareTo().equalsIgnoreCase("none")){
						DAttributes temp = dvar.get(i).attributes.get(j);
						
						if(temp.getCompareType().equalsIgnoreCase("==")){
							System.out.println(temp.getName()+"!="+temp.getCompareTo());
						}
						else if(temp.getCompareType().equalsIgnoreCase(">")){
							
						}
						
					}
				}
			}
		}
		else if(this.modality.equalsIgnoreCase("non-obligation")){
			
		}
		else if(this.modality.equalsIgnoreCase("possibility")){
			
		}
		else if(this.modality.equalsIgnoreCase("non-possibility")){
			
		}
	}
	public String getModality() {
		return modality;
	}
	public void setModality(String modality) {
		this.modality = modality;
	}
	
	
	
}
