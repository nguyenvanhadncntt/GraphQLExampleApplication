package com.example.graphql.GraphQLExample.controller;

import com.example.graphql.GraphQLExample.dto.OrderDto;
import com.example.graphql.GraphQLExample.publisher.OrderPublisher;
import com.example.graphql.GraphQLExample.service.OrderService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Controller
public class OrderController {
    private final OrderService orderService;
    private final OrderPublisher orderPublisher;

    public OrderController(OrderService orderService, OrderPublisher orderPublisher) {
        this.orderService = orderService;
        this.orderPublisher = orderPublisher;
    }

    @MutationMapping
    public OrderDto placeOrder(@Argument("order") OrderDto orderDto) {
        var result = orderService.placeOrder(orderDto);
        orderPublisher.publish(result);
        return result;
    }

    @SubscriptionMapping
    public Flux<OrderDto> getOrderPlaced() {
        return orderPublisher.getPublisher();
    }
}
