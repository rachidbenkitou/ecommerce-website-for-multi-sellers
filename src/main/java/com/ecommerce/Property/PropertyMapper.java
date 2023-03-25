package com.ecommerce.Property;

import java.util.List;

public interface PropertyMapper {
   	PropertyDto ProductpropertyToDto(ProductProperty productProperty);
   	List<PropertyDto> ProductproperstyToDtos(List<ProductProperty> productProperty);

   	}
