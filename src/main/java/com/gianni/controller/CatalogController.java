package com.gianni.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gianni.Service.ProductServices;
import com.gianni.Entities.Product;
@RestController
public class CatalogController {
	
	@Autowired
	private ProductServices prodService;
	
	@GetMapping("/catalog")
	@PreAuthorize("hasAnyAuthority('ROLE_admin', 'ROLE_user')")
	public List<Product> catalog() {
		return prodService.getAllProducts();
	}
	
	@GetMapping("/catalog/{id}")
	@PreAuthorize("hasAnyAuthority('ROLE_admin', 'ROLE_user')")
	public Optional<Product> getProdId(@PathVariable int id)
	{
		Optional<Product> product = prodService.getProductById(id);
		return prodService.getProductById(id);
	}
	
	@PostMapping("/edit-catalog")
	@PreAuthorize("hasAuthority('ROLE_admin')")
	public void addEmp(@RequestBody Product prod)
	{
		prodService.addProduct(prod);
	}
	
	@DeleteMapping("/edit-catalog/{id}")
	@PreAuthorize("hasAuthority('ROLE_admin')")
	public void deleteProduct(@PathVariable int id)
	{
		prodService.deleteProduct(id);
	}

}
