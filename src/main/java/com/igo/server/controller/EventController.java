package com.igo.server.controller;

import com.igo.server.jwt.JwtTokenProvider;
import com.igo.server.model.Event;
import com.igo.server.model.EventTask;
import com.igo.server.service.EventService;
import com.igo.server.service.EventTaskService;
import com.igo.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/v1")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private EventTaskService eventTaskService;

    @GetMapping("/events")
    public ResponseEntity<?> getAllEvents(){
        return new ResponseEntity<>(eventService.findAllEvents(), HttpStatus.OK);
    }

    @GetMapping("/events/{eventId}")
    public ResponseEntity<?> getEventById(@PathVariable Long eventId){
        return new ResponseEntity<>(eventService.findEventById(eventId), HttpStatus.OK);
    }

    @PostMapping("/events")
    public ResponseEntity<?> createEvent(@RequestBody Event event){
        return new ResponseEntity<>(eventService.saveEvent(event), HttpStatus.CREATED);
    }

    @PatchMapping("/events")
    public ResponseEntity<?> modifyEvent(@RequestBody Event event){
        return new ResponseEntity<>(eventService.updateEvent(event), HttpStatus.CREATED);
    }

    @DeleteMapping("/events")
    public ResponseEntity<?> deleteEvent(@RequestBody Event event){
        eventService.deleteEvent(event.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/events/{eventId}/tasks")
    public ResponseEntity<?> createEventTask(@PathVariable Long eventId, @RequestBody EventTask task){
        Event event = eventService.findEventById(eventId);
        event.setEventTasks(Collections.singleton(task));
        eventService.updateEvent(event);
        return new ResponseEntity<>(eventTaskService.saveEventTask(task), HttpStatus.CREATED);
    }

    @GetMapping("/events/{eventId}/tasks")
    public ResponseEntity<?> getAllEventTasks(@PathVariable Long eventId){
        Event event = eventService.findEventById(eventId);
        return new ResponseEntity<>(event.getEventTasks(), HttpStatus.OK);
    }

    @DeleteMapping("/events/{eventId}/tasks")
    public ResponseEntity<?> deleteEventTask(@PathVariable Long eventId, @RequestBody EventTask task){
        eventTaskService.deleteEventTask(task.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
