package com.ecommerce.Product.Service;

import java.util.List;

import com.ecommerce.Product.Product;
import com.ecommerce.Product.ProductDto;

public interface ProductService {

	Product AddProduct(ProductDto productDto);
	void deleteProduct(String nameProduct);
	Product sellerProduct(String nameProduct,Integer Quantityseller);
	Product updateProduct(ProductDto productDto);
	
	List<ProductDto> getProductByCategories(String subCategoryName);
	ProductDto getProductByName(String nameProduct);
	 
	
	
	
	
}
