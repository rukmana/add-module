package com.mytmmin.etravel.DataModel.Settlement;

import com.google.gson.annotations.SerializedName;
import com.mytmmin.etravel.GlobalVariable;

import java.io.Serializable;

public class TravelSettlementDirectAllowanceDataModel implements Serializable {

    @SerializedName(GlobalVariable.SERIALIZED_NAME_PREPARATION_ALLOWANCE)
    public TravelSettlementAllowanceDetailPerItemDataModel tsDirectPreparationAllowance;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_WINTER_ALLOWANCE)
    public TravelSettlementAllowanceDetailPerItemDataModel tsDirectWinterAllowance;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_DAILY_ALLOWANCE)
    public TravelSettlementAllowanceDetailPerItemDataModel tsDirectDailyAllowance;

    public TravelSettlementDirectAllowanceDataModel(TravelSettlementAllowanceDetailPerItemDataModel tsDirectPreparationAllowance, TravelSettlementAllowanceDetailPerItemDataModel tsDirectWinterAllowance, TravelSettlementAllowanceDetailPerItemDataModel tsDirectDailyAllowance) {
        this.tsDirectPreparationAllowance = tsDirectPreparationAllowance;
        this.tsDirectWinterAllowance = tsDirectWinterAllowance;
        this.tsDirectDailyAllowance = tsDirectDailyAllowance;
    }
}
