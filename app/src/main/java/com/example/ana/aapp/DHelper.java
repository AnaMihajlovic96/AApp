package com.example.ana.aapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.ana.aapp.Model.Auction;
import com.example.ana.aapp.Model.Bid;
import com.example.ana.aapp.Model.Item;
import com.example.ana.aapp.Model.User;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by Ana on 6/9/2017.
 */

public class DHelper extends OrmLiteSqliteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME ="Ana";
    private static final int DATABASE_VERSION=13;

    private RuntimeExceptionDao<Auction, String> AuctionRuntimeDao=null;
    private RuntimeExceptionDao<User, String> usersRunDao=null;
    private RuntimeExceptionDao<Item, String> itemRunDao=null;
    private RuntimeExceptionDao<Bid, String> bidRuntimeDAo=null;

    public RuntimeExceptionDao<Auction, String> AuctionRuntimeDao() {
        if (AuctionRuntimeDao ==null){
            AuctionRuntimeDao= getRuntimeExceptionDao(Auction.class);
        }
        return AuctionRuntimeDao;
    }

    public RuntimeExceptionDao<User, String> getUsersRunDao() {
        if (usersRunDao ==null) {
            usersRunDao = getRuntimeExceptionDao(User.class);
        }
        return usersRunDao;
    }

    public RuntimeExceptionDao<Item, String> getItemRunDao() {
            if (itemRunDao ==null){
                itemRunDao= getRuntimeExceptionDao(Item.class);
        }
        return itemRunDao;
    }

    public RuntimeExceptionDao<Bid, String> getBidRuntimeDAo() {
        if (bidRuntimeDAo ==null) {
            bidRuntimeDAo = getRuntimeExceptionDao(Bid.class);
        }
        return bidRuntimeDAo;
    }



    public DHelper(Context c){
        super(c,DATABASE_NAME,null,DATABASE_VERSION);
        this.context = c;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {

        try {
            TableUtils.createTable(connectionSource, Auction.class);
            TableUtils.createTable(connectionSource, User.class);
            TableUtils.createTable(connectionSource, Item.class);
            TableUtils.createTable(connectionSource, Bid.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {

        try {
            TableUtils.dropTable(connectionSource, Bid.class, true);
            TableUtils.dropTable(connectionSource, Auction.class, true);
            TableUtils.dropTable(connectionSource, User.class, true);
            TableUtils.dropTable(connectionSource, Item.class, true);
            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
