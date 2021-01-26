package com.neo4j.demo.service;

import com.neo4j.demo.repository.UserProfileRepository;
import com.neo4j.demo.exception.UserAlreadyExistsException;
import com.neo4j.demo.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserProfileServiceImpl implements UserProfileService
{
    private UserProfileRepository repository;

    @Autowired
    public UserProfileServiceImpl(UserProfileRepository repository) {
        this.repository = repository;
    }


    @Override
    public UserProfile addUserDetails(UserProfile userProfile) throws UserAlreadyExistsException
    {
        Optional<UserProfile> existingUser=repository.findById(userProfile.getEmail());
        if(existingUser.isPresent())
        {
            throw new UserAlreadyExistsException("User already exists");
        }

        userProfile.setName(userProfile.getFirstName().concat("//s"+userProfile.getLastName()));
        UserProfile newUserProfile=repository.save(userProfile);
        repository.addRelationshipBetweenUserAndProject(userProfile.getEmail(), "Quantum");

        return newUserProfile;
    }

    @Override
    public UserProfile getUserByEmail(String email)
    {
        Optional<UserProfile> existingUser=repository.findById(email);
        if(existingUser.isEmpty())
        {
            throw new NoSuchElementException();
        }
        return existingUser.get();
    }

    @Override
    public List<UserProfile> getAllUserDetails()
    {
        return (List<UserProfile>) repository.findAll();
    }


}
