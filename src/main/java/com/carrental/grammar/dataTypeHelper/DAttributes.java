package com.carrental.grammar.dataTypeHelper;

import java.util.ArrayList;

public class DAttributes {
	private String name;
	private String label;
	private String type;
	private boolean writeToFile;
	private String compareTo;
	private String compareType;
	private ArrayList<String>getterSetterMethod;
	public DAttributes(){
		writeToFile=false;
		compareTo="none";
		getterSetterMethod = new ArrayList<String>();
	}
	
	public DAttributes(String name){
		this.name=name;
		//this.label="$"+name;
		writeToFile=false;
		compareTo="none";
		getterSetterMethod = new ArrayList<String>();
	}
	
	public String getCompareType() {
		return compareType;
	}

	public void setCompareType(String compareType) {
		this.compareType = compareType;
	}

	public DAttributes(String name,String type){
		this.name=name;
		//this.label="$"+name;
		this.type = type;
		writeToFile=false;
		compareTo="none";
		getterSetterMethod = new ArrayList<String>();
	}
	public DAttributes(String name,String type,String label){
		this.name=name;
		this.type=type;
		this.label="$"+label;
		compareTo="none";
		getterSetterMethod = new ArrayList<String>();
	}
	
	public void printMethodName(){
		for(int i=0;i<getterSetterMethod.size();i++){
			System.out.println(getterSetterMethod.get(i).toString());
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = "$"+label;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isWriteToFile() {
		return writeToFile;
	}
	public void setWriteToFile(boolean writeToFile) {
		this.writeToFile = writeToFile;
	}
	public String getCompareTo() {
		return compareTo;
	}
	public void setCompareTo(String compareTo) {
		this.compareTo = compareTo;
	}

	public ArrayList<String> getGetterSetterMethod() {
		return getterSetterMethod;
	}

	public void setGetterSetterMethod(ArrayList<String> getterSetterMethod) {
		this.getterSetterMethod = getterSetterMethod;
	}
	
	
	
	
}
