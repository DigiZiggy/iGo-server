package com.igo.server.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="address_line1")
    private String addressLine1;

    @Column(name="address_line2")
    private String addressLine2;

    @Column(name="city")
    private String city;

    @Column(name="state")
    private String state;

    @Column(name="postcode")
    private Long postcode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="location_id", nullable=false)
    private Location coordinates;
}
