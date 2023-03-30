package com.ecommerce.Product;

import java.util.List;

import com.ecommerce.Property.PropertyDto;
import com.ecommerce.subCategory.SubCategoryDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductDto
		{
	String productName;
	Integer productQuantity;
	Float prodcutPrice;
	List<PropertyDto> propertys;
	SubCategoryDto subCatergory;

}
