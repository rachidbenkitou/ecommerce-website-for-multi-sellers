package com.ecommerce.order.Excetion;

import com.ecommerce.shared.ApiBasedException;
import org.springframework.http.HttpStatus;

public class OrderNotFoundException extends ApiBasedException {


    public OrderNotFoundException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return  HttpStatus.NOT_FOUND;
    }
}
