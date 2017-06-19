package com.example.ana.aapp.Model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ana on 5/29/2017.
 */
    @DatabaseTable(tableName = "item")
    public class Item implements Serializable {
    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField
    public String name;
    @DatabaseField
    public String description;
    @DatabaseField
    public String picture;
    @DatabaseField
    public boolean sold;
    @ForeignCollectionField(eager = true)
    public ForeignCollection<Auction> auctions;

    public Item() {
    }
    public Item(long id, String name, String description, String picture, boolean sold) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.picture = picture;
        this.sold = sold;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean isSold() {

        return sold;
    }



    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public ForeignCollection<Auction> getAuctions() {
        return auctions;
    }

    public void setAuctions(ForeignCollection<Auction> auctions) {
        this.auctions = auctions;
    }
}
