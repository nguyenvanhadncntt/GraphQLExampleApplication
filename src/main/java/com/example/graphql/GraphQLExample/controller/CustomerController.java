package com.example.graphql.GraphQLExample.controller;

import com.example.graphql.GraphQLExample.dto.CustomerDto;
import com.example.graphql.GraphQLExample.service.CustomerService;
import org.apache.catalina.util.StringUtil;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @QueryMapping
    public List<CustomerDto> getCustomers()
    {
        return customerService.getCustomers();
    }

    @QueryMapping
    public List<CustomerDto> searchCustomers(@Argument String name, @Argument int page, @Argument int size)
    {
        return customerService.searchCustomers(StringUtils.hasText(name) ? name : "", page, size);
    }

    @MutationMapping
    public CustomerDto createCustomer(@Argument CustomerDto customer)
    {
        return customerService.createCustomer(customer);
    }

    @MutationMapping
    public boolean deleteCustomer(@Argument long id)
    {
        return customerService.deleteCustomer(id);
    }
}
