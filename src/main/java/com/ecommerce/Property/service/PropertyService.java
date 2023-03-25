package com.ecommerce.Property.service;

import java.util.List;

import com.ecommerce.Property.Property;
import com.ecommerce.Property.PropertyDto;
import com.ecommerce.Property.PropertyRequest;

public interface PropertyService {

	 List<PropertyDto> getPropertysValues(Long idProduct);
	 
	 List<String> getPropertsProduct(Long idProdut);
	 
	 List<String> getValuesProperty(String PropertyName);
	 
	 Property addPropertyToProduct(PropertyRequest propertyRequest);
	 
	 PropertyDto updatePropertyProduct(Long idProductProperty,String newValue);
	 
	 boolean deletePropertyFromProduct(Short idProperty,Long idProduct);
	 
	 boolean deleteteValueFromProcutProperty(Long idProductProperty);
	 
	 
}
