package com.mytmmin.etravel.POJO;

import com.google.gson.annotations.SerializedName;
import com.mytmmin.etravel.DataModel.MyTravelMainDataDataModel;
import com.mytmmin.etravel.GlobalVariable;

import java.util.ArrayList;

public class MyTravelMainDevPojo {

    @SerializedName(GlobalVariable.SERIALIZED_NAME_SUCCESS)
    public boolean success;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_MESSAGE)
    public String message;
//    @SerializedName(GlobalVariable.SERIALIZED_NAME_PAGE)
//    public int page;
//    @SerializedName(GlobalVariable.SERIALIZED_NAME_LIMIT)
//    public int limit;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_TOTAL_DATA)
    public int totalData;
//    @SerializedName(GlobalVariable.SERIALIZED_NAME_TOTAL_PAGES)
//    public int total_pages;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_DATA)
    public ArrayList<MyTravelMainDataDataModel> data = new ArrayList<>();

}
