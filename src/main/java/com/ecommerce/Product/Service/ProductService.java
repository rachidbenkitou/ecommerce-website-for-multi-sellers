package com.ecommerce.Product.Service;

import java.util.List;

import com.ecommerce.Product.Product;
import com.ecommerce.Product.ProductDto;

public interface ProductService {

	ProductDto AddProduct(ProductDto productDto);
	void deleteProduct(String nameProduct);
	ProductDto sellerProduct(String nameProduct,Integer Quantityseller);
	ProductDto updateProduct(String productName,ProductDto productDto);
	
	List<ProductDto> getProductByCategories(String subCategoryName);
	ProductDto getProductByName(String nameProduct);
	 
	
	
	
	
}
