package com.ecommerce.Property.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ecommerce.EcommerceApplication;
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
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = EcommerceApplication.class)
class PropertyServiceTest {
	
//	private AutoCloseable autoCloseable;
//	@Autowired
	
	private PropertyService propertyService;
//	@Autowired
	@Mock
	private ProductRepository productRepository;
	@Autowired
	private PropertyMapper  mapper;
//	@Autowired
	@Mock
	private ProductPropertyRepository productPropertyRepository;
//	@Autowired
	@Mock
	private PropertyRepository propertyRepository;
	
	
	
	private Property property1,property2;
	
	private ProductProperty productProperty1,productProperty2;
	
	private Product product1;
		
	@BeforeEach
	void SetUp(){
		
//		autoCloseable = MockitoAnnotations.openMocks(this);
		propertyService= new PropertyServiceImp(productRepository, mapper, productPropertyRepository, propertyRepository);
		
		
		property1=Property.builder()
				.propertyId("1")
				.propertyName("size")
//				.productProperties(new ArrayList<>(List.of(productProperty1)) )
				.build();

		property2=Property.builder()
//				.propertyId((short) 2)
				.propertyName("couleur")
//				.productProperties(List.of(productProperty2))
				.build();
		product1=Product.builder()
				.prodcutPrice((float) 32.2)
				.id(UUID.randomUUID().toString())
				.productName("Product 1")
				.productQuantity(32)
//				.productPropertyts(List.of(productProperty1))
				.build();
		
		 
		productProperty1=ProductProperty.builder()
				.id("1")
				.product(product1)
				.property(property1)
				.value("24")
				.build();
		productProperty2=ProductProperty.builder()
//				.id(2L)
				.product(product1)
				.property(property2)
				.value("red")
				.build();
		
//		productRepository.save(product1);
//		productRepository.save(product2);
//		productRepository.save(product3);
//		propertyRepository.save(property1);
//		propertyRepository.save(property2);
//		propertyRepository.save(property3);
//		productProperty1=productPropertyRepository.save(productProperty1);
//		productPropertyRepository.save(productProperty2);
//		productPropertyRepository.save(productProperty3);
//		
		Random random= new  Random();
		when(productRepository.findByProductName(any(String.class))).then(new Answer<Optional<Product>>() {

			@Override
			public Optional<Product> answer(InvocationOnMock invocation) throws Throwable {
				
				return Optional.of(Product.builder()
						.id(UUID.randomUUID().toString())
						.prodcutPrice(random.nextFloat())
						.productName(invocation.getArgument(0))
						.productQuantity(random.nextInt(50)+10)
						.build());
			}});
		
		
		when(productPropertyRepository.findByProductId(any(String.class))).thenReturn(Optional.of(List.of(productProperty1,productProperty2)));
		when(propertyRepository.findByPropertyName(anyString())).thenReturn(Optional.of(property1) );
		when(productPropertyRepository.save(any(ProductProperty.class))).thenReturn(productProperty1);
		when(productPropertyRepository.findById(anyString())).thenReturn(Optional.of(productProperty1) );
//		when(productPropertyRepository.deleteByProductAndProperty(product1,property1))
//		productPropertyRepository.deleteById();
		
		when(productPropertyRepository.findByPropertyPropertyId(anyString())).thenReturn(Optional.of(List.of(productProperty1,productProperty2)));
	}
	
	@AfterEach
	void tearDown() throws Exception {
		
	}

	

	@Test
	void testGetPropertysValues() {
		
		List<?> productPropertyList=  propertyService.getPropertysAndValues(product1.getProductName());
		
		assertNotNull(productPropertyList);
		assertTrue(productPropertyList.size()==2);
		
		
	}

	@Test
	
	void testGetPropertsProduct() {

	 Set<String> propertys=	propertyService.getPropertsProduct(product1.getProductName());
	 
	 assertNotNull(propertys);
	 assertEquals(propertys, List.of("size","couleur"));
	 
	 
		
	}

	@Test
	
	void testGetValuesProperty() {
		
		Set<String> values=	propertyService.getValuesProperty(property1.getPropertyName());
		assertNotNull(values);
		 assertEquals(List.of("24","red"),values );
	}

	@Test
	void testAddPropertyToProduct() {
		when(productRepository.existsByProductName("Product 1")).thenReturn(true);
		List<PropertyDto> productProperty= propertyService.addPropertyToProduct(new PropertyRequest(
			    "Product 1",
				"point",
				List.of("12","13")
				));
		
		assertNotNull(productProperty);
		assertTrue(productProperty.size()==2);
		
		
	}
	
	void testAddPropertyToProductNotFound() {
		when(productRepository.existsByProductName("Product 5")).thenReturn(false);
		assertThrows(ProductNotFoundException.class, ()->{
			propertyService.addPropertyToProduct(new PropertyRequest(
				    "Product 5",
					"point",
					List.of("12","13")
					));
		});
	}

	@Test
	void testUpdatePropertyProduct() {
		PropertyDto  propertyDto= propertyService.updatePropertyProduct(productProperty1.getId(), "35");
		assertNotNull(propertyDto);
		assertEquals(propertyDto,PropertyDto.builder()
				.idProdcutProperty(productProperty1.getId())
				.propertyName(productProperty1.getProperty().getPropertyName())
				.value("35")
				.build()
				);
		
	}

	@Test
	void testDeletePropertyFromProduct() {
		when(productPropertyRepository.findByProductId(any(String.class))).thenReturn(Optional.of(List.of(productProperty1)));

		propertyService.deletePropertyFromProduct("size","Product 1");
		assertThat(propertyService.getPropertsProduct(product1.getProductName())).hasSize(1);
		
	}

	@Test
	void testDeleteteValueFromProcutProperty() {
		when(productPropertyRepository.findByProductId(any(String.class))).thenReturn(Optional.of(List.of(productProperty1)));
		propertyService.deleteteValueFromProcutProperty(productProperty1.getId());
		assertThat(propertyService.getPropertsProduct(product1.getProductName())).hasSize(1);

	}

}
