package com.mytmmin.etravel.ViewHolder.Proposal.Approver;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.vipulasri.timelineview.TimelineView;
import com.mytmmin.etravel.R;

public class ProposalApproverListAllowanceInnerExpensesViewHolder extends RecyclerView.ViewHolder{

    public TextView allowanceDetails, allowanceAmmount;
    public TimelineView timeline;
    public View divider;

    public ProposalApproverListAllowanceInnerExpensesViewHolder(@NonNull View itemView) {
        super(itemView);

        allowanceDetails = itemView.findViewById(R.id.total_expenses_inner_destinations_name);
        allowanceAmmount = itemView.findViewById(R.id.total_expenses_inner_total_expenses);
        timeline = itemView.findViewById(R.id.timeline);
        divider = itemView.findViewById(R.id.view_divider);

    }
}
