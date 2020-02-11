package com.mytmmin.etravel.DataModel.Settlement;

import com.google.gson.annotations.SerializedName;
import com.mytmmin.etravel.GlobalVariable;

import java.io.Serializable;

public class TravelSettlementAllowanceDetailPerItemDataModel implements Serializable {

    @SerializedName(GlobalVariable.SERIALIZED_NAME_ALLOWANCE_IDR_PROPOSAL)
    public String tsAllowanceIdrProposal;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_ALLOWANCE_USD_PROPOSAL)
    public String tsAllowanceUsdProposal;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_ALLOWANCE_JPY_PROPOSAL)
    public String tsAllowanceJpyProposal;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_ALLOWANCE_IDR_SETTLEMENT)
    public String tsAllowanceIdrSettlement;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_ALLOWANCE_USD_SETTLEMENT)
    public String tsAllowanceUsdSettlement;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_ALLOWANCE_JPY_SETTLEMENT)
    public String tsAllowanceJpySettlement;

    public TravelSettlementAllowanceDetailPerItemDataModel(String tsAllowanceIdrProposal, String tsAllowanceUsdProposal, String tsAllowanceJpyProposal, String tsAllowanceIdrSettlement, String tsAllowanceUsdSettlement, String tsAllowanceJpySettlement) {
        this.tsAllowanceIdrProposal = tsAllowanceIdrProposal;
        this.tsAllowanceUsdProposal = tsAllowanceUsdProposal;
        this.tsAllowanceJpyProposal = tsAllowanceJpyProposal;
        this.tsAllowanceIdrSettlement = tsAllowanceIdrSettlement;
        this.tsAllowanceUsdSettlement = tsAllowanceUsdSettlement;
        this.tsAllowanceJpySettlement = tsAllowanceJpySettlement;
    }

    public void setTsAllowanceIdrProposal(String tsAllowanceIdrProposal) {
        this.tsAllowanceIdrProposal = tsAllowanceIdrProposal;
    }

    public void setTsAllowanceUsdProposal(String tsAllowanceUsdProposal) {
        this.tsAllowanceUsdProposal = tsAllowanceUsdProposal;
    }

    public void setTsAllowanceJpyProposal(String tsAllowanceJpyProposal) {
        this.tsAllowanceJpyProposal = tsAllowanceJpyProposal;
    }

    public void setTsAllowanceIdrSettlement(String tsAllowanceIdrSettlement) {
        this.tsAllowanceIdrSettlement = tsAllowanceIdrSettlement;
    }

    public void setTsAllowanceUsdSettlement(String tsAllowanceUsdSettlement) {
        this.tsAllowanceUsdSettlement = tsAllowanceUsdSettlement;
    }

    public void setTsAllowanceJpySettlement(String tsAllowanceJpySettlement) {
        this.tsAllowanceJpySettlement = tsAllowanceJpySettlement;
    }
}
