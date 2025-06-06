package com.feedback.feedback_service.controller;

import com.feedback.feedback_service.model.Feedback;
import com.feedback.feedback_service.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;



    @PostMapping
    public Feedback submitFeedback(@RequestBody Feedback feedback){
        return feedbackService.saveFeedback(feedback);
    }



}
