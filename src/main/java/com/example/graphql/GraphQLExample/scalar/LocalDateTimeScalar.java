package com.example.graphql.GraphQLExample.scalar;

import graphql.language.StringValue;
import graphql.schema.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LocalDateTimeScalar {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    public static GraphQLScalarType createLocalDateScalar() {
        return GraphQLScalarType.newScalar()
                .name("LocalDateTime")
                .description("Custom scalar for handling LocalDate in format 'yyyy-MM-dd'")
                .coercing(new Coercing<LocalDateTime, String>() {
                    @Override
                    public String serialize(Object dataFetcherResult) {
                        if (dataFetcherResult instanceof LocalDateTime) {
                            return ((LocalDateTime) dataFetcherResult).format(formatter);
                        }
                        throw new CoercingSerializeException("Expected a LocalDateTime object.");
                    }

                    @Override
                    public LocalDateTime parseValue(Object input) {
                        try {
                            if (input instanceof String) {
                                return LocalDateTime.parse((String) input, formatter);
                            }
                            throw new CoercingParseValueException("Expected a String.");
                        } catch (DateTimeParseException e) {
                            throw new CoercingParseValueException("Invalid date-time format, expected yyyy-MM-dd'T'HH:mm:ss.");
                        }
                    }

                    @Override
                    public LocalDateTime parseLiteral(Object input) {
                        if (input instanceof StringValue) {
                            try {
                                return LocalDateTime.parse(((StringValue) input).getValue(), formatter);
                            } catch (DateTimeParseException e) {
                                throw new CoercingParseLiteralException("Invalid date-time format, expected yyyy-MM-dd'T'HH:mm:ss.");
                            }
                        }
                        throw new CoercingParseLiteralException("Expected a StringValue.");
                    }
                }).build();
    }
}
