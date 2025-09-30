package com.example.graphql.GraphQLExample.controller;

import com.example.graphql.GraphQLExample.dto.ProductDto;
import com.example.graphql.GraphQLExample.service.ProductService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @MutationMapping
    public ProductDto createProduct(@Argument ProductDto product) {
        return productService.createProduct(product);
    }
}
