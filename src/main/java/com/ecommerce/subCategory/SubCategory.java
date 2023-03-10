package com.ecommerce.subCategory;

import com.ecommerce.category.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serializable;

@Data
@AllArgsConstructor
@Document
public class SubCategory implements Serializable {
    @Id
    private String subCategoryId;
    private String subCategoryName;
    private Category category;
}
