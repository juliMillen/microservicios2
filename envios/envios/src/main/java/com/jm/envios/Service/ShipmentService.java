package com.jm.envios.Service;

import com.jm.envios.DTO.ShipmentDTO;
import com.jm.envios.Entity.Shipment;
import com.jm.envios.Repository.iShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentService {

    @Autowired
    private iShipmentRepository shipmentRepository;

    public List<Shipment> findAllShipments(){
        return shipmentRepository.findAll();
    }

    public Shipment findShipmentById(Long id){
        return shipmentRepository.findById(id).orElse(null);
    }

    public List<ShipmentDTO> findAllShipmentsByIdClient(Long idClient){
        if(idClient==null){
            throw new RuntimeException("idClient is null");
        }
        List<Shipment> list = shipmentRepository.findShipmentById(idClient);

        return  list.stream().map(ship -> {
            ShipmentDTO shipmentDTO = new ShipmentDTO();
            shipmentDTO.setIdClient(ship.getIdClient());
            shipmentDTO.setCreationDate(ship.getCreationDate());
            shipmentDTO.setEstate(ship.getEstate());
            shipmentDTO.setDescription(ship.getDescription());
            shipmentDTO.setIdClient(ship.getIdClient());
            return shipmentDTO;
        }).toList();
    }


    public void createShipment(Shipment shipment){
        if(shipment == null){
            throw new RuntimeException("shipment is null");
        }
        shipmentRepository.save(shipment);
    }

    public void updateShipment(Long id,Shipment shipment){
        Shipment toUpdate = shipmentRepository.findById(id).orElseThrow(() -> new RuntimeException("shipment not found"));
        toUpdate.setDescription(shipment.getDescription());
        toUpdate.setIdClient(shipment.getIdClient());
        toUpdate.setEstate(shipment.getEstate());
        toUpdate.setCreationDate(shipment.getCreationDate());
        shipmentRepository.save(toUpdate);
    }

    public void deleteShipment(Long id){
        Shipment toDelete = shipmentRepository.findById(id).orElseThrow(() -> new RuntimeException("shipment not found"));
        shipmentRepository.delete(toDelete);
    }
}
