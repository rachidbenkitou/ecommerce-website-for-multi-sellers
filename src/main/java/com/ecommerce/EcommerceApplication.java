package com.ecommerce;

import com.ecommerce.client.Client;
import com.ecommerce.client.ClientDto;
import com.ecommerce.client.ClientRepository;
import com.ecommerce.client.service.ClientService;
import com.ecommerce.supplier.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class EcommerceApplication implements CommandLineRunner {

    private final ClientRepository clientRepository;
    private final ClientService clientService;
    private final SupplierRepository supplierRepository;

    @Autowired
    public EcommerceApplication(ClientRepository clientRepository, ClientService clientService, SupplierRepository supplierRepository) {

        this.clientRepository = clientRepository;
        this.clientService = clientService;
        this.supplierRepository = supplierRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

/*

            if(clientRepository.findAll().isEmpty()){
            clientRepository.save(new Client("B123","Youssef","el mahdoubi","Youssef@gmail.com","admin","khouribga"));
            clientRepository.save(new Client("A123","Abdelkabir","el bahmadi","abdlkbir@gmail.com","admin","oulad teima"));
            clientRepository.save(new Client("C123","Rachid","benkitou","Rachid@gmail.com","admin","casablanca"));
        }
        clientService.updateClient(new ClientDto("C123","Rachid","benkitou","Rachid@gmail.com","admin","casablanca"));
        clientRepository.save(new Client("D123","Rachid","benkitou","Rachid@gmail.com","admin","casablanca"));
*/
        //clientService.saveClient(new ClientDto("S123","save","el save","save@gmail.com","user","city save"));

        /*clientRepository.save(new Client("Z542","Client"));
        for(User user: userRepository.findAll()){
            System.out.println(user);
        }
        for(Client client: clientRepository.findAll()){
            System.out.println(client);
        }*/
    }
}
