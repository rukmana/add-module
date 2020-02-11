package com.mytmmin.etravel.DataModel.Settlement;

import com.google.gson.annotations.SerializedName;
import com.mytmmin.etravel.GlobalVariable;

import java.io.Serializable;

public class TravelSettlementDestinationDetailDataModel implements Serializable {

    @SerializedName(GlobalVariable.SERIALIZED_NAME_TP_DESTINATION_SEQ)
    public String tsDestinationDetailSeq;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_PREPARATION_ALLOWANCE)
    public TravelSettlementAllowanceDetailPerItemDataModel tsDestinationDetailPreparationAllowance;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_WINTER_ALLOWANCE)
    public TravelSettlementAllowanceDetailPerItemDataModel tsDestinationDetailWinterAllowance;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_DAILY_ALLOWANCE)
    public TravelSettlementAllowanceDetailPerItemDataModel tsDestinationDetailDailyAllowance;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_DOMESTIC_LAND_TRANSPORT)
    public TravelSettlementAllowanceDetailPerItemDataModel tsDestinationDetailDomesticLandTransportAllowance;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_HOTEL_ALLOWANCE)
    public TravelSettlementAllowanceDetailPerItemDataModel tsDestinationDetailHotelAllowance;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_OVERSEAS_LAND_TRANSPORT)
    public TravelSettlementAllowanceDetailPerItemDataModel tsDestinationDetailOverseasLandTransportAllowance;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_MISCELLANEOUS)
    public TravelSettlementAllowanceDetailPerItemDataModel tsDestinationDetailMiscellaneousAllowance;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_FISCAL_TAXES)
    public TravelSettlementAllowanceDetailPerItemDataModel tsDestinationDetailFiscalTaxesAllowance;

    public TravelSettlementDestinationDetailDataModel(String tsDestinationDetailSeq, TravelSettlementAllowanceDetailPerItemDataModel tsDestinationDetailPreparationAllowance, TravelSettlementAllowanceDetailPerItemDataModel tsDestinationDetailWinterAllowance, TravelSettlementAllowanceDetailPerItemDataModel tsDestinationDetailDailyAllowance, TravelSettlementAllowanceDetailPerItemDataModel tsDestinationDetailDomesticLandTransportAllowance, TravelSettlementAllowanceDetailPerItemDataModel tsDestinationDetailHotelAllowance, TravelSettlementAllowanceDetailPerItemDataModel tsDestinationDetailOverseasLandTransportAllowance, TravelSettlementAllowanceDetailPerItemDataModel tsDestinationDetailMiscellaneousAllowance, TravelSettlementAllowanceDetailPerItemDataModel tsDestinationDetailFiscalTaxesAllowance) {
        this.tsDestinationDetailSeq = tsDestinationDetailSeq;
        this.tsDestinationDetailPreparationAllowance = tsDestinationDetailPreparationAllowance;
        this.tsDestinationDetailWinterAllowance = tsDestinationDetailWinterAllowance;
        this.tsDestinationDetailDailyAllowance = tsDestinationDetailDailyAllowance;
        this.tsDestinationDetailDomesticLandTransportAllowance = tsDestinationDetailDomesticLandTransportAllowance;
        this.tsDestinationDetailHotelAllowance = tsDestinationDetailHotelAllowance;
        this.tsDestinationDetailOverseasLandTransportAllowance = tsDestinationDetailOverseasLandTransportAllowance;
        this.tsDestinationDetailMiscellaneousAllowance = tsDestinationDetailMiscellaneousAllowance;
        this.tsDestinationDetailFiscalTaxesAllowance = tsDestinationDetailFiscalTaxesAllowance;
    }
}
