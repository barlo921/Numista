package com.barlo.numista.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Coin implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String collection;

    @Column
    private String subcollection;

    @Column(nullable = false)
    private String coin;

    @Column
    private String year;

    @Column
    private String country;

    @Column
    private String description;

    public Coin() {
    }

    public Coin(Long id, String collection, String subcollection, String coin, String year, String country, String description) {
        this.id = id;
        this.collection = collection;
        this.subcollection = subcollection;
        this.coin = coin;
        this.year = year;
        this.country = country;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getSubcollection() {
        return subcollection;
    }

    public void setSubcollection(String subcollection) {
        this.subcollection = subcollection;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
