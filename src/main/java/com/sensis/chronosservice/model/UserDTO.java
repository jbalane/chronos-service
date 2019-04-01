package com.sensis.chronosservice.model;

import java.util.Date;

public class UserDTO {

    private Long id;
    private String enterpriseId;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private Boolean isApprover;
    private Date projectStartDate;
    private Date projectEndDate;

    private String username;
    private String password;

    public UserDTO() {
    }

    public UserDTO(Long id, String enterpriseId, String firstName, String lastName, String email, String contactNumber, Boolean isApprover, Date projectStartDate, Date projectEndDate, String username, String password) {
        this.id = id;
        this.enterpriseId = enterpriseId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactNumber = contactNumber;
        this.isApprover = isApprover;
        this.projectStartDate = projectStartDate;
        this.projectEndDate = projectEndDate;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Boolean getIsApprover() {
        return isApprover;
    }

    public void setIsApprover(Boolean approver) {
        isApprover = approver;
    }

    public Date getProjectStartDate() {
        return projectStartDate;
    }

    public void setProjectStartDate(Date projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public Date getProjectEndDate() {
        return projectEndDate;
    }

    public void setProjectEndDate(Date projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
