package com.figma.staticProfileService.repopsitory;

import com.figma.staticProfileService.model.ManufacturerRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Khalid Hasan
 */
@Repository
public interface ManufacturerRoleRepository extends CrudRepository<ManufacturerRole, Long> {
    List<ManufacturerRole> findManufacturerRoleByStatusId(String statusId);
}
