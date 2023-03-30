package com.ecommerce.Property;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String propertyId;
	@Indexed(unique=true)
	private String propertyName;
	
//	private List<ProductProperty> productProperties;
	
	
}
