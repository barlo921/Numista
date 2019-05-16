package com.barlo.numista.service;

import com.barlo.numista.model.CoinCollectionMapping;
import com.barlo.numista.repository.CoinCoillectionMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Service implementation for Coin Collection Mapping Repository
@Service
@Transactional
@Qualifier(value = "coinCollectionMappingService")
public class CoinCollectionMappingServiceImpl implements NumistaService {

    private CoinCoillectionMappingRepository coinCoillectionMappingRepository;

    //Spring injects dependency of crud repository
    @Autowired
    public CoinCollectionMappingServiceImpl(final CoinCoillectionMappingRepository coinCoillectionMappingRepository) {
        this.coinCoillectionMappingRepository = coinCoillectionMappingRepository;
    }

    //Save to repository
    @Override
    public Object save(Object coinCollectionMapping) {
        return coinCoillectionMappingRepository.save((CoinCollectionMapping) coinCollectionMapping);
    }

    //Get all objects from repository
    @Override
    public List<CoinCollectionMapping> findAll() {
        return coinCoillectionMappingRepository.findAll();
    }
}
