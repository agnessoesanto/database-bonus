package com.example.lat24mei22;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context c;
    ArrayList getId, getName, getPw;
    LayoutInflater inflater;

    public CustomAdapter(Context c, ArrayList getId, ArrayList getName, ArrayList getPw) {
        this.c = c;
        this.getId = getId;
        this.getName = getName;
        this.getPw = getPw;
        inflater = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return getId.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.mylv_element, null);
        TextView id = (TextView) view.findViewById(R.id.textView2);
        TextView name = (TextView) view.findViewById(R.id.textView3);
        TextView pwd = (TextView) view.findViewById(R.id.textView4);
        id.setText(String.valueOf(getId.get(i)));
        name.setText(String.valueOf(getName.get(i)));
        pwd.setText(String.valueOf(getPw.get(i)));
        return view;
    }
}
