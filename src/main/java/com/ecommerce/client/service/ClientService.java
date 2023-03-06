package com.ecommerce.client.service;

import com.ecommerce.client.ClientDto;
import com.ecommerce.client.exceptions.ClientAlreadyExistsException;
import com.ecommerce.client.exceptions.ClientNotFoundException;

import java.util.List;

public interface ClientService {

    List<ClientDto> findAllClient();

    List<ClientDto> findClientByNom(String id) throws ClientNotFoundException;

    ClientDto saveClient(ClientDto clientDto) throws ClientAlreadyExistsException;

    ClientDto updateClient(ClientDto clientDto);

    void deleteClient(String id) throws ClientNotFoundException;
}
