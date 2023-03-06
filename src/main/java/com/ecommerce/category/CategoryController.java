package com.ecommerce.category;

import com.ecommerce.category.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
@Tag(name="Category Controller")
public class CategoryController {
    private final CategoryService categoryService;

    @Operation(summary = "Find the entire categories", description = "This method allows you to find all categories and returns a list of CategoryDto objects.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the categories of objects were found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))})
    })
    @GetMapping("/all")
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }
    @Operation(summary = "Find the categories by name", description = "This method allows you to find the categories by name and returns a list of CategoryDto objects.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the categories of objects were found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))})
    })
    @GetMapping("/find/name/{categoryName}")
    public ResponseEntity<List<CategoryDto>> getCategoriesByName(@PathVariable String categoryName){
        return new ResponseEntity<>(categoryService.getCategoriesByName(categoryName), HttpStatus.OK);
    }
    @Operation(summary = "Save a category", description = "this method allows you to save a category.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the category object created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))})
    })
    @PostMapping("/save")
    public ResponseEntity<CategoryDto> saveCategory(@RequestBody CategoryDto categoryDto){
        return new ResponseEntity<>(categoryService.saveCategory(categoryDto), HttpStatus.CREATED);
    }
    @Operation(summary = "Update a category", description = "this method allows you to update a category.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the category object updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))})
    })
    @PutMapping("/update/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto){
        return new ResponseEntity<>(categoryService.updateCategory(categoryDto), HttpStatus.OK);
    }
    @Operation(summary = "delete a category", description = "this method allows you to delete a category by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the category object deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))})
    })
    @DeleteMapping("/delete/{categoryName}")
    public ResponseEntity<?> deleteCategoryByName(@PathVariable String categoryName){
        categoryService.deleteCategoryByName(categoryName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
