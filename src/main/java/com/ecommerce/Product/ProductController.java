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
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Product.Service.ProductService;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
@Tag(name = "Product Controller")
public class ProductController {

	private final ProductService productService;
	
	@GetMapping("/name/{nameProduct}")
    public ResponseEntity<ProductDto> getProductByName(@PathVariable String nameProduct) {
    	return new ResponseEntity<ProductDto>(productService.getProductByName(nameProduct),HttpStatus.OK);
    }
	
	@GetMapping("/subGategory/{subCategoryName}")
	public ResponseEntity<List<ProductDto>> getProductByCategories(@PathVariable String subCategoryName){
		return new ResponseEntity<List<ProductDto>>(productService.getProductByCategories(subCategoryName),HttpStatus.OK);
	}
	
    @PostMapping("/save")
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto){
    	return new ResponseEntity<ProductDto>(productService.AddProduct(productDto),HttpStatus.OK) ;
    }
    
    @PutMapping("/update/{productName}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable String productName,@RequestBody ProductDto productDto){
    	return new ResponseEntity<ProductDto>(productService.updateProduct(productName, productDto),HttpStatus.OK);
    	
    }
    
    @PutMapping("seller/{productName}")
    ResponseEntity<ProductDto> sellerProduct(String productName,Integer quantitySeller){
    	return new ResponseEntity<ProductDto>(productService.sellerProduct(productName, quantitySeller),HttpStatus.OK);
    }
    
    @DeleteMapping("delete/{productName}")
    ResponseEntity<?> deleteProduct(@PathVariable String productName){
    	productService.deleteProduct(productName);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
	
}
