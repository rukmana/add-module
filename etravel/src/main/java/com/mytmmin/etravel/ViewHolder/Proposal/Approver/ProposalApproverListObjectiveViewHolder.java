package com.mytmmin.etravel.ViewHolder.Proposal.Approver;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mytmmin.etravel.R;

public class ProposalApproverListObjectiveViewHolder extends RecyclerView.ViewHolder{

    public TextView objectiveDestination, objectivesDetails;

    public ProposalApproverListObjectiveViewHolder(@NonNull View itemView) {
        super(itemView);

        objectiveDestination = itemView.findViewById(R.id.objectives_details_destination);
        objectivesDetails = itemView.findViewById(R.id.objectives_details_details);

    }
}
