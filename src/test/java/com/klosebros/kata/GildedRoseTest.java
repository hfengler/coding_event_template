package com.klosebros.kata;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

    private final static String AGED_BRIE = "Aged Brie";

    @Test
    void foo() {
        Item[] items = new Item[] {new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Assertions.assertThat(app.items[0].name).isEqualTo("foo");
    }

    @Test
    void agedBrieGetsBetter() {
        var app = createGildedRose(new Item(AGED_BRIE, 10, 0));
        app.updateQuality();
        Assertions.assertThat(app.items[0].quality).isEqualTo(1);
    }
    @Test
    void AgedSockGetsWorse() {
        var app = createGildedRose(new Item("Aged Sock", 10, 1));
        app.updateQuality();
        Assertions.assertThat(app.items[0].quality).isZero();
    }

    @Test
    void experiationProductsGetsMoreWorse() {
        var app = createGildedRose(new Item("Aged Sock", 0, 2));
        app.updateQuality();
        Assertions.assertThat(app.items[0].quality).isZero();
    }


    private GildedRose createGildedRose(Item... items) {
        return new GildedRose(items);
    }

}