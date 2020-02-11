package com.mytmmin.etravel.ViewHolder.Settlement.History;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mytmmin.etravel.R;
import com.omega_r.libs.omegarecyclerview.OmegaRecyclerView;

public class SettlementHistoryListTripHistoryViewHolder extends RecyclerView.ViewHolder {

    public TextView employeeName, employeeDivision, employeeRegNumber, travelDestinationCity,  travelEndTrip, daysCount, totalAllocation, totalExpenses;
    public Button tpNumber, openRequestDetails, travelType;
    public de.hdodenhof.circleimageview.CircleImageView profileImage;
    public OmegaRecyclerView listApproverRecyclerView;

    public SettlementHistoryListTripHistoryViewHolder(View itemView) {
        super(itemView);


        employeeName = itemView.findViewById(R.id.text_employee_name);
        employeeDivision = itemView.findViewById(R.id.text_employee_division);
        employeeRegNumber = itemView.findViewById(R.id.text_employee_noreg);
        travelDestinationCity = itemView.findViewById(R.id.text_employee_settlement_to_city_name);
        travelEndTrip = itemView.findViewById(R.id.text_employee_settlement_end_trip_date_detail);
        tpNumber = itemView.findViewById(R.id.btn_tp_number);
        openRequestDetails = itemView.findViewById(R.id.button_show_details);
        profileImage = itemView.findViewById(R.id.image_profile_image);
        travelType = itemView.findViewById(R.id.btn_settlement_type);
        listApproverRecyclerView = itemView.findViewById(R.id.recyclerview_list_approver_history);
        totalExpenses = itemView.findViewById(R.id.text_employee_settlement_expenses_details_ammount);
        daysCount = itemView.findViewById(R.id.text_employee_settlement_days_count);
        totalAllocation = itemView.findViewById(R.id.text_employee_settlement_allocation_details_ammount);

    }

}
