package com.app.reach.model;

/**
 * Created by tenzin on 17/3/16.
 */
public class Company {
    Long id
    String companyCode
    String companyName
    Boolean active


    Company(Long id, String companyCode, String companyName, Boolean active) {
        this.id = id
        this.companyCode = companyCode
        this.companyName = companyName
        this.active = active
    }

    void setId(Long id) {
        this.id = id
    }

    void setCompanyCode(String companyCode) {
        this.companyCode = companyCode
    }

    void setCompanyName(String companyName) {
        this.companyName = companyName
    }

    Long getId() {

        return id
    }

    Boolean getActive() {
        return active
    }

    void setActive(Boolean active) {
        this.active = active
    }

    String getCompanyCode() {
        return companyCode
    }

    String getCompanyName() {
        return companyName
    }

}
