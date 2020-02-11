package com.mytmmin.etravel.DataModel.Proposal;

import com.google.gson.annotations.SerializedName;
import com.mytmmin.etravel.GlobalVariable;

import java.io.Serializable;

public class TravelProposalDirectAllowanceDataModel implements Serializable {

    @SerializedName(GlobalVariable.SERIALIZED_NAME_PREPARATION_ALLOWANCE)
    public TravelProposalAllowanceDetailPerItemDataModel tpDirectPreparationAllowance;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_WINTER_ALLOWANCE)
    public TravelProposalAllowanceDetailPerItemDataModel tpDirectWinterAllowance;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_DAILY_ALLOWANCE)
    public TravelProposalAllowanceDetailPerItemDataModel tpDirectDailyAllowance;

    public TravelProposalDirectAllowanceDataModel(TravelProposalAllowanceDetailPerItemDataModel tpDirectPreparationAllowance, TravelProposalAllowanceDetailPerItemDataModel tpDirectWinterAllowance, TravelProposalAllowanceDetailPerItemDataModel tpDirectDailyAllowance) {
        this.tpDirectPreparationAllowance = tpDirectPreparationAllowance;
        this.tpDirectWinterAllowance = tpDirectWinterAllowance;
        this.tpDirectDailyAllowance = tpDirectDailyAllowance;
    }
}
