package com.ecommerce.aaa;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stuednt")
@AllArgsConstructor
public class EController {
    private final ExterneStudentRepo externeStudentRepo;

    @GetMapping("/all")
    public List<ExterneStudent> getAll(){
        return externeStudentRepo.findAll();
    }
    @PostMapping("/save")
    public ExterneStudent saveAll(@RequestBody ExterneStudent externeStudent){
        return externeStudentRepo.save(externeStudent);
    }

}
