package com.neo4j.demo.controller;

import com.neo4j.demo.exception.UserAlreadyExistsException;
import com.neo4j.demo.model.UserProfile;
import com.neo4j.demo.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/v1/user")
public class UserProfileController
{
    private UserProfileService userProfileService;

    @Autowired
    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }


    @PostMapping("/register")
    public ResponseEntity<?> addUserNode(@RequestBody UserProfile userProfile)
    {
        try
        {
            UserProfile newUserAdded= userProfileService.addUserDetails(userProfile);
            return new ResponseEntity<>(newUserAdded, HttpStatus.CREATED);
        }
        catch (UserAlreadyExistsException existsException)
        {
            return new ResponseEntity<String>("User already exists", HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/fetchuser")
    public ResponseEntity<?> getUser(@RequestParam("email") String email)
    {
        try
        {
            return new ResponseEntity<>(userProfileService.getUserByEmail(email),HttpStatus.OK);
        }
        catch (NoSuchElementException exception)
        {
            return new ResponseEntity<>("User not found",HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUserDetails()
    {
        try
        {
            //userProfileService.addRelationshipBetweenUserAndCity("abhishek1.gupta@gmail.com", "Jaipur");
            return new ResponseEntity<>(userProfileService.getAllUserDetails(),HttpStatus.OK);
        }
        catch (Exception exception)
        {
            return new ResponseEntity<String>("No user found",HttpStatus.CONFLICT);
        }
    }


}
