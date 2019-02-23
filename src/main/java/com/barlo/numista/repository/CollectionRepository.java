package com.barlo.numista.repository;

import com.barlo.numista.model.Collection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.MANDATORY)
public interface CollectionRepository extends CrudRepository<Collection, Long> {
    @Override
    List<Collection> findAll();
}
