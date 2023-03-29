package com.ecommerce.subCategory;

import com.ecommerce.category.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@Builder
@Data
@AllArgsConstructor
@Document
public class SubCatgeory implements Serializable {
    @Id
    private String id;
    @Indexed(unique = true)
    private String subCategoryName;
    @DBRef
    private Category category;
   
}
