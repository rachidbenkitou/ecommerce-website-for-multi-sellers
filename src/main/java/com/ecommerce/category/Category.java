package com.ecommerce.category;

import com.ecommerce.subCategory.SubCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@Document
public class Category implements Serializable {
    @Id
    private String categoryId;
    @Field
    private String categoryName;
    @DBRef
    private List<SubCategory> subCatgeories;
}
