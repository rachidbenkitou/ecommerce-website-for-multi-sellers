package com.ecommerce.Property;

import java.util.List;

public record PropertyRequest(Long idProduct,String nameProperty,List<String> values) {

	
}
