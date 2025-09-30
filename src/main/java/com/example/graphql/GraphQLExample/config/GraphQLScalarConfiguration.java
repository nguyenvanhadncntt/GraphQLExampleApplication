package com.example.graphql.GraphQLExample.config;

import com.example.graphql.GraphQLExample.scalar.LocalDateScalar;
import com.example.graphql.GraphQLExample.scalar.LocalDateTimeScalar;
import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class GraphQLScalarConfiguration {
    @Bean
    public GraphQLScalarType localDateScalar() {
        return LocalDateScalar.createLocalDateScalar();
    }

    @Bean
    public GraphQLScalarType localDateTimeScalar() {
        return LocalDateTimeScalar.createLocalDateScalar();
    }

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return builder ->
                builder.scalar(ExtendedScalars.Date)
                        .scalar(ExtendedScalars.LocalTime)
                        .scalar(ExtendedScalars.DateTime)
                        .scalar(localDateScalar())
                        .scalar(localDateTimeScalar());
    }
    
}