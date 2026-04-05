package com.lavindu_product.product_service.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lavindu_product.product_service.Entity.Product;
import com.lavindu_product.product_service.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository prodRepo;

    public ProductService(ProductRepository prodRepo){
        this.prodRepo = prodRepo;
    }

    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = prodRepo.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    
}
