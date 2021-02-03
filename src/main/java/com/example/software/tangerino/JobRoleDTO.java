
package com.example.software.tangerino;

import java.util.HashMap;
import java.util.Map;

public class JobRoleDTO {

    private long alterationDate;
    private String description;
    private EmployerDTO employerDTO;
    private String externalId;
    private long id;
    private String message;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public JobRoleDTO() {
    }

    /**
     * 
     * @param employerDTO
     * @param alterationDate
     * @param description
     * @param externalId
     * @param id
     * @param message
     */
    public JobRoleDTO(long alterationDate, String description, EmployerDTO employerDTO, String externalId, long id, String message) {
        super();
        this.alterationDate = alterationDate;
        this.description = description;
        this.employerDTO = employerDTO;
        this.externalId = externalId;
        this.id = id;
        this.message = message;
    }

    public long getAlterationDate() {
        return alterationDate;
    }

    public void setAlterationDate(long alterationDate) {
        this.alterationDate = alterationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EmployerDTO getEmployerDTO() {
        return employerDTO;
    }

    public void setEmployerDTO(EmployerDTO employerDTO) {
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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
