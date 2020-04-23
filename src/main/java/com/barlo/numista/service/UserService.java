package com.barlo.numista.service;

import com.barlo.numista.model.users.Role;
import com.barlo.numista.model.users.User;
import com.barlo.numista.repository.UserRepository;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static com.barlo.numista.utils.ValidationUtils.checkNotFound;
import static com.barlo.numista.utils.ValidationUtils.checkNotFoundWithId;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    @Autowired
    public UserService(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.getByUsername(email);
    }

    public User create(User user) {
        Assert.notNull(user, "user must not be null");

        User userDb = repository.getByUsername(user.getUsername());

        if (userDb != null) {
            return null;
        }

        user.setRoles(Sets.newHashSet(Role.USER));
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialNonExpired(true);
        user.setEnabled(true);

        return repository.save(user);
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public User get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public User getByUsername(String username) {
        return checkNotFound(repository.getByUsername(username), "username = " + username);
    }

    public List<User> getAll() {
        return repository.getAll();
    }

    public void update(User user) {
        Assert.notNull(user, "user must not be null");
        checkNotFoundWithId(repository.save(user), user.getId());
    }
}
