# Spring-Note

## IoC

1. What is Ioc Inversion of Control?

   The approach of outsourcing the construction and management of objects.

2. What is Spring Bean?

   A "Spring Bean" is simply a Java object.

   When Java objects are created by the Spring Container, then Spring refers to them as "Spring Beans".

   Spring Beans are created from normal Java classes .... just like Java objects.

   由Spring容器创造的对象

## Dependency Injection

1. What is Dependency Injection?

   

## Annotations

Meta-data about a class

Spring would scan Java classes for special annotations, and automatically register the beans in Spring container

1. Enable component scannint in Spring config file
2. Add @Component("bean ID") annotations to Java classes
3. Retrieve bean from Spring container

Class name: KendoCoach -> Default bean ID: kendoCoach