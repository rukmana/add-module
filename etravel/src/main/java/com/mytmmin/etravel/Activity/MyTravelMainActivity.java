package com.mytmmin.etravel.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.mytmmin.etravel.Fragment.Settlement.MySettlementFragment;
import com.mytmmin.etravel.Fragment.Proposal.MyProposalFragment;
import com.mytmmin.etravel.GlobalVariable;
import com.mytmmin.etravel.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MyTravelMainActivity extends AppCompatActivity implements View.OnClickListener {

    ViewPager viewPager;
    private de.hdodenhof.circleimageview.CircleImageView photoprofile;
    private TextView employeeName;
    private String username, photourl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_my_travel_main);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                username = null;
                photourl = null;
            }
            else {
                username = extras.getString(GlobalVariable.SERIALIZED_NAME_EMPLOYEE_NAME);
                photourl = extras.getString(GlobalVariable.SERIALIZED_NAME_PHOTO_URL);
            }
        } else {
            username = savedInstanceState.getString(GlobalVariable.SERIALIZED_NAME_EMPLOYEE_NAME);
            photourl = savedInstanceState.getString(GlobalVariable.SERIALIZED_NAME_PHOTO_URL);
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationIcon(R.drawable.ic_chevron_left_white_24dp);
        toolbar.setNavigationOnClickListener(this);

        ViewGroup tab = findViewById(R.id.tab);
        tab.addView(LayoutInflater.from(this).inflate(R.layout.layout_navigation_tab_distribute_evenly, tab, false));

        viewPager = findViewById(R.id.viewpager);
        SmartTabLayout viewPagerTab = findViewById(R.id.viewpagertab);

        final FragmentPagerItems pages = new FragmentPagerItems(this);
        pages.add(FragmentPagerItem.of(getString(R.string.my_travel), MyProposalFragment.class));
        pages.add(FragmentPagerItem.of(getString(R.string.my_settlement), MySettlementFragment.class));

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), pages);

        viewPager.setAdapter(adapter);
        viewPagerTab.setViewPager(viewPager);

        employeeName = findViewById(R.id.text_overall_balance_ammount);
        photoprofile = findViewById(R.id.image_profile_image);

        if(username==null && photourl==null){
            employeeName.setText("Guest");
            photoprofile.setImageResource(getResources().
                    getIdentifier("drawable/ic_person_white_24dp", null, getPackageName()));
        }
        else{
            employeeName.setText(username);
            photoprofile.setImageResource(getResources().
                    getIdentifier(photourl, null, getPackageName()));
        }

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case -1:
                FirebaseAuth.getInstance().signOut();
                Intent resultIntent = new Intent();
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
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
