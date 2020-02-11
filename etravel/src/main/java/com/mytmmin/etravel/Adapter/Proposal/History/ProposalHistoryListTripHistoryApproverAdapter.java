package com.mytmmin.etravel.Adapter.Proposal.History;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mytmmin.etravel.DataModel.MyTravelApprovalsDataModel;
import com.mytmmin.etravel.GlideApp;
import com.mytmmin.etravel.R;
import com.mytmmin.etravel.ViewHolder.Proposal.History.ProposalHistoryListTripApproverViewHolder;

import java.util.ArrayList;

public class ProposalHistoryListTripHistoryApproverAdapter extends RecyclerView.Adapter<ProposalHistoryListTripApproverViewHolder>{
    private ArrayList<MyTravelApprovalsDataModel> mFeedList = new ArrayList<>();
    private Context mContext;
//    private LayoutInflater mLayoutInflater;
    private Activity activity;

    ProposalHistoryListTripHistoryApproverAdapter() {
        setHasStableIds(true);
    }

    @Override
    public int getItemCount() {
        return (mFeedList!=null? mFeedList.size():0);
    }

    public void addValues(Activity activity, ArrayList<MyTravelApprovalsDataModel> list) {

        if (this.activity == null)
            this.activity = activity;

        for (int i=0; i<list.size(); i++){
            mFeedList.add(list.get(i));
        }

        notifyItemInserted(mFeedList.size() - list.size());
//        notifyDataSetChanged();
    }

    @Override
    @NonNull
    public ProposalHistoryListTripApproverViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater mLayoutInflater = LayoutInflater.from(mContext);
        View view;

        view = mLayoutInflater.inflate(R.layout.ph_recyclerview_item_list_approver, parent, false);

        return new ProposalHistoryListTripApproverViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProposalHistoryListTripApproverViewHolder holder, int position) {

        final MyTravelApprovalsDataModel dataItem = mFeedList.get(position);

        final float scale = mContext.getResources().getDisplayMetrics().density;
        int pixels = (int) (10 * scale + 0.5f);

        GlideApp.with(activity)
                .load(dataItem.myTravelApprovalPhotoUrl)
                .override(100,100)
                .centerCrop()
                .placeholder(R.drawable.ic_arrow_downward_green_24dp)
                .error(R.drawable.ic_arrow_upward_primary_24dp)
                .into(holder.imageView);

        Paint paint = holder.dottedLine.getPaint();

        //set first and last item padding
        if (position == getItemCount()-1){
            holder.dottedLine.setVisibility(View.GONE);
            holder.layoutImage.setPadding(0,0,pixels,0);
        }
        else if(position == 0){
            holder.layoutImage.setPadding(pixels,0,0,0);
        }

        if (position == 0 || position == 1){
            paint.setColor(activity.getResources().getColor(R.color.primary_button));
            holder.dottedLine.setPaint(paint);
            holder.imageView.setBorderColor(activity.getResources().getColor(R.color.primary_button));
        }
        else if (position == 2){
            paint.setColor(activity.getResources().getColor(R.color.orange_color));
            holder.dottedLine.setPaint(paint);
            holder.imageView.setBorderColor(activity.getResources().getColor(R.color.orange_color));
        }
        else{
            paint.setColor(activity.getResources().getColor(R.color.button_disabled));
            holder.dottedLine.setPaint(paint);
            holder.imageView.setBorderColor(activity.getResources().getColor(R.color.button_disabled));
        }
    }

}
