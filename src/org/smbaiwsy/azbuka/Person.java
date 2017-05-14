package org.smbaiwsy.azbuka;

public class Person {
	private String id;
	private String name;
	private String surname;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public Person(String id, String surname, String name){
		this.id = id;
		this.surname = surname;
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s %s", surname,name);
	}

}
