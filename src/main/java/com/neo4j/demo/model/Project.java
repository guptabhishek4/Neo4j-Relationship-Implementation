package com.neo4j.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label="Project")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project
{
    @Id
    private String projectId;

    private String projectName;

    private String name;

    private int noOfResources;
}
