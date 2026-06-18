**2. CONCEPTS OF RESEARCH**

1. What does CRUD stand for?
CRUD stands for Create, Read, Update, Delete.

2. Difference between HTTP methods POST, PUT, PATCH, DELETE?
Post - used to send data to the server to create a new resource.
Put - to completely replace an existing resource or create it if it does not exist.
Patch - used to modify an existing resource.
Delete - to completely remove an existing resource from the server.

3. Give the correct HTTP status code for each:
a. A new category was created - 201 Created

b. A category was deleted successfully - 204 No Content

c. The id requested does not exist - 404 Not Found

d. The request body is missing a required field - 400 Bad Request

e. The user is logged in but not allowed - 403 Forbidden

4. Difference between @RequestBody, @RequestParam,
@PathVariable - with one tiny example of each.
- @RequestBody - is used to request data from the HTTP request body.
   @PostMapping
   public CategoryDto addCategory(
   @RequestBody CategoryDto dto) {
   return categoryService.addCategory(dto);
   }
JSON: {
   "name": "Burger"
   }
- @RequestParam - used to read values from query parameters.
  @GetMapping("/search")
  public String search(
  @RequestParam String name) {
  return name;
  }
URL:
  /api/categories/search?name=Pizza

- @PathVariable - used to read values directly from url path.
  @GetMapping("/{id}")
  public CategoryDto getCategoryById(
  @PathVariable Long id) {
  return categoryService.getCategoryById(id);
  }
URL:
  /api/categories/1

5. What is Jakarta Bean Validation? Explain @Valid,
@NotBlank, @Size.
Jakarta Bean Validation  is a framework used to validate data before it is processed by the application to ensure that incoming data meets defined rules.
- @Valid - triggers validation on an object received by the controller.
public ResponseEntity<CategoryDto> addCategory(
   @Valid @RequestBody CategoryDto dto)
- @NotBlank - makes sure a string is not null, empty, or only spaces.
@NotBlank(message = "Category name is required")
private String name;
- @Size - restricts the minimum and maximum length of a field.
  @Size(min = 2, max = 50)
  private String name;

6. Why return a DTO and not the entity itself? Give 2
reasons. 
- Separating of concerns - DTO's allow the API response format to be different from the database structure, making it easier to change the database without affecting API consumers.

- Security - a DTO prevents exposing internal database fields that should not be visible to users.

7. What is Optional<T>? Why does findById return Optional?
   This helps avoid NullPointerException by forcing developers to handle the case where a value does not exist.
   Optional<Category> category =
   categoryRepository.findById(id);