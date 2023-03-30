package com.ecommerce.Property;

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

import com.ecommerce.Product.ProductDto;
import com.ecommerce.Property.service.PropertyService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/property")
@AllArgsConstructor
@Tag(name = "Property Controller")
public class PropertyContoller {

	private final PropertyService propertyService;
	
	@GetMapping("/getPropertyvaluesProduct/{nameProduct}")
	public ResponseEntity<List<PropertyDto>> getPropertysAndValues(@PathVariable String nameProduct){
		return new ResponseEntity<List<PropertyDto>>(propertyService.getPropertysAndValues(nameProduct),HttpStatus.OK);
	}
	
	@GetMapping("/getPropertsProduct/{nameProduct}")
	public ResponseEntity<List<String>> getPropertsProduct(@PathVariable String nameProduct){
		return new ResponseEntity<List<String>>(propertyService.getPropertsProduct(nameProduct),HttpStatus.OK);
	}
	
	@GetMapping("/getValuesProperty/{propertyName}")
	public ResponseEntity<List<String>> getValuesProperty(@PathVariable String propertyName){
		return new ResponseEntity<List<String>>(propertyService.getValuesProperty(propertyName),HttpStatus.OK);
	}
	
	@PostMapping("/addPropertyToPruct")
	public ResponseEntity<List<PropertyDto>> addPropertyToProduct(PropertyRequest propertyRequest){
		return new ResponseEntity<List<PropertyDto>>(propertyService.addPropertyToProduct(propertyRequest),HttpStatus.OK);
	}
	
	@PutMapping("/updatePropertyProduct/{idProductProperty}")
	public ResponseEntity<PropertyDto> updatePropertyProduct(String idProductProperty,String newValue){
		return new ResponseEntity<PropertyDto>(propertyService.updatePropertyProduct(idProductProperty, newValue),HttpStatus.OK);
	}
	
	@DeleteMapping("/deletePropertyFromProduct")
	public ResponseEntity<?> deletePropertyFromProduct(@PathVariable String nameProperty,@RequestBody String nameProduct){
		propertyService.deletePropertyFromProduct(nameProperty, nameProduct);
		return new ResponseEntity<ProductDto>(HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteteValueFromProcutProperty/{idProductProperty}")
	public ResponseEntity<?> deleteteValueFromProcutProperty(@PathVariable String idProductProperty){
		propertyService.deleteteValueFromProcutProperty(idProductProperty);
		return new ResponseEntity<ProductDto>(HttpStatus.OK);
	}
}
