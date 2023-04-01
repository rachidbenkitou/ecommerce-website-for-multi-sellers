package com.ecommerce.Property.service;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ecommerce.Product.Product;
import com.ecommerce.Product.ProductRepository;
import com.ecommerce.Product.exceptions.ProductNotFoundException;
import com.ecommerce.Property.ProductProperty;
import com.ecommerce.Property.ProductPropertyRepository;
import com.ecommerce.Property.Property;
import com.ecommerce.Property.PropertyDto;
import com.ecommerce.Property.PropertyMapper;
import com.ecommerce.Property.PropertyRepository;
import com.ecommerce.Property.PropertyRequest;
import com.ecommerce.Property.Exception.ProductNotHaveAnyProperty;
import com.ecommerce.Property.Exception.ProductNotHaveValueException;
import com.ecommerce.Property.Exception.PropertyNotFoundException;

@Service
@Transactional
public class PropertyServiceImp implements PropertyService {

	private ProductRepository productRepository;
	
	private PropertyMapper propertyMapper;
	
	private ProductPropertyRepository productPropertyRepository;
	
	private PropertyRepository propertyRepository;

	public PropertyServiceImp(ProductRepository productRepository, 
			PropertyMapper propertyMapper,
			ProductPropertyRepository productPropertyRepository,
			PropertyRepository propertyRepository
			) {
		super();
		this.productRepository = productRepository;
		this.propertyMapper=propertyMapper;
		this.productPropertyRepository=productPropertyRepository;
		this.propertyRepository=propertyRepository;
	}

	@Override
	public List<PropertyDto> getPropertysAndValues(String nameProduct) {
		Product product=productRepository.findByProductName(nameProduct).orElseThrow(()->new ProductNotFoundException("product not found"));
		return propertyMapper.ProductproperstyToDtos(productPropertyRepository.findByProductId(product.getId())
				.orElseThrow(()-> new ProductNotHaveAnyProperty("Product not have any Property")));
	}

	@Override
	public Set<String> getPropertsProduct(String nameProduct) {

		Product product= productRepository.findByProductName(nameProduct)
				.orElseThrow(()->new ProductNotFoundException("product not found"));
		return productPropertyRepository.findByProductId(product.getId())
				.orElseThrow(()-> new ProductNotHaveAnyProperty("Product not have any Property"))
				.stream().map((p)->p.getProperty().getPropertyName())
				.collect(Collectors.toSet());
	}

	@Override
	public Set<String> getValuesProperty(String propertyName) {
		Property property= propertyRepository.findByPropertyName(propertyName)
				.orElseThrow(()->new ProductNotFoundException("product not found"));
		return productPropertyRepository.findByPropertyPropertyId(property.getPropertyId())
				.orElseThrow(()-> new ProductNotHaveAnyProperty("Product not have any Property"))
				.stream().map((p)->p.getValue()).collect(Collectors.toSet());
	}

	@Override
	public List<PropertyDto> addPropertyToProduct(PropertyRequest propertyRequest) {
		
		Property property=propertyRepository.findByPropertyName(propertyRequest.propertyName()).orElse(
				propertyRepository.save(Property.builder()
						.propertyName(propertyRequest.propertyName())
						.build())
				);
		
		if(!productRepository.existsByProductName(propertyRequest.productName()))throw new ProductNotFoundException("product not found");
		
		Product product=productRepository.findByProductName(propertyRequest.productName()).get();
		
		return propertyRequest.values().stream().map((v)->{
			ProductProperty productProperty=ProductProperty.builder()
					.property(property)
					.product(product)
					.value(v)
					.build();
			return propertyMapper.ProductpropertyToDto(productPropertyRepository.save(productProperty));
		}).toList();
	}

	@Override
	public PropertyDto updatePropertyProduct(String idProductProperty, String newValue) {
		ProductProperty productProperty=productPropertyRepository.findById(idProductProperty)
				.orElseThrow(()->new ProductNotHaveValueException("this Product not have this value"));
		productProperty.setValue(newValue);
		
		return propertyMapper.ProductpropertyToDto(productPropertyRepository.save(productProperty));
	}

	@Override
	public boolean deletePropertyFromProduct(String nameProperty,  String nameProduct) {

		 productPropertyRepository.deleteByProductAndProperty(
				productRepository.findByProductName(nameProduct)
				.orElseThrow(()->new ProductNotFoundException("product not found")), 
				propertyRepository.findByPropertyName(nameProperty)
				.orElseThrow(()->new PropertyNotFoundException("property not found"))
				
				);
		 return true;
	}

	@Override
	public boolean deleteteValueFromProcutProperty(String nameProductProperty) {
		
		 productPropertyRepository.deleteById(nameProductProperty);
		 return true;
	}

	



}
