package com.example.cricketacademy.repository;

import com.example.cricketacademy.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<Coach, Long> {
}
