package com.ecommerce.Property;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PropertyMapperImp implements PropertyMapper{

	@Override
	public PropertyDto ProductpropertyToDto(ProductProperty productProperty) {
				
		PropertyDto dto= PropertyDto.builder()
				.idProdcutProperty(productProperty.getId())
				.namePropery(productProperty.getProperty().getPropertyName())
				.value(productProperty.getValue())
				.build();
		return dto;
	}

	@Override
	public List<PropertyDto> ProductproperstyToDtos(List<ProductProperty> productProperty) {
		// TODO Auto-generated method stub
		return productProperty.stream().map((pP)->ProductpropertyToDto(pP)).toList();
	}

}
