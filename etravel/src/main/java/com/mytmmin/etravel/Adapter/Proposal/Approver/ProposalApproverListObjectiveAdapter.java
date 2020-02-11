package com.mytmmin.etravel.Adapter.Proposal.Approver;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mytmmin.etravel.DataModel.MyTravelDestinationsDataModel;
import com.mytmmin.etravel.R;
import com.mytmmin.etravel.ViewHolder.Proposal.Approver.ProposalApproverListObjectiveViewHolder;

import java.util.ArrayList;

public class ProposalApproverListObjectiveAdapter extends RecyclerView.Adapter<ProposalApproverListObjectiveViewHolder> {
    private ArrayList<MyTravelDestinationsDataModel> mFeedList = new ArrayList<>();
//    private LayoutInflater mLayoutInflater;
    private Activity activity;

    public ProposalApproverListObjectiveAdapter() {
        setHasStableIds(true);
    }

    @Override
    public int getItemCount() {
        return (mFeedList!=null? mFeedList.size():0);
    }

    public void addValues(Activity activity, ArrayList<MyTravelDestinationsDataModel> list) {

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
    public ProposalApproverListObjectiveViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context mContext = parent.getContext();
        LayoutInflater mLayoutInflater = LayoutInflater.from(mContext);
        View view;

        view = mLayoutInflater.inflate(R.layout.pa_recyclerview_item_objective, parent, false);

        return new ProposalApproverListObjectiveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProposalApproverListObjectiveViewHolder holder, int position) {

        final MyTravelDestinationsDataModel dataItem = mFeedList.get(position);

        holder.objectiveDestination.setText(dataItem.myTravelDestinationCountryName);
        holder.objectivesDetails.setText(dataItem.myTravelDestinationObjectives);

    }
}
