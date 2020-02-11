package com.mytmmin.etravel;

public class GlobalVariable {
    //Server base url
    public static final String SERVER_BASE_URL = "http://ec2-54-251-162-109.ap-southeast-1.compute.amazonaws.com/mytravel/android/";
    public static final String TOYOTA_DEV_SERVER_BASE_URL = "http://travel.dev.toyota.co.id/";

    //API Interface
    public static final String POST_TRAVEL_API_ENDPOINT = "mytravel_request_api.php";
    public static final String GET_ALL_TRAVEL_INQUIRY_ENDPOINT = "TravelInquiry/getInquiry";
    public static final String GET_ALL_TRAVEL_HISTORY_ENDPOINT = "TravelHistory/getHistory";
    public static final String GET_ALL_TRAVEL_DRAFT_ENDPOINT = "TravelDraft/getDraft";
    public static final String GET_APPROVE_REJECT_TRAVEL_INQUIRY_ENDPOINT = "ApproveReject/confirm";

    //from travel proposal code start with 1
    //from travel settlement code start with 2
    //from main travel code start with 9
    //fragment code add 3 after activity prefix
    public static final int PROPOSAL_APPROVER_REQUEST_DETAILS_RESULT_CODE = 1002;
    public static final int PROPOSAL_APPROVER_REQUEST_MAIN_RESULT_CODE = 1001;
    public static final int PROPOSAL_HISTORY_REQUEST_MAIN_RESULT_CODE = 1003;
    public static final int PROPOSAL_HISTORY_REQUEST_DETAILS_RESULT_CODE = 1004;
    public static final int SETTLEMENT_APPROVER_REQUEST_DETAILS_RESULT_CODE = 2002;
    public static final int SETTLEMENT_APPROVER_REQUEST_MAIN_RESULT_CODE = 2001;
    public static final int SETTLEMENT_HISTORY_REQUEST_MAIN_RESULT_CODE = 2003;
    public static final int SETTLEMENT_HISTORY_REQUEST_DETAILS_RESULT_CODE = 2004;
    public static final int MYTRAVEL_MAIN_MYTRAVEL_FRAGMENT_ADD_TRAVEL_PROPOSAL_CODE = 9301;
    public static final int MYTRAVEL_MAIN_MYTRAVEL_FRAGMENT_LIST_HISTORY_APPROVAL_CODE = 9302;
    public static final int MYTRAVEL_MAIN_MYTRAVEL_FRAGMENT_LIST_PROPOSAL_APPROVAL_CODE = 9303;
    public static final int MYTRAVEL_MAIN_MYTSETTLEMENT_FRAGMENT_LIST_HISTORY_SETTLEMENT_CODE = 9304;
    public static final int MYTRAVEL_MAIN_MYSETTLEMENT_FRAGMENT_LIST_SETTLEMENT_APPROVAL_CODE = 9305;

    //TAG
    public static final String TAG_OPEN_PROPOSAL_APPROVER_REQUEST_DETAILS_ACTIVITY = "open_proposal_approver_request_details_activity";
    public static final String TAG_OPEN_PROPOSAL_HISTORY_REQUEST_DETAILS_ACTIVITY = "open_proposal_history_request_details_activity";
    public static final String TAG_OPEN_SETTLEMENT_APPROVER_REQUEST_DETAILS_ACTIVITY = "open_settlement_approver_request_details_activity";
    public static final String TAG_OPEN_SETTLEMENT_HISTORY_REQUEST_DETAILS_ACTIVITY = "open_settlement_history_request_details_activity";

