package com.ecommerce.Property;

import java.util.List;
import java.util.Set;

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

import com.ecommerce.Product.ProductDto;
import com.ecommerce.Property.service.PropertyService;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import io.swagger.v3.oas.annotations.media.Content;
@RestController
@RequestMapping("/property")
@AllArgsConstructor
@Tag(name = "Property Controller")
public class PropertyContoller {

    private final PropertyService propertyService;
    
    @GetMapping("/getPropertyvaluesProduct/{nameProduct}")
    @Operation(summary = "Get all properties and their values for a given product name")
    @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PropertyDto.class)))
    public ResponseEntity<List<PropertyDto>> getPropertysAndValues(@PathVariable String nameProduct){
        return new ResponseEntity<List<PropertyDto>>(propertyService.getPropertysAndValues(nameProduct),HttpStatus.OK);
    }
    
    @GetMapping("/getPropertsProduct/{nameProduct}")
    @Operation(summary = "Get all properties for a given product name")
    @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Set.class)))
    public ResponseEntity<Set<String>> getPropertsProduct(@PathVariable String nameProduct){
        return new ResponseEntity<Set<String>>(propertyService.getPropertsProduct(nameProduct),HttpStatus.OK);
    }
    
    @GetMapping("/getValuesProperty/{propertyName}")
    @Operation(summary = "Get all values for a given property name")
    @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Set.class)))
    public ResponseEntity<Set<String>> getValuesProperty(@PathVariable String propertyName){
        return new ResponseEntity<Set<String>>(propertyService.getValuesProperty(propertyName),HttpStatus.OK);
    }
    
    @PostMapping("/addPropertyToPruct")
    @Operation(summary = "Add a new property to a product")
    @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PropertyDto.class)))
    public ResponseEntity<List<PropertyDto>> addPropertyToProduct(@RequestBody PropertyRequest propertyRequest){
        return new ResponseEntity<List<PropertyDto>>(propertyService.addPropertyToProduct(propertyRequest),HttpStatus.OK);
    }
    
    @PutMapping("/updatePropertyProduct/{idProductProperty}")
    @Operation(summary = "Update the value of a property for a given product")
    @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PropertyDto.class)))
    public ResponseEntity<PropertyDto> updatePropertyProduct(@PathVariable String idProductProperty, @RequestParam String newValue){
        return new ResponseEntity<PropertyDto>(propertyService.updatePropertyProduct(idProductProperty, newValue),HttpStatus.OK);
    }
    
    @DeleteMapping("/deletePropertyFromProduct")
    @Operation(summary = "Delete a property from a product")
    @ApiResponse(responseCode = "200", description = "Success")
    public ResponseEntity<?> deletePropertyFromProduct(String nameProperty,String nameProduct){
        propertyService.deletePropertyFromProduct(nameProperty, nameProduct);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteteValueFromProcutProperty/{idProductProperty}")
    @Operation(summary = "Delete a value from a product property")
    @ApiResponse(responseCode = "200", description = "Success")
    public ResponseEntity<?> deleteteValueFromProcutProperty(@PathVariable String idProductProperty){
        propertyService.deleteteValueFromProcutProperty(idProductProperty);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
