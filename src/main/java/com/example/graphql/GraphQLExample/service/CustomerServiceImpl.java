package com.example.graphql.GraphQLExample.service;

import com.example.graphql.GraphQLExample.dto.CustomerDto;
import com.example.graphql.GraphQLExample.model.Customer;
import com.example.graphql.GraphQLExample.repository.CustomerRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    private CustomerServiceImpl(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDto> getCustomers() {
        return customerRepository.findAll().stream().map(customer ->
                CustomerDto.builder()
                        .id(customer.getId())
                        .name(customer.getName())
                        .address(customer.getAddress())
                        .birthDate(customer.getBirthDate())
                        .phoneNumber(customer.getPhoneNumber())
                        .build()
        ).toList();
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customer) {
        Customer customerDB = new Customer();
        customerDB.setName(customer.getName());
        customerDB.setAddress(customer.getAddress());
        customerDB.setBirthDate(customer.getBirthDate());
        customerDB.setPhoneNumber(customer.getPhoneNumber());

        customerDB = customerRepository.save(customerDB);

        customer.setId(customerDB.getId());

        return customer;
    }

    @Override
    public boolean deleteCustomer(long id) {
        customerRepository.deleteById(id);
        return true;
    }

    @Override
    public List<CustomerDto> searchCustomers(String name, int page, int size) {
        return customerRepository.findByNameContainingIgnoreCase(name, PageRequest.of(page, size)).stream().map(customer ->
                CustomerDto.builder()
                        .id(customer.getId())
                        .name(customer.getName())
                        .address(customer.getAddress())
                        .birthDate(customer.getBirthDate())
                        .phoneNumber(customer.getPhoneNumber())
                        .build()
        ).toList();
    }
}
