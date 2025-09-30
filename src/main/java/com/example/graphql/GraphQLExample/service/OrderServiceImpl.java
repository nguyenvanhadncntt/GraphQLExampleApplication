package com.example.graphql.GraphQLExample.service;

import com.example.graphql.GraphQLExample.dto.OrderDto;
import com.example.graphql.GraphQLExample.model.Customer;
import com.example.graphql.GraphQLExample.model.OrderProduct;
import com.example.graphql.GraphQLExample.model.Product;
import com.example.graphql.GraphQLExample.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDto placeOrder(OrderDto orderDto) {

        var order = com.example.graphql.GraphQLExample.model.Order.builder()
                .customer(Customer.builder().id(orderDto.getCustomerId()).build())
                .orderDate(LocalDateTime.now())
                .build();


        var orderProducts = orderDto.getOrderProducts().stream().map(orderProductDto ->
                OrderProduct.builder()
                        .product(Product.builder().id(orderProductDto.productId()).build())
                        .quantity(orderProductDto.quantity())
                        .unitPrice(orderProductDto.unitPrice())
                        .totalProductPrice(orderProductDto.unitPrice().multiply(BigDecimal.valueOf(orderProductDto.quantity())))
                        .order(order)
                        .build()
        ).toList();

        var totalOrderPrice = orderProducts.stream()
                .map(OrderProduct::getTotalProductPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        order.setOrderProducts(orderProducts);
        order.setTotal(totalOrderPrice);

        var savedOrder = orderRepository.save(order);

        return OrderDto.builder()
                .id(savedOrder.getId())
                .customerId(savedOrder.getCustomer().getId())
                .orderDate(savedOrder.getOrderDate())
                .total(savedOrder.getTotal())
                .orderProducts(orderDto.getOrderProducts())
                .build();
    }
}
