package com.example.graphql.GraphQLExample.service;

import com.example.graphql.GraphQLExample.dto.OrderDto;

public interface OrderService {
    OrderDto placeOrder(OrderDto orderDto);
}
