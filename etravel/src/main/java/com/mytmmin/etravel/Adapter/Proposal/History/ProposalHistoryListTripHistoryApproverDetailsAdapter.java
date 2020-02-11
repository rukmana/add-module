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
import com.mytmmin.etravel.ViewHolder.Proposal.History.ProposalHistoryListTripApproverDetailsViewHolder;

import java.util.ArrayList;

public class ProposalHistoryListTripHistoryApproverDetailsAdapter extends RecyclerView.Adapter<ProposalHistoryListTripApproverDetailsViewHolder>{
    private ArrayList<MyTravelApprovalsDataModel> mFeedList = new ArrayList<>();
    private Context mContext;
//    private LayoutInflater mLayoutInflater;
    private Activity activity;

    public ProposalHistoryListTripHistoryApproverDetailsAdapter() {
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
    public ProposalHistoryListTripApproverDetailsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater mLayoutInflater = LayoutInflater.from(mContext);
        View view;

        view = mLayoutInflater.inflate(R.layout.ph_recyclerview_item_approver_detail, parent, false);

        return new ProposalHistoryListTripApproverDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProposalHistoryListTripApproverDetailsViewHolder holder, int position) {

        final MyTravelApprovalsDataModel dataItem = mFeedList.get(position);

        final float scale = mContext.getResources().getDisplayMetrics().density;
        int pixels = (int) (10 * scale + 0.5f);

//        holder.imageView.setImageResource(activity.getResources().
//                getIdentifier(dataItem.photoUrl, null, activity.getPackageName()));
        GlideApp.with(activity)
                .load(dataItem.myTravelApprovalPhotoUrl)
                .override(100,100)
                .centerCrop()
                .placeholder(R.drawable.ic_person_grey_24dp)
                .error(R.drawable.ic_person_grey_24dp)
                .into(holder.imageView);

        holder.approverName.setText(dataItem.myTravelApprovalApproverName);
        holder.approverName.setSelected(true);
        holder.approverDate.setText("");
        holder.approverStatus.setText(dataItem.myTravelApprovalApprovedStatus);

        Paint paint = holder.dottedLine.getPaint();

        //set first and last item padding
        if (position == getItemCount()-1){
            holder.dottedLine.setVisibility(View.GONE);
            holder.layout.setPadding(0,0,0,pixels);
        }
        else if(position == 0){
            holder.layout.setPadding(0,pixels,0,0);
        }

        if (dataItem.myTravelApprovalApprovedStatus.toUpperCase().equals("FINISH")){
            paint.setColor(activity.getResources().getColor(R.color.primary_button));
            holder.dottedLine.setPaint(paint);
            holder.imageView.setBorderColor(activity.getResources().getColor(R.color.primary_button));
            holder.approverStatus.setTextColor(activity.getResources().getColor(R.color.primary_button));
        }
        else if (dataItem.myTravelApprovalApprovedStatus.toUpperCase().equals("INPROCESS")){
            paint.setColor(activity.getResources().getColor(R.color.orange_color));
            holder.dottedLine.setPaint(paint);
            holder.imageView.setBorderColor(activity.getResources().getColor(R.color.orange_color));
            holder.approverDate.setTextColor(activity.getResources().getColor(R.color.orange_color));
        }
        else{
            paint.setColor(activity.getResources().getColor(R.color.button_disabled));
            holder.dottedLine.setPaint(paint);
            holder.imageView.setBorderColor(activity.getResources().getColor(R.color.button_disabled));
        }
    }

}
