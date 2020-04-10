package com.igo.server.service;


import com.igo.server.model.Event;

import java.util.List;

public interface EventService {

    Event saveEvent(Event event);

    Event updateEvent(Event event);

    void deleteEvent(Long eventId);

    Event findEventById(Long eventId);

    List<Event> findAllEvents();

    Long numberOfEvents();
}
