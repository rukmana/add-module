package com.mytmmin.etravel.Adapter.Settlement.Approver;

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

import com.mytmmin.etravel.Activity.Settlement.Approver.SettlementApproverMain;
import com.mytmmin.etravel.Activity.Settlement.Approver.SettlementApproverRequestDetails;
import com.mytmmin.etravel.DataModel.MyTravelListApproveRejectDataModel;
import com.mytmmin.etravel.DataModel.MyTravelMainDataDataModel;
import com.mytmmin.etravel.Filter.Settlement.SettlementApproverFilterHelper;
import com.mytmmin.etravel.GlideApp;
import com.mytmmin.etravel.Helper;
import com.mytmmin.etravel.R;
import com.mytmmin.etravel.ViewHolder.Settlement.Approver.SettlementApproverListSettlementApprovalViewHolder;
import com.omega_r.libs.omegarecyclerview.OmegaRecyclerView;
import com.omega_r.libs.omegarecyclerview.pagination.PaginationViewCreator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import static com.mytmmin.etravel.GlobalVariable.SETTLEMENT_APPROVER_REQUEST_DETAILS_RESULT_CODE;

public class SettlementApproverListSettlementApprovalAdapter extends OmegaRecyclerView.Adapter<SettlementApproverListSettlementApprovalViewHolder> implements Filterable, PaginationViewCreator {

    private Activity activity;
    private ArrayList<MyTravelMainDataDataModel> mFeedList = new ArrayList<>();
    private ArrayList<MyTravelMainDataDataModel> currentList;
    private Context mContext;
    private SettlementApproverFilterHelper travelApproverFilterHelper;
    private int counter=0;
    public int totalDataSize = 0;
    public ArrayList <MyTravelListApproveRejectDataModel> listApproveReject = new ArrayList<>();
    private Helper helper;

    @Nullable
    private Callback mCallback;

    public SettlementApproverListSettlementApprovalAdapter() {
        setHasStableIds(true);
    }

    public SettlementApproverListSettlementApprovalAdapter(Activity activity, ArrayList<MyTravelMainDataDataModel> item) {
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
    public SettlementApproverListSettlementApprovalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater mLayoutInflater = LayoutInflater.from(mContext);
        View view;

        view = mLayoutInflater.inflate(R.layout.sa_cardview_list_settlement_approval, parent, false);

        return new SettlementApproverListSettlementApprovalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SettlementApproverListSettlementApprovalViewHolder holder, final int position) {

        final MyTravelMainDataDataModel dataItem = mFeedList.get(position);

        long diff = helper.calculateDateDiff(dataItem.mainDataDestinations.get(0).myTravelDestinationFrom, dataItem.mainDataDestinations.get(dataItem.mainDataDestinations.size()-1).myTravelDestinationUntil);

//        holder.profileImage.setImageResource(activity.getResources().
//        getIdentifier("drawable/ic_person_grey_24dp", null, activity.getPackageName()));
        holder.profileImage.setBorderColor(activity.getResources().getColor(R.color.white));
        holder.employeeName.setText(dataItem.mainDataEmployeeName);
        holder.employeeDivision.setText(dataItem.mainDataDivisionTitle);
        holder.employeeRegNumber.setText(dataItem.mainDataNoreg);
        if (dataItem.mainDataDestinations.size()>1){
            holder.travelDestinationCity.setText(R.string.multiple_destinations);
        }
        else{
            holder.travelDestinationCity.setText(dataItem.mainDataDestinations.get(0).myTravelDestinationCountryName);
        }
        holder.travelType.setText(dataItem.mainDataBusinessTrip);

        holder.travelEndTrip.setText(dataItem.mainDataDestinations.get(0).myTravelDestinationFrom+" - "+dataItem.mainDataDestinations.get(dataItem.mainDataDestinations.size()-1).myTravelDestinationUntil);
        if (diff>0){
            holder.travelTotalDays.setText(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)+"");
        }
        else{
            holder.travelTotalDays.setText(0+"");
        }
        holder.travelTotalExpenses.setText(helper.currencyFormat(dataItem.mainDataTsAllowance.tsTotalInIdr.tsTotalSettlement, "IDR "));
        holder.travelTotalAllocated.setText(helper.currencyFormat(dataItem.mainDataTsAllowance.tsTotalInIdr.tsTotalProposal, "IDR "));
        holder.tpNumber.setText(dataItem.mainDataTpNo);

        for (int i=0; i<listApproveReject.size(); i++){
            if (listApproveReject.get(i).approveRejectDraftNumber.contains(dataItem.mainDataDraftNumber)){
                dataItem.setIsChecked(1);
            }
        }

