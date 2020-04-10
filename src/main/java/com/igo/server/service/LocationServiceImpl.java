package com.igo.server.service;

import com.igo.server.model.Location;
import com.igo.server.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location updateLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public void deleteLocation(Long locationId) {
        locationRepository.deleteById(locationId);
    }

    @Override
    public Location findLocationById(Long locationId) {
        return locationRepository.findById(locationId).orElse(null);
    }

    @Override
    public List<Location> findAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Long numberOfLocations() {
        return locationRepository.count();
    }
}
