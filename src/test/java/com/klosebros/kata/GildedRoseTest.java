package com.klosebros.kata;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    private final static String AGED_BRIE = "Aged Brie";
    private static final String AGED_SOCK = "Aged Sock";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    @Test
    void foo() {
        Item[] items = new Item[] {new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Assertions.assertThat(app.items[0].name).isEqualTo("foo");
    }

    @Test
    void AgedSockGetsWorse() {
        var app = createGildedRose(new Item(AGED_SOCK, 10, 1));
        app.updateQuality();
        Assertions.assertThat(app.items[0].quality).isZero();
    }

    @Test
    void expatriationProductsGetsMoreWorse() {
        var app = createGildedRose(new Item(AGED_SOCK, 0, 2));
        app.updateQuality();
        Assertions.assertThat(app.items[0].quality).isZero();
    }

    @Test
    void qualityIsAlwaysPositiv() {
        var app = createGildedRose(new Item(AGED_SOCK, 0, 0));
        app.updateQuality();
        Assertions.assertThat(app.items[0].quality).isZero();
    }

    @Test
    void agedBrieIsNeverBetterThan50() {
        var app = createGildedRose(new Item(AGED_BRIE, 10, 50));
        app.updateQuality();
        Assertions.assertThat(app.items[0].quality).isEqualTo(50);
    }

//    @Test
//    void sulfurasQualityIsAllwaysSame() {
//        var app = createGildedRose(new Item(SULFURAS_HAND_OF_RAGNAROS, 10, 50));
//        app.updateQuality();
//        Assertions.assertThat(app.items[0].quality).isEqualTo(50);
//    }

    private GildedRose createGildedRose(Item... items) {
        return new GildedRose(items);
    }

}
