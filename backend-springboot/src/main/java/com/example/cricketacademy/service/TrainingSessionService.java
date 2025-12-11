package com.example.cricketacademy.service;

import com.example.cricketacademy.entity.TrainingSession;
import com.example.cricketacademy.exception.NotFoundException;
import com.example.cricketacademy.repository.TrainingSessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingSessionService {

    private final TrainingSessionRepository sessionRepository;

    public TrainingSessionService(TrainingSessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<TrainingSession> getAll() {
        return sessionRepository.findAll();
    }

    public TrainingSession getById(Long id) {
        return sessionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Session not found with id " + id));
    }

    public TrainingSession create(TrainingSession session) {
        return sessionRepository.save(session);
    }

    public TrainingSession update(Long id, TrainingSession updated) {
        TrainingSession existing = getById(id);
        existing.setStartDateTime(updated.getStartDateTime());
        existing.setEndDateTime(updated.getEndDateTime());
        existing.setFocusArea(updated.getFocusArea());
        existing.setBatch(updated.getBatch());
        existing.setCoach(updated.getCoach());
        return sessionRepository.save(existing);
    }

    public void delete(Long id) {
        sessionRepository.deleteById(id);
    }
}
