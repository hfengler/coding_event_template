package com.klosebros.kata;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if ("Sulfuras, Hand of Ragnaros".equals(item.name)) {
                continue;
            }

            item.sellIn = item.sellIn - 1;



            if ("Aged Brie".equals(item.name)
                || "Backstage passes to a TAFKAL80ETC concert".equals(item.name)) {


                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(item.name)) {
                        if (item.sellIn < 11 && item.quality < 50) {
                            item.quality = item.quality + 1;
                        }

                        if (item.sellIn < 6 && item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            } else {
                if (item.quality > 0) {
                    item.quality = item.quality - 1;
                }
            }


            if (item.sellIn < 0) {
                if (!"Aged Brie".equals(item.name)) {
                    if (!"Backstage passes to a TAFKAL80ETC concert".equals(item.name)) {
                        if (item.quality > 0) {
                            item.quality = item.quality - 1;
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}
