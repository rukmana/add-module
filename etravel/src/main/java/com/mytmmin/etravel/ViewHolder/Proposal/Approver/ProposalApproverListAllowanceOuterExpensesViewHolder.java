package com.mytmmin.etravel.ViewHolder.Proposal.Approver;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.mytmmin.etravel.R;

public class ProposalApproverListAllowanceOuterExpensesViewHolder extends RecyclerView.ViewHolder{

    public TextView expensesDestinations, expensesDetails;
    public ConstraintLayout collapsibleLayout, mainLayout;
    public ImageView collapseButton;
    public RecyclerView innerRecyclerView;

    public ProposalApproverListAllowanceOuterExpensesViewHolder(@NonNull View itemView) {
        super(itemView);

        expensesDestinations = itemView.findViewById(R.id.total_expenses_outer_destinations_name);
        expensesDetails = itemView.findViewById(R.id.total_expenses_outer_total_expenses);
        collapsibleLayout = itemView.findViewById(R.id.collapsible_inner_expenses_layout);
        collapseButton = itemView.findViewById(R.id.image_collapse_inner_expenses_details);
        innerRecyclerView = itemView.findViewById(R.id.approver_recycler_view_adapter_content_allowance_inner_expenses);
        mainLayout = itemView.findViewById(R.id.outer_expenses_main_layout);

        expensesDestinations.setSelected(true);
        expensesDetails.setSelected(true);

    }
}
