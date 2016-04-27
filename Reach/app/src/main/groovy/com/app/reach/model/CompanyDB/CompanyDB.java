package com.app.reach.model.CompanyDB;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/**
 * Created by tenzin on 26/4/16.
 */
@RealmClass
public class CompanyDB extends RealmObject {
    Long id;
    String companyCode;
    String companyName;
    Boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
