package com.feedback.feedback_service.repository;

import com.feedback.feedback_service.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback,Long> {
}
