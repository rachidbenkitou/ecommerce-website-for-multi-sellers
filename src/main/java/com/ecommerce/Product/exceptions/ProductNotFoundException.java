package com.ecommerce.Product.exceptions;

import org.springframework.http.HttpStatus;

import com.ecommerce.shared.ApiBasedException;

public class ProductNotFoundException extends ApiBasedException {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(String message) {
		super(message);
		
	}

	@Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }
}
