package com.klosebros.kata;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    private final static String AGED_BRIE = "Aged Brie";
    private static final String AGED_SOCK = "Aged Sock";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";

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

    @Test
    void agedBrieIsNeverBetterThan50IfExpired() {
        var app = createGildedRose(new Item(AGED_BRIE, -1, 49));
        app.updateQuality();
        Assertions.assertThat(app.items[0].quality).isEqualTo(50);
    }

    @Test
    void sulfurasQualityIsAllwaysSame() {
        var app = createGildedRose(new Item(SULFURAS_HAND_OF_RAGNAROS, 1, 1));
        app.updateQuality();
        Assertions.assertThat(app.items[0].quality).isEqualTo(1);
        Assertions.assertThat(app.items[0].sellIn).isEqualTo(1);
    }

    @Test
    void sulfurasQualityIsAllwaysSame2() {
        var app = createGildedRose(new Item(SULFURAS_HAND_OF_RAGNAROS, -1, 1));
        app.updateQuality();
        Assertions.assertThat(app.items[0].quality).isEqualTo(1);
        Assertions.assertThat(app.items[0].sellIn).isEqualTo(-1);
    }

    @Test
    void backstagePass11() {
        var app = createGildedRose(new Item(BACKSTAGE_PASS, 11, 1));
        app.updateQuality();
        Assertions.assertThat(app.items[0].quality).isEqualTo(2);
        Assertions.assertThat(app.items[0].sellIn).isEqualTo(10);
    }

    @Test
    void backstagePass10() {
        var app = createGildedRose(new Item(BACKSTAGE_PASS, 10, 1));
        app.updateQuality();
        Assertions.assertThat(app.items[0].quality).isEqualTo(3);
        Assertions.assertThat(app.items[0].sellIn).isEqualTo(9);
    }

    @Test
    void backstagePass5() {
        var app = createGildedRose(new Item(BACKSTAGE_PASS, 5, 1));
        app.updateQuality();
        Assertions.assertThat(app.items[0].quality).isEqualTo(4);
    }

    @Test
    void backstagePass1() {
        var app = createGildedRose(new Item(BACKSTAGE_PASS, 1, 1));
        app.updateQuality();
        Assertions.assertThat(app.items[0].quality).isEqualTo(4);
    }

    @Test
    void backstagePass0() {
        var app = createGildedRose(new Item(BACKSTAGE_PASS, 0, 1));
        app.updateQuality();
        Assertions.assertThat(app.items[0].quality).isEqualTo(0);
    }

    private GildedRose createGildedRose(Item... items) {
        return new GildedRose(items);
    }

}
