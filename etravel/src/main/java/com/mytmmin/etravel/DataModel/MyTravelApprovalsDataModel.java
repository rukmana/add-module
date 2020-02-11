package com.mytmmin.etravel.DataModel;

import com.google.gson.annotations.SerializedName;
import com.mytmmin.etravel.GlobalVariable;

import java.io.Serializable;

public class MyTravelApprovalsDataModel implements Serializable {

    @SerializedName(GlobalVariable.SERIALIZED_NAME_NOREG)
    public String myTravelApprovalNoreg;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_APPROVED_STATUS)
    public String myTravelApprovalApprovedStatus;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_APPROVAL_LEVEL)
    public String myTravelApprovalApprovalLevel;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_EDIT_NAME)
    public String myTravelApprovalApproverName;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_PATH_LOCATION)
    public String myTravelApprovalPhotoUrl;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_DOC_SEQ)
    public String myTravelApprovalDocSeq;

    public MyTravelApprovalsDataModel(String myTravelApprovalNoreg, String myTravelApprovalApprovedStatus, String myTravelApprovalApprovalLevel, String myTravelApprovalApproverName, String myTravelApprovalPhotoUrl, String myTravelApprovalDocSeq) {
        this.myTravelApprovalNoreg = myTravelApprovalNoreg;
        this.myTravelApprovalApprovedStatus = myTravelApprovalApprovedStatus;
        this.myTravelApprovalApprovalLevel = myTravelApprovalApprovalLevel;
        this.myTravelApprovalApproverName = myTravelApprovalApproverName;
        this.myTravelApprovalPhotoUrl = myTravelApprovalPhotoUrl;
        this.myTravelApprovalDocSeq = myTravelApprovalDocSeq;
    }
}
