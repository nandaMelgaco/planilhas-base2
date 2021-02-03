package com.example.software.requests;

import com.example.software.bases.RequestRestBase;
import io.restassured.http.Method;

public class GetHorasRHApropriacao extends RequestRestBase{

    public GetHorasRHApropriacao(String startDate, String endDate,int user_Id, int offset){

        url = "https://redmine.base2.com.br";
        requestService = "/time_entries.json?user_id="+user_Id+"&project_id=6&from="+startDate+"&limit=100&offset="+offset+"&to="+endDate;
        method = Method.GET;
        headers.put("X-Redmine-API-Key", "8e7a5965847e3a2ae03cd21cb41370e28b7b5e87");
    }
}
