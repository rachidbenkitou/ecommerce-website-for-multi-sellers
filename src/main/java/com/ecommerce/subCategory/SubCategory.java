package com.ecommerce.subCategory;

import com.ecommerce.category.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@Document
public class SubCategory implements Serializable {
    @Id
    private String subCategoryId;
    private String subCategoryName;
    @DBRef
    private Category category;
}
