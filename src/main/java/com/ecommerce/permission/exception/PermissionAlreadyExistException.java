package com.ecommerce.permission.exception;

import com.ecommerce.shared.ApiBasedException;
import org.springframework.http.HttpStatus;

public class PermissionAlreadyExistException extends ApiBasedException {

    public PermissionAlreadyExistException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }
}
