package com.app.reach.reach.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.app.reach.model.Company;
import com.app.reach.reach.R;

import java.util.List;

/**
 * Created by tenzin on 23/3/16.
 */

    public class CompanyUserAdapter  extends ArrayAdapter<Company> {

        public CompanyUserAdapter(Context context, List<Company> objects) {
            super(context,0 , objects);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            Company company = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.company_list_item, parent, false);
            }
            // Lookup view for data population
            TextView textviewId = (TextView) convertView.findViewById(R.id.textViewId);
            TextView textviewCompanyCode = (TextView) convertView.findViewById(R.id.textViewCompanyCode);
            TextView textViewCompanyName = (TextView) convertView.findViewById(R.id.textViewCompanyName);
            TextView textviewActive = (TextView) convertView.findViewById(R.id.textViewActive);

            // Populate the data into the template view using the data object

            textviewId.setText("" + company.getId());
            textviewCompanyCode.setText(company.getCompanyCode());
            textViewCompanyName.setText(company.getCompanyName());
            textviewActive.setText("" + company.getActive());

            // Return the completed view to render on screen

            return convertView;

        }

    }
