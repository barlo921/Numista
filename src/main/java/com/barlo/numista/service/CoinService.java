package com.barlo.numista.service;

import com.barlo.numista.model.Coin;
import com.barlo.numista.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.barlo.numista.utils.ValidationUtils.checkNotFoundWithId;

//Service implementation for Coin Repository
@Service
public class CoinService {

    private CoinRepository repository;

    //Spring injects dependency of crud repository
    @Autowired
    public CoinService(final CoinRepository repository) {
        this.repository = repository;
    }

    public Coin create(Coin coin, int collectionId) {
        return repository.save(coin, collectionId);
    }

    public Coin update(Coin coin, int collectionId) {
        return repository.save(coin, collectionId);
    }

    //Get all objects from repository
    public List<Coin> findAll() {
        return repository.getAll();
    }

    public Coin findById(Integer id) {
        return checkNotFoundWithId(repository.get(id), id);
    }
}