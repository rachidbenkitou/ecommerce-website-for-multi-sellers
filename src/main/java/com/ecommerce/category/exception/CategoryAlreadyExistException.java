package com.ecommerce.category.exception;

import com.ecommerce.shared.ApiBasedException;
import org.springframework.http.HttpStatus;

public class CategoryAlreadyExistException extends ApiBasedException {
    public CategoryAlreadyExistException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }
}
