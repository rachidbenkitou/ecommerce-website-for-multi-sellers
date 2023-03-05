package com.ecommerce;

import com.ecommerce.client.Client;
import com.ecommerce.client.ClientRepository;
import com.ecommerce.user.User;
import com.ecommerce.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class EcommerceApplication implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public EcommerceApplication(UserRepository userRepository, ClientRepository clientRepository) {
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if(userRepository.findAll().isEmpty()){

            userRepository.save(new User("B123","Youssef","el mahdoubi","abdlkbir@gmail.com","admin","oulad teima"));
        }
        clientRepository.save(new Client("Z542","Client"));
        for(User user: userRepository.findAll()){
            System.out.println(user);
        }
        for(Client client: clientRepository.findAll()){
            System.out.println(client);
        }
    }
}
