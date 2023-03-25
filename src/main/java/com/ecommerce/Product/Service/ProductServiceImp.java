package com.ecommerce.Product.Service;

import java.util.List;

import com.ecommerce.Product.Product;
import com.ecommerce.Product.ProductDto;
import com.ecommerce.Product.ProductMapper;
import com.ecommerce.Product.ProductRepository;
import com.ecommerce.subCategory.SubCategoryRepository;

public class ProductServiceImp implements ProductService {

	private ProductRepository productRepository;
	private ProductMapper productMapper;
	private SubCategoryRepository categoryRepository;
	
	@Override
	public Product AddProduct(ProductDto productDto) {
	  Product product=productMapper.dtoToProduct(productDto);
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(Long idProduct) {
	
		productRepository.deleteById(idProduct);
		
	}

	@Override
	public Product sellerProduct(Long idProduct, Integer Quantityseller) {
		Product product=productRepository.findById(idProduct).orElseThrow(()->new RuntimeException("not found")); 
		if(product.getProductQuantity()-Quantityseller<0) throw new RuntimeException("quantity not found");
		product.setProductQuantity(product.getProductQuantity()-Quantityseller);
		
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Long idProduct,ProductDto productDto) {
		
		Product product=productMapper.dtoToProduct(productDto);
		product.setProductId(idProduct);
		return productRepository.save(product);
	}

	@Override
	public List<ProductDto> getProductByCategories(String subCategoryName) {
		
		return productMapper.productsToDtos(categoryRepository.findBySubCategoryName(subCategoryName).get().getProducts());
	}

	@Override
	public ProductDto getProductById(Long idProduct) {
		
		return productMapper.productToDto(productRepository.findById(idProduct).get());
	}

}
