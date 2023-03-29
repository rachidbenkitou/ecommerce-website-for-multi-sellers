package com.ecommerce.Property.Exception;

import org.springframework.http.HttpStatus;

import com.ecommerce.shared.ApiBasedException;

public class ProductNotHaveValueException  extends ApiBasedException {

	private static final long serialVersionUID = 1L;

	public ProductNotHaveValueException(String message) {
		super(message);
		
	}

	@Override
	public HttpStatus getStatusCode() {
		
		return HttpStatus.CONFLICT;
	}

}
