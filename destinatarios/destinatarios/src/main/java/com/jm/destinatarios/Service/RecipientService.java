package com.jm.destinatarios.Service;

import com.jm.destinatarios.DTO.RecipientDTO;
import com.jm.destinatarios.DTO.ShipmentDTO;
import com.jm.destinatarios.Entity.Recipient;
import com.jm.destinatarios.Repository.ShipmentClient;
import com.jm.destinatarios.Repository.iRecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipientService {

    @Autowired
    private iRecipientRepository recipientRepository;

    @Autowired
    private ShipmentClient shipmentClient;


    public RecipientDTO getRecipientByShipment(Long id){
        Recipient recipient = recipientRepository.findById(id).orElseThrow( () -> new RuntimeException("Recipient not found") );

        //llamo al otro microservicio
        List<ShipmentDTO> shipments = shipmentClient.getShipmentsByRecipientId(id);

        //armo el DTO

        RecipientDTO dto = new RecipientDTO();
        dto.setIdRecipient(recipient.getIdRecipient());
        dto.setName(recipient.getName());
        dto.setSurname(recipient.getSurname());
        dto.setDni(recipient.getDni());
        dto.setPhoneNumber(recipient.getPhoneNumber());
        dto.setAddress(recipient.getAddress());
        dto.setShipments(shipments);
        return dto;
    }

    public List<RecipientDTO> getAllRecipients(){
        List<Recipient> listRecipients = recipientRepository.findAll();
        List<RecipientDTO> recipients = new ArrayList<>();
        for(Recipient recipient : listRecipients){
            RecipientDTO dto = new RecipientDTO();
            dto.setIdRecipient(recipient.getIdRecipient());
            dto.setName(recipient.getName());
            dto.setSurname(recipient.getSurname());
            dto.setDni(recipient.getDni());
            recipients.add(dto);
        }
        return recipients;
    }

    public RecipientDTO getRecipientById(Long id){
        Recipient toSearch = recipientRepository.findById(id).orElseThrow( () -> new RuntimeException("Recipient not found") );
        RecipientDTO dto = new RecipientDTO();
        dto.setIdRecipient(toSearch.getIdRecipient());
        dto.setName(toSearch.getName());
        dto.setSurname(toSearch.getSurname());
        dto.setDni(toSearch.getDni());
        dto.setPhoneNumber(toSearch.getPhoneNumber());
        dto.setAddress(toSearch.getAddress());
        return dto;
    }

    public void createRecipient(Recipient recipient){
        if(recipient == null){
            throw new RuntimeException("Recipient not found");
        }
        recipientRepository.save(recipient);
    }

    public void updateRecipient(Long id,Recipient recipient){
        Recipient toUpdate = recipientRepository.findById(id).orElseThrow( () -> new RuntimeException("Recipient not found") );
        toUpdate.setName(recipient.getName());
        toUpdate.setSurname(recipient.getSurname());
        toUpdate.setDni(recipient.getDni());
        toUpdate.setPhoneNumber(recipient.getPhoneNumber());
        toUpdate.setAddress(recipient.getAddress());
        recipientRepository.save(toUpdate);
    }

    public void deleteRecipient(Long id){
        recipientRepository.deleteById(id);
    }
}
