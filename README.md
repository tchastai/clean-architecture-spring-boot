# Clean Architecture

A Spring Boot project inspired by Robert C. Martin's book 'Clean Architecture', based on hexagonal architecture.

## Architecture

.
├── README.md
├── docker-compose.yaml
├── domain
│   ├── pom.xml
│   ├── src
│       ├── main
│       │   ├── java
│       │   │   └── com
│       │   │       └── cleanarchitecture
│       │   │           ├── House.java
│       │   │           ├── constant
│       │   │           │   └── ExceptionConstant.java
│       │   │           ├── exception
│       │   │           │   └── DomainException.java
│       │   │           ├── repository
│       │   │           │   └── HouseRepository.java
│       │   │           └── service
│       │   │               ├── DomainHouseService.java
│       │   │               └── HouseService.java
│       │   └── resources
│       └── test
│           └── java
│               ├── HouseTest.java
│               └── com
│                   └── cleanarchitecture
│                       └── service
│                           └── DomainHouseServiceTest.java
├── hexagonal
│   ├── HELP.md
│   ├── mvnw
│   ├── mvnw.cmd
│   ├── pom.xml
│   ├── src
│       ├── main
│       │   ├── java
│       │   │   └── com
│       │   │       └── cleanarchitecture
│       │   │           └── hexagonal
│       │   │               ├── HexagonalApplication.java
│       │               ├── application
│       │   │               │   ├── dto
│       │   │               │   │   ├── CreateHouseRequestDto.java
│       │   │               │   │   ├── CreateHouseResponseDto.java
│       │   │               │   │   └── GetHouseResponseDto.java
│       │   │               │   └── rest
│       │   │               │       └── HouseController.java
│       │   │               └── infrastructure
│       │   │                   ├── configuration
│       │   │                   │   └── ServiceInjectionConfiguration.java
│       │   │                   └── repository
│       │   │                       └── postgres
│       │   │                           ├── HouseDbRepository.java
│       │   │                           ├── JpaHouseRepository.java
│       │   │                           └── entity
│       │   │                               └── HouseEntity.java
│       │   └── resources
│       │       ├── application-dev.yaml
│       │       ├── application-preprod.yaml
│       │       ├── application-prod.yaml
│       │       ├── application.yaml
│       │       └── logback-spring.xml
│       └── test
│           └── java
│               └── com
│                   └── cleanarchitecture
│                       └── hexagonal
│                           ├── HexagonalApplicationTests.java
│                           └── application
│                               └── rest
│                                   └── HouseControllerTest.java


As can be seen, the project is divided into two modules: The first one, called "domain," aims to isolate the business logic without injecting any additional library. This approach facilitates reusable business code, ensuring high maintainability, scalability, and testability.
