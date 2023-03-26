package com.ecommerce.Property.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ecommerce.Product.Product;
import com.ecommerce.Product.ProductRepository;
import com.ecommerce.Property.ProductProperty;
import com.ecommerce.Property.ProductPropertyRepository;
import com.ecommerce.Property.Property;
import com.ecommerce.Property.PropertyDto;
import com.ecommerce.Property.PropertyMapper;
import com.ecommerce.Property.PropertyRepository;
import com.ecommerce.Property.PropertyRequest;

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
	public List<PropertyDto> getPropertysValues(Long idProduct) {
		
		Product product =Product.builder()
				.productId(idProduct)
				.build();
		
		List<ProductProperty> productProperties=productPropertyRepository.findAllByProduct(product).orElseThrow(()->new RuntimeException("this product not has any Property"));
		
		return propertyMapper.ProductproperstyToDtos(productProperties);
	}

	@Override
	public List<String> getPropertsProduct(Long idProdut) {

		return productRepository.findById(idProdut).
				orElseThrow(()->new RuntimeException("product not found"))
				.getProductPropertyts().stream().map((p)->p.getProduct().getProductName())
				.toList();
	}

	@Override
	public List<String> getValuesProperty(String propertyName) {

		return propertyRepository.findByPropertyName(propertyName).orElse(null)
				.getProductProperties()
				.stream().map((p)->p.getValue()).toList();
	}

	@Override
	public Property addPropertyToProduct(PropertyRequest propertyRequest) {
		
		Property property=propertyRepository.findByPropertyName(propertyRequest.nameProperty()).orElse(
				propertyRepository.save(Property.builder()
						.propertyName(propertyRequest.nameProperty())
						.build())
				);
				
				
		
		Product product=productRepository.findById(propertyRequest.idProduct()).orElseThrow(()->new RuntimeException("product not found"));
		for (String value: propertyRequest.values()) {
			ProductProperty productProperty=ProductProperty.builder()
					.property(property)
					.product(product)
					.value(value)
					.build();
			property.getProductProperties().add(productProperty);
		}
		
		return propertyRepository.save(property);
	}

	@Override
	public PropertyDto updatePropertyProduct(Long idProductProperty, String newValue) {
		ProductProperty productProperty=productPropertyRepository.findById(idProductProperty).get();
		productProperty.setValue(newValue);
		
		return propertyMapper.ProductpropertyToDto(productPropertyRepository.save(productProperty));
	}

	@Override
	public boolean deletePropertyFromProduct(Short idProperty,  Long idProduct) {

		return productPropertyRepository.deleteAllByProductAndProperty(
				productRepository.findById(idProduct).get(), 
				propertyRepository.findById(idProperty).get()
				);
	}

	@Override
	public boolean deleteteValueFromProcutProperty(Long idProductProperty) {
		// TODO Auto-generated method stub
		 productPropertyRepository.deleteById(idProductProperty);
		 return true;
	}

	



}
