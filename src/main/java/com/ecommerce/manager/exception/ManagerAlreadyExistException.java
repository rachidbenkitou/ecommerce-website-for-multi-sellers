package com.ecommerce.manager.exception;

import com.ecommerce.shared.ApiBasedException;
import org.springframework.http.HttpStatus;

public class ManagerAlreadyExistException extends ApiBasedException {

    public ManagerAlreadyExistException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }
}
