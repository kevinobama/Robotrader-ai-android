package com.example.kevingates.robotrader_ai_android;

/**
 * Created by kevingates on 11/28/17.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomCryptoAdapter extends ArrayAdapter<robotsModel> {
    public CustomCryptoAdapter(Context context, ArrayList<robotsModel> robotsModels) {
        super(context, 0, robotsModels);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.robot_listview_layout, parent, false);
        }

        // Get the data item for this position
        robotsModel robotsModel1 = getItem(position);

        TextView nameText = (TextView) convertView.findViewById(R.id.name);
//        TextView country = (TextView) convertView.findViewById(R.id.country);
//        TextView buy = (TextView) convertView.findViewById(R.id.buy);
//        TextView sell = (TextView) convertView.findViewById(R.id.sell);

        nameText.setText(robotsModel1.getName());
//        country.setText(exchange.getCountry());
//        buy.setText(exchange.getBuy());
//        sell.setText(exchange.getSell());

        return convertView;
    }
}
