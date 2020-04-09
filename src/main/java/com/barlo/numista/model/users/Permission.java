package com.barlo.numista.model.users;


public enum Permission {
    SELF_COLLECTION_READ("self_collection:read"),
    SELF_COIN_READ("self_coin:read"),
    SELF_COLLECTION_WRITE("self_collection:write"),
    SELF_COIN_WRITE("self_coin:write"),
    ALL_COLLECTION_READ("all_collection:read"),
    ALL_COLLECTION_WRITE("all_collection:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
