package com.mytmmin.etravel.Adapter.Proposal.Approver;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mytmmin.etravel.DataModel.MyTravelDestinationsDataModel;
import com.mytmmin.etravel.DataModel.Proposal.TravelProposalAllowanceInnerExpensesDataModel;
import com.mytmmin.etravel.DataModel.Proposal.TravelProposalDestinationDetailDataModel;
import com.mytmmin.etravel.Helper;
import com.mytmmin.etravel.R;
import com.mytmmin.etravel.ViewHolder.Proposal.Approver.ProposalApproverListAllowanceOuterExpensesViewHolder;

import java.util.ArrayList;

public class ProposalApproverListAllowanceOuterExpensesAdapter extends RecyclerView.Adapter<ProposalApproverListAllowanceOuterExpensesViewHolder>{
    //mfeedlist is for main source of the data, which is the detail of the allowance destination.
    private ArrayList<TravelProposalDestinationDetailDataModel> mFeedList = new ArrayList<>();
    //secondaryfeedlist is for secondary source of the data which is the destination only, to get the destination name etc.
    private ArrayList<MyTravelDestinationsDataModel> secondaryFeedList = new ArrayList<>();
    private Context mContext;
//    private LayoutInflater mLayoutInflater;
    private Activity activity;
    private ProposalApproverListAllowanceInnerExpensesAdapter innerAdapter;
    private String usdExchangeRate, jpyExchangeRate;

    private Helper helper;

    public ProposalApproverListAllowanceOuterExpensesAdapter() {
        setHasStableIds(true);
    }

    @Override
    public int getItemCount() {
        return (mFeedList!=null? mFeedList.size():0);
    }

    public void addValues(@NonNull Activity activity, ArrayList<TravelProposalDestinationDetailDataModel> list, ArrayList<MyTravelDestinationsDataModel> list2nd, String usdRate, String jpyRate) {

        if (this.activity == null)
            this.activity = activity;

        helper = new Helper(activity);

        this.usdExchangeRate = usdRate;
        this.jpyExchangeRate = jpyRate;

        for (int i=0; i<list.size(); i++){
            mFeedList.add(list.get(i));
            secondaryFeedList.add(list2nd.get(i));
        }

        notifyItemInserted(mFeedList.size() - list.size());
//        notifyDataSetChanged();
    }

    public void clear() {
        int size = mFeedList.size();
        mFeedList.clear();
//        notifyDataSetChanged();
        notifyItemRangeRemoved(0, size);
    }

    @Override
    @NonNull
    public ProposalApproverListAllowanceOuterExpensesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater mLayoutInflater = LayoutInflater.from(mContext);
        View view;

        view = mLayoutInflater.inflate(R.layout.pa_recyclerview_item_allowance_outer_expense, parent, false);

