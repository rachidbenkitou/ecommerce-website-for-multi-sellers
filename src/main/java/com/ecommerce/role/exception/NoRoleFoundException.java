package com.ecommerce.role.exception;

import com.ecommerce.shared.ApiBasedException;
import org.springframework.http.HttpStatus;

public class NoRoleFoundException extends ApiBasedException {

    public NoRoleFoundException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
