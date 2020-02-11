package com.mytmmin.etravel.API;

import com.mytmmin.etravel.POJO.AllDraftNumberToyotaDevPojo;
import com.mytmmin.etravel.POJO.ApproveRejectToyotaDevPojo;
import com.mytmmin.etravel.POJO.MyTravelMainDevPojo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import static com.mytmmin.etravel.GlobalVariable.GET_ALL_TRAVEL_DRAFT_ENDPOINT;
import static com.mytmmin.etravel.GlobalVariable.GET_ALL_TRAVEL_HISTORY_ENDPOINT;
import static com.mytmmin.etravel.GlobalVariable.GET_ALL_TRAVEL_INQUIRY_ENDPOINT;
import static com.mytmmin.etravel.GlobalVariable.GET_APPROVE_REJECT_TRAVEL_INQUIRY_ENDPOINT;

public interface MyTravelAPIInterface {

    @GET(GET_ALL_TRAVEL_INQUIRY_ENDPOINT)
    Call<MyTravelMainDevPojo> getAllRequestApprover(@Query("noreg") String noreg, @Query("type") String type, @Query("page") String page, @Query("limit") String limit);

    @FormUrlEncoded
    @POST(GET_APPROVE_REJECT_TRAVEL_INQUIRY_ENDPOINT)
    Call<ApproveRejectToyotaDevPojo> approveRejectRequest(@Field("draft_no") String draftNo, @Field("noreg") String noReg, @Field("type") String type, @Field("action") String action);

    @GET(GET_ALL_TRAVEL_HISTORY_ENDPOINT)
    Call<MyTravelMainDevPojo> getAllRequestHistory(@Query("noreg") String noreg, @Query("type") String type, @Query("page") String page, @Query("limit") String limit);

    @GET(GET_ALL_TRAVEL_DRAFT_ENDPOINT)
    Call<AllDraftNumberToyotaDevPojo> getAllDraftNumber(@Query("noreg") String noreg, @Query("type") String type);

//    @FormUrlEncoded
//    @POST("/api/users?")
//    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);

}
