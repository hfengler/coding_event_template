package com.klosebros.kata;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final int MAX_QUALITY = 50;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private static void handleSellIn(Item item) {
        if (isNotSulfuras(item)) {
            decreaseSellIn(item);
        }
    }

    private static void handleAging(Item item) {
        if (isNotAgedBrie(item) && isNotBackstagePass(item)) {
            normalAging(item);
        } else {
            olderGetsBetter(item);
        }
    }

    private static void handleExpiredItems(Item item) {
        if (item.sellIn >= 0) {
            return;
        }

        if (isNotAgedBrie(item)) {
            if (isNotBackstagePass(item)) {
                normalAging(item);
            } else {
                item.quality = 0;
            }
        } else {
            if (item.quality < MAX_QUALITY) {
                increaseQuality(item);
            }
        }
    }

    private static void olderGetsBetter(Item item) {
        if (item.quality >= MAX_QUALITY) {
            return;
        }

        increaseQuality(item);

        if (!isNotBackstagePass(item)) {
            handleBackstagePasses(item);
        }
    }

    private static void handleBackstagePasses(Item item) {
        if (item.sellIn < 11 && (item.quality < MAX_QUALITY)) {
            increaseQuality(item);

        }

        if (item.sellIn < 6 && (item.quality < MAX_QUALITY)) {
            increaseQuality(item);

        }
    }

    private static void normalAging(Item item) {
        if (item.quality > 0 && (isNotSulfuras(item))) {
            decreaseQuality(item);
        }
    }

    private static void decreaseQuality(Item item) {
        item.quality = item.quality - 1;
    }

    private static boolean isNotSulfuras(Item item) {
        return !item.name.equals(SULFURAS);
    }

    private static void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    public void updateQuality() {
        for (Item item : items) {
            handleAging(item);
            handleSellIn(item);
            handleExpiredItems(item);
        }
    }

    private static void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }

    private static boolean isNotBackstagePass(Item item) {
        return !item.name.equals(BACKSTAGE_PASSES);
    }

    private static boolean isNotAgedBrie(Item item) {
        return !item.name.equals(AGED_BRIE);
    }
}
