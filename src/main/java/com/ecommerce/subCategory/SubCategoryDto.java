package com.ecommerce.subCategory;

import com.ecommerce.category.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class SubCategoryDto implements Serializable {
    private String subCategoryId;
    private String subCategoryName;
    private Category category;
}
