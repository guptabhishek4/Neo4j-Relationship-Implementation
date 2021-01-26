package com.neo4j.demo.service;

import com.neo4j.demo.exception.ProjectAlreadyExistsException;
import com.neo4j.demo.model.Project;

import java.util.List;

public interface ProjectService
{
    Project addProject(Project project) throws ProjectAlreadyExistsException;
    Project getProjectByName(String projectName);
    List<Project> getAllProjects();
}