        if (dataItem.isChecked > 0) {
            holder.isChecked.setChecked(true);
            holder.layoutCardView.setBackground(mContext.getResources().getDrawable(R.drawable.custom_cardview_selected_button));
        }
        else{
            holder.isChecked.setChecked(false);
            holder.layoutCardView.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        }

        GlideApp.with(activity)
                .load(dataItem.mainDataPhotoUrl)
                .override(100,100)
                .centerCrop()
                .placeholder(R.drawable.ic_arrow_downward_green_24dp)
                .error(R.drawable.ic_arrow_upward_primary_24dp)
                .into(holder.profileImage);

        holder.isChecked.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(holder.isChecked.isChecked()){
                    counter++;
                    dataItem.setIsChecked(1);
                    holder.isChecked.setChecked(true);

                    listApproveReject.add(new MyTravelListApproveRejectDataModel(Integer.toString(position), dataItem.mainDataDraftNumber));
                }
                else{
                    counter--;
                    dataItem.setIsChecked(0);
                    holder.isChecked.setChecked(false);

                    for(Iterator<MyTravelListApproveRejectDataModel> it = listApproveReject.iterator(); it.hasNext();) {
                        MyTravelListApproveRejectDataModel s = it.next();
                        if(s.approveRejectDraftNumber.contains(dataItem.mainDataDraftNumber)) {
                            it.remove();
                        }
                    }
                }

                changeGlobalCheckBox();
                notifyDataSetChanged();
            }
        });

        holder.layoutCardView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (counter>0){
                    if(dataItem.isChecked < 1){
                        counter++;
                        dataItem.setIsChecked(1);
                        holder.isChecked.setChecked(true);
                        v.setBackgroundColor(mContext.getResources().getColor(R.color.colorAccent_15));

                        listApproveReject.add(new MyTravelListApproveRejectDataModel(Integer.toString(position), dataItem.mainDataDraftNumber));
                    }
                    else{
                        counter--;
                        dataItem.setIsChecked(0);
                        holder.isChecked.setChecked(false);
                        v.setBackgroundColor(mContext.getResources().getColor(R.color.white));

                        for(Iterator<MyTravelListApproveRejectDataModel> it = listApproveReject.iterator(); it.hasNext();) {
                            MyTravelListApproveRejectDataModel s = it.next();
                            if(s.approveRejectDraftNumber.contains(dataItem.mainDataDraftNumber)) {
                                it.remove();
                            }
                        }
                    }

                    changeGlobalCheckBox();
                    notifyDataSetChanged();
                }
                else{
                }

            }
        });

        holder.layoutCardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if (counter<1){
                    counter++;
                    dataItem.setIsChecked(1);
                    holder.isChecked.setChecked(true);
                    v.setBackgroundColor(mContext.getResources().getColor(R.color.colorAccent_15));

                    listApproveReject.add(new MyTravelListApproveRejectDataModel(Integer.toString(position), dataItem.mainDataDraftNumber));
                    changeGlobalCheckBox();
                    notifyDataSetChanged();

                    return true;
                }
                else{
                    return false;
                }

            }
        });

        holder.openRequestDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter == 0){
                    if (mContext instanceof SettlementApproverMain){
                        ((SettlementApproverMain)mContext).startIntentFromAdapter(SettlementApproverRequestDetails.class, dataItem, SETTLEMENT_APPROVER_REQUEST_DETAILS_RESULT_CODE);
                    }
                }
            }
        });

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
        if(travelApproverFilterHelper ==null)
        {
            travelApproverFilterHelper =new SettlementApproverFilterHelper(currentList,this,activity);
        }

        return travelApproverFilterHelper;
    }

    public void refresh(){
        notifyDataSetChanged();
    }

    public void setFilteredData(ArrayList<MyTravelMainDataDataModel> filteredData) {
//        this.mFeedList.clear();
        this.mFeedList=filteredData;
    }

    //Checkboxes handler
    public void setAllChecked (boolean globalState){

        if (globalState){
            for (int i=0; i<mFeedList.size();i++){
                if (mFeedList.get(i).isChecked < 1) {
                    mFeedList.get(i).setIsChecked(1);
                }
            }
            counter = mFeedList.size();
        }
        else{
            for (int i=0; i<mFeedList.size();i++){
                if (mFeedList.get(i).isChecked > 0) {
                    mFeedList.get(i).setIsChecked(0);
                }
            }
            counter = 0;
            listApproveReject.clear();
        }

        notifyDataSetChanged();
    }

    private void changeGlobalCheckBox(){
        if (mContext instanceof SettlementApproverMain){
            ((SettlementApproverMain)mContext).setAllChecked(counter==mFeedList.size());
        }
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

    public void removeValues (int position){
        mFeedList.remove(position);
        currentList.remove(position);
    }
}
