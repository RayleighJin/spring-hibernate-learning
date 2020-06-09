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

## Annotations

Meta-data about a class

###IoC

Spring would scan Java classes for special annotations, and automatically register the beans in Spring container

1. Enable component scannint in Spring config file
2. Add *@Component("bean ID")* annotations to Java classes
3. Retrieve bean from Spring container

Class name: KendoCoach --> Default bean ID: kendoCoach

###DI 

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

_@PostConstruct("prototype")_ 

_@PreDestroy("prototype")_ 

#Spring MVC - Note 

#Hibernate - Note 