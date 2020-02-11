package com.mytmmin.etravel.Fragment.Settlement;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.mytmmin.etravel.Activity.Settlement.Approver.SettlementApproverMain;
import com.mytmmin.etravel.Activity.Settlement.History.SettlementHistoryMain;
import com.mytmmin.etravel.GlobalVariable;
import com.mytmmin.etravel.R;

public class MySettlementFragment extends Fragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "key";

//    private String mParam2;

    public MySettlementFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static MySettlementFragment newInstance(String param1) {
        MySettlementFragment fragment = new MySettlementFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            String mParam1 = getArguments().getString(ARG_PARAM1);
        }
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.main_settlement_fragment_my_settlement, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageButton buttonMySettlement = view.findViewById(R.id.button_list_settlement_approval);
        ImageButton buttonSettlementHistory = view.findViewById(R.id.button_list_settlement_history);

        buttonMySettlement.setOnClickListener(this);
        buttonSettlementHistory.setOnClickListener(this);
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
            case R.id.button_list_settlement_history:
                Intent i = new Intent(getActivity(), SettlementHistoryMain.class);
                startActivityForResult(i, GlobalVariable.SETTLEMENT_HISTORY_REQUEST_MAIN_RESULT_CODE);
                break;
            case R.id.button_list_settlement_approval:
                Intent j = new Intent(getActivity(), SettlementApproverMain.class);
                startActivityForResult(j, GlobalVariable.SETTLEMENT_APPROVER_REQUEST_MAIN_RESULT_CODE);
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
