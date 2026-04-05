package com.lavindu_product.product_service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.lavindu_product.product_service.DTO.ProductRequestDto;
import com.lavindu_product.product_service.DTO.ProductResponseDto;
import com.lavindu_product.product_service.Entity.Product;

@Component
public class ProductMapper {
    
    public Product toEntity(ProductRequestDto dto){
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setSkuCode(dto.getSkuCode());
        return product;
    }

    public ProductResponseDto toResponseDto(Product product){
        return ProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .skuCode(product.getSkuCode())
                .build();
    }

    public List<ProductResponseDto> toResponseDtoList(List<Product> products) {
        return products.stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    public void updateEntityFromDto(ProductRequestDto dto, Product product) {
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setSkuCode(dto.getSkuCode());
    }
}
