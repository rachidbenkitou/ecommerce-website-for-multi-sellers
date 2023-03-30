package com.ecommerce.Property.Exception;

import org.springframework.http.HttpStatus;

import com.ecommerce.shared.ApiBasedException;

public class PropertyNotFoundException extends ApiBasedException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PropertyNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HttpStatus getStatusCode() {
		// TODO Auto-generated method stub
		return HttpStatus.CONFLICT;
	}

}
