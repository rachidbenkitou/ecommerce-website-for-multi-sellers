package com.ecommerce.client.exceptions;

import com.ecommerce.shared.ApiBasedException;
import org.springframework.http.HttpStatus;

public class ClientNotFoundException extends ApiBasedException {
    public ClientNotFoundException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
