package com.gianni.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gianni.Entities.Product;
import com.gianni.Repo.ProductRepository;

@Service
public class ProductServices {
	
	@Autowired
	ProductRepository prod;
	
	public List<Product> getAllProducts(){
		return prod.findAll();
	}
	public Optional<Product> getProductById(int id)
	{
		return prod.findById(id);
	}
	public void deleteProduct(Integer id) {
		prod.deleteById(id);
	}
	public void addProduct(Product product)
	{
		prod.save(product);
	}

}
