package com.mytmmin.etravel.Adapter.Proposal.Approver;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mytmmin.etravel.DataModel.Proposal.TravelProposalAllowanceInnerExpensesDataModel;
import com.mytmmin.etravel.R;
import com.mytmmin.etravel.ViewHolder.Proposal.Approver.ProposalApproverListAllowanceInnerExpensesViewHolder;

import java.util.ArrayList;

public class ProposalApproverListAllowanceInnerExpensesAdapter extends RecyclerView.Adapter<ProposalApproverListAllowanceInnerExpensesViewHolder>{
    private ArrayList<TravelProposalAllowanceInnerExpensesDataModel> mFeedList = new ArrayList<>();
    private Context mContext;
//    private LayoutInflater mLayoutInflater;
    private Activity activity;

    public ProposalApproverListAllowanceInnerExpensesAdapter() {
        setHasStableIds(true);
    }

    @Override
    public int getItemCount() {
        return (mFeedList!=null? mFeedList.size():0);
    }

    public void addValues(Activity activity, ArrayList<TravelProposalAllowanceInnerExpensesDataModel> list) {

        if (this.activity == null)
            this.activity = activity;

        for (int i=0; i<list.size(); i++){
            mFeedList.add(list.get(i));
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
    public ProposalApproverListAllowanceInnerExpensesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater mLayoutInflater = LayoutInflater.from(mContext);
        View view;

        view = mLayoutInflater.inflate(R.layout.pa_recyclerview_item_allowance_inner_expense, parent, false);

        return new ProposalApproverListAllowanceInnerExpensesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProposalApproverListAllowanceInnerExpensesViewHolder holder, int position) {

        final TravelProposalAllowanceInnerExpensesDataModel dataItem = mFeedList.get(position);

        holder.allowanceDetails.setText(dataItem.allowanceDetails);
        holder.allowanceAmmount.setText(dataItem.allowanceAmmount);
        holder.allowanceDetails.setSelected(true);
        holder.allowanceAmmount.setSelected(true);
        holder.timeline.setMarker(mContext.getResources().getDrawable(R.drawable.ic_radio_button_unchecked_orange_24dp));

        if (position == getItemCount()-1){
            holder.divider.setVisibility(View.GONE);
        }

    }

//    private LinearLayoutManager getLinearLayoutManager(RecyclerView rv) {
//        return new LinearLayoutManager(rv.getContext(), LinearLayoutManager.VERTICAL, false);
//    }

}
