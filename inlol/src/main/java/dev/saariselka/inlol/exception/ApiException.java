package dev.saariselka.inlol.exception;

public class ApiException extends RuntimeException{
    APIType type;

    public ApiException(String message, APIType type) {
        super(message);
        this.type = type;
    }

}
