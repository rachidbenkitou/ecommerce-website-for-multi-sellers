<<<<<<< HEAD
package com.ecommerce.client.exceptions;

import com.ecommerce.shared.ApiBasedException;
import org.springframework.http.HttpStatus;

public class ClientNotFoundException extends ApiBasedException {
    public ClientNotFoundException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
=======
package com.ecommerce.client.exceptions;

import com.ecommerce.shared.ApiBasedException;
import org.springframework.http.HttpStatus;

public class ClientNotFoundException extends ApiBasedException {
    public ClientNotFoundException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
>>>>>>> 4fd60159d56d751dc9c3219729c6aec6c20f7c09
