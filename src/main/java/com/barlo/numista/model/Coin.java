package com.barlo.numista.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "coin")
public class Coin implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String coin;

    @Column
    private String year;

    @Column
    private String country;

    @Column
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "collection_id")
    private Collection coinCollection;

    public Coin() {
    }

    public Coin(final Collection coinCollection, final String coin, final String year, final String country, final String description) {
        setCoinCollection(coinCollection);
        this.coin = coin;
        this.year = year;
        this.country = country;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(final String coin) {
        this.coin = coin;
    }

    public String getYear() {
        return year;
    }

    public void setYear(final String year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Collection getCoinCollection() {
        return coinCollection;
    }

    public void setCoinCollection(Collection coinCollection) {
        this.coinCollection = coinCollection;
        if (!coinCollection.getSetOfCoins().contains(this)) {
            coinCollection.getSetOfCoins().add(this);
        }
    }

    @Override
    public String toString() {
        return "Coin{" +
                "id=" + id +
                ", coin='" + coin + '\'' +
                ", year='" + year + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", coinCollection=" + coinCollection +
                '}';
    }
}
