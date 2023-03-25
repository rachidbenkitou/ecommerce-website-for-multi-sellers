package com.ecommerce.Property;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.ecommerce.Product.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
public class ProductProperty {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Long id;
	private String value ;
	
	private Property property;
	private Product product;
}
