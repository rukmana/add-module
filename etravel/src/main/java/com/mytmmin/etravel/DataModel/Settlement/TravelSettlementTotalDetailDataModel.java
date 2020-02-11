package com.mytmmin.etravel.DataModel.Settlement;

import com.google.gson.annotations.SerializedName;
import com.mytmmin.etravel.GlobalVariable;

import java.io.Serializable;

public class TravelSettlementTotalDetailDataModel implements Serializable {

    @SerializedName(GlobalVariable.SERIALIZED_NAME_TOTAL_PROPOSAL)
    public String tsTotalProposal;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_TOTAL_SETTLEMENT)
    public String tsTotalSettlement;

    public TravelSettlementTotalDetailDataModel(String tsTotalProposal, String tsTotalSettlement) {
        this.tsTotalProposal = tsTotalProposal;
        this.tsTotalSettlement = tsTotalSettlement;
    }

    public void setTsTotalProposal(String tsTotalProposal) {
        this.tsTotalProposal = tsTotalProposal;
    }

    public void setTsTotalSettlement(String tsTotalSettlement) {
        this.tsTotalSettlement = tsTotalSettlement;
    }
}