        return new ProposalApproverListAllowanceOuterExpensesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProposalApproverListAllowanceOuterExpensesViewHolder holder, int position) {

        final TravelProposalDestinationDetailDataModel dataItem = mFeedList.get(position);
        final MyTravelDestinationsDataModel data2ndItem = secondaryFeedList.get(position);

        double total = 0;

        ArrayList<TravelProposalAllowanceInnerExpensesDataModel> innerAllowance = new ArrayList<>();

        if (helper.showTpAllowanceDetailPerItemValue(dataItem.tpDestinationDetailPreparationAllowance)!=null){
            innerAllowance.add(new TravelProposalAllowanceInnerExpensesDataModel("Preparation Allowance", helper.showTpAllowanceDetailPerItemValue(dataItem.tpDestinationDetailPreparationAllowance)));
            total+= helper.tpAllowanceDetailPerItemCalculator(dataItem.tpDestinationDetailPreparationAllowance, usdExchangeRate, jpyExchangeRate);
        }
        if (helper.showTpAllowanceDetailPerItemValue(dataItem.tpDestinationDetailWinterAllowance)!=null){
            innerAllowance.add(new TravelProposalAllowanceInnerExpensesDataModel("Winter Allowance", helper.showTpAllowanceDetailPerItemValue(dataItem.tpDestinationDetailWinterAllowance)));
            total+= helper.tpAllowanceDetailPerItemCalculator(dataItem.tpDestinationDetailWinterAllowance, usdExchangeRate, jpyExchangeRate);
        }
        if (helper.showTpAllowanceDetailPerItemValue(dataItem.tpDestinationDetailDailyAllowance)!=null){
            innerAllowance.add(new TravelProposalAllowanceInnerExpensesDataModel("Daily Allowance", helper.showTpAllowanceDetailPerItemValue(dataItem.tpDestinationDetailDailyAllowance)));
            total+= helper.tpAllowanceDetailPerItemCalculator(dataItem.tpDestinationDetailDailyAllowance, usdExchangeRate, jpyExchangeRate);
        }
        if (helper.showTpAllowanceDetailPerItemValue(dataItem.tpDestinationDetailDomesticLandTransportAllowance)!=null){
            innerAllowance.add(new TravelProposalAllowanceInnerExpensesDataModel("Domestic Land Transport", helper.showTpAllowanceDetailPerItemValue(dataItem.tpDestinationDetailDomesticLandTransportAllowance)));
            total+= helper.tpAllowanceDetailPerItemCalculator(dataItem.tpDestinationDetailDomesticLandTransportAllowance, usdExchangeRate, jpyExchangeRate);
        }
        if (helper.showTpAllowanceDetailPerItemValue(dataItem.tpDestinationDetailHotelAllowance)!=null){
            innerAllowance.add(new TravelProposalAllowanceInnerExpensesDataModel("Hotel Allowance", helper.showTpAllowanceDetailPerItemValue(dataItem.tpDestinationDetailHotelAllowance)));
            total+= helper.tpAllowanceDetailPerItemCalculator(dataItem.tpDestinationDetailHotelAllowance, usdExchangeRate, jpyExchangeRate);
        }
        if (helper.showTpAllowanceDetailPerItemValue(dataItem.tpDestinationDetailOverseasLandTransportAllowance)!=null){
            innerAllowance.add(new TravelProposalAllowanceInnerExpensesDataModel("Overseas Land Transport", helper.showTpAllowanceDetailPerItemValue(dataItem.tpDestinationDetailOverseasLandTransportAllowance)));
            total+= helper.tpAllowanceDetailPerItemCalculator(dataItem.tpDestinationDetailOverseasLandTransportAllowance, usdExchangeRate, jpyExchangeRate);
        }
        if (helper.showTpAllowanceDetailPerItemValue(dataItem.tpDestinationDetailMiscellaneousAllowance)!=null){
            innerAllowance.add(new TravelProposalAllowanceInnerExpensesDataModel("Miscellaneous", helper.showTpAllowanceDetailPerItemValue(dataItem.tpDestinationDetailMiscellaneousAllowance)));
            total+= helper.tpAllowanceDetailPerItemCalculator(dataItem.tpDestinationDetailMiscellaneousAllowance, usdExchangeRate, jpyExchangeRate);
        }
        if (helper.showTpAllowanceDetailPerItemValue(dataItem.tpDestinationDetailFiscalTaxesAllowance)!=null){
            innerAllowance.add(new TravelProposalAllowanceInnerExpensesDataModel("Fiscal Taxes", helper.showTpAllowanceDetailPerItemValue(dataItem.tpDestinationDetailFiscalTaxesAllowance)));
            total+= helper.tpAllowanceDetailPerItemCalculator(dataItem.tpDestinationDetailFiscalTaxesAllowance, usdExchangeRate, jpyExchangeRate);
        }

        holder.expensesDetails.setText(helper.currencyFormat(Double.toString(total),"IDR "));
        holder.expensesDestinations.setText(data2ndItem.myTravelDestinationCountryName);
        holder.expensesDestinations.setSelected(true);
        holder.expensesDetails.setSelected(true);

        if(innerAllowance.size()>0){
            holder.innerRecyclerView.setLayoutManager(getLinearLayoutManager());
            innerAdapter = new ProposalApproverListAllowanceInnerExpensesAdapter();
            innerAdapter.addValues(activity, innerAllowance);
            holder.innerRecyclerView.setAdapter(innerAdapter);
            innerAdapter.notifyDataSetChanged();
        }

        holder.collapseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.collapsibleLayout.getVisibility() == View.VISIBLE){
                    holder.collapsibleLayout.setVisibility(View.GONE);
                    holder.collapseButton.setImageResource(R.drawable.ic_expand_more_primary_24dp);
                    holder.innerRecyclerView.scrollToPosition(innerAdapter.getItemCount()-1);
                }
                else if(holder.collapsibleLayout.getVisibility() == View.GONE){
                    holder.collapsibleLayout.setVisibility(View.VISIBLE);
                    holder.collapseButton.setImageResource(R.drawable.ic_expand_less_primary_24dp);
                }
            }
        });

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.collapsibleLayout.getVisibility() == View.VISIBLE){
                    holder.collapsibleLayout.setVisibility(View.GONE);
                    holder.collapseButton.setImageResource(R.drawable.ic_expand_more_primary_24dp);
                    if(innerAdapter!=null)
                        holder.innerRecyclerView.scrollToPosition(innerAdapter.getItemCount()-1);
                }
                else if(holder.collapsibleLayout.getVisibility() == View.GONE){
                    holder.collapsibleLayout.setVisibility(View.VISIBLE);
                    holder.collapseButton.setImageResource(R.drawable.ic_expand_less_primary_24dp);
                }
            }
        });

    }

    private LinearLayoutManager getLinearLayoutManager() {
        return new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
    }

}
