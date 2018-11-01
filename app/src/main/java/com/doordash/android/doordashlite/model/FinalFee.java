package com.doordash.android.doordashlite.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by SreeL1 on 10/30/2018.
 *
 */

public class FinalFee {
    @SerializedName("display_string")
    @Expose
    private String displayString;
    @SerializedName("unit_amount")
    @Expose
    private int unitAmount;

    public String getDisplayString() {
        return displayString;
    }

    public void setDisplayString(String displayString) {
        this.displayString = displayString;
    }

    public int getUnitAmount() {
        return unitAmount;
    }

    public void setUnitAmount(int unitAmount) {
        this.unitAmount = unitAmount;
    }
}
