package com.ecommerce.subCategory.exception;

import com.ecommerce.shared.ApiBasedException;
import org.springframework.http.HttpStatus;

public class SubCategoryAlreadyExistException extends ApiBasedException {
    public SubCategoryAlreadyExistException(String message) {
        super(message);
    }
    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }
}