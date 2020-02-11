package com.mytmmin.etravel.DataModel.Settlement;

import com.google.gson.annotations.SerializedName;
import com.mytmmin.etravel.GlobalVariable;

import java.io.Serializable;

public class TravelSettlementSuspenseAllowanceDataModel implements Serializable {

    @SerializedName(GlobalVariable.SERIALIZED_NAME_DOMESTIC_LAND_TRANSPORT)
    public TravelSettlementAllowanceDetailPerItemDataModel tsSuspenseDomesticLandTransportAllowance;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_HOTEL_ALLOWANCE)
    public TravelSettlementAllowanceDetailPerItemDataModel tsSuspenseHotelAllowance;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_OVERSEAS_LAND_TRANSPORT)
    public TravelSettlementAllowanceDetailPerItemDataModel tsSuspenseOverseasLandTransportAllowance;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_MISCELLANEOUS)
    public TravelSettlementAllowanceDetailPerItemDataModel tsSuspenseMiscellaneousAllowance;
    @SerializedName(GlobalVariable.SERIALIZED_NAME_FISCAL_TAXES)
    public TravelSettlementAllowanceDetailPerItemDataModel tsSuspenseFiscalTaxesAllowance;

    public TravelSettlementSuspenseAllowanceDataModel(TravelSettlementAllowanceDetailPerItemDataModel tsSuspenseDomesticLandTransportAllowance, TravelSettlementAllowanceDetailPerItemDataModel tsSuspenseHotelAllowance, TravelSettlementAllowanceDetailPerItemDataModel tsSuspenseOverseasLandTransportAllowance, TravelSettlementAllowanceDetailPerItemDataModel tsSuspenseMiscellaneousAllowance, TravelSettlementAllowanceDetailPerItemDataModel tsSuspenseFiscalTaxesAllowance) {
        this.tsSuspenseDomesticLandTransportAllowance = tsSuspenseDomesticLandTransportAllowance;
        this.tsSuspenseHotelAllowance = tsSuspenseHotelAllowance;
        this.tsSuspenseOverseasLandTransportAllowance = tsSuspenseOverseasLandTransportAllowance;
        this.tsSuspenseMiscellaneousAllowance = tsSuspenseMiscellaneousAllowance;
        this.tsSuspenseFiscalTaxesAllowance = tsSuspenseFiscalTaxesAllowance;
    }
}
