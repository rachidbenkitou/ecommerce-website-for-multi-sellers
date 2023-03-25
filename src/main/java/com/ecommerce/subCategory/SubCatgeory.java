package com.ecommerce.subCategory;

import com.ecommerce.Product.Product;
import com.ecommerce.category.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@Document
public class SubCatgeory implements Serializable {
    @Id
    private String subCategoryId;
    @Column(unique = true)
    private String subCategoryName;
    private Category category;
    
    private List<Product> products;
}
