package com.app.reach.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by tenzin on 22/3/16.
 */
public class CompanyList implements Parcelable{
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

    @Override
    int describeContents() {
        return 0
    }

    @Override
    void writeToParcel(Parcel dest, int flags) {

    }
}
