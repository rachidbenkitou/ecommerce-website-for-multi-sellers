package com.ecommerce.category;

import com.ecommerce.subCategory.SubCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Document
public class Category implements Serializable {
    @Id
    private String categoryId;
    @Field
    private String categoryName;
    private List<SubCategory> subCatgeories= new ArrayList<>();
}
