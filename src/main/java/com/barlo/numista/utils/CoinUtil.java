package com.barlo.numista.utils;

import com.barlo.numista.model.Coin;
import com.barlo.numista.model.Collection;
import com.barlo.numista.service.CollectionService;
import com.barlo.numista.to.CoinTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class CoinUtil {

    @Autowired
    private CollectionService service;

    public List<CoinTO> convertToCoinTO(final List<Coin> coins) {
        return coins.stream()
                .map(this::createCoinTO)
                .collect(Collectors.toList());
    }

    public CoinTO createCoinTO(final Coin coin) {
        Collection tempCollection = null;
        Collection tempSubcollection = null;
        if (coin.getCollection().getParentId() == null) {
            tempCollection = coin.getCollection();
        } else {
            tempSubcollection = coin.getCollection();
            tempCollection = service.get(coin.getCollection().getParentId());
        }

        return new CoinTO(coin, tempCollection, tempSubcollection);
    }

}
