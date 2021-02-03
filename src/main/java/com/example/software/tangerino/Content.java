package com.example.software.tangerino;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Content {

    private String admissionDate;
    private String birthDate;
    private Company company;
    private String cpf;
    private CurrentWorkSchedule currentWorkSchedule;
    private CurrentWorkplaceDTO currentWorkplaceDTO;
    private String effectiveDate;
    private String email;
    private String externalId;
    private long id;
    private JobRoleDTO jobRoleDTO;
    private LastManager lastManager;
    private List<Manager> managers = null;
    private String message;
    private String name;
    private String phone;
    private String pin;
    private String pis;
    private String resignationDate;
    private String updateDate;
    private List<WorkScheduleList> workScheduleList = null;
    private List<WorkplaceList> workplaceList = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Content() {
    }

    /**
     * 
     * @param lastManager
     * @param admissionDate
     * @param updateDate
     * @param workScheduleList
     * @param currentWorkplaceDTO
     * @param externalId
     * @param message
     * @param birthDate
     * @param resignationDate
     * @param workplaceList
     * @param pin
     * @param phone
     * @param cpf
     * @param name
     * @param company
     * @param id
     * @param pis
     * @param jobRoleDTO
     * @param effectiveDate
     * @param email
     * @param managers
     * @param currentWorkSchedule
     */
    public Content(String admissionDate, String birthDate, Company company, String cpf, CurrentWorkSchedule currentWorkSchedule, CurrentWorkplaceDTO currentWorkplaceDTO, String effectiveDate, String email, String externalId, long id, JobRoleDTO jobRoleDTO, LastManager lastManager, List<Manager> managers, String message, String name, String phone, String pin, String pis, String resignationDate, String updateDate, List<WorkScheduleList> workScheduleList, List<WorkplaceList> workplaceList) {
        super();
        this.admissionDate = admissionDate;
        this.birthDate = birthDate;
        this.company = company;
        this.cpf = cpf;
        this.currentWorkSchedule = currentWorkSchedule;
        this.currentWorkplaceDTO = currentWorkplaceDTO;
        this.effectiveDate = effectiveDate;
        this.email = email;
        this.externalId = externalId;
        this.id = id;
        this.jobRoleDTO = jobRoleDTO;
        this.lastManager = lastManager;
        this.managers = managers;
        this.message = message;
        this.name = name;
        this.phone = phone;
        this.pin = pin;
        this.pis = pis;
        this.resignationDate = resignationDate;
        this.updateDate = updateDate;
        this.workScheduleList = workScheduleList;
        this.workplaceList = workplaceList;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public CurrentWorkSchedule getCurrentWorkSchedule() {
        return currentWorkSchedule;
    }

    public void setCurrentWorkSchedule(CurrentWorkSchedule currentWorkSchedule) {
        this.currentWorkSchedule = currentWorkSchedule;
    }

    public CurrentWorkplaceDTO getCurrentWorkplaceDTO() {
        return currentWorkplaceDTO;
    }

    public void setCurrentWorkplaceDTO(CurrentWorkplaceDTO currentWorkplaceDTO) {
        this.currentWorkplaceDTO = currentWorkplaceDTO;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public JobRoleDTO getJobRoleDTO() {
        return jobRoleDTO;
    }

    public void setJobRoleDTO(JobRoleDTO jobRoleDTO) {
        this.jobRoleDTO = jobRoleDTO;
    }

    public LastManager getLastManager() {
        return lastManager;
    }

    public void setLastManager(LastManager lastManager) {
        this.lastManager = lastManager;
    }

    public List<Manager> getManagers() {
        return managers;
    }

    public void setManagers(List<Manager> managers) {
        this.managers = managers;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getResignationDate() {
        return resignationDate;
    }

    public void setResignationDate(String resignationDate) {
        this.resignationDate = resignationDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public List<WorkScheduleList> getWorkScheduleList() {
        return workScheduleList;
    }

    public void setWorkScheduleList(List<WorkScheduleList> workScheduleList) {
        this.workScheduleList = workScheduleList;
    }

    public List<WorkplaceList> getWorkplaceList() {
        return workplaceList;
    }

    public void setWorkplaceList(List<WorkplaceList> workplaceList) {
        this.workplaceList = workplaceList;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
