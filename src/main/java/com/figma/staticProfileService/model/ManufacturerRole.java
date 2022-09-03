package com.figma.staticProfileService.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author : Khalid Hasan
 */
@Entity(name = "Manufacturer_Role")
@Data
@NoArgsConstructor
public class ManufacturerRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Status_Id")
    private String statusId;
}
