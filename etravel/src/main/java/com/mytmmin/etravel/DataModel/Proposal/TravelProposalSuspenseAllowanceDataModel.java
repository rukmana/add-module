package com.mytmmin.etravel.DataModel.Proposal;

import com.google.gson.annotations.SerializedName;
import com.mytmmin.etravel.GlobalVariable;

import java.io.Serializable;

public class TravelProposalSuspenseAllowanceDataModel implements Serializable {

    @SerializedName(GlobalVariable.SERIALIZED_NAME_DOMESTIC_LAND_TRANSPORT)
    public TravelProposalAllowanceDetailPerItemDataModel tpSuspenseDomesticLandTransportAllowance;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_HOTEL_ALLOWANCE)
    public TravelProposalAllowanceDetailPerItemDataModel tpSuspenseHotelAllowance;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_OVERSEAS_LAND_TRANSPORT)
    public TravelProposalAllowanceDetailPerItemDataModel tpSuspenseOverseasLandTransportAllowance;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_MISCELLANEOUS)
    public TravelProposalAllowanceDetailPerItemDataModel tpSuspenseMiscellaneousAllowance;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_FISCAL_TAXES)
    public TravelProposalAllowanceDetailPerItemDataModel tpSuspenseFiscalTaxesAllowance;

    public TravelProposalSuspenseAllowanceDataModel(TravelProposalAllowanceDetailPerItemDataModel tpSuspenseDomesticLandTransportAllowance, TravelProposalAllowanceDetailPerItemDataModel tpSuspenseHotelAllowance, TravelProposalAllowanceDetailPerItemDataModel tpSuspenseOverseasLandTransportAllowance, TravelProposalAllowanceDetailPerItemDataModel tpSuspenseMiscellaneousAllowance, TravelProposalAllowanceDetailPerItemDataModel tpSuspenseFiscalTaxesAllowance) {
        this.tpSuspenseDomesticLandTransportAllowance = tpSuspenseDomesticLandTransportAllowance;
        this.tpSuspenseHotelAllowance = tpSuspenseHotelAllowance;
        this.tpSuspenseOverseasLandTransportAllowance = tpSuspenseOverseasLandTransportAllowance;
        this.tpSuspenseMiscellaneousAllowance = tpSuspenseMiscellaneousAllowance;
        this.tpSuspenseFiscalTaxesAllowance = tpSuspenseFiscalTaxesAllowance;
    }
}
