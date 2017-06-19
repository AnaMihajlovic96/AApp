package com.example.ana.aapp;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;

import com.example.ana.aapp.Adapteri.AuctionAdapter;
import com.example.ana.aapp.Adapteri.ItemAdapter;
import com.example.ana.aapp.Model.Auction;
import com.example.ana.aapp.Model.Bid;
import com.example.ana.aapp.Model.Item;
import com.example.ana.aapp.Model.User;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemsActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
        //@Override
        //public void onClick(View view) {
        //    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //             .setAction("Action", null).show();
        //   }
        // });


        final Button itemButton = (Button) findViewById(R.id.Item_button);
        itemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startItemActivity();


            }
       });

        ListView lv = (ListView) findViewById(R.id.ListV);
        List<Auction> auction= new ArrayList< Auction>();
        Item item01 = new Item(10, "imeItema", "opis/neki", "slika i td", false );
        User user01 = new User(10,"ime","mail", "pass", "slika", "adresa", "telefon");
        Auction auction01= new Auction(11, new Date(), 55, new Date(),item01,user01);
        Bid bid01= new Bid(1, 44, new Date(),auction01, user01);
        DHelper dHelper =new DHelper(this);
        RuntimeExceptionDao<Item, String> anak=dHelper.getItemRunDao();
        RuntimeExceptionDao<User, String> anau=dHelper.getUsersRunDao();
        RuntimeExceptionDao<Auction, String> anaa=dHelper.AuctionRuntimeDao();
        RuntimeExceptionDao<Bid, String> anab=dHelper.getBidRuntimeDAo();


        anak.create(item01);
        anau.create(user01);
        anaa.create(auction01);
        anab.create(bid01);


        List<Item> listaItem = anak.queryForAll();
        List<User> userItem=anau.queryForAll();
        List<Auction> auctionItem=anaa.queryForAll();
        List<Bid> bidAuction=anab.queryForAll();

        ItemAdapter A = new ItemAdapter(this,R.layout.item_list_view,(ArrayList<Item>)listaItem);
        lv.setAdapter(A);

        //listaItem.add(item01);
       //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, "Open navigation drawer", "close nav drawer");
        //drawer.setDrawerListener(toggle);
        //toggle.syncState();

                NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
                navigationView.setNavigationItemSelectedListener(this);
            }

            private void startItemActivity() {
                Intent i= new Intent(this,ItemActivity.class);
                startActivity(i);
            }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_gallery) {
            // Handle the camera action
        } else if (id == R.id.nav_camera) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void BtnItemOnClick(View view){
        Intent intent = new Intent(ItemsActivity.this, ItemActivity.class);
        startActivity(intent);
    }

    public void BtnOnClickSettings(View view){
        Intent intent = new Intent(ItemsActivity.this, SettingsActivity.class);
        startActivity(intent);
    }
}