package com.mytmmin.etravel.Activity.Settlement.History;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.mytmmin.etravel.DataModel.MyTravelMainDataDataModel;
import com.mytmmin.etravel.Fragment.Settlement.SettlementApproverRequestDetailsFragment;
import com.mytmmin.etravel.Helper;
import com.mytmmin.etravel.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.Bundler;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import static com.mytmmin.etravel.GlobalVariable.TAG_OPEN_SETTLEMENT_HISTORY_REQUEST_DETAILS_ACTIVITY;

public class SettlementHistoryRequestDetails  extends AppCompatActivity implements View.OnClickListener {

    ViewPager viewPager;

    ImageView buttonLeft, buttonRight, questionMark;

    FragmentPagerItemAdapter adapter;

    MyTravelMainDataDataModel dataItem;

    private Helper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sh_activity_history_request_details);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                dataItem = null;
            }
            else {
                dataItem = (MyTravelMainDataDataModel) extras.getSerializable(TAG_OPEN_SETTLEMENT_HISTORY_REQUEST_DETAILS_ACTIVITY);
            }
        } else {
            dataItem = (MyTravelMainDataDataModel) savedInstanceState.getSerializable(TAG_OPEN_SETTLEMENT_HISTORY_REQUEST_DETAILS_ACTIVITY);
        }

        helper= new Helper(getApplicationContext());

        //init toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationIcon(R.drawable.ic_chevron_left_white_24dp);
        toolbar.setNavigationOnClickListener(this);

        TextView totalExpenses, totalAllocation, totalBalance, statusDesc;
        totalExpenses = findViewById(R.id.text_settlement_expenses_detail);
        totalAllocation = findViewById(R.id.text_settlement_allocation_detail);
        totalBalance = findViewById(R.id.text_overall_balance_ammount);
        statusDesc = findViewById(R.id.text_status_settlement_approval);

        totalExpenses.setText(helper.currencyFormat(dataItem.mainDataTsAllowance.tsTotalInIdr.tsTotalSettlement, "IDR "));
        totalAllocation.setText(helper.currencyFormat(dataItem.mainDataTsAllowance.tsTotalInIdr.tsTotalProposal, "IDR "));
        if(Double.parseDouble(dataItem.mainDataTsAllowance.tsTotalInIdr.tsTotalProposal) < Double.parseDouble(dataItem.mainDataTsAllowance.tsTotalInIdr.tsTotalSettlement)){
            totalBalance.setText("- "+helper.currencyFormat(dataItem.mainDataTsAllowance.tsBalanceInIdr, "IDR "));
        }
        else{
            totalBalance.setText(helper.currencyFormat(dataItem.mainDataTsAllowance.tsBalanceInIdr, "IDR "));
        }
        statusDesc.setText(dataItem.mainDataStatusDesc);

        ViewGroup tab = findViewById(R.id.tab);
        tab.addView(LayoutInflater.from(this).inflate(R.layout.layout_navigation_tab_mid_only, tab, false));

        viewPager = findViewById(R.id.viewpager);
        SmartTabLayout viewPagerTab = findViewById(R.id.viewpagertab_center);

        FragmentPagerItems pages = new FragmentPagerItems(this);
        for(int i=0; i<dataItem.mainDataDestinations.size(); i++){
            pages.add(FragmentPagerItem.of(dataItem.mainDataDestinations.get(i).myTravelDestinationCountryName, SettlementApproverRequestDetailsFragment.class, new Bundler().putSerializable("key", dataItem).get()));
        }

        adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), pages);

        viewPager.setAdapter(adapter);
        viewPagerTab.setViewPager(viewPager);
        viewPagerTab.setOnPageChangeListener(mPageChangeListener);

        buttonLeft = findViewById(R.id.button_left);
        buttonRight = findViewById(R.id.button_right);
        questionMark = findViewById(R.id.btn_settlement_question_mark);

        questionMark.setOnClickListener(this);
        buttonRight.setOnClickListener(this);
        buttonLeft.setOnClickListener(this);

        if (adapter.getCount() == 1){
            buttonRight.setVisibility(View.INVISIBLE);
            buttonRight.setClickable(false);
        }

        buttonLeft.setVisibility(View.INVISIBLE);
        buttonLeft.setClickable(false);


    }

    private final ViewPager.OnPageChangeListener mPageChangeListener =

            new ViewPager.SimpleOnPageChangeListener() {

                @Override
                public void onPageSelected(int position) {

                    Fragment page = adapter.getPage(position);
                    if (page == null) {
                        //                        showToast("page is null");
                        return;
                    }

                    switch (adapter.getCount()){
                        case 1:
                            buttonLeft.setVisibility(View.INVISIBLE);
                            buttonRight.setVisibility(View.INVISIBLE);
                            buttonLeft.setClickable(false);
                            buttonRight.setClickable(false);
                            break;
                        case 2:
                            if(position == 0){
                                buttonLeft.setVisibility(View.INVISIBLE);
                                buttonRight.setVisibility(View.VISIBLE);
                                buttonLeft.setClickable(false);
                                buttonRight.setClickable(true);
                            }
                            else{
                                buttonLeft.setVisibility(View.VISIBLE);
                                buttonRight.setVisibility(View.INVISIBLE);
                                buttonLeft.setClickable(true);
                                buttonRight.setClickable(false);
                            }
                            break;
                        default:
                            if (position == 0){
                                buttonLeft.setVisibility(View.INVISIBLE);
                                buttonLeft.setClickable(false);
                            }
                            else if (position == (adapter.getCount()-1)){
                                buttonRight.setVisibility(View.INVISIBLE);
                                buttonRight.setClickable(false);
                            }
                            else{
                                buttonLeft.setVisibility(View.VISIBLE);
                                buttonRight.setVisibility(View.VISIBLE);
                                buttonLeft.setClickable(true);
                                buttonRight.setClickable(true);
                            }
                            break;
                    }

                }
            };

    private void showTooltip(int type){

        //show popup
        View popupView = LayoutInflater.from(this).inflate(R.layout.sa_dialog_custom_returning_funds_dialog, null);
        final PopupWindow popupWindow = new PopupWindow(popupView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT, true);

        Button closeDialog = popupView.findViewById(R.id.btn_okkay);

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
            WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
            WindowManager.LayoutParams p = (WindowManager.LayoutParams)container.getLayoutParams();
            p.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
            p.dimAmount = 0.5f;
            if(wm != null) {
                wm.updateViewLayout(container, p);
            }
        }

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case -1:
                onBackPressed();
                break;
            case R.id.button_left:
                viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
                break;
            case R.id.button_right:
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                break;
            case R.id.btn_settlement_question_mark:
                //show tooltip
                showTooltip(1);
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
