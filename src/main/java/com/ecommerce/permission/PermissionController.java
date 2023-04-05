package com.ecommerce.permission;

import com.ecommerce.permission.service.PermissionService;
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
@RequestMapping("/permission")
@RequiredArgsConstructor
@Tag(name="Permission Controller")
public class PermissionController {
    private final PermissionService permissionService;
    @Operation(summary = "Find the entire permissions", description = "This method allows you to find all permissions and returns a list of PermissionDto objects.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the permission of objects were found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PermissionDto.class))})
    })
    @GetMapping("/all")
    public ResponseEntity<List<PermissionDto>> getAllPermissions(){
        return new ResponseEntity<>(permissionService.getAllPermissions(), HttpStatus.OK);
    }
    @Operation(summary = "Find the permissions by name", description = "This method allows you to find the permissions by name and returns a list of PermissionDto objects.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the permissions of objects were found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PermissionDto.class))})
    })
    @GetMapping("/find/name/{permissionName}")
    public ResponseEntity<List<PermissionDto>> getPermissionsByName(@PathVariable String permissionName){
        return new ResponseEntity<>(permissionService.getPermissionsByName(permissionName), HttpStatus.OK);
    }
    @Operation(summary = "Save a permission", description = "this method allows you to save a permission.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the permission object created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PermissionDto.class))})
    })
    @PostMapping("/save")
    public ResponseEntity<PermissionDto> savePermission(@RequestBody PermissionDto permissionDto){
        return new ResponseEntity<>(permissionService.savePermission(permissionDto), HttpStatus.CREATED);
    }
    @Operation(summary = "Update a permission", description = "this method allows you to update a permission.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the permission object updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PermissionDto.class))})
    })
    @PutMapping("/update/{permissionId}")
    public ResponseEntity<PermissionDto> updatePermission(@RequestBody PermissionDto permissionDto){
        return new ResponseEntity<>(permissionService.updatePermission(permissionDto), HttpStatus.OK);
    }
    @Operation(summary = "delete a permission", description = "this method allows you to delete a permission by name.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the permission object deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PermissionDto.class))})
    })
    @DeleteMapping("/delete/{permissionName}")
    public ResponseEntity<?> deletePermissionByName(@PathVariable String permissionName){
        permissionService.deletePermissionByName(permissionName);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
