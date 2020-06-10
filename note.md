# Spring - Note

## IoC - Inversion of Control

* What is Ioc Inversion of Control?

  The approach of outsourcing the construction and management of objects.

* What is Spring Bean?

  A "Spring Bean" is simply a Java object.

  When Java objects are created by the Spring Container, then Spring refers to them as "Spring Beans".

  Spring Beans are created from normal Java classes .... just like Java objects.

  由Spring容器创造的对象

## DI - Dependency Injection

* What is Dependency Injection?

## Annotations Config

Meta-data about a class

### IoC

Spring would scan Java classes for special annotations, and automatically register the beans in Spring container

1. Enable component scannint in Spring config file
2. Add *@Component("bean ID")* annotations to Java classes
3. Retrieve bean from Spring container

Class name: KendoCoach --> Default bean ID: kendoCoach

### DI 

_@Qualifier("bean ID")_ for multi implementation, but it should be inside the constructor parentheses when used in constructor case

__Constructor__

1. Define the dependency interface and class
2. Create a constructor for injection
3. Configure the dependency injection with _@Autowired_ annotation

Spring would scan for a component that implements FortuneService interface, create an instance of it and inject it to TennisCoach

__Any Method__

Mostly setter method

1. Create setter method in the class for injections
2. Configure the dependency injection with *@Autowired* annotation

__Field__

Which injection type to use? Choose one and stay consistent 

### Scope 

_@Scope("singleton")_ all requests share one object

_@Scope("prototype")_ creates a new object for each request

### Lifecycle

_@PostConstruct_

_@PreDestroy_

## Java Config

1. Create a Java class and annotate as _@Configuration_
2. Add component scanning support _@ComponentScan("package name")_ (optional)
3. Read Spring Java configuration class
4. Retrieve bean from Spring container

__Define beans with Java code__

1. Define method to expose bean _@Bean_, the method name would be the bean ID
2. Inject bean dependencies
3. Read Spring Java configuration class
4. Retrieve bean from Spring container

__Injecting values__

1. Load property file with _@PropertySource("classpath:filename")_

2. Reference values with _@Value("${property id}")_

# Spring MVC - Note 

![SpringMVC_arch](/Users/hao/Personal Projects/Spring-Learn/pic/SpringMVC_arch.png)

Front Controller already built by Spring

__Model__

* Contains the data
* Store/retrieve data via backend systems
* Place the data in the model

__View Template__

* Most common is JSP + JSTL, there are also many else e.g. Thymeleaf, Groovy, etc
* Model data comes over to view template and JSP page can read the model data and display it

__Steps__

1. Create Controller class

   Annotate class with _@Controller_, which inherits from _@Component_ supporting scanning

2. Define Controller method

3. Add request mapping to Controller method

   _@RequestMappint("/")_

4. Return View name 无后缀

5. Develop View page

# Hibernate - Note 