package com.mytmmin.etravel.Activity.Settlement.History;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.mytmmin.etravel.API.APIClient;
import com.mytmmin.etravel.API.MyTravelAPIInterface;
import com.mytmmin.etravel.Activity.Proposal.History.ProposalHistoryMain;
import com.mytmmin.etravel.Adapter.Settlement.History.SettlementHistoryListTripHistoryAdapter;
import com.mytmmin.etravel.DataModel.MyTravelMainDataDataModel;
import com.mytmmin.etravel.GlobalVariable;
import com.mytmmin.etravel.Helper;
import com.mytmmin.etravel.POJO.MyTravelMainDevPojo;
import com.mytmmin.etravel.R;
import com.omega_r.libs.omegarecyclerview.OmegaRecyclerView;
import com.omega_r.libs.omegarecyclerview.pagination.OnPageRequestListener;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SettlementHistoryMain extends AppCompatActivity implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener,
        SearchView.OnQueryTextListener, OnPageRequestListener, SettlementHistoryListTripHistoryAdapter.Callback {

    private Activity activity;
    private SearchView searchView;
    private SwipeRefreshLayout swipe;

    private SettlementHistoryListTripHistoryAdapter adapter;
    OmegaRecyclerView listHistoryTripRecyclerView;

    private int mCounter;
    private ArrayList<MyTravelMainDataDataModel> listData;

    private static final String TAG = ProposalHistoryMain.class.getSimpleName();

    private MyTravelAPIInterface settlementApiInterface;

    private static final int limit = 5;

    private int totalData=0;
    private int returnValue=-1;
    private int pages = 0;

    Helper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sh_activity_settlement_history_main);

        settlementApiInterface = APIClient.getClient().create(MyTravelAPIInterface.class);

        //init views
        initView();
    }

    private void initData(String functionname, final int page){

        swipe.setRefreshing(true);

        Call<MyTravelMainDevPojo> call = settlementApiInterface.getAllRequestHistory("09105014", "settlement", Integer.toString(page+1), Integer.toString(5));
        call.enqueue(new Callback<MyTravelMainDevPojo>() {
            @Override
            public void onResponse(@NonNull Call<MyTravelMainDevPojo> call, @NonNull Response<MyTravelMainDevPojo> response) {

                MyTravelMainDevPojo resource = response.body();

                if (resource!=null && resource.success){
                    listData = new ArrayList<>();
                    totalData = resource.totalData;
                    listData = resource.data;

                    for (int i=0; i<listData.size(); i++){
                        //sanitize money
                        listData.get(i).mainDataTsAllowance.setTsBalanceInIdr(helper.sanitizeMoneyHelper(listData.get(i).mainDataTsAllowance.tsBalanceInIdr, false));
                        listData.get(i).mainDataTsAllowance.setTsTotalDeductionInIdr(helper.sanitizeMoneyHelper(listData.get(i).mainDataTsAllowance.tsTotalDeductionInIdr, false));
                        listData.get(i).mainDataTsAllowance.tsTotalInIdr.setTsTotalProposal(helper.sanitizeMoneyHelper(listData.get(i).mainDataTsAllowance.tsTotalInIdr.tsTotalProposal, false));
                        listData.get(i).mainDataTsAllowance.tsTotalInIdr.setTsTotalSettlement(helper.sanitizeMoneyHelper(listData.get(i).mainDataTsAllowance.tsTotalInIdr.tsTotalSettlement, false));
                        listData.get(i).setMainDataUsdExchangeRate(helper.sanitizeMoneyHelper(listData.get(i).mainDataUsdExchangeRate, true));
                        listData.get(i).setMainDataJpyExchangeRate(helper.sanitizeMoneyHelper(listData.get(i).mainDataJpyExchangeRate, true));

                        //sanitize date
                        for (int j=0; j<listData.get(i).mainDataDestinations.size(); j++){
                            listData.get(i).mainDataDestinations.get(j).setMyTravelDestinationFrom(helper.sanitizeDateHelper(listData.get(i).mainDataDestinations.get(j).myTravelDestinationFrom));
                            listData.get(i).mainDataDestinations.get(j).setMyTravelDestinationUntil(helper.sanitizeDateHelper(listData.get(i).mainDataDestinations.get(j).myTravelDestinationUntil));
                        }

                        //sanitize allowance per item (karena ini settlement, auto ignore travel proposal data)
                        helper.sanitizeTsDetailPerItem(listData.get(i).mainDataTsAllowance.tsDirectAllowance.tsDirectDailyAllowance);
                        helper.sanitizeTsDetailPerItem(listData.get(i).mainDataTsAllowance.tsDirectAllowance.tsDirectPreparationAllowance);
                        helper.sanitizeTsDetailPerItem(listData.get(i).mainDataTsAllowance.tsDirectAllowance.tsDirectWinterAllowance);
                        helper.sanitizeTsDetailPerItem(listData.get(i).mainDataTsAllowance.tsSuspenseAllowance.tsSuspenseDomesticLandTransportAllowance);
                        helper.sanitizeTsDetailPerItem(listData.get(i).mainDataTsAllowance.tsSuspenseAllowance.tsSuspenseFiscalTaxesAllowance);
                        helper.sanitizeTsDetailPerItem(listData.get(i).mainDataTsAllowance.tsSuspenseAllowance.tsSuspenseHotelAllowance);
                        helper.sanitizeTsDetailPerItem(listData.get(i).mainDataTsAllowance.tsSuspenseAllowance.tsSuspenseMiscellaneousAllowance);
                        helper.sanitizeTsDetailPerItem(listData.get(i).mainDataTsAllowance.tsSuspenseAllowance.tsSuspenseOverseasLandTransportAllowance);

                        //sanitize allowance per item (karena ini settlement, auto ignore travel proposal data)
                        for (int j=0; j< listData.get(i).mainDataTsDestinationDetail.size(); j++){
                            helper.sanitizeTsDetailPerItem(listData.get(i).mainDataTsDestinationDetail.get(j).tsDestinationDetailDailyAllowance);
                            helper.sanitizeTsDetailPerItem(listData.get(i).mainDataTsDestinationDetail.get(j).tsDestinationDetailDomesticLandTransportAllowance);
                            helper.sanitizeTsDetailPerItem(listData.get(i).mainDataTsDestinationDetail.get(j).tsDestinationDetailFiscalTaxesAllowance);
                            helper.sanitizeTsDetailPerItem(listData.get(i).mainDataTsDestinationDetail.get(j).tsDestinationDetailHotelAllowance);
                            helper.sanitizeTsDetailPerItem(listData.get(i).mainDataTsDestinationDetail.get(j).tsDestinationDetailMiscellaneousAllowance);
                            helper.sanitizeTsDetailPerItem(listData.get(i).mainDataTsDestinationDetail.get(j).tsDestinationDetailOverseasLandTransportAllowance);
                            helper.sanitizeTsDetailPerItem(listData.get(i).mainDataTsDestinationDetail.get(j).tsDestinationDetailPreparationAllowance);
                            helper.sanitizeTsDetailPerItem(listData.get(i).mainDataTsDestinationDetail.get(j).tsDestinationDetailWinterAllowance);
                        }

                    }

                    adapter.addValues(activity, listData);
                    swipe.setRefreshing(false);
                    if(page == 0){
                        listHistoryTripRecyclerView.scrollToPosition(0);
                    }
                }
                else{
                    swipe.setRefreshing(false);
                    listHistoryTripRecyclerView.showErrorPagination();
                }


            }

            @Override
            public void onFailure(@NonNull Call<MyTravelMainDevPojo> call, @NonNull Throwable t) {
                call.cancel();

                swipe.setRefreshing(false);
                listHistoryTripRecyclerView.showErrorPagination();
            }
        });

    }

    @Override
    public void onRefresh() {
        if (searchView.isIconified()){
            refreshData();
        }
        else{
            searchView.setIconified(true);
            listHistoryTripRecyclerView.showProgressPagination();
            swipe.setRefreshing(false);
        }
    }

    private void initView(){
        activity = this;
        helper = new Helper(getApplicationContext());

        //init toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationIcon(R.drawable.ic_chevron_left_white_24dp);
        toolbar.setNavigationOnClickListener(this);

        swipe = findViewById(R.id.swipe_refresh);
        swipe.setOnRefreshListener(this);

        listHistoryTripRecyclerView = findViewById(R.id.recyclerview_list_history_trip);
        listHistoryTripRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        listHistoryTripRecyclerView.setPaginationCallback(this);

        adapter = new SettlementHistoryListTripHistoryAdapter();
        adapter.setCallback(this);
        listHistoryTripRecyclerView.setAdapter(adapter);
        listHistoryTripRecyclerView.showProgressPagination();

        swipe.post(new Runnable() {

            @Override
            public void run() {

                if(swipe != null) {
                    swipe.setRefreshing(true);
                }
                if(pages>0){
                    refreshData();
                }
            }
        });

    }

    //Pagination handler
    @Override
    public void onPageRequest(int page) {

        pages = page;

        if (pages == 0 || pages*limit < totalData){
            if (searchView != null){
                if (searchView.isIconified()){
                    mCounter++;
                    initData("on page request not null", pages);
                }
            }
            else{
                mCounter++;
                initData("on page request null", pages);
            }
        }

    }

    @Override
    public int getPagePreventionForEnd() {

        if (searchView != null && searchView.isIconified()){
            if (adapter.getItemCount()>0){
                returnValue = 0;
            }
            else{
                returnValue = -1;
            }
        }
        else{
            returnValue = -1;
        }

        return returnValue;
    }

    @Override
    public void onRetryClicked() {

        if (!searchView.isIconified()){
            searchView.setIconified(true);
            listHistoryTripRecyclerView.showProgressPagination();
        }

        refreshData();

    }

    private void refreshData(){
        listHistoryTripRecyclerView.invalidate();
        if (adapter.getItemCount()>0){
            adapter.clear();
        }
        listHistoryTripRecyclerView.setAdapter(adapter);
        listHistoryTripRecyclerView.showProgressPagination();
        initData("on refresh", 0);
    }

    //Override view hanlder

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case -1:
                //on toolbar back navigation pressed
                if (!searchView.isIconified()){
                    searchView.setIconified(true);
                    listHistoryTripRecyclerView.showProgressPagination();
                }
                else{
                    onBackPressed();
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (!searchView.isIconified()){
            searchView.setIconified(true);
            listHistoryTripRecyclerView.showProgressPagination();
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView = (SearchView) item.getActionView();

        ImageView closeBtn = searchView.findViewById(R.id.search_close_btn);
        closeBtn.setImageResource(R.drawable.ic_close_white_24dp);
        closeBtn.setEnabled(false);
        closeBtn.setImageDrawable(null);
        ImageView searchBtn = searchView.findViewById(R.id.search_button);
        searchBtn.setImageResource(R.drawable.ic_search_white_24dp);

        searchView.setQueryHint(getString(R.string.type_name));
        searchView.setIconifiedByDefault(true);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    //Search filter handler

    @Override
    public boolean onQueryTextSubmit(String query) {
        listHistoryTripRecyclerView.hidePagination();
        adapter.getFilter().filter(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        listHistoryTripRecyclerView.hidePagination();
        adapter.getFilter().filter(newText);
        return false;
    }

    //public function accessible from adapter

    public void startIntentFromAdapter (Class target, MyTravelMainDataDataModel dataItem, int resultCode){
        Intent requestDetails = new Intent(this, target);
        requestDetails.putExtra(GlobalVariable.TAG_OPEN_SETTLEMENT_HISTORY_REQUEST_DETAILS_ACTIVITY, dataItem);
        startActivityForResult(requestDetails, resultCode);
    }
    //should be always at the bottom, on activity result

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case GlobalVariable.SETTLEMENT_HISTORY_REQUEST_DETAILS_RESULT_CODE:
                if (resultCode == RESULT_CANCELED){
                }
                break;
            default:
                break;
        }
    }
}
