package com.feedback.feedback_service.dto;


import lombok.Data;

@Data
public class FeedbackRequestDTO {
    private String type;
    private String message;
    private String submittedBy;
    private Long productId;
}
