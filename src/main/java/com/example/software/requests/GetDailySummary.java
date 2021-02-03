package com.example.software.requests;

import com.example.software.bases.RequestRestBase;
import io.restassured.http.Method;

public class GetDailySummary extends RequestRestBase {

    public GetDailySummary(String endDate, String startDate){
    	url = "https://api.tangerino.com.br/api/punch";
        requestService = "/daily-summary/";
        method = Method.GET;
        queryParameters.put("endDate", endDate);
        queryParameters.put("startDate", startDate);
    }
}
