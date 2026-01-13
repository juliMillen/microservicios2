package com.jm.destinatarios.Controller;

import com.jm.destinatarios.DTO.RecipientDTO;
import com.jm.destinatarios.Entity.Recipient;
import com.jm.destinatarios.Service.RecipientService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipient")
public class RecipientController {

    @Autowired
    private RecipientService recipientService;

    @GetMapping("/shipment/{id}")
    public ResponseEntity<RecipientDTO> getRecipient(@PathVariable Long id){
        RecipientDTO toSearch = recipientService.getRecipientByShipment(id);
        return new ResponseEntity<>(toSearch, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<RecipientDTO>> getAllRecipients(){
        return new ResponseEntity<>(recipientService.getAllRecipients(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createRecipient(@RequestBody Recipient recipient){
        recipientService.createRecipient(recipient);
        return new ResponseEntity<>("Recipient created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateRecipient(@PathVariable Long id,@RequestBody Recipient recipient){
        recipientService.updateRecipient(id, recipient);
        return new ResponseEntity<>("Recipient updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRecipient(@PathVariable Long id){
        recipientService.deleteRecipient(id);
        return new ResponseEntity<>("Recipient deleted successfully", HttpStatus.NO_CONTENT);

    }
}
