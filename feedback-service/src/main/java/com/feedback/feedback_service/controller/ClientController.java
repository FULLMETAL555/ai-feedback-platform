package com.feedback.feedback_service.controller;

import com.feedback.feedback_service.model.Client;
import com.feedback.feedback_service.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping("/register")
    public Client registerClient(@RequestBody Client client){
        return clientService.registerClient(client);
    }

    @GetMapping("/verify")
    public boolean verifyApiKey(@RequestHeader("X-API-KEY") String apiKey){
        return clientService.getClientByApiKey(apiKey).isPresent();
    }
}
