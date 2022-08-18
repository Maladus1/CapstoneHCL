package com.gianni.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gianni.Entities.Role;
import com.gianni.Entities.User;
import com.gianni.Repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public void assignRoletoUser(User u, String roleType)
	{
		Role r = new Role(roleType);
		u.getRoles().add(r);
		repo.save(u);
	}
	public void addUser(User u)
	{
		System.out.println(u.getEmail());
		repo.save(u);
	}
}
