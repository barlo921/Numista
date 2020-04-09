package com.barlo.numista;

import com.barlo.numista.model.users.Role;
import com.barlo.numista.model.users.User;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.barlo.numista.model.users.Role.ROLE_ADMIN;
import static com.barlo.numista.model.users.Role.ROLE_USER;
import static org.assertj.core.api.Assertions.assertThat;

public class UserTestData {

    public final static int USER1_ID = 5;

    public final static User USER_1 = new User(
            USER1_ID,
            "123@123.ru",
            "password",
            true,
            true,
            true,
            true,
            Role.ROLE_USER);

    public final static User USER_2 = new User(
            USER1_ID + 1,
            "1234@123.ru",
            "password123",
            true,
            true,
            true,
            true,
            Role.ROLE_ADMIN
    );

    public final static List<User> USERS = Arrays.asList(USER_2, USER_1);

    public static User getCreated() {
        return new User("234@123.ru", "pass", true, true, true, true, Role.ROLE_USER);
    }

    public static User getUpdated() {
        return new User(USER1_ID + 1, "1234@123.ru", "pass123", true, true, true, true, Role.ROLE_ADMIN);
    }

    public static void assertMatch(User actual, User expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<User> actual, Iterable<User> expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<User> actual, User ... expected) {
        assertThat(actual).isEqualTo(Arrays.asList(expected));
    }

}
