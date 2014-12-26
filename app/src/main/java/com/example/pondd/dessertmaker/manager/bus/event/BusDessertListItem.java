package com.example.pondd.dessertmaker.manager.bus.event;

/**
 * Created by Pondd on 12/26/14 AD.
 */
public class BusDessertListItem {
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    private int position;


    public BusDessertListItem(int position) {
        this.position = position;
    }
}
