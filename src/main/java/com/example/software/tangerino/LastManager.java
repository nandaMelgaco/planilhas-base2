
package com.example.software.tangerino;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LastManager {

    private List<Object> employeeList = null;
    private long id;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public LastManager() {
    }

    /**
     * 
     * @param employeeList
     * @param id
     */
    public LastManager(List<Object> employeeList, long id) {
        super();
        this.employeeList = employeeList;
        this.id = id;
    }

    public List<Object> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Object> employeeList) {
        this.employeeList = employeeList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
