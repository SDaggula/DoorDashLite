package com.doordash.android.doordashlite.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by SreeL1 on 10/30/2018.
 *
 */

public class DeliveryFeeDetails {
    @SerializedName("final_fee")
    @Expose
    private FinalFee finalFee;
    @SerializedName("discount")
    @Expose
    private Discount discount;
    @SerializedName("surge_fee")
    @Expose
    private SurgeFee surgeFee;
    @SerializedName("original_fee")
    @Expose
    private OriginalFee originalFee;

    public FinalFee getFinalFee() {
        return finalFee;
    }

    public void setFinalFee(FinalFee finalFee) {
        this.finalFee = finalFee;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public SurgeFee getSurgeFee() {
        return surgeFee;
    }

    public void setSurgeFee(SurgeFee surgeFee) {
        this.surgeFee = surgeFee;
    }

    public OriginalFee getOriginalFee() {
        return originalFee;
    }

    public void setOriginalFee(OriginalFee originalFee) {
        this.originalFee = originalFee;
    }
}
