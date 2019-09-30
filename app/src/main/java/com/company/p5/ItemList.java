package com.company.p5;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

class ItemList {
    static List<Item> itemList = new ArrayList<>();

    static {
        for (int i = 0; i < 200; i++) {
            Item item = new Item();
            item.name = "Item " + i;
            item.desc = "Description " + i;
            item.rating = (float) Math.random()*10;
            itemList.add(item);
        }
    }
}
