package com.barlo.numista.service;

import com.barlo.numista.AbstractTest;
import com.barlo.numista.CoinTestData;
import com.barlo.numista.model.Coin;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import static com.barlo.numista.CoinTestData.*;
import static com.barlo.numista.CollectionTestData.*;
import static org.junit.Assert.*;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
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
        assertMatch(service.findById(update.getId()), updated);
    }

    @Test
    public void findAllTest() {
        assertMatch(service.findAll(), COINS);
    }

    @Test
    public void findByIdTest() {
        assertMatch(service.findById(COIN1_ID), COIN1);
    }
}