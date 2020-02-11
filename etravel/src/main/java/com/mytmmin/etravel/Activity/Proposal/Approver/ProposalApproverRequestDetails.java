package com.mytmmin.etravel.Activity.Proposal.Approver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.vipulasri.timelineview.TimelineView;
import com.mytmmin.etravel.Adapter.Proposal.Approver.ProposalApproverListObjectiveAdapter;
import com.mytmmin.etravel.Adapter.Proposal.Approver.ProposalApproverListAllowanceOuterExpensesAdapter;
import com.mytmmin.etravel.Adapter.Proposal.Approver.ProposalApproverListTimelineAdapter;
import com.mytmmin.etravel.DataModel.MyTravelDestinationsDataModel;
import com.mytmmin.etravel.DataModel.MyTravelMainDataDataModel;
import com.mytmmin.etravel.DataModel.Proposal.TravelProposalDestinationDetailDataModel;
import com.mytmmin.etravel.GlideApp;
import com.mytmmin.etravel.GlobalVariable;
import com.mytmmin.etravel.Helper;
import com.mytmmin.etravel.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class ProposalApproverRequestDetails extends AppCompatActivity implements View.OnClickListener{

    private MyTravelMainDataDataModel dataItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pa_activity_approver_request_details);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                dataItem = null;
            }
            else {
                dataItem = (MyTravelMainDataDataModel) extras.getSerializable(GlobalVariable.TAG_OPEN_PROPOSAL_APPROVER_REQUEST_DETAILS_ACTIVITY);
            }
        } else {
            dataItem = (MyTravelMainDataDataModel) savedInstanceState.getSerializable(GlobalVariable.TAG_OPEN_PROPOSAL_APPROVER_REQUEST_DETAILS_ACTIVITY);
        }

        initView();
    }

    private void initView(){
        Helper helper = new Helper(getApplicationContext());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationIcon(R.drawable.ic_chevron_left_white_24dp);
        toolbar.setNavigationOnClickListener(this);

        String toFromDate = dataItem.mainDataDestinations.get(0).myTravelDestinationFrom+" to "+dataItem.mainDataDestinations.get(dataItem.mainDataDestinations.size()-1).myTravelDestinationUntil;

        TextView totalAllowance = findViewById(R.id.total_expenses_total_ammount);
        TextView employeeName = findViewById(R.id.text_employee_name);
        TextView employeeRegNum = findViewById(R.id.text_employee_noreg);
        TextView employeeDivision = findViewById(R.id.text_employee_division);
        TextView employeePosition = findViewById(R.id.text_employee_position);
        CircleImageView photoProfile = findViewById(R.id.image_profile_image);
        Button tpNumber = findViewById(R.id.btn_tp_number);
        TextView tripDateDetails = findViewById(R.id.trip_date_details);

        employeeRegNum.setText(dataItem.mainDataNoreg);
        employeeDivision.setText(dataItem.mainDataDivisionTitle);
        employeeName.setText(dataItem.mainDataEmployeeName);

        GlideApp.with(this)
                .load(dataItem.mainDataPhotoUrl)
                .override(100,100)
                .centerCrop()
                .placeholder(R.drawable.ic_person_grey_24dp)
                .error(R.drawable.ic_person_grey_24dp)
                .into(photoProfile);

        tpNumber.setText(dataItem.mainDataTpNo);
        tripDateDetails.setText(toFromDate);
        totalAllowance.setText(helper.currencyFormat(dataItem.mainDataTpAllowance.tpTotalTransferInIdr,"IDR "));
        totalAllowance.setSelected(true);

        TimelineView timelineView = findViewById(R.id.timeline);
        LinearLayout rightLayout = findViewById(R.id.right_layout);
        TextView startingCityDetails = findViewById(R.id.left_destination_city_name);
        TextView startingCityDate = findViewById(R.id.left_destination_date);

        timelineView.setMarker(getResources().getDrawable(R.drawable.ic_flight_depart));
        rightLayout.setVisibility(View.INVISIBLE);
        startingCityDetails.setText(dataItem.mainDataCityFrom);
        startingCityDate.setText(dataItem.mainDataDestinations.get(0).myTravelDestinationFrom);

        RecyclerView timelineRecyclerView = findViewById(R.id.approver_recycler_view_adapter_content_details_timeline);

        ArrayList<MyTravelDestinationsDataModel> listDestinationsData = dataItem.mainDataDestinations;

        timelineRecyclerView.setLayoutManager(getLinearLayoutManager(timelineRecyclerView));
        ProposalApproverListTimelineAdapter proposalApproverListTimelineAdapter = new ProposalApproverListTimelineAdapter();
        proposalApproverListTimelineAdapter.addValues(this, listDestinationsData);
        timelineRecyclerView.setAdapter(proposalApproverListTimelineAdapter);
        proposalApproverListTimelineAdapter.notifyDataSetChanged();

        RecyclerView objectivesRecyclerView = findViewById(R.id.approver_recycler_view_adapter_content_details_objectives);

        objectivesRecyclerView.setLayoutManager(getLinearLayoutManager(objectivesRecyclerView));
        ProposalApproverListObjectiveAdapter objectivesAdapter = new ProposalApproverListObjectiveAdapter();
        objectivesAdapter.addValues(this, listDestinationsData);
        objectivesRecyclerView.setAdapter(objectivesAdapter);
        objectivesAdapter.notifyDataSetChanged();

        RecyclerView outerExpensesRecyclerView = findViewById(R.id.approver_recycler_view_adapter_content_allowance_outer_expenses);

        ArrayList<TravelProposalDestinationDetailDataModel> outerExpensesListData = dataItem.mainDataTpDestinationDetail;

        outerExpensesRecyclerView.setLayoutManager(getLinearLayoutManager(outerExpensesRecyclerView));
        ProposalApproverListAllowanceOuterExpensesAdapter proposalApproverListAllowanceOuterExpensesAdapter = new ProposalApproverListAllowanceOuterExpensesAdapter();
        proposalApproverListAllowanceOuterExpensesAdapter.addValues(this, outerExpensesListData, listDestinationsData, dataItem.mainDataUsdExchangeRate, dataItem.mainDataJpyExchangeRate);
        outerExpensesRecyclerView.setAdapter(proposalApproverListAllowanceOuterExpensesAdapter);
        proposalApproverListAllowanceOuterExpensesAdapter.notifyDataSetChanged();

    }

    private LinearLayoutManager getLinearLayoutManager(RecyclerView rv) {
        return new LinearLayoutManager(rv.getContext(), LinearLayoutManager.VERTICAL, false);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case -1:
                onBackPressed();
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
