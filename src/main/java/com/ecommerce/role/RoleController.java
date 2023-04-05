package com.ecommerce.role;

import com.ecommerce.category.CategoryDto;
import com.ecommerce.manager.ManagerDto;
import com.ecommerce.role.service.RoleService;
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
@RequestMapping("/role")
@RequiredArgsConstructor
@Tag(name="Role Controller")
public class RoleController {
    private final RoleService roleService;
    @Operation(summary = "Find the entire roles", description = "This method allows you to find all roles and returns a list of RoleDto objects.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the roles of objects were found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = RoleDto.class))})
    })
    @GetMapping("/all")
    public ResponseEntity<List<RoleDto>> getAllRoles(){
        return new ResponseEntity<>(roleService.getAllRoles(), HttpStatus.OK);
    }
    @Operation(summary = "Find the roles by name", description = "This method allows you to find the roles by name and returns a list of RoleDto objects.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the roles of objects were found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ManagerDto.class))})
    })
    @GetMapping("/find/name/{roleName}")
    public ResponseEntity<List<RoleDto>> getRoleByName(@PathVariable String roleName){
        return new ResponseEntity<>(roleService.getRolesByName(roleName), HttpStatus.OK);
    }
    @Operation(summary = "Save a role", description = "this method allows you to save a role.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the role object created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ManagerDto.class))})
    })
    @PostMapping("/save")
    public ResponseEntity<RoleDto> saveRole(@RequestBody RoleDto roleDto){
        return new ResponseEntity<>(roleService.saveRole(roleDto), HttpStatus.CREATED);
    }
    @Operation(summary = "Update a role", description = "this method allows you to update a role.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the role object updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))})
    })
    @PutMapping("/update/{roleId}")
    public ResponseEntity<RoleDto> updateRole(@RequestBody RoleDto roleDto){
        return new ResponseEntity<>(roleService.updateRole(roleDto), HttpStatus.OK);
    }
    @Operation(summary = "delete a role", description = "this method allows you to delete a role by name.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the role object deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoryDto.class))})
    })
    @DeleteMapping("/delete/{roleName}")
    public ResponseEntity<?> deleteRoleByName(@PathVariable String roleName){
        roleService.deleteRoleByName(roleName);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
