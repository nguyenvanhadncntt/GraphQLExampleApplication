package com.example.graphql.GraphQLExample.repository;

import com.example.graphql.GraphQLExample.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
