package com.ecommerce.Product;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Product.Service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
@RestController
@RequestMapping("/product")
@AllArgsConstructor
@Tag(name = "Product Controller")
public class ProductController {

	private final ProductService productService;
	
	@GetMapping("/name/{nameProduct}")
	@Operation(summary = "Get product by name", description = "Get a product by its name")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Product found",
					content = @Content(schema = @Schema(implementation = ProductDto.class))),
			@ApiResponse(responseCode = "404", description = "Product not found",
					content = @Content)
	})
    public ResponseEntity<ProductDto> getProductByName(@PathVariable String nameProduct) {
    	return new ResponseEntity<ProductDto>(productService.getProductByName(nameProduct),HttpStatus.OK);
    }
	
	@GetMapping("/subGategory/{subCategoryName}")
	@Operation(summary = "Get products by subcategory", description = "Get products by their subcategory")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Products found",
					content = @Content(array = @ArraySchema(schema = @Schema(implementation = ProductDto.class)))),
			@ApiResponse(responseCode = "404", description = "Products not found",
					content = @Content)
	})
	public ResponseEntity<List<ProductDto>> getProductByCategories(@PathVariable String subCategoryName){
		return new ResponseEntity<List<ProductDto>>(productService.getProductByCategories(subCategoryName),HttpStatus.OK);
	}
	
    @PostMapping("/save")
	@Operation(summary = "Save a new product", description = "Save a new product")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Product saved",
					content = @Content(schema = @Schema(implementation = ProductDto.class)))
	})
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto){
    	return new ResponseEntity<ProductDto>(productService.AddProduct(productDto),HttpStatus.OK) ;
    }
    
    @PutMapping("/update/{productName}")
	@Operation(summary = "Update a product", description = "Update an existing product by its name")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Product updated",
					content = @Content(schema = @Schema(implementation = ProductDto.class))),
			@ApiResponse(responseCode = "404", description = "Product not found",
					content = @Content)
	})
    public ResponseEntity<ProductDto> updateProduct(@PathVariable String productName,@RequestBody ProductDto productDto){
    	return new ResponseEntity<ProductDto>(productService.updateProduct(productName, productDto),HttpStatus.OK);
    }
    
    @PutMapping("seller/{productName}")
	@Operation(summary = "Seller a product", description = "Increase the quantity of a product by its name")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Product quantity updated",
					content = @Content(schema = @Schema(implementation = ProductDto.class))),
			@ApiResponse(responseCode = "404", description = "Product not found",
					content = @Content)
	})
    ResponseEntity<ProductDto> sellerProduct(@PathVariable String productName,@RequestParam Integer quantitySeller){
    	return new ResponseEntity<ProductDto>(productService.sellerProduct(productName, quantitySeller),HttpStatus.OK);
    }
    
    @DeleteMapping("delete/{productName}")
	@Operation(summary = "Delete a product", description = "Delete a product by its name")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Product deleted",
					content = @Content),
			@ApiResponse(responseCode = "404", description = "Product not found")})

    ResponseEntity<?> deleteProduct(@PathVariable String productName){
        productService.deleteProduct(productName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
