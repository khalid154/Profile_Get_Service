package com.figma.staticProfileService.response;

import lombok.Builder;
import lombok.Data;

/**
 * @author : Khalid Hasan
 */
@Data
@Builder
public class ManufacturerRoleCategoriesResponse {
    private int statusCode;
    private ManufacturerRoleCategoriesData data;
}
