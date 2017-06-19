package com.example.ana.aapp.Adapteri;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ana.aapp.Model.Auction;
import com.example.ana.aapp.Model.Bid;
import com.example.ana.aapp.R;

import java.util.List;

/**
 * Created by Ana on 6/5/2017.
 */

public class BidAdapter extends ArrayAdapter<Bid> {
        public BidAdapter(Context c, int resource, List<Bid> Bid) {
            super(c, resource, Bid);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View v = convertView;
            if(v == null){
                LayoutInflater l = LayoutInflater.from(getContext());
                v= l.inflate(R.layout.bid_item,null);

            }

            Bid b= getItem(position);
            TextView tvgetId = (TextView) v.findViewById(R.id.id);
            tvgetId.setText(Double.toString(b.getId()));

            TextView tvPrice = (TextView) v.findViewById(R.id.Price);
            tvPrice.setText(Double.toString(b.getPrice()));

            TextView dateTime = (TextView) v.findViewById(R.id.dateTime);
            dateTime.setText(b.getDateTime().toString());

            TextView Item = (TextView) v.findViewById(R.id.auctions);
            Item.setText(b.getAuction().toString());


            TextView tvUser = (TextView) v.findViewById(R.id.user);
            tvUser.setText(b.getUser().getName());


            return v;
        }
    }

