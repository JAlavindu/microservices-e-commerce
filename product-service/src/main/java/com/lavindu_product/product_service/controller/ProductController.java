package com.lavindu_product.product_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lavindu_product.product_service.DTO.ProductRequestDto;
import com.lavindu_product.product_service.DTO.ProductResponseDto;
import com.lavindu_product.product_service.Entity.Product;
import com.lavindu_product.product_service.repository.ProductRepository;
import com.lavindu_product.product_service.service.ProductService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }
    
    @GetMapping("hello")
    public String hello() {
        return "hello";
    }
    
    @PostMapping("createProduct")
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto product) {
        ProductResponseDto savedProd = productService.saveProduct(product);
        return new ResponseEntity<>(savedProd, HttpStatus.OK);
    }
    
    @GetMapping("getProducts")
    public ResponseEntity<List<ProductResponseDto>> getProducts() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }
    
}
