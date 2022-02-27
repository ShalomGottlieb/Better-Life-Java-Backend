package com.couponsProject.project2.Exceptions;

public class AlreadyExistsException extends Exception{
    public AlreadyExistsException() {
        super("Already exists");
    }

    public AlreadyExistsException(String message) {
        super(message);
    }
}
