package com.barlo.numista.utils.exception.ui;

import com.barlo.numista.utils.exception.AbstractNumistaException;

public class CollectionIsNotSetException extends AbstractNumistaException {

    public CollectionIsNotSetException() {
        super("You must set Collection for your Subcollection");
    }

    @Override
    public String getException() {
        return "Collection is not set";
    }
}
