package com.ecommerce.category;

import com.ecommerce.subCategory.SubCatgeory;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class CategoryDto implements Serializable {
    private String categoryId;
    private String categoryName;
    private List<SubCatgeory> subCatgeories= new ArrayList<>();
}
