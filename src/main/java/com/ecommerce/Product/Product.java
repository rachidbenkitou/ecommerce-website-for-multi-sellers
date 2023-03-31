package com.ecommerce.Product;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ecommerce.subCategory.SubCategory;

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
	@Id
	private String id;
	@Indexed(unique=true)
	private StSring productName;
	private Integer productQuantity;
	private Float prodcutPrice;
	@DBRef
	private SubCategory subCatgeory;

//	private List<ProductProperty> productPropertyts;

}