    //Serialized Name
    public static final String SERIALIZED_NAME_PAGE = "page";
    public static final String SERIALIZED_NAME_LIMIT = "limit";
    public static final String SERIALIZED_NAME_TOTAL_DATA = "totalData";
    public static final String SERIALIZED_NAME_TOTAL_PAGES = "total_pages";
    public static final String SERIALIZED_NAME_SUCCESS = "success";
    public static final String SERIALIZED_NAME_MESSAGE = "message";
    public static final String SERIALIZED_NAME_DATA = "data";
//    public static final String SERIALIZED_NAME_ID = "id";
//    public static final String SERIALIZED_NAME_IS_CHECKED = "is_checked";
//    public static final String SERIALIZED_NAME_IS_TRAVEL_MULTIPLE_CITY = "is_travel_multiple_city";
//    public static final String SERIALIZED_NAME_IS_DOMESTIC_TRIP = "is_domestic_trip";
//    public static final String SERIALIZED_NAME_DRAFT_NUMBER = "draft_number";
//    public static final String SERIALIZED_NAME_TP_NUMBER = "tp_number";
    public static final String SERIALIZED_NAME_EMPLOYEE_NAME = "employee_name";
//    public static final String SERIALIZED_NAME_EMPLOYEE_DIVISION = "employee_division";
//    public static final String SERIALIZED_NAME_EMPLOYEE_REG_NUMBER = "employee_reg_number";
//    public static final String SERIALIZED_NAME_TRAVEL_STARTING_CITY = "travel_starting_city";
//    public static final String SERIALIZED_NAME_TRAVEL_TOTAL_DAYS = "travel_total_days";
//    public static final String SERIALIZED_NAME_TRAVEL_START_TRIP_DATE = "travel_start_trip_date";
//    public static final String SERIALIZED_NAME_TRAVEL_END_TRIP_DATE = "travel_end_trip_date";
//    public static final String SERIALIZED_NAME_TRAVEL_TOTAL_EXPENSES = "travel_total_expenses";
//    public static final String SERIALIZED_NAME_TRAVEL_DESTINATION_CITY = "travel_destination_city";
    public static final String SERIALIZED_NAME_PHOTO_URL = "photo_url";
//    public static final String SERIALIZED_NAME_TRAVEL_DESTINATION_CITY_DETAILS = "travel_destination_city_details";
//    public static final String SERIALIZED_NAME_TRAVEL_DESTINATION_CITY_DATE = "travel_destination_city_date";
//    public static final String SERIALIZED_NAME_OBJECTIVES_DESTINATION = "objectives_destination";
//    public static final String SERIALIZED_NAME_OBJECTIVES_DETAILS = "objectives_details";
//    public static final String SERIALIZED_NAME_EXPENSES_DESTINATION = "expenses_destination";
//    public static final String SERIALIZED_NAME_EXPENSES_DETAILS = "expenses_details";
    public static final String SERIALIZED_NAME_ALLOWANCE_DETAILS = "allowance_details";
    public static final String SERIALIZED_NAME_ALLOWANCE_AMMOUNT = "allowance_ammount";
//    public static final String SERIALIZED_NAME_ALLOWANCE_DATA_MODEL = "allowance_data_model";
//    public static final String SERIALIZED_NAME_APPROVER_STATUS = "approver_status";
//    public static final String SERIALIZED_NAME_APPROVER_DATE = "approver_date";

    //Toyota Dev API TAG
    public static final String SERIALIZED_NAME_POSITION = "POSITION";
    public static final String SERIALIZED_NAME_DRAFT_NO = "DRAFT_NO";
    public static final String SERIALIZED_NAME_TP_NO = "TP_NO";
    public static final String SERIALIZED_NAME_NOREG = "NOREG";
    public static final String SERIALIZED_NAME_PATH_LOCATION = "PATH_LOCATION";
    public static final String SERIALIZED_NAME_USD_EXCHANGE_RATE = "USD_EXCHANGE_RATE";
    public static final String SERIALIZED_NAME_JPY_EXCHANGE_RATE = "JPY_EXCHANGE_RATE";
    public static final String SERIALIZED_NAME_STATUS_DESC = "STATUS_DESC";
    public static final String SERIALIZED_NAME_BUSINESS_TRIP = "BUSINESS_TRIP";
    public static final String SERIALIZED_NAME_LAST_TP_POSITION = "LAST_TP_POSITION";
    public static final String SERIALIZED_NAME_ORG_PERSON_INFO = "OrgPersonInfo";
    public static final String SERIALIZED_NAME_EDIT_NAME = "EDITNAME";
    public static final String SERIALIZED_NAME_DIV_ORG_TITLE = "DIV_ORG_TITLE";
    public static final String SERIALIZED_NAME_DESTINATION_DATA = "destinationData";
    public static final String SERIALIZED_NAME_DESTINATIONS = "DESTINATION";
    public static final String SERIALIZED_NAME_TP_DESTINATION_SEQ = "TP_DESTINATION_SEQ";
    public static final String SERIALIZED_NAME_COUNTRY_CD = "COUNTRY_CD";
    public static final String SERIALIZED_NAME_COUNTRY_NAME = "COUNTRY_NAME";
    public static final String SERIALIZED_NAME_CITY_COUNTRY = "CITY_COUNTRY";
    public static final String SERIALIZED_NAME_CITY = "CITY";
    public static final String SERIALIZED_NAME_CITY_FROM = "CITY_FROM";
    public static final String SERIALIZED_NAME_CITY_CD = "CITY_CD";
    public static final String SERIALIZED_NAME_CITY_NAME = "CITY_NAME";
    public static final String SERIALIZED_NAME_OBJECTIVES= "OBJECTIVES";
    public static final String SERIALIZED_NAME_FROM_STR = "FROM_STR";
    public static final String SERIALIZED_NAME_FROM = "FROM";
    public static final String SERIALIZED_NAME_UNTIL = "UNTIL";
    public static final String SERIALIZED_NAME_UNTIL_STR = "UNTIL_STR";
    public static final String SERIALIZED_NAME_CANCEL_FLAG = "CANCEL_FLAG";
    public static final String SERIALIZED_NAME_APPROVAL = "approval";
    public static final String SERIALIZED_NAME_APPROVALS = "APPROVAL";
    public static final String SERIALIZED_NAME_APPROVED_STATUS = "APPROVED_STATUS";
    public static final String SERIALIZED_NAME_APPROVAL_LEVEL = "APPROVAL_LEVEL";
    public static final String SERIALIZED_NAME_DOC_SEQ = "DOC_SEQ";

