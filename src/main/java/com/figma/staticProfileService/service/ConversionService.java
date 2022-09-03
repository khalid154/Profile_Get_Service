package com.figma.staticProfileService.service;

import com.figma.staticProfileService.constants.StatusCode;
import com.figma.staticProfileService.model.ManufacturerRole;
import com.figma.staticProfileService.model.ManufacturerRoleCategory;
import com.figma.staticProfileService.response.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Khalid Hasan
 */
public class ConversionService {

    public static ManufacturerRolesResponse getManufacturerRolesResponseByManufacturer(List<ManufacturerRole> manufacturerRoles) {
        List<ManufacturerRoleDto> manufacturerRolesDto = manufacturerRoles.stream()
                .map(role -> getManufacturerRole(role)).collect(Collectors.toList());
        ManufacturerRolesData manufacturerRolesData = new ManufacturerRolesData();
        manufacturerRolesData.setManufacturerRoles(manufacturerRolesDto);
        ManufacturerRolesResponse manufacturerRolesResponse = ManufacturerRolesResponse.builder()
                .data(manufacturerRolesData)
                .statusCode(StatusCode.SUCCESS.code)
                .build();
        return manufacturerRolesResponse;
    }

    private static ManufacturerRoleDto getManufacturerRole(ManufacturerRole manufacturerRole) {
        ManufacturerRoleDto manufacturerRoleDto = new ManufacturerRoleDto();
        manufacturerRoleDto.setId(manufacturerRole.getId());
        manufacturerRoleDto.setName(manufacturerRole.getName());
        return manufacturerRoleDto;
    }

    public static ManufacturerRoleCategoriesResponse getManufacturerRoleCategoriesResponseByManufacturerRoleCategory(List<ManufacturerRoleCategory> manufacturerRoleCategories) {
        List<ManufacturerRoleCategoryDto> manufacturerRoleCategoryDtos = manufacturerRoleCategories.stream()
                .map(role -> getManufacturerRoleCategory(role)).collect(Collectors.toList());
        ManufacturerRoleCategoriesData manufacturerRolesData = new ManufacturerRoleCategoriesData();
        manufacturerRolesData.setManufacturerRoleCategory(manufacturerRoleCategoryDtos);
        ManufacturerRoleCategoriesResponse manufacturerRoleCategoriesResponse = ManufacturerRoleCategoriesResponse.builder()
                .data(manufacturerRolesData)
                .statusCode(StatusCode.SUCCESS.code)
                .build();
        return manufacturerRoleCategoriesResponse;
    }

    private static ManufacturerRoleCategoryDto getManufacturerRoleCategory(ManufacturerRoleCategory manufacturerRoleCategory) {
        ManufacturerRoleCategoryDto manufacturerRoleCategoryDto = new ManufacturerRoleCategoryDto();
        manufacturerRoleCategoryDto.setId(manufacturerRoleCategory.getId());
        manufacturerRoleCategoryDto.setName(manufacturerRoleCategory.getName());
        return manufacturerRoleCategoryDto;
    }
}
