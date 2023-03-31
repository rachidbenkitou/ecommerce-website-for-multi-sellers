package com.ecommerce.Property.service;

import java.util.List;
import java.util.Set;

import com.ecommerce.Property.PropertyDto;
import com.ecommerce.Property.PropertyRequest;

public interface PropertyService {

	 List<PropertyDto> getPropertysAndValues(String nameProduct);
	 
	 Set<String> getPropertsProduct(String nameProduct);
	 
	 Set<String> getValuesProperty(String PropertyName);
	 
	 List<PropertyDto> addPropertyToProduct(PropertyRequest propertyRequest);
	 
	 PropertyDto updatePropertyProduct(String idProductProperty,String newValue);
	 
	 boolean deletePropertyFromProduct(String nameProperty,String nameProduct);
	 
	 boolean deleteteValueFromProcutProperty(String idProductProperty);
	 
	 
}
