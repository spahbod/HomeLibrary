package com.pl.home.library.controllers;

import com.pl.home.library.entities.Product;
import com.pl.home.library.repositories.ProductRepository;
import org.ocpsoft.rewrite.annotation.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.SessionScoped;
import java.util.List;

@SessionScoped
@Component(value = "productList")
@Join(path = "/", to = "/views/product-list.jsf")
public class ProductListController {
	@Autowired
	private ProductRepository productRepository;

	public List<Product> getProducts() {
		return productRepository.findAll();
	}
}
