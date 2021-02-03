
package com.example.software.tangerino;

import java.util.HashMap;
import java.util.Map;

public class WorkScheduleTimetableList_ {

    private long day;
    private long endShift1;
    private long endShift2;
    private long endShift3;
    private long endShift4;
    private long endShift5;
    private long endShift6;
    private long id;
    private String message;
    private long startShift1;
    private long startShift2;
    private long startShift3;
    private long startShift4;
    private long startShift5;
    private long startShift6;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public WorkScheduleTimetableList_() {
    }

    /**
     * 
     * @param startShift6
     * @param startShift5
     * @param startShift4
     * @param startShift3
     * @param startShift2
     * @param startShift1
     * @param message
     * @param endShift4
     * @param endShift3
     * @param endShift6
     * @param endShift5
     * @param endShift2
     * @param endShift1
     * @param id
     * @param day
     */
    public WorkScheduleTimetableList_(long day, long endShift1, long endShift2, long endShift3, long endShift4, long endShift5, long endShift6, long id, String message, long startShift1, long startShift2, long startShift3, long startShift4, long startShift5, long startShift6) {
        super();
        this.day = day;
        this.endShift1 = endShift1;
        this.endShift2 = endShift2;
        this.endShift3 = endShift3;
        this.endShift4 = endShift4;
        this.endShift5 = endShift5;
        this.endShift6 = endShift6;
        this.id = id;
        this.message = message;
        this.startShift1 = startShift1;
        this.startShift2 = startShift2;
        this.startShift3 = startShift3;
        this.startShift4 = startShift4;
        this.startShift5 = startShift5;
        this.startShift6 = startShift6;
    }

    public long getDay() {
        return day;
    }

    public void setDay(long day) {
        this.day = day;
    }

    public long getEndShift1() {
        return endShift1;
    }

    public void setEndShift1(long endShift1) {
        this.endShift1 = endShift1;
    }

    public long getEndShift2() {
        return endShift2;
    }

    public void setEndShift2(long endShift2) {
        this.endShift2 = endShift2;
    }

    public long getEndShift3() {
        return endShift3;
    }

    public void setEndShift3(long endShift3) {
        this.endShift3 = endShift3;
    }

    public long getEndShift4() {
        return endShift4;
    }

    public void setEndShift4(long endShift4) {
        this.endShift4 = endShift4;
    }

    public long getEndShift5() {
        return endShift5;
    }

    public void setEndShift5(long endShift5) {
        this.endShift5 = endShift5;
    }

    public long getEndShift6() {
        return endShift6;
    }

    public void setEndShift6(long endShift6) {
        this.endShift6 = endShift6;
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

    public long getStartShift1() {
        return startShift1;
    }

    public void setStartShift1(long startShift1) {
        this.startShift1 = startShift1;
    }

    public long getStartShift2() {
        return startShift2;
    }

    public void setStartShift2(long startShift2) {
        this.startShift2 = startShift2;
    }

    public long getStartShift3() {
        return startShift3;
    }

    public void setStartShift3(long startShift3) {
        this.startShift3 = startShift3;
    }

    public long getStartShift4() {
        return startShift4;
    }

    public void setStartShift4(long startShift4) {
        this.startShift4 = startShift4;
    }

    public long getStartShift5() {
        return startShift5;
    }

    public void setStartShift5(long startShift5) {
        this.startShift5 = startShift5;
    }

    public long getStartShift6() {
        return startShift6;
    }

    public void setStartShift6(long startShift6) {
        this.startShift6 = startShift6;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
