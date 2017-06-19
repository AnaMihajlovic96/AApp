package com.example.ana.aapp.Adapteri;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextClock;
import android.widget.TextView;

import com.example.ana.aapp.Model.Auction;
import com.example.ana.aapp.R;

import java.util.List;

/**
 * Created by Ana on 5/29/2017.
 */

public class AuctionAdapter extends ArrayAdapter<Auction>{
    public AuctionAdapter(Context c, int resource, List <Auction> ListAuction) {
        super(c, resource, ListAuction);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if(v == null){
            LayoutInflater l = LayoutInflater.from(getContext());
            v= l.inflate(R.layout.auction_item_list,null);

        }

        Auction a = getItem(position);
        TextView tvStartDate = (TextView) v.findViewById(R.id.FirstDate);
        tvStartDate.setText(a.getFirstDate().toString());

        TextView tvStartPrice = (TextView) v.findViewById(R.id.startPrice);
        tvStartPrice.setText(Double.toString(a.getStartPrice()));

        TextView lastDate = (TextView) v.findViewById(R.id.lastDate);
        lastDate.setText(a.getLastDate().toString());

        TextView Item = (TextView) v.findViewById(R.id.ItemA);
        Item.setText(a.getItem().toString());


        TextView tvUser = (TextView) v.findViewById(R.id.userA);
        tvUser.setText(a.getUser().getName());


        return v;
    }
}