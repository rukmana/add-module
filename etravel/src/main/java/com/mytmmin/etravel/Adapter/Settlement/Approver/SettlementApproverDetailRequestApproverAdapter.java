package com.mytmmin.etravel.Adapter.Settlement.Approver;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mytmmin.etravel.DataModel.Settlement.TravelSettlementAllowanceDetailPerItemDataModel;
import com.mytmmin.etravel.Fragment.Settlement.SettlementApproverRequestDetailsFragment;
import com.mytmmin.etravel.Helper;
import com.mytmmin.etravel.R;
import com.mytmmin.etravel.ViewHolder.Settlement.Approver.SettlementApproverDetailRequestApproverViewHolder;

import java.util.ArrayList;

public class SettlementApproverDetailRequestApproverAdapter extends RecyclerView.Adapter<SettlementApproverDetailRequestApproverViewHolder>{
    private ArrayList<TravelSettlementAllowanceDetailPerItemDataModel> mFeedList = new ArrayList<>();
    private ArrayList<Integer> mFeedTypeList = new ArrayList<>();
    //    private LayoutInflater mLayoutInflater;
    private Activity activity;
    private SettlementApproverRequestDetailsFragment.RecyclerViewClickListener mListener;

    private Helper helper;

    public SettlementApproverDetailRequestApproverAdapter() {
        setHasStableIds(true);
    }

    @Override
    public int getItemCount() {
        return (mFeedList!=null? mFeedList.size():0);
    }

    public void addValues(SettlementApproverRequestDetailsFragment.RecyclerViewClickListener clickListener, Activity activity, ArrayList<TravelSettlementAllowanceDetailPerItemDataModel> list, ArrayList<Integer> typeList) {

        if (this.activity == null)
            this.activity = activity;

        if (this.mListener==null)
            this.mListener = clickListener;

        helper = new Helper(activity);

        for (int i=0; i<list.size(); i++){
            mFeedList.add(list.get(i));
            mFeedTypeList.add(typeList.get(i));
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
    public SettlementApproverDetailRequestApproverViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context mContext = parent.getContext();
        LayoutInflater mLayoutInflater = LayoutInflater.from(mContext);
        View view;

        view = mLayoutInflater.inflate(R.layout.sa_cardview_list_settlement_expenses_details, parent, false);

        return new SettlementApproverDetailRequestApproverViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SettlementApproverDetailRequestApproverViewHolder holder, final int position) {

        final TravelSettlementAllowanceDetailPerItemDataModel dataItem = mFeedList.get(position);
        final Integer typeData = mFeedTypeList.get(position);

        switch (typeData){
            case 1:
                holder.detailTypeName.setText("Winter allowance");
                break;
            case 2:
                holder.detailTypeName.setText("Preparation allowance");
                break;
            case 3:
                holder.detailTypeName.setText("Overseas land transport");
                break;
            case 4:
                holder.detailTypeName.setText("Miscellaneous");
                break;
            case 5:
                holder.detailTypeName.setText("Hotel allowance");
                break;
            case 6:
                holder.detailTypeName.setText("Fiscal Taxes");
                break;
            case 7:
                holder.detailTypeName.setText("Domestic land transport");
                break;
            case 8:
                holder.detailTypeName.setText("Daily allowance");
                break;
            default:
                break;
        }

        holder.detailTypeType.setText("Spent");
        holder.detailTotalExpenses.setText(helper.showTsAllowanceSettlementDetailPerItemValue(dataItem));
        holder.detailAllocated.setText(helper.showTsAllowanceProposalDetailPerItemValue(dataItem));
        holder.detailBalance.setText(helper.tsAllowanceDetailPerItemCalculator(dataItem));

        holder.viewReceipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener==null){
                    return;
                }
                mListener.onViewReceiptClicked(v, position);
            }
        });

    }

//    private LinearLayoutManager getLinearLayoutManager(RecyclerView rv) {
//        return new LinearLayoutManager(rv.getContext(), LinearLayoutManager.VERTICAL, false);
//    }

}
