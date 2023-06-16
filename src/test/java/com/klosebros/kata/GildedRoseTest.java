package com.klosebros.kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

    @Test
    void testItemName() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isEqualTo("foo");
    }

    @Test
    void testQualityIsNeverNegative() {
        // Die Qualität eines Artikels ist nie negativ
        Item[] items = new Item[]{new Item("foo", 1, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(0);
        assertThat(app.items[0].quality).isZero();
        app.updateQuality();
        assertThat(app.items[0].quality).isZero();
        app.updateQuality();
        assertThat(app.items[0].quality).isZero();
    }

    @Test
    void testQualityIsReducedTwice() {
        // Sobald das Haltbarkeitsdatum überschritten ist, sinkt die Qualität doppelt so schnell
        Item[] items = new Item[]{new Item("foo", 1, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(0);
        assertThat(app.items[0].quality).isEqualTo(9);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(-1);
        assertThat(app.items[0].quality).isEqualTo(7);
    }

    @Test
    void qualityOfAgedBrie() {
        Item[] items = new Item[]{new Item("Aged Brie", 1, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(11);
    }

    @Test
    void qualityIsNeverGreaterAs50() {
        Item[] items = new Item[]{new Item("Aged Brie", 1, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(50);
    }

    @Test
    void sulfurasNeverLoseQuality() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 1, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(10);
    }

    @Test
    void backstageTicketGetHigherValueIfSellInGetsSmaller10() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(7);
    }

    @Test
    void backstageTicketGetHigherValueIfSellInGetsSmaller5() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(8);
    }

    @Test
    void backstageTicketGet0ValueIfSellInIs0() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 1, 25)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(28);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(0);
    }

    @Test
    void testAgedBrieGetQualityNeverGreater50() {
        Item[] items = new Item[]{new Item("Aged Brie", -1, 48)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(50);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(50);
    }

}
