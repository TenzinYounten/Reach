package com.app.reach.reach.ProductDetails
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import android.widget.TextView
import com.app.reach.model.Product
import com.app.reach.reach.R

import java.text.DecimalFormat

public class ProductDetailsActivity extends AppCompatActivity implements ProductDetailsView {

    ProductDetailsPresenter detailsPresenter
    ProductDetailsService detailsService
    ListView listView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Long companyId = getIntent().getLongExtra("companyId", 0)
        Long productId = getIntent().getLongExtra("productId", 0)
        setContentView(R.layout.activity_product_details);

        Context context = this.getApplicationContext()

        detailsPresenter = new ProductDetailsPresenter(this, new ProductDetailsService())
        detailsPresenter.onCreate(context, companyId, productId)
    }

    @Override
    def listProduct(SuccessfulGetProductDetailEvent event) {
        Product product= event.product

        TextView textviewProductName = (TextView) findViewById(R.id.product_Name);
        TextView textViewProductMrpPrice = (TextView) findViewById(R.id.product_MrpPrice);
        TextView textviewProductDescription = (TextView) findViewById(R.id.product_description);
        TextView textviewSellingPriceWithoutTax = (TextView) findViewById(R.id.product_sellingPriceWithoutTax);
        TextView textviewSellingPriceWithTax = (TextView) findViewById(R.id.product_sellingPriceWithTax);

        // Populate the data into the template view using the data object

        textviewProductName.setText( product.getName());
        textViewProductMrpPrice.setText(""+(new DecimalFormat("##.##").format(product.getMrpPrice())))
        textviewProductDescription.setText(product.getProductDescription());
        textviewSellingPriceWithoutTax.setText(""+(new DecimalFormat("##.##").format(product.getSellingPriceWithoutTax())));
        textviewSellingPriceWithTax.setText(""+(new DecimalFormat("##.##").format(product.getSellingPriceWithTax())));

    }

    @Override
    def showNetworkFailiureMessage(String s) {
        return null
    }

    @Override
    void showNoProductsRegisteredError(int i) {

    }
}