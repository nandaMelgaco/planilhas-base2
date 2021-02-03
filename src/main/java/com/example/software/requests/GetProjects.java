package com.example.software.requests;

import com.example.software.bases.RequestRestBase;
import io.restassured.http.Method;

public class GetProjects extends RequestRestBase{
    public GetProjects(int offset){

        url = "https://redmine.base2.com.br";
        requestService = "/projects.json?limit=100&offset="+offset;
        method = Method.GET;
        headers.put("X-Redmine-API-Key", "8e7a5965847e3a2ae03cd21cb41370e28b7b5e87");
    }

}