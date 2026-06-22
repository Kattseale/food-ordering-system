**RESEARCH**

1. What is a Java generic type? Why is <T> useful?
A Java generic is a class or interface thag is parameterized over types, allowing to pass data types as arguments, like passing values to methods. This allows a single class,
interface or method to operate safely on many different data types.
<T> is a placeholder for a type that is specified when the class or method is used. It helps reduce code duplication and prevents type-casting errors.

2. What does Lombok @Builder generate behind the scenes?
@Builder generates a builder class with methods for setting each field and a build() method that creates the object. It adds a static builder() method to start the building process.

3. What is the Builder design pattern? When to use it?
The Builder pattern is a way of creating objects step by step instead of using large constructors. We use it when a class has many fields, especially optional fields, because it makes
code easier to read and maintain.

4. What is LocalDateTime? How is it different from Date?
LocalDateTime is a Java 8 date and time class that stores both date and time without a timezone. It's part of the modern Java Date-Time API.

5. Why does a consistent response format matter to frontend developers?
A consistent response format makes it easier for frontend applications to process API responses. Developers always know where to find the status, message, and data, which reduces bugs
and simplifies error handling.

6. What does @JsonInclude(JsonInclude.Include.NON_NULL) do?
It tells Jackson to exclude fields that null values when converting an object to JSON. This keeps responses cleaner and removes unnecessary fields.

7. What is a static factory method? Why use Response.success(...) instead of new Response<>()?
A static factory is a static method that creates and returns an object. It provides a clear and controlled way to create instances.
Response.success("Category retrieved",dto); instead of
new Response<>(200, "Category retrieved",dto,LocalDateTime.now());