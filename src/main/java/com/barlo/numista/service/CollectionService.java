package com.barlo.numista.service;

import com.barlo.numista.model.Collection;
import com.barlo.numista.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.barlo.numista.utils.ValidationUtils.checkNotFoundWithId;
import static com.barlo.numista.utils.ValidationUtils.checkNotFound;

import java.util.List;

@Service
public class CollectionService {

    private CollectionRepository repository;

    @Autowired
    public CollectionService(final CollectionRepository repository) {
        this.repository = repository;
    }

    public Collection create(Collection collection, int ownerId) {
        return repository.save(collection, ownerId);
    }

    public void update(Collection collection, int ownerId) {
        checkNotFoundWithId(repository.save(collection, ownerId), collection.getId());
    }

    public Collection get(Integer id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public Collection getByName(String name) {
        return checkNotFound(repository.getByName(name), "name=" + name);
    }

    public List<Collection> getAll() {
        return repository.getAll();
    }

    public List<Collection> getAllTopLevel() {
        return repository.getAllTopLevel();
    }

    public List<Collection> getSubLevel(int parentId) {
        return repository.getSubLevel(parentId);
    }

}
