package com.ecommerce.client.service;



import com.ecommerce.client.Client;
import com.ecommerce.client.ClientDto;
import com.ecommerce.client.ClientMapper;
import com.ecommerce.client.ClientRepository;
import com.ecommerce.client.exceptions.ClientAlreadyExistsException;
import com.ecommerce.client.exceptions.ClientNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class ClientServiceImplement implements  ClientService{

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientMapper clientMapper;

    @Override
    public List<ClientDto> findAllClient(){
        return clientMapper.modelToDtos(clientRepository.findAll());
    }

    @Override
    public List<ClientDto> findClientByNom(String firstName)throws ClientNotFoundException{
        /*Optional<Client> client=Optional.ofNullable(clientRepository.findByFirstName(nom));
        if(!client.isPresent())
            throw new ClientNotFoundException("No client found");*/
        List<Client> clients = clientRepository.findByFirstName(firstName);
        return clientMapper.modelToDtos(clients);
    }
    private ClientDto addClient(ClientDto clientDto){
        Client client = clientMapper.dtoToModel(clientDto);
        Client updatedClient = clientRepository.save(client);
        return clientMapper.modelToDto(updatedClient);
    }
    @Override
    public ClientDto saveClient(ClientDto clientDto) throws ClientAlreadyExistsException {
        Optional<Client> existingClient = clientRepository.findById(clientDto.getId());
        if(existingClient.isPresent()) throw new ClientAlreadyExistsException("Client Already Exists");
        return addClient(clientDto);
    }
    @Override
    public ClientDto updateClient(ClientDto clientDto){
        return addClient(clientDto);
    }

    @Override
    public void deleteClient(String id) throws ClientNotFoundException {
        clientRepository.findById(id).orElseThrow(()->new ClientNotFoundException("client not found"));
        clientRepository.deleteById(id);
    }
}