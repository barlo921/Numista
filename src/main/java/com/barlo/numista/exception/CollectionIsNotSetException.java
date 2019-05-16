package com.barlo.numista.exception;

public class CollectionIsNotSetException extends AbstractNumistaException {

    private String message;

    public CollectionIsNotSetException() {
        this.message = "You must set Collection for your Subcollection";
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getException() {
        return "Collection is not set";
    }
}
