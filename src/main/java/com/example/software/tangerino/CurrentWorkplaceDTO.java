
package com.example.software.tangerino;

import java.util.HashMap;
import java.util.Map;

public class CurrentWorkplaceDTO {

    private String externalId;
    private long id;
    private String name;
    private boolean standard;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CurrentWorkplaceDTO() {
    }

    /**
     * 
     * @param standard
     * @param name
     * @param externalId
     * @param id
     */
    public CurrentWorkplaceDTO(String externalId, long id, String name, boolean standard) {
        super();
        this.externalId = externalId;
        this.id = id;
        this.name = name;
        this.standard = standard;
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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
