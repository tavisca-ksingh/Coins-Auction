package com.auction.pojo;

import com.auction.pojo.Coin;

import java.io.Serializable;
import java.util.Date;

public class BidableCoins implements Serializable {
    private int id;
    private String name;
    private Coin coin;
    private Date deadLine;

    public BidableCoins(String name, Coin coin, Date deadLine) {
        this.id = coin.getId();
        this.name = name;
        this.coin = coin;
        this.deadLine = deadLine;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coin getCoin() {
        return coin;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    @Override
    public String toString() {
        return String.format("\n{Name: %-5s Coins: %-8s  Date: %5s}",
                name, coin, deadLine);
    }

}
