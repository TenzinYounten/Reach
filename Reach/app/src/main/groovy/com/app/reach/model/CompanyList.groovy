package com.app.reach.model
/**
 * Created by tenzin on 22/3/16.
 */
public class CompanyList {
    List<Company> companyList

    CompanyList(List<Company> companyList) {
        this.companyList = companyList
    }

    List<Company> getCompanyList() {
        return companyList
    }

    void setCompanyList(List<Company> companyList) {
        this.companyList = companyList
    }
}
