package com.mytmmin.etravel.DataModel.Settlement;

import com.google.gson.annotations.SerializedName;
import com.mytmmin.etravel.GlobalVariable;

import java.io.Serializable;

public class TravelSettlementAllowanceDataModel implements Serializable {

    @SerializedName(GlobalVariable.SERIALIZED_NAME_DIRECT_ALLOWANCE)
    public TravelSettlementDirectAllowanceDataModel tsDirectAllowance;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_SUSPENSE_ALLOWANCE)
    public TravelSettlementSuspenseAllowanceDataModel tsSuspenseAllowance;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_TOTAL_IN_IDR)
    public TravelSettlementTotalDetailDataModel tsTotalInIdr;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_TOTAL_DEDUCTION_IN_IDR)
    public String tsTotalDeductionInIdr;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_BALANCE_IN_IDR)
    public String tsBalanceInIdr;

    public void setTsTotalDeductionInIdr(String tsTotalDeductionInIdr) {
        this.tsTotalDeductionInIdr = tsTotalDeductionInIdr;
    }

    public void setTsBalanceInIdr(String tsBalanceInIdr) {
        this.tsBalanceInIdr = tsBalanceInIdr;
    }
}
