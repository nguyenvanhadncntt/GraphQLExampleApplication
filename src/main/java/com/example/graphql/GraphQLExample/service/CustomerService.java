package com.example.graphql.GraphQLExample.service;

import com.example.graphql.GraphQLExample.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getCustomers();

    CustomerDto createCustomer(CustomerDto customer);

    boolean deleteCustomer(long id);

    List<CustomerDto> searchCustomers(String name, int page, int size);
}
