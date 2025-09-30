package com.example.graphql.GraphQLExample.service;

import com.example.graphql.GraphQLExample.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);

    List<ProductDto> getProducts();
}
