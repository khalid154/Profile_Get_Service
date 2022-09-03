package com.figma.staticProfileService.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author : Khalid Hasan
 */

@Data
@NoArgsConstructor
@Entity(name = "Manufacturer_Role_Category")
public class ManufacturerRoleCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Manufacturer_Role_Id")
    private Long manufacturerRoleId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Status_Id")
    private String statusId;
}
