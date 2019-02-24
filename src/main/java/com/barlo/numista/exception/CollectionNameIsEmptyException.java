package com.barlo.numista.exception;

public class CollectionNameIsEmptyException extends AbstractNumistaException {

    private String message;

    public CollectionNameIsEmptyException() {
        this.message = "Please chose Collection name";
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getException() {
        return "Collection name is not set";
    }
}
