package com.example.cricketacademy.controller;

import com.example.cricketacademy.entity.TrainingSession;
import com.example.cricketacademy.service.TrainingSessionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class TrainingSessionController {

    private final TrainingSessionService sessionService;

    public TrainingSessionController(TrainingSessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping
    public List<TrainingSession> getAll() {
        return sessionService.getAll();
    }

    @GetMapping("/{id}")
    public TrainingSession getById(@PathVariable Long id) {
        return sessionService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrainingSession create(@RequestBody TrainingSession session) {
        return sessionService.create(session);
    }

    @PutMapping("/{id}")
    public TrainingSession update(@PathVariable Long id, @RequestBody TrainingSession session) {
        return sessionService.update(id, session);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        sessionService.delete(id);
    }
}
