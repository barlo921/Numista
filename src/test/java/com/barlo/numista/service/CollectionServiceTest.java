package com.barlo.numista.service;

import com.barlo.numista.AbstractTest;
import com.barlo.numista.model.Collection;
import com.barlo.numista.utils.exception.logic.NotFoundException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.barlo.numista.CollectionTestData.*;

public class CollectionServiceTest extends AbstractTest {

    @Autowired
    private CollectionService service;

    @Test
    public void createTest() {
        Collection newCollection = getCreated();
        Collection created = service.create(newCollection, 1);
        newCollection.setId(created.getId());
        assertMatch(newCollection, created);
    }

    @Test
    public void updateTest() {
        Collection updated = getUpdated();
        service.update(updated, 1);
        assertMatch(service.get(COLLECTION1_ID + 1), updated);
    }

    @Test
    public void getTest() {
        assertMatch(service.get(COLLECTION1_ID), COLLECTION1);
    }

    @Test(expected = NotFoundException.class)
    public void getNotFoundTest() {
        service.get(COLLECTION1_ID + 6);
    }

    @Test
    public void getByNameTest() {
        assertMatch(service.getByName("Euro"), COLLECTION1);
        assertMatch(service.getByName("2 Euro"), COLLECTION2);
    }

    @Test(expected = NotFoundException.class)
    public void getByNameNotFoundTest() {
        service.getByName("Rubles");
    }

    @Test
    public void getAllTest() {
        assertMatch(service.getAll(), COLLECTIONS);
    }

    @Test
    public void getAllTopLevelTest() {
        assertMatch(service.getAllTopLevel(), COLLECTION1);
    }

    @Test
    public void getSubLevelTest() {
        assertMatch(service.getSubLevel(1), COLLECTION2);
    }
}