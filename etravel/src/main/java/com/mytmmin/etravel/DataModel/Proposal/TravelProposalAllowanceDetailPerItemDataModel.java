package com.mytmmin.etravel.DataModel.Proposal;

import com.google.gson.annotations.SerializedName;
import com.mytmmin.etravel.GlobalVariable;

import java.io.Serializable;

public class TravelProposalAllowanceDetailPerItemDataModel implements Serializable {

    @SerializedName(GlobalVariable.SERIALIZED_NAME_ALLOWANCE_IDR)
    public String tpAllowanceIdr;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_ALLOWANCE_USD)
    public String tpAllowanceUsd;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_ALLOWANCE_JPY)
    public String tpAllowanceJpy;

    public TravelProposalAllowanceDetailPerItemDataModel(String tpAllowanceIdr, String tpAllowanceUsd, String tpAllowanceJpy) {
        this.tpAllowanceIdr = tpAllowanceIdr;
        this.tpAllowanceUsd = tpAllowanceUsd;
        this.tpAllowanceJpy = tpAllowanceJpy;
    }

    public void setTpAllowanceIdr(String tpAllowanceIdr) {
        this.tpAllowanceIdr = tpAllowanceIdr;
    }

    public void setTpAllowanceUsd(String tpAllowanceUsd) {
        this.tpAllowanceUsd = tpAllowanceUsd;
    }

    public void setTpAllowanceJpy(String tpAllowanceJpy) {
        this.tpAllowanceJpy = tpAllowanceJpy;
    }
}
