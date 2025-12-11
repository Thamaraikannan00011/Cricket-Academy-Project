package com.example.cricketacademy.controller;

import com.example.cricketacademy.entity.Batch;
import com.example.cricketacademy.service.BatchService;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
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
    public @NonNull List<Batch> getAll() {
        return batchService.getAll();
    }

    @GetMapping("/{id}")
    public @NonNull Batch getById(@PathVariable @NonNull Long id) {
        return batchService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public @NonNull Batch create(@RequestBody @NonNull Batch batch) {
        return batchService.create(batch);
    }

    @PutMapping("/{id}")
    public @NonNull Batch update(@PathVariable @NonNull Long id,
                                 @RequestBody @NonNull Batch batch) {
        return batchService.update(id, batch);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NonNull Long id) {
        batchService.delete(id);
    }
}
