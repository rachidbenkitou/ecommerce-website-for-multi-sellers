package com.ecommerce.Product;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.ecommerce.Property.ProductProperty;
import com.ecommerce.subCategory.SubCatgeory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
public class Product {
	
	private Long productId;
	private String productName;
	private Integer productQuantity;
	private Float prodcutPrice;
	
	private SubCatgeory subCatgeory;
	private List<ProductProperty> productPropertyts;

}
