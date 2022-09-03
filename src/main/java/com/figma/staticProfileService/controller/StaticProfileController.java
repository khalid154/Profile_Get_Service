package com.figma.staticProfileService.controller;

import com.figma.staticProfileService.constants.StatusCode;
import com.figma.staticProfileService.response.ManufacturerRoleCategoriesResponse;
import com.figma.staticProfileService.response.ManufacturerRolesResponse;
import com.figma.staticProfileService.util.CompletableFutures;
import com.figma.staticProfileService.service.IStaticProfileService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletionStage;

/**
 * @author : Khalid Hasan
 */

@RestController
@CrossOrigin
@Log4j2
@RequestMapping("/staticProfile")
public class StaticProfileController {

    private final IStaticProfileService staticProfileService;

    @Autowired
    public StaticProfileController(IStaticProfileService staticProfileService) {
        this.staticProfileService = staticProfileService;
    }

    @GetMapping(value = "/role")
    @ApiOperation(value = "this is an api to get static on boarding data", response = ManufacturerRolesResponse.class)
    public CompletionStage<ManufacturerRolesResponse> getManufacturerRole() {
        log.info("request received at Static profile controller");
        return staticProfileService.getManufacturerRole()
                .exceptionally(throwable -> {
                    Throwable unwrappedException = CompletableFutures.unwrapCompletionStageException(throwable);
                    log.warn("exception while fetching manufacturer role", throwable);
                    log.info(unwrappedException.getMessage());
                    return ManufacturerRolesResponse.builder()
                            .statusCode(StatusCode.NOT_FOUND.code)
                            .build();
                });
    }

    @GetMapping(value = "/role/{roleId}")
    @ApiOperation(value = "this is an api to get static on boarding data", response = ManufacturerRoleCategoriesResponse.class)
    public CompletionStage<ManufacturerRoleCategoriesResponse> getManufacturerRoleCategory(@PathVariable(name = "roleId") Long roleId) {
        log.info("request received at Static profile controller with role Id = " + roleId);
        return staticProfileService.getManufacturerRoleCategory(roleId)
                .exceptionally(throwable -> {
                    Throwable unwrappedException = CompletableFutures.unwrapCompletionStageException(throwable);
                    log.warn("exception while fetching manufacturer role category", throwable);
                    log.info(unwrappedException.getMessage());
                    return ManufacturerRoleCategoriesResponse.builder()
                            .statusCode(StatusCode.NOT_FOUND.code)
                            .build();
                });
    }
}
