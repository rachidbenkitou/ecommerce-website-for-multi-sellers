package com.ecommerce.seller.exceptions;

import com.ecommerce.shared.ApiBasedException;
import org.springframework.http.HttpStatus;

public class SellerAlreadyExistsException extends ApiBasedException {
    public SellerAlreadyExistsException(String message) {
        super(message);
    }

    /**
     * @return
     */
    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }
}
