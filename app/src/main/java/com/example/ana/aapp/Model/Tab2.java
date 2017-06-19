package com.example.ana.aapp.Model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ana.aapp.Adapteri.AuctionAdapter;
import com.example.ana.aapp.Adapteri.BidAdapter;
import com.example.ana.aapp.BidActivity;
import com.example.ana.aapp.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Ana on 6/5/2017.
 */

public class Tab2 extends Fragment {

    private static final int CODE_REQUEST = 13;
    private User u;
    List<Bid> listb;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab2, container, false);


        FloatingActionButton bidButton = (FloatingActionButton) rootView.findViewById(R.id.bidButton);
        bidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
              });



      //  FloatingActionButton bt = (FloatingActionButton) rootView.findViewById(R.id.cenaid);
        //bt.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View v) {
              //  start();
            //}
      //  });
        ListView lv = (ListView) rootView.findViewById(R.id.item02);
        List<Auction> auctions=new ArrayList<Auction>();
        Item item = new Item(1, "aukcija", "opis", "slika", false);

        u = new User(1,"ovo","01","ovo","ovo","ovo","ovo");

        Auction a2 = new Auction(2, new Date(), 3, new Date(), new Item(2,"aukcija2", "opis2", "slika2", false), u);
        Bid b1= new Bid (1, 2, new Date(), a2, u);
        Bid b2= new Bid (2, 3, new Date(), a2, u);
        listb = new ArrayList<Bid>();
         listb = new ArrayList<Bid>() ;
        listb.add(b1);
        listb.add(b2);
        BidAdapter bAd = new BidAdapter(getActivity(),R.layout.bid_item,listb);

        lv.setAdapter(bAd);
        return rootView;
    }

    private void start() {
        Intent i = new Intent(getActivity(), BidActivity.class);
        startActivityForResult(i, CODE_REQUEST);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(CODE_REQUEST==requestCode) {
            if (Activity.RESULT_OK==resultCode){
                final int price = Integer.parseInt(data.getStringExtra("anakraljica"));
                Bid bidb =new Bid(01,price,new Date(),null,u);
                listb.add(bidb);
                boolean isBigger = true;
                for(int i = 0; i < listb.size();i++)
                {
                    if(listb.get(i).getPrice()> price) {
                        isBigger = false;
                        break;
                    }
                }
                if(isBigger) {
                    Toast.makeText(getActivity(), "Najbolja ponuda", Toast.LENGTH_LONG).show();
                }

            }

        }else {
            super.onActivityResult(requestCode,resultCode,data);
        }
    }
}

