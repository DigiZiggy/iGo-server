package com.igo.server.service;

import com.igo.server.model.Event;
import com.igo.server.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event saveEvent(final Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(final Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void deleteEvent(final Long eventId) {
        eventRepository.deleteById(eventId);
    }

    @Override
    public Event findEventById(final Long eventId) {
        return eventRepository.findById(eventId).orElse(null);
    }

    @Override
    public List<Event> findAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Long numberOfEvents() {
        return eventRepository.count();
    }
}
