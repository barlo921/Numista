package com.barlo.numista;

import com.barlo.numista.model.Collection;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectionTestData {

    public static final int COLLECTION1_ID = 1;

    public static final Collection COLLECTION1 = new Collection(COLLECTION1_ID, "Euro", null);
    public static final Collection COLLECTION2 = new Collection(COLLECTION1_ID + 1, "2 Euro", COLLECTION1_ID);

    public static final List<Collection> COLLECTIONS = Arrays.asList(COLLECTION1, COLLECTION2);

    public static Collection getCreated() {
        return new Collection("Rubles", null);
    }

    public static Collection getUpdated() {
        return new Collection(COLLECTION1_ID + 1, "Dollars", COLLECTION1_ID);
    }

    public static void assertMatch(Collection actual, Collection expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Collection> actual, Iterable<Collection> expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Collection> actual, Collection ... expected) {
        assertThat(actual).isEqualTo(Arrays.asList(expected));
    }


}
