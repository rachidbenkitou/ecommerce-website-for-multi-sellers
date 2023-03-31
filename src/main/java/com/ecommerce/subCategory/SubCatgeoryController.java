package com.ecommerce.subCategory;

import com.ecommerce.subCategory.service.SubCategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subCategory")
@AllArgsConstructor
@Tag(name="SubCategory Controller")
public class SubCatgeoryController {
    private final SubCategoryService subCategoryService;

    @Operation(summary = "Find the entire subCategories", description = "This method allows you to find all subCategories and returns a list of SubCategoryDto objects.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the subCategories of objects were found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SubCategoryDto.class))})
    })
    @GetMapping("/all")
    public ResponseEntity<List<SubCategoryDto>> getAllsubCategories(){
        return new ResponseEntity<>(subCategoryService.getAllSubCategories(), HttpStatus.OK);
    }
    @Operation(summary = "Find the subCategories by name", description = "This method allows you to find the subCategories by name and returns a list of SubCategoryDto objects.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the subCategories of objects were found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SubCategoryDto.class))})
    })
    @GetMapping("/find/name/{subCategoryName}")
    public ResponseEntity<List<SubCategoryDto>> getsubCategoriesByName(@PathVariable String subCategoryName){
        return new ResponseEntity<>(subCategoryService.getSubCategoriesByName(subCategoryName), HttpStatus.OK);
    }
    @Operation(summary = "Save a SubCategory", description = "this method allows you to save a SubCategory.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the SubCategory object created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SubCategoryDto.class))})
    })
    @PostMapping("/save")
    public ResponseEntity<SubCategoryDto> saveSubCategory(@RequestBody SubCategoryDto subCategoryDto){
        return new ResponseEntity<>(subCategoryService.saveSubCategory(subCategoryDto), HttpStatus.CREATED);
    }
    @Operation(summary = "Update a SubCategory", description = "this method allows you to update a SubCategory.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the SubCategory object updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SubCategoryDto.class))})
    })
    @PutMapping("/update/{subCategoryId}")
    public ResponseEntity<SubCategoryDto> updateSubCategory(@RequestBody SubCategoryDto subCategoryDto){
        return new ResponseEntity<>(subCategoryService.updateSubCategory(subCategoryDto), HttpStatus.OK);
    }
    @Operation(summary = "delete a SubCategory", description = "this method allows you to delete a SubCategory by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the SubCategory object deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SubCategoryDto.class))})
    })
    @DeleteMapping("/delete/{subCategoryName}")
    public ResponseEntity<?> deleteSubCategoryByName(@PathVariable String subCategoryName){
        subCategoryService.deleteSubCategoryByName(subCategoryName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @GetMapping("/find/subCategoryName/{categoryName}")
    public ResponseEntity<List<SubCategory>> getSubCategoriesByName(@PathVariable String categoryName){
        return new ResponseEntity<>(subCategoryRepository.findByCategoryCategoryId(categoryName), HttpStatus.OK);
    }
}
