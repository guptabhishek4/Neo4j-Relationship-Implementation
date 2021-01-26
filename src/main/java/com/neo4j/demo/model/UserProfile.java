package com.neo4j.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.time.LocalDate;

@NodeEntity(label = "UserProfile")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile
{
    @Id
    private String email;

    private String name;
    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private boolean availableForProject;
}

