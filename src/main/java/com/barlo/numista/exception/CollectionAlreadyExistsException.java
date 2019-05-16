package com.barlo.numista.exception;

public class CollectionAlreadyExistsException extends AbstractNumistaException {

    private String message;

    public CollectionAlreadyExistsException(final String collectionName) {
        this.message = "Collection with \"" + collectionName + "\" already exists";
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getException() {
        return "Such collection already exists";
    }
}
