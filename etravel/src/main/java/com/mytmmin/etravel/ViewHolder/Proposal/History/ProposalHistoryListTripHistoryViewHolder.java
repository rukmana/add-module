package com.mytmmin.etravel.ViewHolder.Proposal.History;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mytmmin.etravel.R;
import com.omega_r.libs.omegarecyclerview.OmegaRecyclerView;

public class ProposalHistoryListTripHistoryViewHolder extends RecyclerView.ViewHolder {

    public TextView employeeName, employeeDivision, employeeRegNumber, travelStartingCity, travelDestinationCity, travelStartTrip, travelEndTrip, totalExpenses, daysCount;
    public Button tpNumber, openRequestDetails, travelType;
    public de.hdodenhof.circleimageview.CircleImageView profileImage;
    public OmegaRecyclerView listApproverRecyclerView;

    public ProposalHistoryListTripHistoryViewHolder(View itemView) {
        super(itemView);


        employeeName = itemView.findViewById(R.id.text_employee_name);
        employeeDivision = itemView.findViewById(R.id.text_employee_division);
        employeeRegNumber = itemView.findViewById(R.id.text_employee_noreg);
        travelStartingCity = itemView.findViewById(R.id.text_employee_travel_from_city_name);
        travelDestinationCity = itemView.findViewById(R.id.text_employee_travel_to_city_name);
        travelStartTrip = itemView.findViewById(R.id.text_employee_travel_start_trip_date_detail);
        travelEndTrip = itemView.findViewById(R.id.text_employee_travel_end_trip_date_detail);
        tpNumber = itemView.findViewById(R.id.btn_tp_number);
        openRequestDetails = itemView.findViewById(R.id.button_show_details);
        profileImage = itemView.findViewById(R.id.image_profile_image);
        travelType = itemView.findViewById(R.id.travel_type);
        listApproverRecyclerView = itemView.findViewById(R.id.recyclerview_list_approver_history);
        totalExpenses = itemView.findViewById(R.id.text_employee_travel_expenses_details_ammount);
        daysCount = itemView.findViewById(R.id.text_employee_travel_days_count);

    }

}
