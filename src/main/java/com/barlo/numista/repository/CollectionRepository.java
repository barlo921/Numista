package com.barlo.numista.repository;

import com.barlo.numista.model.Collection;

import java.util.List;
import java.util.Optional;

public interface CollectionRepository {

    Collection save(Collection collection);

    boolean delete(long id);

    Collection get(long id);

    Collection getByName(String name);

    List<Collection> getAll();

    List<Collection> getAllTopLevel();

    List<Collection> getSubLevel(long parentId);

}
