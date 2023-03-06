package com.ecommerce.client;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client dtoToModel(ClientDto clientDto);

    ClientDto modelToDto(Client client);
    List<ClientDto> modelToDtos(List<Client> clients);
}
