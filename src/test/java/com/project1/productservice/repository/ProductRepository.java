package com.project1.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.project1.productservice.model.product;

public interface ProductRepository extends MongoRepository<product, String> {
}
