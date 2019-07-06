package com.barlo.numista.model;

import javax.persistence.*;

@Entity
@Table(name = "coin")
public class Coin extends AbstractBaseEntity {

    @Column(nullable = false)
    private String name;

    @Column
    private String year;

    @Column
    private String country;

    @Column
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "collection_id")
    private Collection collection;

    public Coin() {
    }

    public Coin(String name, String year, String country, String description, Collection collection) {
        this.name = name;
        this.year = year;
        this.country = country;
        this.description = description;
        this.collection = collection;
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

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
        if (!collection.getSetOfCoins().contains(this)) {
            collection.getSetOfCoins().add(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "year='" + year + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", collection=" + collection +
                '}';
    }
}
