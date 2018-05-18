package com.carrental.grammar.dataTypeHelper;

import java.util.ArrayList;

public class DVariablesWrapper {
	public ArrayList<DVariables> dvar;
	public DVariablesWrapper(){
		dvar = new ArrayList<DVariables>();
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
	
}
