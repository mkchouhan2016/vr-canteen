package com.example.canteen;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.canteen.R;

public class custom extends ArrayAdapter {
    Activity c;
    String[] s1;
    Integer[] img1;
    public custom(Context context, String[] resource, Integer[] textViewResourceId) {
        super(context, R.layout.activity_main, resource);
        c = (Activity) context;
        s1 = resource;
        img1 = textViewResourceId;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater LF = c.getLayoutInflater();///layoutinflater is class which use for include xml file .
        convertView = LF.inflate(R.layout.single, null);
        ImageView im = convertView.findViewById(R.id.img1);
        TextView tv = convertView.findViewById(R.id.text1);
        im.setImageResource(img1[position]);
        tv.setText(s1[position]);
        return convertView;

    }
}
