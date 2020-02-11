package com.mytmmin.etravel.Fragment.Settlement;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.mytmmin.etravel.Adapter.Settlement.Approver.SettlementApproverDetailRequestApproverAdapter;
import com.mytmmin.etravel.DataModel.MyTravelMainDataDataModel;
import com.mytmmin.etravel.DataModel.Settlement.TravelSettlementAllowanceDetailPerItemDataModel;
import com.mytmmin.etravel.Helper;
import com.mytmmin.etravel.R;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.omega_r.libs.omegarecyclerview.OmegaRecyclerView;

import java.util.ArrayList;

public class SettlementApproverRequestDetailsFragment extends Fragment {

    private static final String ARG_PARAM1 = "key";

    private MyTravelMainDataDataModel destinationsDetail;

    private Helper helper;

    public interface RecyclerViewClickListener {

        void onViewReceiptClicked(View view, int position);

    }

//    public interface ActivityClickListener {
//
//        void onQuestionMarkClicked(View view, int position, int type);
//
//    }


//    private ActivityClickListener mListener;

    public SettlementApproverRequestDetailsFragment() {
        // Required empty public constructor
    }

    public static SettlementApproverRequestDetailsFragment newInstance(String param1, String param2) {
        SettlementApproverRequestDetailsFragment fragment = new SettlementApproverRequestDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            destinationsDetail = (MyTravelMainDataDataModel) getArguments().getSerializable(ARG_PARAM1);
        }

