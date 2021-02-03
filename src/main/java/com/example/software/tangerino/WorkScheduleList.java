
package com.example.software.tangerino;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkScheduleList {

    private long alterationDate;
    private EmployerDTO_ employerDTO;
    private String externalId;
    private long id;
    private String message;
    private String name;
    private boolean standard;
    private List<WorkScheduleTimetableList_> workScheduleTimetableList = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public WorkScheduleList() {
    }

    /**
     * 
     * @param standard
     * @param employerDTO
     * @param alterationDate
     * @param workScheduleTimetableList
     * @param name
     * @param externalId
     * @param id
     * @param message
     */
    public WorkScheduleList(long alterationDate, EmployerDTO_ employerDTO, String externalId, long id, String message, String name, boolean standard, List<WorkScheduleTimetableList_> workScheduleTimetableList) {
        super();
        this.alterationDate = alterationDate;
        this.employerDTO = employerDTO;
        this.externalId = externalId;
        this.id = id;
        this.message = message;
        this.name = name;
        this.standard = standard;
        this.workScheduleTimetableList = workScheduleTimetableList;
    }

    public long getAlterationDate() {
        return alterationDate;
    }

    public void setAlterationDate(long alterationDate) {
        this.alterationDate = alterationDate;
    }

    public EmployerDTO_ getEmployerDTO() {
        return employerDTO;
    }

    public void setEmployerDTO(EmployerDTO_ employerDTO) {
        this.employerDTO = employerDTO;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public List<WorkScheduleTimetableList_> getWorkScheduleTimetableList() {
        return workScheduleTimetableList;
    }

    public void setWorkScheduleTimetableList(List<WorkScheduleTimetableList_> workScheduleTimetableList) {
        this.workScheduleTimetableList = workScheduleTimetableList;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
