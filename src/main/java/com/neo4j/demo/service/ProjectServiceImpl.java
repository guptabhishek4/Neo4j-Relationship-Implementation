package com.neo4j.demo.service;

import com.neo4j.demo.exception.ProjectAlreadyExistsException;
import com.neo4j.demo.model.Project;
import com.neo4j.demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService
{
    private ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project addProject(Project project) throws ProjectAlreadyExistsException {
        Optional<Project> existingProject=projectRepository.findById(project.getProjectId());
        if(existingProject.isPresent())
        {
            throw new ProjectAlreadyExistsException("Project already exists");
        }

        project.setName(project.getProjectName());
        Project newProject=projectRepository.save(project);

        return newProject;
    }

    @Override
    public Project getProjectByName(String projectName)
    {
        Project existingProject=projectRepository.findByProjectName(projectName);
        if(existingProject==null)
        {
            throw new NoSuchElementException("Project does not exist");
        }
        return existingProject;
    }

    @Override
    public List<Project> getAllProjects()
    {
        return (List<Project>) projectRepository.findAll();
    }
}
