package com.barlo.numista.service;

import com.barlo.numista.model.Coin;
import com.barlo.numista.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Service class for DB

@Service
@Transactional
public class CoinServiceImpl implements CoinService {

    private CoinRepository coinRepository;

    //Spring injects dependency of crud repository
    @Autowired
    public CoinServiceImpl(CoinRepository coinRepository) {
        this.coinRepository = coinRepository;
    }

    //Save to repository (DB)
    @Override
    public Coin save(Coin coin) {
        return coinRepository.save(coin);
    }

    //Get all objects from repository (DB)
    @Override
    public List<Coin> findAll() {
        return coinRepository.findAll();
    }
}
