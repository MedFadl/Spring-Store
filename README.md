# Store - Spring Boot Learning Journey

> **Note**
>
> This repository is **not about "vibe coding" or blindly generating code with AI**.
>
> I use AI as a **learning assistant** to understand concepts, review ideas, get feedback, and improve my problem-solving skills — not to skip the learning process.
>
> The goal of this playground is to **master Spring Boot**, understand backend architecture, and grow step by step toward becoming a professional **back-end developer**.
>
> If you are learning too, use AI as a tool to understand better, not as a replacement for thinking.

---

## What This Project Is

**Store** is my personal repository for learning **Spring Boot**.

Having built a strong foundation in core Java (see my [JavaPlayGround](https://github.com/medhat/JavaPlayGround) repo), I am now moving into the world of frameworks. This project is where I experiment with Spring Boot's features, learn how to build enterprise-ready applications, and prepare for real-world backend roles.

This repository is used to:

* Transition from core Java to the Spring ecosystem
* Understand Inversion of Control (IoC) and Dependency Injection (DI)
* Learn Spring Boot's auto-configuration magic
* Explore the various Spring annotations and their roles
* Build RESTful APIs and handle web requests
* Practice organizing code into layers (Controller, Service, Repository)
* Learn how to manage application configuration and properties
* Prepare for more advanced topics like Spring Data JPA, Security, and Microservices

---

## Main Goal

The main goal is to bridge the gap between "knowing Java" and "building professional backend systems."

**To master Spring Boot and become job-ready as a Java Back-End Developer, inshallah.**

My current path is:

1.  Master Spring Core concepts (Beans, IoC, DI)
2.  Understand the Spring Bean Lifecycle
3.  Get comfortable with Spring MVC and REST controllers
4.  Learn how to use Spring Boot Starters and Auto-configuration
5.  Move into Spring Data JPA and database integration
6.  Implement validation and error handling
7.  Learn Spring Security for authentication and authorization
8.  Explore testing Spring Boot applications (JUnit, Mockito)
9.  Build a complete, real-world backend project
10. Become a capable and confident back-end developer, inshallah

---

## What I Have Covered So Far

I am currently in the early stages of Spring Boot, focusing on the core mechanics:

* **Inversion of Control (IoC) & Beans**: Understanding how Spring manages object creation and lifecycle.
* **Dependency Injection (DI)**:
    * Constructor Injection (The recommended way!)
    * Setter Injection
    * Field Injection (and why to avoid it)
* **Spring Annotations**:
    * `@SpringBootApplication`: The entry point.
    * `@Component`, `@Service`, `@Controller`, `@Repository`: Identifying Spring-managed beans.
    * `@Autowired`: Automating dependency wiring.
    * `@Primary` & `@Qualifier`: Handling multiple beans of the same type.
    * `@Value`: Injecting properties from `application.properties`.
    * `@RequestMapping`: Mapping web requests.
* **Web Basics**: Setting up simple controllers and serving static content (`index.html`).
* **Project Structure**: Following standard Maven and Spring Boot conventions.

---

## Project Highlights

### IoC and Dependency Injection
I've practiced how to let Spring handle the "wiring" of the application. For example, using `@Qualifier` to choose between different payment services or notification methods without changing the business logic.

### Layered Architecture
Even in these early examples, I am practicing separating concerns:
- **Web Layer**: Controllers to handle HTTP requests.
- **Service Layer**: Business logic (like `OrderService`).
- **Notification Layer**: Abstracting communication (SMS, Email).

---

## Current Project Structure

```text
store/
├─ pom.xml
├─ README.md
├─ src/
│  ├─ main/
│  │  ├─ java/
│  │  │  └─ com/
│  │  │     └─ medhat/
│  │  │        └─ store/
│  │  │           ├─ StoreApplication.java       (Entry Point)
│  │  │           ├─ HomeController.java         (Web Controller)
│  │  │           ├─ OrderService.java           (Business Logic)
│  │  │           ├─ PaymentService.java         (Interface)
│  │  │           ├─ VCashPaymentService.java
│  │  │           ├─ WaffarhaPaymentService.java
│  │  │           └─ notification/               (Sub-package)
│  │  │              ├─ NotificationService.java (Interface)
│  │  │              ├─ EmailNotificationService.java
│  │  │              ├─ SMSNotificationService.java
│  │  │              └─ NotificationManager.java
│  │  └─ resources/
│  │     ├─ application.properties               (Config)
│  │     └─ static/
│  │        ├─ index.html
│  │        └─ Notes.md                          (Personal Study Notes)
│  └─ test/                                      (Upcoming: Unit Tests)
```

---

## Learning Roadmap

### Current Stage: Spring Boot Fundamentals
* [x] Spring Boot Project Setup (Maven)
* [x] Understanding IoC and Beans
* [x] Dependency Injection (Constructor vs Setter)
* [x] Core Annotations
* [x] Basic Controllers and Request Mapping
* [x] Externalized Configuration (`@Value`)

### Next Stage: Data and Persistence
* [ ] Introduction to Spring Data JPA
* [ ] Working with H2 and MySQL
* [ ] Creating Entities and Repositories
* [ ] CRUD Operations
* [ ] Transaction Management

### Advanced Backend Stage
* [ ] REST API Best Practices (DTOs, ResponseEntities)
* [ ] Exception Handling (`@ControllerAdvice`)
* [ ] Bean Validation
* [ ] Spring Security (JWT, OAuth2)
* [ ] Unit and Integration Testing

---

## Final Purpose

This project is my "coding gym" for Spring Boot. It's where I make mistakes, learn from them, and build the discipline needed for a professional career.

**The mission is to master Spring Boot, unlock my potential as a developer, and build impactful backend systems, inshallah <3.**
