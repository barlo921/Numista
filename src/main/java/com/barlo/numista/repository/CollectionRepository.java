package com.barlo.numista.repository;

import com.barlo.numista.model.Collection;

import java.util.List;

public interface CollectionRepository {

    Collection save(Collection collection, int ownerId);

    boolean delete(int id);

    Collection get(int id);

    Collection getByName(String name);

    List<Collection> getAll();

    List<Collection> getAllTopLevel();

    List<Collection> getSubLevel(int parentId);

}
