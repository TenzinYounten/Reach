package com.app.reach.reach.Adapter
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.TextView
import com.app.reach.model.OrderlineListItem
import com.app.reach.reach.R

import java.text.DecimalFormat
/**
 * Created by tenzin on 28/3/16.
 */
public class ProductUserAdapter extends ArrayAdapter<List<OrderlineListItem>> {
    private LayoutInflater inflater;
    /*Realm realm*/
    private ArrayList<List<OrderlineListItem>> objects;

    public ProductUserAdapter(Context context, int textview, List<OrderlineListItem> objects) {
        super(context, textview, objects);
        inflater = LayoutInflater.from(context)
        this.objects = objects
        Log.d("Arraylist", "" + objects.dump())
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder()

        Log.d("convert view", "" + convertView)
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.product_list_item, null);
        }

        /* if (convertView == null) {
             convertView = LayoutInflater.from(getContext()).inflate(R.layout.product_list_item, parent, false);
         }*/

        Log.d("convert view", "" + convertView.dump())
        // Get the data item for this position
        // String[] products = new String[objects.size()]
        OrderlineListItem product = getItem(position);
        Log.d("product", "" + product)
        holder.productQuantity = convertView.findViewById(R.id.Quantity)

        convertView.setTag(holder);
        holder.position = position
        holder.productQuantity.setText("")

        holder.productQuantity.addTextChangedListener(new TextWatcher() {
            @Override
            void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            void afterTextChanged(Editable s) {
                if (s != "") {
                    /* realm.beginTransaction()
                     PurchasedOrderDB item = realm.createObject(PurchasedOrderDB.class)*/
                    product.quantity = s.toInteger()

                } else {
                    holder.productQuantity.setText(""+0)

                }
                Log.d("product name", "" + product.name)
                Log.d("product quantity", "" + product.quantity)
                Log.d("whole product", "" + product.dump())

                objects.each {
                    Log.d("objects", "" + it.dump())
                }
            }

        })

        objects.each {
            Log.d("objects2", "" + it.dump())
        }


        // Check if an existing view is being reused, otherwise inflate the view

        // Lookup view for data population
        TextView textviewProductMrp = (TextView) convertView.findViewById(R.id.textViewProductMrp);
        TextView textViewProductName = (TextView) convertView.findViewById(R.id.textViewProductName);
        EditText textviewQuantity = (EditText) convertView.findViewById(R.id.Quantity)
        // Populate the data into the template view using the data object

        textviewProductMrp.setText("" + (new DecimalFormat("##.##").format(product.getMrpPrice())));
        textViewProductName.setText(product.getName());
        textviewQuantity.setText(""+0)

        // Return the completed view to render on screen
        return convertView;

    }

    public  getOrderLineListItem() {
        return objects
    }

    private class ViewHolder {
        EditText productQuantity;
        int position
    }

}
