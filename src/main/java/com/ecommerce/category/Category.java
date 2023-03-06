package com.ecommerce.category;

import com.ecommerce.subCategory.SubCatgeory;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Document
public class Category implements Serializable {
    @Id
    private String categoryId;
    @Column(unique = true)
    private String categoryName;
    private List<SubCatgeory> subCatgeories= new ArrayList<>();
}
