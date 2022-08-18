package com.gianni.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return ("<h1>Welcome Home</h1>");
	}
	@GetMapping("/user")
	@PreAuthorize("hasAnyAuthority('ROLE_admin', 'ROLE_user')")
	public String user() {
		return ("<h1>Welcome User</h1>");
	}
	@GetMapping("/admin")
	@PreAuthorize("hasAuthority('ROLE_admin')")
	public String admin() {
		return ("<h1>Welcome Admin</h1>");
	}
	
}
