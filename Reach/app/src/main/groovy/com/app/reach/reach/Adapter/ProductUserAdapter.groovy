package com.app.reach.reach.Adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.app.reach.model.Product
import com.app.reach.reach.R
/**
 * Created by tenzin on 28/3/16.
 */
public class ProductUserAdapter  extends ArrayAdapter<List<Product>> {


        public ProductUserAdapter(Context context, List<Product> objects) {
            super(context, 0, objects);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            Product product = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.product_list_item, parent, false);
            }
            // Lookup view for data population
            TextView textviewProductMrp = (TextView) convertView.findViewById(R.id.textViewProductMrp);
            TextView textViewProductName = (TextView) convertView.findViewById(R.id.textViewProductName);
            TextView textviewProductDescription = (TextView) convertView.findViewById(R.id.textViewProductDescription);

            // Populate the data into the template view using the data object

            textviewProductMrp.setText(""+product.getMrpPrice());
            textViewProductName.setText(product.getName());
            textviewProductDescription.setText(product.getProductDescription());

            // Return the completed view to render on screen

            return convertView;

        }

}
