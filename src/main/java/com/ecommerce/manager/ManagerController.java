package com.ecommerce.manager;

import com.ecommerce.category.CategoryDto;
import com.ecommerce.manager.service.ManagerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manger")
@RequiredArgsConstructor
@Tag(name="Category Controller")
public class ManagerController {
    /*
    private final ManagerService managerService;
    @Operation(summary = "Find the entire managers", description = "This method allows you to find all managers and returns a list of ManagerDto objects.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the managers of objects were found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))})
    })
    @GetMapping("/all")
    public ResponseEntity<List<ManagerDto>> getAllManagers(){
        return new ResponseEntity<>(managerService.getAllMangers(), HttpStatus.OK);
    }
    @Operation(summary = "Find the managers by name", description = "This method allows you to find the managers by name and returns a list of ManagerDto objects.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the managers of objects were found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ManagerDto.class))})
    })
    @GetMapping("/find/name/{managerEmail}")
    public ResponseEntity<List<ManagerDto>> getManagersByEmail(@PathVariable String managerEmail){
        return new ResponseEntity<>(managerService.getManagersByEmail(managerEmail), HttpStatus.OK);
    }
    @Operation(summary = "Save a manager", description = "this method allows you to save a manager.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the manager object created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ManagerDto.class))})
    })
    @PostMapping("/save")
    public ResponseEntity<ManagerDto> saveManager(@RequestBody ManagerDto managerDto){
        return new ResponseEntity<>(managerService.saveManager(managerDto), HttpStatus.CREATED);
    }
    @Operation(summary = "Update a manager", description = "this method allows you to update a manager.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the manager object updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))})
    })
    @PutMapping("/update/{managerId}")
    public ResponseEntity<ManagerDto> updateManager(@RequestBody ManagerDto managerDto){
        return new ResponseEntity<>(managerService.updateManager(managerDto), HttpStatus.OK);
    }
    @Operation(summary = "delete a manager", description = "this method allows you to delete a manager by email.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the manager object deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))})
    })
    @DeleteMapping("/delete/{managerEmail}")
    public ResponseEntity<?> deleteManagerEmail(@PathVariable String managerEmail){
        managerService.deleteManagerByEmail(managerEmail);
        return new ResponseEntity<>(HttpStatus.OK);
    }

     */

}
