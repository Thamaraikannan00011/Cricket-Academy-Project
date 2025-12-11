package com.example.cricketacademy.entity;

import jakarta.persistence.*;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "batches")
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String level;
    private LocalTime startTime;
    private LocalTime endTime;

    @OneToMany(mappedBy = "batch")
    private Set<Player> players = new HashSet<>();

    @OneToMany(mappedBy = "batch")
    private Set<TrainingSession> sessions = new HashSet<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }

    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    public LocalTime getEndTime() { return endTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }

    public Set<Player> getPlayers() { return players; }
    public void setPlayers(Set<Player> players) { this.players = players; }

    public Set<TrainingSession> getSessions() { return sessions; }
    public void setSessions(Set<TrainingSession> sessions) { this.sessions = sessions; }
}
