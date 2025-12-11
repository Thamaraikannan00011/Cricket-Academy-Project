package com.example.cricketacademy.service;

import com.example.cricketacademy.entity.Player;
import com.example.cricketacademy.exception.NotFoundException;
import com.example.cricketacademy.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    public Player getById(Long id) {
        Optional<Player> optional = playerRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NotFoundException("Player not found with id " + id);
        }
    }

    public Player create(Player player) {
        return playerRepository.save(player);
    }

    public Player update(Long id, Player updated) {
        Player existing = getById(id);
        existing.setFullName(updated.getFullName());
        existing.setAge(updated.getAge());
        existing.setRole(updated.getRole());
        existing.setBattingStyle(updated.getBattingStyle());
        existing.setBowlingStyle(updated.getBowlingStyle());
        existing.setBatch(updated.getBatch());
        existing.setJoinDate(updated.getJoinDate());
        return playerRepository.save(existing);
    }

    public void delete(Long id) {
        playerRepository.deleteById(id);
    }
}
