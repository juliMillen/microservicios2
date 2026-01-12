package com.jm.destinatarios.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipientDTO {

    private Long idRecipient;

    private String name;

    private String surname;

    private String dni;

    private String address;

    private String phoneNumber;

    private List<ShipmentDTO> shipments;
}
