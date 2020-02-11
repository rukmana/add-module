package com.mytmmin.etravel.DataModel.Proposal;

import com.google.gson.annotations.SerializedName;
import com.mytmmin.etravel.GlobalVariable;

public class TravelProposalAllowanceInnerExpensesDataModel {

    @SerializedName(GlobalVariable.SERIALIZED_NAME_ALLOWANCE_DETAILS)
    public String allowanceDetails;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_ALLOWANCE_AMMOUNT)
    public String allowanceAmmount;

    public TravelProposalAllowanceInnerExpensesDataModel(String allowanceDetails, String allowanceAmmount) {
        this.allowanceDetails = allowanceDetails;
        this.allowanceAmmount = allowanceAmmount;
    }

}
