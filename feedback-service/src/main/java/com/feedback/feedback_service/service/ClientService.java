package com.feedback.feedback_service.service;

import com.feedback.feedback_service.model.Client;
import com.feedback.feedback_service.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client registerClient(Client client){
        return clientRepository.save(client);
    }

    public Optional<Client> getClientByApiKey(String apiKey){
        return clientRepository.findByApiKey(apiKey);
    }

}
