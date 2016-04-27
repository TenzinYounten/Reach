package com.app.reach.model.CompanyDB;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/**
 * Created by tenzin on 26/4/16.
 */
@RealmClass
public class CompanyListDB extends RealmObject {
    RealmList<CompanyDB> companyListDB;

    public RealmList<CompanyDB> getCompanyListDB() {
        return companyListDB;
    }

    public void setCompanyListDB(RealmList<CompanyDB> companyListDB) {
        this.companyListDB = companyListDB;
    }
}
