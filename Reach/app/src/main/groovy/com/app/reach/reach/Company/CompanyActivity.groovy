package com.app.reach.reach.Company

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
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

public class CompanyActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,CompanyView {
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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        event = bus.getStickyEvent(SuccessfulLoginEvent.class)
        Log.d("Event",""+event)

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.main_drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy()

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        presenter.onOptionItemSelected(item)
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        presenter.onNavigationItemSelected(item)
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
