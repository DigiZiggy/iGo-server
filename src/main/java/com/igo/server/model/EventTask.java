package com.igo.server.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name="event_task")
public class EventTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="start_time")
    private LocalDateTime startTime;

    @Column(name="end_time")
    private LocalDateTime endTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="event_id", nullable=false)
    private Event event;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "task_user",
            joinColumns =  @JoinColumn(name = "event_task_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> usersAssignedToTask;

}
