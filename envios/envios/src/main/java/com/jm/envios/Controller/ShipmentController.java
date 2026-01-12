package com.jm.envios.Controller;

import com.jm.envios.DTO.ShipmentDTO;
import com.jm.envios.Entity.Shipment;
import com.jm.envios.Service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {

    @Autowired
    private ShipmentService shipmentService;

    @GetMapping("/list/{idClient}")
    public ResponseEntity<List<ShipmentDTO>> findAllShipmentsByIdClient(@PathVariable Long idClient){
        List<ShipmentDTO> list = shipmentService.findAllShipmentsByIdClient(idClient);
        return new  ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Shipment>> listaShipments(){
        List<Shipment> list = shipmentService.findAllShipments();
        return new  ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shipment> findShipmentById(@PathVariable Long id){
        Shipment shipment = shipmentService.findShipmentById(id);
        return new ResponseEntity<>(shipment, HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<String> createShipment(@RequestBody Shipment shipment){
        shipmentService.createShipment(shipment);
        return new ResponseEntity<>("Shipment created", HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateShipment(@PathVariable Long id,@RequestBody Shipment shipment){
        shipmentService.updateShipment(id, shipment);
        return new ResponseEntity<>("Shipment updated", HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteShipmentById(@PathVariable Long id){
        shipmentService.deleteShipment(id);
        return new ResponseEntity<>("Shipment deleted", HttpStatus.NO_CONTENT);
    }
}
