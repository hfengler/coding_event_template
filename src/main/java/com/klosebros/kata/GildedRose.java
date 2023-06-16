package com.klosebros.kata;

class GildedRose {

    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String AGED_BRIE = "Aged Brie";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            var isAgedBrie = isExpectedItem(i, AGED_BRIE);
            var isBackstagePass = isExpectedItem(i, BACKSTAGE_PASSES);
            var isSulfuras = isExpectedItem(i, SULFURAS);
            if (!isAgedBrie && !isBackstagePass) {
                if (items[i].quality > 0 && !isSulfuras) {
                    items[i].quality--;
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality++;
                    if (isBackstagePass) {
                        if (items[i].sellIn < 11 && items[i].quality < 50) {
                            items[i].quality++;
                        }
                        if (items[i].sellIn < 6 && items[i].quality < 50) {
                            items[i].quality++;
                        }
                    }
                }
            }

            if (!isSulfuras) {
                items[i].sellIn--;
            }

            // Sobald das Haltbarkeitsdatum überschritten ist, sinkt die Qualität doppelt so schnell
            if (items[i].sellIn < 0) {
                if (!isAgedBrie) {
                    if (!isBackstagePass) {
                        if (items[i].quality > 0 && !isSulfuras){
                            items[i].quality--;
                        }
                    } else {
                        items[i].quality = 0;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality++;
                    }
                }
            }
        }
    }

    private boolean isExpectedItem(int i, String itemName) {
        return items[i].name.equals(itemName);
    }
}
