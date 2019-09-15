package com.barlo.numista.service;

import com.barlo.numista.AbstractTest;
import com.barlo.numista.CoinTestData;
import com.barlo.numista.model.Coin;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.barlo.numista.CoinTestData.*;
import static com.barlo.numista.CollectionTestData.*;

public class CoinServiceTest extends AbstractTest {

    @Autowired
    CoinService service;

    @Test
    public void createTest() {
        Coin created = CoinTestData.getCreated();
        Coin newCoin = service.create(created, COLLECTION2.getId());
        created.setId(newCoin.getId());
        assertMatch(newCoin, created);
    }

    @Test
    public void updateTest() {
        Coin update = service.create(CoinTestData.getCreated(), COLLECTION2.getId());
        Coin updated = CoinTestData.getUpdated();
        updated.setId(update.getId());
        service.update(updated, COLLECTION2.getId());
        assertMatch(service.getById(update.getId()), updated);
    }

    @Test
    public void findAllTest() {
        assertMatch(service.getAll(), COINS);
    }

    @Test
    public void findByIdTest() {
        assertMatch(service.getById(COIN1_ID), COIN1);
    }
}