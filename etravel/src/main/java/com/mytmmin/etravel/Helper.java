package com.mytmmin.etravel;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.mytmmin.etravel.DataModel.Proposal.TravelProposalAllowanceDetailPerItemDataModel;
import com.mytmmin.etravel.DataModel.Settlement.TravelSettlementAllowanceDetailPerItemDataModel;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Helper {
    
    private Context context;
    
    public Helper (Context context){
        this.context = context;
    }

    // sanitation is to unified the formatting for date, and money.

    public String sanitizeDateHelper(@Nullable String date) {
        // change the date format or send "null" as the date.

        String initDateFormat =  "dd/MM/yyyy";
        String endDateFormat = "dd MMM yyyy";

        if (date == null){
            return "null";
        }
        else{
            try{
                Date initDate = new SimpleDateFormat(initDateFormat, Locale.US).parse(date);
                SimpleDateFormat formatter = new SimpleDateFormat(endDateFormat, Locale.US);

                return formatter.format((initDate!=null? initDate:"null"));
            }
            catch (Exception e){
                //
                handleExecption(e, "Sanitation date helper - ");
                return date;
            }
        }

    }

    public String sanitizeMoneyHelper(@Nullable String money, boolean currency){
        //remove comma from the string. and if the currency == true, the function is called to calculate the rate USD and JPY in IDR

        if (money != null){
            if (money.contains(",")){
                money = money.replaceAll(",", "");
            }

            //type 0 = bukan untuk pengalian currency
            if(!currency){
                money = money.substring(0, money.length() - 3);
            }

        }
        else{
            handleExecption(null, "Sanitation money helper - ");
        }

        return money;
    }

    public void sanitizeTpDetailPerItem (TravelProposalAllowanceDetailPerItemDataModel dataItem){

        try{
            if (dataItem.tpAllowanceIdr != null && !dataItem.tpAllowanceIdr.equals("0.00")){
                dataItem.setTpAllowanceIdr(sanitizeMoneyHelper(dataItem.tpAllowanceIdr, false));
            }
            if (dataItem.tpAllowanceUsd != null && !dataItem.tpAllowanceUsd.equals("0.00")){
                dataItem.setTpAllowanceUsd(sanitizeMoneyHelper(dataItem.tpAllowanceUsd, false));
            }
            if (dataItem.tpAllowanceJpy != null && !dataItem.tpAllowanceJpy.equals("0.00")){
                dataItem.setTpAllowanceJpy(sanitizeMoneyHelper(dataItem.tpAllowanceJpy, false));
            }
        }catch (Exception e){
            handleExecption(e, "Sanitation tp detail per item helper - ");
        }

    }

    public void sanitizeTsDetailPerItem (TravelSettlementAllowanceDetailPerItemDataModel dataItem){
        try{
            if (dataItem.tsAllowanceIdrProposal != null && !dataItem.tsAllowanceIdrProposal.equals("0.00")){
                dataItem.setTsAllowanceIdrProposal(sanitizeMoneyHelper(dataItem.tsAllowanceIdrProposal, false));
            }
            if (dataItem.tsAllowanceIdrSettlement != null && !dataItem.tsAllowanceIdrSettlement.equals("0.00")){
                dataItem.setTsAllowanceIdrSettlement(sanitizeMoneyHelper(dataItem.tsAllowanceIdrSettlement, false));
            }
            if (dataItem.tsAllowanceUsdProposal != null && !dataItem.tsAllowanceUsdProposal.equals("0.00")){
                dataItem.setTsAllowanceUsdProposal(sanitizeMoneyHelper(dataItem.tsAllowanceUsdProposal, false));
            }
            if (dataItem.tsAllowanceUsdSettlement != null && !dataItem.tsAllowanceUsdSettlement.equals("0.00")){
                dataItem.setTsAllowanceUsdSettlement(sanitizeMoneyHelper(dataItem.tsAllowanceUsdSettlement, false));
            }
            if (dataItem.tsAllowanceJpyProposal != null && !dataItem.tsAllowanceJpyProposal.equals("0.00")){
                dataItem.setTsAllowanceJpyProposal(sanitizeMoneyHelper(dataItem.tsAllowanceJpyProposal, false));
            }
            if (dataItem.tsAllowanceJpySettlement != null && !dataItem.tsAllowanceJpySettlement.equals("0.00")){
                dataItem.setTsAllowanceJpySettlement(sanitizeMoneyHelper(dataItem.tsAllowanceJpySettlement, false));
            }
        }catch (Exception e){
            handleExecption(e, "Sanitation ts detail per item helper - ");
        }


    }

    public String showTpAllowanceDetailPerItemValue(TravelProposalAllowanceDetailPerItemDataModel dataItem){
        String showedValue = null;

        try{
            if (dataItem.tpAllowanceIdr != null && !dataItem.tpAllowanceIdr.equals("0.00")){
                showedValue = currencyFormat(dataItem.tpAllowanceIdr, "IDR ");
            }
            if (dataItem.tpAllowanceUsd != null && !dataItem.tpAllowanceUsd.equals("0.00")){
                showedValue = currencyFormat(dataItem.tpAllowanceUsd, "USD ");
            }
            if (dataItem.tpAllowanceJpy != null && !dataItem.tpAllowanceJpy.equals("0.00")){
                showedValue = currencyFormat(dataItem.tpAllowanceJpy, "JPY ");
            }
        }catch (Exception e){
            handleExecption(e, "Show tp allowance detail per item helper - ");
        }

        return  showedValue;
    }

    public String showTsAllowanceProposalDetailPerItemValue(TravelSettlementAllowanceDetailPerItemDataModel dataItem){
        String showedValue = null;

        try{
            if (dataItem.tsAllowanceIdrProposal != null && !dataItem.tsAllowanceIdrProposal.equals("0.00")){
                showedValue = currencyFormat(dataItem.tsAllowanceIdrProposal, "IDR ");
            }
            if (dataItem.tsAllowanceUsdProposal != null && !dataItem.tsAllowanceUsdProposal.equals("0.00")){
                showedValue = currencyFormat(dataItem.tsAllowanceUsdProposal, "USD ");
            }
            if (dataItem.tsAllowanceJpyProposal != null && !dataItem.tsAllowanceJpyProposal.equals("0.00")){
                showedValue = currencyFormat(dataItem.tsAllowanceJpyProposal, "JPY ");
            }
        }catch (Exception e){
            handleExecption(e, "Show ts allowance proposal detail per item helper - ");
        }

        return  showedValue;
    }

    public String showTsAllowanceSettlementDetailPerItemValue(TravelSettlementAllowanceDetailPerItemDataModel dataItem){
        String showedValue = null;

        try{
            if (dataItem.tsAllowanceIdrSettlement != null && !dataItem.tsAllowanceIdrSettlement.equals("0.00")){
                showedValue = currencyFormat(dataItem.tsAllowanceIdrSettlement, "IDR ");
            }
            if (dataItem.tsAllowanceUsdSettlement != null && !dataItem.tsAllowanceUsdSettlement.equals("0.00")){
                showedValue = currencyFormat(dataItem.tsAllowanceUsdSettlement, "USD ");
            }
            if (dataItem.tsAllowanceJpySettlement != null && !dataItem.tsAllowanceJpySettlement.equals("0.00")){
                showedValue = currencyFormat(dataItem.tsAllowanceJpySettlement, "JPY ");
            }
        }catch (Exception e){
            handleExecption(e, "Show ts allowance settlement detail per item helper - ");
        }

        return  showedValue;
    }

    public double tpAllowanceDetailPerItemCalculator(TravelProposalAllowanceDetailPerItemDataModel dataItem, String usdExchangeRate, String jpyExchangeRate){
        double total=0.00;

        if (usdExchangeRate == null){
            usdExchangeRate = "1.00";
        }
        else if (jpyExchangeRate == null){
            jpyExchangeRate = "1.00";
        }

        try{
            if (dataItem.tpAllowanceIdr != null && !dataItem.tpAllowanceIdr.equals("0.00")){
                total += Double.parseDouble(dataItem.tpAllowanceIdr);
            }
            if (dataItem.tpAllowanceUsd != null && !dataItem.tpAllowanceUsd.equals("0.00")){
                total += (Double.parseDouble(dataItem.tpAllowanceUsd)*Double.parseDouble(usdExchangeRate));
            }
            if (dataItem.tpAllowanceJpy != null && !dataItem.tpAllowanceJpy.equals("0.00")){
                total += (Double.parseDouble(dataItem.tpAllowanceJpy)*Double.parseDouble(jpyExchangeRate));
            }
        }catch (Exception e){
            handleExecption(e, "Tp allowance detail per item calc helper - ");
        }
        

        return total;
    }

    public String tsAllowanceDetailPerItemCalculator(TravelSettlementAllowanceDetailPerItemDataModel dataItem){
        double total;
        String totalStr="0";

        try{
            if (dataItem.tsAllowanceIdrProposal!=null && !dataItem.tsAllowanceIdrProposal.equals("0.00") ){
                if (dataItem.tsAllowanceIdrSettlement!=null && !dataItem.tsAllowanceIdrSettlement.equals("0.00") ){
                    total = Double.parseDouble(dataItem.tsAllowanceIdrProposal) - Double.parseDouble(dataItem.tsAllowanceIdrSettlement);
                    totalStr = currencyFormat(Double.toString(total), "IDR ");
                }
            }
            if (dataItem.tsAllowanceUsdProposal!=null && !dataItem.tsAllowanceUsdProposal.equals("0.00") ){
                if (dataItem.tsAllowanceUsdSettlement!=null && !dataItem.tsAllowanceUsdSettlement.equals("0.00") ){
                    total = Double.parseDouble(dataItem.tsAllowanceUsdProposal) - Double.parseDouble(dataItem.tsAllowanceUsdSettlement);
                    totalStr = currencyFormat(Double.toString(total), "USD ");
                }
            }
            if (dataItem.tsAllowanceJpyProposal!=null && !dataItem.tsAllowanceJpyProposal.equals("0.00") ){
                if (dataItem.tsAllowanceJpySettlement!=null && !dataItem.tsAllowanceJpySettlement.equals("0.00") ){
                    total = Double.parseDouble(dataItem.tsAllowanceJpyProposal) - Double.parseDouble(dataItem.tsAllowanceJpySettlement);
                    totalStr = currencyFormat(Double.toString(total), "JPY ");
                }
            }
        }catch (Exception e){
            handleExecption(e, "Ts allowance detail per item calc helper - ");
        }

        return totalStr;
    }

    public String currencyFormat(String amount, String currency) {
        DecimalFormat formatter = new DecimalFormat("###,###,##0.00");

        try{
            //the negative sign didn't changed in sanitation intentionally. it is to determine whether the settlement is return value, balance, or additional
            if(amount.contains("-")){
                amount = amount.replaceAll("-", "");
            }
        }catch (Exception e){
            handleExecption(e, "Currency format helper - ");
        }
        

        return currency+formatter.format(Double.parseDouble(amount));
    }



    public long calculateDateDiff (String startDate, String endDate){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.US);
        long diff = 0;

        try {
            Date dateStart = sdf.parse(startDate);
            Date dateEnd = sdf.parse(endDate);

            if (dateEnd!=null && dateStart!=null){
                //add 1 day to the end date
                Calendar c = Calendar.getInstance();
                c.setTime(dateEnd);
                c.add(Calendar.DATE, 1);

                dateEnd = new Date(c.getTimeInMillis());
                diff = dateEnd.getTime() - dateStart.getTime();
            }
        }catch (Exception e){
            handleExecption(e, "Calculate date diff helper - ");
        }

        return diff;
    }
    
    private void handleExecption (Exception e, String functionName){
        if (e == null) {
            Toast.makeText(context, functionName, Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(context, functionName+e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

}
