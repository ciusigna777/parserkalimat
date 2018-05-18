package com.carrental.grammar.dataTypeHelper;

import java.util.ArrayList;

public class DVariables {
	public String className; //ex: Driver, Rental, berhubungan dengan nama entitas 
	public String label; //ex: $rental, $driver, $r, $c, $cc, etc
	public ArrayList<DAttributes> attributes;
	public boolean writeToFile;
	
	public DVariables(){
		this.writeToFile=false;
		label=" ";
	}
	public DVariables(String className) {
		super();
		this.className = className;
		this.label = "$"+className;
		this.attributes = new ArrayList<DAttributes>();
		this.writeToFile=false;
	}
	public DVariables(Object o){
		this.attributes = new ArrayList<DAttributes>();
		this.writeToFile=false;
		generateFromClass(o);
		
	}
	
	public int isAttributeExist(String attributeName){
		for(int i=0;i<attributes.size();i++){
			if(attributes.get(i).getName().equalsIgnoreCase(attributeName)){
				return i;
			}
		}
		return -1;
	}
	
	public DAttributes getAttributesByName(String name){
		DAttributes result;
		for(int i=0;i<attributes.size();i++){
			if(attributes.get(i).getName().equalsIgnoreCase(name)){
				result=attributes.get(i);
				return result;
			}
		}
		return null;
	}
	
	public ArrayList<DAttributes> getAttributesByType(String type){
		ArrayList<DAttributes>result = new ArrayList<DAttributes>();
		for(int i=0;i<attributes.size();i++){
			if(attributes.get(i).getType().equalsIgnoreCase(type)){
				result.add(attributes.get(i));
			}
		}
		return result;
	}
	
	public int getAttribByName(String name){
		for(int i=0;i<attributes.size();i++){
			System.out.println(attributes.get(i).getName()+ "      "+name);
			if(attributes.get(i).getName().equalsIgnoreCase(name)){
				return i;
			}
		}
		return -1;
	}
	
	public void generateFromClass(Object o){
		//System.out.println(o.getClass().getSimpleName());
		this.className = o.getClass().getSimpleName();
		this.label = "$"+o.getClass().getSimpleName().toLowerCase();
		for(int i=0;i<o.getClass().getDeclaredFields().length;i++){
			String tempLabel = o.getClass().getSimpleName().toLowerCase()+o.getClass().getDeclaredFields()[i].getName();
			DAttributes temp = new DAttributes(o.getClass().getDeclaredFields()[i].getName(),o.getClass().getDeclaredFields()[i].getType().getSimpleName(),tempLabel);
			this.attributes.add(temp);
			/*
			System.out.println("attr name: "+o.getClass().getDeclaredFields()[i].getName());
			System.out.println("attr type: "+o.getClass().getDeclaredFields()[i].getType().getSimpleName());*/
		}
		
		
	}
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getVariableName() {
		return label;
	}
	public void setVariableName(String label) {
		this.label = "$"+label;
	}
	public ArrayList<DAttributes> getAttributes() {
		return attributes;
	}
	public void setAttributes(ArrayList<DAttributes> attributes) {
		this.attributes = attributes;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public boolean isWriteToFile() {
		return writeToFile;
	}
	public void setWriteToFile(boolean writeToFile) {
		this.writeToFile = writeToFile;
	}
	
	
}
