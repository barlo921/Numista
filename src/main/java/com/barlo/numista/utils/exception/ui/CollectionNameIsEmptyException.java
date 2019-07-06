package com.barlo.numista.utils.exception.ui;

import com.barlo.numista.utils.exception.AbstractNumistaException;

public class CollectionNameIsEmptyException extends AbstractNumistaException {

    public CollectionNameIsEmptyException() {
        super("Please choose Collection name");
    }

    @Override
    public String getException() {
        return "Collection name is not set";
    }
}
