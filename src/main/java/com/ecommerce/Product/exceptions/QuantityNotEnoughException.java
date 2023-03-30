package com.ecommerce.Product.exceptions;

import org.springframework.http.HttpStatus;

import com.ecommerce.shared.ApiBasedException;

public class QuantityNotEnoughException extends ApiBasedException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6257806419184845955L;

	public QuantityNotEnoughException(String message) {
		super(message);
	}
	
	 @Override
	 public HttpStatus getStatusCode() {
	        return HttpStatus.CONFLICT;
	 }

}
