package com.home.practice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Role")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	@Column
	String newRole;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getnewRole() {
		return newRole;
	}
	public void setnewRole(String newRole) {
		this.newRole = newRole;
	}

}
