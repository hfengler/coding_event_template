package com.klosebros.kata;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void testItemName() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Assertions.assertThat(app.items[0].name).isEqualTo("foo");
    }

    @Test
    void testQualityIsNeverNegative() {
        // Die Qualität eines Artikels ist nie negativ
        Item[] items = new Item[]{new Item("foo", 1, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Assertions.assertThat(app.items[0].sellIn).isEqualTo(0);
        Assertions.assertThat(app.items[0].quality).isZero();
        app.updateQuality();
        Assertions.assertThat(app.items[0].quality).isZero();
        app.updateQuality();
        Assertions.assertThat(app.items[0].quality).isZero();
    }

    @Test
    void testQualityIsReducedTwice() {
        // Sobald das Haltbarkeitsdatum überschritten ist, sinkt die Qualität doppelt so schnell
        Item[] items = new Item[]{new Item("foo", 1, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Assertions.assertThat(app.items[0].sellIn).isEqualTo(0);
        Assertions.assertThat(app.items[0].quality).isEqualTo(9);
        app.updateQuality();
        Assertions.assertThat(app.items[0].sellIn).isEqualTo(-1);
        Assertions.assertThat(app.items[0].quality).isEqualTo(7);
    }

}
