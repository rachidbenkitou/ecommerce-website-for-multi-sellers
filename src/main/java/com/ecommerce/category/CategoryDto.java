package com.ecommerce.category;

import com.ecommerce.subCategory.SubCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class CategoryDto implements Serializable {
    private String categoryId;
    private String categoryName;
    //private List<SubCategory> subCatgeories;
}
