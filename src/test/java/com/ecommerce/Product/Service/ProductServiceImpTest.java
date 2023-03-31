package com.ecommerce.Product.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ecommerce.EcommerceApplication;
import com.ecommerce.Product.Product;
import com.ecommerce.Product.ProductDto;
import com.ecommerce.Product.ProductMapper;
import com.ecommerce.Product.ProductRepository;
import com.ecommerce.Product.exceptions.ProductAlreadyExistException;
import com.ecommerce.Product.exceptions.QuantityNotEnoughException;
import com.ecommerce.subCategory.SubCategoryDto;
import com.ecommerce.subCategory.SubCategoryRepository;
import com.ecommerce.subCategory.SubCategory;

@ExtendWith(MockitoExtension.class)
class ProductServiceImpTest {

//	@Autowired
	
	
//	@Autowired
	@Mock
	private ProductRepository productRepository;
	
	@Mock
	private ProductMapper productMapper;

//	@Autowired
	@Mock
	private SubCategoryRepository subCategoryRepository;
	@InjectMocks
	private ProductServiceImp productService;
	private Product product1,product2,product3;
	
	private SubCategory subCatgeory;
	
	@BeforeEach
	void SetUp() {
//		productService=new ProductServiceImp(productRepository, productMapper, subCategoryRepository);
		subCatgeory=SubCategory.builder()
				.subCategoryName("SubCategory")
				.build();
		
		
		
		product1=Product.builder()
				.prodcutPrice((float) 32.2)
				.productName("Product 1")
				.productQuantity(32)
				.subCatgeory(subCatgeory)
				.build();
		product2=Product.builder()
				.prodcutPrice((float) 37.2)
				.productName("Product 2")
				.productQuantity(36)
				.subCatgeory(subCatgeory)
				.build();
		product3=Product.builder()
				.prodcutPrice((float) 31.2)
				.productName("Product 3")
				.productQuantity(31)
				.subCatgeory(subCatgeory)
				.build(); 
//		subCategoryRepository.save(subCatgeory);
//		productRepository.save(product2);
//		productRepository.save(product3);
		when(subCategoryRepository.save(any(SubCategory.class))).thenAnswer(new Answer<SubCategory>() {

			@Override
			public SubCategory answer(InvocationOnMock invocation) throws Throwable {
				
				return SubCategory.builder()
						.subCategoryId(UUID.randomUUID().toString())
						.subCategoryName(subCatgeory.getSubCategoryName())
						.build();
			}
		});

		
		when(productMapper.dtoToProduct(any(ProductDto.class))).thenAnswer(new Answer<Product>() {

			@Override
			public Product answer(InvocationOnMock invocation) throws Throwable {
				ProductDto productdto=invocation.getArgument(0);
				return Product.builder()
						.prodcutPrice(productdto.getProdcutPrice())
						.productName(productdto.getProductName())
						.productQuantity(productdto.getProductQuantity())
						
						.build();
				}
			});
			
		when(productMapper.productToDto(any(Product.class))).thenAnswer(new Answer<ProductDto>() {

			@Override
			public ProductDto answer(InvocationOnMock invocation) throws Throwable {
				ProductDto product=invocation.getArgument(0);
				return ProductDto.builder()
						.prodcutPrice(product.getProdcutPrice())
						.productName(product.getProductName())
						.productQuantity(product.getProductQuantity())
						.build();
				
			}
			});;	
		
		when(productRepository.save(any(Product.class))).thenAnswer(new Answer<Product>() {

			@Override
			public Product answer(InvocationOnMock invocation) throws Throwable {
	            Product product=invocation.getArgument(0);
	            product.setId(UUID.randomUUID().toString());
				return product;
			}
		});
		Random random= new  Random();
		when(productRepository.findByProductName(any(String.class))).then(new Answer<Optional<Product>>() {

			@Override
			public Optional<Product> answer(InvocationOnMock invocation) throws Throwable {
				
				return Optional.of(Product.builder()
						.id(UUID.randomUUID().toString())
						.prodcutPrice(random.nextFloat())
						.productName(invocation.getArgument(0))
						.subCatgeory(subCatgeory)
						.productQuantity(random.nextInt(50)+10)
						.build());
			}});
		
		when(subCategoryRepository.findBySubCategoryName(any(String.class))).thenAnswer(new Answer<Optional<SubCategory>>() {

			@Override
			public Optional<SubCategory> answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				return Optional.of(SubCategory.builder()
						.subCategoryId(UUID.randomUUID().toString())
						.subCategoryName(invocation.getArgument(0))
						.build()
						);
			}});
		
	}
	
	
	@Test
	void testAddProduct() {
		
		
		
		ProductDto dto=ProductDto.builder()
				.prodcutPrice(32.43f)
				.productName("Product 5")
				.productQuantity(32)
				.subCatergory(SubCategoryDto.builder()
					.subCategoryName("SubCategory")
						.build())
				.build();
		
		assertThat(productService.AddProduct(dto)).
		       hasFieldOrPropertyWithValue("productName","Product 5")
		       .isNotNull();
		
		
	}
	
	@Test
	@Disabled
	void testAddProductAlrealyExist() {
		when(productRepository.existsByProductName(any(String.class))).thenReturn(true);
		ProductDto dto=ProductDto.builder()
				.prodcutPrice(32.43f)
				.productName("Product 3")
				.productQuantity(32)
				.subCatergory(SubCategoryDto.builder()
					.subCategoryName("SubCategory")
						.build())
				.build();
		
		assertThatThrownBy(()->{productService.AddProduct(dto);})
		.isInstanceOf(ProductAlreadyExistException.class)
		.hasMessageContaining("Product alrealy exist");
	}

	@Test
	void testSellerProduct() {
		ProductDto product=productService.sellerProduct("Product 1", 10);
		assertThat(product.getProductQuantity())
		.isGreaterThan(0);

	}
	
	@Test
	void testSellerProductWhitQuantityInsifisant() {
		assertThatThrownBy(()->{productService.sellerProduct("Product 1", 100);})
		.isInstanceOf(QuantityNotEnoughException.class)
		.hasMessageContaining("quantity not suffisant");

	}

	@Test
	void testUpdateProduct() {
		ProductDto dto=ProductDto.builder()
				.prodcutPrice(31.43f)
				.productName("Product 3")
				.productQuantity(37)
				.subCatergory(SubCategoryDto.builder()
				.subCategoryName("SubCategory")
						.build())
				.build();
		
		assertThat(productService.updateProduct("Product 3",dto))
		.isNotNull()
		.hasFieldOrPropertyWithValue("productQuantity",dto.getProductQuantity())
		.hasFieldOrPropertyWithValue("productName",dto.getProductName())
		.hasFieldOrPropertyWithValue("prodcutPrice",dto.getProdcutPrice());
		
	}

	@Test
	void testGetProductByCategories() {
		when(productRepository.findBySubCatgeorySubCategoryId(any(String.class))).thenReturn( Optional.ofNullable(List.of(product1,product2,product3)));
		assertThat(productService.getProductByCategories("SubCategory"))
		.isNotNull()
		.hasSize(3);
		
	}

	@Test
	void testGetProductById() {
		assertThat(productService.getProductByName("Product 3"))
		.isNotNull();
	
	}
	@Test
	void testGetProductByIdNotExist() {
		when(productRepository.findByProductName("Product 3")).thenThrow(new ProductAlreadyExistException("product not found"));

		assertThatThrownBy(()->{productService.getProductByName("Product 3");})
		.isInstanceOf(ProductAlreadyExistException.class)
		.hasMessageContaining("product not found");
	
	}

}
