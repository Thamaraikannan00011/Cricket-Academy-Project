package com.example.cricketacademy.controller;

import com.example.cricketacademy.entity.Coach;
import com.example.cricketacademy.service.CoachService;
import org.springframework.http.HttpStatus;
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
    public List<Coach> getAll() {
        return coachService.getAll();
    }

    @GetMapping("/{id}")
    public Coach getById(@PathVariable Long id) {
        return coachService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Coach create(@RequestBody Coach coach) {
        return coachService.create(coach);
    }

    @PutMapping("/{id}")
    public Coach update(@PathVariable Long id, @RequestBody Coach coach) {
        return coachService.update(id, coach);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        coachService.delete(id);
    }
}
