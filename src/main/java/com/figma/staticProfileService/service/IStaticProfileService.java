package com.figma.staticProfileService.service;

import com.figma.staticProfileService.response.ManufacturerRoleCategoriesResponse;
import com.figma.staticProfileService.response.ManufacturerRolesResponse;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletionStage;

/**
 * @author : Khalid Hasan
 */
@Service
public interface IStaticProfileService {
    CompletionStage<ManufacturerRolesResponse> getManufacturerRole();

    CompletionStage<ManufacturerRoleCategoriesResponse> getManufacturerRoleCategory(Long roleId);
}
