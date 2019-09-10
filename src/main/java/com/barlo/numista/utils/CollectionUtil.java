package com.barlo.numista.utils;

import com.barlo.numista.model.Collection;
import com.barlo.numista.service.CollectionService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;

public class CollectionUtil {

    @Autowired
    private CollectionService service;

    private CollectionUtil() {
    }

    public static CollectionUtil getBean() {
        return new CollectionUtil();
    }

    public ObservableList<Collection> getAllTopLevel() {
        return FXCollections.observableArrayList(service.getAllTopLevel());
    }

    public ObservableList<Collection> getSubLevel(int parentId) {
        return FXCollections.observableArrayList(service.getSubLevel(parentId));
    }

}
