package com.app.reach.reach.Company

import com.app.reach.model.CompanyDB.CompanyDB
import io.realm.RealmList
/**
 * Created by tenzin on 17/3/16.
 */
public class SuccessfulGetCompanyEvent {
   RealmList<CompanyDB> companyList

    SuccessfulGetCompanyEvent(RealmList<CompanyDB> companyList) {
        this.companyList = companyList
    }

    RealmList<CompanyDB> getCompanyList() {
        return companyList
    }

    void setCompanyList(RealmList<CompanyDB> companyList) {
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
