package com.neo4j.demo.exception;

public class UserAlreadyExistsException extends Exception
{
    public UserAlreadyExistsException() {
    }
    public UserAlreadyExistsException(String message) {
        super(message);
    }

}