    public static final String SERIALIZED_NAME_TP_ALLOWANCE = "TP_ALLOWANCE";
    public static final String SERIALIZED_NAME_TP_DESTINATION_DETAILS = "TP_DESTINATION_DTL";

    public static final String SERIALIZED_NAME_TS_ALLOWANCE = "TS_ALLOWANCE";
    public static final String SERIALIZED_NAME_TS_DESTINATION_DETAILS = "TS_DESTINATION_DTL";

    public static final String SERIALIZED_NAME_DIRECT_ALLOWANCE = "directAllowance";
    public static final String SERIALIZED_NAME_SUSPENSE_ALLOWANCE = "suspenseAllowance";

    public static final String SERIALIZED_NAME_PREPARATION_ALLOWANCE = "preparationAllowance";
    public static final String SERIALIZED_NAME_WINTER_ALLOWANCE = "winterAllowance";
    public static final String SERIALIZED_NAME_DAILY_ALLOWANCE = "dailyAllowance";
    public static final String SERIALIZED_NAME_DOMESTIC_LAND_TRANSPORT = "domesticLandTransport";
    public static final String SERIALIZED_NAME_HOTEL_ALLOWANCE = "hotelAllowance";
    public static final String SERIALIZED_NAME_OVERSEAS_LAND_TRANSPORT = "overseasLandTransport";
    public static final String SERIALIZED_NAME_MISCELLANEOUS = "Miscellaneous";
    public static final String SERIALIZED_NAME_FISCAL_TAXES = "fiscalTaxes";

    public static final String SERIALIZED_NAME_TOTAL_TRANSFER_IN_IDR = "totalTransferInIdr";
    public static final String SERIALIZED_NAME_TOTAL_IN_IDR = "totalInIdr";
    public static final String SERIALIZED_NAME_TOTAL_PROPOSAL = "totalProposal";
    public static final String SERIALIZED_NAME_TOTAL_SETTLEMENT = "totalSettlement";
    public static final String SERIALIZED_NAME_TOTAL_DEDUCTION_IN_IDR = "totalDeductionInIdr";
    public static final String SERIALIZED_NAME_BALANCE_IN_IDR = "balanceInIdr";

    public static final String SERIALIZED_NAME_TP_ALLOWANCE_DETAILS = "TpAllowanceDtls";
    public static final String SERIALIZED_NAME_DESTINATION = "destination"; //TODO: change name

    public static final String SERIALIZED_NAME_ALLOWANCE_IDR = "allowanceIdr";
    public static final String SERIALIZED_NAME_ALLOWANCE_USD = "allowanceUsd";
    public static final String SERIALIZED_NAME_ALLOWANCE_JPY = "allowanceJpy";
    public static final String SERIALIZED_NAME_ALLOWANCE_IDR_PROPOSAL = "allowanceIdrProposal";
    public static final String SERIALIZED_NAME_ALLOWANCE_USD_PROPOSAL = "allowanceUsdProposal";
    public static final String SERIALIZED_NAME_ALLOWANCE_JPY_PROPOSAL = "allowanceJpyProposal";
    public static final String SERIALIZED_NAME_ALLOWANCE_IDR_SETTLEMENT = "allowanceIdrSettlement";
    public static final String SERIALIZED_NAME_ALLOWANCE_USD_SETTLEMENT = "allowanceUsdSettlement";
    public static final String SERIALIZED_NAME_ALLOWANCE_JPY_SETTLEMENT = "allowanceJpySettlement";

    //Approve / reject
    public static final String SERIALIZED_NAME_STATUS_PROCESS_ID = "statusProcessId";

}
