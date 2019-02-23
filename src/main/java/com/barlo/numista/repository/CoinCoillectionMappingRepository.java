package com.barlo.numista.repository;

import com.barlo.numista.model.CoinCollectionMapping;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.MANDATORY)
public interface CoinCoillectionMappingRepository extends CrudRepository<CoinCollectionMapping, Long> {
    @Override
    List<CoinCollectionMapping> findAll();
}
