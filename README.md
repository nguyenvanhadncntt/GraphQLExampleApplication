# GraphQLExample

A Java Spring Boot application demonstrating a modular GraphQL API for managing customers, orders, and products.

## Features

- GraphQL API endpoints for CRUD operations
- DTOs, services, repositories, and controllers
- Custom GraphQL scalars
- Maven build

## Project Structure

```
src/
  main/
    java/com/example/graphql/GraphQLExample/
      config/         # App and GraphQL configuration
      controller/     # GraphQL controllers
      dto/            # Data Transfer Objects
      model/          # JPA entities
      repository/     # Spring Data repositories
      scalar/         # Custom scalars
      service/        # Business logic
    resources/
      application.properties
      graphql/
        schema.graphqls
  test/
    java/com/example/graphql/GraphQLExample/
      GraphQlExampleApplicationTests.java
```

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.8+

### Build & Run

```sh
mvn clean install
mvn spring-boot:run
```

The app runs at [http://localhost:8080](http://localhost:8080).

### GraphQL Playground

Access the GraphQL endpoint at:  
`http://localhost:8080/graphql`

Use tools like [Altair](https://altair.sirmuel.design/) or [GraphiQL](https://github.com/graphql/graphiql) to interact.

## Example Query

```graphql
query {
  orders {
    id
    orderDate
    total
    customer {
      id
      name
    }
    orderProducts {
      product {
        id
        name
      }
      quantity
      unitPrice
      totalProductPrice
    }
  }
}
```

## Testing

Run tests with:

```sh
mvn test
```

## License

MIT

