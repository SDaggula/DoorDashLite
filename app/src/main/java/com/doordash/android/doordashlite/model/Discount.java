package com.doordash.android.doordashlite.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by SreeL1 on 10/30/2018.
 *
 */

public class Discount {
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("source_type")
    @Expose
    private String sourceType;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("discount_type")
    @Expose
    private String discountType;
    @SerializedName("amount")
    @Expose
    private Amount amount;
    @SerializedName("min_subtotal")
    @Expose
    private MinSubtotal minSubtotal;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public MinSubtotal getMinSubtotal() {
        return minSubtotal;
    }

    public void setMinSubtotal(MinSubtotal minSubtotal) {
        this.minSubtotal = minSubtotal;
    }

}
