package com.example.graphql.GraphQLExample.dto;

import java.math.BigDecimal;

public record OrderProductDto(
        Long id, Long productId, String productName, BigDecimal unitPrice,
        BigDecimal totalProductPrice, Integer quantity) {
}
