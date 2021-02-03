
package com.example.software.tangerino;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrentWorkSchedule {

    private String externalId;
    private long id;
    private String name;
    private boolean standard;
    private long startDate;
    private List<WorkScheduleTimetableList> workScheduleTimetableList = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CurrentWorkSchedule() {
    }

    /**
     * 
     * @param standard
     * @param workScheduleTimetableList
     * @param name
     * @param externalId
     * @param id
     * @param startDate
     */
    public CurrentWorkSchedule(String externalId, long id, String name, boolean standard, long startDate, List<WorkScheduleTimetableList> workScheduleTimetableList) {
        super();
        this.externalId = externalId;
        this.id = id;
        this.name = name;
        this.standard = standard;
        this.startDate = startDate;
        this.workScheduleTimetableList = workScheduleTimetableList;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStandard() {
        return standard;
    }

    public void setStandard(boolean standard) {
        this.standard = standard;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public List<WorkScheduleTimetableList> getWorkScheduleTimetableList() {
        return workScheduleTimetableList;
    }

    public void setWorkScheduleTimetableList(List<WorkScheduleTimetableList> workScheduleTimetableList) {
        this.workScheduleTimetableList = workScheduleTimetableList;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
