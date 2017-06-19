package com.example.ana.aapp.Model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Ana on 5/29/2017.
 */
@DatabaseTable(tableName = "auction")
public class Auction implements Serializable
{
    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField
    private Date firstDate;
    @DatabaseField
    private double startPrice;
    @DatabaseField
    private Date lastDate;
    @DatabaseField(foreign = true, dataType= DataType.SERIALIZABLE)
    private Item item;
    @DatabaseField(foreign = true, dataType= DataType.SERIALIZABLE)
    private User user;
    @ForeignCollectionField(eager = true)
   public ForeignCollection<Bid> bids;

    public Auction() {

    }
    public Auction(long id, Date firstDate,double startPrice , Date lastDate, Item item, User user) {
        this.id = id;
        this.firstDate = firstDate;
        this.startPrice = startPrice;
        this.lastDate = lastDate;
        this.item = item;
        this.user = user;



    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

    public double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(double startPrice) {
        this.startPrice = startPrice;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
