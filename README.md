# Store - Spring Boot Learning Journey

> **Note**
>
> This repository is **not about "vibe coding" or blindly generating code with AI**.
>
> I use AI as a **learning assistant** to understand concepts, review ideas, get feedback, and improve my problem-solving skills — not to skip the learning process.
>
> The goal of this playground is to **master Spring Boot**, understand backend architecture, and grow step by step toward becoming a professional **Java Back-End Developer**.
>
> If you are learning too, use AI as a tool to understand better, not as a replacement for thinking.

---

## What This Project Is

**Store** is my personal Spring Boot learning project.

After building a strong foundation in core Java through my [JavaPlayGround](https://github.com/medhat/JavaPlayGround) repo, this project became my transition into the Spring ecosystem and real backend development.

This repository started as a place to practice the fundamentals, but it has grown into a broader backend learning project where I explore how real Spring Boot applications are structured.

So far, this project has helped me practice:

- Spring Boot fundamentals
- Inversion of Control and Dependency Injection
- Bean lifecycle and configuration
- Spring MVC basics
- Layered backend architecture
- Spring Data JPA fundamentals
- Entity relationships and database modeling
- Reducing boilerplate code with Lombok
- Database schema evolution using Flyway
- Repository patterns and custom queries
- Moving step by step toward production-style backend development

Now that the core fundamentals are mostly covered, the next phase is focused on building more real-world backend features such as:

- REST APIs
- Authentication and authorization
- Validation
- Error handling
- Payment processing
- Testing
- Cleaner API design
- Production-style backend architecture

I may continue building on this same project, or I may create a new project to explore new ideas with a cleaner structure. Most likely, I will continue improving this project and use it as the foundation for the next learning stages.

---

## Main Goal

The main goal is to bridge the gap between **knowing Java** and **building professional backend systems**.

**To master Spring Boot and become job-ready as a Java Back-End Developer, inshallah.**

This project is not just about writing code. It is about understanding how backend systems work, why certain patterns exist, and how to build applications that are clean, maintainable, and closer to real production systems.

---

## Learning Progress

### Completed / Covered Fundamentals

I have finished the main Spring Boot fundamentals and built a solid base in:

1. Spring Core concepts: Beans, IoC, DI **[DONE]**
2. Spring Bean Lifecycle **[DONE]**
3. Spring Boot Starters and Auto-configuration **[DONE]**
4. External configuration with YAML **[DONE]**
5. Spring MVC basics **[DONE]**
6. Lombok basics **[DONE]**
7. Persistence introduction **[DONE]**
8. Flyway database migrations **[DONE]**
9. Spring Data JPA basics **[DONE / CONTINUING]**
10. Repository queries and projections **[DONE / CONTINUING]**

### Current / Next Learning Phase

Now I am moving into more practical backend development:

1. Build real REST APIs **[NEXT]**
2. Use DTOs for request and response models **[NEXT]**
3. Add validation **[UPCOMING]**
4. Add global exception handling **[UPCOMING]**
5. Implement authentication and authorization with Spring Security **[UPCOMING]**
6. Learn JWT-based authentication **[UPCOMING]**
7. Explore payment processing **[UPCOMING]**
8. Write tests with JUnit and Mockito **[UPCOMING]**
9. Improve project structure and architecture **[CONTINUING]**
10. Build a complete real-world backend project **[LONG-TERM GOAL]**

---

## What I Have Covered So Far

This project has covered the foundation needed before moving into full REST API development.

### Spring Core Fundamentals

- **Inversion of Control**
  - Understanding how Spring manages object creation.
  - Letting the container wire dependencies instead of manually creating objects everywhere.

- **Dependency Injection**
  - Constructor injection.
  - Setter injection.
  - Field injection.
  - Understanding when constructor injection is usually preferred.

- **Beans and Components**
  - Using Spring stereotypes:
    - `@Component`
    - `@Service`
    - `@Controller`
    - `@Repository`

- **Bean Configuration**
  - Java-based configuration:
    - `@Configuration`
    - `@Bean`

- **Bean Selection**
  - Using:
    - `@Primary`
    - `@Qualifier`

- **Bean Lifecycle**
  - `@PostConstruct`
  - `@PreDestroy`

- **Bean Scopes and Lazy Loading**
  - Singleton and prototype scopes.
  - Lazy initialization.
  - Understanding how bean creation affects application behavior.

---

## Spring Boot Features Covered

- Maven project setup
- Spring Boot application entry point
- Auto-configuration basics
- Externalized configuration using `application.yaml`
- Static resources
- Basic Spring MVC request handling
- Maven dependency management
- Connecting the application to a database
- Managing database schema changes with Flyway
- Using Spring Boot as the foundation for backend development

---

## Spring MVC Progress

I have worked with the basic Spring MVC concepts needed before moving into REST APIs:

- Creating controllers
- Handling basic web requests
- Serving static content
- Understanding Spring Boot static resource handling
- Understanding the request/response flow at a basic level

The next step is to move from simple MVC basics into proper REST API development using:

- `@RestController`
- Request mapping
- Path variables
- Query parameters
- Request bodies
- Response DTOs
- Status codes
- API error handling

---

## Persistence and Database Progress

Persistence has become one of the main parts of this project.

### Covered

- Introduction to persistence in Spring Boot
- Creating entity/model classes
- Database integration basics
- Schema evolution using migrations
- Moving from manual database changes to versioned migrations
- Spring Data JPA repositories
- Basic CRUD repository usage
- Custom query methods
- JPQL queries
- Entity relationships
- Working with related data
- Using projections for selected data

### Flyway Database Migrations

The project uses Flyway to manage database schema changes in a professional and versioned way.

```text
src/main/resources/db/migration/
├── V1__initial_migration.sql
├── V2__add_profile.sql
└── V3__add_tags.sql
```

Flyway helped me understand why database changes should be tracked, versioned, and repeatable instead of being applied manually.

---

## Lombok Progress

I have used **Lombok** to reduce repetitive Java boilerplate code.

Lombok helps generate:

- Getters and setters
- Constructors
- `toString()`
- `equals()` / `hashCode()`
- Builder-style object creation where needed

Used in:

- Models
- DTOs
- JPA entities
- Request/response objects

This helped me keep the code cleaner while focusing more on Spring Boot concepts and backend architecture.

---

## Project Highlights

### Spring Core Practice

- Bean creation and lifecycle
- Dependency injection patterns
- Multiple implementation handling
- Configuration management
- Understanding how Spring wires an application together

### Spring Boot Practice

- Auto-configuration
- Application configuration
- Dependency management
- Running and structuring a Spring Boot app

### MVC and Web Basics

- Basic request handling
- Static content serving
- Preparing for REST API development

### Persistence Practice

- Entity modeling
- Repository usage
- Database migrations
- Query methods
- JPQL
- Relationships between entities
- Projections and selected data fetching

### Learning Mindset

This project represents the stage where I finished the fundamentals and started moving from "learning concepts" into "building backend features".

---

## Learning Roadmap

### Stage 1: Spring Core and Fundamentals

- [x] Spring Boot setup
- [x] IoC and DI
- [x] Bean lifecycle
- [x] Bean scopes
- [x] Configuration
- [x] YAML configuration
- [x] Auto-configuration basics

### Stage 2: Spring MVC

- [x] Controllers
- [x] Static resources
- [x] Basic request handling
- [ ] REST APIs
- [ ] DTOs
- [ ] Exception handling
- [ ] Response status handling

### Stage 3: Lombok

- [x] Reduce boilerplate
- [x] Use Lombok with models and entities
- [ ] Improve Lombok usage with JPA best practices

### Stage 4: Persistence

- [x] Models/entities
- [x] Flyway setup
- [x] Spring Data JPA basics
- [x] Repository methods
- [x] Custom queries
- [x] Basic relationships
- [ ] Advanced relationships
- [ ] CRUD APIs
- [ ] Pagination and sorting
- [ ] Transaction management

### Stage 5: REST API Development

- [ ] Build proper REST controllers
- [ ] Use DTOs for clean API input/output
- [ ] Add validation
- [ ] Add global exception handling
- [ ] Use proper HTTP status codes
- [ ] Design cleaner API endpoints

### Stage 6: Authentication and Authorization

- [ ] Learn Spring Security fundamentals
- [ ] Implement user authentication
- [ ] Implement authorization
- [ ] Learn JWT authentication
- [ ] Protect API endpoints
- [ ] Understand roles and permissions

### Stage 7: Payments and Real-World Features

- [ ] Explore payment processing concepts
- [ ] Integrate with a payment provider
- [ ] Handle payment flow securely
- [ ] Understand webhooks
- [ ] Learn how real backend services communicate with external systems

### Stage 8: Testing and Production Readiness

- [ ] Unit testing with JUnit
- [ ] Mocking with Mockito
- [ ] Repository testing
- [ ] Controller testing
- [ ] Integration testing
- [ ] Improve error handling
- [ ] Improve project structure
- [ ] Prepare for production-style backend development

---

## Technologies Used

- Java
- Spring Boot
- Spring Core
- Spring MVC
- Spring Data JPA
- Lombok
- Maven
- Flyway
- YAML
- SQL
- JPA / Hibernate

### Planned / Upcoming

- Spring Security
- JWT
- Bean Validation
- JUnit
- Mockito
- Payment gateway integration

---

## Current Status

The fundamentals phase is mostly complete.

This project now includes practice with:

- Spring Boot fundamentals
- IoC and Dependency Injection
- Bean lifecycle
- MVC basics
- Lombok
- Database migrations
- Persistence
- Spring Data JPA
- Repository queries
- Entity relationships
- Backend project structure basics

The next major step is:

**Building real REST APIs, then moving into authentication, authorization, payments, testing, and more production-style backend features.**

I am still deciding whether to continue everything inside this same project or create a new project to explore new topics with a fresh structure. Most likely, I will continue this project and improve it step by step.

---

## How to Run

```bash
./mvnw spring-boot:run
```

**Windows**

```bash
mvnw.cmd spring-boot:run
```

Open:

```text
http://localhost:8080
```

---

## Final Purpose

This is my Spring Boot coding gym — where I learn by building, breaking, fixing, and improving.

The first phase was about learning the fundamentals.

The next phase is about building real backend features and understanding how professional systems are designed.

The goal is to become a strong backend developer capable of building real-world systems with confidence.

**Mission: master Spring Boot and become job-ready, inshallah.**