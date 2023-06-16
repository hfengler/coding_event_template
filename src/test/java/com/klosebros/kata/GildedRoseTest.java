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

}
