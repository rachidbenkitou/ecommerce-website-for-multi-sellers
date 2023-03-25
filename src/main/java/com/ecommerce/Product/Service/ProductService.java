package com.ecommerce.Product.Service;

import java.util.List;

import com.ecommerce.Product.Product;
import com.ecommerce.Product.ProductDto;

public interface ProductService {

	Product AddProduct(ProductDto productDto);
	void deleteProduct(Long idProduct);
	Product sellerProduct(Long idProduct,Integer Quantityseller);
	Product updateProduct(Long idProduct,ProductDto productDto);
	
	List<ProductDto> getProductByCategories(String subCategoryName);
	ProductDto getProductById(Long idProduct);
	 
	
	
	
	
}
