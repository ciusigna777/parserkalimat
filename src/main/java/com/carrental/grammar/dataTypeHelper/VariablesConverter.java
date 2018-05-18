package com.carrental.grammar.dataTypeHelper;

public class VariablesConverter {
	private static final VariablesConverter instance=new VariablesConverter();
	
	public static VariablesConverter getInstance(){
		return instance;
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
}
