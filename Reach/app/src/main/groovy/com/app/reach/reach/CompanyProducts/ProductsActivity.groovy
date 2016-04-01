package com.app.reach.reach.CompanyProducts

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import com.app.reach.model.Product
import com.app.reach.reach.ActivityUtility.ActivityUtil
import com.app.reach.reach.Adapter.ProductUserAdapter
import com.app.reach.reach.ProductDetails.ProductDetailsActivity
import com.app.reach.reach.R

public class ProductsActivity extends AppCompatActivity implements ProductsView {
    ProductsPresenter presenter
    ProductsView view
    ListView listView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        Long companyId = getIntent().getLongExtra("companyId",0)
        Context context = this.getApplicationContext()
        presenter = new ProductsPresenter(this, new ProductsService());

        Log.d("pro","")
        Log.d("Productid",""+companyId)
        presenter.onCreate(context,companyId)

    }

    @Override
    def listProducts(SuccessfulGetProductsEvent event) {
        Long companyId = getIntent().getLongExtra("companyId",0)
        listView = findViewById(R.id.listViewProduct)
        List<Product> product = event.productList
        Log.d("Product",""+product.productCode)

        ProductUserAdapter adapter = new ProductUserAdapter(this, product)

        listView.setAdapter(adapter)
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    final int position, long id) {

                Product productList = (Product) listView.getItemAtPosition(position)
                Long productId = (Long) productList.id

                Intent intent = new Intent(view.getContext(), ProductDetailsActivity.class)
                intent.putExtra("productId", productId)
                intent.putExtra("companyId", companyId)

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
}
