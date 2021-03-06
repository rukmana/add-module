package com.mytmmin.etravel.Adapter.Settlement.History;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mytmmin.etravel.Activity.Settlement.History.SettlementHistoryMain;
import com.mytmmin.etravel.Activity.Settlement.History.SettlementHistoryRequestDetails;
import com.mytmmin.etravel.DataModel.MyTravelMainDataDataModel;
import com.mytmmin.etravel.Filter.Settlement.SettlementHistoryFilterHelper;
import com.mytmmin.etravel.GlideApp;
import com.mytmmin.etravel.Helper;
import com.mytmmin.etravel.R;
import com.mytmmin.etravel.ViewHolder.Settlement.History.SettlementHistoryListTripHistoryViewHolder;
import com.omega_r.libs.omegarecyclerview.OmegaRecyclerView;
import com.omega_r.libs.omegarecyclerview.pagination.PaginationViewCreator;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static com.mytmmin.etravel.GlobalVariable.SETTLEMENT_HISTORY_REQUEST_DETAILS_RESULT_CODE;

public class SettlementHistoryListTripHistoryAdapter extends OmegaRecyclerView.Adapter<SettlementHistoryListTripHistoryViewHolder> implements Filterable, PaginationViewCreator {

    private Activity activity;
    private ArrayList<MyTravelMainDataDataModel> mFeedList = new ArrayList<>();
    private ArrayList<MyTravelMainDataDataModel> currentList;
    private Context mContext;
    private SettlementHistoryFilterHelper proposalHistoryFilterHelper;
    private int counter=0;
    private Helper helper;

    @Nullable
    private Callback mCallback;

    public SettlementHistoryListTripHistoryAdapter() {
        setHasStableIds(true);
    }

    public SettlementHistoryListTripHistoryAdapter(Activity activity, ArrayList<MyTravelMainDataDataModel> item) {
//        this.context = context;
        this.activity = activity;
        this.mFeedList = item;
        this.currentList = item;
//        this.context = context;
        notifyItemInserted(mFeedList.size() - item.size());
    }

    @Override
    public int getItemCount() {
        return (mFeedList!=null? mFeedList.size():0);
    }

    public void addValues(Activity activity, ArrayList<MyTravelMainDataDataModel> list) {

        if (this.activity == null)
            this.activity = activity;

        helper = new Helper(activity);
        currentList = new ArrayList<>();

        for (int i=0; i<list.size(); i++){
            mFeedList.add(list.get(i));
            currentList.add(list.get(i));
        }

        notifyItemInserted(mFeedList.size() - list.size());
//        notifyDataSetChanged();
    }

    public void clear() {
//        int size = mFeedList.size();
        mFeedList.clear();
        currentList.clear();
        notifyDataSetChanged();
//        notifyItemRangeRemoved(0, size);
    }

    @Override
    @NonNull
    public SettlementHistoryListTripHistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater mLayoutInflater = LayoutInflater.from(mContext);
        View view;

        view = mLayoutInflater.inflate(R.layout.sh_cardview_list_history_trip, parent, false);

        return new SettlementHistoryListTripHistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SettlementHistoryListTripHistoryViewHolder holder, int position) {

        final MyTravelMainDataDataModel dataItem = mFeedList.get(position);

        long diff = helper.calculateDateDiff(dataItem.mainDataDestinations.get(0).myTravelDestinationFrom, dataItem.mainDataDestinations.get(dataItem.mainDataDestinations.size()-1).myTravelDestinationUntil);

        GlideApp.with(activity)
                .load(dataItem.mainDataPhotoUrl)
                .override(100,100)
                .centerCrop()
                .placeholder(R.drawable.ic_person_grey_24dp)
                .error(R.drawable.ic_person_grey_24dp)
                .into(holder.profileImage);

        holder.employeeName.setText(dataItem.mainDataEmployeeName);
        holder.employeeDivision.setText(dataItem.mainDataDivisionTitle);
        holder.employeeRegNumber.setText(dataItem.mainDataNoreg);
        holder.totalExpenses.setText(helper.currencyFormat(dataItem.mainDataTsAllowance.tsTotalInIdr.tsTotalSettlement, "IDR "));
        holder.totalAllocation.setText(helper.currencyFormat(dataItem.mainDataTsAllowance.tsTotalInIdr.tsTotalProposal, "IDR "));
        if (diff>0){
            holder.daysCount.setText(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)+"");
        }
        else{
            holder.daysCount.setText(0+"");
        }
        if (dataItem.mainDataDestinations.size()>1){
            holder.travelDestinationCity.setText(R.string.multiple_destinations);
        }
        else{
            holder.travelDestinationCity.setText(dataItem.mainDataDestinations.get(0).myTravelDestinationCountryName);
        }

        holder.travelType.setText(dataItem.mainDataBusinessTrip);

        holder.travelEndTrip.setText(dataItem.mainDataDestinations.get(dataItem.mainDataDestinations.size()-1).myTravelDestinationUntil);
        holder.tpNumber.setText(dataItem.mainDataTpNo);

        holder.openRequestDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter == 0){
                    if (mContext instanceof SettlementHistoryMain){
                        ((SettlementHistoryMain)mContext).startIntentFromAdapter(SettlementHistoryRequestDetails.class, dataItem, SETTLEMENT_HISTORY_REQUEST_DETAILS_RESULT_CODE);
                    }
                }
            }
        });

        holder.listApproverRecyclerView.setLayoutManager(getLinearLayoutManager());
        SettlementHistoryListTripHistoryApproverAdapter innerAdapter = new SettlementHistoryListTripHistoryApproverAdapter();
        innerAdapter.addValues(activity, dataItem.mainDataApprovals);
        holder.listApproverRecyclerView.setAdapter(innerAdapter);
        innerAdapter.notifyDataSetChanged();

    }

    @Override
    public boolean isDividerAllowedBelow(int position) {
        return super.isDividerAllowedBelow(position) && position % 2 == 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public interface Callback {
        void onRetryClicked();
    }

    //Filter handler
    @Override
    public Filter getFilter() {
        if(proposalHistoryFilterHelper ==null)
        {
            proposalHistoryFilterHelper =new SettlementHistoryFilterHelper(currentList,this,activity);
        }

        return proposalHistoryFilterHelper;
    }

    public void refresh(){
        notifyDataSetChanged();
    }

    public void setFilteredData(ArrayList<MyTravelMainDataDataModel> filteredData) {
//        this.mFeedList.clear();
        this.mFeedList=filteredData;
    }

    //Pagination handler
    @Nullable
    @Override
    public View createPaginationView(ViewGroup parent, LayoutInflater inflater) {
        return inflater.inflate(R.layout.item_pagination_progress, parent, false);
    }

    @Nullable
    @Override
    public View createPaginationErrorView(ViewGroup parent, LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.item_pagination_error_loading, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCallback != null) {
                    mCallback.onRetryClicked();
                }
            }
        });
        return view;
    }

    public int getCounter(){
        return counter;
    }

    public void setCallback(@Nullable Callback callback) {
        mCallback = callback;
    }

    private LinearLayoutManager getLinearLayoutManager() {
        return new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
    }
}
