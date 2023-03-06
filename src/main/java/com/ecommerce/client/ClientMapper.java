<<<<<<< HEAD
package com.ecommerce.client;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface ClientMapper {

    Client dtoToModel(ClientDto clientDto);

    ClientDto modelToDto(Client client);

    List<ClientDto> modelToDtos(List<Client> clients);
}
=======
package com.ecommerce.client;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client dtoToModel(ClientDto clientDto);

    ClientDto modelToDto(Client client);

    List<ClientDto> modelToDtos(List<Client> clients);
}
>>>>>>> 4fd60159d56d751dc9c3219729c6aec6c20f7c09
