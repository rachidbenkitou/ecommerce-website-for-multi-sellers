package com.ecommerce.category;

import com.ecommerce.category.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }
    @GetMapping("/find/name/{categoryName}")
    public ResponseEntity<List<CategoryDto>> getCategoriesByName(@PathVariable String categoryName){
        return new ResponseEntity<>(categoryService.getCategoriesByName(categoryName), HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<CategoryDto> saveCategory(@RequestBody CategoryDto categoryDto){
        return new ResponseEntity<>(categoryService.saveCategory(categoryDto), HttpStatus.CREATED);
    }
    @PutMapping("/update/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto){
        return new ResponseEntity<>(categoryService.updateCategory(categoryDto), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{categoryName}")
    public ResponseEntity<?> deleteCategoryByName(@PathVariable String categoryName){
        categoryService.deleteCategoryByName(categoryName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
