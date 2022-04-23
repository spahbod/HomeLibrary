package com.pl.home.library.controllers;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.pl.home.library.entities.Product;
import com.pl.home.library.repositories.ProductRepository;

@Scope(value = "session")
@Component(value = "productController")
@ELBeanName(value = "productController")
@Join(path = "/product", to = "/views/product-form.jsf")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    private Product product = new Product();

    public String save() {
        productRepository.save(product);
        product = new Product();
        return "/views/product-list.xhtml?faces-redirect=true";
    }

    public Product getProduct() {
        return product;
    }
}
