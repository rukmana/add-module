package com.mytmmin.etravel.ViewHolder.Settlement.Approver;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.mytmmin.etravel.R;

public class SettlementApproverDetailRequestApproverViewHolder extends RecyclerView.ViewHolder {

    public TextView detailTypeName, detailTypeType, detailTotalExpenses, detailAllocated, detailBalance;
    public Button viewReceipt;
    public CardView cardView;
    public ConstraintLayout layoutCardView;

    public SettlementApproverDetailRequestApproverViewHolder(View itemView) {
        super(itemView);
        
        detailTypeName = itemView.findViewById(R.id.text_expenses_type_name);
        detailTypeType = itemView.findViewById(R.id.text_expenses_type_type);
        detailTotalExpenses = itemView.findViewById(R.id.text_expenses_type_total);
        detailAllocated = itemView.findViewById(R.id.text_expenses_type_allocated_details);
        detailBalance = itemView.findViewById(R.id.text_expenses_type_balance_details);
        viewReceipt = itemView.findViewById(R.id.btn_view_receipt);
        cardView = itemView.findViewById(R.id.cardview_settlement_expenses_detail);
        layoutCardView = itemView.findViewById(R.id.layout_cardview);

    }

}
