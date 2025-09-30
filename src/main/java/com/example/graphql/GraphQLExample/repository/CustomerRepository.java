package com.example.graphql.GraphQLExample.repository;

import com.example.graphql.GraphQLExample.model.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c FROM Customer c left join fetch c.orders o WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Customer> findByNameContainingIgnoreCase(@Param("name") String name, Pageable pageable);
}
