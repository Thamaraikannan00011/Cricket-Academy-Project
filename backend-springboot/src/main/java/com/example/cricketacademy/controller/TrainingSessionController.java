package com.example.cricketacademy.controller;

import com.example.cricketacademy.entity.TrainingSession;
import com.example.cricketacademy.service.TrainingSessionService;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
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
    public @NonNull List<TrainingSession> getAll() {
        return sessionService.getAll();
    }

    @GetMapping("/{id}")
    public @NonNull TrainingSession getById(@PathVariable @NonNull Long id) {
        return sessionService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public @NonNull TrainingSession create(@RequestBody @NonNull TrainingSession session) {
        return sessionService.create(session);
    }

    @PutMapping("/{id}")
    public @NonNull TrainingSession update(@PathVariable @NonNull Long id,
                                           @RequestBody @NonNull TrainingSession session) {
        return sessionService.update(id, session);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NonNull Long id) {
        sessionService.delete(id);
    }
}
