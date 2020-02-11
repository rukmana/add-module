package com.mytmmin.etravel.POJO;

import com.google.gson.annotations.SerializedName;
import com.mytmmin.etravel.GlobalVariable;


public class ApproveRejectToyotaDevPojo {

    @SerializedName(GlobalVariable.SERIALIZED_NAME_SUCCESS)
    public boolean success;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_MESSAGE)
    public String message;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_STATUS_PROCESS_ID)
    public int statusProcessId;

}
