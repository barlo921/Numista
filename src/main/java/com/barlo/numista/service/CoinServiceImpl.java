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
@Transactional
@Qualifier(value = "coinService")
public class CoinServiceImpl implements NumistaService {

    private CoinRepository coinRepository;

    //Spring injects dependency of crud repository
    @Autowired
    public CoinServiceImpl(final CoinRepository coinRepository) {
        this.coinRepository = coinRepository;
    }

    //Save to repository
    @Override
    public Object save(final Object coin) {
       return coinRepository.save((Coin) coin);
    }

    //Get all objects from repository
    @Override
    public List<Coin> findAll() {
        return coinRepository.findAll();
    }

    @Override
    public Coin findById(Long id) {
        return coinRepository.findById(id).get();
    }
}
