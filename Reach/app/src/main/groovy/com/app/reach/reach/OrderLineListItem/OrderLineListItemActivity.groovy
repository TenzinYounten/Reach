package com.app.reach.reach.OrderLineListItem

import android.content.Context
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ListView
import com.app.reach.model.OrderDB.OrderLine
import com.app.reach.model.OrderDB.PurchasedOrderDb
import com.app.reach.model.OrderlineListItem
import com.app.reach.reach.ActivityUtility.ActivityUtil
import com.app.reach.reach.Adapter.OrderLineUserAdapter
import com.app.reach.reach.NetworkConnectivity.NetworkChangeReceiver
import com.app.reach.reach.R
import io.realm.RealmResults

public class OrderLineListItemActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,OrderLineListItemActivityView{

    OrderLineListItemPresenter activityPresenter;
    OrderLineListItemActivityView activityView;
    ListView listView
    NetworkChangeReceiver receiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_line_list_item);

        activityPresenter = new OrderLineListItemPresenter(this, new OrderLineListItemService())
     /*   Bundle b = this.getIntent().getExtras();
        ArrayList<OrderlineListItem> orderlineListItems = activityPresenter.getOrderLineListItem(b)
        activityPresenter.onCreate(orderlineListItems)*/
        activityPresenter.listItems()

  /*     *//* Intent i = this.getIntent();
        ArrayList<OrderlineListItem> orderL*//*ist = i.getParcelableArrayListExtra("OrderLine");*/
     /*   Bundle b = this.getIntent().getExtras();

        ArrayList<OrderlineListItem> orderList = b.getParcelableArrayList("OrderLine");
        Log.d("ArrayListin",""+orderList.dump())
        OrderLineList orderLineList = new OrderLineList()
        orderLineList.setOrderlineListItems(b.getParcelableArrayList("OrderLine"))


        Log.d("Ordeline",""+orderLineList.getOrderlineListItems().name)
        Log.d("Ordeline",""+orderLineList.getOrderlineListItems().companyId)*/

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

       /* fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

      /*  IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        receiver = new NetworkChangeReceiver()
        registerReceiver(receiver, intentFilter)*/
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
        /*unregisterReceiver()*/
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
        activityPresenter.onOptionItemSelected(item)
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        activityPresenter.onNavigationItemSelected(item)
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    Object listItems() {
        Bundle b = this.getIntent().getExtras();

        listView = findViewById(R.id.listViewOrderLine)
        Log.d("class",""+b.class)
        ArrayList<OrderlineListItem> orderlineListItems = null
        orderlineListItems = b.getParcelableArrayList("OrderLine")
        orderlineListItems = activityPresenter.getQuantifiedOrders(orderlineListItems)

        double totalSum = activityPresenter.calculateTotal(orderlineListItems.mrpPrice as ArrayList<Double>,orderlineListItems.quantity)
        Log.d("totalSum",""+totalSum)
        Log.d("totalSum",""+totalSum)
        Log.d("class",""+orderlineListItems.dump())

        OrderLineUserAdapter adapter = new OrderLineUserAdapter(this, R.layout.orderline_list_item, orderlineListItems )
        listView.setAdapter(adapter)
    }

    @Override
    void startCompanyActivity() {
        new ActivityUtil(this).startCompanyActivity()
    }

    public void onSubmitOrder (View view ) {
        Context context = this.getApplicationContext()
        Bundle b = this.getIntent().getExtras();
        ArrayList<OrderLine> orderlineListItems = null
        orderlineListItems = b.getParcelableArrayList("OrderLine")
        orderlineListItems = activityPresenter.getQuantifiedOrderLine(orderlineListItems)
        Log.d("orderline classss",""+orderlineListItems.class)
        double totalSum = activityPresenter.calculateTotal(orderlineListItems.mrpPrice,orderlineListItems.quantity)
        Log.d("Activity total sum",""+totalSum)
        Log.d("Activity list items",""+orderlineListItems.companyId)
        RealmResults<PurchasedOrderDb> dbRealmResults = activityPresenter.onSubmitOrder(orderlineListItems,context,totalSum)
        //RealmResults<PurchasedOrderDb> purchasedOrderLineDB = activityPresenter.getStoredPurchaseOrderLine()
        Log.d("ActivityRealmResult",""+dbRealmResults.dump())

        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        receiver = new NetworkChangeReceiver()
        registerReceiver(receiver, intentFilter)
        activityPresenter.startCompanyActivity()

        //activityPresenter.onSubmitGetPurchaseOrderNumber(context,dbRealmResults)
    }


}
