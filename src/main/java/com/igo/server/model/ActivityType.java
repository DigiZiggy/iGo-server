package com.igo.server.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "activity_type")
public class ActivityType {
//    DIVING, FOOTBALL, TENNIS,
//    FISHING, GYM, WALKING,
//    CYCLING, RUNNING, DISCGOLF,
//    BASKETBALL, VOLLEYBALL, HOCKEY;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    public String name;

    @ManyToMany(mappedBy = "userActivityTypes")
    Set<User> usersEnlisted;

    @OneToMany(mappedBy="eventActivityType")
    private Set<Event> eventsOfThisActivity;
}
