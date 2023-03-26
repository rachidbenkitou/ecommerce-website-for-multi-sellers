package com.ecommerce.Property;

import java.util.List;

import javax.persistence.Entity;

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

	private Short propertyId;
	private String propertyName;
	
	private List<ProductProperty> productProperties;
	
	
}
