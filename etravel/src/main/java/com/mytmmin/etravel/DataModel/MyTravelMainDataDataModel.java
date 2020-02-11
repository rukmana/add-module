package com.mytmmin.etravel.DataModel;

import com.google.gson.annotations.SerializedName;
import com.mytmmin.etravel.DataModel.Settlement.TravelSettlementAllowanceDataModel;
import com.mytmmin.etravel.DataModel.Settlement.TravelSettlementDestinationDetailDataModel;
import com.mytmmin.etravel.DataModel.Proposal.TravelProposalAllowanceDataModel;
import com.mytmmin.etravel.DataModel.Proposal.TravelProposalDestinationDetailDataModel;
import com.mytmmin.etravel.GlobalVariable;

import java.io.Serializable;
import java.util.ArrayList;

public class MyTravelMainDataDataModel implements Serializable {

    public int isChecked;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_DRAFT_NO)
    public String mainDataDraftNumber;

    @SerializedName(GlobalVariable.SERIALIZED_NAME_STATUS_DESC)
    public String mainDataStatusDesc;

    @SerializedName(GlobalVariable.SERIALIZED_NAME_TP_NO)
    public String mainDataTpNo;

    @SerializedName(GlobalVariable.SERIALIZED_NAME_EDIT_NAME)
    public String mainDataEmployeeName;

    @SerializedName(GlobalVariable.SERIALIZED_NAME_NOREG)
    public String mainDataNoreg;

    @SerializedName(GlobalVariable.SERIALIZED_NAME_PATH_LOCATION)
    public String mainDataPhotoUrl;

    @SerializedName(GlobalVariable.SERIALIZED_NAME_USD_EXCHANGE_RATE)
    public String mainDataUsdExchangeRate;

    @SerializedName(GlobalVariable.SERIALIZED_NAME_JPY_EXCHANGE_RATE)
    public String mainDataJpyExchangeRate;

    @SerializedName(GlobalVariable.SERIALIZED_NAME_BUSINESS_TRIP)
    public String mainDataBusinessTrip;

    @SerializedName(GlobalVariable.SERIALIZED_NAME_CITY_FROM)
    public String mainDataCityFrom;

    @SerializedName(GlobalVariable.SERIALIZED_NAME_DIV_ORG_TITLE)
    public String mainDataDivisionTitle;

    @SerializedName(GlobalVariable.SERIALIZED_NAME_DESTINATIONS)
    public ArrayList<MyTravelDestinationsDataModel> mainDataDestinations = new ArrayList<>();

    @SerializedName(GlobalVariable.SERIALIZED_NAME_APPROVALS)
    public ArrayList<MyTravelApprovalsDataModel> mainDataApprovals = new ArrayList<>();

    @SerializedName(GlobalVariable.SERIALIZED_NAME_TP_ALLOWANCE)
    public TravelProposalAllowanceDataModel mainDataTpAllowance;

    @SerializedName(GlobalVariable.SERIALIZED_NAME_TS_ALLOWANCE)
    public TravelSettlementAllowanceDataModel mainDataTsAllowance;

    @SerializedName(GlobalVariable.SERIALIZED_NAME_TP_DESTINATION_DETAILS)
    public ArrayList <TravelProposalDestinationDetailDataModel> mainDataTpDestinationDetail = new ArrayList<>();

    @SerializedName(GlobalVariable.SERIALIZED_NAME_TS_DESTINATION_DETAILS)
    public ArrayList <TravelSettlementDestinationDetailDataModel> mainDataTsDestinationDetail = new ArrayList<>();

    public void setMainDataUsdExchangeRate(String mainDataUsdExchangeRate) {
        this.mainDataUsdExchangeRate = mainDataUsdExchangeRate;
    }

    public void setMainDataJpyExchangeRate(String mainDataJpyExchangeRate) {
        this.mainDataJpyExchangeRate = mainDataJpyExchangeRate;
    }

    public void setIsChecked(int checked) {
        isChecked = checked;
    }
}
