package com.ecommerce.client;

import com.ecommerce.client.exceptions.ClientAlreadyExistsException;
import com.ecommerce.client.exceptions.ClientNotFoundException;
import com.ecommerce.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<ClientDto> getAllClient(){
        return clientService.findAllClient();
    }

     @GetMapping("/find/{name}")
    public List<ClientDto> getClient(@PathVariable String firstName) throws ClientNotFoundException {
        return clientService.findClientByNom(firstName);
    }

    @PostMapping("/save")
    public ClientDto saveClient(@RequestBody ClientDto clientDto)throws ClientAlreadyExistsException{
        //UUID uuid = UUID.randomUUID();
        //clientDto.setId(uuid.toString());
        return clientService.saveClient(clientDto);
    }

    @PutMapping("/update")
    public ClientDto updateClient(@RequestBody ClientDto clientDto){
        return clientService.updateClient(clientDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable(name = "id") String idClient){
        clientService.deleteClient(idClient);
    }
}
