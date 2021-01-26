package com.neo4j.demo.repository;

import com.neo4j.demo.model.Project;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends Neo4jRepository<Project,String>
{
    Project findByProjectName(String projectName);
}