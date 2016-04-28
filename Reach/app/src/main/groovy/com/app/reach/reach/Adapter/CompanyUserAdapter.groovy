package com.app.reach.reach.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.app.reach.model.CompanyDB.CompanyDB
import com.app.reach.reach.R
/**
 * Created by tenzin on 23/3/16.
 */

    public class CompanyUserAdapter  extends ArrayAdapter<CompanyDB> {

        public CompanyUserAdapter(Context context, List<CompanyDB> objects) {
            super(context,0 , objects);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            CompanyDB company = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.company_list_item, parent, false);
            }
            // Lookup view for data population
            TextView textViewCompanyName = (TextView) convertView.findViewById(R.id.textViewCompanyName);
            // Populate the data into the template view using the data object
            textViewCompanyName.setText(company.getCompanyName());
            // Return the completed view to render on screen
            return convertView;

        }

    }
