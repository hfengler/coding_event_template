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
            Item item = items[i];

            var isAgedBrie = isExpectedItem(item, AGED_BRIE);
            var isBackstagePass = isExpectedItem(item, BACKSTAGE_PASSES);
            var isSulfuras = isExpectedItem(item, SULFURAS);

            boolean qualityLess50 = item.quality < 50;

            if (!isAgedBrie && !isBackstagePass) {
                if (item.quality > 0 && !isSulfuras) {
                    item.quality--;
                }
            } else if (qualityLess50) {
                item.quality++;
                qualityHandlerBackstagePass(item);
            }

            if (!isSulfuras) {
                item.sellIn--;
            }

            // Sobald das Haltbarkeitsdatum überschritten ist, sinkt die Qualität doppelt so schnell
            if (item.sellIn < 0) {
                if (!isAgedBrie) {
                    if (!isBackstagePass) {
                        if (item.quality > 0 && !isSulfuras) {
                            item.quality--;
                        }
                    } else {
                        item.quality = 0;
                    }
                }
                qualityHandlerAgedBrie(item);
            }
        }
    }

    private void qualityHandlerAgedBrie(Item item){
        var isAgedBrie = isExpectedItem(item, AGED_BRIE);
        boolean qualityLess50 = item.quality < 50;
        if (isAgedBrie && qualityLess50) {
            item.quality++;
        }
    }

    private void qualityHandlerBackstagePass(Item item) {
        var isBackstagePass = isExpectedItem(item, BACKSTAGE_PASSES);

        if (isBackstagePass) {
            boolean qualityLess50 = item.quality < 50;
            if (item.sellIn < 11 && qualityLess50) {
                item.quality++;
            }
            if (item.sellIn < 6 && qualityLess50) {
                item.quality++;
            }
        }

    }

    private boolean isExpectedItem(Item item, String itemName) {
        return item.name.equals(itemName);
    }
}
