package com.ecommerce.role.exception;

import com.ecommerce.shared.ApiBasedException;
import org.springframework.http.HttpStatus;

public class RoleAlreadyExistException extends ApiBasedException {

    public RoleAlreadyExistException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }
}
