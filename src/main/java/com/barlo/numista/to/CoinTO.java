package com.barlo.numista.to;

import com.barlo.numista.model.Coin;
import com.barlo.numista.model.Collection;

public class CoinTO {

    private Integer id;
    private String name;
    private Collection collection;
    private Collection subcollection;
    private int year;
    private String country;
    private String description;

    public CoinTO(final Coin coin, final Collection collection, final Collection subcollection) {
        this.id = coin.getId();
        this.name = coin.getName();
        this.year = coin.getYear();
        this.country = coin.getCountry();
        this.collection = collection;
        this.subcollection = subcollection;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection getCollection() {
        return collection;
    }

    public Collection getSubcollection() {
        return subcollection;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public String getDescription() {
        return description;
    }
}
