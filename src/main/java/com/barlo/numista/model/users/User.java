package com.barlo.numista.model.users;

import com.barlo.numista.model.AbstractBaseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users",
        uniqueConstraints = {@UniqueConstraint(columnNames = "username", name = "users_unique_username_idx")})
public class User extends AbstractBaseEntity implements UserDetails {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @Column(name = "non_expired", nullable = false)
    private boolean isAccountNonExpired;

    @Column(name = "non_locked", nullable = false)
    private boolean isAccountNonLocked;

    @Column(name = "credentials_non_expired", nullable = false)
    private boolean isCredentialNonExpired;

    @Column(name = "enabled", nullable = false)
    private boolean isEnabled;

    public User() {
    }

    public User(Integer id,
                String username,
                String password,
                Set<Role> roles,
                boolean isAccountNonExpired,
                boolean isAccountNonLocked,
                boolean isCredentialNonExpired,
                boolean isEnabled) {
        super(id);
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialNonExpired = isCredentialNonExpired;
        this.isEnabled = isEnabled;
    }

    public User(String username,
                String password,
                Set<Role> roles,
                boolean isAccountNonExpired,
                boolean isAccountNonLocked,
                boolean isCredentialNonExpired,
                boolean isEnabled) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialNonExpired = isCredentialNonExpired;
        this.isEnabled = isEnabled;
    }

    public User(Integer id,
                String username,
                String password,
                boolean isAccountNonExpired,
                boolean isAccountNonLocked,
                boolean isCredentialNonExpired,
                boolean isEnabled,
                Role role,
                Role... roles) {
        this(id, username, password, EnumSet.of(role, roles), isAccountNonExpired, isAccountNonLocked, isCredentialNonExpired, isEnabled);
    }

    public User(String username,
                String password,
                boolean isAccountNonExpired,
                boolean isAccountNonLocked,
                boolean isCredentialNonExpired,
                boolean isEnabled,
                Role role,
                Role... roles) {
        this(username, password, EnumSet.of(role, roles), isAccountNonExpired, isAccountNonLocked, isCredentialNonExpired, isEnabled);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        roles.forEach(role -> authorities.addAll(role.getGrantedAuthorities()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    public void setCredentialNonExpired(boolean credentialNonExpired) {
        isCredentialNonExpired = credentialNonExpired;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", isAccountNonExpired=" + isAccountNonExpired +
                ", isAccountNonLocked=" + isAccountNonLocked +
                ", isCredentialNonExpired=" + isCredentialNonExpired +
                ", isEnabled=" + isEnabled +
                '}';
    }
}
