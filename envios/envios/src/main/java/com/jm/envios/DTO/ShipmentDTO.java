package com.jm.envios.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentDTO {

    private Long idShipment;

    private LocalDate creationDate;

    private String estate;

    private String description;

    private Long idClient;
}
