package com.ecommerce.Product;

import java.util.List;

import com.ecommerce.Property.PropertyDto;
import com.ecommerce.subCategory.SubCategoryDto;

public record ProductDto(
		String productName,
		Integer productQuantity,
		Float prodcutPrice,
		List<PropertyDto> propertys,
		SubCategoryDto SubCatergory){

}
