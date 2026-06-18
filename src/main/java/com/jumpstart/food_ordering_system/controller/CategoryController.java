package com.jumpstart.food_ordering_system.controller;

import com.jumpstart.food_ordering_system.response.Response;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import jakarta.validation.Valid;
import com.jumpstart.food_ordering_system.dto.CategoryDto;
import com.jumpstart.food_ordering_system.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<Response<List<CategoryDto>>> getAllCategories() {

        List<CategoryDto> categories =
                categoryService.getAllCategories();

        return ResponseEntity.ok(
                Response.success(
                        "Categories retrieved",
                        categories
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<CategoryDto>> getCategoryById(
            @PathVariable Long id) {

        CategoryDto dto =
                categoryService.getCategoryById(id);

        return ResponseEntity.ok(
                Response.success(
                        "Category retrieved",
                        dto
                )
        );
    }

    @PostMapping
    public ResponseEntity<Response<CategoryDto>> addCategory(
            @Valid @RequestBody CategoryDto dto) {

        CategoryDto savedCategory =
                categoryService.addCategory(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        Response.success(
                                "Category created successfully",
                                savedCategory
                        )
                );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<CategoryDto>> updateCategory(
            @PathVariable Long id,
            @RequestBody CategoryDto dto) {

        CategoryDto updatedCategory =
                categoryService.updateCategory(id, dto);

        return ResponseEntity.ok(
                Response.success(
                        "Category updated successfully",
                        updatedCategory
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Void>> deleteCategory(
            @PathVariable Long id) {

        categoryService.deleteCategory(id);

        return ResponseEntity.ok(
                Response.success(
                        "Category deleted successfully",
                        null
                )
        );
    }
}
