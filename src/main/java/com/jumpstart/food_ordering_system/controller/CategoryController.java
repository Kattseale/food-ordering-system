package com.jumpstart.food_ordering_system.controller;

import com.jumpstart.food_ordering_system.dto.CategoryDto;
import com.jumpstart.food_ordering_system.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }
    @PostMapping
    public ResponseEntity<CategoryDto> addCategory(
            @RequestBody CategoryDto dto) {

        CategoryDto savedCategory =
                categoryService.addCategory(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedCategory);
    }
}