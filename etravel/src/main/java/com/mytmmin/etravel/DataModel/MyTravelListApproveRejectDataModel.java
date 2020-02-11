package com.mytmmin.etravel.DataModel;

import com.google.gson.annotations.SerializedName;
import com.mytmmin.etravel.GlobalVariable;

import java.io.Serializable;

public class MyTravelListApproveRejectDataModel implements Serializable {

    //TODO: change serialized name
    @SerializedName(GlobalVariable.SERIALIZED_NAME_POSITION)
    public String approveRejectPosition;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_DRAFT_NO)
    public String approveRejectDraftNumber;

    public MyTravelListApproveRejectDataModel(String approveRejectPosition, String approveRejectDraftNumber) {
        this.approveRejectPosition = approveRejectPosition;
        this.approveRejectDraftNumber = approveRejectDraftNumber;
    }
}
