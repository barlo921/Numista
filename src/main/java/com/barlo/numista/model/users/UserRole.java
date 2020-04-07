package com.barlo.numista.model.users;


import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.barlo.numista.model.users.UserPermission.*;

public enum UserRole {
    ROLE_USER(Sets.newHashSet(SELF_COLLECTION_READ, SELF_COLLECTION_WRITE, SELF_COIN_READ, SELF_COIN_WRITE)),
    ROLE_ADMIN(Sets.newHashSet(ALL_COLLECTION_READ, ALL_COLLECTION_WRITE));

    private Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());

        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
