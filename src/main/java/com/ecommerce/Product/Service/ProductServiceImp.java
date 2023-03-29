package com.ecommerce.Product.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ecommerce.Product.Product;
import com.ecommerce.Product.ProductDto;
import com.ecommerce.Product.ProductMapper;
import com.ecommerce.Product.ProductRepository;
import com.ecommerce.Product.exceptions.ProductAlreadyExistException;
import com.ecommerce.Product.exceptions.ProductNotFoundException;
import com.ecommerce.Product.exceptions.QuantityNotEnoughException;
import com.ecommerce.subCategory.SubCategoryRepository;
import com.ecommerce.subCategory.SubCatgeory;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class ProductServiceImp implements ProductService {

	private ProductRepository productRepository;
	private ProductMapper productMapper;
	private SubCategoryRepository categoryRepository;
	/**
	 * Add Product to database
	 * @param ProductDto Product information using for add Product
	 * @return Product saving in database
	 * @throws ProductNotFoundException id product alrealy existe or SubCategory not found
	 */
	@Override
	public Product AddProduct(ProductDto productDto) {
	  if(ifExistProduct(productDto.getProductName())) throw new ProductAlreadyExistException("Product alrealy exist");
	  Product product=productMapper.dtoToProduct(productDto);
	  SubCatgeory subCatgeory= categoryRepository.findBySubCategoryName(productDto.getSubCatergory().getSubCategoryName()).orElseThrow(()-> new RuntimeException("SubCategory not found"));
	  product.setSubCatgeory(subCatgeory);
	  return productRepository.save(product);
	}
	/**
	 * delete Product from database by id
	 * @param nameProduct id unique for Product that well delete  
	 */
	@Override
	public void deleteProduct(String nameProduct) {
	
		productRepository.deleteByProductName(nameProduct);
		
	}

	/**
	 * discount a quantity from product
	 * @param nameProduct id unique for product
	 * @param Quantityseller quantity discount from origin Quantity Product
	 * @throws RuntimeException if origin Quantity Product less than Quantity discount
	 * @return new Product 
	 */
	@Override
	public Product sellerProduct(String nameProduct, Integer Quantityseller) {
		Product product=productRepository.findByProductName(nameProduct).orElseThrow(()->new ProductNotFoundException("not found")); 
		if(product.getProductQuantity()-Quantityseller<0) throw new QuantityNotEnoughException("quantity not suffisant");
		product.setProductQuantity(product.getProductQuantity()-Quantityseller);
		
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(ProductDto productDto) {
		
		
		
		Product productUpdated=productMapper.dtoToProduct(productDto);
		
		Product product =productRepository.findByProductName(productDto.getProductName()).orElseThrow(()->new ProductNotFoundException("not found")); 
		if(product.getSubCatgeory().getSubCategoryName().equals(productDto.getSubCatergory().getSubCategoryName())) {
			// TODO Exception Category not found
			SubCatgeory catgeory=categoryRepository.findBySubCategoryName(productDto.getSubCatergory().getSubCategoryName()).orElseThrow(()->new RuntimeException("not found"));
			productUpdated.setSubCatgeory(catgeory);
		}
		productUpdated.setId(product.getId());
		
		return productRepository.save(productUpdated);
	}

	@Override
	public List<ProductDto> getProductByCategories(String subCategoryName) {
		// TODO Exception Category not found
		SubCatgeory subCatgeory= categoryRepository.findBySubCategoryName(subCategoryName).get();
		return productMapper.productsToDtos(productRepository.findBySubCatgeoryId(subCatgeory.getId()).get());
	}

	@Override
	public ProductDto getProductByName(String nameProduct) {
		
		return productMapper.productToDto(productRepository.findByProductName(nameProduct).orElseThrow(()->new ProductAlreadyExistException("product not found")));
	}
	
	private boolean ifExistProduct(String productName) {
	 return	productRepository.existsByProductName(productName);
	}

}