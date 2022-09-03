package com.figma.staticProfileService.response;

import lombok.Builder;
import lombok.Data;

/**
 * @author : Khalid Hasan
 */

@Data
@Builder
public class ManufacturerRolesResponse {
    private int statusCode;
    private ManufacturerRolesData data;
}
