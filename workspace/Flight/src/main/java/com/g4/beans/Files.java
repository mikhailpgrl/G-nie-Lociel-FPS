package com.g4.beans;

public class Files {
	
	private String name;
	private String file;
	private String content;
	
	public Files(){
		
	}

	public void print(){
		System.out.println(name);
		System.out.println(file);
	}
	
	public String getName() {
		return name;
	}

	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
