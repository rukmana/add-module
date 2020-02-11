package com.mytmmin.etravel.ViewHolder.Settlement.Approver;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.mytmmin.etravel.R;

public class SettlementApproverListSettlementApprovalViewHolder extends RecyclerView.ViewHolder {

    public TextView employeeName, employeeDivision, employeeRegNumber, travelDestinationCity, travelEndTrip, travelTotalDays, travelTotalExpenses, travelTotalAllocated;
    public Button tpNumber, openRequestDetails, travelType;
    public CheckBox isChecked;
    public de.hdodenhof.circleimageview.CircleImageView profileImage;
    public CardView cardView;
    public ConstraintLayout layoutCardView;

    public SettlementApproverListSettlementApprovalViewHolder(View itemView) {
        super(itemView);


        employeeName = itemView.findViewById(R.id.text_employee_name);
        employeeDivision = itemView.findViewById(R.id.text_employee_division);
        employeeRegNumber = itemView.findViewById(R.id.text_employee_noreg);
        travelDestinationCity = itemView.findViewById(R.id.text_employee_settlement_to_city_name);
        travelEndTrip = itemView.findViewById(R.id.text_employee_settlement_end_trip_date_detail);
        travelTotalDays = itemView.findViewById(R.id.text_employee_settlement_days_count);
        travelTotalExpenses = itemView.findViewById(R.id.text_employee_settlement_expenses_details_ammount);
        tpNumber = itemView.findViewById(R.id.btn_tp_number);
        openRequestDetails = itemView.findViewById(R.id.button_show_details);
        isChecked = itemView.findViewById(R.id.selected_checkbox);
        profileImage = itemView.findViewById(R.id.image_profile_image);
        cardView = itemView.findViewById(R.id.cardview_list_trip_approval);
        layoutCardView = itemView.findViewById(R.id.layout_cardview);
        travelType = itemView.findViewById(R.id.btn_settlement_type);
        travelTotalAllocated = itemView.findViewById(R.id.text_employee_settlement_allocation_details_ammount);

    }

}
