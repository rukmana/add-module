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
import com.mytmmin.etravel.ViewHolder.Proposal.Approver.ProposalApproverListTimelineViewHolder;

import java.util.ArrayList;

public class ProposalApproverListTimelineAdapter extends RecyclerView.Adapter<ProposalApproverListTimelineViewHolder> {
    private ArrayList<MyTravelDestinationsDataModel> mFeedList = new ArrayList<>();
    private Context mContext;
//    private LayoutInflater mLayoutInflater;
    private Activity activity;

    public ProposalApproverListTimelineAdapter() {
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
    public ProposalApproverListTimelineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater mLayoutInflater = LayoutInflater.from(mContext);
        View view;

        view = mLayoutInflater.inflate(R.layout.pa_recyclerview_item_timeline, parent, false);

        return new ProposalApproverListTimelineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProposalApproverListTimelineViewHolder holder, int position) {

        final MyTravelDestinationsDataModel dataItem = mFeedList.get(position);
        holder.timelineView.setMarker(mContext.getResources().getDrawable(R.drawable.ic_flight_landing));

        if (position == (mFeedList.size()-1)){
            holder.divider.setVisibility(View.GONE);
            holder.dummyDate.setVisibility(View.GONE);
            holder.dummyDestination.setVisibility(View.GONE);
        }

        if (position%2==0){
            holder.leftLayout.setVisibility(View.INVISIBLE);
            holder.rightDestination.setText(dataItem.myTravelDestinationCountryName);
            holder.rightDate.setText(dataItem.myTravelDestinationUntil);
        }
        else{
            holder.rightLayout.setVisibility(View.INVISIBLE);
            holder.leftDestination.setText(dataItem.myTravelDestinationCountryName);
            holder.leftDate.setText(dataItem.myTravelDestinationUntil);
        }

    }
}
