package com.barlo.numista.to;

import com.barlo.numista.model.Coin;
import com.barlo.numista.model.Collection;

public class CoinTO {

    private Integer id;
    private String name;
    private Collection collection;
    private Collection subcollection;
    private Integer year;
    private String country;
    private String description;

    public CoinTO() {
    }

    public CoinTO(final Coin coin, final Collection collection, final Collection subcollection) {
        this.id = coin.getId();
        this.name = coin.getName();
        this.year = coin.getYear();
        this.country = coin.getCountry();
        this.collection = collection;
        this.subcollection = subcollection;
        this.description = coin.getDescription();
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

    public Integer getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public String getDescription() {
        return description;
    }

    public boolean isNew() {
        return id == null;
    }

    @Override
    public String toString() {
        return "CoinTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", collection=" + collection +
                ", subcollection=" + subcollection +
                ", year=" + year +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
