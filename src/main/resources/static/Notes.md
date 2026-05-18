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

| Annotation | Purpose |
|---|---|
| `@Autowired` | Automatically injects dependencies/beans. Usually used with constructor injection. |
| `@Primary` | Marks a bean as the default bean when multiple beans of the same type exist. |
| `@Qualifier` | Selects a specific bean by name when multiple beans exist. |

---

# Quick Mental Model

| Layer | Common Annotation |
|---|---|
| Web Layer | `@Controller` |
| Business Logic | `@Service` |
| Database Layer | `@Repository` |
| Generic Helper Bean | `@Component` |