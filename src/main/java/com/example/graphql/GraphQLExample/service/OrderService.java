package com.example.graphql.GraphQLExample.service;

import com.example.graphql.GraphQLExample.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto placeOrder(OrderDto orderDto);

    List<OrderDto> getOrders();
}
