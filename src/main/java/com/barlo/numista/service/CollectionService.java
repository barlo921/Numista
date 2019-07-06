package com.barlo.numista.service;

import com.barlo.numista.model.Collection;
import com.barlo.numista.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Service implementation for Collection Repository
@Service
@Transactional
@Qualifier(value = "collectionService")
public class CollectionService {

    private CollectionRepository collectionRepository;

    //Spring injects dependency of crud repository
    @Autowired
    public CollectionService(final CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    //Save to repository
    public Collection save(final Collection collection) {
        return collectionRepository.save(collection);
    }

    //Get all objects from repository
    public List<Collection> findAll() {
        return collectionRepository.getAll();
    }

    public Collection findById(Long id) {
        return collectionRepository.get(id);
    }
}
