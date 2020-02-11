package com.mytmmin.etravel.DataModel.Proposal;

import com.google.gson.annotations.SerializedName;
import com.mytmmin.etravel.GlobalVariable;

import java.io.Serializable;

public class TravelProposalDestinationDetailDataModel implements Serializable {

    @SerializedName(GlobalVariable.SERIALIZED_NAME_TP_DESTINATION_SEQ)
    public String tpDestinationDetailSeq;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_PREPARATION_ALLOWANCE)
    public TravelProposalAllowanceDetailPerItemDataModel tpDestinationDetailPreparationAllowance;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_WINTER_ALLOWANCE)
    public TravelProposalAllowanceDetailPerItemDataModel tpDestinationDetailWinterAllowance;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_DAILY_ALLOWANCE)
    public TravelProposalAllowanceDetailPerItemDataModel tpDestinationDetailDailyAllowance;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_DOMESTIC_LAND_TRANSPORT)
    public TravelProposalAllowanceDetailPerItemDataModel tpDestinationDetailDomesticLandTransportAllowance;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_HOTEL_ALLOWANCE)
    public TravelProposalAllowanceDetailPerItemDataModel tpDestinationDetailHotelAllowance;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_OVERSEAS_LAND_TRANSPORT)
    public TravelProposalAllowanceDetailPerItemDataModel tpDestinationDetailOverseasLandTransportAllowance;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_MISCELLANEOUS)
    public TravelProposalAllowanceDetailPerItemDataModel tpDestinationDetailMiscellaneousAllowance;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_FISCAL_TAXES)
    public TravelProposalAllowanceDetailPerItemDataModel tpDestinationDetailFiscalTaxesAllowance;

    public TravelProposalDestinationDetailDataModel(String tpDestinationDetailSeq, TravelProposalAllowanceDetailPerItemDataModel tpDestinationDetailPreparationAllowance, TravelProposalAllowanceDetailPerItemDataModel tpDestinationDetailWinterAllowance, TravelProposalAllowanceDetailPerItemDataModel tpDestinationDetailDailyAllowance, TravelProposalAllowanceDetailPerItemDataModel tpDestinationDetailDomesticLandTransportAllowance, TravelProposalAllowanceDetailPerItemDataModel tpDestinationDetailHotelAllowance, TravelProposalAllowanceDetailPerItemDataModel tpDestinationDetailOverseasLandTransportAllowance, TravelProposalAllowanceDetailPerItemDataModel tpDestinationDetailMiscellaneousAllowance, TravelProposalAllowanceDetailPerItemDataModel tpDestinationDetailFiscalTaxesAllowance) {
        this.tpDestinationDetailSeq = tpDestinationDetailSeq;
        this.tpDestinationDetailPreparationAllowance = tpDestinationDetailPreparationAllowance;
        this.tpDestinationDetailWinterAllowance = tpDestinationDetailWinterAllowance;
        this.tpDestinationDetailDailyAllowance = tpDestinationDetailDailyAllowance;
        this.tpDestinationDetailDomesticLandTransportAllowance = tpDestinationDetailDomesticLandTransportAllowance;
        this.tpDestinationDetailHotelAllowance = tpDestinationDetailHotelAllowance;
        this.tpDestinationDetailOverseasLandTransportAllowance = tpDestinationDetailOverseasLandTransportAllowance;
        this.tpDestinationDetailMiscellaneousAllowance = tpDestinationDetailMiscellaneousAllowance;
        this.tpDestinationDetailFiscalTaxesAllowance = tpDestinationDetailFiscalTaxesAllowance;
    }
}
