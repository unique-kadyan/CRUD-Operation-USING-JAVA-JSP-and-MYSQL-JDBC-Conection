package com.db.User;


public class User {

	private int idusers;
	private String name;
	private String email;
	private String mob;
	
	
	public User(int idusers, String name, String email, String mob) {
		super();
		this.idusers = idusers;
		this.name = name;
		this.mob = mob;
		this.email = email;
	}
	
	public User(String name,String email, String mob) {
		super();
		this.name = name;
		this.mob = mob;
		this.email = email;
	}
	public User(int id)
	{
		this.idusers = id;
	}
	public int getIdusers() {
		return idusers;
	}
	public void setIdusers(int idusers) {
		this.idusers = idusers;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
