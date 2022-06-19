package dev.saariselka.inlol.exception;

public class ApiException extends RuntimeException{
    public ApiException(String message) {
        super(message);
    }
}
