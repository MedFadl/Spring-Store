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

After building a strong foundation in core Java through my [JavaPlayGround](https://github.com/medhat/JavaPlayGround) repo, this project represents my transition into the Spring ecosystem and real backend development.

This repository is used to practice:

- Spring Boot fundamentals
- Inversion of Control and Dependency Injection
- Bean lifecycle and configuration
- Spring MVC and web request handling
- Layered backend architecture
- Spring Data JPA basics
- Reducing boilerplate code with Lombok
- Database schema evolution using Flyway
- Moving step by step toward production-style backend development

---

## Main Goal

The main goal is to bridge the gap between **knowing Java** and **building professional backend systems**.

**To master Spring Boot and become job-ready as a Java Back-End Developer, inshallah.**

My current learning path is:

1. Master Spring Core concepts: Beans, IoC, DI **[DONE]**
2. Understand the Spring Bean Lifecycle **[DONE]**
3. Learn Spring Boot Starters and Auto-configuration **[DONE]**
4. Get comfortable with Spring MVC and basic web controllers **[DONE / CONTINUING]**
5. Learn how Lombok reduces Java boilerplate **[DONE / CONTINUING]**
6. Move into Spring Data JPA and database integration **[IN PROGRESS]**
7. Learn database migration with Flyway **[IN PROGRESS]**
8. Implement validation and error handling **[UPCOMING]**
9. Learn Spring Security for authentication and authorization **[UPCOMING]**
10. Explore testing Spring Boot applications with JUnit and Mockito **[UPCOMING]**
11. Build a complete real-world backend project **[UPCOMING]**

---

## What I Have Covered So Far

I have completed the Spring Core foundation and started moving into persistence and database-backed applications.

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
  - Singleton and prototype scopes
  - Lazy initialization for performance optimization

---

## Spring Boot Features Covered

- Maven project setup
- Spring Boot application entry point
- Auto-configuration basics
- Externalized configuration using `application.yaml`
- Static resources (`src/main/resources/static`)
- Basic Spring MVC request handling
- Maven dependency management

---

## Lombok Progress

I have started using **Lombok** to reduce repetitive Java boilerplate code.

Lombok generates automatically:

- Getters / Setters
- Constructors
- `toString()`
- `equals()` / `hashCode()`

Used in:

- Models
- DTOs
- JPA entities
- Request/response objects

This helps keep code cleaner and more maintainable.

---

## Spring MVC Progress

I have started working with Spring MVC concepts:

- Creating controllers
- Handling basic requests
- Serving static content
- Understanding Spring Boot static resource handling

Still progressing toward full REST API development.

---

## Persistence and Database Progress

### Covered / Started

- Introduction to persistence in Spring Boot
- Creating model classes
- Database integration basics
- Schema evolution using migrations
- Moving from manual DB changes to versioned structure

### Flyway Database Migrations

```
src/main/resources/db.migration/
├─ V1__initial_migration.sql
├─ V2__add_profile.sql
└─ V3__add_tags.sql
```

This introduces professional database version control using Flyway.

---

## Project Highlights

### Spring Core Practice

- Bean creation and lifecycle
- Dependency injection patterns
- Multiple implementation handling
- Configuration management

### Lombok Usage

Reduces boilerplate and prepares for cleaner backend architecture.

### MVC and Static Content

Basic web handling and static file serving.

### Database Migration Practice

Professional approach to schema versioning.

---

## Current Project Structure

```
Spring-Store/
├─ pom.xml
├─ README.md
├─ mvnw
├─ mvnw.cmd
├─ src/
│  ├─ main/
│  │  ├─ java/
│  │  │  └─ com/
│  │  │     └─ medhat/
│  │  │        └─ store/
│  │  │           ├─ StoreApplication.java
│  │  │           ├─ models/
│  │  │           │  └─ User.java
│  │  │           └─ archived/
│  │  │              └─ earlier Spring Core learning examples
│  │  └─ resources/
│  │     ├─ application.yaml
│  │     ├─ db.migration/
│  │     │  ├─ V1__initial_migration.sql
│  │     │  ├─ V2__add_profile.sql
│  │     │  └─ V3__add_tags.sql
│  │     └─ static/
│  │        ├─ index.html
│  │        └─ Notes.md
│  └─ test/
```

---

## Learning Roadmap

### Stage 1: Spring Core and Fundamentals

- [x] Spring Boot setup
- [x] IoC and DI
- [x] Bean lifecycle
- [x] Bean scopes
- [x] Configuration
- [x] YAML configuration

### Stage 2: Spring MVC

- [x] Controllers
- [x] Static resources
- [ ] REST APIs
- [ ] DTOs
- [ ] Exception handling

### Stage 3: Lombok

- [x] Reduce boilerplate
- [ ] Lombok best practices with JPA

### Stage 4: Persistence

- [x] Models
- [x] Flyway setup
- [ ] Spring Data JPA
- [ ] Relationships
- [ ] CRUD APIs

### Stage 5: Advanced Backend

- [ ] Validation
- [ ] Security (Spring Security + JWT)
- [ ] Testing
- [ ] Production-ready API design

---

## Technologies Used

- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Lombok
- Maven
- Flyway
- YAML
- SQL

---

## How to Run

```bash
./mvnw spring-boot:run
```

Windows:

```bash
mvnw.cmd spring-boot:run
```

Open:

```
http://localhost:8080
```

---

## Current Status

This project now includes:

- Spring Boot fundamentals
- IoC / DI mastery
- MVC basics
- Lombok usage
- Initial persistence design
- Flyway migrations

Next step: **Spring Data JPA + real CRUD APIs**

---

## Final Purpose

This is my Spring Boot coding gym — where I learn by building, breaking, and improving.

The goal is to become a strong backend developer capable of building real-world systems with confidence.

**Mission: master Spring Boot and become job-ready, inshallah.**