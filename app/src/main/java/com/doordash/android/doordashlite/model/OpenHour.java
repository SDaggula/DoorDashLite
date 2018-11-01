package com.doordash.android.doordashlite.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by SreeL1 on 10/30/2018.
 *
 */

public class OpenHour {
    @SerializedName("hour")
    @Expose
    private int hour;
    @SerializedName("minute")
    @Expose
    private int minute;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

}
