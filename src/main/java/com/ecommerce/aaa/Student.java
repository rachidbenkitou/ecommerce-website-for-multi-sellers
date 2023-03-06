package com.ecommerce.aaa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS )
public abstract class Student {
    @Id
    private String id;
    private String name;
}
