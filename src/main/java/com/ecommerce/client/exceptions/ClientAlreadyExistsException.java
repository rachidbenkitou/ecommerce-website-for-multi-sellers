<<<<<<< HEAD
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
=======
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
>>>>>>> 4fd60159d56d751dc9c3219729c6aec6c20f7c09
