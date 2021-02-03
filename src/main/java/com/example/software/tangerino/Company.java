
package com.example.software.tangerino;

import java.util.HashMap;
import java.util.Map;

public class Company {

    private String accountStatus;
    private String descriptionName;
    private String externalId;
    private String fantasyName;
    private long id;
    private String sponsor;
    private String sponsorEmail;
    private boolean standard;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Company() {
    }

    /**
     * 
     * @param accountStatus
     * @param standard
     * @param sponsor
     * @param descriptionName
     * @param externalId
     * @param fantasyName
     * @param id
     * @param sponsorEmail
     */
    public Company(String accountStatus, String descriptionName, String externalId, String fantasyName, long id, String sponsor, String sponsorEmail, boolean standard) {
        super();
        this.accountStatus = accountStatus;
        this.descriptionName = descriptionName;
        this.externalId = externalId;
        this.fantasyName = fantasyName;
        this.id = id;
        this.sponsor = sponsor;
        this.sponsorEmail = sponsorEmail;
        this.standard = standard;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getDescriptionName() {
        return descriptionName;
    }

    public void setDescriptionName(String descriptionName) {
        this.descriptionName = descriptionName;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getFantasyName() {
        return fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getSponsorEmail() {
        return sponsorEmail;
    }

    public void setSponsorEmail(String sponsorEmail) {
        this.sponsorEmail = sponsorEmail;
    }

    public boolean isStandard() {
        return standard;
    }

    public void setStandard(boolean standard) {
        this.standard = standard;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
