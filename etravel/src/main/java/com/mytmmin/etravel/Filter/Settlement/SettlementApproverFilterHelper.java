package com.mytmmin.etravel.Filter.Settlement;

import android.content.Context;
import android.util.Log;
import android.widget.Filter;

import com.mytmmin.etravel.Adapter.Settlement.Approver.SettlementApproverListSettlementApprovalAdapter;
import com.mytmmin.etravel.DataModel.MyTravelMainDataDataModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SettlementApproverFilterHelper extends Filter {
    private ArrayList<MyTravelMainDataDataModel> currentList;
    private SettlementApproverListSettlementApprovalAdapter adapter;
    private Context c;

    public SettlementApproverFilterHelper(ArrayList<MyTravelMainDataDataModel> currentList, SettlementApproverListSettlementApprovalAdapter adapter, Context c) {
        this.currentList = currentList;
        this.adapter = adapter;
        this.c=c;
    }
    /*
    - Perform actual filtering.
     */
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults filterResults=new FilterResults();

        if(constraint != null && constraint.length()>0)
        {
            //CHANGE TO UPPER
            constraint=constraint.toString().toUpperCase();

            //HOLD FILTERS WE FIND
            ArrayList<MyTravelMainDataDataModel> foundFilters=new ArrayList<>();

            MyTravelMainDataDataModel data;

            //ITERATE CURRENT LIST
            for (int i=0;i<currentList.size();i++)
            {
                data = currentList.get(i);

                //SEARCH
                if(data.mainDataEmployeeName.toUpperCase().contains(constraint) )
                {
                    //ADD IF FOUND
                    foundFilters.add(data);
                }

                for (int j=0;j<data.mainDataDestinations.size();j++){
                    if(data.mainDataDestinations.get(j).myTravelDestinationCityName!=null){
                        if(data.mainDataDestinations.get(j).myTravelDestinationCityName.toUpperCase().contains(constraint)){
                            //ADD IF FOUND
                            foundFilters.add(data);
                        }
                    }
                    else if (data.mainDataDestinations.get(j).myTravelDestinationCountryName!=null){
                        if(data.mainDataDestinations.get(j).myTravelDestinationCountryName.toUpperCase().contains(constraint)){
                            //ADD IF FOUND
                            foundFilters.add(data);
                        }
                    }
                }

            }

            //SET RESULTS TO FILTER LIST, remove duplication
            Set<MyTravelMainDataDataModel> set = new HashSet<>(foundFilters);
            foundFilters.clear();
            foundFilters.addAll(set);

            filterResults.count=foundFilters.size();
            filterResults.values=foundFilters;
        }else
        {
            //NO ITEM FOUND.LIST REMAINS INTACT
            filterResults.count=currentList.size();
            filterResults.values=currentList;
        }

        //RETURN RESULTS
        return filterResults;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        adapter.setFilteredData((ArrayList<MyTravelMainDataDataModel>) filterResults.values);
        adapter.refresh();
    }
}