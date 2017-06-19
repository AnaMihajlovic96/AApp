package com.example.ana.aapp;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;
import android.widget.TextView;

import com.example.ana.aapp.Adapteri.AuctionAdapter;
import com.example.ana.aapp.Model.Auction;
import com.example.ana.aapp.Model.Item;
import com.example.ana.aapp.Model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tab1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab1, container, false);

        ListView lv = (ListView) rootView.findViewById(R.id.item01);

        List<Auction> auctions=new ArrayList<Auction>();
        Item item = new Item(1, "aukcija", "opis", "slika", false);

        User u = new User(1,"ovo","01","ovo","ovo","ovo","ovo");
        Auction a1 = new Auction(1, new Date(), 2, new Date(), new Item(1, "aukcija", "opis", "slika", false), u);
        Auction a2 = new Auction(2, new Date(), 3, new Date(), new Item(2,"aukcija2", "opis2", "slika2", false), u);
        Auction a3= new Auction(3, new Date(), 4, new Date(), new Item(3, "aukcija3", "opis3", "slika3", false), u);
        List<Auction> a = new ArrayList<Auction>() ;
        a.add(a1);
        a.add(a2);
        a.add(a3);
        AuctionAdapter aA = new AuctionAdapter(getActivity(),R.layout.auction_item_list,a);
        lv.setAdapter(aA);
        return rootView;
    }
}