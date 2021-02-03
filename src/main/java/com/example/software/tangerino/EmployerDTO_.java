
package com.example.software.tangerino;

import java.util.HashMap;
import java.util.Map;

public class EmployerDTO_ {

    private String companyName;
    private String currentlyPerformsPunch;
    private String email;
    private String employeeRange;
    private long id;
    private String message;
    private String origin;
    private String password;
    private String phone;
    private String platform;
    private boolean receiveNews;
    private String sponsorName;
    private String token;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public EmployerDTO_() {
    }

    /**
     * 
     * @param companyName
     * @param currentlyPerformsPunch
     * @param origin
     * @param sponsorName
     * @param receiveNews
     * @param message
     * @param platform
     * @param token
     * @param password
     * @param phone
     * @param employeeRange
     * @param id
     * @param email
     */
    public EmployerDTO_(String companyName, String currentlyPerformsPunch, String email, String employeeRange, long id, String message, String origin, String password, String phone, String platform, boolean receiveNews, String sponsorName, String token) {
        super();
        this.companyName = companyName;
        this.currentlyPerformsPunch = currentlyPerformsPunch;
        this.email = email;
        this.employeeRange = employeeRange;
        this.id = id;
        this.message = message;
        this.origin = origin;
        this.password = password;
        this.phone = phone;
        this.platform = platform;
        this.receiveNews = receiveNews;
        this.sponsorName = sponsorName;
        this.token = token;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCurrentlyPerformsPunch() {
        return currentlyPerformsPunch;
    }

    public void setCurrentlyPerformsPunch(String currentlyPerformsPunch) {
        this.currentlyPerformsPunch = currentlyPerformsPunch;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployeeRange() {
        return employeeRange;
    }

    public void setEmployeeRange(String employeeRange) {
        this.employeeRange = employeeRange;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public boolean isReceiveNews() {
        return receiveNews;
    }

    public void setReceiveNews(boolean receiveNews) {
        this.receiveNews = receiveNews;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
