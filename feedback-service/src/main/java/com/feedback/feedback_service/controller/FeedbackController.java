package com.feedback.feedback_service.controller;

import com.feedback.feedback_service.dto.FeedbackRequestDTO;
import com.feedback.feedback_service.model.Client;
import com.feedback.feedback_service.model.Feedback;
import com.feedback.feedback_service.model.Product;
import com.feedback.feedback_service.service.ClientService;
import com.feedback.feedback_service.service.FeedbackService;
import com.feedback.feedback_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ClientService clientService;

    @PostMapping
    public Feedback submitFeedback(@RequestHeader("X-API-KEY") String apiKey, @RequestBody FeedbackRequestDTO dto){
        //validate client
        Client client=clientService.getClientByApiKey(apiKey).orElseThrow(()->new RuntimeException("No client Exist"));

        //validate product
        Product product=productService.findById(dto.getProductId());

        if(!product.getClient().getClientId().equals(client.getClientId())){
            throw new RuntimeException("Unauthorized to submit feedback for this product");
        }



        return feedbackService.saveFeedback(dto,product);
    }



}
