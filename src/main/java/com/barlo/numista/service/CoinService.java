package com.barlo.numista.service;

import com.barlo.numista.model.Coin;
import com.barlo.numista.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Service implementation for Coin Repository
@Service
public class CoinService {

    private CoinRepository coinRepository;

    //Spring injects dependency of crud repository
    @Autowired
    public CoinService(final CoinRepository coinRepository) {
        this.coinRepository = coinRepository;
    }

    //Save to repository
    public Coin save(final Coin coin, int collectionId) {
       return coinRepository.save(coin, collectionId);
    }

    public Coin create(Coin coin, int collectionId) {
        return coinRepository.save(coin, collectionId);
    }

    public Coin update(Coin coin, int collectionId) {
        return coinRepository.save(coin, collectionId);
    }

    //Get all objects from repository
    public List<Coin> findAll() {
        return coinRepository.getAll();
    }

    public Coin findById(Integer id) {
        return coinRepository.get(id);
    }
}