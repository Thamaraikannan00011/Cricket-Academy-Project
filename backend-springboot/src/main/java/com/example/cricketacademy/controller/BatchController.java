package com.example.cricketacademy.controller;

import com.example.cricketacademy.entity.Batch;
import com.example.cricketacademy.service.BatchService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/batches")
public class BatchController {

    private final BatchService batchService;

    public BatchController(BatchService batchService) {
        this.batchService = batchService;
    }

    @GetMapping
    public List<Batch> getAll() {
        return batchService.getAll();
    }

    @GetMapping("/{id}")
    public Batch getById(@PathVariable Long id) {
        return batchService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Batch create(@RequestBody Batch batch) {
        return batchService.create(batch);
    }

    @PutMapping("/{id}")
    public Batch update(@PathVariable Long id, @RequestBody Batch batch) {
        return batchService.update(id, batch);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        batchService.delete(id);
    }
}
