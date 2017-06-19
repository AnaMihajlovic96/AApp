package com.example.ana.aapp.Adapteri;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ana.aapp.Model.Auction;
import com.example.ana.aapp.Model.Item;
import com.example.ana.aapp.R;

import java.util.List;

/**
 * Created by Ana on 5/29/2017.
 */

public class ItemAdapter extends ArrayAdapter<Item>{
    public ItemAdapter(Context c, int resource, List<Item> items) { super(c,resource, items); }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater li = LayoutInflater.from(getContext());
            v = li.inflate(R.layout.item_list_view, null);


        }
        Item i = getItem(position);
        TextView nameI = (TextView) v.findViewById(R.id.nameI);
        nameI.setText(i.getName().toString());


        TextView descriptionI = (TextView) v.findViewById(R.id.descriptionI);
        descriptionI.setText(i.getDescription().toString());


        TextView pictureI = (TextView) v.findViewById(R.id.pictureI);
        pictureI.setText(i.getPicture().toString());



   return v;


    }

}
