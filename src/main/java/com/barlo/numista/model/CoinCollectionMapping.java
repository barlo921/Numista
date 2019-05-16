package com.barlo.numista.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "coinCollectionMapping")
public class CoinCollectionMapping implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
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
