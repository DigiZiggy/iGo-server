package com.igo.server.service;

import com.igo.server.model.EventTask;
import com.igo.server.repository.EventTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventTaskServiceImpl implements EventTaskService {

    @Autowired
    private EventTaskRepository eventTaskRepository;

    @Override
    public EventTask saveEventTask(final EventTask eventTask) {
        return eventTaskRepository.save(eventTask);
    }

    @Override
    public EventTask updateEventTask(final EventTask eventTask) {
        return eventTaskRepository.save(eventTask);
    }

    @Override
    public void deleteEventTask(final Long eventTaskId) {
        eventTaskRepository.deleteById(eventTaskId);
    }

    @Override
    public EventTask findEventTaskById(final Long eventTaskId) {
        return eventTaskRepository.findById(eventTaskId).orElse(null);
    }

    @Override
    public List<EventTask> findAllEventTasks() {
        return eventTaskRepository.findAll();
    }

    @Override
    public Long numberOfEventTasks() {
        return eventTaskRepository.count();
    }
}
