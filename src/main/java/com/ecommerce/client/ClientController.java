package com.ecommerce.client;

import com.ecommerce.client.exceptions.ClientNotFoundException;
import com.ecommerce.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/allClient")
    public List<ClientDto> getAllClient(){
        return clientService.findAllClient();
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<ClientDto> getClient(@RequestParam String name) throws ClientNotFoundException {
        return new ResponseEntity<>(clientService.findClientByNom(name), HttpStatus.OK);
    }

}
