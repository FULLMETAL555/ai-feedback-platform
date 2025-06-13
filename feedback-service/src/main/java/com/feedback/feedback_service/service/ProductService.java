package com.feedback.feedback_service.service;

import com.feedback.feedback_service.model.Client;
import com.feedback.feedback_service.model.Product;
import com.feedback.feedback_service.repository.ClientRepository;
import com.feedback.feedback_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ClientRepository clientRepository;

    public Product addProduct(String apiKey,Product product){

        Client client=clientRepository.findByApiKey(apiKey).orElseThrow(()-> new RuntimeException("Invalid Apikey"));
        product.setClient(client);
        return productRepository.save(product);
    }

    public Product findById(long productID) {
        return productRepository.findById(productID).orElseThrow(()->new RuntimeException("This product does not exist"));
    }
}
