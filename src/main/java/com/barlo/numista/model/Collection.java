package com.barlo.numista.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "collections", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "collections_unique_name_idx")})
public class Collection extends AbstractBaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "parent_id")
    private Integer parentId;

    @OneToMany(cascade = CascadeType.ALL,
                fetch = FetchType.EAGER,
                mappedBy = "collection")
    private Set<Coin> setOfCoins;

    public Collection() {
    }

    public Collection(final String name) {
        this.name = name;
    }

    public Collection(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public Collection(final String name, final Integer parentId) {
        this.name = name;
        this.parentId = parentId;
    }

    public Collection(Integer id, String name, Integer parentId) {
        super(id);
        this.name = name;
        this.parentId = parentId;
        this.setOfCoins = setOfCoins;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(final Integer parentId) {
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
        if (coin.getCollection() != this) {
            coin.setCollection(this);
        }
    }

    @Override
    public String toString() {
        return "Collection{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
