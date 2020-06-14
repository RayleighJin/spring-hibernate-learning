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

   _@RequestMapping("/")_

   Get request parameters with either _req.getParameter("param name")_ 

   or 

   passing the param as _@RequestParam("param name") String method_param_name_

4. Return View name 无后缀

5. Develop View page

__Request Mapping__

Can be of Parent-Child like mode

__Validation__

1. Add validation rule to the class
2. Display error message on HTML form
3. Perform validation in the Controller class

_@InitBinder_ works as a pre-processor for all web requests coming to the Controller

dataBinder.registerCustomEditor();

__Custom Validation__

```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

	// define default course code
	public String value() default "EECS";
	
	// define default error message
	public String message() default "must start with EECS";
	
	// define default groups
	public Class<?>[] groups() default {};
	
	// define default payloads
	public Class<? extends Payload>[] payload() default {};
}
```

```java
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator
	implements ConstraintValidator<CourseCode, String> {
	
	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode courseCode) {
		coursePrefix = courseCode.value();
	}
	
	@Override
	public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
		
    boolean result = true;
   
		if (code == null) {
			return result;
		}
		result = code.startsWith(coursePrefix);
		return result;
	}	
}
```



# Hibernate - Note 

![Hibernate_func](/Users/hao/Personal Projects/Spring-Learn/pic/Hibernate_func.png)

Hibernate works as a connection between Java program and Database

Hibernate uses JDBC in the background to do all the low level work

__ORM__ Object Relational Mapping

1. Add Hibernate config file
2. Annotate Java classes (for mapping)
   1. Map class to database table _@Entity @Table(name="table name")_
   2. Map field to table column _@Id_ (for primary key) _@Column(name="col name")_
3. Develop Java code to perform database operations

__Entity Class__ is a Java class that is mapped to a database table

__HQL__ Hibernate Query Language, a SQL like query language, but should use Java property name instead of database column name

__CRUD__ Create/Read/Update/Delete

## Mapping

### One to One

Can have more tha one strategy using _cascade={CascadeType.MERGE, CascadeType.REFRESH}_

```java
/*
Instructor Class
*/
@OneToOne(cascade = CascadeType.ALL) // specify cascade type
@JoinColumn(name="instructor_detail_id") // name here is the foreign key 只有外键(下面定义的dield)才有这个annotation
private InstructorDetail instructorDetail; // the referenced entity
```

```java
/*
Main App
*/
System.out.println(">> Details of the Instructor: " + instructor.getInstructorDetail());
```

Double the steps above in _InstructorDetail_ class to create __Bi-Directional__ one to one mapping

```java
/*
InstructorDetail Class
*/
@OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
private Instructor instructor;
```

```java
/*
Main App
*/
System.out.println(">> Associated Instructor: " + instructorDetail.getInstructor());
```

Handle leak error

```java
/*
Main App
*/
try {
  session.beginTransaction();
  // do some work
  session.getTransaction().commit();
}
catch (Exception e) {
  e.printStackTrace();
}
finally {
  session.close(); // close the session to prevent the leak
  factory.close();
}
```

### One to Many

```java
/*
City Class
*/
@OneToMany(mappedBy="city") // 一个城市有多个大学，所以mapped by城市，亦即mapped by ONE(to前面那个)
@Cascade(CascadeType.ALL)
private List<College> college;
```

### Eager Loading & Lazy Loading

__Eager__ helps to pre-fetch

__Lazy__ fetches when demanded

### Many to Many

__Inverse__ refers to the other side of the relationship

```java
/*
Student Class
*/
@ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                       CascadeType.PERSIST, CascadeType.REFRESH})
@JoinTable(name="course_student",
           joinColumns = @JoinColumn(name="student_id"),
           inverseJoinColumns = @JoinColumn(name="course_id")) // the other side is the course table
private List<Course> courses;
```

```java
/*
Course Class
*/
@ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                       CascadeType.PERSIST, CascadeType.REFRESH})
@JoinTable(name="course_student",
           joinColumns = @JoinColumn(name="course_id"),
           inverseJoinColumns = @JoinColumn(name="student_id")) // the other side is the student table
private List<Student> students;
```

