package com.figma.staticProfileService.service.impl;

import com.figma.staticProfileService.constants.Status;
import com.figma.staticProfileService.repopsitory.ManufacturerRoleCategoryRepository;
import com.figma.staticProfileService.repopsitory.ManufacturerRoleRepository;
import com.figma.staticProfileService.response.ManufacturerRoleCategoriesResponse;
import com.figma.staticProfileService.response.ManufacturerRolesResponse;
import com.figma.staticProfileService.service.ConversionService;
import com.figma.staticProfileService.service.IStaticProfileService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * @author : Khalid Hasan
 */

@Service
@Log4j2
public class StaticProfileServiceImpl implements IStaticProfileService {

    private ManufacturerRoleRepository manufacturerRoleRepository;
    private ManufacturerRoleCategoryRepository manufacturerRoleCategoryRepository;

    @Autowired
    public StaticProfileServiceImpl(ManufacturerRoleRepository manufacturerRoleRepository, ManufacturerRoleCategoryRepository manufacturerRoleCategoryRepository) {
        this.manufacturerRoleRepository = manufacturerRoleRepository;
        this.manufacturerRoleCategoryRepository = manufacturerRoleCategoryRepository;
    }

    @Override
    public CompletionStage<ManufacturerRolesResponse> getManufacturerRole() {
        return CompletableFuture.supplyAsync(() -> {
            return manufacturerRoleRepository.findManufacturerRoleByStatusId(Status.Active.name());
        }).thenApply(res -> {
            return ConversionService.getManufacturerRolesResponseByManufacturer(res);
        });
    }

    @Override
    public CompletionStage<ManufacturerRoleCategoriesResponse> getManufacturerRoleCategory(Long roleId) {
        return CompletableFuture.supplyAsync(() -> {
            return manufacturerRoleCategoryRepository.findManufacturerRoleCategoryByManufacturerRoleIdAndStatusId(roleId, Status.Active.name());
        }).thenApply(res -> {
            return ConversionService.getManufacturerRoleCategoriesResponseByManufacturerRoleCategory(res);
        });
    }
}
