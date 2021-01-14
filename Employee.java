package com.revature.day03.employee;
import java.io.*;

class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int id;
	private static int idCounter = 0;
	private String role = "New Employee";
	
	public Employee(String name, String role) {
		super();
		this.name = name;
		this.id = idCounter++;
		this.role = role;
	}

	public Employee(String name) {
		super();
		this.name = name;
		this.id = idCounter++;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", role=" + role + "]";
	}
}