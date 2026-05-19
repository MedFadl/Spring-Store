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

1.  Master Spring Core concepts (Beans, IoC, DI) [DONE]
2.  Understand the Spring Bean Lifecycle [DONE]
3.  Get comfortable with Spring MVC and REST controllers [IN PROGRESS]
4.  Learn how to use Spring Boot Starters and Auto-configuration [DONE]
5.  Move into Spring Data JPA and database integration [UPCOMING]
6.  Implement validation and error handling
7.  Learn Spring Security for authentication and authorization
8.  Explore testing Spring Boot applications (JUnit, Mockito)
9.  Build a complete, real-world backend project
10. Become a capable and confident back-end developer, inshallah

---

## What I Have Covered So Far

I am currently moving from Spring Core fundamentals to Data and Persistence:

* **Inversion of Control (IoC) & Beans**: Understanding how Spring manages object creation and lifecycle.
* **Dependency Injection (DI)**: Constructor, Setter, and Field injection.
* **Bean Lifecycle**: Using `@PostConstruct` and `@PreDestroy` to manage bean initialization and cleanup.
* **Bean Scopes & Lazy Loading**: Mastering `Singleton` vs `Prototype` and using `@Lazy` for performance optimization.
* **Spring Annotations**:
    * `@SpringBootApplication`, `@Component`, `@Service`, `@Controller`, `@Repository`.
    * `@Autowired`, `@Primary`, `@Qualifier`.
    * `@Value`, `@Configuration`, `@Bean`.
    * `@RequestMapping`.
* **Configuration**: Moving from `application.properties` to structured `application.yaml`.
* **Layered Architecture & Repository Pattern**: Practicing clean code by separating concerns into Controllers, Services, and Repositories (using an In-Memory implementation for now).
* **Web Basics**: Simple controllers and static content.

---

## Project Highlights

### IoC and Dependency Injection
I've practiced how to let Spring handle the "wiring" of the application. I've explored both annotation-based wiring and manual Java-based configuration using `@Configuration` and `@Bean`.

### Bean Lifecycle and Scopes
Implemented lifecycle hooks (`@PostConstruct`, `@PreDestroy`) and experimented with different bean scopes like `Prototype` to understand how Spring manages object instances.

### Layered Architecture
Even in these early examples, I am practicing separating concerns:
- **Web Layer**: Controllers to handle HTTP requests.
- **Service Layer**: Business logic (like `OrderService` and `UserService`).
- **Data Layer**: Initializing the repository pattern with `InMemoryUserRepository`.
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
│  │  │           ├─ AppConfig.java              (Java-Based Configuration)
│  │  │           ├─ HomeController.java         (Web Controller)
│  │  │           ├─ OrderService.java           (Lifecycle & Scopes)
│  │  │           ├─ HeavyResource.java          (Lazy Initialization)
│  │  │           ├─ PaymentService.java         (Interface)
│  │  │           ├─ VCashPaymentService.java
│  │  │           ├─ WaffarhaPaymentService.java
│  │  │           ├─ notification/               (Sub-package)
│  │  │           │  ├─ NotificationService.java
│  │  │           │  ├─ EmailNotificationService.java
│  │  │           │  ├─ SMSNotificationService.java
│  │  │           │  └─ NotificationManager.java
│  │  │           └─ user/                       (User Management Layer)
│  │  │              ├─ User.java
│  │  │              ├─ UserRepository.java      (Repository Interface)
│  │  │              ├─ InMemoryUserRepository.java
│  │  │              └─ UserService.java
│  │  └─ resources/
│  │     ├─ application.yaml                     (Structured Configuration)
│  │     └─ static/
│  │        ├─ index.html
│  │        └─ Notes.md                          (Personal Study Notes)
│  └─ test/
│     └─ java/
│        └─ com/
│           └─ medhat/
│              └─ store/
│                 └─ SoreApplicationTests.java   (Context Loading Test)
```

---

## Learning Roadmap

### Current Stage: Spring Core & Fundamentals
* [x] Spring Boot Project Setup (Maven)
* [x] Understanding IoC and Beans
* [x] Dependency Injection (Constructor, Setter, Field)
* [x] Bean Lifecycle hooks (`@PostConstruct`, `@PreDestroy`)
* [x] Bean Scopes (Singleton, Prototype) & Lazy Loading
* [x] Java-Based Configuration (`@Configuration`, `@Bean`)
* [x] Externalized Configuration (Properties & YAML)
* [x] Basic Controllers and Request Mapping

### Next Stage: Data and Persistence (In Progress)
* [x] Understanding the Repository Pattern
* [x] Implementing In-Memory Repositories
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
