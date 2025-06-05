package com.feedback.feedback_service.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String type;
    @Setter
    private String message;
    @Setter
    private String submittedBy;

    @PrePersist
    public void prePersist(){
        LocalDateTime submittedAt = LocalDateTime.now();
    }

}
