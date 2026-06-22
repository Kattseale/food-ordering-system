**RESEARCH**

Q1.  What is JPA? What is Hibernate? How are they related?
JPA (Java Persistence API) is a Java specification for managing data between Java objects and relational databases.
Hibernate is a framework that implements the JPA specification.

Q2.  What is the difference between @Entity and @Table?
@Entity marks a Java class as a database entity that Hibernate should manage. 
@Entity
public class Menu{
}
Table specifies the database table name.
@Entity
@Table(name = "menus")
public class Menu {
}

Q3.  What is a foreign key? What is @ManyToOne? Give 2 real-world examples.
A foreign key is a column that links one table to another.
@ManyToOne indicates that many records belong to one parent record. Meaning many menus can belong to one category.
@ManyToOne
private Category category;
eg. Many employees belong to one department.
    Many students belong to one school.

Q4.  What does @JoinColumn(name = "category_id") do?
It tells Hibernate which database column stores the foreign key.

Q5.  Why store price as BigDecimal and not double?
Money requires exact precision. For financial data, BigDecimal avoids rounding errors. eg.
double total = 0.1 + 0.2;
= 0.30000000000000004 //Bad

BigDecimal total =
new BigDecimal("0.1")
.add(new BigDecimal("0.2"));
= 0.3 //Good

Q6.  What does FetchType LAZY vs EAGER mean? What is the default for @ManyToOne?

-Eager - loads related data immediately. When Menu is loaded, Category is loaded too.
@ManyToOne(fetch = FetchType.EAGER)

Lazy - related data only when needed. Category is fetched only when menu.getCategory() is called.
@ManyToOne(fetch = FetchType.LAZY)
Default for @ManyToOne. This is the JPA default.
FetchType.EAGER

Q7.  What is the N+1 query problem?
This happens when Hibernate executes too many database queries. It is a database performance bottleneck where an application executes N additional queries to
fetch related data after an initial query retrieves a list of N parent records. Instead of pulling all records data simultaneously, the application communicates 
with the database N+1 total times, causing severe latency and high server load.

Q8.  What is dependency injection? Constructor injection vs field injection — which is preferred and why?
Dependency Injection (DI) means Spring creates and supplies them where needed by injecting them automatically.
Construction Injection (CI) Dependencies are passed into the class via constructor.
Field Injection (FI) Dependencies are injected directly into the class fields via annotations, bypassing constructors or setters.
Constructor injection is widely preferred and considered the industry standard for production code. It is easier to test, recommended by Spring, dependencies are required at creation time.

Q9.  What does @RequiredArgsConstructor (Lombok) do?
It automatically generates a constructor for all final fields.This reduces boilerplate code.

Q10. What is the role of the SERVICE layer? Why must it be separate from the controller?
The Service layer contains business logic. It is the architectural middleman in software design, responsible for executing core business logic and orchestrating the flow of data. It stands between
the presentation layer (Controller) and the data access layer (Repository), translating raw inputs into actionable domain rules.

Q11. Why MUST you validate that categoryId exists before saving a menu?
To prevent invalid data. Validation ensures that Menu belongs to a real category, data remains consistent,users receive a meaningful error message.

Q12. Difference between save() and saveAndFlush()?
save() Saves the entity but Hibernate may delay writing to the database until later.
saveAndFlush() Saves automatically and forces Hibernate to execute SQL right away. Used when I need the database updated instantly before continuing.

Q13. Why write private mapper methods (entity <-> dto)?
Mapper methods convert between entities and DTOs. This avoids duplicated code, keeps controllers and services cleaner and separates database models from API models.