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

    public Coin() {
    }

    public Coin(final String coin, final String year, final String country, final String description) {
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
}
