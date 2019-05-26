package com.barlo.numista.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "collection")
public class Collection implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column
    private Long parentId;

    @OneToMany(cascade = CascadeType.ALL,
                fetch = FetchType.EAGER,
                mappedBy = "coinCollection")
    private Set<Coin> setOfCoins = new HashSet<>();

    public Collection() {
    }

    public Collection(final String name) {
        this.name = name;
    }

    public Collection(final String name, final Long parentId) {
        this.name = name;
        this.parentId = parentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(final Long parentId) {
        this.parentId = parentId;
    }

    public Set<Coin> getSetOfCoins() {
        return setOfCoins;
    }

    public void setSetOfCoins(Set<Coin> setOfCoins) {
        this.setOfCoins = setOfCoins;
    }

    public void addCoin(Coin coin) {
        this.setOfCoins.add(coin);
        if (coin.getCoinCollection() != this) {
            coin.setCoinCollection(this);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
