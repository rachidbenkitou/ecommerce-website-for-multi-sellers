package com.ecommerce.subCategory;

import com.ecommerce.category.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubCategoryDto implements Serializable {
    private String subCategoryId;
    private String subCategoryName;
    @DBRef
    private Category category;
}
