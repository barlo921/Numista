package com.barlo.numista.service;

import com.barlo.numista.AbstractTest;
import com.barlo.numista.UserTestData;
import com.barlo.numista.model.users.User;
import com.barlo.numista.utils.exception.logic.NotFoundException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.barlo.numista.UserTestData.*;

public class UserServiceTest extends AbstractTest {

    @Autowired
    public UserService service;

    @Test
    public void createTest() {

        User newUser = getCreated();
        User created = service.create(newUser);
        newUser.setId(created.getId());
        assertMatch(newUser, created);

    }

    @Test
    public void getTest() {
        UserTestData.assertMatch(service.get(USER1_ID), USER_1);
    }

    @Test(expected = NotFoundException.class)
    public void getNotFoundTest() {
        service.get(USER1_ID + 10000);
    }

    @Test
    public void getByNameTest() {
        UserTestData.assertMatch(service.getByUsername("123@123.ru"), USER_1);
        UserTestData.assertMatch(service.getByUsername("1234@123.ru"), USER_2);
    }

    @Test(expected = NotFoundException.class)
    public void getByNameNotFoundTest() {
        service.getByUsername("notFound@non.ru");
    }

    @Test
    public void getAllTest() {
        UserTestData.assertMatch(service.getAll(), USERS);
    }

}
