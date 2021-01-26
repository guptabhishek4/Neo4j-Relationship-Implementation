package com.neo4j.demo.service;

import com.neo4j.demo.exception.UserAlreadyExistsException;
import com.neo4j.demo.model.UserProfile;

import java.util.List;

public interface UserProfileService
{
    UserProfile addUserDetails(UserProfile userProfile) throws UserAlreadyExistsException;
    UserProfile getUserByEmail(String email);
    List<UserProfile> getAllUserDetails();
    //void addRelationshipBetweenUserAndCity(String email,String projectName);
}
