# Spring Annotations — Quick Reminder

## Core Spring Annotations

| Annotation | Purpose |
|---|---|
| `@SpringBootApplication` | Main Spring Boot application annotation. Enables auto-configuration and component scanning. |
| `@Controller` | Handles web requests and returns views/pages. |
| `@Service("name")` | Business logic layer bean. Optional name can be used for bean selection. |
| `@Repository` | Database/data access layer. Used for repositories and DAOs. |
| `@Component` | Generic Spring-managed bean. Base annotation for all Spring beans. |
| `@RequestMapping` | Maps URLs/endpoints to controller methods or classes. |
| `@Value` | Injects values from `application.properties` or environment variables. |

---

# Bean & Dependency Injection

| Annotation       | Purpose                                                                                 |
|------------------|-----------------------------------------------------------------------------------------|
| `@Autowired`     | Automatically injects dependencies/beans. Usually used with constructor injection.      |
| `@Primary`       | Marks a bean as the default bean when multiple beans of the same type exist.            |
| `@Qualifier`     | Selects a specific bean by name when multiple beans exist.                              |
| `@Bean`          | identifies the method as a bean (method should be noun and it initialize                |
| `@Lazy`          | Make a bean or a component LAZY (not loading untill needed                              |
| `@Scope`         | Defines the scope / lifecycle of a bean. (e.g., singleton, prototype, request, session) |
| `@Configuration` | Marks a class as a Spring configuration class.                                          |
| `@PostConstruct` | Mark method as a post-construct method (once bean created , do something quickly        |
| `@PreDestroy`    | Mark method as a pre-destroy method (before bean destroyed, cleanup resources, etc.)    |
---

# Quick Mental Model

| Layer | Common Annotation |
|---|---|
| Web Layer | `@Controller` |
| Business Logic | `@Service` |
| Database Layer | `@Repository` |
| Generic Helper Bean | `@Component` |