package com.ecommerce.Property;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ecommerce.Product.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
public class ProductProperty {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private String id;
	private String value ;
	@DBRef()
	private Property property;
	@DBRef()
	private Product product;
}
