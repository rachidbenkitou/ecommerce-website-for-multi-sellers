package com.ecommerce.seller;

import com.ecommerce.Product.Product;
import com.ecommerce.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class SellerDto extends UserDto implements Serializable {
    private String  description;
    private List<Product> products;

}
