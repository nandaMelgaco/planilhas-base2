package com.example.software.requests;

import com.example.software.bases.RequestRestBase;
import io.restassured.http.Method;

public class GetEmployee extends RequestRestBase {

    public GetEmployee(){
        url = "https://api.tangerino.com.br/api/employer";
        requestService = "/employee/find-all?size=1000";
        method = Method.GET;
    }
}
