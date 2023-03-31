package com.ecommerce.seller.exceptions;

import com.ecommerce.shared.ApiBasedException;
import org.springframework.http.HttpStatus;

public class SellerNotFoundException extends ApiBasedException {

    public SellerNotFoundException(String message) {
        super(message);
    }

    /**
     * @return
     */
    @Override
    public HttpStatus getStatusCode() {
         return HttpStatus.NOT_FOUND;
    }
}
