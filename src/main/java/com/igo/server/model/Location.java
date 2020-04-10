package com.igo.server.model;

import lombok.Data;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.util.Set;

@Data
@Entity
@Table(name="location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="latitude")
    private Double latitude;

    @Column(name="longitude")
    private Double longitude;

    @ManyToMany(mappedBy = "userCoordinates")
    Set<User> usersOnLocation;

    @OneToMany(mappedBy="eventCoordinates")
    private Set<Event> eventsOnThisLocation;

    @OneToMany(mappedBy="coordinates")
    private Set<Address> addressesCorrespondingToThisLocation;
}
