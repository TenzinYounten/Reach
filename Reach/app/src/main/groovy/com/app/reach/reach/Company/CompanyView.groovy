package com.app.reach.reach.Company

import android.content.Intent;

/**
 * Created by tenzin on 17/3/16.
 */
public interface CompanyView {

    def listCompanies(SuccessfulGetCompanyEvent event)

    void showNoCompaniesRegisteredError(int i)

    def showNetworkFailiureMessage(String s)

    void startProductActivity(Intent intent)
}
