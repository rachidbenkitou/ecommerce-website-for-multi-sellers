package com.ecommerce.client.exceptions;

import com.ecommerce.shared.ApiBasedException;
import org.springframework.http.HttpStatus;

public class ClientAlreadyExistsException extends ApiBasedException {
    public ClientAlreadyExistsException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }
}
