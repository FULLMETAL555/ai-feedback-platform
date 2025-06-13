package com.feedback.feedback_service.service;


import com.feedback.feedback_service.dto.FeedbackRequestDTO;
import com.feedback.feedback_service.model.Feedback;
import com.feedback.feedback_service.model.Product;
import com.feedback.feedback_service.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public Feedback saveFeedback(FeedbackRequestDTO dto, Product product){
        Feedback feedback=new Feedback();
        feedback.setType(dto.getType());
        feedback.setMessage(dto.getMessage());
        feedback.setSubmittedBy(dto.getSubmittedBy());
        feedback.setProduct(product);

        return feedbackRepository.save(feedback);
    }
}
