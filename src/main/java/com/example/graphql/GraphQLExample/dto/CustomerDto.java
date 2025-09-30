package com.example.graphql.GraphQLExample.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Long id;
    private String name;
    private String address;
    private LocalDate birthDate;
    private String phoneNumber;
    private List<OrderDto> orders;
}
