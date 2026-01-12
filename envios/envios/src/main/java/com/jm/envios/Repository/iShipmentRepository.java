package com.jm.envios.Repository;

import com.jm.envios.DTO.ShipmentDTO;
import com.jm.envios.Entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iShipmentRepository extends JpaRepository<Shipment, Long> {


    @Query("SELECT ship FROM Shipment ship WHERE ship.idClient = :idClient  ")
    List<ShipmentDTO> findShipmentById(@Param("idClient") Long idClient);
}
