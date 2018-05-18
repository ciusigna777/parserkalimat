package com.carrental.grammar.dataTypeHelper;

public class DAttributes {
	private String name;
	private String label;
	private String type;
	private boolean writeToFile;
	private String compareTo;
	private String compareType;
	public DAttributes(){
		writeToFile=false;
		compareTo="none";
	}
	
	public DAttributes(String name){
		this.name=name;
		//this.label="$"+name;
		writeToFile=false;
		compareTo="none";
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
	}
	public DAttributes(String name,String type,String label){
		this.name=name;
		this.type=type;
		this.label="$"+label;
		compareTo="none";
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
	
	
	
}
