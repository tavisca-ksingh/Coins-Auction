package com.auction.pojo;

import java.io.Serializable;
import java.util.Objects;

public class Coin  implements Serializable {
    private  int id ;
    private int hashId = 0;
    private static int teamIdCounter = 101;

    private String country;
    private int denomination;
    private int yearOfMinting;
    private int currentValue;
    private String acquiredDate;


    public Coin(String country, int denomination, int yearOfMinting, int currentValue, String acquiredDate) {
        this.id = teamIdCounter++;
        this.country = country;
        this.denomination = denomination;
        this.yearOfMinting = yearOfMinting;
        this.currentValue = currentValue;
        this.acquiredDate =  acquiredDate;

    }

    public String getCountry() {
        return country;
    }

    public int getDenomination() {
        return denomination;
    }

    public int getYearOfMinting() {
        return yearOfMinting;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public String getAcquiredDate() {
        return acquiredDate;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coin coin = (Coin) o;
        return ( country == coin.country && coin.denomination == denomination &&
                yearOfMinting == coin.yearOfMinting && currentValue ==coin.currentValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hashId);
    }


    @Override
    public String toString() {
        return String.format("\n{ID: %-5d Country: %-8s Denomination: %-5d Year of Minting: %-7d Current Value: %-8d Acquired Date: %5s}",
                id, country, denomination, yearOfMinting, currentValue,acquiredDate);
    }

}
