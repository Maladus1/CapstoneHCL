package com.gianni.Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="User")
public class User {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false, name="userId")
	private int userId;
	@Column(nullable = false, name="username")
	private String username;
	@Column(nullable = false, name="password")
	private String password;
	@Column(nullable = false, name="email")
	private String email; 
	
	@ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	   @JoinTable(name="user_roles",
	               joinColumns={@JoinColumn(name="user_id")},
	               inverseJoinColumns={@JoinColumn(name="role_id")})
	private Set<Role> roles = new HashSet<Role>();
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	
}
