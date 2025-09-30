package com.example.graphql.GraphQLExample.service;

import com.example.graphql.GraphQLExample.dto.ProductDto;
import com.example.graphql.GraphQLExample.model.Product;
import com.example.graphql.GraphQLExample.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        var product = Product.builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .build();
        product = productRepository.save(product);
        productDto.setId(product.getId());
        return productDto;
    }

    @Override
    public List<ProductDto> getProducts() {
        return productRepository.findAll().stream().map(product ->
                ProductDto.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .build()
        ).toList();
    }


}
