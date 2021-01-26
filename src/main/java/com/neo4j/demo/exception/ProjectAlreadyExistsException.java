package com.neo4j.demo.exception;

public class ProjectAlreadyExistsException extends Exception
{
    public ProjectAlreadyExistsException() {
    }
    public ProjectAlreadyExistsException(String message) {
        super(message);
    }
}