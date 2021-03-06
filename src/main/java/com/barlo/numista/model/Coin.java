package com.barlo.numista.model;

import com.barlo.numista.model.users.User;
import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "coins")
public class Coin extends AbstractBaseEntity {

    @Column(nullable = false)
    private String name;

    @Column
    private Integer year;

    @Column
    private String country;

    @Column
    private String description;

    @ManyToOne(fetch = FetchType.EAGER,
            targetEntity = Collection.class,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "collection_id", nullable = false)
    @NotNull
    private Collection collection;

    @ManyToOne(
            fetch = FetchType.EAGER,
            targetEntity = User.class,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id", nullable = false)
    @NotNull
    private User user;

    public Coin() {
    }

    public Coin(String name, int year, String country, String description, Collection collection) {
        this.name = name;
        this.year = year;
        this.country = country;
        this.description = description;
        this.collection = collection;
    }

    public Coin(String name, int year, String country, String description) {
        this.name = name;
        this.year = year;
        this.country = country;
        this.description = description;
    }

    public Coin(Integer id, String name, int year, String country, String description, Collection collection) {
        super(id);
        this.name = name;
        this.year = year;
        this.country = country;
        this.description = description;
        this.collection = collection;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(final Integer year) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", collection=" + collection +
                ", id=" + id +
                '}';
    }
}
