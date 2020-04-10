package com.igo.server.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Data
@Entity
@Table(name="event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @ManyToMany(mappedBy = "userEvents")
    Set<User> usersRegistered;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="location_id", nullable=false)
    private Location eventCoordinates;

    @ManyToOne
    @JoinColumn(name="activity_type_id", nullable=false)
    private ActivityType eventActivityType;

    @OneToMany(mappedBy="event")
    private Set<EventTask> eventTasks;
}
