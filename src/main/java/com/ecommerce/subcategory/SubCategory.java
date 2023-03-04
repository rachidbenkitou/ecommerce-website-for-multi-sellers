package com.ecommerce.subcategory;

import com.ecommerce.category.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;
import java.io.Serializable;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubCategory implements Serializable {
    private int subCategoryId;
    private String subCategoryName;
    @ManyToOne
    private Category category;
}
