package com.example.software.tangerino;

import java.util.HashMap;
import java.util.Map;

public class ColaboradorTangerinoDailySumary {

private long compensatoryHoursBalance;
private String date;
private long dayMissing;
private long employeeId;
private long employerId;
private long estimatedHours;
private long fictaHours;
private long hoursBalance;
private long id;
private boolean isAdjustment;
private boolean isHoliday;
private boolean missed;
private String movementType;
private long nightHours;
private long onCallHours;
private long overlimitCompensatoryHoursBalance;
private long overtimeTypeFour;
private long overtimeTypeOne;
private long overtimeTypeThree;
private long overtimeTypeTwo;
private long paidHours;
private long punchRoleId;
private long remainingHours;
private boolean unjustifiedMiss;
private long workedHours;
private long workscheduleId;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
*
*/
public ColaboradorTangerinoDailySumary() {
}

/**
*
* @param date
* @param overlimitCompensatoryHoursBalance
* @param workscheduleId
* @param remainingHours
* @param isHoliday
* @param nightHours
* @param hoursBalance
* @param fictaHours
* @param overtimeTypeFour
* @param movementType
* @param overtimeTypeTwo
* @param compensatoryHoursBalance
* @param id
* @param workedHours
* @param punchRoleId
* @param paidHours
* @param missed
* @param dayMissing
* @param employeeId
* @param overtimeTypeOne
* @param employerId
* @param isAdjustment
* @param overtimeTypeThree
* @param onCallHours
* @param estimatedHours
* @param unjustifiedMiss
*/
public ColaboradorTangerinoDailySumary(long compensatoryHoursBalance, String date, long dayMissing, long employeeId, long employerId, long estimatedHours, long fictaHours, long hoursBalance, long id, boolean isAdjustment, boolean isHoliday, boolean missed, String movementType, long nightHours, long onCallHours, long overlimitCompensatoryHoursBalance, long overtimeTypeFour, long overtimeTypeOne, long overtimeTypeThree, long overtimeTypeTwo, long paidHours, long punchRoleId, long remainingHours, boolean unjustifiedMiss, long workedHours, long workscheduleId) {
super();
this.compensatoryHoursBalance = compensatoryHoursBalance;
this.date = date;
this.dayMissing = dayMissing;
this.employeeId = employeeId;
this.employerId = employerId;
this.estimatedHours = estimatedHours;
this.fictaHours = fictaHours;
this.hoursBalance = hoursBalance;
this.id = id;
this.isAdjustment = isAdjustment;
this.isHoliday = isHoliday;
this.missed = missed;
this.movementType = movementType;
this.nightHours = nightHours;
this.onCallHours = onCallHours;
this.overlimitCompensatoryHoursBalance = overlimitCompensatoryHoursBalance;
this.overtimeTypeFour = overtimeTypeFour;
this.overtimeTypeOne = overtimeTypeOne;
this.overtimeTypeThree = overtimeTypeThree;
this.overtimeTypeTwo = overtimeTypeTwo;
this.paidHours = paidHours;
this.punchRoleId = punchRoleId;
this.remainingHours = remainingHours;
this.unjustifiedMiss = unjustifiedMiss;
this.workedHours = workedHours;
this.workscheduleId = workscheduleId;
}

public long getCompensatoryHoursBalance() {
return compensatoryHoursBalance;
}

public void setCompensatoryHoursBalance(long compensatoryHoursBalance) {
this.compensatoryHoursBalance = compensatoryHoursBalance;
}

public String getDate() {
return date;
}

public void setDate(String date) {
this.date = date;
}

public long getDayMissing() {
return dayMissing;
}

public void setDayMissing(long dayMissing) {
this.dayMissing = dayMissing;
}

public long getEmployeeId() {
return employeeId;
}

public void setEmployeeId(long employeeId) {
this.employeeId = employeeId;
}

public long getEmployerId() {
return employerId;
}

public void setEmployerId(long employerId) {
this.employerId = employerId;
}

public long getEstimatedHours() {
return estimatedHours;
}

public void setEstimatedHours(long estimatedHours) {
this.estimatedHours = estimatedHours;
}

public long getFictaHours() {
return fictaHours;
}

public void setFictaHours(long fictaHours) {
this.fictaHours = fictaHours;
}

public long getHoursBalance() {
return hoursBalance;
}

public void setHoursBalance(long hoursBalance) {
this.hoursBalance = hoursBalance;
}

public long getId() {
return id;
}

public void setId(long id) {
this.id = id;
}

public boolean isIsAdjustment() {
return isAdjustment;
}

public void setIsAdjustment(boolean isAdjustment) {
this.isAdjustment = isAdjustment;
}

public boolean isIsHoliday() {
return isHoliday;
}

public void setIsHoliday(boolean isHoliday) {
this.isHoliday = isHoliday;
}

public boolean isMissed() {
return missed;
}

public void setMissed(boolean missed) {
this.missed = missed;
}

public String getMovementType() {
return movementType;
}

public void setMovementType(String movementType) {
this.movementType = movementType;
}

public long getNightHours() {
return nightHours;
}

public void setNightHours(long nightHours) {
this.nightHours = nightHours;
}

public long getOnCallHours() {
return onCallHours;
}

public void setOnCallHours(long onCallHours) {
this.onCallHours = onCallHours;
}

public long getOverlimitCompensatoryHoursBalance() {
return overlimitCompensatoryHoursBalance;
}

public void setOverlimitCompensatoryHoursBalance(long overlimitCompensatoryHoursBalance) {
this.overlimitCompensatoryHoursBalance = overlimitCompensatoryHoursBalance;
}

public long getOvertimeTypeFour() {
return overtimeTypeFour;
}

public void setOvertimeTypeFour(long overtimeTypeFour) {
this.overtimeTypeFour = overtimeTypeFour;
}

public long getOvertimeTypeOne() {
return overtimeTypeOne;
}

public void setOvertimeTypeOne(long overtimeTypeOne) {
this.overtimeTypeOne = overtimeTypeOne;
}

public long getOvertimeTypeThree() {
return overtimeTypeThree;
}

public void setOvertimeTypeThree(long overtimeTypeThree) {
this.overtimeTypeThree = overtimeTypeThree;
}

public long getOvertimeTypeTwo() {
return overtimeTypeTwo;
}

public void setOvertimeTypeTwo(long overtimeTypeTwo) {
this.overtimeTypeTwo = overtimeTypeTwo;
}

public long getPaidHours() {
return paidHours;
}

public void setPaidHours(long paidHours) {
this.paidHours = paidHours;
}

public long getPunchRoleId() {
return punchRoleId;
}

public void setPunchRoleId(long punchRoleId) {
this.punchRoleId = punchRoleId;
}

public long getRemainingHours() {
return remainingHours;
}

public void setRemainingHours(long remainingHours) {
this.remainingHours = remainingHours;
}

public boolean isUnjustifiedMiss() {
return unjustifiedMiss;
}

public void setUnjustifiedMiss(boolean unjustifiedMiss) {
this.unjustifiedMiss = unjustifiedMiss;
}

public long getWorkedHours() {
return workedHours;
}

public void setWorkedHours(long workedHours) {
this.workedHours = workedHours;
}

public long getWorkscheduleId() {
return workscheduleId;
}

public void setWorkscheduleId(long workscheduleId) {
this.workscheduleId = workscheduleId;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

@Override
public String toString() {
	return "ColaboradorTangerino [compensatoryHoursBalance=" + compensatoryHoursBalance + ", date=" + date
			+ ", dayMissing=" + dayMissing + ", employeeId=" + employeeId + ", employerId=" + employerId
			+ ", estimatedHours=" + estimatedHours + ", fictaHours=" + fictaHours + ", hoursBalance=" + hoursBalance
			+ ", id=" + id + ", isAdjustment=" + isAdjustment + ", isHoliday=" + isHoliday + ", missed=" + missed
			+ ", movementType=" + movementType + ", nightHours=" + nightHours + ", onCallHours=" + onCallHours
			+ ", overlimitCompensatoryHoursBalance=" + overlimitCompensatoryHoursBalance + ", overtimeTypeFour="
			+ overtimeTypeFour + ", overtimeTypeOne=" + overtimeTypeOne + ", overtimeTypeThree=" + overtimeTypeThree
			+ ", overtimeTypeTwo=" + overtimeTypeTwo + ", paidHours=" + paidHours + ", punchRoleId=" + punchRoleId
			+ ", remainingHours=" + remainingHours + ", unjustifiedMiss=" + unjustifiedMiss + ", workedHours="
			+ workedHours + ", workscheduleId=" + workscheduleId + ", additionalProperties=" + additionalProperties
			+ "]";
}



}