package com.example.cricketacademy.service;

import com.example.cricketacademy.entity.Batch;
import com.example.cricketacademy.exception.NotFoundException;
import com.example.cricketacademy.repository.BatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatchService {

    private final BatchRepository batchRepository;

    public BatchService(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    public List<Batch> getAll() {
        return batchRepository.findAll();
    }

    public Batch getById(Long id) {
        Optional<Batch> optional = batchRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NotFoundException("Batch not found with id " + id);
        }
    }

    public Batch create(Batch batch) {
        return batchRepository.save(batch);
    }

    public Batch update(Long id, Batch updated) {
        Batch existing = getById(id);
        existing.setName(updated.getName());
        existing.setLevel(updated.getLevel());
        existing.setStartTime(updated.getStartTime());
        existing.setEndTime(updated.getEndTime());
        return batchRepository.save(existing);
    }

    public void delete(Long id) {
        batchRepository.deleteById(id);
    }
}
