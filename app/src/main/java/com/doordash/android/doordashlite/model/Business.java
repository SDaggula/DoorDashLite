package com.doordash.android.doordashlite.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by SreeL1 on 10/30/2018.
 *
 */


public class Business {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("business_vertical")
    @Expose
    private Object businessVertical;

    public Object getBusinessVertical() {
        return businessVertical;
    }

    public void setBusinessVertical(Object businessVertical) {
        this.businessVertical = businessVertical;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}