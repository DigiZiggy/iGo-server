package com.igo.server.controller;

import com.igo.server.jwt.JwtTokenProvider;
import com.igo.server.model.Event;
import com.igo.server.model.EventTask;
import com.igo.server.model.Role;
import com.igo.server.model.User;
import com.igo.server.service.EventService;
import com.igo.server.service.EventTaskService;
import com.igo.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;

@RestController
public class UserController {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserService userService;

    @Autowired
    private EventService eventService;

    @Autowired
    private EventTaskService eventTaskService;

    @PostMapping("/api/user/registration")
    public ResponseEntity<?> register(@RequestBody User user){
        System.out.println("GETS TO REGISTRATION!!!!");

        if(userService.findByUsername(user.getUsername())!=null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        user.setRole(Role.USER);
        System.out.println("User ROLE set");
        System.out.println(user.getRole());
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/api/user/login")
    public ResponseEntity<?> getUser(Principal principal){
		//principal = httpServletRequest.getUserPrincipal.
        System.out.println("GET TO LOGIN: getUser()");
        if(principal == null){
            System.out.println("principal is NULL");
            //logout will also use here so we should return ok http status.
            return ResponseEntity.ok(principal);
        }
        System.out.println("principal:  " + principal);

        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) principal;

        System.out.println("authenticationToken:  " + authenticationToken);

        User user = userService.findByUsername(authenticationToken.getName());
        System.out.println("USER:  " + user.toString());
        user.setToken(tokenProvider.generateToken(authenticationToken));

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/api/user/event-create")
    public ResponseEntity<?> createEvent(@RequestBody Event event){
        return new ResponseEntity<>(eventService.saveEvent(event), HttpStatus.CREATED);
    }

    @PutMapping("/api/user/event-update")
    public ResponseEntity<?> updateEvent(@RequestBody Event event){
        return new ResponseEntity<>(eventService.updateEvent(event), HttpStatus.CREATED);
    }

    @DeleteMapping("/api/user/event-delete")
    public ResponseEntity<?> deleteEvent(@RequestBody Event event){
        eventService.deleteEvent(event.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/api/user/events")
    public ResponseEntity<?> getAllEvents(){
        return new ResponseEntity<>(eventService.findAllEvents(), HttpStatus.OK);
    }

    @PostMapping("/api/user/event/addTask")
    public ResponseEntity<?> purchaseProduct(@RequestBody EventTask eventTask){
        eventTaskService.saveEventTask(eventTask);
        return new ResponseEntity<>(eventTask, HttpStatus.CREATED);
    }
}
