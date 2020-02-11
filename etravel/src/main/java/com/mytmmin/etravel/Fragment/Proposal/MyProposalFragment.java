package com.mytmmin.etravel.Fragment.Proposal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.mytmmin.etravel.Activity.Proposal.Approver.ProposalApproverMain;
import com.mytmmin.etravel.Activity.Proposal.History.ProposalHistoryMain;
import com.mytmmin.etravel.GlobalVariable;
import com.mytmmin.etravel.R;

public class MyProposalFragment extends Fragment implements View.OnClickListener {

    public MyProposalFragment() {
        // Required empty public constructor
    }


//    public static MyProposalFragment newInstance(String param1, String param2) {
//        MyProposalFragment fragment = new MyProposalFragment();
//        return fragment;
//    }

    private void startActivity(Class target, int requestCode){
        Intent i = new Intent(getActivity(), target);
        startActivityForResult(i, requestCode);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.main_travel_fragment_my_travel, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageButton buttonStatusCheck = view.findViewById(R.id.button_list_travel_approval);
        ImageButton buttonTravelApproval = view.findViewById(R.id.button_list_travel_history);

        buttonStatusCheck.setOnClickListener(this);
        buttonTravelApproval.setOnClickListener(this);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
//            case R.id.button_add_travel_proposal:
//                //TODO: go to create new proposal
//                Intent k = new Intent(getActivity(), SettlementApproverMain.class);
//                startActivityForResult(k, GlobalVariable.MYTRAVEL_MAIN_MYTRAVEL_FRAGMENT_LIST_HISTORY_APPROVAL_CODE);
//                break;
            case R.id.button_list_travel_approval:
                Intent i = new Intent(getActivity(), ProposalHistoryMain.class);
                startActivityForResult(i, GlobalVariable.PROPOSAL_HISTORY_REQUEST_MAIN_RESULT_CODE);
                break;
            case R.id.button_list_travel_history:
                Intent j = new Intent(getActivity(), ProposalApproverMain.class);
                startActivityForResult(j, GlobalVariable.PROPOSAL_APPROVER_REQUEST_MAIN_RESULT_CODE);
                break;
            default:
                break;
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getActivity();

        //handle on activity result
    }
}