        helper = new Helper(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.sa_fragment_settlement_request_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int position = FragmentPagerItem.getPosition(getArguments());

        RecyclerViewClickListener rvListener = new RecyclerViewClickListener() {
            @Override
            public void onViewReceiptClicked(View view, int position) {
                showReceiptPopUp();
            }

        };

        TextView dayToFromPerDestinations = view.findViewById(R.id.text_details_per_destinations_total_day);
        dayToFromPerDestinations.setText(destinationsDetail.mainDataDestinations.get(position).myTravelDestinationFrom);

        TextView objectivesPerDestinations = view.findViewById(R.id.text_details_per_destinations_objectives);
        objectivesPerDestinations.setText("Objectives: "+destinationsDetail.mainDataDestinations.get(position).myTravelDestinationObjectives);

        ArrayList<TravelSettlementAllowanceDetailPerItemDataModel> detailPerItem = new ArrayList<>();
        ArrayList<Integer> typeDetailPerItem = new ArrayList<>();

        try{
            if (helper.showTsAllowanceProposalDetailPerItemValue(destinationsDetail.mainDataTsDestinationDetail.get(position).tsDestinationDetailWinterAllowance)!=null &&
                    helper.showTsAllowanceSettlementDetailPerItemValue(destinationsDetail.mainDataTsDestinationDetail.get(position).tsDestinationDetailWinterAllowance)!=null){
                detailPerItem.add(destinationsDetail.mainDataTsDestinationDetail.get(position).tsDestinationDetailWinterAllowance);
                typeDetailPerItem.add(1);
            }
            if (helper.showTsAllowanceProposalDetailPerItemValue(destinationsDetail.mainDataTsDestinationDetail.get(position).tsDestinationDetailPreparationAllowance)!=null &&
                    helper.showTsAllowanceSettlementDetailPerItemValue(destinationsDetail.mainDataTsDestinationDetail.get(position).tsDestinationDetailPreparationAllowance)!=null){
                detailPerItem.add(destinationsDetail.mainDataTsDestinationDetail.get(position).tsDestinationDetailPreparationAllowance);
                typeDetailPerItem.add(2);
            }
            if (helper.showTsAllowanceProposalDetailPerItemValue(destinationsDetail.mainDataTsDestinationDetail.get(position).tsDestinationDetailOverseasLandTransportAllowance)!=null &&
                    helper.showTsAllowanceSettlementDetailPerItemValue(destinationsDetail.mainDataTsDestinationDetail.get(position).tsDestinationDetailOverseasLandTransportAllowance)!=null){
                detailPerItem.add(destinationsDetail.mainDataTsDestinationDetail.get(position).tsDestinationDetailOverseasLandTransportAllowance);
                typeDetailPerItem.add(3);
            }
            if (helper.showTsAllowanceProposalDetailPerItemValue(destinationsDetail.mainDataTsDestinationDetail.get(position).tsDestinationDetailMiscellaneousAllowance)!=null &&
                    helper.showTsAllowanceSettlementDetailPerItemValue(destinationsDetail.mainDataTsDestinationDetail.get(position).tsDestinationDetailMiscellaneousAllowance)!=null){
                detailPerItem.add(destinationsDetail.mainDataTsDestinationDetail.get(position).tsDestinationDetailMiscellaneousAllowance);
                typeDetailPerItem.add(4);
            }
            if (helper.showTsAllowanceProposalDetailPerItemValue(destinationsDetail.mainDataTsDestinationDetail.get(position).tsDestinationDetailHotelAllowance)!=null &&
                    helper.showTsAllowanceSettlementDetailPerItemValue(destinationsDetail.mainDataTsDestinationDetail.get(position).tsDestinationDetailHotelAllowance)!=null){
                detailPerItem.add(destinationsDetail.mainDataTsDestinationDetail.get(position).tsDestinationDetailHotelAllowance);
                typeDetailPerItem.add(5);
            }
            if (helper.showTsAllowanceProposalDetailPerItemValue(destinationsDetail.mainDataTsDestinationDetail.get(position).tsDestinationDetailFiscalTaxesAllowance)!=null &&
                    helper.showTsAllowanceSettlementDetailPerItemValue(destinationsDetail.mainDataTsDestinationDetail.get(position).tsDestinationDetailFiscalTaxesAllowance)!=null){
                detailPerItem.add(destinationsDetail.mainDataTsDestinationDetail.get(position).tsDestinationDetailFiscalTaxesAllowance);
                typeDetailPerItem.add(6);
            }
            if (helper.showTsAllowanceProposalDetailPerItemValue(destinationsDetail.mainDataTsDestinationDetail.get(position).tsDestinationDetailDomesticLandTransportAllowance)!=null &&
                    helper.showTsAllowanceSettlementDetailPerItemValue(destinationsDetail.mainDataTsDestinationDetail.get(position).tsDestinationDetailDomesticLandTransportAllowance)!=null){
                detailPerItem.add(destinationsDetail.mainDataTsDestinationDetail.get(position).tsDestinationDetailDomesticLandTransportAllowance);
                typeDetailPerItem.add(7);
            }
            if (helper.showTsAllowanceProposalDetailPerItemValue(destinationsDetail.mainDataTsDestinationDetail.get(position).tsDestinationDetailDailyAllowance)!=null &&
                    helper.showTsAllowanceSettlementDetailPerItemValue(destinationsDetail.mainDataTsDestinationDetail.get(position).tsDestinationDetailDailyAllowance)!=null){
                detailPerItem.add(destinationsDetail.mainDataTsDestinationDetail.get(position).tsDestinationDetailDailyAllowance);
                typeDetailPerItem.add(8);
            }
        }catch (Exception e){
            Toast.makeText(getContext(), "Settlement approver request detail fragment - "+e.getMessage(), Toast.LENGTH_LONG).show();
        }


        SettlementApproverDetailRequestApproverAdapter adapter = new SettlementApproverDetailRequestApproverAdapter();
        OmegaRecyclerView recyclerView = view.findViewById(R.id.recyclerview_details_settlement_expenses);
        recyclerView.setLayoutManager(getLinearLayoutManager(recyclerView));
        adapter.addValues(rvListener, getActivity(), detailPerItem, typeDetailPerItem);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    //    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void showReceiptPopUp(){

        //getphotourl
        String photoUrl = "drawable/fake_receipt";

        //show popup
        View popupView = LayoutInflater.from(getActivity()).inflate(R.layout.sa_dialog_custom_receipt_dialog, null);
        final PopupWindow popupWindow = new PopupWindow(popupView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT, true);

        Button closeDialog = popupView.findViewById(R.id.btn_okkay);
        ImageView receipt = popupView.findViewById(R.id.image_receipt_settlement_details);

        receipt.setImageResource(getResources().
                getIdentifier(photoUrl, null, getActivity().getPackageName()));

        closeDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Do something
                popupWindow.dismiss();
            }
        });

        popupWindow.showAsDropDown(popupView, 0, 0);

        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });

        //dim the screen
        View container = popupWindow.getContentView().getRootView();
        if(container != null) {
            WindowManager wm = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
            WindowManager.LayoutParams p = (WindowManager.LayoutParams)container.getLayoutParams();
            p.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
            p.dimAmount = 0.5f;
            if(wm != null) {
                wm.updateViewLayout(container, p);
            }
        }

    }

    private LinearLayoutManager getLinearLayoutManager(RecyclerView rv) {
        return new LinearLayoutManager(rv.getContext(), LinearLayoutManager.VERTICAL, false);
    }
}
