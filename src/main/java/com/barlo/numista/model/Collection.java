package com.barlo.numista.model;

import com.barlo.numista.model.users.User;
import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "collections")
public class Collection extends AbstractBaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(name = "parent_id")
    private Integer parentId;

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "collection")
    private Set<Coin> setOfCoins;

    @ManyToOne(
            fetch = FetchType.EAGER,
            targetEntity = User.class,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id", nullable = false)
    @NotNull
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
