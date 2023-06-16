package com.klosebros.kata;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private static void olderGetsBetter(Item item) {
        if (item.quality >= 50) {
            return;
        }

        item.quality = item.quality + 1;

        if (item.name.equals(BACKSTAGE_PASSES)) {
            handleBackstagePasses(item);
        }
    }

    private static void handleBackstagePasses(Item item) {
        if (item.sellIn < 11 && (item.quality < 50)) {
            item.quality = item.quality + 1;

        }

        if (item.sellIn < 6 && (item.quality < 50)) {
            item.quality = item.quality + 1;

        }
    }

    private static void normalAging(Item item) {
        if (item.quality > 0 && (!item.name.equals(SULFURAS))) {
            item.quality = item.quality - 1;
        }
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals(AGED_BRIE) && !item.name.equals(BACKSTAGE_PASSES)) {
                normalAging(item);
            } else {
                olderGetsBetter(item);
            }

            if (!item.name.equals(SULFURAS)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(AGED_BRIE)) {
                    if (!item.name.equals(BACKSTAGE_PASSES)) {
                        normalAging(item);
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
