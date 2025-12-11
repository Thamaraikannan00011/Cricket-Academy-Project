package com.example.cricketacademy.service;

import com.example.cricketacademy.entity.Coach;
import com.example.cricketacademy.exception.NotFoundException;
import com.example.cricketacademy.repository.CoachRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoachService {

    private final CoachRepository coachRepository;

    public CoachService(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    public List<Coach> getAll() {
        return coachRepository.findAll();
    }

    public Coach getById(Long id) {
        Optional<Coach> optional = coachRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NotFoundException("Coach not found with id " + id);
        }
    }

    public Coach create(Coach coach) {
        return coachRepository.save(coach);
    }

    public Coach update(Long id, Coach updated) {
        Coach existing = getById(id);
        existing.setFullName(updated.getFullName());
        existing.setSpecialty(updated.getSpecialty());
        existing.setExperienceYears(updated.getExperienceYears());
        return coachRepository.save(existing);
    }

    public void delete(Long id) {
        coachRepository.deleteById(id);
    }
}
