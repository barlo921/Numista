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
public class CollectionServiceImpl implements NumistaService {

    private CollectionRepository collectionRepository;

    //Spring injects dependency of crud repository
    @Autowired
    public CollectionServiceImpl(final CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    //Save to repository
    @Override
    public Object save(final Object collection) {
        return collectionRepository.save((Collection) collection);
    }

    //Get all objects from repository
    @Override
    public List<Collection> findAll() {
        return collectionRepository.findAll();
    }

    @Override
    public Collection findById(Long id) {
        return collectionRepository.findById(id).get();
    }
}
