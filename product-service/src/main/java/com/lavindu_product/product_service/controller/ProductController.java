package com.lavindu_product.product_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("product")
public class ProductController {
    
    @GetMapping("hello")
    public String hello() {
        return "hello";
    }
    
}
