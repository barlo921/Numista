package com.barlo.numista.to;

import com.barlo.numista.model.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CollectionTO {

    private Integer id;
    private String name;
    private Integer parentId;

    @JsonCreator
    public CollectionTO(@JsonProperty("id") Integer id,
                        @JsonProperty("name") String name,
                        @JsonProperty("parentId") Integer parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public CollectionTO(Collection collection) {
        id = collection.getId();
        name = collection.getName();
        parentId = collection.getParentId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
