package com.igo.server.model;

import antlr.collections.List;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Data
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role role;

    @Transient
    private String token;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_activity_type",
                joinColumns =  @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "activity_type_id"))
    private Set<ActivityType> userActivityTypes;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_event",
            joinColumns =  @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    private Set<Event> userEvents;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_location",
            joinColumns =  @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id"))
    private Set<Location> userCoordinates;

    @ManyToMany(mappedBy = "usersAssignedToTask")
    Set<EventTask> userEventTasks;
}
