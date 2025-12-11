package com.example.cricketacademy.repository;

import com.example.cricketacademy.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByBatchId(Long batchId);
}
