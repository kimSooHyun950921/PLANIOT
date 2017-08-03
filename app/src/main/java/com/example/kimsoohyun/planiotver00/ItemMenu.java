package com.example.kimsoohyun.planiotver00;

import android.graphics.drawable.Drawable;

/**
 * Created by kimsoohyun on 2017-08-01.
 */
public class ItemMenu {
    Drawable myPlantImage;
    String name;
    String date;

    public ItemMenu(Drawable myPlantImage, String name, String date) {
        this.myPlantImage = myPlantImage;
        this.name = name;
        this.date = date;
    }

    public Drawable getMyPlantImage() {
        return myPlantImage;
    }

    public void setMyPlantImage(Drawable myPlantImage) {
        this.myPlantImage = myPlantImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
