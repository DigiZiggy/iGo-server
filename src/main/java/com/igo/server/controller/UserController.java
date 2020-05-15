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
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserService userService;

    @PostMapping("/user/registration")
    public ResponseEntity<?> register(@RequestBody User user){
        if(userService.findByUsername(user.getUsername())!=null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        user.setRole(Role.USER);
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/user/login")
    public ResponseEntity<?> getUser(Principal principal){
		//principal = httpServletRequest.getUserPrincipal.
        if(principal == null){
            //logout will also use here so we should return ok http status.
            return ResponseEntity.ok(principal);
        }
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) principal;

        User user = userService.findByUsername(authenticationToken.getName());
        user.setToken(tokenProvider.generateToken(authenticationToken));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/events")
    public ResponseEntity<?> getAllUserEvents(@PathVariable Long userId){
        User user = userService.findUserById(userId);
        return new ResponseEntity<>(user.getUserEvents(), HttpStatus.OK);
    }
}
