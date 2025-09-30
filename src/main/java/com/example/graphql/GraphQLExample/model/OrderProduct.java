package com.example.graphql.GraphQLExample.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@Entity
@Table(name = "order_product")
@AllArgsConstructor
@NoArgsConstructor
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalProductPrice;
    @ManyToOne
    private Order order;
    @ManyToOne
    private Product product;
}
