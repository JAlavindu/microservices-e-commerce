package com.lavindu_product.product_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lavindu_product.product_service.DTO.ProductRequestDto;
import com.lavindu_product.product_service.DTO.ProductResponseDto;
import com.lavindu_product.product_service.Entity.Product;
import com.lavindu_product.product_service.mapper.ProductMapper;
import com.lavindu_product.product_service.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository prodRepo;
    private final ProductMapper prodMapper;

    public ProductService(ProductRepository prodRepo, ProductMapper prodMapper){
        this.prodRepo = prodRepo;
        this.prodMapper = prodMapper;
    }

    public List<ProductResponseDto> getProducts() {
        return prodMapper.toResponseDtoList(prodRepo.findAll());
    }

    public ProductResponseDto saveProduct(ProductRequestDto productRequestDto) {
        Product product = prodMapper.toEntity(productRequestDto);
        Product savedProd = prodRepo.save(product);
        return prodMapper.toResponseDto(savedProd);
    }

    public ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto) {
        Product existingProd = prodRepo.findById(id).orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Product not found for id: " + id));

        prodMapper.updateEntityFromDto(productRequestDto, existingProd);
        Product updated = prodRepo.save(existingProd);
        return prodMapper.toResponseDto(updated);
        
    }
    
}
