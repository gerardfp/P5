package com.company.p5;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MainViewModel extends AndroidViewModel {


    List<Item> itemList = new ArrayList<>();
    public int selectedItem = 0;

    public MainViewModel(@NonNull Application application) {
        super(application);

        for (int i = 0; i < 200; i++) {
            Item item = new Item();
            item.name = "Item " + i;
            item.desc = "Description " + i;
            item.rating = (float) Math.random()*10;
            itemList.add(item);
        }
    }
}
