package com.ecommerce.category;

import com.ecommerce.subcategory.SubCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {
    private int categoryId;
    private String categoryName;
    @OneToMany(mappedBy = "category")
    private List<SubCategory> subCategories;
}
