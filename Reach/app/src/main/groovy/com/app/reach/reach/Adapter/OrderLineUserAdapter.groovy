package com.app.reach.reach.Adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.app.reach.model.OrderlineListItem
import com.app.reach.reach.R

import java.text.DecimalFormat

/**
 * Created by tenzin on 13/4/16.
 */
public class OrderLineUserAdapter extends ArrayAdapter<OrderlineListItem> {


    OrderLineUserAdapter(Context context, int resource, ArrayList<OrderlineListItem> objects) {
        super(context, resource, objects)
    }

    @Override
    View getView(int position, View convertView, ViewGroup parent) {
        OrderlineListItem orderlineListItems= getItem(position)

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.orderline_list_item, parent, false);
        }

        TextView productName = convertView.findViewById(R.id.textViewProductName) as TextView
        TextView productMrp = convertView.findViewById(R.id.textViewProductMrp) as TextView
        TextView productQuantity = convertView.findViewById(R.id.productQuantity) as TextView
        TextView productTotal = convertView.findViewById(R.id.productTotal) as TextView

        String mrpPrice = ""+new DecimalFormat("##.##").format(orderlineListItems.mrpPrice)
        String total = ""+(orderlineListItems.quantity * mrpPrice.toInteger())

        productName.setText(""+orderlineListItems.name)
        productMrp.setText("" +mrpPrice);
        productQuantity.setText(""+orderlineListItems.quantity);
        productTotal.setText(total)

        return convertView
    }
}
