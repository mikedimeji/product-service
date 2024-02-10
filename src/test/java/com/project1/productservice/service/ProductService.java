package com.project1.productservice.service;

import com.project1.productservice.dto.ProductRequest;
import com.project1.productservice.dto.ProductResponse;
import com.project1.productservice.model.product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.project1.productservice.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        product Product = product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(Product);
        log.info("Product" + Product.getId() + "is saved");
    }

    public List<ProductResponse> getAllProducts(){
        List<product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).collect(Collectors.toList());
    }

    public ProductResponse mapToProductResponse(product Product) {
        return ProductResponse.builder()
                .id(Product.getId())
                .name(Product.getName())
                .description(Product.getDescription())
                .price(Product.getPrice())
                .build();
    }
}
