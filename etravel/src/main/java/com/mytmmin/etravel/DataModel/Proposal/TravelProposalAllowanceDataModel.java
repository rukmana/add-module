package com.mytmmin.etravel.DataModel.Proposal;

import com.google.gson.annotations.SerializedName;
import com.mytmmin.etravel.GlobalVariable;

import java.io.Serializable;

public class TravelProposalAllowanceDataModel implements Serializable {

    @SerializedName(GlobalVariable.SERIALIZED_NAME_DIRECT_ALLOWANCE)
    public TravelProposalDirectAllowanceDataModel tpDirectAllowance;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_SUSPENSE_ALLOWANCE)
    public TravelProposalSuspenseAllowanceDataModel tpSuspenseAllowance;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_TOTAL_TRANSFER_IN_IDR)
    public String tpTotalTransferInIdr;

    public TravelProposalAllowanceDataModel(TravelProposalDirectAllowanceDataModel tpDirectAllowance, TravelProposalSuspenseAllowanceDataModel tpSuspenseAllowance, String tpTotalTransferInIdr) {
        this.tpDirectAllowance = tpDirectAllowance;
        this.tpSuspenseAllowance = tpSuspenseAllowance;
        this.tpTotalTransferInIdr = tpTotalTransferInIdr;
    }

    public void setTpTotalTransferInIdr(String tpTotalTransferInIdr) {
        this.tpTotalTransferInIdr = tpTotalTransferInIdr;
    }
}
