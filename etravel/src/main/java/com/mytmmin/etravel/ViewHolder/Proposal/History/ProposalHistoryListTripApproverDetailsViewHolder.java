package com.mytmmin.etravel.ViewHolder.Proposal.History;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.mytmmin.etravel.R;
import com.xfinity.dahdit.DottedLine;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProposalHistoryListTripApproverDetailsViewHolder extends RecyclerView.ViewHolder{

    public CircleImageView imageView;
    public TextView approverName, approverDate, approverStatus;
    public DottedLine dottedLine;
    public ConstraintLayout layout;

    public ProposalHistoryListTripApproverDetailsViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.image_profile_image);
        approverName = itemView.findViewById(R.id.approval_status_name);
        approverDate = itemView.findViewById(R.id.approval_status_date);
        approverStatus = itemView.findViewById(R.id.approval_status_text);
        dottedLine = itemView.findViewById(R.id.first_dash);
        layout = itemView.findViewById(R.id.layout_id);

    }
}
