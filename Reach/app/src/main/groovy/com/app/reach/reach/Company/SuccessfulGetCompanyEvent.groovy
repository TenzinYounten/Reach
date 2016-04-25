package com.app.reach.reach.Company

import com.app.reach.model.Company

/**
 * Created by tenzin on 17/3/16.
 */
public class SuccessfulGetCompanyEvent {
   List<Company> companyList

    SuccessfulGetCompanyEvent(List<Company> companyList) {
        this.companyList = companyList
    }

    List<Company> getCompanyList() {
        return companyList
    }

    void setCompanyList(List<Company> companyList) {
        this.companyList = companyList
    }
 /*   Object response
    Object getResponse() {
        return response
    }

    void setResponse(Object response) {
        this.response = response
    }


    SuccessfulGetCompanyEvent(Object response) {
        this.response = response
    }*/

}
