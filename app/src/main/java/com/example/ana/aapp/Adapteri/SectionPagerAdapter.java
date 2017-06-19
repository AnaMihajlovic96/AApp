package com.example.ana.aapp.Adapteri;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ana.aapp.Model.Auction;
import com.example.ana.aapp.Model.Bid;
import com.example.ana.aapp.Model.Tab2;
import com.example.ana.aapp.Tab1;

/**
 * Created by Ana on 6/5/2017.
 */

public class SectionPagerAdapter extends FragmentPagerAdapter {

    public SectionPagerAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Tab1 lFragmentTest = new Tab1();
                return lFragmentTest;
            case 1:
                Tab2 licitationFragment = new Tab2();
                return licitationFragment;


        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;


    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Tab1";
            case 1:
                return "Tab2";

        }
        return null;
    }
}
