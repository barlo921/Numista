package com.barlo.numista.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "coin_collection_mapping")
public class CoinCollectionMapping implements Serializable {

    @Column(nullable = false)
    private Long id_coin;

    @Column(nullable = false)
    private Long id_collection;

    public CoinCollectionMapping() {
    }

    public CoinCollectionMapping(final Long id_coin, final Long id_collection) {
        this.id_coin = id_coin;
        this.id_collection = id_collection;
    }

    public Long getId_coin() {
        return id_coin;
    }

    public void setId_coin(final Long id_coin) {
        this.id_coin = id_coin;
    }

    public Long getId_collection() {
        return id_collection;
    }

    public void setId_collection(final Long id_collection) {
        this.id_collection = id_collection;
    }
}
