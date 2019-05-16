package com.barlo.numista.repository;


import com.barlo.numista.model.Coin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.MANDATORY)
public interface CoinRepository extends CrudRepository<Coin, Long> {
    List<Coin> findAll();
}
