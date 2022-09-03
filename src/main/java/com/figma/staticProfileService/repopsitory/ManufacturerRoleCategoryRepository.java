package com.figma.staticProfileService.repopsitory;

import com.figma.staticProfileService.model.ManufacturerRoleCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author : Khalid Hasan
 */
public interface ManufacturerRoleCategoryRepository extends CrudRepository<ManufacturerRoleCategory, Long> {
   List<ManufacturerRoleCategory> findManufacturerRoleCategoryByManufacturerRoleIdAndStatusId(Long manufacturerRoleId, String statusId);
}
