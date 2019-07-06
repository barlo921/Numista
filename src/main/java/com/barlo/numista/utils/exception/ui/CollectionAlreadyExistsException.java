package com.barlo.numista.utils.exception.ui;

import com.barlo.numista.utils.exception.AbstractNumistaException;

public class CollectionAlreadyExistsException extends AbstractNumistaException {

    public CollectionAlreadyExistsException(final String collectionName) {
        super("Collection with \"" + collectionName + "\" already exists");
    }

    @Override
    public String getException() {
        return "Such collection already exists";
    }
}
