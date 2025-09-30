package com.example.graphql.GraphQLExample.controller;

import com.example.graphql.GraphQLExample.dto.OrderDto;
import com.example.graphql.GraphQLExample.service.OrderService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @MutationMapping
    public OrderDto placeOrder(@Argument("order") OrderDto orderDto) {
        return orderService.placeOrder(orderDto);
    }
}
