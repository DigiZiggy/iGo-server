package com.igo.server.service;

import com.igo.server.model.Location;

import java.util.List;

public interface LocationService {

    Location saveLocation(Location location);

    Location updateLocation(Location location);

    void deleteLocation(Long locationId);

    Location findLocationById(Long locationId);

    List<Location> findAllLocations();

    Long numberOfLocations();
}
