package com.mytmmin.etravel.POJO;

import com.google.gson.annotations.SerializedName;
import com.mytmmin.etravel.DataModel.MyTravelListApproveRejectDataModel;
import com.mytmmin.etravel.GlobalVariable;

import java.util.ArrayList;


public class AllDraftNumberToyotaDevPojo {

    @SerializedName(GlobalVariable.SERIALIZED_NAME_SUCCESS)
    public boolean success;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_MESSAGE)
    public String message;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_TOTAL_DATA)
    public String totalData;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_DATA)
    public ArrayList<MyTravelListApproveRejectDataModel> draftNumbers = new ArrayList<>();

}
