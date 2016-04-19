package com.g4.beans;

public class Files {
	
	private String name;
	private String file;
	
	public Files(){
		
	}

	public void print(){
		System.out.println(name);
		System.out.println(file);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	
}
