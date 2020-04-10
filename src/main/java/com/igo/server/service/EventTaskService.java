package com.igo.server.service;

import com.igo.server.model.EventTask;

import java.util.List;

public interface EventTaskService {

    EventTask saveEventTask(EventTask eventTask);

    EventTask updateEventTask(EventTask eventTask);

    void deleteEventTask(Long eventTaskId);

    EventTask findEventTaskById(Long eventTaskId);

    List<EventTask> findAllEventTasks();

    Long numberOfEventTasks();
}
