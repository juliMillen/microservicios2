package com.jm.destinatarios.Repository;

import com.jm.destinatarios.DTO.ShipmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="shipmentClient", url="http://localhost:8080/shipment")
public interface ShipmentClient {

    @GetMapping("/list/{idClient}")
    List<ShipmentDTO> getShipmentsByRecipientId(@PathVariable("idClient") Long idClient);
}
