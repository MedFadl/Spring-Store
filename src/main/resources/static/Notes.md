# Spring Framework (:)) Quick Reference Guide

This is a structured reference for Spring annotations and core concepts learned so far, including practical examples from our Store project.

---

## 1. Stereotype Annotations
These tell Spring to create a Bean (an object) and manage its lifecycle. These are usually placed on classes.

| Annotation | Layer | Purpose | Example |
|---|---|---|---|
| `@Component` | Any | Generic bean. Base for all stereotypes. | `public class MyHelper { ... }` |
| `@Service` | Business | Logic layer. Same as `@Component` but semantically better. | `OrderService`, `UserService` |
| `@Repository` | Data | Database layer. Handles data access and exception translation. | `InMemoryUserRepository` |
| `@Controller` | Web | Handles HTTP requests and returns views (HTML). | `HomeController` |

### Code Example:
```java
@Service("Email") // optional name for @Qualifier
@Primary          // makes it the default implementation
public class EmailNotificationService implements NotificationService {
    // ... logic ...
}
```

---

## 2. Configuration & Bean Management
Used for manual bean definition, typically in a configuration class.

| Annotation | Purpose | Details |
|---|---|---|
| `@Configuration` | Marks class as a config source. | Contains one or more `@Bean` methods. |
| `@Bean` | Defines a single bean. | The method returns the object to be managed. |
| `@Scope` | Lifecycle of the bean. | `singleton` (default, one per app), `prototype` (new every time). |
| `@Lazy` | Delay initialization. | Bean is created only when requested for the first time. |

### Code Example:
```java
@Configuration
public class AppConfig {
    @Bean
    @Scope("prototype") // A new OrderService every time it's requested
    public OrderService orderService() {
        return new OrderService(paymentService());
    }
}
```

---

## 3. Bean Scopes
Defines the lifecycle and visibility of a bean instance.

| Scope | Description | Use Case |
|---|---|---|
| `singleton` | **(Default)** One instance per Spring Container. | Stateless beans (Services, Repositories). |
| `prototype` | A new instance is created every time it's requested. | Stateful beans or objects with short lifespans. |
| `request` | One instance per HTTP request. (Web only) | Tracking request-specific data or state. |
| `session` | One instance per HTTP session. (Web only) | User-specific data (Shopping cart, login info). |
| `application` | One instance per ServletContext. (Web only) | Global web application state. |

### Code Example:
```java
@Component
@Scope("prototype")
public class TaskProcessor {
    // Each thread/request gets its own instance
}

@Component
@Scope("session") // Needs a web-aware application context
public class UserSettings {
    // Data persists as long as the user's session is active
}
```

---

## 4. Dependency Injection (DI)
How Spring connects different beans and injects external data.

| Annotation | Purpose | Best Practice |
|---|---|---|
| `@Autowired` | Automatically injects a dependency. | Use **Constructor Injection** (works without annotation on single constructors). |
| `@Qualifier` | Specifies which bean to inject. | Used when multiple beans of the same type exist (e.g., SMS vs Email). |
| `@Value` | Injects external values. | Reads from `application.properties` or environment variables. |

### Code Example:
```java
@Service
public class NotificationManager {
    private final NotificationService service;

    // Constructor Injection (Recommended)
    public NotificationManager(@Qualifier("SMS") NotificationService service) {
        this.service = service;
    }
}

// Injecting values:
@Value("${mail.host}")
private String host;
```

---

## 5. Lifecycle Hooks
Methods that run automatically at specific points in a Bean's lifecycle.

| Annotation | Purpose | Usage |
|---|---|---|
| `@PostConstruct` | Runs **after** bean creation & injection. | Ideal for initialization logic. |
| `@PreDestroy` | Runs **before** bean is destroyed. | Ideal for cleanup (closing files, DB connections). |

### Code Example:
```java
@PostConstruct
public void init() {
    System.out.println("Service initialized and ready!");
}

@PreDestroy
public void cleanup() {
    System.out.println("Cleaning up resources before shutdown...");
}
```

---

## 6. Web Mapping
Mapping URLs to Java methods in your Controllers.

| Annotation | Purpose | Example |
|---|---|---|
| `@RequestMapping` | General mapping for URLs. | `@RequestMapping("/")` |

### Code Example:
```java
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index() {
        return "index.html"; // Refers to static/index.html
    }
}
```

---

## 7. Application Entry Point
| Annotation | Purpose |
|---|---|
| `@SpringBootApplication` | The "All-in-One" annotation. Enables: <br>1. **Auto-Configuration** <br>2. **Component Scanning** (looks for @Service, @Component, etc.) <br>3. **Configuration** (can define @Beans here too). |

---

## Quick Tips & Best Practices
- **Constructor Injection** is superior to field injection because it makes dependencies explicit and allows for `final` fields (immutability).
- Use `@Primary` for your "default" implementation and `@Qualifier` when you need to be specific.
- **Bean Naming**: By default, Spring uses the camelCase method name or class name as the Bean ID.
- **Scopes**: 
    - `singleton`: Shared instance (Stateless beans).
    - `prototype`: New instance every time (Stateful beans).
    - `request` / `session`: Web-specific scopes for per-request or per-user data.