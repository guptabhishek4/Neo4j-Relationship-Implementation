package com.neo4j.demo.repository;

import com.neo4j.demo.model.UserProfile;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProfileRepository extends Neo4jRepository<UserProfile,String>
{
    List<UserProfile> findByFirstName(String firstName);
    List<UserProfile> findByFirstNameAndLastName(String firstName,String lastName);


    //MATCH (a),(b) WHERE a.email="abhishek1.gupta@gmail.com" and b.projectName="Quantum"
    //MERGE (a)-[:APPLIES_FOR]->(b)
    @Query("MATCH (a:UserProfile),(b:Project) WHERE a.email=$email and b.projectName=$projectName MERGE (a)-[:APPLIES_FOR]->(b) ")
    void addRelationshipBetweenUserAndProject(String email,String projectName);

}
