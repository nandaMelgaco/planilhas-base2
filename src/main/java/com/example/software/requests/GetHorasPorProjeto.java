package com.example.software.requests;

import com.example.software.bases.RequestRestBase;
import io.restassured.http.Method;

public class GetHorasPorProjeto extends RequestRestBase {

    public GetHorasPorProjeto(String startDate, String endDate, int offset,int projectId,int userId){
        url = "https://redmine.base2.com.br";
        requestService = "/time_entries.json?user_id="+userId+"&project_id="+projectId+"&from="+startDate+"&limit=100&offset="+offset+"&to="+endDate;
        method = Method.GET;
        headers.put("X-Redmine-API-Key", "8e7a5965847e3a2ae03cd21cb41370e28b7b5e87");
    }
}
