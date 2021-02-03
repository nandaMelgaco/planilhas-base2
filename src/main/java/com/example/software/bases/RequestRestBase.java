package com.example.software.bases;

import com.example.software.utils.RestAssuredUtils;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.*;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.path.json.config.JsonPathConfig.NumberReturnType.BIG_DECIMAL;

public abstract class RequestRestBase {
    protected String url = null;
    protected String requestService = null;
    protected Method method = null;
    protected String jsonBody = null;
    protected Map<String, String> headers = new HashMap<String, String>();
    protected Map<String, String> cookies = new HashMap<String, String>();
    protected Map<String, String> queryParameters = new HashMap<String, String>();

    public RequestRestBase(){
        config = RestAssuredConfig.newConfig().jsonConfig(jsonConfig().numberReturnType(BIG_DECIMAL));
        enableLoggingOfRequestAndResponseIfValidationFails();
        headers.put("content-type", "application/json");
        headers.put("Authorization", "Basic ZTM2OGNjOTJmMGY1NDc1NGFlZDMyMTg3OTUzYWFiNGU6ZjdiZTFjMzFlNTZkNDkwODkyNzc0MDkzYmQ4YTA1Yjc="); //<== EXEMPLO DE COMO ADICIONAR TOKEN DEFAULT CASO NECESSÁRIO
    }

    public Response executeRequest() {
        Response response = RestAssuredUtils.executeRestRequest(url, requestService, method, headers, cookies, queryParameters, jsonBody);

        return response;
    }

    public void removeHeader(String header){
        headers.remove(header);
    }

    public void removeCookie(String cookie){
        cookies.remove(cookie);
    }

    public void removeQueryParameters(String parameter){
        queryParameters.remove(parameter);
    }

    public void setMehtod(Method method){
        this.method = method;
    }
}
