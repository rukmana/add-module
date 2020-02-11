package com.mytmmin.etravel.ViewHolder.Proposal.Approver;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.mytmmin.etravel.R;

public class ProposalApproverListTripApprovalViewHolder extends RecyclerView.ViewHolder {

    public TextView employeeName, employeeDivision, employeeRegNumber, travelStartingCity, travelDestinationCity, travelStartTrip, travelEndTrip, travelTotalDays, travelTotalExpenses;
    public Button tpNumber, openRequestDetails, travelType;
    public CheckBox isChecked;
    public de.hdodenhof.circleimageview.CircleImageView profileImage;
    public CardView cardView;
    public ConstraintLayout layoutCardView;

    public ProposalApproverListTripApprovalViewHolder(View itemView) {
        super(itemView);


        employeeName = itemView.findViewById(R.id.text_employee_name);
        employeeDivision = itemView.findViewById(R.id.text_employee_division);
        employeeRegNumber = itemView.findViewById(R.id.text_employee_noreg);
        travelStartingCity = itemView.findViewById(R.id.text_employee_travel_from_city_name);
        travelDestinationCity = itemView.findViewById(R.id.text_employee_travel_to_city_name);
        travelStartTrip = itemView.findViewById(R.id.text_employee_travel_start_trip_date_detail);
        travelEndTrip = itemView.findViewById(R.id.text_employee_travel_end_trip_date_detail);
        travelTotalDays = itemView.findViewById(R.id.text_employee_travel_days_count);
        travelTotalExpenses = itemView.findViewById(R.id.text_employee_travel_expenses_details_ammount);
        tpNumber = itemView.findViewById(R.id.btn_tp_number);
        openRequestDetails = itemView.findViewById(R.id.button_show_details);
        isChecked = itemView.findViewById(R.id.selected_checkbox);
        profileImage = itemView.findViewById(R.id.image_profile_image);
        cardView = itemView.findViewById(R.id.cardview_list_trip_approval);
        layoutCardView = itemView.findViewById(R.id.layout_cardview);
        travelType = itemView.findViewById(R.id.btn_travel_type);

        employeeName.setSelected(true);

    }

}
