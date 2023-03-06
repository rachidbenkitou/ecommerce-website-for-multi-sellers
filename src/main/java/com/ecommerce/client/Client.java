<<<<<<< HEAD
package com.ecommerce.client;


import com.ecommerce.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import java.io.Serializable;


@Document
@Data
@AllArgsConstructor
public class Client extends User implements Serializable {
    @Column(unique = true)
   private String username;
}
=======
package com.ecommerce.client;


import com.ecommerce.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import java.io.Serializable;


@Document
@Data
@AllArgsConstructor
public class Client extends User implements Serializable {
    @Column(unique = true)
    private String username;
}
>>>>>>> 4fd60159d56d751dc9c3219729c6aec6c20f7c09
