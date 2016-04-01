package com.app.reach.reach.Company

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import com.app.reach.model.Company
import com.app.reach.reach.ActivityUtility.ActivityUtil
import com.app.reach.reach.Adapter.CompanyUserAdapter
import com.app.reach.reach.CompanyProducts.ProductsActivity
import com.app.reach.reach.Login.SuccessfulLoginEvent
import com.app.reach.reach.R
import org.greenrobot.eventbus.EventBus

public class CompanyActivity extends AppCompatActivity implements CompanyView {
    CompanyPresenter presenter
    CompanyView view


    SuccessfulLoginEvent event
    private EventBus bus = EventBus.getDefault();
    ListView listView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        Context context = this.getApplicationContext()

        presenter = new CompanyPresenter(this, new CompanyService(),context);
        presenter.onCreate()

    }

    @Override
    def listCompanies(SuccessfulGetCompanyEvent event) {

        listView = findViewById(R.id.listViewCompanies)
        List<Company> company = event.companyList

        CompanyUserAdapter adapter = new CompanyUserAdapter(this, company)

        listView.setAdapter(adapter)
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    final int position, long id) {

                Company companyList = (Company) listView.getItemAtPosition(position)
                Log.d("Selected comapny company",""+companyList)
                Long companyId = (Long) companyList.id
                Log.d("companyId",""+companyId)

                Intent intent = new Intent(view.getContext(), ProductsActivity.class)
                intent.putExtra("companyId", companyId)
                presenter.onItemClick(intent)

            }
        });
    }

    @Override
    void showNoCompaniesRegisteredError(int i) {
        Toast.makeText(this, getString(i), Toast.LENGTH_LONG).show();
    }

    @Override
    def showNetworkFailiureMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();

    }

    @Override
    void startProductActivity(Intent intent) {
        new ActivityUtil(this).startProductActivity(intent)

    }
}
