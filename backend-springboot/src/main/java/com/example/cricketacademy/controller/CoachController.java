package com.example.cricketacademy.controller;

import com.example.cricketacademy.entity.Coach;
import com.example.cricketacademy.service.CoachService;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coaches")
public class CoachController {

    private final CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping
    public @NonNull List<Coach> getAll() {
        return coachService.getAll();
    }

    @GetMapping("/{id}")
    public @NonNull Coach getById(@PathVariable @NonNull Long id) {
        return coachService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public @NonNull Coach create(@RequestBody @NonNull Coach coach) {
        return coachService.create(coach);
    }

    @PutMapping("/{id}")
    public @NonNull Coach update(@PathVariable @NonNull Long id,
                                 @RequestBody @NonNull Coach coach) {
        return coachService.update(id, coach);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NonNull Long id) {
        coachService.delete(id);
    }
}
