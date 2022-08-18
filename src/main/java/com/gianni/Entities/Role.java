package com.gianni.Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Role")
public class Role {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="roleId")
	private int roleId;
	@Column(name="roleType")
	private String roleType;
	
	@ManyToMany(mappedBy = "roles")
	@JsonIgnore
	private Set <User> users = new HashSet<User>();

	public Role()
	{
		
	}
	public Role(String roleType)
	{
		this.roleType = roleType;
	}
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}
