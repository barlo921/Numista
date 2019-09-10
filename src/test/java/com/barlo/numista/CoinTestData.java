package com.barlo.numista;

import com.barlo.numista.model.Coin;

import java.util.Arrays;
import java.util.List;

import static com.barlo.numista.CollectionTestData.COLLECTION1;
import static com.barlo.numista.CollectionTestData.COLLECTION2;
import static org.assertj.core.api.Assertions.assertThat;

public class CoinTestData {

    public static final int COIN1_ID = 3;

    public static final Coin COIN1 = new Coin(COIN1_ID, "Flag", "2018", "Malta", "", COLLECTION2);
    public static final Coin COIN2 = new Coin(COIN1_ID + 1, "Roman", "2009", "Italy", "", COLLECTION2);

    public static final List<Coin> COINS = Arrays.asList(COIN1, COIN2);

    public static Coin getCreated() {
        return new Coin("Cancer", "2018", "Belgium", "");
    }

    public static Coin getUpdated() {
        return new Coin("Flagsss", "2017", "Italy", "", COLLECTION2);
    }

    public static void assertMatch(Coin actual, Coin expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Coin> actual, Iterable<Coin> expected) {
        assertThat(actual).isEqualTo(expected);
    }

}
