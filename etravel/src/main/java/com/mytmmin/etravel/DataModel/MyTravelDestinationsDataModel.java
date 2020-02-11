package com.mytmmin.etravel.DataModel;

import com.google.gson.annotations.SerializedName;
import com.mytmmin.etravel.GlobalVariable;

import java.io.Serializable;

public class MyTravelDestinationsDataModel implements Serializable {

    @SerializedName(GlobalVariable.SERIALIZED_NAME_TP_DESTINATION_SEQ)
    public String myTravelDestinationSeq;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_CITY_COUNTRY)
    public String myTravelDestinationCountryName;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_CITY)
    public String myTravelDestinationCityName;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_OBJECTIVES)
    public String myTravelDestinationObjectives;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_FROM)
    public String myTravelDestinationFrom;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_UNTIL)
    public String myTravelDestinationUntil;

    public MyTravelDestinationsDataModel(String myTravelDestinationSeq, String myTravelDestinationCountryName, String myTravelDestinationCityName, String myTravelDestinationObjectives, String myTravelDestinationFrom, String myTravelDestinationUntil) {
        this.myTravelDestinationSeq = myTravelDestinationSeq;
        this.myTravelDestinationCountryName = myTravelDestinationCountryName;
        this.myTravelDestinationCityName = myTravelDestinationCityName;
        this.myTravelDestinationObjectives = myTravelDestinationObjectives;
        this.myTravelDestinationFrom = myTravelDestinationFrom;
        this.myTravelDestinationUntil = myTravelDestinationUntil;
    }

    public void setMyTravelDestinationFrom(String myTravelDestinationFrom) {
        this.myTravelDestinationFrom = myTravelDestinationFrom;
    }

    public void setMyTravelDestinationUntil(String myTravelDestinationUntil) {
        this.myTravelDestinationUntil = myTravelDestinationUntil;
    }
}
