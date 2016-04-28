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
public class ProductUserAdapter extends ArrayAdapter<OrderlineListItem> {
    private LayoutInflater inflater;
    /*Realm realm*/
    private ArrayList<OrderlineListItem> objects;

    public ProductUserAdapter(Context context, int textview, ArrayList<OrderlineListItem> objects) {
        super(context, textview, objects);
        inflater = LayoutInflater.from(context)
        this.objects = objects
        Log.d("Arraylist", "" + objects.dump())
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder()
        OrderlineListItem orderlineListItems = getItem(position)

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
        /*       OrderlineListItem product = getItem(position);
               Log.d("product", "" + product)*/
        holder.productQuantity = convertView.findViewById(R.id.Quantity) as EditText

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
                if (s.size() == 0) {
                    /* realm.beginTransaction()
                     PurchasedOrderDB item = realm.createObject(PurchasedOrderDB.class)*/ 111
                    orderlineListItems.quantity = 0
                } else {
                    orderlineListItems.quantity = s.toInteger()
                }
                Log.d("product name", "" + orderlineListItems.name)
                Log.d("product quantity", "" + orderlineListItems.quantity)
                Log.d("whole product", "" + orderlineListItems.dump())

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

        textviewProductMrp.setText("" + (new DecimalFormat("##.##").format(orderlineListItems.getMrpPrice())));
        textViewProductName.setText(orderlineListItems.getName());
        textviewQuantity.setText("" + 0)

        // Return the completed view to render on screen
        return convertView;

    }

    public getOrderLineListItem() {
        return objects
    }

    private class ViewHolder {
        EditText productQuantity;
        int position
    }

}
