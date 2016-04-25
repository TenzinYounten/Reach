package com.app.reach.reach.CompanyProducts

import android.content.Context
import android.content.Intent
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
import android.widget.AdapterView
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import com.app.reach.model.OrderLineList
import com.app.reach.model.OrderlineListItem
import com.app.reach.reach.ActivityUtility.ActivityUtil
import com.app.reach.reach.Adapter.ProductUserAdapter
import com.app.reach.reach.OrderLineListItem.OrderLineListItemActivity
import com.app.reach.reach.ProductDetails.ProductDetailsActivity
import com.app.reach.reach.R

public class ProductsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, ProductsView {
    ProductsPresenter presenter
    ProductsView view
    ListView listView
    FloatingActionButton fab
    ArrayList<OrderlineListItem> lineItems

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        Long companyId = getIntent().getLongExtra("companyId", 0)
        Context context = this.getApplicationContext()
        presenter = new ProductsPresenter(this, new ProductsService());

        Log.d("pro", "")
        Log.d("Productid", "" + companyId)
        presenter.onCreate(context, companyId)
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        /* fab.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

             }
         });*/

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
    def listProducts(SuccessfulGetProductsEvent event) {
        Long companyId = getIntent().getLongExtra("companyId", 0)
        EditText productQuantity = findViewById(R.id.Quantity)
        listView = findViewById(R.id.listViewProduct)
        Log.d("event.product",""+event.productList)
        this.lineItems = event.productList
        Log.d("Lineitems",""+lineItems.dump())
        List<OrderlineListItem> product = event.productList
        Log.d("OrderlineListItem", "" + product.productCode)

        ProductUserAdapter adapter = new ProductUserAdapter(this, R.layout.product_list_item, product)

        listView.setAdapter(adapter)

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    final int position, long id) {
                productQuantity.setFocusable(false)
                def quantity = productQuantity.getText()

                OrderlineListItem productList = (OrderlineListItem) listView.getItemAtPosition(position)
                Long productId = (Long) productList.id

                Intent intent = new Intent(view.getContext(), ProductDetailsActivity.class)
                intent.putExtra("productId", productId)
                intent.putExtra("companyId", companyId)
                intent.putExtra("productQuantity", quantity)

                presenter.onItemClick(intent)
            }
        });
    }

    @Override
    void showNoProductsRegisteredError(int p) {
        Toast.makeText(this, getString(p), Toast.LENGTH_LONG).show();

    }

    @Override
    def showNetworkFailiureMessage(String p) {
        Toast.makeText(this, p, Toast.LENGTH_LONG).show();
    }

    @Override
    void startProductActivity(Intent p) {
        new ActivityUtil(this).startProductDetailsActivity(p)
    }

    @Override
    void viewOrderItems() {
        Log.d("lineitems", "" + lineItems)
        /*  ArrayList<List<OrderlineListItem>> objects;
         *//* Snackbar.make(view, "Replace", Snackbar.LENGTH_LONG)
                  .setAction("Action", null).show();*//*
          objects = ProductUserAdapter.getOrderLineListItem()
          objects.each {
              Log.d("objects2", "" + it.dump())
          }*/
        Intent intent = new Intent(this, OrderLineListItemActivity.class);

        OrderLineList orderList = new OrderLineList()

        ArrayList<OrderlineListItem> orderlineListItems = lineItems

        Log.d("List",""+orderlineListItems.name)
        Bundle b = new Bundle();
        b.putParcelableArrayList("OrderLine", orderlineListItems);
        Log.d("class",""+b.class)
        intent.putExtras(b);

        orderList.setOrderlineListItems(b.getParcelableArrayList("OrderLine"))
        Log.d("Bundle",""+b.getParcelableArrayList("OrderLine"))
        Log.d("OrderList", "" + orderList.orderlineListItems.name.dump())
        presenter.onProceedClick(intent)
    }

    @Override
    void startOrderLineListActivity(Intent intent) {
        new ActivityUtil(this).startOrderLineListItemsActivity(intent)
    }

    public void viewOrderItems(View view) {
        presenter.viewOrderItems()
    }
}
