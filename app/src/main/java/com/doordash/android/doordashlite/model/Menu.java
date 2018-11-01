package com.doordash.android.doordashlite.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by SreeL1 on 10/30/2018.
 *
 */

public class Menu {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("menu_version")
    @Expose
    private int menuVersion;
    @SerializedName("open_hours")
    @Expose
    private List<List<OpenHour>> openHours = null;
    @SerializedName("is_business_enabled")
    @Expose
    private Object isBusinessEnabled;
    @SerializedName("status_type")
    @Expose
    private String statusType;
//
    @SerializedName("popular_items")
    @Expose
    private List<PopularItem> popularItems = null;
    @SerializedName("is_catering")
    @Expose
    private boolean isCatering;
    @SerializedName("subtitle")
    @Expose
    private String subtitle;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getMenuVersion() {
        return menuVersion;
    }

    public void setMenuVersion(int menuVersion) {
        this.menuVersion = menuVersion;
    }

    public List<List<OpenHour>> getOpenHours() {
        return openHours;
    }

    public void setOpenHours(List<List<OpenHour>> openHours) {
        this.openHours = openHours;
    }

    public Object getIsBusinessEnabled() {
        return isBusinessEnabled;
    }

    public void setIsBusinessEnabled(Object isBusinessEnabled) {
        this.isBusinessEnabled = isBusinessEnabled;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public List<PopularItem> getPopularItems() {
        return popularItems;
    }

    public void setPopularItems(List<PopularItem> popularItems) {
        this.popularItems = popularItems;
    }

    public boolean isIsCatering() {
        return isCatering;
    }

    public void setIsCatering(boolean isCatering) {
        this.isCatering = isCatering;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
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