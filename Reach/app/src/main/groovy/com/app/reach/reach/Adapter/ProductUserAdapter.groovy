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
    private Integer[] arrtemp;


    public ProductUserAdapter(Context context, int textview, ArrayList<OrderlineListItem> objects) {
        super(context, textview, objects);
        inflater = LayoutInflater.from(context)
        this.objects = objects
        arrtemp = new Integer[objects.size()]
        Log.d("Arraylist", "" + objects.dump())
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder
        if (convertView == null) {
            holder = new ViewHolder()
            Log.d("convert view", "" + convertView)
            convertView = inflater.inflate(R.layout.product_list_item, null);

            holder. productMrp = (TextView) convertView.findViewById(R.id.textViewProductMrp);
            holder.productName = (TextView) convertView.findViewById(R.id.textViewProductName);
            holder.productQuantity = (EditText) convertView.findViewById(R.id.Quantity)

            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }


        Log.d("convert view", "" + convertView.dump())
        OrderlineListItem orderlineListItems = getItem(position)

        holder.productQuantity.addTextChangedListener(new TextWatcher() {
            @Override
            void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            void afterTextChanged(Editable s) {
                if (s == null) {
                    /* realm.beginTransaction()
                     CallBackPurchasedOrder item = realm.createObject(CallBackPurchasedOrder.class)*/
                    orderlineListItems.quantity = 0
                } else {
                    orderlineListItems.quantity = s.toInteger()
                    arrtemp[holder.position] = s.toInteger()
                }

                Log.d("product name", "" + orderlineListItems.name)
                Log.d("product quantity", "" + orderlineListItems.quantity)
                Log.d("whole product", "" + orderlineListItems.dump())

            }
        })

        objects.each {
            Log.d("objects2", "" + it.dump())
        }
        holder.position = position
        // Check if an existing view is being reused, otherwise inflate the view
        // Lookup view for data population
        /**/
        if(arrtemp[position] != null)
        holder.productQuantity.setText(""+arrtemp[position])
        // Populate the data into the template view using the data object

        holder.productMrp.setText("" + (new DecimalFormat("##.##").format(orderlineListItems.getMrpPrice())));
        holder.productName.setText(orderlineListItems.getName());

        // Return the completed view to render on screen
        return convertView;

    }

    public getOrderLineListItem() {
        return objects
    }

    private class ViewHolder {
        EditText productQuantity;
        TextView productMrp;
        TextView productName;
        int position
    }
}
