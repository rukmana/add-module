package com.mytmmin.etravel.ViewHolder.Proposal.Approver;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.vipulasri.timelineview.TimelineView;
import com.mytmmin.etravel.R;

public class ProposalApproverListTimelineViewHolder extends RecyclerView.ViewHolder {

    public LinearLayout leftLayout, rightLayout;
    public TextView leftDestination, rightDestination, leftDate, rightDate, dummyDestination, dummyDate;
    public TimelineView timelineView;
    public View divider;

    public ProposalApproverListTimelineViewHolder(@NonNull View itemView) {
        super(itemView);

        leftLayout = itemView.findViewById(R.id.left_layout);
        rightLayout = itemView.findViewById(R.id.right_layout);
        leftDestination = itemView.findViewById(R.id.left_destination_city_name);
        rightDestination = itemView.findViewById(R.id.right_destination_city_name);
        leftDate = itemView.findViewById(R.id.left_destination_date);
        rightDate = itemView.findViewById(R.id.right_destination_date);
        timelineView = itemView.findViewById(R.id.timeline);
        divider = itemView.findViewById(R.id.view_divider);
        dummyDestination = itemView.findViewById(R.id.left_destination_city_name_dummy);
        dummyDate = itemView.findViewById(R.id.left_destination_date_dummy);
    }
}
