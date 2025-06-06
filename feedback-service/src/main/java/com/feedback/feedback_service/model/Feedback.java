package com.feedback.feedback_service.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Data
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String type;

    private String message;

    private String submittedBy;

    private LocalDateTime submittedAt;

    private String sentiment;

    @PrePersist
    public void prePersist(){
        this.submittedAt = LocalDateTime.now();
    }

}
