package com.example.pondd.dessertmaker.dao;

import com.google.gson.annotations.SerializedName;
import com.inthecheesefactory.thecheeselibrary.dao.BaseDao;

import java.lang.reflect.Array;
import java.util.Date;

/**
 * Created by Pondd on 12/26/14 AD.
 */
public class DessertItemDao extends BaseDao {

    @SerializedName("menu_id")
    private int menuID;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("prep_time")
    private int prepTime;
    @SerializedName("ready_in_time")
    private int readyInTime;
    @SerializedName("timestamp")
    private Date timeStamp;
    @SerializedName("ingredients")
    private String[] ingredients;
    @SerializedName("directions")
    private String[] directions;

    public int getMenuID() {
        return menuID;
    }

    public void setMenuID(int menuID) {
        this.menuID = menuID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public int getReadyInTime() {
        return readyInTime;
    }

    public void setReadyInTime(int readyInTime) {
        this.readyInTime = readyInTime;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public String[] getDirections() {
        return directions;
    }

    public void setDirections(String[] directions) {
        this.directions = directions;
    }


}
