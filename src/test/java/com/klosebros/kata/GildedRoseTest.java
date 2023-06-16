package com.klosebros.kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

    @Test
    void foo() {
        var items = new Item[] {new Item("foo", 1, 2)};
        var app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isEqualTo("foo");
        assertThat(app.items[0].sellIn).isZero();
        assertThat(app.items[0].quality).isEqualTo(1);
    }
    @Test
    void fooSmells() {
        var items = new Item[] {new Item("foo", 0, 5)};
        var app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isEqualTo("foo");
        assertThat(app.items[0].sellIn).isEqualTo(-1);
        assertThat(app.items[0].quality).isEqualTo(3);
    }
    @Test
    void bree() {
        var items = new Item[] {new Item("Aged Brie", 1, 2)};
        var app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isEqualTo("Aged Brie");
        assertThat(app.items[0].sellIn).isZero();
        assertThat(app.items[0].quality).isEqualTo(3);
    }
    @Test
    void greater50() {
        var items = new Item[] {new Item("Aged Brie", 1, 50)};
        var app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isEqualTo("Aged Brie");
        assertThat(app.items[0].sellIn).isZero();
        assertThat(app.items[0].quality).isEqualTo(50);
    }
    @Test
    void neverNegative() {
        var items = new Item[] {new Item("foo", 1, 0)};
        var app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isEqualTo("foo");
        assertThat(app.items[0].sellIn).isZero();
        assertThat(app.items[0].quality).isEqualTo(0);
    }
    @Test
    void sulfuras() {
        var items = new Item[] {new Item("Sulfuras, Hand of Ragnaros", 1, 50)};
        var app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isEqualTo("Sulfuras, Hand of Ragnaros");
        assertThat(app.items[0].sellIn).isEqualTo(1);
        assertThat(app.items[0].quality).isEqualTo(50);
    }

    @Test
    void backstageSmaller11() {
        var items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 10, 2)};
        var app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isEqualTo("Backstage passes to a TAFKAL80ETC concert");
        assertThat(app.items[0].sellIn).isEqualTo(9);
        assertThat(app.items[0].quality).isEqualTo(4);
    }
    @Test
    void backstageSmaller6() {
        var items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 5, 2)};
        var app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isEqualTo("Backstage passes to a TAFKAL80ETC concert");
        assertThat(app.items[0].sellIn).isEqualTo(4);
        assertThat(app.items[0].quality).isEqualTo(5);
    }
    @Test
    void backstageBigger10() {
        var items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 12, 2)};
        var app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isEqualTo("Backstage passes to a TAFKAL80ETC concert");
        assertThat(app.items[0].sellIn).isEqualTo(11);
        assertThat(app.items[0].quality).isEqualTo(3);
    }
    @Test
    void backstageAfterConcert() {
        var items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 0, 2)};
        var app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isEqualTo("Backstage passes to a TAFKAL80ETC concert");
        assertThat(app.items[0].sellIn).isEqualTo(-1);
        assertThat(app.items[0].quality).isZero();
    }

}
