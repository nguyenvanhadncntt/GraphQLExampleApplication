package com.example.graphql.GraphQLExample.publisher;

import com.example.graphql.GraphQLExample.dto.OrderDto;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Component
public class OrderPublisher {
    private final Sinks.Many<OrderDto> sink = Sinks.many().multicast().onBackpressureBuffer();

    public void publish(OrderDto order) {
        sink.tryEmitNext(order);
    }

    public Flux<OrderDto> getPublisher() {
        return sink.asFlux();
    }
}
