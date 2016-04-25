package com.app.reach.reach.ProductDetails
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import com.app.reach.model.OrderlineListItem
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
        int quantity = getIntent().getIntExtra("productQuantity", 0)
        OrderlineListItem product= event.product

        TextView textviewProductName = (TextView) findViewById(R.id.product_Name);
        TextView textViewProductMrpPrice = (TextView) findViewById(R.id.product_MrpPrice);
        TextView textviewProductDescription = (TextView) findViewById(R.id.product_description);
        EditText product_Quantity = (EditText) findViewById(R.id.editText_quantity)


        // Populate the data into the template view using the data object

        textviewProductName.setText(Html.fromHtml("<b>"+"OrderlineListItem Name : "+"</b>"+product.getName()));
        textViewProductMrpPrice.setText(Html.fromHtml("<b>"+"OrderlineListItem Mrp Price : "+"</b>"+(new DecimalFormat("##.##").format(product.getMrpPrice()))))
        textviewProductDescription.setText(Html.fromHtml("<b>"+"OrderlineListItem Description : "+"</b>"+product.getProductDescription()));
        product_Quantity.setText(""+product_Quantity)
    }

    @Override
    def showNetworkFailiureMessage(String s) {
        return null
    }

    @Override
    void showNoProductsRegisteredError(int i) {

    }
}