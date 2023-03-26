package com.ecommerce.Product.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ecommerce.Product.Product;
import com.ecommerce.Product.ProductDto;
import com.ecommerce.Product.ProductMapper;
import com.ecommerce.Product.ProductRepository;
import com.ecommerce.subCategory.SubCategoryRepository;

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
	 */
	@Override
	public Product AddProduct(ProductDto productDto) {
	  Product product=productMapper.dtoToProduct(productDto);
		return productRepository.save(product);
	}
	/**
	 * delete Product from database by id
	 * @param idProduct id unique for Product that well delete  
	 */
	@Override
	public void deleteProduct(Long idProduct) {
	
		productRepository.deleteById(idProduct);
		
	}

	/**
	 * discount a quantity from product
	 * @param idProduct id unique for product
	 * @param Quantityseller quantity discount from origin Quantity Product
	 * @throws RuntimeException if origin Quantity Product less than Quantity discount
	 * @return new Product 
	 */
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
