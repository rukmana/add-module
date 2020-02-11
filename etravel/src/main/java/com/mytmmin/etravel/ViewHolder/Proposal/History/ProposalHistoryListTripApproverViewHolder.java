package com.mytmmin.etravel.ViewHolder.Proposal.History;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.mytmmin.etravel.R;
import com.xfinity.dahdit.DottedLine;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProposalHistoryListTripApproverViewHolder extends RecyclerView.ViewHolder{

    public CircleImageView imageView;
    public DottedLine dottedLine;
    public ConstraintLayout layoutImage;

    public ProposalHistoryListTripApproverViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.image_profile_image);
        dottedLine = itemView.findViewById(R.id.first_dash);
        layoutImage = itemView.findViewById(R.id.right_layout);

    }
}
