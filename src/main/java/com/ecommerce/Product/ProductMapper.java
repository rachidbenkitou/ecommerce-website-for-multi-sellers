package com.ecommerce.Product;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
	
	ProductDto productToDto(Product product);
	Product dtoToProduct(ProductDto productDto);
	List<ProductDto> productsToDtos(List<Product> product);



}
